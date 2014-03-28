/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package installator.stages.config;

/**
 *
 * @author s0912679
 */
public interface BackListener {

    public <T> void panelReverted(StageInteracting<T> panel);

}