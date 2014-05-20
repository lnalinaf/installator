package installer.stages.config;

import installer.Configuration;
import installer.Parameters;

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
	 * @param configStage стадия конфигурации
	 * @param parameters контейнер с результатами работы конфигурации
	 */
	public <T> void managedConfigStages(ConfigStage<T> configStage, Parameters parameters);

}
