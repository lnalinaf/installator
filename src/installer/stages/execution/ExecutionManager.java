package installer.stages.execution;

import installer.Parameters;

/**
 * Класс для обработки результатов работы {@link installer.Configuration}. Данный менеджер используется для удаления
 * или конфигурауции {@link ExecStage} из {@link installer.Execution}.
 * По умолчанию менеджер не установлен.
 *
 * @see ExecStage#setExecutionManager(ExecutionManager)
 *
 * @author cfif11
 */
public interface ExecutionManager {

	/**
	 * Управляет {@link ExecStage}, которые содержатся в {@link installer.Execution}
	 * @param execStage Стадия выполнения
	 */
	public void managedExecStages(ExecStage execStage, Parameters parameters);
}
