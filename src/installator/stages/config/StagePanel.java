package installator.stages.config;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * Класс для использования графической формы стадии.
 * @author cfif11
 */
public abstract class StagePanel<T> {

	/**
	 * Текст для кнопки "отмена"
	 */
	public static final String CANCEL = "Отмена";

	/**
	 * Текст для кнопки "продолжить"
	 */
	public static final String NEXT = "Продолжить";

	/**
	 * Стандартный размер окна установщика
	 */
	public static final Dimension STANDARD_SIZE = new Dimension(400, 300);

	/**
	 * Данные, которые считывает программа со стадии при взаимодействии с пользователем
	 */
	protected T data;

	/**
	 * Индефикатор стадии
	 */
	protected int index;

	/**
	 * Слушатель для вызова диалога о завершении программы.
	 */
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

	/**
	 * Слушатель для перехода на следующую стадию
	 */
	protected ActionListener nextListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			calcData();
		}
	};

	class Lock {

	}

	private final Lock lock = new Lock();

	/**
	 * Создание панели
	 * @param index индефикатор стадии
	 */
	public StagePanel(int index) {
		this.index = index;
	}

	/**
	 * Возвращает Графическую {@link javax.swing.JPanel панель}
	 * @return
	 */
	public abstract JPanel getGUI();

	/**
	 * Инициализация стадии
	 */
	protected abstract void init();

	/**
	 * Вычисление данных при работе с пользователем.
	 */
	protected void calcData() {
		synchronized (lock) {
			lock.notifyAll();
		}
	}


	/**
	 * Не закрывает стадию, пока работа с ней не будет закончена
	 * @return
	 */
	protected T doInGUI() {
		synchronized (lock) {
			try {
				lock.wait();
				return data;
			} catch (InterruptedException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}

	/**
	 * Выход из стадии
	 */
	protected void exit() {
		synchronized (lock) {
			data = null;
			lock.notifyAll();
		}
	}

	public abstract JComponent $$$getRootComponent$$$();
}
