package installator.stages.config;

import installator.Configuration;

/**
 * Общий класс для стадии конфигурации. Из таких стадий должен состоять объект
 * {@link Configuration}. Стадия содержит основные поля "Имя", "Индефикатор" и
 * "Панель". Панель - наследник {@link StageInteracting}.
 *
 * @author cfif11
 * @param <T> Тип данных, которые возвращает стадия после своего завершения.
 */
public class ConfigStage<T> implements StageInteracting<T> {

    /**
     * Имя
     */
    protected final String name;
    /**
     * Индефикатор
     */
    protected int index;

    private StageInteracting<T> panel;

    /**
     * Создание стадии
     *
     * @param index Индефикатор
     * @param name имя
     */
    public ConfigStage(int index, String name) {
        this.index = index;
        this.name = name;
    }

    /**
     * Создаем стадию задавая имя и панель.
     *
     * @see StageInteracting
     * @param panel панель, обязательно должна являть наследником
     * {@link StageInteracting}
     * @param index индефикатор
     * @param name имя
     */
    public ConfigStage(StageInteracting<T> panel, int index, String name) {
        this(index, name);
        this.panel = panel;
    }

    /**
     * Устанавливаем панель, если не передали ее в конструкторе.
     *
     * @param panel панель, обязательно должна являть наследником
     * {@link StageInteracting}
     */
    public void setPanel(StageInteracting<T> panel) {
        if (panel != null) {
            this.panel = panel;
        } else {
            throw new NullPointerException("panel is null");
        }
    }

    /**
     * Возвращает панель взаимодействия с пользователем
     *
     * @return панель взаимодействия с пользователем
     */
    public StageInteracting<T> getPanel() {
        return panel;
    }

    /**
     * Возвращает данные взаимодействия с пользователем.
     *
     * @return данные взаимодействия с пользователем.
     */
    @Override
    public T getData() {
        return panel.getData();
    }

    /**
     * Устанавливаем видимость(возможность использования) стадии.
     *
     * @param usable {@code true} если стадия используется.
     */
    @Override
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

    @Override
    public int getIndex() {
        return index;
    }
}
