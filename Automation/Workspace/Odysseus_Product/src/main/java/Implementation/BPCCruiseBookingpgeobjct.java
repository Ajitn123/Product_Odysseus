package Implementation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class BPCCruiseBookingpgeobjct 
{

	// Cruise Search
	@FindBy(id="StartDate")
	private WebElement Selectfrmdte; 
	
    @FindBy(id="EndDate")
	private WebElement selecttodte;   
		
	@FindBy(xpath="//select[@id='Suppliers']")  
	private WebElement selectcruiseline;    
		
	@FindBy(id="btnSearch")
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
			Selectfrmdte.sendKeys(Keys.ENTER);
			Thread.sleep(1000);
	//		Selectfrmdte.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/a[2]/span")).click();
	//		Thread.sleep(500);
	//		Selectfrmdte.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[1]/td[7]/a")).click(); //For 01 April
	//		Thread.sleep(500);
	//		selecttodte.click();
			Selectfrmdte.sendKeys(Keys.TAB);
			Thread.sleep(1000);
	//		selecttodte.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/a[2]/span")).click();
	//		Thread.sleep(500);
			selecttodte.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr[5]/td[3]/a")).click(); //For 30 Jan
			Thread.sleep(1000);
			Select select = new Select(selectcruiseline.findElement(By.xpath("//select[@id='Suppliers']")));
   		    select.deselectAll();
			Thread.sleep(400);
			Select select1 = new Select(selectcruiseline.findElement(By.xpath("//select[@id='Suppliers']")));
			select1.selectByVisibleText("Seabourn"); // Viva Voyage: Norwegian Cruise Line, BPC: Seabourn, 
			Thread.sleep(1000);
			Clicksearchbtn.sendKeys(Keys.ENTER);
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
