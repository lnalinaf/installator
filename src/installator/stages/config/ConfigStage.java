package installator.stages.config;

import installator.Configuration;

import java.io.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Общий класс для стадии конфигурации. Из таких стадий должен состоять объект
 * {@link Configuration}.
 *
 * @param <T> Тип данных, которые возвращает стадия после своего завершения.
 * @author cfif11
 */
public abstract class ConfigStage<T> {


	private static final AtomicInteger STAGE_NUMERATOR = new AtomicInteger();

	/**
	 * Индефикатор
	 */
	protected int index;

	/**
	 * Полезная информация от пользователя по завершению работы стадии
	 */
	protected T data;

	private boolean usable = true;
	private ConfigManager configManager;
	private StagePanel<T> panel;

	/**
	 * Создание стадии конфигурации
	 */
	public ConfigStage() {
		this.index = STAGE_NUMERATOR.getAndIncrement();
	}

	/**
	 * Возвращает панель взаимодействия с пользователем
	 *
	 * @return панель взаимодействия с пользователем
	 */
	public StagePanel<T> getPanel() {
		return panel;
	}

	/**
	 * Возвращает данные взаимодействия с пользователем.
	 *
	 * @return данные взаимодействия с пользователем.
	 */
	public T getData() {
		return data;
	}

	/**
	 * Устанавливаем видимость(возможность использования) стадии.
	 *
	 * @param usable {@code true} если стадия используется.
	 */
	public void setUsable(boolean usable) {
		this.usable = usable;
	}

	/**
	 * Возвращает, используется ли стадия в конфигурации на текущий момент
	 * @return {@code true}, если стадия используется, {@code false} в обратном случае
	 */
	public boolean isUsable() {
		return usable;
	}

	/**
	 * Возвращает индефикатор стадии
	 * @return индефикатор стадии
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * Запускает выполение стадии, если включен режим GUI
	 */
	public void run() {
		data = panel.doInGUI();
	}

	/**
	 * Запускает выполение стадии, если режим GUI выключен
	 */
	public void run(BufferedReader reader) throws IOException{
		data = doInConsole(reader);
	}

	/**
	 * Устанавливает {@link ConfigManager} для стадии. По умолчанию он не установлен
	 * @param configManager менеджер обработки результатов
	 */
	public void setConfigManager(ConfigManager configManager) {
		this.configManager = configManager;
	}

	/**
	 * Возвращает {@link ConfigManager} для стадии. По умолчанию {@code null}
	 * @return  configManager менеджер обработки результатов
	 */
	public ConfigManager getConfigManager() {
		return configManager;
	}

	/**
	 * Описывает последовательность действий стадии в консольном режиме.
	 * @param output поток выводв
	 * @return результат работы стадии
	 * @throws IOException ошибка потоков ввода/вывода
	 */
	public abstract T doInConsole(BufferedReader output) throws IOException;

	/**
	 * Обрабатывает команды на выход из установщика в режиме консоли
	 * @param command данные, введенные пользователем
	 * @return {@code true}, если пользователь ввел "quit" или "q"
	 */
	protected boolean exitConsole(String command) {
		return command.equalsIgnoreCase("quit") || command.equalsIgnoreCase("q");
	}

	/**
	 * Устанавливает графическую панель для стадии.
	 * @param panel {@link StagePanel}
	 */
	protected void setPanel(StagePanel<T> panel) {
		this.panel = panel;
	}
}
