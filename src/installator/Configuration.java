package installator;

import installator.stages.config.*;

import java.util.ArrayList;

/**
 * Класс, который содержит в себе всю информацию о конфигурации установки
 * (взаимодействие с пользователем) и сохраняет всю информацию в объект
 * {@link Parameters}. Класс инициализируется с помощью списка {@link ConfigStage}
 * Переход от одной стадии к другой по умолчанию осуществляется по порядку.
 */
public class Configuration{

	public static boolean gui;

	private ArrayList<ConfigStage> list;
	private final Parameters parameters = new Parameters();
	private TestIter form;

	/**
	 * Создать Конфигурацию
	 *
	 * @param stages список стадий
	 * @param isGUI  использовать GUI режим?
	 */
	Configuration(ArrayList<ConfigStage> stages, boolean isGUI) {
		this.list = stages;
		gui = isGUI;
		run();
	}

	/**
	 * Получить список стадий
	 *
	 * @return список стадий
	 */
	public ArrayList<ConfigStage> getListStages() {
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

	private void run() {
		if (gui)
			form = new TestIter();
		for (ConfigStage cur : list) {
			if (cur.isUsable()) {
				if (gui) {
					form.getContentPane().add(cur.getPanel().getGUI());
					form.setVisible(true);
				}
				cur.run();
				parameters.addParameter(cur.getIndex(), cur.getData());
				if (gui)
					form.getContentPane().remove(cur.getPanel().getGUI());
			}
		}
	}
}
