package Implementation;

import java.io.File;
import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Login 
{
  
	private static final TakesScreenshot driver = null;

	@FindBy(id="UserName")
	private WebElement username;
	
	@FindBy(id="UserPassword")
	private WebElement password;
	
	@FindBy(id="SubmitBTN")
	private WebElement loginbtn;
	
	//For Select Website
	@FindBy(xpath="//*[@id='aspnetForm']/table/tbody/tr/td[1]/table[1]/tbody/tr/td/table/tbody/tr[5]/td[3]/a[1]")
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
			Thread.sleep(10000);
						
		}
		catch(Exception e)
		{
			
			File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				
			   try
			   {
				    FileUtils.copyFile(scr, new File("D:\\Ajit\\Script_SS\\login\\bookingpge.jpg"));
				
			   } catch(Exception e1)
			     {
				     e1.printStackTrace();
				    
			     }  
			
		}
		
		
	}


	public boolean isDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
}
