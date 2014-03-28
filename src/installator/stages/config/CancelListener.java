/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package installator.stages.config;

/**
 *
 * @author s0912679
 */

public interface CancelListener {

    public <T> void panelCanceled(StageInteracting<T> panel);

}
