package BUU.ZSpider.dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

public class FileDao {
	public void WriteTOLocal(String string, String fileName) throws IOException {
		FileWriter fileWriter = new FileWriter(new File("G:\\tianya\\"
				+ fileName));
		fileWriter.write(string);
		fileWriter.flush();
		fileWriter.close();
	}

	public void WriteTOLocal(String string) throws IOException {
		String fileName = UUID.randomUUID().toString();
		
		this.WriteTOLocal(string, fileName);
	}
}
