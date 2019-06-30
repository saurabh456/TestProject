package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//div[@class='right menu']//span[contains(text(),'Saurabh Verma')]")
	WebElement userName;
	
	@FindBy (xpath="//div[@class='summary']/child::*/a[contains(text(),'Mamta')]")
	WebElement contactsName;
	
	public HomePage() 
	{
		
		PageFactory.initElements(driver, this);

	}
	//Actions
	
	public boolean verifyUserName()
	{
		return userName.isDisplayed();
	}
	
	public Boolean contactsNameVerification()
	{
		if(contactsName.isDisplayed())
		{
			System.out.println("The Contacts Name at HomePage is:"+contactsName.getText());
			
		}
		return contactsName.isDisplayed();
	}
	
	public ContactsPage clickContactsName()
	{
		contactsName.click();
		return new ContactsPage();
	}

}
