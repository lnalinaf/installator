package installator.stages.execution;

import installator.ExecStage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author s0912679
 */
public class ExecutionStage implements ExecStage {

    String command = null;

    public ExecutionStage(String command) {
        this.command = command;
    }

    @Override
    public int run() throws IOException {
        Process p= Runtime.getRuntime().exec(command);
        try {
            p.waitFor();
        } catch (InterruptedException ex) {
            Logger.getLogger(ExecutionStage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p.exitValue();
    }
}
