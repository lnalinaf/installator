package installator.stages.config;

import javax.swing.JPanel;

/**
 * Стадия предназначенная для выбора пути установки. Основная полезная 
 * информация при работе с пользователем: путь до папки в виде строки.
 * @author cfif11
 */
public class PathStage extends ConfigStage<String>{
    public void doInConsole(){
        System.out.println();
    }
    /**
     * Создание стадии выбора пути с панелью разработчика.
     * @param panel панель, созданная разработчиком. Обязательно должна быть 
     * наследником {@link StageInteracting}
     * @param index индефикатор
     * @param name имя 
     */    
    public PathStage(StageInteracting<String> panel, int index, String name) {
        //super(panel, index, name);
    //    ((StageInteracting)panel).setStage(this);
    }
    
    /**
     * Создание стадии выбора пути с панелью {@link PathPanel по умолчанию}.
     * @param index индефикатор
     * @param name имя
     * @param text текст вопроса
     * @param defaultPath путь по умолчанию
     */
    public PathStage(int index, String name, String text, String defaultPath) {
        //super(index, name);
        setPanel(new PathPanel(index, name, text, defaultPath));
    }

}
