package Implementation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CDNDLCPaymentpgeobjct
{

	  
	//For payment details
	    @FindBy(xpath="//*[@id='_ctl0_MainContentsPH__ctl0_CreditCardInfo_cardType']")
	    private WebElement slctcarttype;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_CreditCardInfo_cardNumber")
	    private WebElement cardno;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_CreditCardInfo_cardCCV")
	    private  WebElement crdcvv;
	    
	    @FindBy(xpath="//*[@id='_ctl0_MainContentsPH__ctl0_CreditCardInfo_expireDate_Month']")
	    private WebElement selectmonth;
	    
	    @FindBy(xpath="//*[@id='_ctl0_MainContentsPH__ctl0_CreditCardInfo_expireDate_Year']")
	    private WebElement selectyear;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_CreditCardInfo_cardHolderName")
	    private WebElement cardholdernme;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_BillingAddress_AddrLine1")
	    private WebElement address;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_BillingAddress_CityInput")
	    private WebElement slectcity;
	    
	    @FindBy(xpath="//*[@id='_ctl0_MainContentsPH__ctl0_BillingAddress_StateSel']")
	    private WebElement slectstate;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_BillingAddress_ZipCodeInput")
	    private WebElement zipcde;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_BillingAddress_PhoneInput_Number")
	    private WebElement billingphone;
	    
	    @FindBy(xpath="//*[@id='_ctl0_MainContentsPH__ctl0_BillingAddress_BankNameTXT']")
	    private WebElement banknme;
	    
	    //For Terms And Condition
	    @FindBy(xpath="//*[@id='AgreeTermsCHK']")
	    private WebElement termsncndtn; 
	    
	    // For Continue Booking Button
	    @FindBy(xpath="//*[@id='_ctl0_MainContentsPH__ctl0_ContinueLNK']")
	    private WebElement ClickonContinuebtn;
	    
	    
	    public void CDNDLCPaymentToTitle(String crdn, String crdcvvno, String crdhldrnm)
		{
		    	try
		    	{
		    	
					slctcarttype.click();
					Thread.sleep(500);
					slctcarttype.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_CreditCardInfo_cardType']/option[5]")).click();
					Thread.sleep(500);  
					cardno.click();
					Thread.sleep(300);
					cardno.sendKeys(crdn);
					Thread.sleep(500);
					crdcvv.click();
					Thread.sleep(300);
					crdcvv.sendKeys(crdcvvno);
					Thread.sleep(500);
					selectmonth.click();
					Thread.sleep(300);
					selectmonth.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_CreditCardInfo_expireDate_Month']/option[8]")).click();
					Thread.sleep(500);
					selectyear.click();
					Thread.sleep(300);
					selectyear.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_CreditCardInfo_expireDate_Year']/option[7]")).click();
					Thread.sleep(500);
					cardholdernme.click();
					Thread.sleep(300);
					cardholdernme.sendKeys(crdhldrnm);
					Thread.sleep(1000);
					billingphone.sendKeys(Keys.TAB);
					Thread.sleep(1000);
			//		banknme.clear();
			//		Thread.sleep(300);
			//		banknme.click();
			//		Thread.sleep(300);
			//		banknme.sendKeys(bnknm);
			//		Thread.sleep(500);
			//		termsncndtn.click();
			//		Thread.sleep(1000);
			//		ClickonContinuebtn.click();
			//		Thread.sleep(2000);
					
		    	}
		    	catch(Exception e)
		    	{
		    		
						     e.printStackTrace();
					     
		    	}
		  }
	
}
