package installator.stages.config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Стадия предназначенная для выбора пути установки. Основная полезная 
 * информация при работе с пользователем: путь до папки в виде строки.
 * @author cfif11
 */
public class PathStage extends ConfigStage<String>{


    String name;

    public String doInConsole() throws IOException {
        System.out.println(name);

        BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
        String s = b.readLine();

        b.close();
        return s;

    }

    
    /**
     * Создание стадии выбора пути с панелью {@link PathPanel по умолчанию}.
     * @param text текст вопроса
     * @param defaultPath путь по умолчанию
     */
    public PathStage(String text, String defaultPath) {
        setPanel(new PathPanel(index, text, defaultPath));
    }

}
