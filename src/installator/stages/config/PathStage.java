package installator.stages.config;

import javax.swing.JPanel;

/**
 * Стадия предназначенная для выбора пути установки. Основная полезная 
 * информация при работе с пользователем: путь до папки в виде строки.
 * @author cfif11
 */
public class PathStage extends ConfigStage<String>{

    /**
     * Создание стадии выбора пути с панелью разработчика.
     * @param panel панель, созданная разработчиком. Обязательно должна быть 
     * наследником {@link StageInteracting}
     * @param name имя 
     */    
    public PathStage(StagePanel panel, String name) {
        super(panel, name);
    //    ((StageInteracting)panel).setStage(this);
    }
    
    /**
     * Создание стадии выбора пути с панелью {@link PathPanel по умолчанию}.
     * @param name имя
     * @param text текст вопроса
     * @param defaultPath путь по умолчанию
     */
    public PathStage(String name, String text, String defaultPath) {
        super(name);
      //  setPanel(new PathPanel(this, name, text, defaultPath));
    }

}
