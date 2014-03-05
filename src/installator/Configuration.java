package installator;

import java.util.ArrayList;
import java.util.Iterator;

public class Configuration implements Iterable<ConfigStage> {
  
    private ArrayList<ConfigStage> list;
    
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
