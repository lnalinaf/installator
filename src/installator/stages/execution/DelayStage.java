package installator.stages.execution;

import java.io.IOException;

/**
 * Created by cfif11 on 13.05.14.
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
