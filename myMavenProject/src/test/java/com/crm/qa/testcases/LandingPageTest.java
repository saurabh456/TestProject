package com.crm.qa.testcases;

import static org.testng.Assert.expectThrows;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LandingPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utility.ExtentReports.ExtentTestManager;

import net.bytebuddy.dynamic.NexusAccessor.InitializationAppender;

public class LandingPageTest extends TestBase {
	
	LandingPage landingpage;
	LoginPage loginpage;
	
	public LandingPageTest()
	{
	super();
	}
	
	@Parameters({"browserName","urlToBeTested"})
	@BeforeTest
	public void setUp(String browserName, String urlToBeTested)
	{
		initialization(browserName, urlToBeTested);
		landingpage = new LandingPage();
	}
	
	@Test
	public void loginButtonTest()
	{
		loginpage = landingpage.clickLoginButton();
		
		if(loginpage !=null)
		{
		ExtentTestManager.getTest().pass("Succesfully clicked Submit button");
		}
	}
	
	 @AfterTest
     public void tearDown()
     {
		 if(driver !=null)
		 System.out.println("Closing the browser");
     driver.quit();
     }
	
}
