package installator;

import installator.stages.config.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс, который содержит в себе всю информацию о конфигурации установки
 * (взаимодействие с пользователем) и сохраняет всю информацию в объект
 * {@link Parameters}. Класс инициализируется с помощью списка {@link ConfigStage}
 * Переход от одной стадии к другой по умолчанию осуществляется по порядку.
 */
public class Configuration {

	public static boolean gui;

	private List<ConfigStage> list;
	private final Parameters parameters = new Parameters();
	private TestIter form;

	/**
	 * Создать Конфигурацию
	 *
	 * @param stages список стадий
	 * @param isGUI  использовать GUI режим?
	 */
	Configuration(List<ConfigStage> stages, boolean isGUI) {
		this.list = stages;
		list.add(new ExecutionStage("Установка выполняется. Пожалуйста подождите."));
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

/*	@Override
	public Iterator<ConfigStage> iterator() {
		return new Iterator<ConfigStage>() {
			Iterator<ConfigStage> temp = list.iterator();

			@Override
			public boolean hasNext() {
				return temp.hasNext();
			}

			@Override
			public ConfigStage next() {
				return null;
			}

			@Override
			public void remove() {

			}
		};
	}    */

	void run() {
		if (gui) {
			form = new TestIter();
			for (int i = 0; i < list.size(); i++) {
				ConfigStage<?> cur = list.get(i);
				if (cur.isUsable()) {
					form.getContentPane().add(cur.getPanel().getGUI());
					form.setVisible(true);
					cur.run();

					if(cur.getData() == null) {
						list.add(i + 1, new ExitStage("Установка была отменена. " +
								"Для завршения работы инсталлятора нажмити кнопку \"Выход\"."));
						form.getContentPane().remove(cur.getPanel().getGUI());
						continue;
					} else if(i == list.size() - 1) {
						list.add(i + 1, new ExitStage("Программный продукт был успешно установлен. " +
								"Для выхода из инсталлятора нажмите \"Выход\"."));
						form.getContentPane().remove(cur.getPanel().getGUI());
						continue;
					}
					parameters.addParameter(i, cur.getData());
					form.getContentPane().remove(cur.getPanel().getGUI());
				}
			}
		} else {
			int index = 0;
			try (BufferedReader b = new BufferedReader(new InputStreamReader(System.in))) {
				for (int i = 0; i < list.size(); i++) {
					ConfigStage<?> cur = list.get(i);
					if (cur.isUsable()) {
						index = cur.getIndex();
						cur.run(b);
						if(cur.getData() == null) {
							list.add(i + 1, new ExitStage("Инствллятор будет закрыт. " +
									"Нажмите \"Ввод\" для продолжения..."));
							System.out.println("!!!");
							continue;
						}
						parameters.addParameter(i, cur.getData());
					}
				}
			} catch (IOException e) {
				System.out.println("На стадии № " + index + " произошла ошибка: " + e.getMessage());
			}
		}
	}

	Parameters getParameters() {
		return parameters;
	}
}
