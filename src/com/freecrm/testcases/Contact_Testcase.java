package com.freecrm.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.freecrm.base.TestBasis;
import com.freecrm.util.Screen;

public class Contact_Testcase extends TestBasis{

	public Contact_Testcase() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Test(dataProvider = "testdata")
	public static void contact (String fname,String mname,String lname) throws IOException
	{
		initiate();
		driver.navigate().to("https://ui.freecrm.com/");
		WebElement email =driver.findElement(By.name("email"));
		email.sendKeys(prop.getProperty("email"));
		WebElement password =driver.findElement(By.name("password"));
		password.sendKeys(prop.getProperty("password"));
		WebElement loginButton= driver.findElement(By.xpath("//div[text()='Login']"));
		loginButton.click();
	   
	
		WebElement contactButton= driver.findElement(By.xpath(("//*[@id='main-nav']/a[3]/span")));
		contactButton.click(); 
		 driver.findElement(new ByChained(By.xpath("//a[@href='/contacts/new']"),By.tagName("button"))).click();
		 driver.navigate().refresh();
		WebElement firstname  = driver.findElement(By.xpath("//input[@name='first_name']"));
		firstname.sendKeys(fname);
		WebElement middelname =driver.findElement(By.xpath("//input[@name='middle_name']"));
		middelname.sendKeys(mname);
		WebElement lastname   =driver.findElement(By.xpath("//input[@name='last_name']"));
		lastname.sendKeys(lname);
	
		WebElement save= driver.findElement(By.xpath("//*[@id='dashboard-toolbar']/div[2]/div/button[2]"));
		save.click();
		WebElement assertsave= driver.findElement(By.xpath("//*[text()='Middle Name(s)']"));
		boolean expected =assertsave.isDisplayed();
		boolean actual =true;

		SoftAssert softassert =new SoftAssert();
		softassert.assertEquals(actual, expected);
		softassert.assertAll();
			
	}
	@DataProvider
	public Object [][] testdata() throws IOException
	{
		Object data [][] = Screen.GetDataFromExcel("Sheet2");
		return data;
	}

}
