package installer.stages.execution;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;


/**
 * Стадия разархивирования части архива по заданному пути
 */
public class UnzipStage extends ExecStage {

	private String in = null;
	private String out = null;

	/**
	 * Создает стадию с заданными указателями(Что и Куда)
	 * @param in что
	 * @param out куда
	 */
	public UnzipStage(String in, String out) {
		this.in = in;
		this.out = out;
	}

	/**
	 * Устанавливает что нужно разархивировать
	 * @param in что
	 */
	public void setIn(String in) {
		this.in = in;
	}

	/**
	 * Устанавливает куда надо разархивировать
	 * @param out куда
	 */
	public void setOut(String out) {
		this.out = out;
	}

	void unpack(String path, String dir_to) throws IOException {
		URL url = UnzipStage.class.getResource("");
		String zipFile = url.toString().replaceAll(".*file:", "").replaceAll("\\!.*", "");
		ZipFile zf = new ZipFile(zipFile);
		Enumeration<? extends ZipEntry> entries = zf.entries();
		ZipEntry e;
		InputStream in;
		OutputStream out;
		byte[] buffer = new byte[4096];
		int length;
		Path pDest = Paths.get(dir_to);
		Path outPath;
		File outFile;
		String partPlus = path + "/";
		while (entries.hasMoreElements()) {
			e = entries.nextElement();
			if (e.getName().equals(path) || e.getName().startsWith(partPlus)) {
				outPath = pDest.resolve(e.getName());
				outFile = outPath.toFile();
				if (e.isDirectory()) {
					outFile.mkdirs();
				} else {
					outFile.getParentFile().mkdirs();
					in = zf.getInputStream(e);
					out = new FileOutputStream(outFile);
					while ((length = in.read(buffer)) != -1) {
						out.write(buffer, 0, length);
					}
					out.flush();
					out.close();
				}
			}
		}
	}

	@Override
	public int run() throws IOException {
		unpack(in, out);
		return 0;
	}
}
