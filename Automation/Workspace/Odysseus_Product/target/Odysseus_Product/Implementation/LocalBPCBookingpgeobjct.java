package Implementation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class LocalBPCBookingpgeobjct 
{
	  
	          // Cruise Search
				@FindBy(xpath="//*[@id='select2-AffiliateDropDownList-container']")
				private WebElement selectaffiliate;   
				
				@FindBy(className="select2-search__field")
				private WebElement searchaffiliate;
				
				@FindBy(xpath="//*[@id='CruiseSearchForm_CruiseLine']")
				private WebElement Selectcruiseline; 
				
			    @FindBy(xpath="//*[@id='CruiseSearchForm_Ship']/optgroup/option[4]")
				private WebElement selectcruiseship;   
					
				@FindBy(xpath="//*[@id='CruiseSearchForm_Month']")  
				private WebElement selectdates;  
					
				@FindBy(xpath="//*[@id='CruiseSearchForm_tab2']/div[2]/div[3]/div/input")
				private WebElement Clicksearchbtn;   
				
				
				
				public void LocalBookingToTittle()
				{
					try
					{
						selectaffiliate.click();
						Thread.sleep(500);
						searchaffiliate.click();
						Thread.sleep(400);
						searchaffiliate.sendKeys("best");
						Thread.sleep(500);
						searchaffiliate.sendKeys(Keys.TAB);
						Thread.sleep(3000);
						Select select = new Select(Selectcruiseline.findElement(By.xpath("//*[@id='CruiseSearchForm_CruiseLine']")));
						select.selectByVisibleText("Princess"); 
						Thread.sleep(1500);
				//		selectcruiseship.click();
				//		Thread.sleep(1500);
						Select select1 = new Select(selectdates.findElement(By.xpath("//*[@id='CruiseSearchForm_Month']")));
						select1.selectByVisibleText("December 2017");
				//		Thread.sleep(1500);
				//		Clicksearchbtn.click();
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
