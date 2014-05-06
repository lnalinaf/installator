package installator.stages.execution;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class UnzipStage implements ExecStage {

	String in = null;
	String out = null;

	public UnzipStage(String in, String out) {
		this.in = in;
		this.out = out;
	}

	public void unpack(String path, String dir_to) throws IOException {
		ZipFile zip = new ZipFile(path);
		Enumeration<? extends ZipEntry> entries = zip.entries();
		LinkedList<ZipEntry> zipFiles = new LinkedList<>();
		while (entries.hasMoreElements()) {
			ZipEntry entry = entries.nextElement();
			if (Pattern.compile(in).matcher(entries.nextElement().getName()).find()) {
				if (entry.isDirectory()) {
					new File(dir_to + "/" + entry.getName()).mkdir();
				} else {
					zipFiles.add(entry);
				}
			}
		}
		for (ZipEntry entry : zipFiles) {
			InputStream in = zip.getInputStream(entry);
			OutputStream out = new FileOutputStream(dir_to + "/" + entry.getName());
			byte[] buffer = new byte[1024];
			int len;
			while ((len = in.read(buffer)) >= 0) {
				out.write(buffer, 0, len);
			}
			in.close();
			out.close();
		}
		zip.close();
	}

	@Override
	public int run() throws IOException {
		String path = UnzipStage.class.getResource("").toString().
				replace("jar:file:", "").replace("!/installator.stages.execution", "");
		String dir_to = out;
		unpack(path, dir_to);
		return 0;
	}
}
