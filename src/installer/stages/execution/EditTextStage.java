package installer.stages.execution;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ListIterator;

/**
 * Стадия редактирования текстового файла
 */
public abstract class EditTextStage extends ExecStage {

	String nameTextFile = null;

	/**
	 * Создает стадию с заданным названием файла.
	 * @param nameTextFile название файла.
	 */
	public EditTextStage(String nameTextFile) {
		this.nameTextFile = nameTextFile;
	}

	/**
	 * Устанавливает название тесктового файла, который надо будет изменять
	 * @param nameTextFile название тесктового файла
	 */
	public void setNameTextFile(String nameTextFile) {
		this.nameTextFile = nameTextFile;
	}

	/**
	 * Задает действия по редактированию данной строки.
	 * @param line Строка, которую надо редактировать
	 * @return результат редактирования
	 */
	public abstract String edit(String line);

	@Override
	public int run() throws IOException {
		Path path = Paths.get(nameTextFile);
		ListIterator<String> li1 = Files.readAllLines(path, Charset.defaultCharset()).listIterator();
		PrintStream print  = new PrintStream(nameTextFile);
		while (li1.hasNext())
			print.println(edit(li1.next()));
		print.close();
		return 0;
	}
}
