package com.auto.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	 WebDriver driver;
	
	
public LoginPage(WebDriver driver)
{
	
	this.driver=driver;
}
	@FindBy(xpath="//*[@id=\"username\"]") WebElement uname;
	@FindBy(xpath="//*[@id=\"password\"]") WebElement pass;
	@FindBy(xpath="//*[@id=\"Login\"]") WebElement loginButton;

public void LogintoPage(String username,String password) {
	
	try
	{
	Thread.sleep(2000);
	}
	catch(InterruptedException e)
	{
			
	}

	uname.sendKeys(username);
	pass.sendKeys(password);
	loginButton.click();
	
}


}
