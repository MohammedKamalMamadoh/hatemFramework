package com.freecrm.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.freecrm.base.TestBasis;

public class Screen  extends TestBasis{

	public Screen() throws IOException {
		super();
		
	}
	
	public static  void screenshoots (String name) throws IOException
	{
		File srcFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("C:\\Users\\huawei\\eclipse-workspace\\framework\\ScreenShoots\\"+name+".png"));
		
	}
	
	public static Object[][] GetDataFromExcel(String sheetname) throws IOException
	{
		File file = new File("D:\\courses_resources\\QACart\\selenuim QACart framwork\\testcases.xlsx");
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
				System.out.println(data[r][c]);
			}
			
		}
		
		return data;
		
		
		
	}

}
