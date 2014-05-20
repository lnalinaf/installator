package installer.stages.execution;

import installer.Parameters;

import java.io.IOException;

/**
 * Стадия выполения некоторого действия установки
 */
public abstract class ExecStage {

	private boolean useful = true;
	private ExecutionManager manager;

	/**
	 * Выполнение действия стадии
	 * @return результат завершения(успешно или нет)
	 * @throws IOException
	 */
	public abstract int run() throws IOException;

	/**
	 * Используется ли стадия
	 * @return {@code true}, если используется, {@code false} в обратном случае
	 */
	public boolean isUseful() {
		return useful;
	}


	/**
	 * Устанавливает для стадии, будет ли она использоваться или нет.
	 * @param useful используется ли стадия
	 */
	public void setUseful(boolean useful) {
		this.useful = useful;
	}

	/**
	 * Устанавливает {@link ExecutionManager} для данной стадии
	 * @param manager менеджер
	 * @return стадию с установленным менеджером
	 */
	public ExecStage setExecutionManager(ExecutionManager manager) {
		this.manager = manager;
		return this;
	}

	/**
	 * Применение менеджера к стадии, если он установлен
	 * @param parameters контейнер информации при работе с пользователем
	 */
	public void managerHandle(Parameters parameters) {
		if(manager != null)
			manager.managedExecStages(this, parameters);
	}


}
