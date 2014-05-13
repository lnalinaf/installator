package installator;


import installator.stages.config.ExecutionStage;

public class Installer {

	private Configuration configuration;
	protected Execution execution;

	public Installer(Configuration configuration, Execution execution) {
		this.configuration = configuration;
		this.execution = execution;
		((ExecutionStage)configuration.getListStages().
				get(configuration.getListStages().size() - 1)).setExecution(execution);
	}

	public void startInstall() {
		configuration.run();
	}
}
