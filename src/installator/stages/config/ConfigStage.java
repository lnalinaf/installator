package installator.stages.config;

import installator.Configuration;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Общий класс для стадии конфигурации. Из таких стадий должен состоять объект
 * {@link Configuration}. Стадия содержит основные поля "Имя", "Индефикатор" и
 * "Панель". Панель - наследник {@link StageInteracting}.
 *
 * @author cfif11
 * @param <T> Тип данных, которые возвращает стадия после своего завершения.
 */
public abstract class ConfigStage<T> implements StageInteracting<T> {

    /**
     * Индефикатор
     */
    protected int index;
    protected T data;

    private static final AtomicInteger STAGE_NUMERATOR = new AtomicInteger();

    private StagePanel<T> panel;

    public ConfigStage() {
        this.index = STAGE_NUMERATOR.getAndIncrement();
    }

    /**
     * Возвращает панель взаимодействия с пользователем
     *
     * @return панель взаимодействия с пользователем
     */
    public StagePanel<T> getPanel() {
        return panel;
    }

    /**
     * Возвращает данные взаимодействия с пользователем.
     *
     * @return данные взаимодействия с пользователем.
     */
    @Override
    public T getData() {
        return data;
    }

    protected void setPanel(StagePanel<T> panel) {
        this.panel = panel;
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

    public void run() {
        if(!Configuration.gui) {
            data = doInConsole();
        } else {
      //  while (getData() == null) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        //}
    }


    public abstract T doInConsole() throws IOException;
}
