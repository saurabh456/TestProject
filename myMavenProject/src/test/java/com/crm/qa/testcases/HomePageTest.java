package com.crm.qa.testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;


public class HomePageTest extends TestBase {
	
	HomePage homepage;
	ContactsPage contactspage;
	
	public HomePageTest()
	{
		//homepage = new HomePage();
	}

  /*	@BeforeTest
	public void setUp() throws IOException
	{
		//initialization();
	} */
	
	@Test(priority=0)
	public void userNameVerificationTest()
	{
		homepage = new HomePage();
		
		Boolean flag = homepage.verifyUserName();
		
		Assert.assertTrue(flag);
		System.out.println("User logs-in successfully");
		Reporter.log("User's Name is now visible");
	}
		
		@Test(priority=1)
		public void contactsNameVerifyTest()
		{
			Boolean flag1 = homepage.contactsNameVerification();
			System.out.println("At Home-Page, Contact's Name is visible:"+ flag1);
			Assert.assertTrue(flag1);
			
			System.out.println("contact Name is visible");
		}
		
		@Test(priority=2, alwaysRun=true)
		public void clickContactsLinkTest()
		{
			//driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			contactspage = homepage.clickContactsLink();
			
		}
		
	}
	
