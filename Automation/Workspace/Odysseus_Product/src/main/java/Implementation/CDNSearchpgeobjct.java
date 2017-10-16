package Implementation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CDNSearchpgeobjct 
{

	
	     // Cruise Search
	        @FindBy(xpath="//*[@id='sb-site']/div[2]/div[2]/div[1]/div[1]/div[3]/div/div/div/div[1]/ul[2]/li[2]/a")
            private WebElement Selctcruise;
	        
	        @FindBy(xpath="//*[@id='select2-AffiliateDropDownList-container']")
            private WebElement SelctAffiliate; 
	
	        @FindBy(xpath="/html/body/span[2]/span/span[1]/input")
            private WebElement SelctAffiliat;  
	
	        @FindBy(id="_ctl0_MainContentsPH__ctl0_CruiseAdvancedSearch__ctl0_DatePicker")
	        private WebElement selectfromdte;
	        
	        @FindBy(id="_ctl0_MainContentsPH__ctl0_CruiseAdvancedSearch__ctl1_DatePicker")
			private WebElement SelctTodte;    
	        
			@FindBy(xpath="//*[@id='CruiseSearchForm_CruiseLine']")
			private WebElement Selectcruiseline; 
			
			@FindBy(xpath="//*[@id='CruiseSearchForm_Ship']/optgroup/option[4]")
			private WebElement ship;  
			
			@FindBy(xpath="//*[@id='CruiseSearchForm_Month']/option[4]")
			private WebElement month; 
			
			@FindBy(id="CruiseSearchForm_OpenTarget")
			private WebElement newwindow; 
			
			@FindBy(xpath="//*[@id='CruiseSearchForm_tab2']/div[2]/div[3]/div/input")
			private WebElement Clicksearchbtn;   
			
			//For Air 
			@FindBy(id="AirSearchForm_From")
			private WebElement Fromloc;  
			
			@FindBy(id="AirSearchForm_FromDate")
			private WebElement Fromdte; 
			
			@FindBy(id="AirSearchForm_To")
			private WebElement Toloc;  
			
			@FindBy(id="AirSearchForm_FromDate")
			private WebElement Todte; 
			
			@FindBy(xpath="//*[@id='AirSearchForm_Adults']")
			private WebElement Adult; 
			
			@FindBy(xpath="//*[@id='DDListPopUp']/div[2]")
			private WebElement Child;  
			
			@FindBy(xpath="//*[@id='DDListPopUp']/div[1]")
			private WebElement Allclasses;
			
			@FindBy(id="AirSearchForm_SearchButton")
			private WebElement search;
			
			
			
			
			public void CDNCDORToTittle()
			{
				try
				{
					Selctcruise.click();
					Thread.sleep(2000);
					SelctAffiliate.click();
					Thread.sleep(1000);
			//		SelctAffiliat.clear();
			//		Thread.sleep(800);
			//		SelctAffiliat.click();
			//		Thread.sleep(900);
					SelctAffiliat.sendKeys("CDOR");
					Thread.sleep(900);
					SelctAffiliat.sendKeys(Keys.TAB);
					Thread.sleep(1000);
					Select select = new Select(Selectcruiseline.findElement(By.xpath("//*[@id='CruiseSearchForm_CruiseLine']")));
					select.selectByVisibleText("Norwegian");  // Oceania Cruises
					Thread.sleep(1500);
					ship.click();
					Thread.sleep(1000);
					month.click();
					Thread.sleep(900);
					
					if(newwindow.isDisplayed())
					{
						newwindow.click();
						Thread.sleep(1000);
					}
					
					Clicksearchbtn.click();
					Thread.sleep(6000);
								
				}
				catch(Exception e)
				{
					 
					   e.printStackTrace();
					     
				}
			}	
				
			public void CDNDLCToTittle()
			{
				try
				{
					Selctcruise.click();
					Thread.sleep(2000);
					SelctAffiliate.click();
					Thread.sleep(2000);
			//		SelctAffiliat.clear();
			//		Thread.sleep(800);
			//		SelctAffiliat.click();
			//		Thread.sleep(1500);
					SelctAffiliat.sendKeys("DLC");
					Thread.sleep(1500);
					SelctAffiliat.sendKeys(Keys.TAB);
					Thread.sleep(1000);
					Select select = new Select(Selectcruiseline.findElement(By.xpath("//*[@id='CruiseSearchForm_CruiseLine']")));
					select.selectByVisibleText("Norwegian");  // Oceania Cruises
					Thread.sleep(1500);
					ship.click();
					Thread.sleep(1000);
					month.click();
					Thread.sleep(900);
					
					if(newwindow.isDisplayed())
					{
						newwindow.click();
						Thread.sleep(1000);
					}
					
					Clicksearchbtn.click();
					Thread.sleep(6000);
								
				}
				catch(Exception e)
				{
					 
					   e.printStackTrace();
					     
				}
			}	
			
			
			public void CDNFaregeekToTittle(String frmloc, String toloc)
			{
				try
				{
					
					SelctAffiliate.click();
					Thread.sleep(5000);
				//	SelctAffiliat.clear();
				//	Thread.sleep(800);
				//	SelctAffiliat.click();
				//	Thread.sleep(4000);
					SelctAffiliat.sendKeys("faregeek");
					Thread.sleep(900);
					SelctAffiliat.sendKeys(Keys.TAB);
					Thread.sleep(1000);
					Fromloc.clear();
					Thread.sleep(500);
					Fromloc.click();
					Thread.sleep(800);
					Fromloc.sendKeys(frmloc);
					Thread.sleep(900);
					Fromloc.sendKeys(Keys.TAB);
					Thread.sleep(1000);
					Fromdte.click();
					Thread.sleep(800);
					Fromdte.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr[1]/td[7]/a")).click();
					Thread.sleep(900);
					Toloc.clear();
					Thread.sleep(500);
					Toloc.click();
					Thread.sleep(800);
					Toloc.sendKeys(toloc);
					Thread.sleep(900);
					Toloc.sendKeys(Keys.TAB);
					Thread.sleep(1000);
					Todte.click();
					Thread.sleep(800);
					Todte.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/div/a/span")).click();
					Thread.sleep(800);
					Todte.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr[4]/td[4]/a")).click();
					Thread.sleep(900);
					Adult.click();
					Thread.sleep(800);
					Adult.findElement(By.xpath("//*[@id='DDListPopUp']/div[2]")).click();
					Thread.sleep(900);
					Child.click();
					Thread.sleep(1000);
					Allclasses.click();
					Thread.sleep(700);
					search.click();
					Thread.sleep(6000);
								
				}
				catch(Exception e)
				{
					 
					   e.printStackTrace();
					     
				}
			}	
			
			public void CDNFaredepotToTittle(String frmloc, String toloc)
			{
				try
				{
					
					SelctAffiliate.click();
					Thread.sleep(1000);
				//	SelctAffiliat.clear();
				//	Thread.sleep(800);
				//	SelctAffiliat.click();
				//	Thread.sleep(900);
					SelctAffiliat.sendKeys("Faredepot");
					Thread.sleep(900);
					SelctAffiliat.sendKeys(Keys.TAB);
					Thread.sleep(1000);
					Fromloc.clear();
					Thread.sleep(500);
					Fromloc.click();
					Thread.sleep(800);
					Fromloc.sendKeys(frmloc);
					Thread.sleep(900);
					Fromloc.sendKeys(Keys.TAB);
					Thread.sleep(1000);
					Fromdte.click();
					Thread.sleep(800);
					Fromdte.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr[1]/td[7]/a")).click();
					Thread.sleep(900);
					Toloc.clear();
					Thread.sleep(500);
					Toloc.click();
					Thread.sleep(800);
					Toloc.sendKeys(toloc);
					Thread.sleep(900);
					Toloc.sendKeys(Keys.TAB);
					Thread.sleep(1000);
					Todte.click();
					Thread.sleep(800);
					Todte.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/div/a/span")).click();
					Thread.sleep(800);
					Todte.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr[4]/td[4]/a")).click();
					Thread.sleep(900);
					Adult.click();
					Thread.sleep(800);
					Adult.findElement(By.xpath("//*[@id='DDListPopUp']/div[2]")).click();
					Thread.sleep(900);
					Child.click();
					Thread.sleep(1000);
					Allclasses.click();
					Thread.sleep(700);
					search.click();
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
