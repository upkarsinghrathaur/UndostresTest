package com.Test.pageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.Test.utilities.SelectDropdown;
import com.Test.utilities.WaitingMethods;


public class RecargaCelular {

	public RecargaCelular(WebDriver driver, WebDriverWait wait) {
		//super();
		this.driver = driver;
		this.wait = wait;
	}
	WebDriver driver;
	WebDriverWait wait;
	
	private By xpath_recargaMenuClick= By.xpath(".//a[@href='#recharge']");
	private By xpath_operador= By.xpath(".//div[@to-do='mobile']//input[@name='operator']");
	private By xpath_number= By.xpath(".//div[@to-do='mobile']//input[@name='mobile']");
	private By xpath_montodeRecarga= By.xpath(".//div[@to-do='mobile']//input[@name='amount']");
	private By xpath_siguiente= By.xpath(".//div[@to-do='mobile']//button[@perform='payment']");
	
	public void clickRecargasCelularMenu()
	{
		WaitingMethods.waitElementTillClickable(xpath_recargaMenuClick, wait).click();
	}
	public void selectOperador(String operadorValue)
	{
		WaitingMethods.waitElementTillVisibility(xpath_operador, wait).click();
		SelectDropdown.selectValuefromSuggestionList(operadorValue, driver, wait);
	}
	
	public void enterNumber(String cellNumber)
	{
		WaitingMethods.waitElementTillVisibility(xpath_number, wait).sendKeys(cellNumber);;
	}
	
	public void selectMonthRechargePrice(String rechargeValue)
	{
		WaitingMethods.waitElementTillVisibility(xpath_montodeRecarga, wait).click();
		SelectDropdown.selectRechargeFromList(rechargeValue, driver, wait);
	}
	
	public void clickSiguiente()
	{
		WaitingMethods.waitElementTillClickable(xpath_siguiente, wait).click();
	}
}
