package com.Test.pageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.Test.utilities.WaitingMethods;

public class Payment 
{

	public Payment(WebDriver driver, WebDriverWait wait) {
		//super();
		this.driver = driver;
		this.wait = wait;
	}
	WebDriver driver;
	WebDriverWait wait;
	
	private By xpath_verifyTitle= By.xpath(".//div[@class='summary container']/div/span");
	private By xpath_creditCardForm= By.xpath(".//h4[@class='fa fa-credit-card fa-2x']");
	private By xpath_cardName= By.xpath(".//form[@id='payment-form']//input[@name='cardname']");
	private By xpath_cardNo= By.xpath(".//form[@id='payment-form']//input[@name='cardno']");
	private By xpath_expiryMonth= By.xpath(".//form[@id='payment-form']//input[@name='expmonth']");
	private By xpath_expiryYear= By.xpath(".//form[@id='payment-form']//input[@name='expyear']");
	private By xpath_cvvNo= By.xpath(".//form[@id='payment-form']//input[@name='cvvno']");
	private By xpath_emailId= By.xpath(".//form[@id='payment-form']//input[@name='txtEmail']");
	private By xpath_paymentButton= By.xpath(".//form[@id='payment-form']//button[@id='paylimit']");	
	
	public String VerifyPaymentPage()
	{
		return WaitingMethods.waitElementTillVisibility(xpath_verifyTitle, wait).getText();
		//String v="Recarga   Recarga Saldo   de Telcel   al número 5523261151   de   $10 pesos";
	}
	
	public void clickForCreditCardPayment()
	{
		WaitingMethods.waitElementTillVisibility(xpath_creditCardForm, wait).click();
	}
	
	public void enterCardNameHolder(String name)
	{
		WaitingMethods.waitElementTillVisibility(xpath_cardName, wait).sendKeys(name);
	}
	
	public void enterCardNumber(String number)
	{
		WaitingMethods.waitElementTillVisibility(xpath_cardNo, wait).sendKeys(number);
	}
	
	public void enterExpiryMonth(String expiryMonth)
	{
		WaitingMethods.waitElementTillVisibility(xpath_expiryMonth, wait).sendKeys(expiryMonth);
	}
	
	public void enterExpiryYear(String expiryYear)
	{
		WaitingMethods.waitElementTillVisibility(xpath_expiryYear, wait).sendKeys(expiryYear);
	}
	
	public void enterCVVNumber(String cvvNumber)
	{
		WaitingMethods.waitElementTillVisibility(xpath_cvvNo, wait).sendKeys(cvvNumber);
	}
	
	public void enterEmailId(String email)
	{
		WaitingMethods.waitElementTillVisibility(xpath_emailId, wait).sendKeys(email);
	}
	
	public void clickPaymentButton()
	{
		WaitingMethods.waitElementTillClickable(xpath_paymentButton, wait).click();
	}
}
