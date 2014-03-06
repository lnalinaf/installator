package installator.stages.config;

import installator.ConfigStage;

public class LicenseStage<Boolean> extends ConfigStage<Boolean>{

    
    public boolean accepted(){return true;};    
    
    public LicenseStage(String text, String question) {
        super(text, question);
    }

    @Override
    public void setData(Boolean data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
