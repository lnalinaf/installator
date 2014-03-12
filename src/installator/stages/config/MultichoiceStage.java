package installator.stages.config;

import installator.ConfigStage;

public class MultichoiceStage<Integer> extends ConfigStage<Integer[]>{

    public String[] items(){return null;}
    
    public int[] itemIndexes(){return null;};
    
    public MultichoiceStage(String name, String text) {
        super(name, text);
    }

    @Override
    public void setData(Integer[] data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
