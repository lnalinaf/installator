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
    public MultichoiceStage(StageInteracting<Integer[]> panel, int index, String name) {
        super(panel, index, name);
    }

    /**
     * Создание стадии множественного выбора из списка с панелью
     * {@link MultichoicePanel по умолчанию}.
     *
     * @param index индефикатор
     * @param name имя
     * @param text текст вопроса
     * @param itemsText массив строк для пунктов списка
     */
    public MultichoiceStage(int index, String name, String text, String[] itemsText) {
        super(index, name);
        setPanel(new MultichoicePanel(index, name, text, itemsText));
    }

}
