package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LandingPage extends TestBase {
	
	public LandingPage()
	{

	PageFactory.initElements(driver, this);
	
	}
	
	@FindBy (xpath="//ul[@class='rd-navbar-nav']//span[contains(text(),'Log In')]")
	WebElement login;
	
	//Actions
	
	public LoginPage clickLoginButton()
	{
		login.click();
		return new LoginPage();
	}
}
