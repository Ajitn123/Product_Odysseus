package Implementation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LocalAirBookingpgeobjectforOdysseus 
{
	  
	   // Search Air (Round Trip)
		@FindBy(xpath="//*[@id='sb-site']/div[2]/div[2]/div[1]/div[1]/div[3]/div/div/div/div[1]/ul[2]/li[1]/a")
		private WebElement ClickonAir;
		
		@FindBy(xpath="//*[@id='select2-AffiliateDropDownList-container']")
		private WebElement selectaffiliate;   
		
		@FindBy(xpath="/html/body/span[2]/span/span[1]/input")
		private WebElement searchaffiliate;
		
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
		
		@FindBy(xpath="//*[@id='AirSearchForm_CurrId']")
		private WebElement selctCurrency; 
		
		@FindBy(xpath="//*[@id='DDListPopUp']/div[8]")
		private WebElement selctCurrncy;
		
		@FindBy(id="AirSearchForm_SearchButton")
		private WebElement SearchAir;
		
		//For One Way
		@FindBy(xpath="//*[@id='AirSearchForm']/div/div[1]/div/ul/li[2]/a")
		private WebElement Selctonewaytrip;
		
		@FindBy(id="AirSearchForm_InfantsInLap")
		private WebElement Lapinfrant;

        //For Multi city
		@FindBy(xpath="//*[@id='AirSearchForm']/div/div[1]/div/ul/li[3]/a")
		private WebElement Selctmultitrip; 
		
		@FindBy(id="AirSearchForm_FromCity_0")
		private WebElement fromloctn;
		
		@FindBy(id="AirSearchForm_ToCity_0")
		private WebElement Toloctn;
		
		@FindBy(id="AirSearchForm_FromCity_1")
		private WebElement fromone;
		
		@FindBy(id="AirSearchForm_ToCity_1")
		private WebElement Twoloc;
		
		@FindBy(xpath="//*[@id='AirSearchForm_InfantsInLap']")
		private WebElement infant; 
		
		
		
		
		public void AirBookingToTitle(String frmloc, String tolc) 
		{
			try
			{
				
				ClickonAir.click();
				Thread.sleep(2000);
		//		selectaffiliate.click();
		//		Thread.sleep(2000);
		//		searchaffiliate.click();
		//		Thread.sleep(1000);
		//		searchaffiliate.sendKeys("Faredepot");
		//		Thread.sleep(1500);
		//		searchaffiliate.sendKeys(Keys.TAB);
				Fromloc.click();
		    	Fromloc.sendKeys(frmloc);
		    	Fromloc.sendKeys(Keys.TAB);
				Thread.sleep(3000);         
			//	selectfrmdte.clear();
			//	selectfrmdte.click();
				selectfrmdte.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr[2]/td[1]/a")).click(); // 03 Sept 2017   
				Thread.sleep(3000);              
				Toloc.click(); 
				Toloc.sendKeys(tolc);
				Toloc.sendKeys(Keys.TAB);
				Thread.sleep(3000);
			//	selecttodte.clear();
			//	selecttodte.click();
			//	selecttodte.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/div/a/span")).click();
				selecttodte.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr[5]/td[2]/a")).click();  // 30 Oct 2017
				Thread.sleep(3000);         
				selectadlt.click();        
				selectadlt.findElement(By.xpath("//*[@id='DDListPopUp']/div[2]")).click();
				Thread.sleep(3000);
				selectchild.click();
				selectchild.findElement(By.xpath("//*[@id='DDListPopUp']/div[2]")).click();
				Thread.sleep(3000);
				Allclass.click();
				Thread.sleep(2000);
				selctCurrency.click();
				Thread.sleep(1000);
				selctCurrncy.click();
				Thread.sleep(1000);
				SearchAir.click();
				Thread.sleep(9000);
		
			}	
			
			catch(Exception e)
			{
			   e.printStackTrace();
			}
		
		}
		
		public void OneWayAirBookingToTitle(String frmloc, String tolc) 
		{
			try
			{
				
				ClickonAir.click();
				Thread.sleep(2000);
				selectaffiliate.click();
				Thread.sleep(2000);
				searchaffiliate.click();
				Thread.sleep(1000);
				searchaffiliate.sendKeys("g-ad");
				Thread.sleep(1500);
				searchaffiliate.sendKeys(Keys.TAB);
				Thread.sleep(1500);
				Selctonewaytrip.click();
				Thread.sleep(1500);
				Fromloc.click();
		    	Fromloc.sendKeys(frmloc);
		    	Fromloc.sendKeys(Keys.TAB);
				Thread.sleep(3000);         
			//	selectfrmdte.clear();
			//	selectfrmdte.click();
				selectfrmdte.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr[2]/td[1]/a")).click(); // 03 Sept 2017   
				Thread.sleep(3000);              
				Toloc.click(); 
				Toloc.sendKeys(tolc);
				Toloc.sendKeys(Keys.TAB);
				Thread.sleep(3000);
			//	selectadlt.click();        
				selectadlt.findElement(By.xpath("//*[@id='DDListPopUp']/div[1]")).click();
				Thread.sleep(3000);
				selectchild.click();
				selectchild.findElement(By.xpath("//*[@id='DDListPopUp']/div[2]")).click();
				Thread.sleep(3000);
				Allclass.click();
				Thread.sleep(2000);
				Lapinfrant.click();
				Thread.sleep(500);
				Lapinfrant.findElement(By.xpath("//*[@id='DDListPopUp']/div[2]")).click();
				Thread.sleep(1500);
				selctCurrency.click();
				Thread.sleep(1000);
				selctCurrncy.click();
				Thread.sleep(1000);
				SearchAir.click();
				Thread.sleep(9000);
		
			}	
			
			catch(Exception e)
			{
			   e.printStackTrace();
			}
		
		}
		
		public void MulticityAirBookingToTitle(String frmloc, String tolc) 
		{
			try
			{
				
				ClickonAir.click();
				Thread.sleep(2000);
				Selctmultitrip.click();
				Thread.sleep(900);
		//		selectaffiliate.click();
		//		Thread.sleep(2000);
		//		searchaffiliate.click();
		//		Thread.sleep(1000);
		//		searchaffiliate.sendKeys("Faredepot");
		//		Thread.sleep(1500);
		//		searchaffiliate.sendKeys(Keys.TAB);
				fromloctn.click();
				fromloctn.sendKeys(frmloc);
				fromloctn.sendKeys(Keys.TAB);
				Thread.sleep(3000);         
			//	selectfrmdte.clear();
			//	selectfrmdte.click();
			//	selectfrmdte.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/div/a/span")).click();
			//	Thread.sleep(900);
				selectfrmdte.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr[5]/td[5]/a")).click(); // 28 sept 2017   
				Thread.sleep(3000);              
				Toloctn.click(); 
				Toloctn.sendKeys(tolc);
				Toloctn.sendKeys(Keys.TAB);
				Thread.sleep(3000);
				Allclass.click();
				fromone.click();
				Thread.sleep(900);
				fromone.sendKeys("delhi");
				Thread.sleep(1000);
				fromone.sendKeys(Keys.TAB);
				Thread.sleep(500);
			//	selecttodte.clear();
			//	selecttodte.click();
				selectfrmdte.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/div/a/span")).click();
				Thread.sleep(600);
				selecttodte.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr[5]/td[3]/a")).click();  // 28 Nov 2017
				Thread.sleep(3000);  
				Twoloc.click();
				Thread.sleep(500);
				Twoloc.sendKeys("mumbai");
				Thread.sleep(1000);
				Twoloc.sendKeys(Keys.TAB);
				Thread.sleep(500);
				Allclass.click();
				Thread.sleep(800);
				selectadlt.click();        
				selectadlt.findElement(By.xpath("//*[@id='DDListPopUp']/div[2]")).click();
				Thread.sleep(3000);
				infant.click();
				infant.findElement(By.xpath("//*[@id='DDListPopUp']/div[2]")).click();
				Thread.sleep(3000);
				selctCurrency.click();
				Thread.sleep(1000);
				selctCurrncy.click();
				Thread.sleep(1000);
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
