package Implementation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class DLCPurchasepgeobjct 
{

	    //For Purchase page(Passenger details)
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_Title")
	    private WebElement selecttitle; 
	
		@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_GenderSEL")
		private WebElement selectgender;

		@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_FirstName")
		private WebElement firstnme;
		
		@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_MiddleName")
		private WebElement midlenme;
		
		@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_LastName")
		private WebElement lastnme;
		
		@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_DateUC_Month")
		private WebElement month;
		
		@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_DateUC_Day")
		private WebElement Day;
		
		@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_DateUC_Year")
		private WebElement Year;
		
		@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_Nationality")
		private WebElement cntry;
		
		@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_EMail")
		private WebElement eml;
		
		@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_AddressUC_AddrLine1")
		private WebElement strtadd;
		
		@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_AddressUC_CityInput")
		private WebElement cty;
		
		@FindBy(xpath="//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_1_AddressUC_StateSel']")
		private WebElement stte;
		
		@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_AddressUC_ZipCodeInput")
		private WebElement zpecde;
		
		@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_Phone1_Number")
		private WebElement phne; 
		
		//For guest two
		@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_2_Title")
		private WebElement slctitlofgustwo;
		
		@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_2_GenderSEL")
		private WebElement gndrofgustwo;
		
		@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_2_FirstName")
		private WebElement frstnmeofgustwo;
		
		@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_2_MiddleName")
		private WebElement mdlnmeofgustwo;
		
		@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_2_LastName")
		private WebElement lstnmeofgustwo; 
		
		@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_2_DateUC_Month")
		private WebElement monthofgustwo;
		
		@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_2_DateUC_Day")
		private WebElement dayofgustwo;
		
		@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_2_DateUC_Year")
		private WebElement yrsofgustwo;
		
		@FindBy(xpath="//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_2_Nationality']")
		private WebElement contry;
		
		//Click on Book Your Cabin button
		@FindBy(xpath="//*[@id='_ctl0_MainContentsPH__ctl0_ContinueLNK']")
		private WebElement clkonbtn;
		
		
		
		 public void DLCPurchaseToTittle(String frstnme, String mdlnme, String lstnme, String emal, String strtaddr, String cti, String zipcde, String phn, String frstnmofgstwo, String mdlnmofgstwo, String lstnmofgstwo)
		 {
			 
			  try
			  {
				    
				       Select select = new Select(selecttitle.findElement(By.id("_ctl0_MainContentsPH__ctl0_TravelerAccount_1_Title")));
				       select.selectByVisibleText("Mr");  
				       Thread.sleep(500);
				       Select select1 = new Select(selectgender.findElement(By.id("_ctl0_MainContentsPH__ctl0_TravelerAccount_1_GenderSEL")));
					   select1.selectByVisibleText("Male");
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
					   month.click();
					   Thread.sleep(200);
					   month.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_1_DateUC_Month']/option[8]")).click();
					   Thread.sleep(500);
					   Day.click();
					   Thread.sleep(300);
					   Day.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_1_DateUC_Day']/option[24]")).click();
					   Thread.sleep(500);
					   Year.click();
					   Thread.sleep(300);
					   Year.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_1_DateUC_Year']/option[73]")).click();
					   Thread.sleep(500);	
					   cntry.click();
					   Thread.sleep(500);
					   cntry.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_1_Nationality']/option[220]")).click();
					   Thread.sleep(800);
					   eml.clear();
					   Thread.sleep(200);
					   eml.click();
					   Thread.sleep(300);
					   eml.sendKeys(emal);
					   Thread.sleep(500);
					   strtadd.clear();
					   Thread.sleep(500);
					   strtadd.click();
					   Thread.sleep(500);
					   strtadd.sendKeys(strtaddr);
					   Thread.sleep(500);
					   cty.clear();
					   Thread.sleep(400);
					   cty.click();
					   Thread.sleep(700);
					   cty.sendKeys(cti);
					   Thread.sleep(800);
					   Select select02 = new Select(stte.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_1_AddressUC_StateSel']")));
				       select02.selectByVisibleText("Alaska");  
					   Thread.sleep(500);
					   zpecde.clear();
					   Thread.sleep(400);
					   zpecde.click();
					   Thread.sleep(500);
					   zpecde.sendKeys(zipcde);
					   Thread.sleep(500);
					   phne.clear();
					   Thread.sleep(500);
					   phne.click();
					   Thread.sleep(500);
					   phne.sendKeys(phn);
					   Select select3 = new Select(slctitlofgustwo.findElement(By.id("_ctl0_MainContentsPH__ctl0_TravelerAccount_2_Title")));
					   select3.selectByVisibleText("Mrs");
					   Thread.sleep(1000);
					   Select select2 = new Select(gndrofgustwo.findElement(By.id("_ctl0_MainContentsPH__ctl0_TravelerAccount_2_GenderSEL")));
					   select2.selectByVisibleText("Female");
					   Thread.sleep(800);
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
					   monthofgustwo.click();
					   Thread.sleep(500);
					   monthofgustwo.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_2_DateUC_Month']/option[10]")).click();
					   Thread.sleep(800);
					   dayofgustwo.click();
					   Thread.sleep(900);
					   dayofgustwo.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_2_DateUC_Day']/option[20]")).click();
					   Thread.sleep(900);
					   yrsofgustwo.click();
					   Thread.sleep(700);
					   yrsofgustwo.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_2_DateUC_Year']/option[8]")).click();
					   Thread.sleep(800);
					   Select select03 = new Select(contry.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_2_Nationality']")));
					   select03.selectByVisibleText("United States");
					   Thread.sleep(1000);
					   clkonbtn.sendKeys(Keys.ENTER);
					   Thread.sleep(2000);

			  }
			  catch(Exception e)
			  {
				   e.getMessage();
			  }
			 
		 }



		public boolean isDisplayed() {
			// TODO Auto-generated method stub
			return false;
		}
	
}
