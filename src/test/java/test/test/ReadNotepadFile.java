package test.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.testng.annotations.Test;

public class ReadNotepadFile {

	@Test
	public void readNotepadFile() throws Exception {

		File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\Notepad1.txt");

		BufferedReader br = new BufferedReader(new FileReader(file));

		String st;
		while ((st = br.readLine()) != null) {
			System.out.println(st);
		}

		br.close();
	}

	@Test
	public void readNotepadFile2() throws Exception {

		FileReader fr = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\Notepad1.txt");

		int i;
		while ((i = fr.read()) != -1)
			System.out.print((char) i);
		fr.close();
	}

}
