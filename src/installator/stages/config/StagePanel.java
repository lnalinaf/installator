package installator.stages.config;


import javax.swing.*;

/**
 * @author agalkin
 */
public abstract class StagePanel<T> {

	protected T data;
	protected int index;

	class Lock {

	}

	protected final Lock lock = new Lock();

	public StagePanel(int index) {
		this.index = index;
	}

	public abstract JPanel getGUI();

	protected abstract void init();

	protected void calcData() {
		synchronized (lock) {
			lock.notifyAll();
		}
	}

	T doInGUI() {
		synchronized (lock) {
			try {
				lock.wait();
				return data;
			} catch (InterruptedException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}
}
