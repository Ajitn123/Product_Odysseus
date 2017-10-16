package Implementation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class VivaVoyagePurchasepageobjct 
{

	        //For Purchase page(Passenger details)
			@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_GenderSEL")
			private WebElement selectgender;
			
			@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_Title")
			private WebElement selecttitle;
			
			@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_EMail")
			private WebElement eml;
			
			@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_FirstName")
			private WebElement firstnme;
			
			@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_MiddleName")
			private WebElement midlenme;
			
			@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_LastName")
			private WebElement lastnme;
			
			@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_DateUC_Day")
			private WebElement Day;
			
			@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_DateUC_Month")
			private WebElement month;
			
			@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_DateUC_Year")
			private WebElement Year;
			
			@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_Nationality")
			private WebElement cntry;
			
			@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_Phone1_Number")
			private WebElement phne; 
			
			//For guest two
			@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_2_GenderSEL")
			private WebElement gndrofgustwo;
			
			@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_2_Title")
			private WebElement slctitlofgustwo;
			
			@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_2_FirstName")
			private WebElement frstnmeofgustwo;
			
			@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_2_MiddleName")
			private WebElement mdlnmeofgustwo;
			
			@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_2_LastName")
			private WebElement lstnmeofgustwo; 
			
			@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_2_DateUC_Day")
			private WebElement dayofgustwo;
			
			@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_2_DateUC_Month")
			private WebElement monthofgustwo;
			
			@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_2_DateUC_Year")
			private WebElement yrsofgustwo;
			
			@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_2_Nationality")
			private WebElement contry;
			
			//Click on Book Your Cabin button
			@FindBy(id="_ctl0_MainContentsPH__ctl0_FastBookLNK")
			private WebElement clkonbtn;
			
	
			
		 public void PurchaseToTittle(String emal, String frstnme, String mdlnme, String lstnme, String phn, String frstnmofgstwo, String mdlnmofgstwo, String lstnmofgstwo)
		 {
		  	 try
			 {
				   Select select1 = new Select(selectgender.findElement(By.id("_ctl0_MainContentsPH__ctl0_TravelerAccount_1_GenderSEL")));
				   select1.selectByVisibleText("Male");
				   Thread.sleep(500);
				   Select select = new Select(selecttitle.findElement(By.id("_ctl0_MainContentsPH__ctl0_TravelerAccount_1_Title")));
				   select.selectByVisibleText("Mr");
				   Thread.sleep(500);
				   eml.clear();
				   Thread.sleep(200);
				   eml.click();
				   Thread.sleep(300);
				   eml.sendKeys(emal);
				   Thread.sleep(500);
				   firstnme.clear();
				   Thread.sleep(100);
				   firstnme.click();
				   Thread.sleep(300);
				   firstnme.sendKeys(frstnme);
				   Thread.sleep(500);
				   midlenme.clear();
				   Thread.sleep(100);
				   midlenme.click();
				   Thread.sleep(300);
				   midlenme.sendKeys(mdlnme);
				   Thread.sleep(500);
				   lastnme.clear();
				   Thread.sleep(100);
				   lastnme.click();
				   Thread.sleep(300);
				   lastnme.sendKeys(lstnme);
				   Thread.sleep(500);
				   Day.click();
				   Thread.sleep(300);
				   Day.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_1_DateUC_Day']/option[24]")).click();
				   Thread.sleep(500);
				   month.click();
				   Thread.sleep(200);
				   month.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_1_DateUC_Month']/option[8]")).click();
				   Thread.sleep(500);
				   Year.click();
				   Thread.sleep(300);
				   Year.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_1_DateUC_Year']/option[73]")).click();
				   Thread.sleep(500);	
				   cntry.click();
				   Thread.sleep(500);
				   cntry.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_1_Nationality']/option[220]")).click();
				   Thread.sleep(800);
				   phne.clear();
				   Thread.sleep(500);
				   phne.click();
				   Thread.sleep(500);
				   phne.sendKeys(phn);
				   Select select2 = new Select(gndrofgustwo.findElement(By.id("_ctl0_MainContentsPH__ctl0_TravelerAccount_2_GenderSEL")));
				   select2.selectByVisibleText("Female");
				   Thread.sleep(500);
				   Select select3 = new Select(slctitlofgustwo.findElement(By.id("_ctl0_MainContentsPH__ctl0_TravelerAccount_2_Title")));
				   select3.selectByVisibleText("Mrs");
				   Thread.sleep(500);
				   frstnmeofgustwo.clear();
				   Thread.sleep(500);
				   frstnmeofgustwo.click();
				   Thread.sleep(500);
				   frstnmeofgustwo.sendKeys(frstnmofgstwo);
				   Thread.sleep(500);
				   mdlnmeofgustwo.clear();
				   Thread.sleep(500);
				   mdlnmeofgustwo.click();
				   Thread.sleep(500);
				   mdlnmeofgustwo.sendKeys(mdlnmofgstwo);
				   Thread.sleep(500);
				   lstnmeofgustwo.clear();
				   Thread.sleep(500);
				   lstnmeofgustwo.click();
				   Thread.sleep(500);
				   lstnmeofgustwo.sendKeys(lstnmofgstwo);
				   Thread.sleep(500);
				   dayofgustwo.click();
				   Thread.sleep(500);
				   dayofgustwo.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_2_DateUC_Day']/option[20]")).click();
				   Thread.sleep(500);
				   monthofgustwo.click();
				   Thread.sleep(500);
				   monthofgustwo.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_2_DateUC_Month']/option[10]")).click();
				   Thread.sleep(500);
				   yrsofgustwo.click();
				   Thread.sleep(500);
				   yrsofgustwo.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_2_DateUC_Year']/option[75]")).click();
				   Thread.sleep(500);
				   contry.click();
				   Thread.sleep(500);
				   contry.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_2_Nationality']/option[220]")).click();
				   Thread.sleep(1000);
				   clkonbtn.sendKeys(Keys.ENTER);
				   Thread.sleep(2000);
				   
			 }
			 catch(Exception e)
			 {
					 
				   e.printStackTrace();
					     
			 }
				
		
	}

	
}
