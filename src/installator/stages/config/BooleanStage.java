package installator.stages.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Стадия предназначенная для логического выбора. Основная полезная 
 * информация при работе с пользователем: true or false
 * @author alina
 */
public class BooleanStage extends ConfigStage<Boolean>{

private String name;

    public Boolean doInConsole() throws IOException {
        System.out.println(name);

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
     * Создание стадии логического выбора с панелью по умолчанию
     * {@link BooleanPanel по умолчанию}.
     * @param question текст вопроса
     * @param answer текст ответа
     */
    public BooleanStage(String question, String answer) {
        setPanel(new BooleanPanel(index, question, answer));
    }

}
