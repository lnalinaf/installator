package installator.stages.config;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by cfif11 on 06.05.14.
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
