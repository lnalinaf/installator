package installator;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import javax.swing.JPanel;

public class ConfigStage<T> implements Callable<T>{
    
    private final String name;
    private final String text; 
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
    
    public void setPanel(JPanel panel) {
        this.panel = panel;
    }
    
    public JPanel getPanel() {
        return panel;
    }
    
    public void setDataTo() {
        panel.setName(name);
    }
    
    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
    public boolean getVisible() {
        return visible;
    }
    
}
