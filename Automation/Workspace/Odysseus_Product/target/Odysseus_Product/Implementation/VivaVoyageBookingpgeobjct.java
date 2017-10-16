package Implementation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class VivaVoyageBookingpgeobjct
{

	   // Cruise Search
		@FindBy(id="_ctl0_MainContentsPH__ctl0_CruiseAdvancedSearch__ctl0_DatePicker")
		private WebElement Selectfrmdte; 
		
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_CruiseAdvancedSearch__ctl1_DatePicker")
		private WebElement selecttodte;   
			
		@FindBy(id="_ctl0_MainContentsPH__ctl0_CruiseAdvancedSearch_Suppliers")  
		private WebElement selectcruiseline;    
			
		@FindBy(id="_ctl0_MainContentsPH__ctl0_CruiseAdvancedSearch_go")
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
		//		Selectfrmdte.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[1]/td[4]/a")).click(); //For 02 Nov
		//		Thread.sleep(500);
				Selectfrmdte.sendKeys(Keys.TAB);
		//		selecttodte.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/a[2]/span")).click();
		//		Thread.sleep(500);
				selecttodte.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[5]/td[4]/a")).click(); //For 30 Nov
				Thread.sleep(1000);
				Select select = new Select(selectcruiseline.findElement(By.id("_ctl0_MainContentsPH__ctl0_CruiseAdvancedSearch_Suppliers")));
				select.selectByVisibleText("Norwegian Cruise Line"); // Viva Voyage: Norwegian Cruise Line 
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
