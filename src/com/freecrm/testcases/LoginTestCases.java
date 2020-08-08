package com.freecrm.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTestCases {
	
	WebDriver driver;
	
	
	@BeforeMethod (enabled = false)
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/chrome/chromedriver.exe");
	    driver= new ChromeDriver();
		driver.get("https://freecrm.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterMethod(enabled = false)
	public void tearDown()
	{
		driver.quit();
		
	}
	
	@Test(priority = 1,enabled = false)
	public void title()
	{
	String expected_result= "Free CRM software can boost your sales by 30%";
	String ActualResult =driver.getTitle();
	System.out.println(ActualResult);
	Assert.assertEquals(ActualResult, expected_result);
	}

	@Test(priority = 2,enabled = false)
	public void URL()
	{
		String expectedURL="https://freecrm.com/";
		String actualURL= driver.getCurrentUrl();
		System.out.println(actualURL);
		Assert.assertEquals(actualURL, expectedURL);
	}
	
	@Test (priority = 3, enabled = false)
	public void  IsLogoDisplayed()
	{
		SoftAssert softassert= new SoftAssert();
		WebElement logo=driver.findElement(By.xpath("//img[@class='img-responsive']"));
		//Boolean expectedlogoresult = true;
		Boolean actuallogoResult   = logo.isDisplayed();
		softassert.assertTrue(false, "false result");
		System.out.println("kimo");
		softassert.assertTrue(false, "false result");
		System.out.println("kimooooooooo");
		softassert.assertTrue(false, "false result");
		System.out.println("kimo test");
		softassert.assertAll();
		System.out.println("kimo all");
	}
	
	@Test(priority = 4, enabled = false)
	public void Login()
	{	
		driver.navigate().to("https://ui.freecrm.com/");
		WebElement email =driver.findElement(By.name("email"));
		email.sendKeys("Email");
		WebElement password =driver.findElement(By.name("password"));
		password.sendKeys("password");
		WebElement loginButton= driver.findElement(By.xpath("//div[text()='Login']"));
		loginButton.click();
		WebElement error= driver.findElement(By.cssSelector("div[class='header']"));
		String expectedresult_login= "Something went wrong...";
		String Actualresult_login= error.getText();	
		// this message will display when test fialed 
	   Assert.assertEquals(Actualresult_login, expectedresult_login, "the two resalts are matched and this yesy passed");
	    
	}
}
