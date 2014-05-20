package installer.stages.execution;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Стадия выполнения некоторой программы
 * @author Vera
 */
public class ExecutionStage extends ExecStage {

	private String command = null;

	public ExecutionStage(String command) {
		this.command = command;
	}

	@Override
	public int run() throws IOException {
		Process p = Runtime.getRuntime().exec(command);
		try {
			p.waitFor();
		} catch (InterruptedException ex) {
			Logger.getLogger(ExecutionStage.class.getName()).log(Level.SEVERE, null, ex);
		}
		return p.exitValue();
	}

	public void setCommand(String command) {
		this.command = command;
	}
}
