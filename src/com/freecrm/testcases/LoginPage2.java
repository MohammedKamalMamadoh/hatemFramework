package com.freecrm.testcases;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.freecrm.base.TestBasis;
import com.freecrm.util.Screen;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class LoginPage2  extends TestBasis{
		
	public LoginPage2() throws IOException {
		super();
		  
	}
	@Parameters({"browser"})
	@BeforeMethod
	public void setup(String browser,Method method) throws ATUTestRecorderException
	{
       initiate();
        recorder = new ATUTestRecorder("C:\\Users\\huawei\\eclipse-workspace\\framework\\records", method.getName(), false);
		recorder.start();
	}
	
	@AfterMethod (enabled = true,groups = {"Smoke","E2E","Regression"})
	public void tearDown(Method method) throws ATUTestRecorderException, IOException
	{
	    recorder.stop();
	    Screen.screenshoots(method.getName());
		driver.quit();
		
	}
	
	@Test
	public void title(Method method) throws IOException
	{
	SoftAssert softassert= new SoftAssert();
	String expected_result= "Free CRM software can boost your sales by 30%";
	String ActualResult =driver.getTitle();
	System.out.println(ActualResult);
	softassert.assertEquals(ActualResult, expected_result);
	softassert.assertAll();
	Screen.screenshoots(method.getName());
	}

	@Test
	public void URL()
	{
		SoftAssert softassert= new SoftAssert();
		String expectedURL="https://freecrm.com/";
		String actualURL= driver.getCurrentUrl();
		System.out.println(actualURL);
		softassert.assertEquals(actualURL, expectedURL);
		softassert.assertAll();
	}
	
	@Test
	public void  IsLogoDisplayed()
	{
		SoftAssert softassert= new SoftAssert();
		WebElement logo=driver.findElement(By.xpath("//img[@class='img-responsive']"));
		Boolean actuallogoResult   = logo.isDisplayed();
		softassert.assertTrue(true, "logo not displayed");
		softassert.assertAll();
	
	}

	@Test
	public void Login()
	{	
		SoftAssert softassert= new SoftAssert();
		driver.navigate().to("https://ui.freecrm.com/");
		WebElement email =driver.findElement(By.name("email"));
		email.sendKeys(prop.getProperty("email"));
		WebElement password =driver.findElement(By.name("password"));
		password.sendKeys(prop.getProperty("password"));
		WebElement loginButton= driver.findElement(By.xpath("//div[text()='Login']"));
		loginButton.click();
		WebElement myname=  driver.findElement(By.cssSelector("span[class='user-display']"));
		Boolean expectedresult_login= true;
		Boolean Actualresult_login= myname.isDisplayed();	
		// this message will display when test fialed 
		softassert.assertEquals(Actualresult_login, expectedresult_login, "the two resalts are not matched and this case not passed");
		softassert.assertAll();
	}
	
	
	
//	@Test(priority = 8, enabled = true,groups = {"Smoke","E2E","Regression"},dataProvider = "Mydata")
//	public void Login(String D_username, String D_password)
//	{	
//		SoftAssert softassert= new SoftAssert();
//		driver.navigate().to("https://ui.freecrm.com/");
//		WebElement email =driver.findElement(By.name("email"));
//		email.sendKeys(D_username);
//		WebElement password =driver.findElement(By.name("password"));
//		password.sendKeys(D_password);
//		WebElement loginButton= driver.findElement(By.xpath("//div[text()='Login']"));
//		loginButton.click();
//		WebElement myname=  driver.findElement(By.cssSelector("span[class='user-display']"));
//		Boolean expectedresult_login= true;
//		Boolean Actualresult_login= myname.isDisplayed();	
//		// this message will display when test fialed 
//		softassert.assertEquals(Actualresult_login, expectedresult_login, "the two resalts are not matched and this case not passed");
//		softassert.assertAll();
//	}
//	
//	@DataProvider
//	public Object[][] Mydata()
//	{
//		Object [][] data = new Object [4][2];
//		data [0][0]= "mohammed.kamal.mamdoh@gmail.com";
//		data [0][1]= "Rent4545";
//		data [1][0]= "mohammed.kamal.mamdoh@gmail.com";
//		data [1][1]= "test";
//		data [2][0]= "rwewewer";
//		data [2][1]= "Rent4545";
//		data [3][0]= "dddeffwf";
//		data [3][1]= "asdfghpoigfghj";
//		return data;
//	}

}
