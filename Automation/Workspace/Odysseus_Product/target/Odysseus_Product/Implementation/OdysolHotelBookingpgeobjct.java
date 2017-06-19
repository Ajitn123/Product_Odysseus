package Implementation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OdysolHotelBookingpgeobjct 
{

	       // Search Air (Round Trip)
			@FindBy(xpath="//*[@id='sb-site']/div[2]/div[2]/div[1]/div[1]/div[3]/div/div/div/div[1]/ul[2]/li[3]/a")
			private WebElement ClickonHotel;
			
			@FindBy(id="HotelSearchForm_Destination")
			private WebElement selectcity;   
			
			@FindBy(xpath="//*[@id='HotelSearchForm_RoomCount']")
			private WebElement selectroom;
			
			@FindBy(xpath="//*[@id='HotelSearchForm_tab3']/div[3]/div[2]/div/input")
			private WebElement SearchHotel; 
			
			        
			
			public void HotelBookingToTitle() 
			{
				try
				{
					
					ClickonHotel.click();
					Thread.sleep(2000);
					selectcity.click();
					Thread.sleep(800);
					selectcity.sendKeys("new york");
					Thread.sleep(3500);
					selectcity.sendKeys(Keys.ENTER);
					Thread.sleep(1500);
					selectroom.click(); 
					Thread.sleep(800); 
					selectroom.findElement(By.xpath("//*[@id='DDListPopUp']/div[2]")).click();
					Thread.sleep(900);
					SearchHotel.click();
					Thread.sleep(9000);
			
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
