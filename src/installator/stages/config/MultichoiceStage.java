package installator.stages.config;

import installator.ConfigStage;
import javax.swing.JPanel;

public class MultichoiceStage extends ConfigStage<Integer[]>{
    
    private Integer[] indexes;
    private String[] itemsText;
    private String[] itemsSelectedText;

    public String[] items(){
        return itemsSelectedText;
    }
    
    public Integer[] itemIndexes(){
        return indexes;
    }
    
    public MultichoiceStage(String name, String text) {
        super(name, text);
    }
    
    public MultichoiceStage(String name, String text, String[] itemsText) {
        super(name, text);
        this.itemsText = itemsText;
    }
    
    public void setItemText(String[] itemsText) {
        this.itemsText = itemsText;
    }
    
    public void createPanel(JPanel panel) throws Exception {
        if (panel != null) {
            if (panel instanceof StagePanel) {
                throw new Exception("");
            }
            this.panel = panel;
        }
        this.panel = new MultichoicePanel(this, name, text, itemsText);
    }

    @Override
    public void setData(Integer[] data) {
        indexes = data;
        itemsSelectedText = new String[data.length];
        for(int i = 0; i < data.length; i++) 
            itemsSelectedText[i] = itemsText[data[i]];
    }
    
    

}
