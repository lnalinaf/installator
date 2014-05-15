package installator.stages.config;

import installator.Configuration;

/**
 * Класс для обработки результатов работы одной {@link ConfigStage}. Данный менеджер используется для удаления
 * или перестановки дальнейших {@link ConfigStage} из {@link Configuration}. По умолчанию менеджер не установлен.
 *
 * @see ConfigStage#setConfigManager(ConfigManager)
 * @author cfif11
 */
public interface ConfigManager {

	/**
	 * Управляет {@link ConfigStage}, которые содержатся в {@link Configuration}
	 * @param configuration конфигурация
	 * @param data результаты работы стадии, для которой установлен данный менеджер
	 */
	public <T> void managedConfigStages(Configuration configuration, T data);

}
