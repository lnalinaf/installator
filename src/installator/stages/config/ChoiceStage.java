package installator.stages.config;

import installator.ConfigStage;
import javax.swing.JPanel;

public class ChoiceStage extends ConfigStage<Integer>{
    
    private Integer index;
    private String[] itemsText;

    public String item(){return itemsText[index];}
    
    public Integer itemIndex(){return index;}
    
    public ChoiceStage(String name, String text, String[] itemsText) {
        super(name, text);
        this.itemsText = itemsText;
    }
    
    public ChoiceStage(String name, String text) {
        super(name, text);
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
        this.panel = new ChoicePanel(this, name, text, itemsText);
    }

    @Override
    public void setData(Integer data) {
        index = data;
    }
    

}
