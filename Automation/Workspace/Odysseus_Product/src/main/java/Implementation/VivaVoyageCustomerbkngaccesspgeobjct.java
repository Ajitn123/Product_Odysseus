package Implementation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VivaVoyageCustomerbkngaccesspgeobjct 
{

	  
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_conf_number")
		private WebElement Confno;
		
		@FindBy(id="_ctl0_MainContentsPH__ctl0_l_name")
		private WebElement Lastnme;
		
		
		
		
		public void VivaVoyageCustomerbookingAccessToTitle(String pnr, String lstnme)
		{
			try
			{
				Confno.clear();
				Thread.sleep(500);
				Confno.click();
				Thread.sleep(900);
				Confno.sendKeys(pnr);
				Thread.sleep(1000);
				Lastnme.clear();
				Thread.sleep(400);
				Lastnme.click();
				Thread.sleep(900);
				Lastnme.sendKeys(lstnme);
				Thread.sleep(1000);
		
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
