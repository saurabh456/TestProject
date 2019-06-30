package com.crm.qa.testcases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;

import junit.framework.Assert;

public class ContactsPageTest extends TestBase
{
	ContactsPage contactspage;
	
	public ContactsPageTest()
	{
	//contactspage = new ContactsPage();
	}
	
	@Test
	public void contactsNameVerificationTest() throws InterruptedException
	{
		contactspage = new ContactsPage();
		String contacts_name=contactspage.contactsNameVerification();
		System.out.println("Is String Empty:"+contacts_name.isEmpty());
		System.out.println("The name of the Contacts is:"+contacts_name);
		
		Assert.assertEquals("Contacts Name fails to match", "Mamta Sharma", contacts_name);
		
		System.out.println("Contact Names matches");
	}
}
