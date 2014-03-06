package installator.stages.config;

import installator.ConfigStage;
import javax.swing.JPanel;

/**
 * Created by cfif11 on 04.03.14.
 */
public class StartStage<T> extends ConfigStage<T> {

    public StartStage(String text, String question) {
        super(text, question);
                
    }

    @Override
    public void setData(T data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
