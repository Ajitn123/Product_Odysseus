package Implementation;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LocalCruisebkngpgeobjct
{
	 
	        // Cruise Search
	        @FindBy(xpath="//*[@id='select2-AffiliateDropDownList-container']")
	        private WebElement Selectaffiliate;   
	        
	        @FindBy(xpath="/html/body/span[2]/span/span[1]/input")
			private WebElement Selectaffi;  
	        
			@FindBy(xpath="//*[@id='CruiseSearchForm_CruiseLine']/option[21]")
			private WebElement Selectcruiseline;  
			
		    @FindBy(xpath="//*[@id='CruiseSearchForm_Ship']/optgroup/option[1]")
			private WebElement selectcruiseship;    
				
			@FindBy(xpath="//*[@id='CruiseSearchForm_Month']/option")  
			private WebElement selectdates;  
			
			@FindBy(xpath="//*[@id='CruiseSearchForm_OpenTarget']")  
			private WebElement selectnewtab;  
				
			@FindBy(xpath="//*[@id='CruiseSearchForm_tab2']/div[2]/div[3]/div/input")
			private WebElement Clicksearchbtn;   
			
			
			
			public void LocalBookingToTittle()
			{
				try
				{
					Selectaffiliate.click();
					Thread.sleep(800);
					Selectaffi.clear();
					Thread.sleep(500);
					Selectaffi.click();
					Thread.sleep(800);
					Selectaffi.sendKeys("Blueclassicdark");
					Thread.sleep(700);
					Selectaffi.sendKeys(Keys.TAB);
					Thread.sleep(800);
					Selectcruiseline.click();
					Thread.sleep(1500);
					selectcruiseship.click();
					Thread.sleep(1500);
					selectdates.click();
					Thread.sleep(1500);
				//	selectnewtab.click();
				//	Thread.sleep(900);
				//	Clicksearchbtn.click();
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
