package installator;

import installator.stages.config.BackListener;
import installator.stages.config.CancelListener;
import installator.stages.config.ConfigStage;
import installator.stages.config.NextListener;
import installator.stages.config.StageInteracting;
import java.util.ArrayList;
import java.util.Iterator;

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
        }
    };
    
    private final BackListener DEFAULT_BACK_LISTENER = new BackListener() {

        @Override
        public <T> void panelReverted(StageInteracting<T> panel) {
            System.out.println("Back");
        }
    };
  
    private ArrayList<ConfigStage> list;
    private Parameters parameters = new Parameters();
    
    Configuration(ArrayList<ConfigStage> stages) {
        this.list = stages;
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

}
