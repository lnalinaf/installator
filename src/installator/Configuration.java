package installator;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Configuration implements Iterable<ConfigStage> {
  
    private ArrayList<ConfigStage> list;


    @Override
    public Iterator<ConfigStage> iterator() {
        return new Iterator<ConfigStage>() {
            @Override
            public boolean hasNext() {
                return false;
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

}
