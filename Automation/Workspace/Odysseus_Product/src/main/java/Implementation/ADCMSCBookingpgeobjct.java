package Implementation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class ADCMSCBookingpgeobjct
{

	 // Cruise Search
	 @FindBy(id="_ctl0_MainContentsPH__ctl0_CruiseAdvancedSearch__ctl0_DateInput")
	 private WebElement Selectfrmdte; 
	
     @FindBy(id="_ctl0_MainContentsPH__ctl0_CruiseAdvancedSearch__ctl1_DateInput")
 	 private WebElement selecttodte;   
		
	 @FindBy(id="_ctl0_MainContentsPH__ctl0_CruiseAdvancedSearch_Suppliers")  
	 private WebElement selectcruiseline;    
		
	 @FindBy(id="_ctl0_MainContentsPH__ctl0_CruiseAdvancedSearch_go")
	 private WebElement Clicksearchbtn;   
	
	
	
	public void BookingToTittle()
	{
		try
		{
			Selectfrmdte.click();
			Thread.sleep(1000);
			Selectfrmdte.findElement(By.xpath("//*[@id='Calendar_StartDate_nextArrow']")).click();
			Thread.sleep(500);
			Selectfrmdte.findElement(By.xpath("//*[@id='Calendar_StartDate_day_0_6']")).click(); //For 01 July 2017
			Thread.sleep(500);
			selecttodte.click();
			Thread.sleep(1000);
			selecttodte.findElement(By.xpath("//*[@id='Calendar_EndDate_nextArrow']")).click();
			Thread.sleep(500);
			selecttodte.findElement(By.xpath("//*[@id='Calendar_EndDate_day_4_3']")).click(); //For 30 August 2017
			Thread.sleep(1000);
			Select select = new Select(selectcruiseline.findElement(By.id("_ctl0_MainContentsPH__ctl0_CruiseAdvancedSearch_Suppliers")));
			select.selectByVisibleText("MSC Cruises"); //MSC Cruises : MSC , Azamara Club Cruises : RCCL
			Thread.sleep(2000);
			Clicksearchbtn.click();
			Thread.sleep(6000);
						
		}
		catch(Exception e)
		{
			 
			   e.printStackTrace();
			     
		}
	}	
		

	public boolean isDisplayed()
	{
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
