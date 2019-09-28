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
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LandingPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utility.ExtentReports.ExtentTestManager;

import net.bytebuddy.dynamic.NexusAccessor.InitializationAppender;

public class LandingPageTest extends TestBase {
	
	LandingPage landingpage;
	HomePage homepage;
	
	public LandingPageTest()
	{
	super();
	}
	
	@BeforeTest
	public void setUp()
	{
		initialization();
		landingpage = new LandingPage();
	}
	
	@Test (priority=1, description="Clicking on loginLink")
	public void clickLoginLinkTest()
	{
		landingpage.clickLoginLink();
		
		ExtentTestManager.getTest().pass("Succesfully clicked LoginLink button");
		}
	
	@Test (priority=2, description="Performing Log-in activity")
	
	public void loginTest() throws InterruptedException
	{
		
	homepage = landingpage.login(prop.getProperty("username"), prop.getProperty("password"));
	
	if(homepage !=null)
	{
		ExtentTestManager.getTest().pass("Succesfully Logged-in to Application");
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
