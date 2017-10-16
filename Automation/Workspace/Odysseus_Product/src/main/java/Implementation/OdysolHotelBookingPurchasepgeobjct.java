package Implementation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class OdysolHotelBookingPurchasepgeobjct 
{

	  //For Checkout page (For passenger 1)
	    @FindBy(xpath="//*[@id='_ctl0_MainContentsPH__ctl0_AccomodationRPT__ctl1_HotelGuest_Title']")
	    private WebElement selctitle;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_AccomodationRPT__ctl1_HotelGuest_FirstName")
	    private WebElement Firstnme;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_AccomodationRPT__ctl1_HotelGuest_MiddleName")
	    private WebElement Middlenme;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_AccomodationRPT__ctl1_HotelGuest_LastName")
	    private WebElement lastnme;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_AccomodationRPT__ctl1_HotelGuest_EMail")
	    private WebElement emal;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_AccomodationRPT__ctl1_HotelGuest_Phone1_Number")
	    private WebElement phnnumbr;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl0_TravelerAccount_1_DateUC_Year")
	    private WebElement selctyear;
	    
	    //For passenger 2
	    @FindBy(xpath="//*[@id='_ctl0_MainContentsPH__ctl0_AccomodationRPT__ctl2_HotelGuest_Title']")
	    private WebElement selecttitle;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_AccomodationRPT__ctl2_HotelGuest_FirstName")
	    private WebElement frstnm;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_AccomodationRPT__ctl2_HotelGuest_MiddleName")
	    private WebElement midlnme;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_AccomodationRPT__ctl2_HotelGuest_LastName")
	    private WebElement lstnm; 
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_AccomodationRPT__ctl2_HotelGuest_EMail")
	    private WebElement emladd; 
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_AccomodationRPT__ctl2_HotelGuest_Phone1_Number")
	    private WebElement phntwo; 
	    
	    @FindBy(xpath="//*[@id='_ctl0_MainContentsPH__ctl0_ContinueLNK']")
	    private WebElement clickonPaynow;
	    
	    
	    
	    
	    public void HotelToTitle(String frstnme, String mdlnme, String lstnme, String eml, String phn, String frtnme, String mdalnme, String lstname, String emlad, String phonetwo)
		{
			try
			{
				 
				Select select = new Select(selctitle.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_AccomodationRPT__ctl1_HotelGuest_Title']")));
				select.selectByVisibleText("Mr");
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
				Middlenme.sendKeys(mdlnme);
				Thread.sleep(500);
				lastnme.clear();
				Thread.sleep(500);
				lastnme.click();
				Thread.sleep(500);
				lastnme.sendKeys(lstnme);
				Thread.sleep(500);
				emal.clear();
				Thread.sleep(500);
				emal.sendKeys(eml);
				Thread.sleep(500);
				phnnumbr.clear();
				Thread.sleep(500);
				phnnumbr.sendKeys(phn);
				Thread.sleep(500);
				Select select1 = new Select(selecttitle.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_AccomodationRPT__ctl2_HotelGuest_Title']")));
				select1.selectByVisibleText("Mrs");
				Thread.sleep(500);
				frstnm.clear();
				Thread.sleep(500);
				frstnm.click();
				Thread.sleep(500);
				frstnm.sendKeys(frtnme);
				Thread.sleep(500);
				midlnme.clear();
				midlnme.click();
				Thread.sleep(500);
				midlnme.sendKeys(mdalnme);
				Thread.sleep(500);
				lstnm.clear();
				Thread.sleep(500);
				lstnm.click();
				Thread.sleep(500);
				lstnm.sendKeys(lstname);
				Thread.sleep(500);
				emladd.click();
				Thread.sleep(500);
				emladd.click();
				Thread.sleep(700);
				emladd.sendKeys(emlad);
				Thread.sleep(900);
				phntwo.clear();
				Thread.sleep(500);
				phntwo.click();
				Thread.sleep(700);
				phntwo.sendKeys(phonetwo);
				Thread.sleep(900);
				clickonPaynow.sendKeys(Keys.ENTER);
				Thread.sleep(4000);
			}
			catch(Exception e)
			{
				e.getMessage();
			}
			
		}
	    
	    public boolean isDisplayed() {
			// TODO Auto-generated method stub
			return false;
		}
	  
			
}
