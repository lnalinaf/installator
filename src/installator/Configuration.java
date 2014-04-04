package installator;

import installator.stages.config.BackListener;
import installator.stages.config.CancelListener;
import installator.stages.config.ConfigStage;
import installator.stages.config.NextListener;
import installator.stages.config.StageInteracting;
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
    
    private final CancelListener DEFAULT_CANCELL_LISTENER = new CancelListener() {

        @Override
        public <T> void panelCanceled(StageInteracting<T> panel) {
            System.out.println("Exit");
        }
    };
    
    private final NextListener DEFAULT_NEXT_LISTENER = new NextListener() {

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
            form.panel = (JPanel)currentStage.getPanel();
            form.myInit();
        }
    };
    
    private final BackListener DEFAULT_BACK_LISTENER = new BackListener() {

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
            form.panel = (JPanel)currentStage.getPanel();
            form.myInit();
        }
    };
  
    private ArrayList<ConfigStage> list;
    private Parameters parameters = new Parameters();
    private final Test form;
    private ConfigStage currentStage = null;
    private NextListener nextListener;
    private BackListener backListener;
    
    /**
     * Создать Конфигурацию
     * @param stages список стадий
     * @param form тут будет некий интерфейс в будущем
     */
    Configuration(ArrayList<ConfigStage> stages, JFrame form) {
        this.list = stages;
        currentStage = list.get(0);
        System.out.println("1!!!!!!!!!!!!!!!!");
        setListeners();
        System.out.println("2!!!!!!!!!!!!!!!!");
        this.form = (Test)form;
        this.form.panel = (JPanel)currentStage.getPanel();
        this.form.myInit();
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
        currentStage.setBackListener(DEFAULT_BACK_LISTENER);
        currentStage.setCancelListener(DEFAULT_CANCELL_LISTENER);
        currentStage.setNextListener(DEFAULT_NEXT_LISTENER);
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
    public void setNextListener(BackListener backListener) {
        this.backListener = backListener;
    }

}
