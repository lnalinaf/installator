/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package installator.stages.config;

/**
 * Слушатель перехода на стадию назад
 * @author Vera
 */
public interface BackListener {

    /**
     *  Реализуется алгоритм перехода на стадию назад. Должен учитывать данные из
     * {@link Parameters}
     * @param <T>
     * @param panel панель, которая содержится на стадии, с которой уходим
     */
    public <T> void panelReverted(StageInteracting<T> panel);

}