package com.crm.qa.testcases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.utility.TestUtil;

import junit.framework.Assert;

public class ContactsPageTest extends TestBase
{
	ContactsPage contactspage;
	String sheet_name="Conctacts";
	
	public ContactsPageTest()
	{
	//contactspage = new ContactsPage();
	}
	
  	@Test(priority=1, description="Scenario to verify contact name")
	public void contactsNameVerificationTest() throws InterruptedException
	{
		contactspage = new ContactsPage();
		String contacts_name=contactspage.contactsNameVerification();
		System.out.println("Is String Empty:"+contacts_name.isEmpty());
		System.out.println("The name of the Contacts is:"+contacts_name);
		
		Assert.assertEquals("Contacts Name fails to match", "Mamta Sharma", contacts_name);
		
		System.out.println("Contact Names matches");
	}
	
 	@Test(priority=2)
	public void cickNewContactButtonTest() throws InterruptedException
	{
		contactspage.clickNewContactButton();
	}
	
	@DataProvider
	public Object[][] getCRMTestData()
	{
		System.out.println("In the getCRMTestData method");
		Object data[][] = TestUtil.getTestData(sheet_name);
		System.out.println("Data is retrieved successfully");
		return data;
	}
	
  	@Test(priority=3, dataProvider="getCRMTestData")
	public void createNewContactTest(String first_name, String last_name, String company, String time_zone, String country_code, String phone_no, String department, String status)
	{
		
		contactspage.createNewCotact(first_name, last_name, company, time_zone, country_code, phone_no, department, status );
	}
	
}
