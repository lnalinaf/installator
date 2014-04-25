
package installator.stages.config;

import javax.swing.JPanel;

/**
 * Интерфейс, от которого должны наследоваться все {@link JPanel панели} 
 * для {@link ConfigStage стадий}. Расширяет стандартные свинговские панели 
 * для связи графического интерфейса с логическими стадиями.
 * @author cfif11
 * @param <T> тип возвращаемого значения от панель
 */
interface StageInteracting<T> {
    

    
    /**
     * Метод возвращает полезную информацию взаимодействия пользователя с 
     * графическим интерфейсом.
     * @return 
     */
    public T getData();
    
    /**
     * Устанавливает слушатель для обработки перехода к следующий стадии.
     * @param nextListener слушатель {@link NextListener} 
     */
    public void setNextListener(NextListener nextListener);
    
    /**
     * Устанавливает слушатель для обработки перехода к предыдущей стадии.
     * @param backListener слушатель {@link BackListener} 
     */
    public void setBackListener(BackListener backListener);
   
    /**
     * Устанавливает слушатель для отмены установки.
     * @param cancelListener слушатель {@link CancelListener} 
     */
    public void setCancelListener(CancelListener cancelListener);
    
     /**
     * Проверяет видимость(возможность использования) стадии.
     *
     * @return {@code true} если стадия используется.
     */
    public boolean isUsable();
    
     /**
     * Устанавливаем видимость(возможность использования) стадии.
     *
     * @param usable {@code true} если стадия используется.
     */
    public void setUsable(boolean usable);
    
    /**
     * Возвращает индефикатор стадии.
     * @return индефикатор
     */
    public int getIndex();
    
}
