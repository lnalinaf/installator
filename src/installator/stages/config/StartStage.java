package installator.stages.config;

import javax.swing.JPanel;

/**
 * Стартовая стадия (приветствие)
 * @author cfif11
 */
public class StartStage extends ConfigStage<Object> {

    /**
     * Создание стартовой стадии с панелью разработчика.
     * @param panel панель, созданная разработчиком. Обязательно должна быть 
     * наследником {@link StageInteracting}
     * @param name имя  
     */
    public StartStage(StagePanel panel, String name) {
        super(panel, name);
    //    ((StageInteracting)panel).setStage(this);
    }
    
    /**
     * Создание стартовой стадии с панелью {@link StartPanel по умолчанию}.
     * @param name имя
     * @param text текст
     */
    public StartStage(String name, String text) {
        super(name);
    //    setPanel(new StartPanel(name, text));
    }
    
}
