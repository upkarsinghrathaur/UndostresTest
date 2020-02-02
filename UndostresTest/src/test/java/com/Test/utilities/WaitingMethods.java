package com.Test.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitingMethods 
{
	public static WebElement waitElementTillVisibility(By element, WebDriverWait wait)
	{
		WebElement waitingelement= wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		return waitingelement;
	}
	
	public static WebElement waitElementTillClickable(By element, WebDriverWait wait)
	{
		WebElement waitingelement= wait.until(ExpectedConditions.elementToBeClickable(element));
		return waitingelement;
	}

}
