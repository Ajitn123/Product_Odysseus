package Implementation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DPB2Ccheckoutpgeobjct 
{
	  
    //For Checkout page (For passenger 1)
	    @FindBy(xpath="//*[@id='_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl0_TravelerAccount_1_Title']")
	    private WebElement selctitle;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl0_TravelerAccount_1_FirstName")
	    private WebElement Firstnme;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl0_TravelerAccount_1_MiddleName")
	    private WebElement Middlenme;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl0_TravelerAccount_1_LastName")
	    private WebElement lastnme;
	    
	    @FindBy(xpath="//*[@id='_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl0_TravelerAccount_1_DateUC_Month']")
	    private WebElement selctmonth;
	    
	    @FindBy(xpath="//*[@id='_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl0_TravelerAccount_1_DateUC_Day']")
	    private WebElement selctday;
	    
	    @FindBy(xpath="//*[@id='_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl0_TravelerAccount_1_DateUC_Year']")
	    private WebElement selctyear;
	    
	    //For passenger 2
	    @FindBy(xpath="//*[@id='_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl1_TravelerAccount_2_Title']")
	    private WebElement selecttitle;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl1_TravelerAccount_2_FirstName")
	    private WebElement frstnm;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl1_TravelerAccount_2_MiddleName")
	    private WebElement midlnme;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl1_TravelerAccount_2_LastName")
	    private WebElement lstnm;
	    
	    @FindBy(xpath="//*[@id='_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl1_TravelerAccount_2_DateUC_Month']")
	    private WebElement slctmnth;
	    
	    @FindBy(xpath="//*[@id='_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl1_TravelerAccount_2_DateUC_Day']")
	    private WebElement slctday;
	    
	    @FindBy(xpath="//*[@id='_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl1_TravelerAccount_2_DateUC_Year']")
	    private WebElement slctyr;
	    
	    //For passenger 3 (Child)
	    @FindBy(xpath="//*[@id='_ctl0__ctl0_MainContentsParentPH_MainContentsPH__ctl0_BookingPassengers__ctl2_TravelerAccount_3_Title']")
	    private WebElement slctitle;
	    
	    @FindBy(id="_ctl0__ctl0_MainContentsParentPH_MainContentsPH__ctl0_BookingPassengers__ctl2_TravelerAccount_3_FirstName")
	    private WebElement slectfrstname;
	    
	    @FindBy(id="_ctl0__ctl0_MainContentsParentPH_MainContentsPH__ctl0_BookingPassengers__ctl2_TravelerAccount_3_MiddleName")
	    private WebElement mdlename;
	    
	    @FindBy(id="_ctl0__ctl0_MainContentsParentPH_MainContentsPH__ctl0_BookingPassengers__ctl2_TravelerAccount_3_LastName")
	    private WebElement slectlstnme;
	    
	    @FindBy(id="_ctl0__ctl0_MainContentsParentPH_MainContentsPH__ctl0_BookingPassengers__ctl2_TravelerAccount_3_DateUC_Month")
	    private WebElement slectmnth;
	    
	    @FindBy(id="_ctl0__ctl0_MainContentsParentPH_MainContentsPH__ctl0_BookingPassengers__ctl2_TravelerAccount_3_DateUC_Day")
	    private WebElement slectday;
	    
	    @FindBy(id="_ctl0__ctl0_MainContentsParentPH_MainContentsPH__ctl0_BookingPassengers__ctl2_TravelerAccount_3_DateUC_Year")
	    private WebElement slectyr;
	    
	    @FindBy(xpath="//*[@id='st-accordion']/ul/li[2]/div/div[7]/input")
	    private WebElement clickonContinue;
	    
	    //For Booking Contact Information
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_BookingContact_EMail")
	    private WebElement email;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_BookingContact_ConfirmEMail")
	    private WebElement cnfmemail;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_BookingContact_Phone1_Number")
	    private WebElement phoneno;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_BookingContact_PhoneAtDest_Number")
	    private WebElement phoneatdestination;
	    
	    @FindBy(xpath="//*[@id='st-accordion']/ul/li[3]/div/div[2]/input")
	    private WebElement continuebtn;  
	    
	  
	    
	    
	    public void DPB2CFlowToTitle(String frstnme, String mdlnme, String lstnme, String fstnm, String mdlnm, String lastnm, String eml, String coneml, String phone, String phn)
		{
			try
			{
				Select select = new Select(selctitle.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl0_TravelerAccount_1_Title']")));
				select.selectByVisibleText("Mr");
				Thread.sleep(800);
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
				selctmonth.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl0_TravelerAccount_1_DateUC_Month']/option[8]")).click();
				Thread.sleep(500);
				selctday.click();
				Thread.sleep(500);
				selctday.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl0_TravelerAccount_1_DateUC_Day']/option[13]")).click();
				Thread.sleep(500);
				selctyear.click();
				Thread.sleep(500);
				selctyear.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl0_TravelerAccount_1_DateUC_Year']/option[15]")).click();
				Thread.sleep(1000);
				Select select1 = new Select(selecttitle.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl1_TravelerAccount_2_Title']")));
				select1.selectByVisibleText("Mrs");
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
				slctmnth.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl1_TravelerAccount_2_DateUC_Month']/option[7]")).click();
				Thread.sleep(500);
				slctday.click();
				Thread.sleep(500);
				slctday.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl1_TravelerAccount_2_DateUC_Day']/option[12]")).click();
				Thread.sleep(500);
				slctyr.click();
				Thread.sleep(500);
				slctyr.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl1_TravelerAccount_2_DateUC_Year']/option[17]")).click();
				Thread.sleep(1000);
		//		slctitle.click();
		//		Thread.sleep(200);
		//		Select select2 = new Select(slctitle.findElement(By.xpath("//*[@id='_ctl0__ctl0_MainContentsParentPH_MainContentsPH__ctl0_BookingPassengers__ctl2_TravelerAccount_3_Title']")));
		//		select2.selectByVisibleText("Miss");
		//		Thread.sleep(300);
		//		slectfrstname.clear();
		//		Thread.sleep(300);
		//		slectfrstname.click();
		//		Thread.sleep(300);
		//		slectfrstname.sendKeys(firstnm);
		//		Thread.sleep(500);
		//		mdlename.clear();
		//		Thread.sleep(200);
		//		mdlename.click();
		//		Thread.sleep(300);
		//		mdlename.sendKeys(midlnam);
		//		Thread.sleep(500);
		//		slectlstnme.clear();
		//		Thread.sleep(200);
		//		slectlstnme.click();
		//		Thread.sleep(300);
		//		slectlstnme.sendKeys(lastnam);
		//		Thread.sleep(500);
		//		slectmnth.click();
		//		Thread.sleep(200);
		//		slectmnth.findElement(By.xpath("//*[@id='_ctl0__ctl0_MainContentsParentPH_MainContentsPH__ctl0_BookingPassengers__ctl2_TravelerAccount_3_DateUC_Month']/option[8]")).click();
		//		Thread.sleep(500);
		//		slectday.click();
		//		Thread.sleep(200);
		//		slectday.findElement(By.xpath("//*[@id='_ctl0__ctl0_MainContentsParentPH_MainContentsPH__ctl0_BookingPassengers__ctl2_TravelerAccount_3_DateUC_Day']/option[12]")).click();
		//		Thread.sleep(500);
		//		slectyr.click();
		//		Thread.sleep(200);
		//		slectyr.findElement(By.xpath("//*[@id='_ctl0__ctl0_MainContentsParentPH_MainContentsPH__ctl0_BookingPassengers__ctl2_TravelerAccount_3_DateUC_Year']/option[5]")).click();
		//		Thread.sleep(500);
				clickonContinue.click();
				Thread.sleep(1000);
				email.clear();
				Thread.sleep(200);
				email.click();
				Thread.sleep(300);
				email.sendKeys(eml);
				Thread.sleep(500);
				cnfmemail.clear();
				Thread.sleep(200);
				cnfmemail.click();
				Thread.sleep(300);
				cnfmemail.sendKeys(coneml);
				Thread.sleep(500);
				phoneno.clear();
				Thread.sleep(200);
				phoneno.click();
				Thread.sleep(300);
				phoneno.sendKeys(phone);
				Thread.sleep(500);
				phoneatdestination.clear();
				Thread.sleep(200);
				phoneatdestination.click();
				Thread.sleep(400);
				phoneatdestination.sendKeys(phn);
				Thread.sleep(500);
				continuebtn.click();
				Thread.sleep(2000);
				
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
