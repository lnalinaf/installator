package installator.stages.config;

/**
 * Слушатель перехода на стадию вперед
 *
 * @author agalkin
 */
public interface NextListener {

    /**
     * Реализуется алгоритм перехода на стадию вперед. Должен учитывать данные
     * из {@link Parameters}
     *
     * @param <T>
     * @param panel панель, которая содержится на стадии, с которой уходим.
     */
    public <T> void panelComplited(StageInteracting<T> panel);

}
