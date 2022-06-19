package com.selenoum.dataDriven.ExternalFiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DemoDataDriven {

	public Object[][] getTestData() throws EncryptedDocumentException, IOException {
//	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream(".\\testdataFiles\\data2.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("CrateUserUser");

		System.out.println("last row noumber (row count) : " + sheet.getLastRowNum());

		System.out.println("last column number ( Column Count ) : " + sheet.getRow(0).getLastCellNum());

		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

		for (int i = 0; i < sheet.getLastRowNum(); i++) { // iterate till last row.

			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) { // iterate till last column

				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();

			}
		}
		for (Object[] objects : data) {
			System.out.println(Arrays.toString(objects));
		}

		return data;
	}

}
