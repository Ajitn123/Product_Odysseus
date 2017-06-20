package Implementation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LocalDynamicPackagingAirPayment 
{

	 
	//For payment details
	    @FindBy(xpath="//*[@id='_ctl0_MainContentsPH__ctl0__ctl4_CreditCardInfo_cardType']")
	    private WebElement slctcarttype;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0__ctl4_CreditCardInfo_cardNumber")
	    private WebElement cardno;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0__ctl4_CreditCardInfo_cardCCV")
	    private  WebElement crdcvv;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0__ctl4_CreditCardInfo_expireDate_Month")
	    private WebElement selectmonth;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0__ctl4_CreditCardInfo_expireDate_Year")
	    private WebElement selectyear;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0__ctl4_CreditCardInfo_cardHolderName")
	    private WebElement cardholdernme;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0__ctl4_BillingAddress_AddrLine1")
	    private WebElement address;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0__ctl4_BillingAddress_CityInput")
	    private WebElement slectcity;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0__ctl4_BillingAddress_StateSel")
	    private WebElement slectstate;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0__ctl4_BillingAddress_ZipCodeInput")
	    private WebElement zipcde;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0__ctl4_BillingAddress_PhoneInput_Number")
	    private WebElement billingphone;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0__ctl4_BillingAddress_BankNameTXT")
	    private WebElement banknme;
	    
	    //For Terms And Condition
	    @FindBy(id="AgreeTermsCHK")
	    private WebElement termsncndtn;
	    
	    // For Continue Booking Button
	    @FindBy(xpath="//*[@id='_ctl0_MainContentsPH__ctl0_ContinueLNK']")
	    private WebElement ClickonContinuebtn;
	    
	    

	    
	public void DynamicPaymentToTitle(String crdno, String cardcvvno, String crdhldrnme, String addr, String cty, String zpcd, String phn)
	{
	    	try
	    	{
	    	
				slctcarttype.click();
				Thread.sleep(500);
				slctcarttype.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0__ctl4_CreditCardInfo_cardType']/option[6]")).click();
				Thread.sleep(500);  
				cardno.click();
				Thread.sleep(300);
				cardno.sendKeys(crdno);
				Thread.sleep(500);
				crdcvv.click();
				Thread.sleep(300);
				crdcvv.sendKeys(cardcvvno);
				Thread.sleep(500);
				selectmonth.click();
				Thread.sleep(300);
				selectmonth.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0__ctl4_CreditCardInfo_expireDate_Month']/option[9]")).click();
				Thread.sleep(500);
				selectyear.click();
				Thread.sleep(300);
				selectyear.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0__ctl4_CreditCardInfo_expireDate_Year']/option[7]")).click();
				Thread.sleep(500);
				cardholdernme.click();
				Thread.sleep(300);
				cardholdernme.sendKeys(crdhldrnme);
				Thread.sleep(1000);
				address.clear();
				Thread.sleep(700);
				address.click();
				Thread.sleep(900);
				address.sendKeys(addr);
				Thread.sleep(1000);
				slectcity.click();
				Thread.sleep(700);
				slectcity.sendKeys(cty);
				Thread.sleep(900);
				slectstate.click();
				Thread.sleep(700);
				slectstate.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0__ctl4_BillingAddress_StateSel']/option[3]")).click();
				Thread.sleep(900);
				zipcde.click();
				Thread.sleep(900);
				zipcde.sendKeys(zpcd);
				Thread.sleep(800);
				billingphone.click();
				Thread.sleep(700);
				billingphone.sendKeys(phn);
				Thread.sleep(900);
			//	Thread.sleep(500);
			//	banknme.clear();
			//	Thread.sleep(300);
			//	banknme.click();
			//	Thread.sleep(300);
			//	banknme.sendKeys(bnknme);
				Thread.sleep(500);
				termsncndtn.click();
			//	Thread.sleep(1000);
			//	ClickonContinuebtn.click();
				Thread.sleep(9000);
				
	    	}
	    	catch(Exception e)
	    	{
	    		
					     e.printStackTrace();
				     
	    	}
	  }




	public boolean isDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
	
}