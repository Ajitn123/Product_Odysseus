package Implementation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CDNLoginpgeobjct 
{
	 
	    @FindBy(id="UserName")
		private WebElement username;
		
		@FindBy(id="UserPassword")
		private WebElement password;
		
		@FindBy(id="SubmitBTN")
		private WebElement loginbtn;
		
		//For Select Website
		@FindBy(xpath="//*[@id='sb-site']/div[2]/div/div[1]/div[1]/div/div/div[2]/div/div/div/div/div[1]/div/div[2]/table/tbody/tr[73]/td[3]/a[1]") // For Odysseus Pre production-USD
		private WebElement Selectweb; 
		
			
		
		public void cdnLoginToTittle(String usrnme, String paswrd)
		{
			try
			{
				
				username.clear();
				Thread.sleep(300);
				username.click();
				username.sendKeys(usrnme);
				Thread.sleep(500);
				password.clear();
				Thread.sleep(300);
				password.click();
				password.sendKeys(paswrd);
				Thread.sleep(500);
				loginbtn.click();
				Thread.sleep(1500);
				Selectweb.click();
				Thread.sleep(12000);
							
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