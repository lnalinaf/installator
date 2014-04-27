package installator.stages.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LicenseStage extends ConfigStage<Boolean>{
    String text;
    String question;
    public Boolean doInConsole() throws IOException {
        System.out.println(text);
        System.out.println(question);
        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        String s = b.readLine();

        b.close();
        if(s.equalsIgnoreCase("y")||s.equalsIgnoreCase("yes")){
            return true;
        }else{
            return false;
        }
    }
    /**
     * Создание стадии принятия лицензии с панелью 
     * {@link LicensePanel по умолчанию
     * @param index индефикатор
     * @param name имя
     * @param text текст лицензионного соглашения
     * @param question вопрос "на принятие лицензии"
     */
    public LicenseStage(String text, String question) {
        setPanel(new LicensePanel(index, text, question));
    }



}
