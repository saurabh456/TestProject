package com.org.learningMaven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crm.qa.configuration.ConfigConnect;

import junit.framework.Assert;

/**
 * Hello world!
 *
 */
public class MavenTest 
{
	static WebDriver driver;
	ConfigConnect con;
	
	@BeforeTest
	public void setup() {
		
		try {
			con = new ConfigConnect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error is"+e.getMessage());
		}
	}
	
	@Test
	public void open() {
		
        System.out.println( "Hello Maven!" );
     
        
       System.setProperty("webdriver.chrome.driver", con.getChromePath());
    	driver=new ChromeDriver();
    	
    	driver.get(con.getUrl());
    	
    	   Reporter.log("Launching the Chrome Browser");
    	
    	driver.manage().window().maximize();//for maximizing the window
    	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
    	
    	System.out.println(driver.getTitle());
    	
    	
    	
    	try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	
    	Assert.assertTrue(driver.getTitle().contains("Go"));
    	
    }

@AfterMethod
public void teardown() {
	
	driver.quit();
}
}
