package Implementation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class OdysolAirBookingpgeobjct 
{

	// Search Air (Round Trip)
	@FindBy(xpath="//*[@id='sb-site']/div[2]/div[2]/div[1]/div[1]/div[3]/div/div/div/div[1]/ul[2]/li[1]/a")
	private WebElement ClickonAir;
	
	@FindBy(xpath="//*[@id='select2-AffiliateDropDownList-container']")
	private WebElement selectaffiliate;   
	
	@FindBy(xpath="/html/body/span[2]/span/span[1]/input")
	private WebElement selectaff;
	
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
	
	        
	
	public void AirBookingToTitle(String frmloc, String tolc) 
	{
		try
		{
			
		//	ClickonAir.click();
		//	Thread.sleep(2000);
		//	selectaffiliate.click();
		//	Thread.sleep(1000);
		//	selectaff.click();
		//	Thread.sleep(800);
		//	selectaff.sendKeys("demo");
		//	Thread.sleep(700);
		//	selectaff.sendKeys(Keys.TAB);
		//	Thread.sleep(3000);
			Fromloc.click();
	    	Fromloc.sendKeys(frmloc);
	    	Fromloc.sendKeys(Keys.TAB);
			Thread.sleep(3000);
		//	selectfrmdte.clear();
		//	selectfrmdte.click();
			selectfrmdte.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr[1]/td[7]/a")).click();   //For 1st july 2016
			Thread.sleep(3000);              
			Toloc.click(); 
			Toloc.sendKeys(tolc);
			Toloc.sendKeys(Keys.TAB);
			Thread.sleep(3000);
		//	selecttodte.clear();
		//	selecttodte.click();
			selecttodte.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr[5]/td[5]/a")).click(); //For 31st Aug 2017
			//selecttodte.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr[5]/td[5]/a")).click(); 
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
