package com.auto.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.auto.utilities.BrowserFactory;
import com.auto.utilities.ExcelDataProvider;
import com.auto.utilities.configDataProvider;
import com.auto.utilities.helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;



public class BaseClass {
	
	public WebDriver driver;
	public ExcelDataProvider excel;
	public configDataProvider config;
	public static ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setUpSuite()
	{
		Reporter.log("Setting up reports and test started", true);
		
		excel=new ExcelDataProvider();
		config=new configDataProvider();
		
		ExtentHtmlReporter extent=new ExtentHtmlReporter(new File("user.dir")+"/Report/Veruna_"+helper.getCurrentDateTime()+".html");
		report=new ExtentReports();
		report.attachReporter(extent);
		
		Reporter.log("Setting Completed- Test can be started", true);
	}
	
	@BeforeClass
	public void setup()
	{
		Reporter.log("Trying to start browser and getting application ready", true);
		
		driver=BrowserFactory.startApplication(driver, config.getBrowser(), config.getStagingURL());	
		
		Reporter.log("Browser and application is up and running", true);
	}
	
	@AfterClass
	public void teardown() {
		
		BrowserFactory.quitBrowser(driver);	
	}
	
	@AfterMethod 
	public void tearDowmMethod(ITestResult result) throws IOException 
	{
	if(result.getStatus()==ITestResult.FAILURE)	
	{
		helper.CaptureScreenshots(driver);
	
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath("helper.CaptureScreenshots(driver)").build());
		}
	else if(result.getStatus()==ITestResult.SUCCESS)
	{
		logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath("helper.CaptureScreenshots(driver)").build());	
	}
		
	report.flush();	
	
	Reporter.log("Test Completed and Reports are generated", true);
	
	}
}
	
