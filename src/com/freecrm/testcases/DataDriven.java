package com.freecrm.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {

	public static void main(String[] args) throws IOException {
		
		File file= new File("D:\\courses_resources\\QACart\\selenuim QACart framwork\\testcases.xlsx");
		FileInputStream fis= new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheet("Sheet1");
		System.out.println(sheet.getRow(0).getCell(0).toString());
		workbook.close();
		

	}

}
