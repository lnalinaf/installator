package installator;

import installator.stages.config.ExecutionStage;
import installator.stages.execution.ExecStage;

import java.io.IOException;
import java.util.List;

public class Execution {

	private List<ExecStage> execStages;

	private ConfigureExecution configureExecution;

	public Execution(List<ExecStage> execStages) {
		this.execStages = execStages;
	}

	public void setConfigureExecution(ConfigureExecution configureExecution) {
		this.configureExecution = configureExecution;
	}

	public int run(ExecutionStage executionConfigStage) {
		int index = 0;
		if (configureExecution != null)
			execStages = configureExecution.configuredStages(this);
		System.out.println("start + size = " + execStages.size());
		int temp = 100 / execStages.size();
		int valueStage = (temp * execStages.size() < 100) ? temp + 1 : temp;
		for (ExecStage execStage : execStages) {
			try {
				System.out.println("!");
				index = execStage.run();
				if(index == -1) {
					break;
				}
				executionConfigStage.changeState(valueStage);
				System.out.println("?");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return index;
	}

}
