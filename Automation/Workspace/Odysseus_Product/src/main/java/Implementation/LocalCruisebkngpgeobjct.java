package Implementation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LocalCruisebkngpgeobjct
{
	 
	        // Cruise Search
			@FindBy(xpath="//*[@id='CruiseSearchForm_CruiseLine']/option[10]")
			private WebElement Selectcruiseline;  
			
		    @FindBy(xpath="//*[@id='CruiseSearchForm_Ship']/optgroup/option[4]")
			private WebElement selectcruiseship;   
				
			@FindBy(xpath="//*[@id='CruiseSearchForm_Month']/option[2]")  
			private WebElement selectdates;  
				
			@FindBy(xpath="//*[@id='CruiseSearchForm_tab2']/div[2]/div[3]/div/input")
			private WebElement Clicksearchbtn;   
			
			
			
			public void LocalBookingToTittle()
			{
				try
				{
					Selectcruiseline.click();
					Thread.sleep(1500);
					selectcruiseship.click();
					Thread.sleep(1500);
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
