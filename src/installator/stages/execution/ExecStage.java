package installator.stages.execution;

import java.io.IOException;

/**
 * Стадия выполения некоторого действия установки
 */
public interface ExecStage {

	/**
	 * Выполнение действия стадии
	 * @return результат завершения(успешно или нет)
	 * @throws IOException
	 */
	int run() throws IOException;


}
