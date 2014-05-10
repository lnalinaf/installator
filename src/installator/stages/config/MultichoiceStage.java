package installator.stages.config;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Стадия предназначенная для множественного выбора из списка. Основная полезная
 * информация при работе с пользователем: массив выбранных пунктов из списка
 *
 * @author cfif11
 */
public class MultichoiceStage extends ConfigStage<Integer[]> {

	private String text;
	private String[] itemsText;

	/**
	 * Создание стадии множественного выбора из списка с панелью
	 * {@link MultichoicePanel по умолчанию}.
	 *
	 * @param text      текст вопроса
	 * @param itemsText массив строк для пунктов списка
	 */
	public MultichoiceStage(String text, String[] itemsText) {
		this.text = text;
		this.itemsText = itemsText;
		setPanel(new MultichoicePanel(index, text, itemsText));
	}

	@Override
	public Integer[] doInConsole(BufferedReader b) throws IOException {
		System.out.println(text);
		for (int i = 0; i < itemsText.length; i++)
			System.out.println((i + 1) + ") " + itemsText[i]);

		while (true) {
			String s = b.readLine();
			if (exitConsole(s))
				return null;
		String[] temp = s.split(",");
		Integer[] result = new Integer[temp.length];
			try {
				for (int i = 0; i < temp.length; i++)
					result[i] = Integer.valueOf(temp[i]);
				return result;
			} catch (NumberFormatException e) {
				System.out.println("Нужно ввести номера выбранных ответов через запятую или \"quit\" для выхода из " +
						"установки. Попробуйте еще раз.");
			}
		}
	}
}
