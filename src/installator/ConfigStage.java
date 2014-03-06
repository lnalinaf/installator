package installator;

import installator.stages.config.StagePanel;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import javax.swing.JPanel;

public abstract class ConfigStage<T> implements Callable<T>{
    
    private String name;
    private String text; 
    private boolean visible;
    private JPanel panel;
    protected ArrayList<T> data = new ArrayList<T>();

    @Override
    public T call() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
        //fail
    }

    public ConfigStage(String name, String text) {
        this.name = name;
        this.text = text;
    }
    
    public void setPanel(StagePanel<T> panel) throws Exception {
        if(panel instanceof JPanel) {
            panel.setConfigStage(this);
            this.panel = (JPanel)panel;
        } else {
            throw new Exception("panel isnt extends JPanel");
        }
    }
    
    public JPanel getPanel() {
        return panel;
    }
    
    public void setName(String name) {
        this.name = name;
        panel.setName(name);
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
    public abstract void setData(T data);
    
    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
    public boolean getVisible() {
        return visible;
    }
    
}
