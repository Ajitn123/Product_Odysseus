package Implementation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LocalDynamicPackagingBookingpgeobjct
{

	 
	           // Cruise Search
	            @FindBy(xpath="//*[@id='sb-site']/div[2]/div[2]/div[1]/div[1]/div[3]/div/div/div/div[1]/ul[2]/li[2]/a")
	            private WebElement Slctcruiseline;  
	    
				@FindBy(xpath="//*[@id='CruiseSearchForm_CruiseLine']/option[4]")
				private WebElement Selectcruiseline;  
				
			    @FindBy(xpath="//*[@id='CruiseSearchForm_Ship']/optgroup/option[4]")
				private WebElement selectcruiseship;    
					
				@FindBy(xpath="//*[@id='CruiseSearchForm_Month']/option[2]")  
				private WebElement selectdates;  
					
				@FindBy(xpath="//*[@id='CruiseSearchForm_tab2']/div[2]/div[3]/div/input")
				private WebElement Clicksearchbtn;   
				
				
				
				public void DynamicBookingToTittle()
				{
					try
					{
						Slctcruiseline.click();
						Thread.sleep(1500);
						Selectcruiseline.click();
						Thread.sleep(1500);
					//	selectcruiseship.click();
					//	Thread.sleep(1500);
						selectdates.click();
						Thread.sleep(1500);
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
