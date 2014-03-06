/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package installator.stages.config;

import installator.ConfigStage;

/**
 *
 * @author cfif11
 */
public interface StagePanel<T> {
    
    public T getData();
    
    public void setConfigStage(ConfigStage<?> stage);
    
    //public void setText(String text);
    
}
