package installator.stages.config;

import javax.swing.JPanel;

public class LicenseStage<Boolean> extends ConfigStage<Boolean>{

    
    /**
     * Создание стадии принятия лицензии с панелью разработчика.
     * @param panel панель, созданная разработчиком. Обязательно должна быть 
     * наследником {@link StageInteracting}
     * @param name имя 
     */
    public LicenseStage(StagePanel panel, int index, String name) {
        super(panel, index, name);
      //  ((StageInteracting)panel).setStage(this);
    }   
    
    /**
     * Создание стадии принятия лицензии с панелью 
     * {@link LicensePanel по умолчанию}.
     * @param name имя
     * @param text текст лицензионного соглашения
     * @param question вопрос "на принятие лицензии"
     */
    public LicenseStage(int index, String name, String text, String question) {
        super(index, name);
        //setPanel(new LicensePanel(this, name, text, question));
    }
    
}
