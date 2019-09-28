package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Reporter;
import com.crm.qa.utility.TestUtil;

public class TestBase {
	
	static public WebDriver driver;
	static public Properties prop;
	
	public TestBase()
	{
		
		try {
		prop=new Properties();
			FileInputStream ip = new FileInputStream("./Configuration/config.property");
			
			prop.load(ip);
			
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			}
	}
	
	public static void initialization()
	{
		
		String browser_name = prop.getProperty("browser");
		//System.out.println("Browser name is:"+browser_name);
		
		if(browser_name.equalsIgnoreCase("chrome")) 
		{     
			System.out.println("Browser-name is:"+browser_name);
			System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
			//System.setProperty("webdriver.chrome.driver","D:\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
			
			System.out.println("Chrome driver thread-id is:"+Thread.currentThread().getId());
		}
		 
		else if (browser_name.equalsIgnoreCase("firefox"))
			{
			
			System.out.println("Browser-name is:" + browser_name);
			System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.setCapability("marionette", true);
			driver = new FirefoxDriver(firefoxOptions);
				 
			System.out.println("Firefox driver thread-id is:"+Thread.currentThread().getId());
			}
		
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);                                  
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	 
	//driver.navigate().to(prop.getProperty("url"));
	
	driver.navigate().to(prop.getProperty("url"));
	
	Reporter.log("Launching broswer now",true);
	
	}
	
}
