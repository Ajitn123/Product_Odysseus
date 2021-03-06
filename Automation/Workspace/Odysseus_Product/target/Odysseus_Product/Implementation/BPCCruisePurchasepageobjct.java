package Implementation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class BPCCruisePurchasepageobjct
{

	 
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
		
		@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_Nationality")
		private WebElement natnality;
		
		@FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_PastPaxNumber")
		private WebElement pastpsngr;
		
		@FindBy(id="//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_1_AddressUC_CountrySel']")
		private WebElement cunty;
		
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
		
		@FindBy(xpath="//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_1_Phone1_PhoneTypeSEL']")
		private WebElement Phntype;
		
		@FindBy(xpath="//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_1_Phone2_Number']")
		private WebElement secondPhn;
		
		@FindBy(xpath="//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_1_Phone2_PhoneTypeSEL']")
		private WebElement secondPhntype;
		
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
		@FindBy(id="DiningPrefOption_0")
		private WebElement diningpref;
		
		//Table size preferences
		@FindBy(id="_ctl0_MainContentsPH__ctl0_DiningTblSizeSEL")
		private WebElement tblszepref;
		
		//For select bed preference
		@FindBy(xpath="//*[@id='BedTypePrefOption_0']")
		private WebElement bedpref; 
		
		//For select special requests
		@FindBy(id="cb6")
		private WebElement spclreq;
		
		@FindBy(id="SServ_PPGR_0")
		private WebElement selctservce;
		
		@FindBy(id="_ctl0_MainContentsPH__ctl0_XRefBookingsTXT")
		private WebElement Othrpref;
		
		@FindBy(id="_ctl0_MainContentsPH__ctl0_AgentRequestedTXT")
		private WebElement spcificagnt;
		
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
			   lastnme.sendKeys(Keys.TAB);
			   month.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_1_DateUC_Month']/option[8]")).click();
			   Thread.sleep(500);
			   month.sendKeys(Keys.TAB);
			   Day.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_1_DateUC_Day']/option[24]")).click();
			   Thread.sleep(500);
			   Day.sendKeys(Keys.TAB);
			   Year.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_1_DateUC_Year']/option[53]")).click();
			   Thread.sleep(500);	
			   Year.sendKeys(Keys.TAB);
			   Thread.sleep(700);
			   natnality.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_1_Nationality']/option[220]")).click();
			   Thread.sleep(900);   
			   natnality.sendKeys(Keys.TAB);
			   pastpsngr.sendKeys("No");
			   Thread.sleep(900);
			   pastpsngr.sendKeys(Keys.TAB);
			   pastpsngr.sendKeys(Keys.TAB);
			   Address.sendKeys(addrss);
			   Thread.sleep(900);
			   Address.sendKeys(Keys.TAB);
			   Address.sendKeys(Keys.TAB);
			   Thread.sleep(700);
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
			   Phntype.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_1_Phone1_PhoneTypeSEL']/option[2]")).click();
			   Phntype.sendKeys(Keys.TAB);
			   secondPhn.sendKeys("8596587482");
			   secondPhn.sendKeys(Keys.TAB);
			   secondPhntype.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_1_Phone2_PhoneTypeSEL']/option[1]")).click();
			   secondPhntype.sendKeys(Keys.TAB);
			   Thread.sleep(1000);
			   Select select2 = new Select(Titleofguesttwo.findElement(By.id("_ctl0_MainContentsPH__ctl0_TravelerAccount_2_Title")));
			   select2.selectByVisibleText("Miss");
			   Thread.sleep(800);
			   Select select3 = new Select(Gendertwo.findElement(By.id("_ctl0_MainContentsPH__ctl0_TravelerAccount_2_GenderSEL")));
			   select3.selectByVisibleText("Female");
			   Thread.sleep(800);
			   Firstnmeofguesttwo.clear();
			   Thread.sleep(500);
			   Firstnmeofguesttwo.click();
			   Thread.sleep(700);
			   Firstnmeofguesttwo.sendKeys(frstnmeoftwo);
			   Thread.sleep(900);
			   Firstnmeofguesttwo.sendKeys(Keys.TAB);
			   Middlenmeofguesttwo.sendKeys(mdlnmetwo);
			   Middlenmeofguesttwo.sendKeys(Keys.TAB);
			   Thread.sleep(800);
			   Lastnmeofguesttwo.sendKeys(lstnmetwo);
			   Lastnmeofguesttwo.sendKeys(Keys.TAB);
			   Thread.sleep(800);
			   Monthofguesttwo.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_2_DateUC_Month']/option[10]")).click();
			   Monthofguesttwo.sendKeys(Keys.TAB);
			   Thread.sleep(500);
			   Dayofguesttwo.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_2_DateUC_Day']/option[19]")).click();
			   Dayofguesttwo.sendKeys(Keys.TAB);
			   Thread.sleep(500);
			   Yearofguesttwo.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_2_DateUC_Year']/option[6]")).click();
			   Yearofguesttwo.sendKeys(Keys.TAB);
			   Thread.sleep(200);
			   selctcntry.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_2_Nationality']/option[220]")).click();
			   selctcntry.sendKeys(Keys.TAB); 	
			   Thread.sleep(500);
			   selctcntry.sendKeys(Keys.TAB);
			   selctcntry.sendKeys(Keys.TAB);
			   Thread.sleep(1000);
			   
			   if(diningpref.findElement(By.id("DiningPrefOption_0")).isDisplayed())
			   {
				   diningpref.click();
				   Thread.sleep(900);
			   }
			  
			   diningpref.sendKeys(Keys.TAB);
			   Thread.sleep(1000);
			   
		  
		/*     //For Table preferences	   
		       if(tblszepref.findElement(By.id("BedTypePrefOption_1")).isDisplayed())
			   {
				   tblszepref.findElement(By.id("BedTypePrefOption_1")).click();
				   Thread.sleep(800);
				   tblszepref.sendKeys(Keys.TAB);
			   } 
			       Thread.sleep(2000);
		*/	   
			  
	 	   
			   if(bedpref.findElement(By.xpath("//*[@id='BedTypePrefOption_0']")).isDisplayed())
			   {
				   WebElement element = bedpref.findElement(By.xpath("//*[@id='BedTypePrefOption_0']"));
             	   element.sendKeys(Keys.ENTER);
				   Thread.sleep(500);
				   
			   }
	  		   
			       bedpref.sendKeys(Keys.TAB);
			       Thread.sleep(500);
			   
		/*     //For Select request preferences	 
		       if(spclreq.findElement(By.id("cb1")).isDisplayed())
		 	   {
				   spclreq.click();    //For pre_paid gratuities
				   Thread.sleep(500);
				   spclreq.findElement(By.id("SServ_E001_0")).click();
				   Thread.sleep(500);
				   spclreq.findElement(By.xpath("//*[@id='SServ_E001_0']/option[3]")).click();
				   Thread.sleep(1000); 
				   spclreq.findElement(By.id("SServ_E001_0_Remark")).click();
				   spclreq.sendKeys("20");
				   Thread.sleep(500);
				   spclreq.sendKeys(Keys.TAB);
				   spclreq.sendKeys(Keys.TAB);
				   spclreq.sendKeys(Keys.TAB);
				   spclreq.sendKeys(Keys.TAB);
				   Thread.sleep(500);
				   
			   } */
			   
			   if(Othrpref.findElement(By.id("_ctl0_MainContentsPH__ctl0_XRefBookingsTXT")).isDisplayed())
			   {
				   Othrpref.click();
				   Othrpref.sendKeys("No");
				   Thread.sleep(500);
				   Othrpref.sendKeys(Keys.TAB);
				   Thread.sleep(500);
			   }
			   
			   if(spcificagnt.findElement(By.id("_ctl0_MainContentsPH__ctl0_AgentRequestedTXT")).isDisplayed())
			   {
				   spcificagnt.click();
				   spcificagnt.sendKeys("No");
				   Thread.sleep(500);
				   spcificagnt.sendKeys(Keys.TAB);
				   Thread.sleep(500);
			   }
			   
			   
			   clckonfnalbkng.click();
			   Thread.sleep(4000);
			 
		 }
		 catch(Exception e)
		 {
				 
			   e.printStackTrace();
				     
		 }
			
			
	}
	
}
