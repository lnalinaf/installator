package installator.stages.config;

import installator.ConfigStage;
import java.io.File;

public class PathStage extends ConfigStage<String>{

    public File path(){return null;}
    
    public PathStage(String text, String question) {
        super(text, question);
    }

}
