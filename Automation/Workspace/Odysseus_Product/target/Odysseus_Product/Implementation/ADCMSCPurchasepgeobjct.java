package Implementation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class ADCMSCPurchasepgeobjct 
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
		
		@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_EMail")
		private WebElement eml;
		
		@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_NewsletterNoRadio")
		private WebElement Hotdeals; 
		
		@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_Nationality")
		private WebElement cntry;
		
		@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_Phone1_Number")
		private WebElement phne; 
		
		@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_AddressUC_AddrLine1")
		private WebElement strtadd;
		
		@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_AddressUC_CityInput")
		private WebElement cty;
		
		@FindBy(xpath="//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_1_AddressUC_StateSel']")
		private WebElement stte;
		
		@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_AddressUC_ZipCodeInput")
		private WebElement zpecde;
		
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
		
		@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_2_Nationality")
		private WebElement contry;
		
		@FindBy(xpath="//*[@id='SServ_ANV_0']")
		private WebElement anniversary;
		
		@FindBy(xpath="//*[@id='SServ_ANV_0_Remark']")
		private WebElement howmanyears;
		
		@FindBy(xpath="//*[@id='SServ_BDY_0']")
		private WebElement bdaygustone;
		
		@FindBy(xpath="//*[@id='SServ_BDY_1']")
		private WebElement bdaygusttwo;
		
		@FindBy(xpath="//*[@id='SServ_CAK_0']")
		private WebElement honymoon;
		
		@FindBy(xpath="//*[@id='_ctl0_MainContentsPH__ctl0_XRefBookingSel']")
		private WebElement othereservation;
		
		@FindBy(xpath="//*[@id='_ctl0_MainContentsPH__ctl0_XRefBookingSel']")
		private WebElement askanagent;
		
		//Click on Book Your Cabin button
		@FindBy(xpath="//*[@id='_ctl0_MainContentsPH__ctl0_FastBookLNK']")
		private WebElement clkonbtn;
		
		
		
		 public void ADCPurchaseToTittle(String frstnme, String mdlnme, String lstnme, String emal, String phn, String strtaddr, String cti, String zipcde, String frstnmofgstwo, String mdlnmofgstwo, String lstnmofgstwo)
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
					   eml.clear();
					   Thread.sleep(200);
					   eml.click();
					   Thread.sleep(300);
					   eml.sendKeys(emal);
					   Thread.sleep(800);
					   WebElement el = Hotdeals.findElement(By.id("_ctl0_MainContentsPH__ctl0_TravelerAccount_1_NewsletterNoRadio"));
					   el.click();
				//	   Hotdeals.click();
					   Thread.sleep(700);
					   cntry.click();
					   Thread.sleep(500);
					   cntry.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_1_Nationality']/option[220]")).click();
					   Thread.sleep(800);
					   phne.clear();
					   Thread.sleep(500);
					   phne.click();
					   Thread.sleep(800);
					   phne.sendKeys(phn);
					   Thread.sleep(700);
					   phne.sendKeys(Keys.TAB);
					   phne.sendKeys(Keys.TAB);
					   phne.sendKeys(Keys.TAB);
					   phne.sendKeys(Keys.TAB);
					   strtadd.sendKeys(strtaddr);
					   Thread.sleep(800);
					   strtadd.sendKeys(Keys.TAB);
					   strtadd.sendKeys(Keys.TAB);
					   cty.sendKeys(cti);
					   Thread.sleep(700);
					   cty.sendKeys(Keys.TAB);
					   stte.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_1_AddressUC_StateSel']/option[3]")).click();
					   Thread.sleep(800);
					   stte.sendKeys(Keys.TAB);
					   zpecde.sendKeys(zipcde);
					   Thread.sleep(500);
					   zpecde.sendKeys(Keys.TAB);
					   Select select3 = new Select(slctitlofgustwo.findElement(By.id("_ctl0_MainContentsPH__ctl0_TravelerAccount_2_Title")));
					   select3.selectByVisibleText("Mrs");
					   Thread.sleep(1000);
					   Select select2 = new Select(gndrofgustwo.findElement(By.id("_ctl0_MainContentsPH__ctl0_TravelerAccount_2_GenderSEL")));
					   select2.selectByVisibleText("Female");
					   Thread.sleep(800);
					   gndrofgustwo.sendKeys(Keys.TAB);
					   frstnmeofgustwo.sendKeys(frstnmofgstwo);
					   Thread.sleep(500);
					   frstnmeofgustwo.sendKeys(Keys.TAB);
					   mdlnmeofgustwo.sendKeys(mdlnmofgstwo);
					   Thread.sleep(500);
					   mdlnmeofgustwo.sendKeys(Keys.TAB);
					   lstnmeofgustwo.sendKeys(lstnmofgstwo);
					   lstnmeofgustwo.sendKeys(Keys.TAB);
					   Thread.sleep(500);
					   monthofgustwo.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_2_DateUC_Month']/option[10]")).click();
					   Thread.sleep(500);
					   monthofgustwo.sendKeys(Keys.TAB);
					   dayofgustwo.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_2_DateUC_Day']/option[14]")).click();
					   Thread.sleep(500);
					   dayofgustwo.sendKeys(Keys.TAB);
					   yrsofgustwo.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_2_DateUC_Year']/option[75]")).click();
					   Thread.sleep(500);
					   yrsofgustwo.sendKeys(Keys.TAB);
					   contry.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_2_Nationality']/option[220]")).click();
					   Thread.sleep(1000);
					   contry.sendKeys(Keys.TAB);
					   othereservation.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_XRefBookingSel']/option[1]")).click();
					   Thread.sleep(1000);
					   othereservation.sendKeys(Keys.TAB);
					   askanagent.sendKeys(Keys.ENTER);
					   Thread.sleep(800);
					   askanagent.sendKeys(Keys.ESCAPE);
					   Thread.sleep(1000);
					   askanagent.sendKeys(Keys.TAB);
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
