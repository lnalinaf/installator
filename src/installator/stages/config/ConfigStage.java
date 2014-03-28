package installator.stages.config;

import installator.Configuration;

/**
 * Общий класс для стадии конфигурации. Из таких стадий должен состоять объект
 * {@link Configuration}. Стадия содержит основные поля "Имя" и "Панель".
 * Панель - графичиская компонента свинга, на которой все отображается.
 * @author cfif11
 * @param <T> Тип данных, которые возвращает стадия после своего завершения.
 */
public class ConfigStage<T> implements StageInteracting<T>{

    protected final String name;

    /**
     * Графическая панель, с помощью которой пользователь будет взаимодействовать
     * с установщиком. Обязательно должна реализовывать интерфейс {@link StageInteracting}
     */
    private StageInteracting<T> panel;

    public ConfigStage(String name) {
        this.name = name;
    }

    /**
     * Создаем стадию задавая имя и панель.
     * @see #panel
     * @param panel панель, обязательно должна являть наследником {@link ConfigStage}
     * @param name имя
     */
    public ConfigStage(StageInteracting<T> panel, String name) {
        this(name);
        this.panel = panel;
    }

    /**
     * Устанавливаем панель, если не передали ее в конструкторе.
     * @param panel панель, обязательно должна являть наследником {@link ConfigStage}
     */
    public void setPanel(StageInteracting<T> panel) {
        if (panel != null) {
            this.panel = panel;
        } else {
            throw new NullPointerException("panel is null");
        }
    }

    /**
     * Возвращает графическую панель взаимодействия с пользователем
     * @return графическую панель взаимодействия с пользователем
     */
    public StageInteracting<T> getPanel() {
        return panel;
    }

    /**
     * Возвращает данные взаимодействия с пользователем.
     * @return данные взаимодействия с пользователем.
     */
    public T getData() {
        return panel.getData();
    }

    /**
     * Устанавливаем видимость(возможность использования) стадии.
     * @param usable {@code true} если стадия используется.
     */
    public void setUsable(boolean usable) {
        panel.setUsable(usable);
    }

    @Override
    public void setNextListener(NextListener nextListener) {
        panel.setNextListener(nextListener);
    }

    @Override
    public void setBackListener(BackListener backListener) {
        panel.setBackListener(backListener);
    }

    @Override
    public void setCancelListener(CancelListener cancelListener) {
        panel.setCancelListener(cancelListener);
    }

    @Override
    public boolean isUsable() {
        return panel.isUsable();
    }
}
