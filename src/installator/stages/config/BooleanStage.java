package installator.stages.config;

/**
 * Стадия предназначенная для логического выбора. Основная полезная 
 * информация при работе с пользователем: true or false
 * @author alina
 */
public class BooleanStage extends ConfigStage<Boolean>{

    public void doInConsole(){

    public Boolean doInConsole() throws IOException {
        System.out.println(name);

        BufferedReader b = new BufferedReader(new InputStreamReader());
        String s = b.readLine();
        if(s.equalsIgnoreCase("y")||s.equalsIgnoreCase("yes")){
            return true;
        }else{
            return false;
        }
        b.close();
    }
     /**
     * Создание стадии логического выбора с панелью
     * {@link BooleanPanel по умолчанию}.
     * @param index индефикатор
     * @param name имя
     * @param panel панель
     */
    public BooleanStage(int index, StageInteracting<Boolean> panel, String name) {
      //  super(panel, index, name);
    }
    
     /**
     * Создание стадии логического выбора с панелью по умолчанию
     * {@link BooleanPanel по умолчанию}.
     * @param index индефикатор
     * @param name имя
     * @param text текст вопроса
     */
    public BooleanStage(int index, String name, String text) {
      //  super(index, name);
        setPanel(new BooleanPanel(index, name, text));
    }

}
