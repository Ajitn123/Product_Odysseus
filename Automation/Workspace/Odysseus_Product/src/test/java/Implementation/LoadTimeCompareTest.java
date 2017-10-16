package Implementation;

import java.io.IOException;
import java.util.logging.Level;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;

public class LoadTimeCompareTest 
{

	static final ExtentReports extent = ExtentReports.get(OdysolAirHeldConfirmAndTicketedTest.class); 
	public static WebDriver driver;
    Reporter report = new Reporter();
	
	 @Parameters({ "browser" })
	 @BeforeTest
	 public void openBroswer(String browser) throws InterruptedException, IOException  
	 {
	     try
	     {
		                 if (browser.equalsIgnoreCase("Firefox"))
		                 {
		                 //    driver = new FirefoxDriver();
		   
		                 } 
		                 else if (browser.equalsIgnoreCase("chrome")) 
		                 {
			                    System.setProperty("webdriver.chrome.driver", "D:\\Ajit\\Automation\\Workspace\\Odysseus_Product\\Driver\\chromedriver_win32\\chromedriver.exe");
			                    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			                    LoggingPreferences loggingprefs = new LoggingPreferences();
			                    loggingprefs.enable(LogType.BROWSER, Level.ALL);
			                    capabilities.setCapability(CapabilityType.LOGGING_PREFS, loggingprefs);
			                    driver = new ChromeDriver(capabilities);
			                   
		                 }  
		                 else if (browser.equalsIgnoreCase("IE")) 
		                 {
			                   System.setProperty("webdriver.ie.driver", "D:\\Ajit\\Automation\\Workspace\\Odysseus_Product\\Driver\\IEDriverServer_Win32_2.53.0\\IEDriverServer.exe");
			                // driver = new InternetExplorerDriver();
			                   
		                 } 

	     } catch (WebDriverException e) 
	       {
		                   System.out.println(e.getMessage());
	       }
	     
	 }
	 
	 @BeforeClass
	 public void baseClass() throws InterruptedException, IOException  
	 {
	       	              
		 driver.manage().window().maximize();
	     driver.get("D:\\Ajit\\Script_SS\\Daily Sanity\\July_2017\\07 July 2017\\HTML Report\\emailable-report.html");
	     Thread.sleep(2000);
	            
	 }

	 @Test()
	 public void CruiseBooking_data() throws Exception
	 {
		
		 
	    try
	    {
	 	    extent.init("D:\\Ajit\\Automation\\Workspace\\Odysseus_Product\\test-output\\emailable-report.html", true);
	 	    extent.startTest("OdysolAirHeldConfirmAndTicketedTest");
	 	    
	 	    //For web site and booking details
	         Reporter.log("Script Name :- Load Time Comparison");
	         Thread.sleep(200);
	         
	         String CurrentDayLoadTime = driver.findElement(By.cssSelector("body > table:nth-child(1) > tbody > tr:nth-child(3) > td:nth-child(5)")).getText();
	         Thread.sleep(1000);
	         Reporter.log("Total script execution Load Time of current day:- " + CurrentDayLoadTime);
	         
	         
	         String Totalloadtimeofpreviusday = "32227577";
	         Reporter.log("Total script execution Load Time of previous day:- " + Totalloadtimeofpreviusday);
	        
	        if(Totalloadtimeofpreviusday.equals(CurrentDayLoadTime))
	        {
	        	Reporter.log("previous and current day's Load time are same..");
 			   
	        }
	/*        
	        else
	        {
	        	Reporter.log("previous and current day's Load time are Not same..");
	        	String a = Totalloadtimeofpreviusday ;
	        	String b = CurrentDayLoadTime;
	        
	        	String c = a + b;
	        	Reporter.log("Difference is:- " + c);
	        	
	        }
	 */       
	        Assert.assertEquals(CurrentDayLoadTime, Totalloadtimeofpreviusday, "verify price");
	         
	         
	    }     
	    catch(Exception e)
	    {
	         	  e.getMessage();
	    }     
	         
	    try
	    {
	    	
	    	
	    }
	    catch(Exception e)
	    {
	    	e.getMessage();
	    }
	   
	 }
	

	@AfterClass
	 public void closeBrowser() throws InterruptedException
	 {
		 /*
		   
		        if(driver!=null) 
		        {
			         System.out.println("Closing the browser");
			         driver.quit();
		        }   
	    */
	 }
		
        
	
	
}
