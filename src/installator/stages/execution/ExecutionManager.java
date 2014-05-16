package installator.stages.execution;

import installator.Execution;

import java.util.List;

/**
 * Класс для обработки результатов работы {@link installator.Configuration}. Данный менеджер используется для удаления
 * или перестановки дальнейших {@link installator.stages.execution.ExecStage} из {@link installator.Execution}.
 * По умолчанию менеджер не установлен.
 *
 * @see installator.Execution#setExecutionManager(ExecutionManager)
 *
 * @author cfif11
 */
public interface ExecutionManager {

	/**
	 * Управляет {@link installator.stages.execution.ExecStage}, которые содержатся в {@link installator.Execution}
	 * @param execution Выполнение
	 */
	public List<ExecStage> managedExecStages(Execution execution);
}
