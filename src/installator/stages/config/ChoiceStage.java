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
    String text;

    public Integer doInConsole() throws IOException {
        System.out.println(text);

        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        String s = b.readLine();
        b.close();
        return null;
    }
    /**
     * Создание стадии единичного выбора из списка с панелью
     * {@link ChoicePanel по умолчанию}.
     *
     * @param text текст вопроса
     * @param itemsText массив строк для пунктов списка
     */
    public ChoiceStage(String text, String[] itemsText) {
        setPanel(new ChoicePanel(index, text, itemsText));
    }

}
