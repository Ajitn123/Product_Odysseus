package Implementation;

import java.io.File;
import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HoldAndConfirmPgeobjct 
{
	    // For Confirm button
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_ConfirmBkgBTN")
	    private WebElement Confirmbookingbtn;
	   
	    //For payment details
	    @FindBy(id="_ctl0_MainContentsPH__ctl0__ctl4_CreditCardInfo_cardType")
	    private WebElement slctcarttype;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0__ctl4_CreditCardInfo_cardHolderName")
	    private WebElement cardholdernme;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0__ctl4_CreditCardInfo_cardNumber")
	    private WebElement cardno;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0__ctl4_CreditCardInfo_cardCCV")
	    private  WebElement crdcvv;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0__ctl4_CreditCardInfo_expireDate_Month")
	    private WebElement selectmonth;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0__ctl4_CreditCardInfo_expireDate_Year")
	    private WebElement selectyear;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0__ctl4_BillingAddress_AddrLine1")
	    private WebElement address;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0__ctl4_BillingAddress_StateSel")
	    private WebElement slectstate;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0__ctl4_BillingAddress_CityInput")
	    private WebElement slectcity;
	    
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
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_ContinueBTN")
	    private WebElement ClickonContinuebtn;
	    
	    
	  private TakesScreenshot driver;
	    
	public void HoldAfterConfirmToTitle(String crdhldrnme, String crdno, String cardcvvno, String adrs, String cty, String zpcd, String phne, String bnknme)
	{
	    	try
	    	{
	    		Confirmbookingbtn.click();
				Thread.sleep(7000);
				slctcarttype.click();
				Thread.sleep(500);
				slctcarttype.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0__ctl4_CreditCardInfo_cardType']/option[6]")).click();
				Thread.sleep(500);
				cardholdernme.click();
				Thread.sleep(300);
				cardholdernme.sendKeys(crdhldrnme);
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
				selectmonth.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0__ctl4_CreditCardInfo_expireDate_Month']/option[11]")).click();
				Thread.sleep(500);
				selectyear.click();
				Thread.sleep(300);
				selectyear.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0__ctl4_CreditCardInfo_expireDate_Year']/option[11]")).click();
				Thread.sleep(500);
				address.click();
				Thread.sleep(300);
				address.sendKeys(adrs);
				Thread.sleep(500);
				slectstate.click();
				Thread.sleep(300);
				slectstate.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0__ctl4_BillingAddress_StateSel']/option[13]")).click();
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
				banknme.clear();
				Thread.sleep(300);
				banknme.click();
				Thread.sleep(300);
				banknme.sendKeys(bnknme);
				Thread.sleep(500);
				termsncndtn.click();
				Thread.sleep(1000);
				ClickonContinuebtn.click();
				Thread.sleep(9000);
				
	    	}
	    	catch(Exception e)
	    	{
	    		File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				
				   try
				   {
					   FileUtils.copyFile(scr, new File("D:\\Ajit\\Script_SS\\login\\Holdandconfirm.jpg"));
					
				   } catch(Exception e1)
				     {
					     e1.printStackTrace();
				     }
	    	}
	  }

	

	public boolean isDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}



}
