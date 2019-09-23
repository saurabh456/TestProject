package com.crm.qa.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.crm.qa.base.TestBase;
import com.crm.qa.utility.ExtentReports.ExtentManager;
import com.crm.qa.utility.ExtentReports.ExtentTestManager;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class takesScreenshot extends TestBase implements ITestListener 
{
WebDriver driver1=null;

static SimpleDateFormat sdf;

	String file_path=System.getProperty("user.dir")+"/screenShots/";
	
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
		System.out.println("I am in onFinish method:"+context.getName());
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("I am in onStart method:"+context.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) 
	{
		System.out.println("Screenshot directory path is:"+file_path);
		System.out.println(result.getName()+" Method has failed");
		/* ITestContext context1 = result.getTestContext();
	       driver1 = (WebDriver)context1.getAttribute("driver"); */
		
		// Object testClass = result.getInstance();
		driver1 = TestBase.driver;
		captureScreenshot(driver1, result.getMethod().getMethodName());
		
	}
	
	public void captureScreenshot(WebDriver driver2, String methodName)
	{
		File scrFile = ((TakesScreenshot)driver2).getScreenshotAs(OutputType.FILE);
		
		String screenshotPath = file_path+methodName+getCurrentDateTime()+".png";
		
		try {
			FileUtils.copyFile(scrFile, new File(screenshotPath));
			System.out.println("***Placed screen shot in "+file_path+" ***");
		} 
		catch (IOException e) 
		{
			System.out.println("Unable to capture the Screenshot"+e.getMessage());
		}
		
		try {
			ExtentTestManager.getTest().fail("Test got failed", MediaEntityBuilder.createScreenCaptureFromPath("screenshotPath").build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static String getCurrentDateTime()
	{
		sdf = new SimpleDateFormat("dd_MMM_yyyy_hh_mm_ss");
		 
		 String currentDateTime = sdf.format(new Date());
		 System.out.println("Date is:"+currentDateTime);
		 return currentDateTime;
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
		System.out.println("I am in onTestSkipped method:"+result.getMethod().getMethodName()+"TestMethod is skipped");
		
		ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
  System.out.println("I am in onTestStart method:"+result.getMethod().getConstructorOrMethod().getName()+"TestMethod is started");
		
  ExtentTestManager.startTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("I am in onTestSuccess method:"+result.getMethod().getConstructorOrMethod().getName()+"TestMethod is Pass");
		ExtentTestManager.getTest().log(Status.PASS, "Test passed");
	}

}
