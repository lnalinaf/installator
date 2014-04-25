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

        BufferedReader b = new BufferedReader(new InputStreamReader());
        String s = b.readLine();
        if(s.equalsIgnoreCase("y")||s.equalsIgnoreCase("yes")){
            return true;
        }else{
            return false;
        }
        b.close();
    }
    /**
     * Создание стадии единичного выбора из списка с панелью
     * {@link ChoicePanelNew по умолчанию}.
     *
     * @param text текст вопроса
     * @param itemsText массив строк для пунктов списка
     */
    public ChoiceStage(String text, String[] itemsText) {
        setPanel(new ChoicePanelNew(index, text, itemsText));
    }
}
