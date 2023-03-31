package com.Actitime.genericLibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * this class is generic class which is having non static methods to perform data driven testing
 * @author shubham
 *
 */

public class FileLibrary {
	public String readDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis= new FileInputStream("./Testdata/commondata.property.txt");
		Properties p= new Properties();
		p.load(fis);
		String value=p.getProperty(key);
		return value;
	}
	/**
	 * this method is non static method used to read the data from excel sheet
	 * @param sheetname
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromeExcelFile(String sheetname,int row,int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis1= new FileInputStream("./Testdata/ActiTimeTestData1.xlsx");
		Workbook wb= WorkbookFactory.create(fis1);
		String value = wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
		return value;
	}

}
