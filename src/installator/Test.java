package installator;

import installator.stages.config.*;
import installator.stages.execution.DelayStage;
import installator.stages.execution.ExecStage;

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
	/*	listConf.add(new ChoiceStage("question", new String[]{"default", "two"}));
		listConf.add(new MultichoiceStage("question", new String[]{"default", "one", "two"}));
		listConf.add(new BooleanStage("Do?", "Yes"));
		listConf.add(new PathStage("Where", "C:/windows"));
		listConf.add(new StringStage("Что делать?", "забить болт"));     */

		listExec.add(new DelayStage());
		listExec.add(new DelayStage());
		listExec.add(new DelayStage());


		config = new Configuration(listConf, false);
		execution = new Execution(listExec);
		installer = new Installer(config, execution);
		installer.startInstall();
	}
}
