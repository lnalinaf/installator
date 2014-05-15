package installator;


/**
 * Основной класс библиотеки. Создает объект {@code Installer} с помощью {@link installator.Configuration} и
 * {@link installator.Execution}
 */
public class Installer {

	private Configuration configuration;

	/**
	 * Создает инсталлятор
	 * @param configuration конфигурация инсталлятора
	 * @param execution //todo: что?
	 */
	public Installer(Configuration configuration, Execution execution) {
		this.configuration = configuration;
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
