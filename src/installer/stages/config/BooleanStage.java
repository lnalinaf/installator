package installer.stages.config;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Стадия предназначенная для логического выбора. Основная полезная
 * информация при работе с пользователем: true or false
 *
 * @author alina
 */
public class BooleanStage extends ConfigStage<Boolean> {

	private String question;

	public Boolean doInConsole(BufferedReader b) throws IOException {
		System.out.println(question);
		System.out.println("Наберите yes или y, если вы согласны");

		String s = b.readLine();
		if(exitConsole(s))
			return null;
		return s.equalsIgnoreCase("y") || s.equalsIgnoreCase("yes");
	}

	/**
	 * Создание стадии логического выбора с панелью по умолчанию
	 * {@link BooleanPanel по умолчанию}.
	 *
	 * @param question текст вопроса
	 * @param answer   текст ответа
	 */
	public BooleanStage(String question, String answer) {
		this.question = question;
		setPanel(new BooleanPanel(index, question, answer));
	}

}
