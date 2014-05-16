package installator.stages.config;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Класс для создания стадии с Лицензионным приглашением. Если пользовател его не принял, установка дальше недоступна
 * или завершается(в зависимости от режима работы с инсталлятором)
 *
 * @author alina
 */
public class LicenseStage extends ConfigStage<Boolean> {
	String text;
	String question;

	public Boolean doInConsole(BufferedReader b) throws IOException {
		System.out.println(text);
		System.out.println(question);
		System.out.println("Наберите yes или y, если вы согласны");
		String s = b.readLine();
		if(exitConsole(s))
			return null;
		return s.equalsIgnoreCase("y") || s.equalsIgnoreCase("yes") ? true : null;
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
