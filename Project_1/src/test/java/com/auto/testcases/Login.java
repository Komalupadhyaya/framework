package com.auto.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.auto.pages.BaseClass;
import com.auto.pages.LoginPage;
import com.auto.utilities.BrowserFactory;
import com.auto.utilities.ExcelDataProvider;
import com.auto.utilities.helper;

public class Login extends BaseClass {
	
	@Test
	public void LoginApp() {
		
	logger=report.createTest("Login To Veruna");	
		
	LoginPage LoginPage=PageFactory.initElements(driver,LoginPage.class);
	
	logger.info("Strting Application");
	
	LoginPage.LogintoPage(excel.getStringData("Accounts",0,0),excel.getStringData("Accounts",1,0));
	
	logger.pass("Login Sucessful");
	
	helper.CaptureScreenshots(driver);
	
		}
	}
