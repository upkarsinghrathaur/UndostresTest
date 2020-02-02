package com.Test.setUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

public class BaseTest 
{
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static SoftAssert softAssert;

	@Parameters({"Browser"})
  @BeforeSuite
  public void launchApplication(String browser) 
	{
		driver= DriverFactory.getBrowser(browser);
		wait= new WebDriverWait(driver, 20);
		driver.get("https://prueba.undostres.com.mx/");
		driver.manage().window().maximize();
  }
	
	@AfterSuite
	public void closeApplication()
	{
		driver.close();
		driver.quit();
	}
}
