package Implementation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CDORBookingpgeobjct 
{

	 // Cruise Search
	@FindBy(id="_ctl0_MainContentsPH__ctl0_CruiseAdvancedSearch__ctl0_DateInput")
	private WebElement Selectfrmdte; 
	
    @FindBy(id="_ctl0_MainContentsPH__ctl0_CruiseAdvancedSearch__ctl1_DateInput")
	private WebElement selecttodte;   
		
	@FindBy(id="_ctl0_MainContentsPH__ctl0_CruiseAdvancedSearch_Suppliers")  
	private WebElement selectcruiseline;    
		
	@FindBy(id="_ctl0_MainContentsPH__ctl0_CruiseAdvancedSearch_SearchLNK")
	private WebElement Clicksearchbtn;   
	
	//For cruises/results.aspx?
	@FindBy(className="ns-viewBtn")
	private WebElement bookbtn;  
	
	//For cruises/details.aspx?
	@FindBy(id="_ctl0:MainContentsPH:_ctl0:_ctl1_GuestAge_1")
	private WebElement Guest1;
	
	@FindBy(id="_ctl0:MainContentsPH:_ctl0:_ctl1_GuestAge_2")
	private WebElement Guest2;
	
	@FindBy(id="_ctl0_MainContentsPH__ctl0__ctl1_ResidentState")
	private WebElement selectstate;
	
	@FindBy(id="_ctl0_MainContentsPH__ctl0__ctl1_CategoryIBTN")
	private WebElement selectcontinue;
	
	
	
	
	public void BookingToTittle()
	{
		try
		{
			Selectfrmdte.click();
			Thread.sleep(1000);
			Selectfrmdte.findElement(By.xpath("//*[@id='Calendar_StartDate_nextArrow']")).click();
			Thread.sleep(500);
			Selectfrmdte.findElement(By.xpath("//*[@id='Calendar_StartDate_day_0_2']")).click(); //For 02 May
			Thread.sleep(500);
			selecttodte.click();
			Thread.sleep(1000);
			selecttodte.findElement(By.xpath("//*[@id='Calendar_EndDate_nextArrow']")).click();
			Thread.sleep(500);
			selecttodte.findElement(By.xpath("//*[@id='Calendar_EndDate_day_4_4']")).click(); //For 29 June
			Thread.sleep(1000);
			Select select = new Select(selectcruiseline.findElement(By.id("_ctl0_MainContentsPH__ctl0_CruiseAdvancedSearch_Suppliers")));
			select.selectByVisibleText("Viking Ocean Cruises");  // Oceania Cruises
			Thread.sleep(1000);
			Clicksearchbtn.click();
			Thread.sleep(5000);
						
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
