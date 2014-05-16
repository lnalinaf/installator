package installator.stages.config;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Стадия для завершения работы инсталлятора.(Установку прервали или она завершилась)
 *  @author cfif11
 */
public class ExitStage extends ConfigStage<Void> {

	private String text;

	public ExitStage(String text) {
		this.text = text;
		setPanel(new ExitPanel(index, text));
	}

	@Override
	public Void doInConsole(BufferedReader output) throws IOException {
		System.out.println(text);
		output.readLine();
		System.exit(0);
		return null;
	}
}
