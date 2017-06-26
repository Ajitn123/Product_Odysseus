package Implementation;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class FaregeekPurchasepgeobjct
{

	   
	    //For Checkout page (For passenger 1)
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_Title")
	    private WebElement selctitle;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_GenderSEL")
	    private WebElement selctgndr;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_FirstName")
	    private WebElement Firstnme;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_MiddleName")
	    private WebElement Middlenme;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_LastName")
	    private WebElement lastnme;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_DateUC_Month")
	    private WebElement selctmonth;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_DateUC_Day")
	    private WebElement selctday;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_DateUC_Year")
	    private WebElement selctyear;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_Phone1_Number")
	    private WebElement phone;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_EMail")
	    private WebElement email;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_1_ConfirmEMail")
	    private WebElement cnfmemail;
	
	    //For Adult 2
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_2_Title")
	    private WebElement selcttle;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_2_GenderSEL")
	    private WebElement selctgendr;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_2_FirstName")
	    private WebElement Frstnme;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_2_MiddleName")
	    private WebElement Mddlenme;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_2_LastName")
	    private WebElement lstnm;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_2_DateUC_Month")
	    private WebElement slctmonth;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_2_DateUC_Day")
	    private WebElement slctday;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_2_DateUC_Year")
	    private WebElement slctyear;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_2_Phone1_Number")
	    private WebElement phne;
	    
	    // For Child 3
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_3_Title")
	    private WebElement slcttle;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_3_GenderSEL")
	    private WebElement slctgendr;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_3_FirstName")
	    private WebElement Frstname;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_3_MiddleName")
	    private WebElement Mddlename;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_3_LastName")
	    private WebElement lstname;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_3_DateUC_Month")
	    private WebElement slctmnth;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_3_DateUC_Day")
	    private WebElement slctdy;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_3_DateUC_Year")
	    private WebElement slctyar;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0_TravelerAccount_3_Phone1_Number")
	    private WebElement pne;
	    
	    @FindBy(xpath="//*[@id='accordion3']/div[1]/div/h3/a")
	    private WebElement zoomout; 
	    
	    @FindBy(xpath="//*[@id='accordion4']/div/div[1]/h3/a")
	    private WebElement zmout;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0__ctl12_AirlinesRepeater__ctl1_FFProgram")
	    private WebElement slctarlne; 
	    
	    @FindBy(id="//*[@id=")  
	    private WebElement prgmno;
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0__ctl14_AirlinesRepeater__ctl1_FFProgram")
	    private WebElement SLCTlnefrthree;  
	    
	    @FindBy(id="_ctl0_MainContentsPH__ctl0__ctl14_AirlinesRepeater__ctl1_FFProgramNumber")
	    private WebElement prgmnothree;
	
	    
	    
	    
	    
	    public void FaregeekToTitle(String frstnme, String mdlnme, String lstnme, String phn, String eml, String coneml, String frstnam, String mdalnme, String lstnam, String frstnm, String mdalnm, String ltnm, String pn)
	    {
	    	 try
	    	 {
	    		  
	    	    Select select = new Select(selctitle.findElement(By.id("_ctl0_MainContentsPH__ctl0_TravelerAccount_1_Title")));
	  			select.selectByVisibleText("Mr");
	  			Thread.sleep(500);
	  			Select select1 = new Select(selctgndr.findElement(By.id("_ctl0_MainContentsPH__ctl0_TravelerAccount_1_GenderSEL")));
	  			select1.selectByVisibleText("Male");
	  			Thread.sleep(500);
	  			Firstnme.clear();
	  			Thread.sleep(500);
	  			Firstnme.click();
	  			Thread.sleep(500);
	  			Firstnme.sendKeys(frstnme);
	  			Thread.sleep(500);
	  			Middlenme.clear();
	  			Thread.sleep(200);
	  			Middlenme.click();
	  			Thread.sleep(500);
	  			Middlenme.sendKeys(mdlnme);
	  			Thread.sleep(500);
	  			lastnme.clear();
	  			Thread.sleep(500);
	  			lastnme.click();
	  			Thread.sleep(500);
	  			lastnme.sendKeys(lstnme);
	  			Thread.sleep(500);
	  			selctmonth.click();
	  			Thread.sleep(500);
	  			selctmonth.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_1_DateUC_Month']/option[8]")).click();
	  			Thread.sleep(500);
	  			selctday.click();
	  			Thread.sleep(500);
	  			selctday.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_1_DateUC_Day']/option[24]")).click();
	  			Thread.sleep(500);
	  			selctyear.click();
	  			Thread.sleep(500);
	  			selctyear.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_1_DateUC_Year']/option[73]")).click();
	  			Thread.sleep(1000);
	  			phone.clear();
	  			Thread.sleep(300);
	  			phone.click();
	  			Thread.sleep(400);
	  			phone.sendKeys(phn);
	  			Thread.sleep(500);
	  			email.clear();
				Thread.sleep(200);
				email.click();
				Thread.sleep(300);
				email.sendKeys(eml);
				Thread.sleep(500);
				cnfmemail.clear();
				Thread.sleep(200);
				cnfmemail.click();
				Thread.sleep(300);
				cnfmemail.sendKeys(coneml);
				Thread.sleep(500);
                Select select2 = new Select(selcttle.findElement(By.id("_ctl0_MainContentsPH__ctl0_TravelerAccount_2_Title")));
	  			select2.selectByVisibleText("Mrs");
	  			Thread.sleep(500);
	  			Select select3 = new Select(selctgendr.findElement(By.id("_ctl0_MainContentsPH__ctl0_TravelerAccount_2_GenderSEL")));
	  			select3.selectByVisibleText("Female");
	  			Thread.sleep(500);
	  			Frstnme.clear();
	  			Thread.sleep(500);
	  			Frstnme.click();
	  			Thread.sleep(500);
	  			Frstnme.sendKeys(frstnam);
	  			Thread.sleep(500);
	  			Mddlenme.clear();
	  			Thread.sleep(200);
	  			Mddlenme.click();
	  			Thread.sleep(500);
	  			Mddlenme.sendKeys(mdalnme);
	  			Thread.sleep(500);
	  			lstnm.clear();
	  			Thread.sleep(500);
	  			lstnm.click();
	  			Thread.sleep(500);
	  			lstnm.sendKeys(lstnam);
	  			Thread.sleep(500);
	  			slctmonth.click();
	  			Thread.sleep(500);
	  			slctmonth.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_2_DateUC_Month']/option[4]")).click();
	  			Thread.sleep(500);
	  			slctday.click();
	  			Thread.sleep(500);
	  			slctday.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_2_DateUC_Day']/option[21]")).click();
	  			Thread.sleep(500);
	  			slctyear.click();
	  			Thread.sleep(500);
	  			slctyear.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_2_DateUC_Year']/option[75]")).click();
	  			Thread.sleep(1000);
	  	//		phone.clear();
	  	//		Thread.sleep(300);
	  	//		phone.click();
	  	//		Thread.sleep(800);
	  	//		phone.sendKeys(phon);
	  	//		Thread.sleep(500);
	  			Select select4 = new Select(slcttle.findElement(By.id("_ctl0_MainContentsPH__ctl0_TravelerAccount_3_Title")));
	  			select4.selectByVisibleText("Miss");
	  			Thread.sleep(500);
	  			Select select5 = new Select(slctgendr.findElement(By.id("_ctl0_MainContentsPH__ctl0_TravelerAccount_3_GenderSEL")));
	  			select5.selectByVisibleText("Female");
	  			Thread.sleep(500);
	  			Frstname.clear();
	  			Thread.sleep(500);
	  			Frstname.click();
	  			Thread.sleep(500);
	  			Frstname.sendKeys(frstnm);
	  			Thread.sleep(800);
	  			Mddlename.clear();
	  			Thread.sleep(200);
	  			Mddlename.click();
	  			Thread.sleep(500);
	  			Mddlename.sendKeys(mdalnm);
	  			Thread.sleep(500);
	  			lstname.clear();
	  			Thread.sleep(500);
	  			lstname.click();
	  			Thread.sleep(500);
	  			lstname.sendKeys(ltnm);
	  			Thread.sleep(500);
	  			slctmnth.click();
	  			Thread.sleep(500);
	  			slctmnth.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_3_DateUC_Month']/option[8]")).click();
	  			Thread.sleep(800);
	  			slctdy.click();
	  			Thread.sleep(800);
	  			slctdy.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_3_DateUC_Day']/option[16]")).click();
	  			Thread.sleep(500);
	  			slctyar.click();
	  			Thread.sleep(800);
	  			slctyar.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_TravelerAccount_3_DateUC_Year']/option[6]")).click();
	    		Thread.sleep(1000);
	    		pne.clear();
	    		Thread.sleep(500);
	    		pne.click();
	    		Thread.sleep(1000);
	    		pne.sendKeys(pn);
	    		Thread.sleep(2000);
	    		zoomout.click();
	    		Thread.sleep(2000);
	    		zmout.click();
	  			Thread.sleep(2000);
	  		//	zmout.sendKeys(Keys.TAB);
	  		//	zmout.sendKeys(Keys.TAB);
				
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
