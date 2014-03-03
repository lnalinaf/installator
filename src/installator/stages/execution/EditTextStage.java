package installator.stages.execution;

import installator.ExecStage;
import java.io.IOException;

public abstract class EditTextStage implements ExecStage{

    public EditTextStage(String textFile) {
    }
    
    public abstract String edit(String line);
    
    @Override
    public int run() throws IOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
