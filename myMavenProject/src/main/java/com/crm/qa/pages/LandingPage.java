package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;
import com.crm.qa.base.TestBase;
import com.crm.qa.utility.ExtentReports.ExtentTestManager;

public class LandingPage extends TestBase {
	
	public LandingPage()
	{

	PageFactory.initElements(driver, this);
	
	}
	
	@FindBy (xpath="//ul[@class='rd-navbar-nav']//child::span[contains(text(),'Log In')]")
	WebElement login;
	
	//Actions
	
	public LoginPage clickLoginButton()
	{
		WebDriverWait wait = new WebDriverWait(driver,3);
		wait.until(ExpectedConditions.visibilityOf(login));
		login.click();
		return new LoginPage();
		
	}
}
