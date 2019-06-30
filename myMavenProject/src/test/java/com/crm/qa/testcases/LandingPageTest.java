package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LandingPage;
import com.crm.qa.pages.LoginPage;

import net.bytebuddy.dynamic.NexusAccessor.InitializationAppender;

public class LandingPageTest extends TestBase {
	
	LandingPage landingpage;
	LoginPage loginpage;
	
	public LandingPageTest()
	{
	super();
	}
	
	@BeforeSuite
	public void setUp()
	{
		initialization();
		landingpage = new LandingPage();
	}
	
	@Test
	public void loginButton()
	{
		loginpage = landingpage.clickLoginButton();
	}
	
	 @AfterSuite
     public void tearDown()
     {
		 System.out.println("Closing the browser");
     driver.quit();
     }
	
}
