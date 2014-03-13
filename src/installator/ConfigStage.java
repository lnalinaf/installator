package installator;

import installator.stages.config.StagePanel;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import javax.swing.JPanel;

public abstract class ConfigStage<T> implements Callable<T>{
    
    protected String name;
    protected String text; 
    protected boolean visible;
    protected JPanel panel;
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
    
    public ConfigStage(JPanel panel, String name, String text) {
        this(name, text);
        if(panel instanceof StagePanel) 
            this.panel = panel;
        else 
            throw new ClassCastException("panel is null");
        this.panel = panel;
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
