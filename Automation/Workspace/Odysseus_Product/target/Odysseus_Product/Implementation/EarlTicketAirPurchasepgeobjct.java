package Implementation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class EarlTicketAirPurchasepgeobjct 
{

	   
	 //For Checkout page (For passenger 1)
	    @FindBy(xpath="//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_1_Title']")
	    private WebElement selctitle;
	    
	    @FindBy(xpath="//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_1_GenderSEL']")
	    private WebElement selctgnder;
	    
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
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_MaskedEMail")
	    private WebElement EML;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_MaskedConfirmEMail")
	    private WebElement CONEML;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_Phone1_MaskedNumber")
	    private WebElement PHNE;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_PhoneAtDest_MaskedNumber")
	    private WebElement DESTPHNE;
	    
	    @FindBy(xpath="//*[@id='section1']/div[5]/div[3]/div/div[2]/h3")
	    private WebElement dropdown;
	    
	    //For passenger 2
	    @FindBy(xpath="//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_2_Title']")
	    private WebElement selecttitle; 
	    
	    @FindBy(xpath="//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_2_GenderSEL']")
	    private WebElement selectgndrtwo;
	    
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
	    @FindBy(xpath="//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_3_Title']")
	    private WebElement slctitle;
	    
	    @FindBy(xpath="//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_3_GenderSEL']")
	    private WebElement slctgnderthree;
	    
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
	    private WebElement slectmonth;
	    
	  //For Delivery address unchecked
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_RequestPaperTicketCHK") 
	    private WebElement delivryunchecked; 
	    
	    @FindBy(xpath="//*[@id='st-accordion']/ul/li[2]/a")
	    private WebElement clickonContinue;
	    
	    //For Booking Contact Information
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_BookingContact_EMail")
	    private WebElement email;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_BookingContact_Phone1_Number")
	    private WebElement phoneno;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_BookingContact_PhoneAtDest_Number")
	    private WebElement phoneatdestination;
	    
	    @FindBy(xpath="//*[@id='st-accordion']/ul/li[2]/div/div[2]/input")
	    private WebElement continuebtn;  
	    
	    @FindBy(xpath="//*[@id='st-accordion']/ul/li[3]/div/div[2]/input")
	    private WebElement markupcontinuebtn;
	    
	    @FindBy(xpath="//*[@id='st-accordion']/ul/li[4]/div/div[2]/input") 
	    private WebElement Additionalcontinuebtn; 
	    
	    @FindBy(xpath="//*[@id='_ctl0_MainContentsPH__ctl0_HoldBTN']") 
	    private WebElement cntnwithpayment; 
	    
	   //For payment details
	    @FindBy(xpath="//*[@id='_ctl0_MainContentsPH__ctl0__ctl4_CreditCardInfo_cardType']")
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
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_HoldBTN")
	    private WebElement ClickonHoldbtn;
	    
	   // For Confirm Booking
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_ConfirmBkgBTN")
	    private WebElement Confirmbookingbtn; 
	    
	   //For Infant
	    @FindBy(xpath="//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_3_Title']")
	    private WebElement slctite;
	    
	    @FindBy(xpath="//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_3_GenderSEL']")
	    private WebElement slctgndertree;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_3_FirstName")
	    private WebElement infntfrstnme;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_3_MiddleName")
	    private WebElement infntmdlname;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_3_LastName")
	    private WebElement infntlstnme;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_3_DateUC_Month")
	    private WebElement infntslectmnth;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_3_DateUC_Day")
	    private WebElement infntslectday;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_3_DateUC_Year")
	    private WebElement infntslectyear;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_DeliveryDetailOpt")
	    private WebElement cpydlveradd;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_DeliveryContact_AddressUC_AddrLine1")
	    private WebElement addrs;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_DeliveryContact_AddressUC_CityInput")
	    private WebElement citynme;
	    
	    @FindBy(xpath="//*[@id='_ctl0_MainContentsPH__ctl0_DeliveryContact_AddressUC_CountrySel']")
	    private WebElement cntrynme;
	    
	    @FindBy(xpath="//*[@id='_ctl0_MainContentsPH__ctl0_DeliveryContact_AddressUC_StateSel']")
	    private WebElement statenme;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_DeliveryContact_AddressUC_MaskedZipCodeInput")
	    private WebElement zipcodes;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_DeliveryContact_Phone1_MaskedNumber")
	    private WebElement phones;
	    
	    
		   
	    
	    public void ConfirmToTitle(String frstnme, String mdalnme, String lstnme, String emladd, String conemladd, String phneno, String destphneno, String fstnm, String mdlenm, String lastnm, String firstnm, String mddlname, String lastnam, String eml, String phone, String crdhldrnme, String crdno, String cardcvvno, String adrs, String cty, String zpcd, String phne, String bnknme)
		{
			try
			{
				
				Select select = new Select(selctitle.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_1_Title']")));
				select.selectByVisibleText("Mr");
				Thread.sleep(500);
				Select select1 = new Select(selctgnder.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_1_GenderSEL']")));
				select1.selectByVisibleText("Male");
				Thread.sleep(500);
				Firstnme.clear();
				Thread.sleep(500);
				Firstnme.click();
				Thread.sleep(500);
				Firstnme.sendKeys(frstnme);
				Thread.sleep(500);
				Middlenme.clear();
				Middlenme.click();
				Thread.sleep(500);
				Middlenme.sendKeys(mdalnme);
				Thread.sleep(500);
				lastnme.clear();
				Thread.sleep(500);
				lastnme.click();
				Thread.sleep(500);
				lastnme.sendKeys(lstnme);
				Thread.sleep(500);
				selctmonth.click();
				Thread.sleep(500);
				selctmonth.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_1_DateUC_Month']/option[9]")).click();
				Thread.sleep(500);
				selctday.click();
				Thread.sleep(500);
				selctday.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_1_DateUC_Day']/option[14]")).click();
				Thread.sleep(500);
				selctyear.click();
				Thread.sleep(500);
				selctyear.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_1_DateUC_Year']/option[13]")).click();
				Thread.sleep(1000);
				EML.clear();
				Thread.sleep(400);
				EML.click();
				Thread.sleep(500);
				EML.sendKeys(emladd);
				Thread.sleep(800); 
				CONEML.clear();
				Thread.sleep(400);
				CONEML.click();
				Thread.sleep(500);
				CONEML.sendKeys(conemladd);
				Thread.sleep(800);
				PHNE.clear();
				Thread.sleep(400);
				PHNE.click();
				Thread.sleep(500);
				PHNE.sendKeys(phneno);
				Thread.sleep(800);
				DESTPHNE.clear();
				Thread.sleep(400);
				DESTPHNE.click();
				Thread.sleep(500);
				DESTPHNE.sendKeys(destphneno);
				Thread.sleep(800);
				Select select2 = new Select(selecttitle.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_2_Title']")));
				select2.selectByVisibleText("Mrs");
				Thread.sleep(700);
				Select select7 = new Select(selectgndrtwo.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_2_GenderSEL']")));
				select7.selectByVisibleText("Female");
				Thread.sleep(500);
				frstnm.clear();
				Thread.sleep(500);
				frstnm.click();
				Thread.sleep(500);
				frstnm.sendKeys(fstnm);
				Thread.sleep(500);
				midlnme.clear();
				midlnme.click();
				Thread.sleep(500);
				midlnme.sendKeys(mdlenm);
				Thread.sleep(500);
				lstnm.clear();
				Thread.sleep(500);
				lstnm.click();
				Thread.sleep(500);
				lstnm.sendKeys(lastnm);
				Thread.sleep(500);
				slctmnth.click();
				Thread.sleep(300);
				slctmnth.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_2_DateUC_Month']/option[8]")).click();
				Thread.sleep(500);
				slctday.click();
				Thread.sleep(500);
				slctday.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_2_DateUC_Day']/option[7]")).click();
				Thread.sleep(500);
				slctyr.click();
				Thread.sleep(500);
				slctyr.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_2_DateUC_Year']/option[7]")).click();
				Thread.sleep(1000);
				slctitle.click();
				Thread.sleep(200);
				Select select3 = new Select(slctitle.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_3_Title']")));
				select3.selectByVisibleText("Miss");
				Thread.sleep(700);
				Select select8 = new Select(slctgnderthree.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_3_GenderSEL']")));
				select8.selectByVisibleText("Female");
				Thread.sleep(300);
				slectfrstname.clear();
				Thread.sleep(300);
				slectfrstname.click();
				Thread.sleep(300);
				slectfrstname.sendKeys(firstnm);
				Thread.sleep(500);
				mdlname.clear();
				mdlname.click();
				Thread.sleep(500);
				mdlname.sendKeys(mddlname);
				Thread.sleep(200);
				slectlstnme.clear();
				Thread.sleep(200);
				slectlstnme.click();
				Thread.sleep(300);
				slectlstnme.sendKeys(lastnam);
				Thread.sleep(800);
				slectmnth.click();
				Thread.sleep(800);
				slectmnth.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_3_DateUC_Month']/option[5]")).click();
				Thread.sleep(700);
				slectday.click();
				Thread.sleep(1000);
				slectday.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_3_DateUC_Day']/option[11]")).click();
				Thread.sleep(1000);
				slectmonth.click();
				Thread.sleep(900);
				slectmonth.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_3_DateUC_Year']/option[9]")).click();
				Thread.sleep(900);
				delivryunchecked.click();
				Thread.sleep(900);
								
			//	Additionalcontinuebtn.click();
			//	Thread.sleep(2000);
		//		cntnwithpayment.click();
		//		Thread.sleep(2000);
				slctcarttype.click();
				Thread.sleep(500);
				slctcarttype.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0__ctl4_CreditCardInfo_cardType']/option[6]")).click();
				Thread.sleep(900);
				cardholdernme.click();
				Thread.sleep(800);
				cardholdernme.sendKeys(crdhldrnme);
				Thread.sleep(700);
				cardno.click();
				Thread.sleep(800);
				cardno.sendKeys(crdno);
				Thread.sleep(800);
				crdcvv.click();
				Thread.sleep(300);
				crdcvv.sendKeys(cardcvvno);
				Thread.sleep(900);
				selectmonth.click();
				Thread.sleep(900);
				selectmonth.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0__ctl4_CreditCardInfo_expireDate_Month']/option[11]")).click();
				Thread.sleep(500);
				selectyear.click();
				Thread.sleep(900);
				selectyear.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0__ctl4_CreditCardInfo_expireDate_Year']/option[11]")).click();
				Thread.sleep(800);
				address.click();
				Thread.sleep(900);
				address.sendKeys(adrs);
				Thread.sleep(800);
				slectstate.click();
				Thread.sleep(700);
				slectstate.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0__ctl4_BillingAddress_StateSel']/option[13]")).click();
				Thread.sleep(800);
				slectcity.click();
				Thread.sleep(700);
				slectcity.sendKeys(cty);
				Thread.sleep(700);
				zipcde.click();
				Thread.sleep(800);
				zipcde.sendKeys(zpcd);
				Thread.sleep(800);
				billingphone.clear();
				Thread.sleep(900);
				billingphone.click();
				Thread.sleep(900);
				billingphone.sendKeys(phne);
				Thread.sleep(800);
		//		banknme.clear();
		//		Thread.sleep(300);
		//		banknme.click();
		//		Thread.sleep(300);
		//		banknme.sendKeys(bnknme);
		//		Thread.sleep(500);
				termsncndtn.click();
				Thread.sleep(1000);
				ClickonContinuebtn.click();
				Thread.sleep(30000);
				
				
				
			}
			catch(Exception e)
			{
				
					     e.printStackTrace();
				     
			}
		}
	   
	    public void OneWayConfirmToTitle(String frstnme, String mdalnme, String lstnme, String emladd, String conemladd, String phneno, String destphneno, String fstnm, String mdlenm, String lastnm, String firstnm, String mddlname, String lastnam, String eml, String phone, String crdhldrnme, String crdno, String cardcvvno, String adrs, String cty, String zpcd, String phne, String bnknme)
		{
			try
			{
				
				Select select = new Select(selctitle.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_1_Title']")));
				select.selectByVisibleText("Mr");
				Thread.sleep(500);
				Select select1 = new Select(selctgnder.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_1_GenderSEL']")));
				select1.selectByVisibleText("Male");
				Thread.sleep(500);
				Firstnme.clear();
				Thread.sleep(500);
				Firstnme.click();
				Thread.sleep(500);
				Firstnme.sendKeys(frstnme);
				Thread.sleep(500);
				Middlenme.clear();
				Middlenme.click();
				Thread.sleep(500);
				Middlenme.sendKeys(mdalnme);
				Thread.sleep(500);
				lastnme.clear();
				Thread.sleep(500);
				lastnme.click();
				Thread.sleep(500);
				lastnme.sendKeys(lstnme);
				Thread.sleep(500);
				selctmonth.click();
				Thread.sleep(500);
				selctmonth.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_1_DateUC_Month']/option[9]")).click();
				Thread.sleep(500);
				selctday.click();
				Thread.sleep(500);
				selctday.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_1_DateUC_Day']/option[14]")).click();
				Thread.sleep(500);
				selctyear.click();
				Thread.sleep(500);
				selctyear.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_1_DateUC_Year']/option[13]")).click();
				Thread.sleep(1000);
				EML.clear();
				Thread.sleep(900);
				EML.click();
				Thread.sleep(800);
				EML.sendKeys(emladd);
				Thread.sleep(800); 
				CONEML.clear();
				Thread.sleep(900);
				CONEML.click();
				Thread.sleep(800);
				CONEML.sendKeys(conemladd);
				Thread.sleep(800);
				PHNE.clear();
				Thread.sleep(700);
				PHNE.click();
				Thread.sleep(500);
				PHNE.sendKeys(phneno);
				Thread.sleep(800);
				PHNE.sendKeys(Keys.TAB);
				Thread.sleep(500);
				dropdown.findElement(By.cssSelector("#section1 > div:nth-child(5) > div:nth-child(3) > div > div.additionaldetails > h3")).sendKeys(Keys.ENTER);
				Thread.sleep(800);
				DESTPHNE.clear();
				Thread.sleep(900);
				DESTPHNE.click();
				Thread.sleep(800);
				DESTPHNE.sendKeys(destphneno);
				Thread.sleep(900);
				DESTPHNE.sendKeys(Keys.TAB);
        		Select select2 = new Select(selecttitle.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_2_Title']")));
				select2.selectByVisibleText("Miss");
				Thread.sleep(700);
				Select select7 = new Select(selectgndrtwo.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_2_GenderSEL']")));
				select7.selectByVisibleText("Female");
				Thread.sleep(500);
				frstnm.clear();
				Thread.sleep(500);
				frstnm.click();
				Thread.sleep(500);
				frstnm.sendKeys(fstnm);
				Thread.sleep(500);
				midlnme.clear();
				midlnme.click();
				Thread.sleep(500);
				midlnme.sendKeys(mdlenm);
				Thread.sleep(500);
				lstnm.clear();
				Thread.sleep(500);
				lstnm.click();
				Thread.sleep(500);
				lstnm.sendKeys(lastnm);
				Thread.sleep(500);
				slctmnth.click();
				Thread.sleep(300);
				slctmnth.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_2_DateUC_Month']/option[8]")).click();
				Thread.sleep(500);
				slctday.click();
				Thread.sleep(500);
				slctday.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_2_DateUC_Day']/option[7]")).click();
				Thread.sleep(500);
				slctyr.click();
				Thread.sleep(500);
				slctyr.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_2_DateUC_Year']/option[9]")).click();
				Thread.sleep(1000);
				slctite.click();
				Thread.sleep(200);
				Select select3 = new Select(slctite.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_3_Title']")));
				select3.selectByVisibleText("Miss");
				Thread.sleep(700);
				Select select8 = new Select(slctgndertree.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_3_GenderSEL']")));
				select8.selectByVisibleText("Female");
				Thread.sleep(300);
				infntfrstnme.clear();
				Thread.sleep(300);
				infntfrstnme.click();
				Thread.sleep(300);
				infntfrstnme.sendKeys(firstnm);
				Thread.sleep(500);
				infntmdlname.clear();
				Thread.sleep(500);
				infntmdlname.click();
				Thread.sleep(500);
				infntmdlname.sendKeys(mddlname);
				Thread.sleep(200);
				infntlstnme.clear();
				Thread.sleep(200);
				infntlstnme.click();
				Thread.sleep(300);
				infntlstnme.sendKeys(lastnam);
				Thread.sleep(800);
				infntslectmnth.click();
				Thread.sleep(800);
				infntslectmnth.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_3_DateUC_Month']/option[7]")).click();
				Thread.sleep(700);
				infntslectday.click();
				Thread.sleep(1000);
				infntslectday.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_3_DateUC_Day']/option[8]")).click();
				Thread.sleep(1000);
				infntslectyear.click();
				Thread.sleep(900);
				infntslectyear.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_3_DateUC_Year']/option[3]")).click();
				Thread.sleep(900);
				delivryunchecked.click();
				Thread.sleep(900);
								
			//	Additionalcontinuebtn.click();
			//	Thread.sleep(2000);
		//		cntnwithpayment.click();
		//		Thread.sleep(2000);
				slctcarttype.click();
				Thread.sleep(500);
				slctcarttype.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0__ctl4_CreditCardInfo_cardType']/option[6]")).click();
				Thread.sleep(900);
				cardholdernme.click();
				Thread.sleep(800);
				cardholdernme.sendKeys(crdhldrnme);
				Thread.sleep(700);
				cardno.click();
				Thread.sleep(800);
				cardno.sendKeys(crdno);
				Thread.sleep(800);
				crdcvv.click();
				Thread.sleep(300);
				crdcvv.sendKeys(cardcvvno);
				Thread.sleep(900);
				selectmonth.click();
				Thread.sleep(900);
				selectmonth.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0__ctl4_CreditCardInfo_expireDate_Month']/option[11]")).click();
				Thread.sleep(500);
				selectyear.click();
				Thread.sleep(900);
				selectyear.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0__ctl4_CreditCardInfo_expireDate_Year']/option[11]")).click();
				Thread.sleep(800);
				address.click();
				Thread.sleep(900);
				address.sendKeys(adrs);
				Thread.sleep(800);
				slectstate.click();
				Thread.sleep(700);
				slectstate.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0__ctl4_BillingAddress_StateSel']/option[13]")).click();
				Thread.sleep(800);
				slectcity.click();
				Thread.sleep(700);
				slectcity.sendKeys(cty);
				Thread.sleep(700);
				zipcde.click();
				Thread.sleep(800);
				zipcde.sendKeys(zpcd);
				Thread.sleep(800);
				billingphone.clear();
				Thread.sleep(900);
				billingphone.click();
				Thread.sleep(900);
				billingphone.sendKeys(phne);
				Thread.sleep(800);
		//		banknme.clear();
		//		Thread.sleep(300);
		//		banknme.click();
		//		Thread.sleep(300);
		//		banknme.sendKeys(bnknme);
		//		Thread.sleep(500);
				termsncndtn.click();
				Thread.sleep(1000);
				ClickonContinuebtn.click();
				Thread.sleep(30000);
				
				
				
			}
			catch(Exception e)
			{
				
					     e.printStackTrace();
				     
			}
		}
	    
	    
	    public void MulticityConfirmToTitle(String frstnme, String mdalnme, String lstnme, String emladd, String conemladd, String phneno, String destphneno, String fstnm, String mdlenm, String lastnm, String firstnm, String mddlname, String lastnam, String eml, String phone, String crdhldrnme, String crdno, String cardcvvno, String adrs, String cty, String zpcd, String phne, String bnknme)
		{
			try
			{
				
				Select select = new Select(selctitle.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_1_Title']")));
				select.selectByVisibleText("Mr");
				Thread.sleep(500);
				Select select1 = new Select(selctgnder.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_1_GenderSEL']")));
				select1.selectByVisibleText("Male");
				Thread.sleep(500);
				Firstnme.clear();
				Thread.sleep(500);
				Firstnme.click();
				Thread.sleep(500);
				Firstnme.sendKeys(frstnme);
				Thread.sleep(500);
				Middlenme.clear();
				Middlenme.click();
				Thread.sleep(500);
				Middlenme.sendKeys(mdalnme);
				Thread.sleep(500);
				lastnme.clear();
				Thread.sleep(500);
				lastnme.click();
				Thread.sleep(500);
				lastnme.sendKeys(lstnme);
				Thread.sleep(500);
				selctmonth.click();
				Thread.sleep(500);
				selctmonth.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_1_DateUC_Month']/option[9]")).click();
				Thread.sleep(500);
				selctday.click();
				Thread.sleep(500);
				selctday.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_1_DateUC_Day']/option[14]")).click();
				Thread.sleep(500);
				selctyear.click();
				Thread.sleep(500);
				selctyear.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_1_DateUC_Year']/option[13]")).click();
				Thread.sleep(1000);
				EML.clear();
				Thread.sleep(400);
				EML.click();
				Thread.sleep(500);
				EML.sendKeys(emladd);
				Thread.sleep(800); 
				CONEML.clear();
				Thread.sleep(400);
				CONEML.click();
				Thread.sleep(500);
				CONEML.sendKeys(conemladd);
				Thread.sleep(800);
				PHNE.clear();
				Thread.sleep(400);
				PHNE.click();
				Thread.sleep(500);
				PHNE.sendKeys(phneno);
				Thread.sleep(800);
				DESTPHNE.clear();
				Thread.sleep(400);
				DESTPHNE.click();
				Thread.sleep(500);
				DESTPHNE.sendKeys(destphneno);
				Thread.sleep(800);
				Select select2 = new Select(selecttitle.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_2_Title']")));
				select2.selectByVisibleText("Mrs");
				Thread.sleep(700);
				Select select7 = new Select(selectgndrtwo.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_2_GenderSEL']")));
				select7.selectByVisibleText("Female");
				Thread.sleep(500);
				frstnm.clear();
				Thread.sleep(500);
				frstnm.click();
				Thread.sleep(500);
				frstnm.sendKeys(fstnm);
				Thread.sleep(500);
				midlnme.clear();
				midlnme.click();
				Thread.sleep(500);
				midlnme.sendKeys(mdlenm);
				Thread.sleep(500);
				lstnm.clear();
				Thread.sleep(500);
				lstnm.click();
				Thread.sleep(500);
				lstnm.sendKeys(lastnm);
				Thread.sleep(500);
				slctmnth.click();
				Thread.sleep(300);
				slctmnth.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_2_DateUC_Month']/option[8]")).click();
				Thread.sleep(500);
				slctday.click();
				Thread.sleep(500);
				slctday.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_2_DateUC_Day']/option[7]")).click();
				Thread.sleep(500);
				slctyr.click();
				Thread.sleep(500);
				slctyr.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_2_DateUC_Year']/option[7]")).click();
				Thread.sleep(1000);
				slctitle.click();
				Thread.sleep(200);
				Select select3 = new Select(slctitle.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_3_Title']")));
				select3.selectByVisibleText("Miss");
				Thread.sleep(700);
				Select select8 = new Select(slctgnderthree.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_3_GenderSEL']")));
				select8.selectByVisibleText("Female");
				Thread.sleep(300);
				slectfrstname.clear();
				Thread.sleep(300);
				slectfrstname.click();
				Thread.sleep(300);
				slectfrstname.sendKeys(firstnm);
				Thread.sleep(500);
				mdlname.clear();
				mdlname.click();
				Thread.sleep(500);
				mdlname.sendKeys(mddlname);
				Thread.sleep(200);
				slectlstnme.clear();
				Thread.sleep(200);
				slectlstnme.click();
				Thread.sleep(300);
				slectlstnme.sendKeys(lastnam);
				Thread.sleep(800);
				slectmnth.click();
				Thread.sleep(800);
				slectmnth.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_3_DateUC_Month']/option[5]")).click();
				Thread.sleep(700);
				slectday.click();
				Thread.sleep(1000);
				slectday.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_3_DateUC_Day']/option[11]")).click();
				Thread.sleep(1000);
				slectmonth.click();
				Thread.sleep(900);
				slectmonth.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_3_DateUC_Year']/option[3]")).click();
				Thread.sleep(900);
				cpydlveradd.click();
				Thread.sleep(900);
				addrs.click();
				Thread.sleep(400);
				addrs.sendKeys("White House");
				Thread.sleep(400);
				citynme.click();
				Thread.sleep(400);
				citynme.sendKeys("Miami");
				Thread.sleep(400);
				cntrynme.click();
				Thread.sleep(400);
				cntrynme.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_DeliveryContact_AddressUC_CountrySel']/option[214]")).click();
				Thread.sleep(500);
				statenme.click();
				Thread.sleep(400);
				statenme.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_DeliveryContact_AddressUC_StateSel']/option[3]")).click();
				Thread.sleep(500);
				zipcodes.click();
				Thread.sleep(500);
				zipcodes.sendKeys("10245");
				Thread.sleep(400);
				phones.click();
				Thread.sleep(500);
				phones.sendKeys("5421563298");
				Thread.sleep(900);
				
			//	Additionalcontinuebtn.click();
			//	Thread.sleep(2000);
		//		cntnwithpayment.click();
		//		Thread.sleep(2000);
				slctcarttype.click();
				Thread.sleep(1000); 
				slctcarttype.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_CreditCardInfo_cardType']/option[4]")).click();
				Thread.sleep(900);
				cardholdernme.click();
				Thread.sleep(800);
				cardholdernme.sendKeys(crdhldrnme);
				Thread.sleep(700);
				cardno.click();
				Thread.sleep(800);
				cardno.sendKeys(crdno);
				Thread.sleep(800);
				crdcvv.click();
				Thread.sleep(700);
				crdcvv.sendKeys(cardcvvno);
				Thread.sleep(900);
				selectmonth.click();
				Thread.sleep(900);
				selectmonth.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0__ctl4_CreditCardInfo_expireDate_Month']/option[11]")).click();
				Thread.sleep(900);
				selectyear.click();
				Thread.sleep(900);
				selectyear.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0__ctl4_CreditCardInfo_expireDate_Year']/option[11]")).click();
				Thread.sleep(800);
				address.click();
				Thread.sleep(900);
				address.sendKeys(adrs);
				Thread.sleep(800);
				slectstate.click();
				Thread.sleep(700);
				slectstate.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0__ctl4_BillingAddress_StateSel']/option[13]")).click();
				Thread.sleep(800);
				slectcity.click();
				Thread.sleep(700);
				slectcity.sendKeys(cty);
				Thread.sleep(700);
				zipcde.click();
				Thread.sleep(800);
				zipcde.sendKeys(zpcd);
				Thread.sleep(800);
				billingphone.clear();
				Thread.sleep(900);
				billingphone.click();
				Thread.sleep(900);
				billingphone.sendKeys(phne);
				Thread.sleep(800);
		//		banknme.clear();
		//		Thread.sleep(300);
		//		banknme.click();
		//		Thread.sleep(300);
		//		banknme.sendKeys(bnknme);
		//		Thread.sleep(500);
				termsncndtn.click();
				Thread.sleep(1000);
				ClickonContinuebtn.click();
				Thread.sleep(30000);
				
				
				
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
