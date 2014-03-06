package installator.stages.config;

import installator.ConfigStage;

public class ChoiceStage<Integer> extends ConfigStage<Integer>{

    public String item(){return null;}
    
    public int itemIndex(){return 0;}
    
    public ChoiceStage(String[] options) {
        super(null, null);
    }

    @Override
    public void setData(Integer data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
