package com.freecrm.utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	XSSFWorkbook wb;
	
	//Use of constructor: whenever the obj of ExcelReader is created excel sheet will be loaded and testdata is ready.
	public ExcelReader() {
		File src = new File(".\\TestData\\Testdata.xlsx");
		try {
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("Unable to read Excel File " + e.getMessage());
		}
	}
	
	//Method overloading where method name is same but parameters num is same but type is diff.
	public String getStringData(int SheetIndex, int row, int col) {
		return wb.getSheetAt(SheetIndex).getRow(row).getCell(col).getStringCellValue();
	}
	
	public String getStringData(String SheetName, int row, int col) {
		return wb.getSheet(SheetName).getRow(row).getCell(col).getStringCellValue();
	}

	public double getNumericData(String SheetName, int row, int col) {
		return wb.getSheet(SheetName).getRow(row).getCell(col).getNumericCellValue();
	}
}
