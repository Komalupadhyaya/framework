package com.auto.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class helper {
	
	//To handle screenshots,frames,alerts,multiple windows,Sync issues, javascript executer.
	
	public static String CaptureScreenshots(WebDriver driver)   //After Testing Capture Screenshot
	{
	File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	String screenshotPath = System.getProperty("user.dir")+"./Screenshot/Veruna_" + getCurrentDateTime() + ".png";
	 
	try {
		FileHandler.copy(src, new File(screenshotPath));
		System.out.println("Screenshot is Captured");
		
	} catch (IOException e) {
		System.out.println("Unable to capture Screenshot"+e.getMessage());
	}
	return screenshotPath;
	}
	
	public static String getCurrentDateTime()
	{
		DateFormat customFormat=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate=new Date();
	return customFormat.format(currentDate);
	}
	
	public void handleAlerts()
	{
		
	}

}
