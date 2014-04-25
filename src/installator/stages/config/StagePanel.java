package installator.stages.config;


import javax.swing.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author agalkin
 */
public abstract class StagePanel<T> implements StageInteracting<T>, Runnable{

    protected NextListener nextListener;
    protected CancelListener cancelListener;
    protected BackListener backListener;
    private boolean usable = true;
    protected T data;
    protected int index;

    public StagePanel(int index) {
        this.index = index;
    }

    @Override
    public boolean isUsable() {
        return usable;
    }

    @Override
    public void setUsable(boolean usable) {
        this.usable = usable;
    }

    @Override
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

    @Override
    public int getIndex() {
        return index;
    }

    public void run() {

    }

    public abstract JPanel getGUI();

    protected abstract void init();

    protected abstract void calcData();
}
