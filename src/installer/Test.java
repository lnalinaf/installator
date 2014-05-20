package installer;

import installer.stages.config.*;
import installer.stages.execution.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cfif11
 */
public class Test {

	static Configuration config;
	static Execution execution;
	static Installer installer;
	private static final List<ConfigStage> listConf = new ArrayList<>();
	private static final List<ExecStage> listExec = new ArrayList<>();

	public static void main(String[] args) {
		listConf.add(new StartStage("Вас приветствует установщик программы Хосэ."));
		listConf.add(new LicenseStage("I agree", "BLABLABLABLABLABLA\nBLABLABLA"));
		//listConf.add(new ChoiceStage("question", new String[]{"default", "two"}));
		//listConf.add(new MultichoiceStage("question", new String[]{"default", "one", "two"}));
		//listConf.add(new BooleanStage("Do?", "Yes"));

		final ConfigStage pathStage = new PathStage("Where", "C:/windows");
		listConf.add(pathStage);
		listConf.add(new StringStage("Что делать?", "забить болт").setConfigManager( new ConfigManager() {
			@Override
			public <T> void managedConfigStages(ConfigStage<T> configStage, Parameters parameters) {
				configStage.setUsable(false);
			}
		}));

		listExec.add(new DelayStage());
		listExec.add(new DelayStage());
		listExec.add(new DelayStage().setExecutionManager(new ExecutionManager() {
			@Override
			public void managedExecStages(ExecStage execution, Parameters parameters) {
				System.out.println(parameters.getParameter(2));
			}
		}));
		listExec.add(new UnzipStage(null, null).setExecutionManager(new ExecutionManager() {
			@Override
			public void managedExecStages(ExecStage execStage, Parameters parameters) {
				execStage.setUseful(false);
				((UnzipStage) execStage).setIn(UnzipStage.class.getResource("").toString().
						replace("jar:file:", "").replace("!/installer.stages.execution", ""));
				((UnzipStage) execStage).setOut((String)parameters.getParameter(pathStage.getIndex()));
			}
		}));


		config = new Configuration(listConf, false);
		execution = new Execution(listExec);
		installer = new Installer(config, execution);
		installer.startInstall();
	}
}
