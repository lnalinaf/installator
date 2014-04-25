package installator.stages.config;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LicenseStage extends ConfigStage<Boolean>{
    public Boolean doInConsole(){
       /* System.out.println(text);
        System.out.println(question);
        BufferedReader b = new BufferedReader(new InputStreamReader());

        System.exit();  */
        return null;
    }
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
