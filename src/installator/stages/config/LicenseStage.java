package installator.stages.config;

import installator.ConfigStage;

public class LicenseStage extends ConfigStage<Boolean>{

    
    public boolean accepted(){return true;};    
    
    public LicenseStage(String text, String question) {
        super(text, question);
    }

    
}
