/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package installator.stages.config;

/**
 * Стадия предназначенная для логического выбора. Основная полезная 
 * информация при работе с пользователем: true or false
 * @author alina
 */
public class BooleanStage  extends ConfigStage<Boolean>{

     /**
     * Создание стадии логического выбора с панелью
     * {@link BooleanPanel по умолчанию}.
     * @param index индефикатор
     * @param name имя
     * @param panel панель
     */
    public BooleanStage(int index, StagePanel panel, String name) {
        super(panel, index, name);
    }
    
     /**
     * Создание стадии логического выбора с панелью по умолчанию
     * {@link BooleanPanel по умолчанию}.
     * @param index индефикатор
     * @param name имя
     * @param text текст вопроса
     */
    public BooleanStage(int index, String name, String text) {
        super(index, name);
        setPanel(new BooleanPanel(index, name, text));
    }

}