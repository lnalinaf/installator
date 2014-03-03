package installator;

import java.util.concurrent.Callable;

public class ConfigStage<T> implements Callable<T>{

    @Override
    public T call() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
        //fail
    }

    public ConfigStage(String text, String question) {
    }
    
}
