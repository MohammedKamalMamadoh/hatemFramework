package com.freecrm.base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

import com.freecrm.util.WedDriverEventListener_Example;

import atu.testrecorder.ATUTestRecorder;

public class TestBasis

{
	public static  WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WedDriverEventListener_Example wBELisener ;
	public static ATUTestRecorder recorder;
	public static Actions action;
	public TestBasis() throws IOException
	{
		prop= new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\huawei\\eclipse-workspace\\framework\\src\\config\\configParameters.properties");
		prop.load(file);
	}
	
	public static void initiate()  //(//String //browser)
	{
//		if (browser.equalsIgnoreCase("chrome"))
//		{
//			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/chrome/chromedriver.exe");
//		    driver= new ChromeDriver();
//		}
//		else if (browser.equalsIgnoreCase("firefox")) 
//		{
//			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/firefox/geckodriver.exe");
//		    driver= new FirefoxDriver();
//		}
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/chrome/chromedriver.exe");
	    driver= new ChromeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();	
		e_driver= new EventFiringWebDriver(driver);
		wBELisener = new WedDriverEventListener_Example();
		e_driver.register(wBELisener);
		driver= e_driver;
		action=new Actions(driver);
		
	}

}