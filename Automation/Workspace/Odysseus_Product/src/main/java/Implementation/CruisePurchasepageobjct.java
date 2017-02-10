package Implementation;

import java.io.File;
import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class CruisePurchasepageobjct
{

	  private static final TakesScreenshot driver = null;
	 
	    //For Purchase page(Passenger details)
		@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_Title")
		private WebElement selecttittle;
		
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
		
		@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_AddressUC_AddrLine1")
		private WebElement Address;
		
		@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_AddressUC_CityInput")
		private WebElement cty; 
		
		@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_AddressUC_StateSel")
		private WebElement State;
		
		@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_AddressUC_ZipCodeInput")
		private WebElement Pncode;
		
		@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_EMail")
		private WebElement Email;
		
		@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_Phone1_Number")
		private WebElement Phne;
		
		//For Guest Two
		@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_2_Title")
		private WebElement Titleofguesttwo;
		
		@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_2_GenderSEL")
		private WebElement Gendertwo;
		
		@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_2_FirstName")
		private WebElement Firstnmeofguesttwo;
		
		@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_2_MiddleName")
		private WebElement Middlenmeofguesttwo;
		
		@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_2_LastName")
		private WebElement Lastnmeofguesttwo;
		
		@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_2_DateUC_Month")
		private WebElement Monthofguesttwo;
		
		@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_2_DateUC_Day")
		private WebElement Dayofguesttwo;
		
		@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_2_DateUC_Year")
		private WebElement Yearofguesttwo;
		
		@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_2_Nationality")
		private WebElement selctcntry;
		
		//For Dining Preference 
		@FindBy(id="DiningPrefOption_1")
		private WebElement diningpref;
		
		//Table size preferences
		@FindBy(id="_ctl0_MainContentsPH__ctl0_DiningTblSizeSEL")
		private WebElement tblszepref;
		
		//For select bed preference
		@FindBy(id="BedTypePrefOption_2")
		private WebElement bedpref;
		
		//For select special requests
		@FindBy(id="cb6")
		private WebElement spclreq;
		
		@FindBy(id="SServ_PPGR_0")
		private WebElement selctservce;
		
		//For click on continue to final booking review button
		@FindBy(xpath="//*[@id='_ctl0_MainContentsPH__ctl0_ContinueLNK']/span[1]")
		private WebElement clckonfnalbkng;
		
		
		
	 public void PurchaseToTittle(String frstnme, String mdlnme, String lstnme, String addrss, String ct, String pncde, String eml, String phn, String frstnmeoftwo, String mdlnmetwo, String lstnmetwo)
	 {
	  	 try
		 {
	  		   Select select = new Select(selecttittle.findElement(By.id("_ctl0_MainContentsPH__ctl0_TravelerAccount_1_Title")));
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
			   Address.clear();
			   Thread.sleep(200);
			   Address.click();
			   Thread.sleep(300);
			   Address.sendKeys(addrss);
			   Address.sendKeys(Keys.TAB);
			   Address.sendKeys(Keys.TAB);
			   Thread.sleep(500);
			   cty.clear();
			   Thread.sleep(500);
			   cty.sendKeys(ct);
			   cty.sendKeys(Keys.TAB);
			   Thread.sleep(500);
			   State.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_1_AddressUC_StateSel']/option[3]")).click();
			   State.sendKeys(Keys.TAB);
			   Thread.sleep(1000);
			   Pncode.clear();
			   Thread.sleep(200);
			   Pncode.sendKeys(pncde);
			   Pncode.sendKeys(Keys.TAB);
			   Thread.sleep(500);
			   Email.clear();
			   Thread.sleep(200);
			   Email.sendKeys(eml);
			   Email.sendKeys(Keys.TAB);
			   Thread.sleep(500);
			   Phne.clear();
			   Thread.sleep(200);
			   Phne.sendKeys(phn);
			   Phne.sendKeys(Keys.TAB);
			   Phne.sendKeys(Keys.TAB);
			   Phne.sendKeys(Keys.TAB);
			   Phne.sendKeys(Keys.TAB);
			   Thread.sleep(1000);
			   Select select2 = new Select(Titleofguesttwo.findElement(By.id("_ctl0_MainContentsPH__ctl0_TravelerAccount_2_Title")));
			   select2.selectByVisibleText("Mr");
			   Thread.sleep(500);
			   Select select3 = new Select(Gendertwo.findElement(By.id("_ctl0_MainContentsPH__ctl0_TravelerAccount_2_GenderSEL")));
			   select3.selectByVisibleText("Male");
			   Thread.sleep(500);
			   Firstnmeofguesttwo.clear();
			   Thread.sleep(200);
			   Firstnmeofguesttwo.click();
			   Thread.sleep(300);
			   Firstnmeofguesttwo.sendKeys(frstnmeoftwo);
			   Thread.sleep(500);
			   Middlenmeofguesttwo.clear();
			   Thread.sleep(200);
			   Middlenmeofguesttwo.click();
			   Thread.sleep(300);
			   Middlenmeofguesttwo.sendKeys(mdlnmetwo);
			   Thread.sleep(500);
			   Lastnmeofguesttwo.clear();
			   Thread.sleep(200);
			   Lastnmeofguesttwo.click();
			   Thread.sleep(300);
			   Lastnmeofguesttwo.sendKeys(lstnmetwo);
			   Lastnmeofguesttwo.sendKeys(Keys.TAB);
			   Thread.sleep(500);
			   Monthofguesttwo.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_2_DateUC_Month']/option[10]")).click();
			   Monthofguesttwo.sendKeys(Keys.TAB);
			   Thread.sleep(500);
			   Dayofguesttwo.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_2_DateUC_Day']/option[19]")).click();
			   Dayofguesttwo.sendKeys(Keys.TAB);
			   Thread.sleep(500);
			   Yearofguesttwo.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_2_DateUC_Year']/option[75]")).click();
			   Yearofguesttwo.sendKeys(Keys.TAB);
			   Thread.sleep(200);
			   selctcntry.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_2_Nationality']/option[220]")).click();
			   selctcntry.sendKeys(Keys.TAB);
			   selctcntry.sendKeys(Keys.TAB);
			   Thread.sleep(1000);
			   diningpref.click();
			   diningpref.sendKeys(Keys.TAB);
			   tblszepref.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_DiningTblSizeSEL']/option[2]")).click();
			   tblszepref.sendKeys(Keys.TAB);
			   Thread.sleep(500);
			   bedpref.click();
			   bedpref.sendKeys(Keys.TAB);
			   bedpref.sendKeys(Keys.TAB);
			   bedpref.sendKeys(Keys.TAB);
			   bedpref.sendKeys(Keys.TAB);
			   Thread.sleep(500);
			   spclreq.click();    //For pre_paid gratuities
			   Thread.sleep(500);
			   Select select5 = new Select(selctservce.findElement(By.id("SServ_PPGR_0")));
			   select5.selectByVisibleText("Yes");
			   selctservce.sendKeys(Keys.TAB);
			   selctservce.sendKeys(Keys.TAB);
			   selctservce.sendKeys(Keys.TAB);
			   Thread.sleep(500);
			   clckonfnalbkng.click();
			   Thread.sleep(4000);
			 
		 }
		 catch(Exception e)
		 {
				 File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
								
				   try
				   {
					    FileUtils.copyFile(scr, new File("D:\\Ajit\\Script_SS\\Cruisebooking\\bookingpge.jpg"));
					
				   } catch(Exception e1)
				     {
					     e1.printStackTrace();
				     }
			}
			
			
		}
	
}
