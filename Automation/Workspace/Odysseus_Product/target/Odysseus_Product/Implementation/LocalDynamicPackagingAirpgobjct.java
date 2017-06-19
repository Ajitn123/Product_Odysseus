package Implementation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LocalDynamicPackagingAirpgobjct 
{

	 
	       // Search Air (Round Trip)
				@FindBy(xpath="//*[@id='sb-site']/div[2]/div[2]/div[1]/div[1]/div[3]/div/div/div/div[1]/ul[2]/li[1]/a")
				private WebElement ClickonAir;
				
				@FindBy(xpath="//*[@id='select2-AffiliateDropDownList-container']")
				private WebElement selectaffiliate;   
				
				@FindBy(className="select2-search__field")
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
				
				@FindBy(xpath="//*[@id='AirSearchForm_InfantsInLap']")
				private WebElement selectinfant;
				
				@FindBy(xpath="//*[@id='AirSearchForm_InfantsInSeat']")
				private WebElement selectseatinfant;
				
				@FindBy(xpath="//*[@id='AirSearchForm_CurrId']")
				private WebElement SelectCurruncy;
				
				@FindBy(xpath="//*[@id='DDListPopUp']/div[8]")
				private WebElement SelectCurncy;
				
				@FindBy(id="AirSearchForm_SearchButton")
				private WebElement SearchAir;
				
				        
				
		public void AirBookingToTitle(String frmloc, String tolc) 
		{
			try
			{
						
					//	ClickonAir.click();
					//	Thread.sleep(2000);
						selectaffiliate.click();
						Thread.sleep(1000);
						searchaffiliate.click();
						Thread.sleep(700);
						searchaffiliate.sendKeys("doleris");
						Thread.sleep(500);
						searchaffiliate.sendKeys(Keys.TAB);
						Thread.sleep(1000);
						Fromloc.click();
				    	Fromloc.sendKeys(frmloc);
				    	Fromloc.sendKeys(Keys.TAB);
						Thread.sleep(3000);         
					//	selectfrmdte.clear();
					//	selectfrmdte.click(); 
						selectfrmdte.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/div/a/span")).click();
						Thread.sleep(700);
						selectfrmdte.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr[1]/td[4]/a")).click(); // 02 Jan 2018   
						Thread.sleep(3000);              
						Toloc.click(); 
						Toloc.sendKeys(tolc);
						Toloc.sendKeys(Keys.TAB);
						Thread.sleep(3000);
					//	selecttodte.clear();
					//	selecttodte.click();
					//	selecttodte.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/div/a/span")).click();
						selecttodte.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr[5]/td[6]/a")).click();  // 28 Feb 2018
						Thread.sleep(3000);
						selectadlt.click();        
						selectadlt.findElement(By.xpath("//*[@id='DDListPopUp']/div[2]")).click();
						Thread.sleep(3000);
						selectchild.click();
						selectchild.findElement(By.xpath("//*[@id='DDListPopUp']/div[2]")).click();
						Thread.sleep(3000);
						Allclass.click();
						Thread.sleep(2000);
						selectinfant.click();
						selectinfant.findElement(By.xpath("//*[@id='DDListPopUp']/div[2]")).click();
						Thread.sleep(1500);
						selectseatinfant.click();
						selectseatinfant.findElement(By.xpath("//*[@id='DDListPopUp']/div[2]")).click();
						Thread.sleep(3000);
				//		SelectCurruncy.click();
				//		Thread.sleep(800);
				//		SelectCurruncy.click();
				//		Thread.sleep(900);
				//		SelectCurncy.click();
				//		Thread.sleep(1000);
						SearchAir.click();
						Thread.sleep(9000);
				
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
