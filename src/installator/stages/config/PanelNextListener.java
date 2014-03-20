/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package installator.stages.config;

import javax.swing.JPanel;

/**
 * 
 * @author agalkin
 */
public interface PanelNextListener<T> {
    
    public void stageComplited(StageInteracting<T> panel);
    
}
