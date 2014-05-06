package installator.stages.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LicenseStage extends ConfigStage<Boolean> {
	String text;
	String question;

	public Boolean doInConsole() {
		System.out.println(text);
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
	 * Создание стадии принятия лицензии с панелью
	 * {@link LicensePanel по умолчанию
	 *
	 * @param index    индефикатор
	 * @param name     имя
	 * @param text     текст лицензионного соглашения
	 * @param question вопрос "на принятие лицензии"
	 */
	public LicenseStage(String text, String question) {
		this.text = text;
		this.question = question;
		setPanel(new LicensePanel(index, text, question));
	}

}
