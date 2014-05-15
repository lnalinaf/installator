package installator.stages.execution;

import installator.Execution;

import java.util.List;

/**
 * @author cfif11
 */
public interface ExecutionManager {

	public List<ExecStage> managedExecStages(Execution execution);
}
