package com.freecrm.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Example {
	
	public static Object[][] GetDataFromExcel(String sheetname) throws IOException
	{
		File file = new File("C:\\Users\\huawei\\Desktop\\testcases.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		Sheet sheet= workbook.getSheet(sheetname);
		
		int row= sheet.getLastRowNum()+1;
		int column= sheet.getRow(0).getLastCellNum();
		Object data [][]  = new Object [row][column];
		for (int r = 0; r < row; r++)
		{
			for (int c = 0; c < column; c++)
			{
				data [r][c]=sheet.getRow(r).getCell(c).toString();
			}
			
		}
		System.out.println(data[0][0]);
		return data;
		
		
	}

}
