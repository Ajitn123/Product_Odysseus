package Implementation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CDNFaredepotPaymentpgobjct 
{

	  
	//For payment details
	    @FindBy(xpath="//*[@id='_ctl0__ctl0_MainContentsParentPH_MainContentsPH__ctl0__ctl4_CreditCardInfo_cardType']")
	    private WebElement slctcarttype; 
	    
	    @FindBy(id="_ctl0__ctl0_MainContentsParentPH_MainContentsPH__ctl0__ctl4_CreditCardInfo_cardHolderName")
	    private WebElement cardholdernme;
	    
	    @FindBy(id="_ctl0__ctl0_MainContentsParentPH_MainContentsPH__ctl0__ctl4_CreditCardInfo_cardNumber")
	    private WebElement cardno;
	    
	    @FindBy(id="_ctl0__ctl0_MainContentsParentPH_MainContentsPH__ctl0__ctl4_CreditCardInfo_cardCCV")
	    private  WebElement crdcvv;
	    
	    @FindBy(id="_ctl0__ctl0_MainContentsParentPH_MainContentsPH__ctl0__ctl4_CreditCardInfo_expireDate_Month")
	    private WebElement selectmonth;
	    
	    @FindBy(id="_ctl0__ctl0_MainContentsParentPH_MainContentsPH__ctl0__ctl4_CreditCardInfo_expireDate_Year")
	    private WebElement selectyear;
	    
	    @FindBy(id="_ctl0__ctl0_MainContentsParentPH_MainContentsPH__ctl0__ctl4_BillingAddress_AddrLine1")
	    private WebElement address;
	    
	    @FindBy(id="_ctl0__ctl0_MainContentsParentPH_MainContentsPH__ctl0__ctl4_BillingAddress_StateSel")
	    private WebElement slectstate;
	    
	    @FindBy(id="_ctl0__ctl0_MainContentsParentPH_MainContentsPH__ctl0__ctl4_BillingAddress_CityInput")
	    private WebElement slectcity;
	    
	    @FindBy(id="_ctl0__ctl0_MainContentsParentPH_MainContentsPH__ctl0__ctl4_BillingAddress_ZipCodeInput")
	    private WebElement zipcde;
	    
	    @FindBy(id="_ctl0__ctl0_MainContentsParentPH_MainContentsPH__ctl0__ctl4_BillingAddress_PhoneInput_Number")
	    private WebElement billingphone;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_BillingAddress_BankPhoneInput_Number")
	    private WebElement bankphne;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_BillingAddress_BankNameTXT")
	    private WebElement banknme;
	    
	    //For Terms And Condition
	    @FindBy(id="AgreeTermsCHK")
	    private WebElement termsncndtn;
	    
	    // For Continue Booking Button
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_ContinueBTN")
	    private WebElement ClickonContinuebtn;
	    
	    

	    
	public void CDNFaredepotPaymentToTitle(String crdhldrnme, String crdno, String cardcvvno, String adrs, String cty, String zpcd, String phne, String bnknm)
	{
	    	try
	    	{
	    		
	    		Select select = new Select(slctcarttype.findElement(By.xpath("//*[@id='_ctl0__ctl0_MainContentsParentPH_MainContentsPH__ctl0__ctl4_CreditCardInfo_cardType']")));
				select.selectByVisibleText("Visa");
				Thread.sleep(500);  
				cardholdernme.click();
				Thread.sleep(300);
				cardholdernme.sendKeys(crdhldrnme);
				Thread.sleep(900);
				cardno.click();
				Thread.sleep(300);
				cardno.sendKeys(crdno);
				Thread.sleep(900);
				crdcvv.click();
				Thread.sleep(800);
				crdcvv.sendKeys(cardcvvno);
				Thread.sleep(900);
				selectmonth.click();
				Thread.sleep(800);
				selectmonth.findElement(By.xpath("//*[@id='_ctl0__ctl0_MainContentsParentPH_MainContentsPH__ctl0__ctl4_CreditCardInfo_expireDate_Month']/option[7]")).click();
				Thread.sleep(2000);
				selectyear.click();
				Thread.sleep(1500);
				selectyear.findElement(By.xpath("//*[@id='_ctl0__ctl0_MainContentsParentPH_MainContentsPH__ctl0__ctl4_CreditCardInfo_expireDate_Year']/option[7]")).click();
				Thread.sleep(500);
				address.clear();
				Thread.sleep(500);
				address.click();
				Thread.sleep(300);
				address.sendKeys(adrs);
				Thread.sleep(500);
				slectstate.click();
				Thread.sleep(300);
				slectstate.findElement(By.xpath("//*[@id='_ctl0__ctl0_MainContentsParentPH_MainContentsPH__ctl0__ctl4_BillingAddress_StateSel']/option[3]")).click();
				Thread.sleep(500);
				slectcity.click();
				Thread.sleep(300);
				slectcity.sendKeys(cty);
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
		//		bankphne.clear();
		//		Thread.sleep(300);
		//		bankphne.click();
		//		Thread.sleep(300);
		//		bankphne.sendKeys("5412562398");
		//		Thread.sleep(300);
		//		banknme.clear();
		//		Thread.sleep(300);
		//		banknme.click();
		//		Thread.sleep(300);
		//		banknme.sendKeys(bnknm);
		//		Thread.sleep(500);
				termsncndtn.click();
				Thread.sleep(1000);
		//		ClickonContinuebtn.click();
		//		Thread.sleep(9000);
				
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
