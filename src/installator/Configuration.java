package installator;

import installator.stages.config.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
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
public class Configuration implements Iterable<ConfigStage> {
    
    private ArrayList<ConfigStage> list;
    public static boolean gui;
    private final Parameters parameters = new Parameters();
    private TestIter form;
    private ConfigStage currentStage = null;
    private NextListener nextListener;// = new DefaultNextListener();
    private BackListener backListener;// = new DefaultBackListener();
    private CancelListener cancelListener;// = new DefaultCancelListener();
    
    /**
     * Создать Конфигурацию
     * @param stages список стадий
     * @param isGUI использовать GUI режим?
     */
    Configuration(ArrayList<ConfigStage> stages, boolean isGUI) {
        this.list = stages;
        gui = isGUI;
        currentStage = list.get(0);
        setListeners();
        if(isGUI) {
            form = new TestIter();
            form.getContentPane().add(stages.get(0).getPanel().getGUI());
            form.setVisible(true);

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            form.getContentPane().remove(stages.get(0).getPanel().getGUI());
            form.getContentPane().add(stages.get(1).getPanel().getGUI());
            form.setVisible(true);
        }
    }
    
    
    /**
     * Получить список стадий
     * @return список стадий
     */
    public ArrayList<ConfigStage> getListStages(){
        return list;
    }
    
    private void setListeners() {
       /* currentStage.setBackListener(backListener);
        currentStage.setCancelListener(cancelListener);
        currentStage.setNextListener(nextListener);          */
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

    @Override
    public Iterator<ConfigStage> iterator() {
        return new Iterator<ConfigStage>() {
            Iterator<ConfigStage> temp = list.iterator();
            @Override
            public boolean hasNext() {
                return temp.hasNext();
            }

            @Override
            public ConfigStage next() {
                return null;
            }

            @Override
            public void remove() {

            }
        };
    }

    public void run() {
        ConfigStage old = null;
        if(gui)
            form = new TestIter();
        for(ConfigStage cur : list) {
            if(cur.isUsable()) {
                cur.run();
                parameters.addParameter(cur.getIndex(), cur.getData());
                if(gui) {

                    if(old != null)
                        form.getContentPane().remove(old.getPanel().getGUI());
                    form.getContentPane().add(cur.getPanel().getGUI());
                    form.setVisible(true);

                }
            }
            old = cur;
        }
    }

  /*  class DefaultNextListener implements NextListener {

        @Override
        public <T> void panelComplited(ConfigStage<T> panel) {
            System.out.println("Next");
            ConfigStage temp = currentStage;
            parameters.addParameter(panel.getIndex(), panel.getData());
            if(panel.getIndex()+1 <= list.size())
                currentStage = list.get(panel.getIndex() + 1);
            else {
                System.out.println("The End");
                return;
            }
            form.remove();
            setListeners();
            form.add((JPanel)currentStage.getPanel());
        }
    
    }
    
   /* class DefaultBackListener implements BackListener {

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
    }          */

}
