package installator.stages.config;

import installator.ConfigStage;
import javax.swing.JPanel;

public class PathStage extends ConfigStage<String>{

    private String pathDirectory;
    
    public PathStage(String text, String question) {
        super(null,null);
    }
    
    public String path(){
        return pathDirectory;
    }
    
        
    public void createPanel(JPanel panel) throws Exception {
        if (panel != null) {
            if (panel instanceof StagePanel) {
                throw new Exception("");
            }
            this.panel = panel;
        }
        this.panel = new PathPanel(this, name, text);
    }

    @Override
    public void setData(String data) {
        pathDirectory = data;
    }

}
