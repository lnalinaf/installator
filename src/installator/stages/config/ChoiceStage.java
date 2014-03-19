package installator.stages.config;

import javax.swing.JPanel;

/**
 * Стадия предназначенная для выбора одного пункта из списка. Основная полезная 
 * информация при работе с пользователем: номер пункта из списка
 * @author cfif11
 */
public class ChoiceStage extends ConfigStage<Integer>{
    
    /**
     * Создание стадии единичного выбора из списка с панелью разработчика.
     * @param panel панель, созданная разработчиком. Обязательно должна быть 
     * наследником {@link StagePanel}
     * @param name имя 
     */
    public ChoiceStage(JPanel panel, String name) {
        super(panel, name);
        ((StagePanel)panel).setStage(this);
    }
    
    /**
     * Создание стадии единичного выбора из списка с панелью 
     * {@link ChoicePanel по умолчанию}.
     * @param name имя
     * @param text текст вопроса
     * @param itemsText массив строк для пунктов списка
     */
    public ChoiceStage(String name, String text, String[] itemsText) {
        super(name);
        setPanel(new ChoicePanel(this, name, text, itemsText));
    }
}
