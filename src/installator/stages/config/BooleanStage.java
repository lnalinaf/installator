package installator.stages.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Стадия предназначенная для логического выбора. Основная полезная
 * информация при работе с пользователем: true or false
 *
 * @author alina
 */
public class BooleanStage extends ConfigStage<Boolean> {

	private String question;

	public Boolean doInConsole() {
		System.out.println(question);
		System.out.println("Наберите yes или y, если вы согласны");
		String s;
		try (BufferedReader b = new BufferedReader(new InputStreamReader(System.in))) {
			s = b.readLine();
		} catch (IOException e) {
			System.out.println("Ошибка: " + e.getMessage() + "Попробуйте ввести еще раз:");
			return null;
		}
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
