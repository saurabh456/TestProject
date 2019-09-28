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

	@FindBy(xpath="//li[@class='nav-item']/a[text()='Login']")
	WebElement loginLink;
	
	@FindBy(xpath="//li[@class='nav-item']//child::div[@class='card-body']/input[@name='password']")
	WebElement username;
	
	@FindBy(xpath="//li[@class='nav-item']//child::div[@class='card-body']/input[@name='username']")
	WebElement password;
	
	@FindBy(xpath="//li[@class='nav-item']//child::div[@class='card-body']/button[text()='Login']")
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
