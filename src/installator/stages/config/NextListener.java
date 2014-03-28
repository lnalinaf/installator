/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package installator.stages.config;


/**
 * 
 * @author agalkin
 */
public interface NextListener {
    
    public <T> void panelComplited(StageInteracting<T> panel);
    
}
