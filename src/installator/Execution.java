package installator;

import installator.stages.execution.ExecutionManager;
import installator.stages.execution.ExecStage;

import java.io.IOException;
import java.util.List;

/**
 * Класс исполнителя установщика, который содержит в себе всю информацию об установке. Содержит список всех возможных
 * {@link ExecStage}. Для редактирования списка исполняемых {@link ExecStage} используется метод
 * {@link #setExecutionManager(ExecutionManager)}
 *
 * @see installator.stages.execution.ExecutionManager
 *
 * @author cfif11
 */
public class Execution {

	private List<ExecStage> execStages;
	private ExecutionManager executionManager;

	/**
	 * Создает класс исполнителя установщика.
	 * @param execStages список {@link ExecStage}
	 */
	public Execution(List<ExecStage> execStages) {
		this.execStages = execStages;
	}

	/**
	 * Устанавливаем {@link ExecutionManager} для исполнителя установщика.
	 * @param executionManager
	 */
	public void setExecutionManager(ExecutionManager executionManager) {
		this.executionManager = executionManager;
	}

	int run(ExecutionConfigStage executionConfigStage) {
		int index = 0;
		if (executionManager != null)
			execStages = executionManager.managedExecStages(this);

		int temp = 100 / execStages.size();
		int valueStage = (temp * execStages.size() < 100) ? temp + 1 : temp;

		for (ExecStage execStage : execStages) {
			try {
				index = execStage.run();
				if(index == -1) {
					break;
				}
				executionConfigStage.changeState(valueStage);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return index;
	}

}
