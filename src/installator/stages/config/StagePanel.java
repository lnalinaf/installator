package installator.stages.config;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author agalkin
 */
public abstract class StagePanel<T> {

	protected T data;
	protected int index;
	protected volatile boolean ready;
	protected ActionListener exitListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			int userAnswer = JOptionPane.showOptionDialog($$$getRootComponent$$$(), "Вы действительно хотите отменить установку?",
					"Выход из установки", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
			System.out.println("userAnswer" + userAnswer);
			if (userAnswer == 0)
				exit();
		}
	};
	protected ActionListener nextListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			calcData();
		}
	};

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
			ready = true;
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

	protected void exit() {
		synchronized (lock) {
			data = null;
			lock.notifyAll();
		}
	}

	public abstract JComponent $$$getRootComponent$$$();
}
