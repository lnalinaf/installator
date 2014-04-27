package installator;

import installator.stages.config.*;

import java.util.ArrayList;

/**
 * Created by cfif11 on 24.04.14.
 */
public class Test {

    static Configuration config;
    private static final ArrayList<ConfigStage> list = new ArrayList<ConfigStage>();

    public static void main(String[] args) {
        list.add(new LicenseStage("I agree", "BLABLABLABLABLABLA\nBLABLABLA"));
        list.add(new ChoiceStage("question", new String[] {"default", "two"}));
        list.add(new MultichoiceStage("question", new String[] {"default", "one", "two"}));
        list.add(new BooleanStage("Do?", "Yes"));
        list.add(new PathStage("Where", "C:/windows"));
        list.add(new StringStage("Что делать?", "забить болт"));

        config = new Configuration(list, true);

    }
}
