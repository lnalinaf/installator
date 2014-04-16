package installator.stages.config;

/**
 * Слушатель отмены инсталлятора
 *
 * @author Vera
 */
public interface CancelListener {

    /**
     * Реализуется алгоритм отмены установки. Должен учитывать данные из
     * {@link Parameters}
     *
     * @param panel панель, которая содержится на стадии, с которой отменили
     * установку
     */
    public <T> void panelCanceled(StageInteracting<T> panel);

}
