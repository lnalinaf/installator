package installator.stages.config;

import installator.Configuration;

/**
 * Общий класс для стадии конфигурации. Из таких стадий должен состоять объект
 * {@link Configuration}. Стадия содержит основные поля "Имя" и "Панель".
 * Панель - графичиская компонента свинга, на которой все отображается.
 * @author cfif11
 * @param <T> Тип данных, которые возвращает стадия после своего завершения.
 */
public class ConfigStage<T> {
    
    private final PanelNextListener DEFAULT = new PanelNextListener<T>() {
        @Override
        public void stageComplited(StageInteracting<T> panel) {
            ConfigStage.this.loadData(panel.getData());
        }
    };
    
    protected final String name;
    
    /**
     * Доступна ли стадия для взаимодействия с пользователем. {@code true} -- если
     * стадия должна взаимодействовать с пользователем.
     * <p> Стадия была загружена, но после действий пользователя на предыдущих 
     * стадиях, она стала не нужна. В этом случае данная переменная должна получить 
     * значение {@code false}
     * @see #setVisible() 
     */
    protected boolean visible = true;

    /**
     * Графическая панель, с помощью которой пользователь будет взаимодействовать
     * с установщиком. Обязательно должна реализовывать интерфейс {@link StageInteracting}
     */
    protected StagePanel<T> panel;
    
    /**
     * В данной переменной должны находится данные, которые можно получить от 
     * пользователя на данной стадии.
     */
    protected T data;

    /**
     * Создаем стадию задавая имя и текст. Сразу после создания нужно задать панель
     * с помощью метода {@link #setPanel(javax.swing.JPanel)}
     * @param name имя
     */
    public ConfigStage(String name) {
        this.name = name;
    }
    
    /**
     * Создаем стадию задавая имя и панель.
     * @see #panel
     * @param panel панель, обязательно должна являть наследником {@link ConfigStage}
     * @param name имя
     */
    public ConfigStage(StagePanel<T> panel, String name) {
        this(name);
        if(panel instanceof StageInteracting) { 
            this.panel = panel;
            this.panel.setNextListener(DEFAULT);
        }
        else 
            throw new ClassCastException("panel does not implement StagePanel");
    }
    
    /**
     * Устанавливаем панель, если не передали ее в конструкторе.
     * @param panel панель, обязательно должна являть наследником {@link ConfigStage}
     */
    public void setPanel(StagePanel<T> panel) {
        if(panel instanceof StageInteracting) {
            this.panel = panel;
            this.panel.setNextListener(DEFAULT);
        }
        else 
            throw new ClassCastException("panel does not implement StagePanel");
    }
    
    
    /**
     * Возвращает графическую панель взаимодействия с пользователем
     * @return графическую панель взаимодействия с пользователем
     */
    public StagePanel<T> getPanel() {
        return panel;
    }
    
    /**
     * Устанавливаем данные с панели. Данный метод вызывается на панели.
     * @param data данные с панели.
     */
    public void loadData(T data) {
        this.data = data;
        System.out.println("DATA="+data);
    }
    
    /**
     * Возвращает данные взаимодействия с пользователем.
     * @return данные взаимодействия с пользователем.
     */
    public T getData() {
        return data;
    }
    
    /**
     * Устанавливаем видимость(возможность использования) стадии.
     * @param visible {@code true} если стадия используется.
     */
    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
    /**
     * Возвращает видимость(возможность использования) стадии.
     * @return {@code true} если стадия используется.
     */
    public boolean getVisible() {
        return visible;
    }
    
}
