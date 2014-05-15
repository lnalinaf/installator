package installator;

import installator.stages.config.ConfigStage;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

/**
 * @author cfif11
 */
class ExecutionConfigStage extends ConfigStage<Boolean> {

	public static final String TEXT_FOR_SUCCESSFUL_INSTALL =
			"Установка успешно завершена. Для продолжения нажмите \"Ввод\"";
	private String text;
	private volatile int progress;
	private Execution execution;

	@Override
	public Boolean doInConsole(BufferedReader output) throws IOException {
		System.out.println(text);
		System.out.println("Установлено " + progress + "%");
		int index = execution.run(this);

		if(index == 0)
			System.out.println(TEXT_FOR_SUCCESSFUL_INSTALL);
		output.readLine();
		System.exit(0);
		return true;
	}

	ExecutionConfigStage(String text) {
		this.text = text;
		setPanel(new ExecutionConfigPanel(index, text, this));
	}

	void setExecution(Execution execution) {
		this.execution = execution;
		((ExecutionConfigPanel)getPanel()).setExecution(execution);
	}

	void changeState(int value) {
		int current = progress + value;
		progress = current <= 100 ? current : 100;
		if(Configuration.gui) {
			((ExecutionConfigPanel)getPanel()).changeState(progress);
		} else {
			System.out.println("Установлено " + progress + "%");
		}
	}
}
