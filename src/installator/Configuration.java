package installator;

import installator.stages.config.BackListener;
import installator.stages.config.CancelListener;
import installator.stages.config.ConfigStage;
import installator.stages.config.NextListener;
import installator.stages.config.StageInteracting;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Configuration implements Iterable<ConfigStage> {
    
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


    @Override
    public Iterator<ConfigStage> iterator() {
        return list.listIterator();
    }
    
    public void addStage(ConfigStage stage) {
        list.add(stage);
    }
    
    public void addStage(int index, ConfigStage stage) {
        list.add(index, stage);
    }
    
    public ConfigStage getStage(int index) {
        return list.get(index);
    }
    
    public ArrayList<ConfigStage> getListStages(){
        return list;
    }
    
    private void setListeners() {
        currentStage.setBackListener(DEFAULT_BACK_LISTENER);
        currentStage.setCancelListener(DEFAULT_CANCELL_LISTENER);
        currentStage.setNextListener(DEFAULT_NEXT_LISTENER);
    }

}
