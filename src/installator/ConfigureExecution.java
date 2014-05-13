package installator;

import installator.Execution;
import installator.stages.execution.ExecStage;

import java.util.List;

/**
 * @author cfif11
 */
public interface ConfigureExecution {

	public List<ExecStage> configuredStages(Execution execution);
}
