package com.crm.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase
{

	public LoginPage() {
		
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(name="email")
	WebElement email_address;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[contains(text(),'Login')]")
	WebElement loginbutton;
	
	//Actions
	
	public String verifyLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	
	public HomePage login(String email, String pass) throws InterruptedException 
	{
		
		WebDriverWait wait = new WebDriverWait(driver,4);
		wait.until(ExpectedConditions.visibilityOf(email_address)); 
		
		email_address.sendKeys(email);
		Thread.sleep(3000);
		password.sendKeys(pass);
		Thread.sleep(3000);
		
		loginbutton.click();
		return new HomePage();
	}
	
}
