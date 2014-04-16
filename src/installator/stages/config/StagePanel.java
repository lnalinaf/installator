package installator.stages.config;

import javax.swing.JPanel;

/**
 *
 * @author agalkin
 */
class StagePanel<T> extends JPanel implements StageInteracting<T> {

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
}
