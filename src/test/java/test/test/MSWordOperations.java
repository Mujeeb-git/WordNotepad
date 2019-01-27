package test.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.Borders;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.testng.annotations.Test;

public class MSWordOperations {

	// s@Test
	public void createWordDoc() throws Exception {

		// Blank Document
		XWPFDocument document = new XWPFDocument();

		// Write the Document in file system
		FileOutputStream out = new FileOutputStream(
				new File(System.getProperty("user.dir") + "\\src\\test\\resources\\createdocument.docx"));
		document.write(out);
		out.close();
		System.out.println("createdocument.docx written successully");
	}

	// @Test
	public void createParagraph() throws Exception {

		// Blank Document
		XWPFDocument document = new XWPFDocument();

		// Write the Document in file system
		FileOutputStream out = new FileOutputStream(
				new File("C:\\Users\\Mujeeb\\Pictures\\OUTPUT" + "\\createdocument.docx"));

		// create Paragraph
		XWPFParagraph paragraph = document.createParagraph();

		// Set bottom border to the Paragraph
		paragraph.setBorderBottom(Borders.BASIC_BLACK_DASHES);

		// Set Left border to the Paragraph
		paragraph.setBorderLeft(Borders.BASIC_BLACK_DASHES);

		// Set Right border to the Paragraph
		paragraph.setBorderRight(Borders.BASIC_BLACK_DASHES);

		// Set Top border to the Paragraph
		paragraph.setBorderTop(Borders.BASIC_BLACK_DASHES);

		XWPFRun run = paragraph.createRun();
		run.setText(
				"Name:" + "\n" + "Employee Number:" + "\n" + "Department:" + "\n" + "Salary:" + "\n" + "Phone Number:");

		document.write(out);
		out.close();
		document.close();
		System.out.println("createparagraph.docx written successfully");
	}

	// @Test
	public void createTable() throws Exception {
		// Blank Document
		XWPFDocument document = new XWPFDocument();

		// Write the Document in file system
		FileOutputStream out = new FileOutputStream(
				new File("C:\\Users\\Mujeeb\\Pictures\\OUTPUT" + "\\createTable.docx"));

		// create Table
		XWPFTable table = document.createTable();

		table.setWidth(10);

		// create first row of the Table
		XWPFTableRow tableRowOne = table.getRow(0);
		tableRowOne.getCell(0).setText("Name");
		tableRowOne.addNewTableCell().setText("George");
		tableRowOne.addNewTableCell().setText("Washington");

		// create second row of the Table
		XWPFTableRow tableRowTwo = table.createRow();
		tableRowTwo.getCell(0).setText("Employee Number");
		tableRowTwo.getCell(1).setText("001");
		tableRowTwo.getCell(2).setText("9876");

		// create third row of the Table
		XWPFTableRow tableRowThree = table.createRow();
		tableRowThree.getCell(0).setText("Department");
		tableRowThree.getCell(1).setText("HYD");
		tableRowThree.getCell(2).setText("OPS");

		document.write(out);
		out.close();
		document.close();
		System.out.println("createTable.docx written successfully");

	}

	//@Test
	public void alignParagraph() throws Exception {

		// Blank Document
		XWPFDocument document = new XWPFDocument();

		// Write the Document in file system
		FileOutputStream out = new FileOutputStream(
				new File("C:\\Users\\Mujeeb\\Pictures\\OUTPUT" + "\\alignparagraph.docx"));

		// create paragraph
		XWPFParagraph paragraph = document.createParagraph();

		// Set alignment paragraph to RIGHT
		paragraph.setAlignment(ParagraphAlignment.RIGHT);
		XWPFRun run = paragraph.createRun();
		run.setText("At tutorialspoint.com, we strive hard to " + "provide quality tutorials for self-learning "
				+ "purpose in the domains of Academics, Information "
				+ "Technology, Management and Computer Programming " + "Languages.");

		// Create Another paragraph
		paragraph = document.createParagraph();

		// Set alignment paragraph to CENTER
		paragraph.setAlignment(ParagraphAlignment.CENTER);
		run = paragraph.createRun();
		run.setText("The endeavour started by Mohtashim, an AMU "
				+ "alumni, who is the founder and the managing director "
				+ "of Tutorials Point (I) Pvt. Ltd. He came up with the "
				+ "website tutorialspoint.com in year 2006 with the help"
				+ "of handpicked freelancers, with an array of tutorials" + " for computer programming languages. ");

		document.write(out);
		out.close();
		System.out.println("alignparagraph.docx written successfully");

	}

	@Test
	public static void wordExtractor() throws Exception, IOException {

		XWPFDocument docx = new XWPFDocument(new FileInputStream("C:\\Users\\Mujeeb\\Pictures\\OUTPUT" + "\\alignparagraph.docx"));

		// using XWPFWordExtractor Class
		XWPFWordExtractor we = new XWPFWordExtractor(docx);
		System.out.println(we.getText());
	}
}