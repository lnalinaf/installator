/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package installator.stages.config;

/**
 * Стадия предназначенная для символьного ответа на вопрос. Основная полезная
 * информация при работе с пользователем: строка.
 *
 * @author alina
 */
public class StringStage extends ConfigStage<String> {

    /**
     * Создание стадии ответа на вопрос с панелью 
     * {@link StringPanel по умолчанию}
     *
     * @param question вопрос
     * @param defaultAnswer ответ по умолчанию
     */
    public StringStage(String question, String defaultAnswer) {
        setPanel(new StringPanel(index, question, defaultAnswer));
    }

    @Override
    public String doInConsole() {
        return null;
    }
}
