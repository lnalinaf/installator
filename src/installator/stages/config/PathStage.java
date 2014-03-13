package installator.stages.config;

import installator.ConfigStage;
import java.io.File;

public class PathStage<String> extends ConfigStage<String>{

    public File path(){return null;}
    
    public PathStage(String text, String question) {
        super(null,null);
    }

    @Override
    public void setData(String data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
