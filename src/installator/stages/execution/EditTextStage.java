package installator.stages.execution;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public abstract class EditTextStage implements ExecStage {

	String nameTextFile = null;
	private final List<String> strings = new ArrayList<>();

	public EditTextStage(String nameTextFile) {
		this.nameTextFile = nameTextFile;
	}

	public abstract String edit(String line);

	@Override
	public int run() throws IOException {
		Path path = Paths.get(nameTextFile);
		ListIterator<String> li = strings.listIterator();
		ListIterator<String> li1 = Files.readAllLines(path, Charset.defaultCharset()).listIterator();
		String t = li1.next();
		while (li1.hasNext()) {
			li.add(edit(t));
		}
		return 0;
	}
}
