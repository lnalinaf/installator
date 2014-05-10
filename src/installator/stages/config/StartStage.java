package installator.stages.config;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by cfif11 on 06.05.14.
 */
public class StartStage extends ConfigStage<Boolean>{

	private String text;

	public StartStage(String text) {
		this.text = text;
		setPanel(new StartPanel(index, text));
	}

	@Override
	public Boolean doInConsole(BufferedReader output) throws IOException {
		System.out.println(text);
		System.out.println("Для продолжения установки, введите \"y\" или \"yes\" ввод.");
		String s = output.readLine();
		if(exitConsole(s))
			return null;
		return s.equalsIgnoreCase("y") || s.equalsIgnoreCase("yes") ? true : null;
	}
}
