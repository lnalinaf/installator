package installer;


/**
 * Основной класс библиотеки. Создает объект {@code Installer} с помощью {@link installer.Configuration} и
 * {@link installer.Execution}
 */
public class Installer {

	private Configuration configuration;
	//private static boolean gui;


	/*public void main(String[] args) {

	}  */

	/**
	 * Создает инсталлятор
	 * @param configuration конфигурация инсталлятора
	 * @param execution //todo: что?
	 */
	public Installer(Configuration configuration, Execution execution) {
		this.configuration = configuration;
		execution.setParameters(configuration.getParameters());
		((ExecutionConfigStage)configuration.getListStages().
				get(configuration.getListStages().size() - 1)).setExecution(execution);
	}

	/**
	 * Запускает установку.
	 */
	public void startInstall() {
		configuration.run();
	}


}
