package com.crm.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.crm.qa.base.TestBase;
import com.crm.qa.utility.*;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath="//table[@class='ui celled sortable striped table custom-grid']/tbody/tr/td[contains(text(),'Mamta Sharma')]")
	WebElement contactsname;
	
	@FindBy(xpath="//div[@class='item']"
			+ "//child::a/button[contains(text(),'New')]")
	WebElement newContactButton;
	
	@FindBy (xpath="//form[@class='ui form segment custom-form-container']"
			+ "//child::div[@class='two fields']//child::*/input[@name='first_name']")
	WebElement firstName;
	
	@FindBy (xpath="//form[@class='ui form segment custom-form-container']//child::div[@class='two fields']"
			+ "//child::*/input[@name='last_name']")
	WebElement lastName;
	
	@FindBy (xpath="//form[@class='ui form segment custom-form-container']//child::div[@class='two fields']//child::*/input[@class='search']")
	WebElement companyName;
	
	@FindBy (xpath="//form[@class='ui form segment custom-form-container']//child::div[@class='two fields']//child::*/div[@class='field']/label[contains(text(),'Time Zone')]//parent::*//child::input[@class='search']")
	WebElement timeZone;
	
	@FindBy (xpath="//form[@class='ui form segment custom-form-container']//child::div[@class='two fields']//child::*/div[@class='field']/label[contains(text(),'Phone')]//parent::*//child::*//child::input[@class='search']")
	WebElement countryCode;
	
	@FindBy (xpath="//form[@class='ui form segment custom-form-container']//child::div[@class='two fields']//child::*/div[@class='field']/label[contains(text(),'Phone')]//parent::*//child::*/div[@class='ui input']/input[@placeholder='Number' and @name='value']")
	WebElement phoneNo;
	
	@FindBy (xpath="//form[@class='ui form segment custom-form-container']//child::div[@class='two fields']//child::*/div[@class='field']/label[contains(text(),'Department')]//parent::*/child::*/input[@name='department']")
	WebElement departMent;
	
	@FindBy (xpath="//form[@class='ui form segment custom-form-container']//child::div[@class='two fields']//child::*/div[@class='field']/label[contains(text(),'Department')]")
	WebElement department_label;
	
	@FindBy (xpath="//form[@class='ui form segment custom-form-container']//child::div[@class='two fields']//child::*/div[@class='field']/label[contains(text(),'Status')]//parent::*/child::*/div[contains(text(),'Select')]")
	WebElement status;
	
	@FindBy (xpath="//div[@id='ui']//child::*/div[@class='item']/button[contains(text(),'Save')]")
	WebElement contact_save;  //Contacts save button
	
	@FindBy(xpath="//div[@id='main-nav']//child::a/span[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	
	public String contactsNameVerification()
	{
		System.out.println("ContactsPage: contactsNameVerification func");
		
		return contactsname.getText();
	}
	

	public void clickNewContactButton() throws InterruptedException
	{
		System.out.println("ContactsPage: clickNewContactButton func");
		//driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver, 4);
		wait.until(ExpectedConditions.visibilityOf(newContactButton)).click();
	//newContactButton.click();
		TestUtil.explicitWait();
	}
	
	public void createNewCotact(String first_name, String last_name, String company_name, String timezone, String countrycode, String phone_no, String department, String status_val)
	{
		
		WebElement timezone_value = driver.findElement(By.xpath("//form[@class='ui form segment custom-form-container']//child::div[@class='two fields']//child::*/div[@class='field']"
				 + "/label[contains(text(),'Time Zone')]//parent::*//child::*/div[@role='option']/span[contains(text(),'"+timezone+"')]"));
		
		WebElement countrycode_value = driver.findElement(By.xpath("//form[@class='ui form segment custom-form-container']//child::div[@class='two fields']//child::*/div[@class='field']/"
				+ "label[contains(text(),'Phone')]//parent::*//child::*/div[@class='item']/span[contains(text(),'"+countrycode+"')]"));
		
		List<WebElement> status_options = driver.findElements(By.xpath("//form[@class='ui form segment custom-form-container']//child::div[@class='two fields']//child::*/div[@class='field']/label[contains(text(),'Status')]//parent::*/child::*//span[@class='text']"));
		
		//int phone_no1=Integer.parseInt(phone_no);
		WebDriverWait wait = new WebDriverWait(driver,4);
		wait.until(ExpectedConditions.visibilityOf(firstName)).sendKeys(first_name);
		//firstName.sendKeys(first_name);
		
		lastName.sendKeys(last_name);
		
		companyName.sendKeys(company_name);
		TestUtil.explicitWait();
		
		timeZone.click();
		timeZone.sendKeys(timezone);
		timezone_value.click();
		
		
	/*	TestUtil.scrollWindow(driver, countryCode);
		
		countryCode.sendKeys(countrycode);
		countrycode_value.click();
		TestUtil.explicitWait();
		System.out.println("Entered value in Countrycode field");
			
		phoneNo.sendKeys(phone_no);
		System.out.println("Entered value in phone field");
		
		TestUtil.explicitWait();
		
		System.out.println("Entering value in Department field");
		
	  Actions act = new Actions(driver);
	  Action act1 =  act.moveToElement(department_label).click().sendKeys(department).build();
	  act1.perform();
		//Action act1 = act.moveToElement(departMent).sendKeys(department).build();
		//act1.perform(); 
		TestUtil.explicitWait();  */
		
		TestUtil.scrollWindow(driver, countryCode); 
		
		TestUtil.explicitWait();
		
		departMent.click();
		departMent.sendKeys(department);
		
		//TestUtil.scrollWindow(driver, status); 
		
		TestUtil.explicitWait();
		
		status.click();
		TestUtil.explicitWait();
		for(WebElement option: status_options)
		  {
			if(status_val.equalsIgnoreCase(option.getText()))
			{
				option.click();
				break;
			}
					
		  }
		TestUtil.explicitWait();
		contact_save.click();
		
		TestUtil.explicitWait();
		
		contactsLink.click();
		
		TestUtil.explicitWait();
		
		wait = new WebDriverWait(driver,4);
		wait.until(ExpectedConditions.visibilityOf(newContactButton));
		newContactButton.click();
		
		
	    }
	
}
