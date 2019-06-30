package com.crm.qa.testcases;

import java.io.IOException;

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
	public void userNameVerificationTest() throws InterruptedException
	{
		homepage = new HomePage();
		Boolean flag = homepage.verifyUserName();
		
		Assert.assertTrue(flag);
		System.out.println("User logs-in successfully");
		Reporter.log("User's Name is now visible");
	}
		
		@Test (priority=1)
		public void contactsNameVerifyTest() throws InterruptedException
		{
			Thread.sleep(3000);
			Boolean flag1 = homepage.contactsNameVerification();
			System.out.println("At Home-Page, Contact's Name is visible:"+ flag1);
			Assert.assertTrue(flag1);
			
			System.out.println("contact Name is visible");
		}
		
		
		@Test(priority=2, dependsOnMethods="contactsNameVerifyTest")
		public void clickContactsNameTest() throws InterruptedException
		{
			
			contactspage = homepage.clickContactsName();
			Thread.sleep(4000);
			
		}
		
	}
	
