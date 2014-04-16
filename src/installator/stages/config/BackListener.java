package installator.stages.config;

/**
 * Слушатель перехода на стадию назад
 *
 * @author Vera
 */
public interface BackListener {

    /**
     * Реализуется алгоритм перехода на стадию назад. Должен учитывать данные из
     * {@link Parameters}
     *
     * @param panel панель, которая содержится на стадии, с которой уходим
     */
    public <T> void panelReverted(StageInteracting<T> panel);

}
