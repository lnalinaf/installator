package installator.stages.config;

public class LicenseStage extends ConfigStage<Boolean>{

    
    /**
     * Создание стадии принятия лицензии с панелью разработчика.
     * @param panel панель, созданная разработчиком. Обязательно должна быть 
     * наследником {@link StageInteracting}
     * @param index индефикатор
     * @param name имя 
     */
    public LicenseStage(StageInteracting<Boolean> panel, int index, String name) {
        super(panel, index, name);
    }   
    
    /**
     * Создание стадии принятия лицензии с панелью 
     * {@link LicensePanel по умолчанию
     * @param index индефикатор
     * @param name имя
     * @param text текст лицензионного соглашения
     * @param question вопрос "на принятие лицензии"
     */
    public LicenseStage(int index, String name, String text, String question) {
        super(index, name);
        setPanel(new LicensePanel(index, name, text, question));
    }
    
}
