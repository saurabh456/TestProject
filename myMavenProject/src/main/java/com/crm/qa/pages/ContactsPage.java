package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath="//div[contains(@class,'ui header item mb5 light-black')]")
	WebElement contactsname;
	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public String contactsNameVerification()
	{
		return contactsname.getText();
	}
	

}
