package installator.stages.execution;

import java.io.IOException;

/**
 * Стадия ожидания некоторого времени
 * @author cfif11
 */
public class DelayStage implements ExecStage {
	@Override
	public int run() throws IOException {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			return -1;
		}
		return 0;
	}
}
