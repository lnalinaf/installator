/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package installator.stages.config;

import javax.swing.JPanel;

/**
 * Интерфейс, от которого должны наследоваться все {@link JPanel панели} 
 * для {@link ConfigStage стадий}. Расширяет стандартные свинговские панели 
 * для связи графического интерфейса с логическими стадиями.
 * @author cfif11
 * @param <T> тип возвращаемого значения от панель
 */
public interface StageInteracting<T> {
    

    
    /**
     * Метод возвращает полезную информацию взаимодействия пользователя с 
     * графическим интерфейсом.
     * @return 
     */
    public T getData();
    
    /**
     * Устанавливает ссылку на {@link ConfigStage стадию}, с которой
     * взаимодействует панель. Используется, когда разработчик устанавливает
     * свою панель для стадии.
     * @param stage 
     */
    public void setNextListener(NextListener nextListener);
    
    public void setBackListener(BackListener backListener);
   
    public void setCancelListener(CancelListener cancelListener);
    
    public boolean isUsable();
    
    public void setUsable(boolean usable);
    
    public int getIndex();
    
}
