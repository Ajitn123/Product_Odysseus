package Implementation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class FaregeekBookingpgeobjct 
{
	    
	    @FindBy(id="AirSearchForm_From")
		private WebElement Fromloc;
	    
	    @FindBy(id="AirSearchForm_To")
		private WebElement Toloc;
		
		@FindBy(id="AirSearchForm_FromDate")
		private WebElement selectfrmdte; 
		
		@FindBy(id="AirSearchForm_FromTime")
		private WebElement searchtime;
		
		@FindBy(id="AirSearchForm_ReturnDate")
		private WebElement selecttodte;
		
		@FindBy(id="AirSearchForm_Adults")
		private WebElement selectadlt;
		
		@FindBy(id="AirSearchForm_Children")
		private WebElement selectchild;
		
		@FindBy(xpath="//*[@id='DDListPopUp']/div[1]")
		private WebElement Allclass;
		
		@FindBy(xpath="//*[@id='AirSearchForm']/div/div[2]/div/dl[6]/dd/a[1]/span")
		private WebElement SearchAir;
		
		
		
		
		public void FaregeekbookingToTitle(String frmloc, String tolc)
		{
			try
			{
				
				Fromloc.sendKeys(Keys.ENTER);
		    	Fromloc.sendKeys(frmloc);
		    	Fromloc.sendKeys(Keys.TAB);
				Thread.sleep(3000);
				Toloc.sendKeys(Keys.ENTER);
				Toloc.sendKeys(tolc);
				Toloc.sendKeys(Keys.TAB);
				Thread.sleep(3000);
				selectfrmdte.findElement(By.xpath("//*[@id='CalendarPopUp']/span/table/tbody/tr[1]/td[3]")).click();
				Thread.sleep(500);
				selectfrmdte.findElement(By.xpath("//*[@id='CalendarPopUp']/span/table/tbody/tr[3]/td[7]")).click();   //For 01 Apr 2017
				Thread.sleep(3000);   
				selectfrmdte.sendKeys(Keys.TAB);
				searchtime.findElement(By.xpath("//*[@id='DDListPopUp']/div[1]")).click();
				Thread.sleep(500);
				searchtime.sendKeys(Keys.TAB);
				selecttodte.findElement(By.xpath("//*[@id='CalendarPopUp']/span/table/tbody/tr[1]/td[3]")).click();
				Thread.sleep(500);
				selecttodte.findElement(By.xpath("//*[@id='CalendarPopUp']/span/table/tbody/tr[7]/td[3]")).click(); //For 30 May 2017
	     		Thread.sleep(3000);         
				selectadlt.click();        
				selectadlt.findElement(By.xpath("//*[@id='DDListPopUp']/div[3]")).click();
				Thread.sleep(3000);  
				selectchild.click();
				selectchild.findElement(By.xpath("//*[@id='DDListPopUp']/div[2]")).click();
				Thread.sleep(3000);
				SearchAir.click();
				Thread.sleep(9000);
		
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
