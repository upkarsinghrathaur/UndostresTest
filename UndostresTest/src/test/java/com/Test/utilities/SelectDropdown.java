package com.Test.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectDropdown 
{

	public static void selectValuefromSuggestionList(String selectValue, WebDriver driver, WebDriverWait wait)
	{
		WebElement dropdownValue= wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//div[@class='suggestion']/ul/li[@data-show='"+selectValue+"']"))));
		dropdownValue.click();
	}
	
	public static void selectRechargeFromList(String rechargeValue, WebDriver driver, WebDriverWait wait)
	{
		WebElement dropdownValue= wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(".//div[@class='suggestion']/ul[@class='category-list  cat1']/li[@data-name='"+rechargeValue+"']"))));
		dropdownValue.click();
	}
}
