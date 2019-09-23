package com.crm.qa.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	
	/* public LoginPageTest() throws IOException
	{
	} */
	
  /*	@BeforeTest
	public void setUp() throws IOException
	{
		// initialization();
		
		
	} */
	
	@Test (priority=0)
	public void loginPageTitleTest()
	{
		loginpage = new LoginPage();
		//driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		Reporter.log("Verifying LoginPageTitle now", true);
		String title = loginpage.verifyLoginPageTitle();
		
		Assert.assertEquals(title, "CRM","Titles doesn't matches");
		System.out.println("The titles are matched");
	}
	
	@Test (priority=1, alwaysRun=true)
	public void loginTest()
	{
		Reporter.log("Log-in to Applicaton now");
		try {
			homepage = loginpage.login(prop.getProperty("email_address"), prop.getProperty("password"));
			
			if(homepage !=null)
			{
				System.out.println("HomePage gets loaded successfully");	
			}
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
