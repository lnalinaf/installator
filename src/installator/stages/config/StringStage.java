/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package installator.stages.config;

/**
 *
 * @author s0921212
 */
public class StringStage extends ConfigStage<String> {

    public StringStage(int index, StagePanel panel, String name){
        super(panel, index, name);
    }
public StringStage(int index, String name, String text, String itemsText) {
        super(index, name);
        setPanel(new StringPanel(index, name, text, itemsText));
    }
}
