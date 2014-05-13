package installator.stages.config;

import installator.Configuration;
import installator.Execution;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author cfif11
 */
public class ExecutionStage extends ConfigStage<Boolean> {

	private String text;
	private volatile int progress;
	private Execution execution;


	public ExecutionStage(String text) {
		this.text = text;
		setPanel(new ExecutionPanel(index, text, this));
	}

	public void setExecution(Execution execution) {
		this.execution = execution;
		((ExecutionPanel)getPanel()).setExecution(execution);
	}

	@Override
	public Boolean doInConsole(BufferedReader output) throws IOException {
		System.out.println(text);
		System.out.println("Установлено " + progress + "%");
		execution.run(this);

		System.out.println("Установка успешно завершена. Для продолжения нажмите \"Ввод\"");

		output.readLine();
		System.exit(0);
		return true;
	}

	public void changeState(int value) {
		int current = progress + value;
		progress = current <= 100 ? current : 100;
		if(Configuration.gui) {
			((ExecutionPanel)getPanel()).changeState(progress);
		} else {
			System.out.println("Установлено " + progress + "%");
		}
	}
}
