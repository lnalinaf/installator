package installator.stages.config;

public class LicenseStage extends ConfigStage<Boolean>{
    
    /**
     * Создание стадии принятия лицензии с панелью 
     * {@link LicensePanelNew по умолчанию
     * @param index индефикатор
     * @param name имя
     * @param text текст лицензионного соглашения
     * @param question вопрос "на принятие лицензии"
     */
    public LicenseStage(String text, String question) {
        setPanel(new LicensePanelNew(index, text, question));
    }
    
}
