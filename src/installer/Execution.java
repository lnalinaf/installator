package installer;

import installer.stages.execution.ExecutionManager;
import installer.stages.execution.ExecStage;

import java.io.IOException;
import java.util.List;

/**
 * Класс исполнителя установщика, который содержит в себе всю информацию об установке. Содержит список всех возможных
 * {@link ExecStage}. Для редактирования списка исполняемых {@link ExecStage} используется метод
 * {@link ExecStage#setExecutionManager(ExecutionManager)}
 *
 * @see ExecutionManager
 *
 * @author cfif11
 */
public class Execution {

	private List<ExecStage> execStages;
	private Parameters parameters;

	/**
	 * Создает класс исполнителя установщика.
	 * @param execStages список {@link ExecStage}
	 */
	public Execution(List<ExecStage> execStages) {
		this.execStages = execStages;
	}

	int run(ExecutionConfigStage executionConfigStage) {
		int index = 0;
		int countStages = 0;
		for (ExecStage execStage : execStages) {
			execStage.managerHandle(parameters);
			if(execStage.isUseful())
				countStages++;
		}

		int temp = 100 / countStages;
		int valueStage = (temp * countStages < 100) ? temp + 1 : temp;

		for (ExecStage execStage : execStages) {
			if (execStage.isUseful()) {
				try {
					index = execStage.run();
					if (index == -1)
						break;
					executionConfigStage.changeState(valueStage);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return index;
	}

	void setParameters(Parameters parameters) {
		this.parameters = parameters;
	}

}
