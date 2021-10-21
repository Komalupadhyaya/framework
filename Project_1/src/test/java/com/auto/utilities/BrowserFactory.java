package com.auto.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory {

	
	
	public static WebDriver startApplication(WebDriver driver, String browserName,String appURL)
	{
		
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe");
			driver=new ChromeDriver();
			//driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		}
		
		else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","./Driver/geckodriver.exe");
			driver=new ChromeDriver();
			//driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);	
			}
		
		else
		{
			System.out.println("We do not Support this browser");
		}
		
		driver.manage().window().maximize();
		driver.get(appURL);
		//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		return driver;
	}
	
	public static void quitBrowser(WebDriver driver)
	{
		
		//driver.quit();
	}
	
		
}
