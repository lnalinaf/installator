package installator.stages.config;

import installator.Configuration;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Общий класс для стадии конфигурации. Из таких стадий должен состоять объект
 * {@link Configuration}. Стадия содержит основные поля "Имя", "Индефикатор"
 *
 * @param <T> Тип данных, которые возвращает стадия после своего завершения.
 * @author cfif11
 */
public abstract class ConfigStage<T> {

	/**
	 * Индефикатор
	 */
	protected int index;
	protected T data;
	protected boolean usable = true;

	class Lock {

	}
	private final Lock lock = new Lock();

	private static final AtomicInteger STAGE_NUMERATOR = new AtomicInteger();
	private StagePanel<T> panel;

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

	public boolean isUsable() {
		return usable;
	}

	public int getIndex() {
		return index;
	}

	public void run() {
		if (!Configuration.gui) {
				while(data == null)                   {
					data = doInConsole();
					System.out.println("in: data=" + data);
				}
			System.out.println("after: data=" + data);
		} else {
			data = panel.doInGUI();
		}
	}

	public abstract T doInConsole();

	protected void setPanel(StagePanel<T> panel) {
		this.panel = panel;
	}
}
