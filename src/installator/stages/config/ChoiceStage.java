package installator.stages.config;

/**
 * Стадия предназначенная для выбора одного пункта из списка. Основная полезная
 * информация при работе с пользователем: номер пункта из списка
 *
 * @author cfif11
 */
public class ChoiceStage extends ConfigStage<Integer> {

    /**
     * Создание стадии единичного выбора из списка с панелью
     * {@link ChoicePanelNew по умолчанию}.
     *
     * @param text текст вопроса
     * @param itemsText массив строк для пунктов списка
     */
    public ChoiceStage(String text, String[] itemsText) {
        setPanel(new ChoicePanelNew(index, text, itemsText));
    }
}
