package installator.stages.config;

import installator.ConfigStage;

public class ChoiceStage<T> extends ConfigStage<T>{

    public String item(){return null;}
    
    public int itemIndex(){return 0;}
    
    public ChoiceStage(String[] options) {
        super(null, null);
    }
    

}
