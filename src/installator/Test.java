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
        list.add(0, new LicenseStage(0, "license", "I agree", "BLABLABLABLABLABLA\nBLABLABLA"));
        list.add(1, new ChoiceStage(1, "choice", "question", new String[] {"default", "two"}));
        list.add(2, new MultichoiceStage(2, "multichoice", "question", new String[] {"default", "one", "two"}));
        list.add(3, new PathStage(3, "path", "Where", "C:/windows"));

        config = new Configuration(list, true);

    }
}
