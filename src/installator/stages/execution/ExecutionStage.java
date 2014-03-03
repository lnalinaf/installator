package installator.stages.execution;

import installator.ExecStage;
import java.io.File;
import java.io.IOException;

public class ExecutionStage implements ExecStage {

    public ExecutionStage(String command, String[] envp, File dir) {
    }

    public ExecutionStage(String command, File dir) {
        this(command, null, dir);
    }

    public ExecutionStage(String command) {
        this(command, null, null);
    }

    @Override
    public int run() throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
