package installator.stages.config;


import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author agalkin
 */
abstract class StagePanel<T> implements StageInteracting<T> {

    private static final AtomicInteger STAGE_NUMERATOR = new AtomicInteger();
    protected NextListener nextListener;
    protected CancelListener cancelListener;
    protected BackListener backListener;
    private boolean usable = true;
    protected T data;
    protected int index;

    public StagePanel() {
        init();
        this.index = STAGE_NUMERATOR.getAndIncrement();
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

    protected abstract void init();
}
