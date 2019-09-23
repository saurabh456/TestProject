package com.crm.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;
import com.crm.qa.utility.TestUtil;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//div[@class='ui fluid container']/div[@id='top-header-menu']/div[@class='right menu']/span[contains(text(),'Saurabh Verma')]")
	WebElement userName;
	
	@FindBy (xpath="//div[@class='summary']/child::*/a[contains(text(),'Mamta')]")
	WebElement contactsName;
	
	@FindBy(xpath="//div[@id='main-nav']//child::a/span[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	public HomePage() 
	{
		
		PageFactory.initElements(driver, this);

	}
	//Actions
	
	public boolean verifyUserName()
	{
		System.out.println("Verifying user-name in the HomePage");
		return userName.isDisplayed();
	}
	
	public Boolean contactsNameVerification()
	{
		System.out.println("In the contactsNameVerification methods");
		
		if(contactsName.isDisplayed())
		{
			System.out.println("The Contacts Name at HomePage is:"+contactsName.getText());
			
		}
		return contactsName.isDisplayed();
	}
	
	public ContactsPage clickContactsLink()
	{
		System.out.println("In the ContactsLink() method, clicking contactsLink on the Page");
		
		//driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOf(contactsLink));
	
		contactsLink.click();
		TestUtil.explicitWait();
		return new ContactsPage();
	}

}
