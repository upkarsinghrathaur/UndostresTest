package com.Test.testCases;

import java.util.Hashtable;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Test.pageObject.Acceso;
import com.Test.pageObject.Payment;
import com.Test.pageObject.RecargaCelular;
import com.Test.setUp.BaseTest;
import com.Test.utilities.DataUtil;

public class CreateRechargeTest extends BaseTest
{
	RecargaCelular recharge;
	Payment payment;
	Acceso login;
	
  @Test(dataProviderClass=DataUtil.class, dataProvider="excelData")
  public void verifyTelecelRecharge(Hashtable<String, String> data) 
  {
	  softAssert= new SoftAssert();
	  recharge= new RecargaCelular(driver, wait);
	  payment= new Payment(driver, wait);
	  login= new Acceso(driver, wait);
	  recharge.clickRecargasCelularMenu();
	  recharge.selectOperador(data.get("operador"));
	  recharge.enterNumber(data.get("number"));
	  recharge.selectMonthRechargePrice(data.get("recarga"));
	  recharge.clickSiguiente();
	  //this assert will verify the the heading of payment page
	  softAssert.assertEquals(payment.VerifyPaymentPage(), "Recarga   Recarga Saldo   de "+data.get("operador")+"   al número "+data.get("number")+"   de   $"+data.get("recarga")+" pesos");
	  payment.enterCardNameHolder(data.get("cardHolderName"));
	  payment.enterCardNumber(data.get("cardNumber"));
	  payment.enterExpiryMonth(data.get("expiryMonth"));
	  payment.enterExpiryYear(data.get("expiryYear"));
	  payment.enterCVVNumber(data.get("cvvNumber"));
	  payment.enterEmailId(data.get("emailId"));
	  payment.clickPaymentButton();
	  login.enterUserName(data.get("userName"));
	  login.enterPassword(data.get("password"));
	  login.verifyCaptcha();
	  login.clickLoginButton();
	  //Verify message if appear
	  //for now i'm not getting any success message i'm getting this alert message-(Correo/Movil o contraseña no válido!)
	  softAssert.assertAll();
  }
}
