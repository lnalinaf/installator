package installator.stages.config;

import installator.ConfigStage;

public class EmptyStage<T> extends ConfigStage<T> {

    public EmptyStage(String text) {
        super(text, null);
    }

    @Override
    public void setData(T data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
