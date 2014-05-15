package installator;

import installator.stages.config.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Класс, который содержит в себе всю информацию о конфигурации установки
 * (взаимодействие с пользователем) и сохраняет всю информацию в объект
 * {@link Parameters}. Класс инициализируется с помощью списка {@link ConfigStage}
 * Переход от одной стадии к другой по умолчанию осуществляется по порядку.
 */
public class Configuration {

	/**
	 * Статическая переменная, которая показывает, в каком режиме будет работать установщик. Графическом или текстовом.
	 */
	public static boolean gui;

	private static final String TEXT_TO_CANCEL_GUI = "Установка была отменена. " +
			"Для завршения работы инсталлятора нажмити кнопку \"Выход\".";
	private static final String TEXT_TO_CANCEL_CONS = "Инствллятор будет закрыт. " +
			"Нажмите \"Ввод\" для продолжения...";
	private static final String TEXT_TO_SUCCESSFUL = "Программный продукт был успешно установлен. " +
			"Для выхода из инсталлятора нажмите \"Выход\".";
	private static final String TEXT_FOR_EXEC_CONFIG_STAGE = "Установка выполняется. Пожалуйста подождите.";

	private List<ConfigStage> list;
	private final Parameters parameters = new Parameters();
	private TestIter form;

	/**
	 * Создает новую Конфигурацию
	 *
	 * @param stages список стадий
	 * @param isGUI  использовать GUI режим?
	 */
	Configuration(List<ConfigStage> stages, boolean isGUI) {
		this.list = stages;
		list.add(new ExecutionConfigStage(TEXT_FOR_EXEC_CONFIG_STAGE));
		gui = isGUI;
	}

	/**
	 * Получить список стадий
	 *
	 * @return список стадий
	 */
	public List<ConfigStage> getListStages() {
		return list;
	}

	void run() {
		if (gui) {
			runGui();
		} else {
			runConsole();
		}
	}

	private void runConsole() {
		int index = 0;
		try (BufferedReader b = new BufferedReader(new InputStreamReader(System.in))) {
			for (int i = 0; i < list.size(); i++) {
				ConfigStage<?> cur = list.get(i);
				if (cur.isUsable()) {
					index = cur.getIndex();
					cur.run(b);

					if(cur.getData() == null)
						list.add(i + 1, new ExitStage(TEXT_TO_CANCEL_CONS));
					finishedStage(i, cur);
				}
			}
		} catch (IOException e) {
			System.out.println("На стадии № " + index + " произошла ошибка: " + e.getMessage());
		}
	}

	private void runGui() {
		form = new TestIter();
		for (int i = 0; i < list.size(); i++) {
			ConfigStage<?> cur = list.get(i);
			if (cur.isUsable()) {
				form.getContentPane().add(cur.getPanel().getGUI());
				form.setVisible(true);
				cur.run();

				if(cur.getData() == null) {
					list.add(i + 1, new ExitStage(TEXT_TO_CANCEL_GUI));
				} else if(i == list.size() - 1) {
					list.add(i + 1, new ExitStage(TEXT_TO_SUCCESSFUL));
				}
				finishedStage(i, cur);
			}
		}
	}

	private void finishedStage(int i, ConfigStage<?> cur) {
		if(gui)
			form.getContentPane().remove(cur.getPanel().getGUI());
		if(cur.getConfigManager() != null)
			cur.getConfigManager().managedConfigStages(this, cur.getData());
		parameters.addParameter(i, cur.getData());
	}

	Parameters getParameters() {
		return parameters;
	}
}
