package installator.stages.config;

/**
 * Стадия предназначенная для множественного выбора из списка. Основная полезная
 * информация при работе с пользователем: массив выбранных пунктов из списка
 *
 * @author cfif11
 */
public class MultichoiceStage extends ConfigStage<Integer[]> {

    /**
     * Создание стадии множественного выбора из списка с панелью разработчика.
     *
     * @param panel панель, созданная разработчиком. Обязательно должна быть
     * наследником {@link StageInteracting}
     * @param index индефикатор
     * @param name имя
     */


    /**
     * Создание стадии множественного выбора из списка с панелью
     * {@link MultichoicePanel по умолчанию}.
     *
     * @param text текст вопроса
     * @param itemsText массив строк для пунктов списка
     */
    public MultichoiceStage(String text, String[] itemsText) {
        setPanel(new MultichoicePanel(index, text, itemsText));
    }

    @Override
    public Integer[] doInConsole() {
        return new Integer[0];
    }
}
