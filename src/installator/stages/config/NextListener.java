/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package installator.stages.config;


/**
 * Слушатель перехода на стадию вперед
 * @author agalkin
 */
public interface NextListener {
    
     /**
     *  Реализуется алгоритм перехода на стадию вперед. Должен учитывать данные из
     * {@link Parameters}
     * @param <T>
     * @param panel панель, которая содержится на стадии, с которой уходим.
     */
    public <T> void panelComplited(StageInteracting<T> panel);
    
}
