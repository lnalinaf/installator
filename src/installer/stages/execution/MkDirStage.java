/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package installer.stages.execution;

import java.io.File;
import java.io.IOException;

/**
 * Стадия создания директории
 * @author Vera
 */
public class MkDirStage extends ExecStage {

	private String name = null;

	/**
	 * Создает стадию с заданым названием директории
	 * @param name название директории
	 */
	public MkDirStage(String name) {
		this.name = name;
	}

	/**
	 * Устанавливает название директории
	 * @param name навзавание директории
	 */
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int run() throws IOException {
		boolean flag;
		File file = new File(name);
		flag = file.mkdirs();
		return flag ? 0 : 1;
	}
}
