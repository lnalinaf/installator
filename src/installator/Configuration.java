package installator;

import installator.stages.config.BackListener;
import installator.stages.config.CancelListener;
import installator.stages.config.ConfigStage;
import installator.stages.config.NextListener;
import installator.stages.config.StageInteracting;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Класс, который содержит в себе всю информацию о конфигурации установки 
 * (взаимодействие с пользователем) и сохраняет всю информацию в объект 
 * {@link Parameters}. Класс инициализируется с помощью списка {@link ConfigStage}
 * Переход от одной стадии к другой по умолчанию осуществляется по порядку.
 * Если нужен некоторый алгоритмический переход, то нужно установить классу 
 * {@link NextListener} и {@link BackListener}
 * @author cfif11
 */
public class Configuration {
    
    private ArrayList<ConfigStage> list;
    private final Parameters parameters = new Parameters();
    private JFrame form;
    private ConfigStage currentStage = null;
    private NextListener nextListener = new DefaultNextListener();
    private BackListener backListener = new DefaultBackListener();
    private CancelListener cancelListener = new DefaultCancelListener();
    
    /**
     * Создать Конфигурацию
     * @param stages список стадий
     * @param isGUI использовать GUI режим?
     */
    Configuration(ArrayList<ConfigStage> stages, boolean isGUI) {
        this.list = stages;
        currentStage = list.get(0);
        setListeners();
        form = new TestIter();
        form.getContentPane().add((JPanel)stages.get(0).getPanel(), BorderLayout.CENTER);

        form.setVisible(true);
        /*this.form.panel = (JPanel)currentStage.getPanel();
        this.form.myInit();*/
    }
    
    /**
     * Добавить стадию в некоторое место списка
     * @param index
     * @param stage 
     */
    public void addStage(int index, ConfigStage stage) {
        list.add(index, stage);
    }
    
    /**
     * Получить стадию по индексу
     * @param index
     * @return 
     */
    public ConfigStage getStage(int index) {
        return list.get(index);
    }
    
    
    /**
     * Получить список стадий
     * @return список стадий
     */
    public ArrayList<ConfigStage> getListStages(){
        return list;
    }
    
    private void setListeners() {
        currentStage.setBackListener(backListener);
        currentStage.setCancelListener(cancelListener);
        currentStage.setNextListener(nextListener);
    }
    
    /**
     * Установить слушатель для алгоритмов перехода между стадиями(кнопка вперед)
     * @param nextListener 
     */
    public void setNextListener(NextListener nextListener) {
        this.nextListener = nextListener;
    }
    
    /**
     * 
     * Установить слушатель для алгоритмов перехода между стадиями(кнопка назад)
     * @param backListener 
     */
    public void setBackListener(BackListener backListener) {
        this.backListener = backListener;
    }
    
    /**
     * Установить слушатель для алгоритмов завершения установки(кнопка отмена)
     * @param cancelListener 
     */
    public void setCancelListener(CancelListener cancelListener) {
        this.cancelListener = cancelListener;
    }
    
    class DefaultNextListener implements NextListener {

        @Override
        public <T> void panelComplited(StageInteracting<T> panel) {
            System.out.println("Next");
            parameters.addParameter(panel.getIndex(), panel.getData());
            if(panel.getIndex()+1 <= list.size())
                currentStage = list.get(panel.getIndex() + 1);
            else {
                System.out.println("The End");
                return;
            }
            setListeners();
            form.add((JPanel)currentStage.getPanel());
        }
    
    }
    
    class DefaultBackListener implements BackListener {

        @Override
        public <T> void panelReverted(StageInteracting<T> panel) {
            System.out.println("Back");
            if(panel.getIndex() != 0) {
                currentStage = list.get(panel.getIndex() - 1);
                parameters.removeParameter(panel.getIndex() - 1);
            } else {
                System.out.println("the begin list");
                return;
            }
            setListeners();
            form.add((JPanel)currentStage.getPanel());
        }

    }
    
    class DefaultCancelListener implements CancelListener {
        @Override
        public <T> void panelCanceled(StageInteracting<T> panel) {
            System.out.println("Exit");
        }
    }

}
