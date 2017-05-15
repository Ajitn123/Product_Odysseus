package Implementation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlanitaBookingpgeobjct
{

	@FindBy(id="AirSearchForm_From")
	private WebElement Fromloc;
	
	@FindBy(id="AirSearchForm_FromDate")
	private WebElement selectfrmdte;
	
	@FindBy(id="AirSearchForm_To")
	private WebElement Toloc;
	
	@FindBy(id="AirSearchForm_ReturnDate")
	private WebElement selecttodte;
	
	@FindBy(id="AirSearchForm_Adults")
	private WebElement selectadlt;
	
	@FindBy(id="AirSearchForm_Children")
	private WebElement selectchild;
	
	@FindBy(xpath="//*[@id='DDListPopUp']/div[1]")
	private WebElement Allclass;
	
	@FindBy(id="AirSearchForm_SearchButton")
	private WebElement SearchAir;
	
	
	
	
	public void AlanitabookingToTitle(String frmloc, String tolc)
	{
		try
		{
			
			Fromloc.click();
	    	Fromloc.sendKeys(frmloc);
	    	Fromloc.sendKeys(Keys.TAB);
			Thread.sleep(3000);
			selectfrmdte.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr[1]/td[7]/a")).click();   //For 1 Apr
			Thread.sleep(3000);              
			Toloc.click(); 
			Toloc.sendKeys(tolc);
			Toloc.sendKeys(Keys.TAB);
			Thread.sleep(3000);
			selecttodte.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr[5]/td[3]/a")).click(); //For 30 May
     		Thread.sleep(3000);         
			selectadlt.click();        
			selectadlt.findElement(By.xpath("//*[@id='DDListPopUp']/div[2]")).click();
			Thread.sleep(3000);  
			selectchild.click();
			selectchild.findElement(By.xpath("//*[@id='DDListPopUp']/div[2]")).click();
			Thread.sleep(3000);
			Allclass.click();
			Thread.sleep(2000);
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
	
	

