package test.test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestClass1 {
	// @Test
	public void testMethod() {
		Scanner s = new Scanner(System.in);
		int testCases;
		testCases = Integer.parseInt(s.nextLine());
		while (testCases > 0) {
			int N;
			/* Scanner s1 = new Scanner(System.in); */
			N = Integer.parseInt(s.nextLine());
			for (int i = 1; i <= N; i++) {
				if (i % 3 == 0 && i % 5 == 0)
					System.out.println("FizzBuzz");
				else if (i % 3 == 0)
					System.out.println("Fizz");
				else if (i % 5 == 0)
					System.out.println("Buzz");
				else
					System.out.println(i);
			}
			testCases--;
		}

	}

	public static void main(String[] args) throws Exception {

		String fname = "C:\\Users\\Mujeeb\\Desktop\\Book1.xlsx"; // or "C:\\myExcel.xlsx"
		InputStream inp = new FileInputStream(fname);
		Workbook wb = WorkbookFactory.create(inp);
		Sheet sheet = null;

		sheet = wb.getSheetAt(0);

		Iterator<Row> rows = sheet.rowIterator();

		final StringBuilder sb = new StringBuilder("");
		while (rows.hasNext()) {
			sb.append("|");
			Row row = (Row) rows.next();
			
			// how to write to a semicolon delimited dat file here
			Iterator<Cell> cells = row.cellIterator();

			while (cells.hasNext()) {
				Cell cell = cells.next();
				sb.append(cell.toString()).append("|");
			}
			sb.append("\n");
		}

		File file = new File("C:\\Users\\Mujeeb\\Desktop\\someFile.dat");

		if (!file.exists()) {
			file.createNewFile();
		}

		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		System.out.println(sb.toString());
		bw.write(sb.toString());
		bw.close();
	}

}
