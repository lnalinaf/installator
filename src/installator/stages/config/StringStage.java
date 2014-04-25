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
     * Создание стадии ответа на вопрос с панелью разработчика
     * 
     * @param index индефикатор
     * @param panel панель, созданная разработчиком. Обязательно должна быть
     * наследником {@link StageInteracting}
     * @param name имя
     */
    StringStage(int index, StageInteracting<String> panel, String name) {
      //  super(panel, index, name);
    }

    /**
     * Создание стадии ответа на вопрос с панелью 
     * {@link StringPanel по умолчанию}
     * 
     * @param index индефикатор
     * @param name имя
     * @param question вопрос
     * @param defaultAnswer ответ по умолчанию
     */
    public StringStage(int index, String name, String question, String defaultAnswer) {
      //  super(index, name);
        setPanel(new StringPanel(index, name, question, defaultAnswer));
    }
}
