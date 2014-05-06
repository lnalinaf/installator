package installator.stages.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Стадия предназначенная для выбора одного пункта из списка. Основная полезная
 * информация при работе с пользователем: номер пункта из списка
 *
 * @author cfif11
 */
public class ChoiceStage extends ConfigStage<Integer> {

	private String text;
	private String[] itemsText;

	public Integer doInConsole() {
		System.out.println(text);
		for (int i = 0; i < itemsText.length; i++)
			System.out.println((i + 1) + ") " + itemsText[i]);

		String s;
		try (BufferedReader b = new BufferedReader(new InputStreamReader(System.in))) {
			s = b.readLine();
		} catch (IOException e) {
			System.out.println("Ошибка: " + e.getMessage() + ". Попробуйте ввести еще раз.");
			return null;
		}

		try {
			return Integer.valueOf(s);
		} catch (NumberFormatException e) {
			System.out.println("Нужно ввести номер выбранного ответа. Попробуйте ввести еще раз.");
			return null;
		}
	}

	/**
	 * Создание стадии единичного выбора из списка с панелью
	 * {@link ChoicePanel по умолчанию}.
	 *
	 * @param text      текст вопроса
	 * @param itemsText массив строк для пунктов списка
	 */
	public ChoiceStage(String text, String[] itemsText) {
		this.text = text;
		this.itemsText = itemsText;
		setPanel(new ChoicePanel(index, text, itemsText));
	}

}
