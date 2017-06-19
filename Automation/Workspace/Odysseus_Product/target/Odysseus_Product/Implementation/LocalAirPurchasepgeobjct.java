package Implementation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class LocalAirPurchasepgeobjct 
{

	  
	   //For Checkout page (For passenger 1)
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_Title")
	    private WebElement selctitle;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_GenderSEL")
	    private WebElement selctgender;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_FirstName")
	    private WebElement Firstnme;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_MiddleName")
	    private WebElement Middlenme;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_LastName")
	    private WebElement lastnme;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_DateUC_Month")
	    private WebElement selctmonth;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_DateUC_Day")
	    private WebElement selctday;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_DateUC_Year")
	    private WebElement selctyear;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_EMail")
	    private WebElement slcteml;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_Phone1_Number")
	    private WebElement slctphne;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_PhoneAtDest_Number")
	    private WebElement slctdestphne;
	    
	    //For passenger 2
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_2_Title")
	    private WebElement selecttitle;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_2_GenderSEL")
	    private WebElement slctgender;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_2_FirstName")
	    private WebElement frstnm;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_2_MiddleName")
	    private WebElement midlnme;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_2_LastName")
	    private WebElement lstnm;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_2_DateUC_Month")
	    private WebElement slctmnth;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_2_DateUC_Day")
	    private WebElement slctday;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_2_DateUC_Year")
	    private WebElement slctyr;
	    
	    //For passenger 3 (Child)
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_3_Title")
	    private WebElement slctitle;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_3_GenderSEL")
	    private WebElement slctgnder;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_3_FirstName")
	    private WebElement slectfrstname;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_3_MiddleName")
	    private WebElement mdlname;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_3_LastName")
	    private WebElement slectlstnme;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_3_DateUC_Month")
	    private WebElement slectmnth;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_3_DateUC_Day")
	    private WebElement slectday;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_3_DateUC_Year")
	    private WebElement slectyer;
	    
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
	    
	    // For Hold Button
	    @FindBy(xpath="//*[@id='_ctl0_MainContentsPH__ctl0_HoldLNK']/span")
	    private WebElement ClickonHoldbtn;
	    
	    // For Confirm Booking
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_ConfirmBkgBTN")
	    private WebElement Confirmbookingbtn; 
	    
	  
	    
	    
	    public void AirpurchaseToTitle(String frstnme, String mdlnme, String lstnme, String emal, String pone, String destpone, String fstnm, String mdlnm, String lastnm, String firstnm, String midlnm, String lastnam)
		{
			try
			{
				
				Select select = new Select(selctitle.findElement(By.id("_ctl0_MainContentsPH__ctl0_TravelerAccount_1_Title")));
				select.selectByVisibleText("Mr");
				Thread.sleep(500);
				Select select1 = new Select(selctgender.findElement(By.id("_ctl0_MainContentsPH__ctl0_TravelerAccount_1_GenderSEL")));
				select1.selectByVisibleText("Male");
				Thread.sleep(500);
				Firstnme.clear();
				Thread.sleep(500);
				Firstnme.click();
				Thread.sleep(500);
				Firstnme.sendKeys(frstnme);
				Thread.sleep(500);
				Middlenme.clear();
				Thread.sleep(500);
				Middlenme.click();
				Thread.sleep(500);
				Middlenme.sendKeys(mdlnme);
				Thread.sleep(500);
				lastnme.clear();
				Thread.sleep(500);
				lastnme.click();
				Thread.sleep(500);
				lastnme.sendKeys(lstnme);
				Thread.sleep(500);
				selctmonth.click();
				Thread.sleep(500);
				selctmonth.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_1_DateUC_Month']/option[8]")).click();
				Thread.sleep(500);
				selctday.click();
				Thread.sleep(500);
				selctday.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_1_DateUC_Day']/option[10]")).click();
				Thread.sleep(500);
				selctyear.click();
				Thread.sleep(500);
				selctyear.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_1_DateUC_Year']/option[7]")).click();
				Thread.sleep(1000); 
				slcteml.clear();
				Thread.sleep(500);
				slcteml.click();
				Thread.sleep(700);
				slcteml.sendKeys(emal);
				Thread.sleep(800);
				slctphne.clear();
				Thread.sleep(500);
				slctphne.click();
				Thread.sleep(700);
				slctphne.sendKeys(pone);
				Thread.sleep(800); 
				slctdestphne.clear();
				Thread.sleep(500);
				slctdestphne.click();
				Thread.sleep(700);
				slctdestphne.sendKeys(destpone);
				Thread.sleep(800);
				Select select2 = new Select(selecttitle.findElement(By.id("_ctl0_MainContentsPH__ctl0_TravelerAccount_2_Title")));
				select2.selectByVisibleText("Mrs");
				Thread.sleep(500);
				Select select3 = new Select(slctgender.findElement(By.id("_ctl0_MainContentsPH__ctl0_TravelerAccount_2_GenderSEL")));
				select3.selectByVisibleText("Female");
				Thread.sleep(500);
				frstnm.clear();
				Thread.sleep(500);
				frstnm.click();
				Thread.sleep(500);
				frstnm.sendKeys(fstnm);
				Thread.sleep(500);
				midlnme.clear();
				Thread.sleep(500);
				midlnme.click();
				Thread.sleep(500);
				midlnme.sendKeys(mdlnm);
				Thread.sleep(500);
				lstnm.clear();
				Thread.sleep(500);
				lstnm.click();
				Thread.sleep(500);
				lstnm.sendKeys(lastnm);
				Thread.sleep(500);
				slctmnth.click();
				Thread.sleep(300);
				slctmnth.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_2_DateUC_Month']/option[9]")).click();
				Thread.sleep(500);
				slctday.click();
				Thread.sleep(500);
				slctday.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_2_DateUC_Day']/option[11]")).click();
				Thread.sleep(500);
				slctyr.click();
				Thread.sleep(500);
				slctyr.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_2_DateUC_Year']/option[10]")).click();
				Thread.sleep(1000);
				slctitle.click();
				Thread.sleep(200);
				Select select4 = new Select(slctitle.findElement(By.id("_ctl0_MainContentsPH__ctl0_TravelerAccount_3_Title")));
				select4.selectByVisibleText("Miss"); 
				Thread.sleep(300);
				Select select5 = new Select(slctgnder.findElement(By.id("_ctl0_MainContentsPH__ctl0_TravelerAccount_3_GenderSEL")));
				select5.selectByVisibleText("Female");
				slectfrstname.clear();
				Thread.sleep(300);
				slectfrstname.click();
				Thread.sleep(300);
				slectfrstname.sendKeys(firstnm);
				Thread.sleep(500); 
				mdlname.clear();
				Thread.sleep(300);
				mdlname.click();
				Thread.sleep(300);
				mdlname.sendKeys(midlnm);
				Thread.sleep(500);
				slectlstnme.clear();
				Thread.sleep(200);
				slectlstnme.click();
				Thread.sleep(300);
				slectlstnme.sendKeys(lastnam);
				Thread.sleep(500);
				slectmnth.click();
				Thread.sleep(200);
				slectmnth.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_3_DateUC_Month']/option[13]")).click();
				Thread.sleep(500);
				slectday.click();
				Thread.sleep(200);
				slectday.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_3_DateUC_Day']/option[13]")).click();
				Thread.sleep(500);
				slectyer.click();
				Thread.sleep(200);
				slectyer.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_3_DateUC_Year']/option[9]")).click();
		//		Thread.sleep(500);
		//		ClickonHoldbtn.click();
				Thread.sleep(3000);
				
				
				
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
