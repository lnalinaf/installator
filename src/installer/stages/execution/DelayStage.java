package installer.stages.execution;

import java.io.IOException;

/**
 * Стадия ожидания некоторого времени
 * @author cfif11
 */
public class DelayStage extends ExecStage {

	private long time = 3000;

	/**
	 * Устанавливает время ожидания
	 * @param time время ожидания
	 */
	public void setTime(long time) {
		this.time = time;
	}

	@Override
	public int run() throws IOException {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			return -1;
		}
		return 0;
	}
}
