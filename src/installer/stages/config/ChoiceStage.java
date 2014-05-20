package installer.stages.config;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Стадия предназначенная для выбора одного пункта из списка. Основная полезная
 * информация при работе с пользователем: номер пункта из списка
 *
 * @author cfif11
 */
public class ChoiceStage extends ConfigStage<Integer> {

	private String text;
	private String[] itemsText;

	public Integer doInConsole(BufferedReader b) throws IOException {
		System.out.println(text);
		for (int i = 0; i < itemsText.length; i++)
			System.out.println((i + 1) + ") " + itemsText[i]);


		while (true) {
			String s = b.readLine();
			if (exitConsole(s))
				return null;
			try {
				return Integer.valueOf(s);
			} catch (NumberFormatException e) {
				System.out.println("Нужно ввести номер выбранного ответа или \"quit\" для выхода из установки. " +
						"Попробуйте еще раз.");
			}
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
