package Implementation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DPB2Csearchpgeobjct 
{
        
     // Cruise Search
     		@FindBy(id="_ctl0_MainContentsPH__ctl0_CruiseAdvancedSearch__ctl0_DatePicker")
     		private WebElement Selectfrmdte; 
     		
     	    @FindBy(id="_ctl0_MainContentsPH__ctl0_CruiseAdvancedSearch__ctl1_DatePicker")
     		private WebElement selecttodte;   
     	    
     	    @FindBy(xpath="//*[@id='_ctl0_MainContentsPH__ctl0_CruiseAdvancedSearch_Destinations']")  
     		private WebElement Destination;
     	    
     	    @FindBy(xpath="//*[@id='_ctl0_MainContentsPH__ctl0_CruiseAdvancedSearch_DeparturePorts']")  
     		private WebElement Departureport;
     			
     		@FindBy(xpath="//*[@id='_ctl0_MainContentsPH__ctl0_CruiseAdvancedSearch_Suppliers']")  
     		private WebElement selectcruiseline;    
     		
     		@FindBy(xpath="//*[@id='_ctl0_MainContentsPH__ctl0_CruiseAdvancedSearch_Ships']")  
     		private WebElement selectcruiseship;    
     			
     		@FindBy(id="_ctl0_MainContentsPH__ctl0_CruiseAdvancedSearch_go")
     		private WebElement Clicksearchbtn;   
     		
     		
     		
     		public void BookingToTittle()
     		{
     			try
     			{
     				Selectfrmdte.sendKeys(Keys.ENTER);
     				Thread.sleep(1000);
     				Selectfrmdte.sendKeys(Keys.TAB);
     			//	Selectfrmdte.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/a[2]/span")).click();
     			//	Thread.sleep(800);
     			//	Selectfrmdte.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/a[2]/span")).click();
     			//	Thread.sleep(500);
      			//	Selectfrmdte.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[1]/td[4]/a")).click(); //For 2nd Nov
     			//	Thread.sleep(500);
     			//	selecttodte.sendKeys(Keys.ENTER);
     			//	Thread.sleep(1000);
     			//	Selectfrmdte.findElement(By.xpath("//*[@id='ui-datepicker-div']/div/a[2]/span")).click();
     			//	Thread.sleep(500);
     				selecttodte.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[5]/td[4]/a")).click(); //For 31 Dec
     				Thread.sleep(1000);
     		//		Select select2 = new Select(Destination.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_CruiseAdvancedSearch_Destinations']")));
     		//		select2.selectByVisibleText("Bahamas");
     		//		Thread.sleep(1500);
     		//		Select select3 = new Select(Departureport.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_CruiseAdvancedSearch_DeparturePorts']")));
     		//		select3.selectByVisibleText("New York City - NYC");
     		//		Thread.sleep(1500);
     				Select select = new Select(selectcruiseline.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_CruiseAdvancedSearch_Suppliers']")));
     				select.selectByVisibleText("Oceania Cruises"); // Disney, Royal Caribbean
     				Thread.sleep(1500);
     				Select select1 = new Select(selectcruiseship.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_CruiseAdvancedSearch_Ships']")));
     				select1.selectByVisibleText("Oceania Cruises - Nautica"); 
     				Thread.sleep(1000);
     				Clicksearchbtn.click();
     				Thread.sleep(5000);
     							
     			}
     			catch(Exception e)
     			{
     				 
     				   e.getMessage();
     				     
     			}
     		}	
     			

     		public boolean isDisplayed()
     		{
     			// TODO Auto-generated method stub
     			return false;
     		}
 	
}
