/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package installator.stages.config;

import javax.swing.JPanel;

/**
 * 
 * @author agalkin
 */
public class StagePanel<T> extends JPanel implements StageInteracting<T>{
    
    protected NextListener nextListener;
    protected CancelListener cancelListener;
    protected BackListener backListener;
    private boolean usable = true;
    protected T data;
    protected int index;

    public StagePanel(int index) {
        super();
        this.index = index;
    }   
    
   public boolean isUsable() {
       return usable;
   }
   
   public void setUsable(boolean usable) {
       this.usable = usable;
   }
   
   public T getData() {
       return data;
   }

    @Override
    public void setNextListener(NextListener nextListener) {
        this.nextListener = nextListener;
    }

    @Override
    public void setBackListener(BackListener backListener) {
        this.backListener = backListener;
    }

    @Override
    public void setCancelListener(CancelListener cancelListener) {
        this.cancelListener = cancelListener;
    }
    
    public int getIndex() {
        return index;
    }
}
