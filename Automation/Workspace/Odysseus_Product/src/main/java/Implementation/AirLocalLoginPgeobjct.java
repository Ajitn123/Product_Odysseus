package Implementation;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AirLocalLoginPgeobjct 
{
 	
	@FindBy(id="UserName")
	private WebElement username;
	
	@FindBy(id="UserPassword")
	private WebElement password;
	
	@FindBy(id="SubmitBTN")
	private WebElement loginbtn;
	
	//For Select Website
	@FindBy(xpath="//*[@id='content_wrapper']/div[1]/div/div/div[2]/div/div/div/div/div[1]/div/div[2]/table/tbody/tr[7]/td[3]/a[1]")
	private WebElement Selectweb; 
		
	
	
	public void LoginToTittle(String usrnme, String paswrd)
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
			Thread.sleep(1000);
			Selectweb.click();
			Thread.sleep(15000);
						
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
