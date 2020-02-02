package com.Test.setUp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory
{
	public static WebDriver driver;
	public static WebDriver getBrowser(String browserType)
	{
		if(driver==null)
		{
			if(browserType.equalsIgnoreCase("FF"))
			{
				System.setProperty("webdriver.gecko.driver", "C:\\Intel\\geckodriver.exe");
				driver= new FirefoxDriver();
			}
			else if(browserType.equalsIgnoreCase("GC"))
			{
				System.setProperty("webdriver.chrome.driver", "C:\\Intel\\chromedriver.exe");
				driver= new ChromeDriver();
			}
			else if(browserType.equalsIgnoreCase("IE"))
			{
				driver= new InternetExplorerDriver();
			}
		}
	
	return driver;
}
}
