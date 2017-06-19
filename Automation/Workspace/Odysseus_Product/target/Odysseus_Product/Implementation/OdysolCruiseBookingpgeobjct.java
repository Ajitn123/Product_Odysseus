package Implementation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class OdysolCruiseBookingpgeobjct 
{

	  
	   // Search Air (Round Trip)
		@FindBy(xpath="//*[@id='sb-site']/div[2]/div[2]/div[1]/div[1]/div[3]/div/div/div/div[1]/ul[2]/li[2]/a")
		private WebElement ClickonCruise;
		
		@FindBy(id="AffiliateDropDownList")
		private WebElement selectaffiliate;   
		
		@FindBy(xpath="//*[@id='CruiseSearchForm_CruiseLine']/option[17]")
		private WebElement selectcruiseline;
		
		@FindBy(xpath="//*[@id='CruiseSearchForm_Month']/option[6]")
		private WebElement selectdate;
		
		@FindBy(id="CruiseSearchForm_OpenTarget")
		private WebElement Allclass; 
		
		@FindBy(xpath="//*[@id='CruiseSearchForm_tab2']/div[2]/div[3]/div/input")
		private WebElement SearchCruise; 
		
		        
		
		public void CruiseBookingToTitle() 
		{
			try
			{
				
				ClickonCruise.click();
				Thread.sleep(2000);
			//	selectaffiliate.click();
			//	selectaffiliate.findElement(By.xpath("//*[@id='AffiliateDropDownList']/option[10]")).click();
			//	Thread.sleep(3000);
				selectcruiseline.click();
				Thread.sleep(3000);
				selectdate.click();
				Thread.sleep(4000);              
			//	Allclass.click();
			//	Thread.sleep(2000);
			//	SearchCruise.click();
			//	Thread.sleep(9000);
		
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
