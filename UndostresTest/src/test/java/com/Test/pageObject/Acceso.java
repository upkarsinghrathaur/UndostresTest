package com.Test.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Test.utilities.WaitingMethods;

public class Acceso 
{
	public Acceso(WebDriver driver, WebDriverWait wait) {
		//super();
		this.driver = driver;
		this.wait = wait;
	}
	WebDriver driver;
	WebDriverWait wait;
	
	private By xpath_userName= By.xpath(".//input[@id='usrname']");
	private By xpath_password= By.xpath(".//input[@id='psw']");
	private By xpath_loginButton= By.xpath(".//button[@id='loginBtn']");
	private By xpath_captcha= By.xpath("//*[@id='recaptcha-anchor']/div[1]");
	
	public void enterUserName(String userName)
	{
		WaitingMethods.waitElementTillVisibility(xpath_userName, wait).sendKeys(userName);
	}
	
	public void enterPassword(String password)
	{
		WaitingMethods.waitElementTillVisibility(xpath_password, wait).sendKeys(password);
	}
	
	public void clickLoginButton()
	{
		WaitingMethods.waitElementTillClickable(xpath_loginButton, wait).click();
	}
	
	public void verifyCaptcha()
	{
		driver.switchTo().frame(0);
		WaitingMethods.waitElementTillClickable(xpath_captcha, wait).click();
		driver.switchTo().parentFrame();		
	}

}
