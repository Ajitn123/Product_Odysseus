package Implementation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class LocalCruisePaymentpgeobjct 
{

	 
	   //For payment details
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_CreditCardInfo_cardType")
	    private WebElement slctcarttype;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_CreditCardInfo_MaskedcardNumber")
	    private WebElement cardno; 
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_CreditCardInfo_cardCCV")
	    private  WebElement crdcvv;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_CreditCardInfo_expireDate_Month")
	    private WebElement selectmonth;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_CreditCardInfo_expireDate_Year")
	    private WebElement selectyear;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_CreditCardInfo_cardHolderName")
	    private WebElement cardholdernme;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_BillingAddress_AddrLine1")
	    private WebElement address;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_BillingAddress_CityInput")
	    private WebElement slectcity;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_BillingAddress_StateSel")
	    private WebElement slectstate;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_BillingAddress_ZipCodeInput")
	    private WebElement zipcde; 
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_BillingAddress_PhoneInput_Number")
	    private WebElement billingphone; 
	    
	    @FindBy(xpath="//*[@id='_ctl0_MainContentsPH__ctl0_BillingAddress_BankNameTXT']")
	    private WebElement banknme; 
	    
	    //For Terms And Condition
	    @FindBy(id="AgreeTermsCHK")
	    private WebElement termsncndtn; 
	    
	    // For Continue Booking Button
	    @FindBy(xpath="//*[@id='_ctl0_MainContentsPH__ctl0_ContinueLNK']")
	    private WebElement ClickonContinuebtn; 
	    
	    //For Multicity
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_CreditCardInfo_MaskedcardNumber")
	    private WebElement crdno; 
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_BillingAddress_PhoneInput_MaskedNumber")
	    private WebElement mltiphone; 
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_BillingAddress_MaskedZipCodeInput")
	    private WebElement mltizpcde; 
	    
	    @FindBy(xpath="//*[@id='AgreeTermsCHK']")
	    private WebElement mltitermsncndtn; 
	  
	    //For BPC Cruise
	    @FindBy(xpath="//*[@id='_ctl0_MainContentsPH__ctl0_ContinueLNK']")
	    private WebElement Cruiseconfrm; 
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_BillMailAddress")
	    private WebElement Bilinginfo; 
	    
	  
	    
	public void PaymentToTitle(String crdno, String cardcvvno, String crdhldrnme, String adrs, String cty, String zpcd, String phne, String bnknme)
	{
	    	try
	    	{
	    	
	    		Select select = new Select(slctcarttype.findElement(By.id("_ctl0_MainContentsPH__ctl0_CreditCardInfo_cardType")));
			    select.selectByVisibleText("Visa");  
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
				selectmonth.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_CreditCardInfo_expireDate_Month']/option[8]")).click();
				Thread.sleep(500);
				selectyear.click();
				Thread.sleep(300);
				selectyear.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_CreditCardInfo_expireDate_Year']/option[7]")).click();
				Thread.sleep(500);
				cardholdernme.click();
				Thread.sleep(300);
				cardholdernme.sendKeys(crdhldrnme);
				Thread.sleep(900);
				address.clear();
				Thread.sleep(500);
				address.click();
				Thread.sleep(300);
				address.sendKeys(adrs);
				Thread.sleep(500);
				slectcity.click();
				Thread.sleep(300);
				slectcity.sendKeys(cty);
				Thread.sleep(500);
				slectstate.click();
				Thread.sleep(300);
				slectstate.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_BillingAddress_StateSel']/option[3]")).click();
				Thread.sleep(500);
				zipcde.click();
				Thread.sleep(300);
				zipcde.sendKeys(zpcd);
				Thread.sleep(500);
				billingphone.clear();
				Thread.sleep(300);
				billingphone.click();
				Thread.sleep(300);
				billingphone.sendKeys(phne);
	    		Thread.sleep(500);
				
				if(banknme.isDisplayed())
				{
					banknme.clear();
					Thread.sleep(300);
					banknme.click();
					Thread.sleep(300);
					banknme.sendKeys(bnknme);
					Thread.sleep(500);
				}
				
				termsncndtn.click();
				Thread.sleep(1000);
				ClickonContinuebtn.click();
				Thread.sleep(9000);
				
	    	}
	    	catch(Exception e)
	    	{
	    		
					     e.printStackTrace();
				     
	    	}
	  }
	
	public void CruisePaymentToTitle(String crdno, String cardcvvno, String crdhldrnme, String adrs, String cty, String zpcd, String phne, String bnknme)
	{
	    	try
	    	{
	    	
	    		Select select = new Select(slctcarttype.findElement(By.id("_ctl0_MainContentsPH__ctl0_CreditCardInfo_cardType")));
			    select.selectByVisibleText("Visa");  
				Thread.sleep(1000);  
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
				selectmonth.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_CreditCardInfo_expireDate_Month']/option[8]")).click();
				Thread.sleep(500);
				selectyear.click();
				Thread.sleep(300);
				selectyear.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_CreditCardInfo_expireDate_Year']/option[7]")).click();
				Thread.sleep(500);
				cardholdernme.click();
				Thread.sleep(300);
				cardholdernme.sendKeys(crdhldrnme);
				Thread.sleep(900);
		//		address.clear();
		//		Thread.sleep(500);
		//		address.click();
		//		Thread.sleep(300);
		//		address.sendKeys(adrs);
		//		Thread.sleep(500);
		//		slectcity.click();
		//		Thread.sleep(300);
		//		slectcity.sendKeys(cty);
		//		Thread.sleep(500);
		//		slectstate.click();
		//		Thread.sleep(300);
		//		slectstate.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_BillingAddress_StateSel']/option[3]")).click();
		//		Thread.sleep(500);
		//		zipcde.click();
		//		Thread.sleep(300);
		//		zipcde.sendKeys(zpcd);
		//		Thread.sleep(500);
		//		billingphone.clear();
		//		Thread.sleep(300);
		//		billingphone.click();
		//		Thread.sleep(300);
		//		billingphone.sendKeys(phne);
	    //		Thread.sleep(500);
		/*		
				if(banknme.isDisplayed())
				{
					banknme.clear();
					Thread.sleep(300);
					banknme.click();
					Thread.sleep(300);
					banknme.sendKeys(bnknme);
					Thread.sleep(500);
				}
		*/		
		//		termsncndtn.click();
		//		Thread.sleep(1000);
				Bilinginfo.click();
				Thread.sleep(1000);
				Cruiseconfrm.click();
				Thread.sleep(9000);
				
	    	}
	    	catch(Exception e)
	    	{
	    		
					     e.printStackTrace();
				     
	    	}
	  }


	public void MulticityPaymentToTitle(String crdhldrnme, String crrdno, String cardcvvno, String adrs, String cty, String zpcd, String phne, String bnknme)
	{
	    	try
	    	{
	    	
	    		Select select = new Select(slctcarttype.findElement(By.id("_ctl0_MainContentsPH__ctl0_CreditCardInfo_cardType")));
			    select.selectByVisibleText("Visa");  
				Thread.sleep(800); 
				cardholdernme.click();
				Thread.sleep(600);
				cardholdernme.sendKeys(crdhldrnme);
				Thread.sleep(900);
				crdno.click();
				Thread.sleep(700);
				crdno.sendKeys(crrdno);
				Thread.sleep(800);
				crdcvv.click();
				Thread.sleep(600);
				crdcvv.sendKeys(cardcvvno);
				Thread.sleep(900);
				selectmonth.click();
				Thread.sleep(700);
				selectmonth.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_CreditCardInfo_expireDate_Month']/option[5]")).click();
				Thread.sleep(900);
				selectyear.click();
				Thread.sleep(700);
				selectyear.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_CreditCardInfo_expireDate_Year']/option[7]")).click();
				Thread.sleep(500);
				address.clear();
				Thread.sleep(500);
				address.click();
				Thread.sleep(700);
				address.sendKeys(adrs);
				Thread.sleep(500);
				slectcity.click();
				Thread.sleep(700);
				slectcity.sendKeys(cty);
				Thread.sleep(500);
				slectstate.click();
				Thread.sleep(300);
				slectstate.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_BillingAddress_StateSel']/option[8]")).click();
				Thread.sleep(500);
				mltizpcde.click();
				Thread.sleep(700);
				mltizpcde.sendKeys(zpcd);
				Thread.sleep(500);
				mltiphone.clear();
				Thread.sleep(800);
				mltiphone.click();
				Thread.sleep(900);
				mltiphone.sendKeys(phne);
	    		Thread.sleep(800);
	    		mltitermsncndtn.click();
				Thread.sleep(1000);
				ClickonContinuebtn.click();
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
