package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import com.crm.qa.utility.TestUtil;

public class TestBase {
	
	static public WebDriver driver;
	static public Properties prop;
	
	public TestBase()
	{
		
		try {
		prop=new Properties();
			FileInputStream ip = new FileInputStream("F:\\selenium_1\\myMavenProject\\Configuration\\config.property");
			
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
	
	public static void initialization() {
		String browser_name = prop.getProperty("browser");
		
		if(browser_name.equalsIgnoreCase("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver",prop.getProperty("ChromeDriverPath"));
			driver = new ChromeDriver();
		}
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	
	driver.navigate().to(prop.getProperty("url"));
	Reporter.log("Launching broswer now");
	
	}
	
	
	
	
	
}
