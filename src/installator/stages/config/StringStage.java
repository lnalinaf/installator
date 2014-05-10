/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package installator.stages.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Стадия предназначенная для символьного ответа на вопрос. Основная полезная
 * информация при работе с пользователем: строка.
 *
 * @author alina
 */
public class StringStage extends ConfigStage<String> {

	private String question;
	private String defaultAnswer;

	public String doInConsole(BufferedReader b) throws IOException {
		System.out.println(question);
		System.out.println("Например: " + defaultAnswer);
		String s = b.readLine();
		if(exitConsole(s))
			return null;
		return s;
	}

	/**
	 * Создание стадии ответа на вопрос с панелью
	 * {@link StringPanel по умолчанию}
	 *
	 * @param question      вопрос
	 * @param defaultAnswer ответ по умолчанию
	 */
	public StringStage(String question, String defaultAnswer) {
		this.question = question;
		this.defaultAnswer = defaultAnswer;
		setPanel(new StringPanel(index, question, defaultAnswer));
	}
}
