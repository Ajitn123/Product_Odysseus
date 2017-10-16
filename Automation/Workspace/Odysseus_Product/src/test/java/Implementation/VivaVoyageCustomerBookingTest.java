package Implementation;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Utility.VivaVoyageCustomerBookingAccessUtils;



public class VivaVoyageCustomerBookingTest 
{

	    VivaVoyageCustomerbkngaccesspgeobjct cstmrbkng;
	    public static WebDriver driver;
        Reporter report = new Reporter();
  
     public static boolean implicitwait(long time)
     {
        try 
        {
              driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
              System.out.println("Waited for"+time+"sec implicitly.");

        } catch (Exception e) 
          {
	            System.out.println(e.getMessage());
          }
               return true;
     } 

     @Parameters({ "browser" })
     @BeforeTest
     public void openBroswer(String browser) throws InterruptedException, IOException  
     {
        try 
        {
                if (browser.equalsIgnoreCase("Firefox"))
                {
                   //  driver = new FirefoxDriver();
	   
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
	                   //driver = new InternetExplorerDriver();
	                   
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
         driver.get("https://www.vivavoyage.co.uk/");
         Thread.sleep(2000);
         
         cstmrbkng = PageFactory.initElements(driver, VivaVoyageCustomerbkngaccesspgeobjct.class);
       
     }

     @Test(dataProvider="Authentications")
     public void Vivavoyage_data(String PNR_NO, String LastName) throws Exception
     {
    	 try
         {
    		//For web site and booking details
             Reporter.log("Website Name :- Viva Voyage UK : Customer Booking Access");
             Thread.sleep(500);
             
             driver.findElement(By.cssSelector("#menu-item-164 > a")).click();
             Thread.sleep(5000);
             
             System.out.println("PNR_NO: " + PNR_NO);
             System.out.println("LastName: " + LastName);
             
             cstmrbkng.VivaVoyageCustomerbookingAccessToTitle(PNR_NO, LastName);
             Thread.sleep(3000);
             
             driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_SearchBookingsBTN")).click();
             Thread.sleep(4000);
            
         }
         catch(Exception e)
         {
    	      Assert.assertFalse(false, "FAIL");
    	      Reporter.log("Booking not available...");
    	 //     AssertJUnit.assertTrue("Time out or Invalid search criteria on resultpage...", crsbkngpge.isDisplayed());
    	 //    throw(e);
         }
    	 
    	 try
    	 {
    		 String el = driver.findElement(By.cssSelector("#MainForm > div.booking-details > div > div.search-booking-list-details > div > div.BookingRow1 > div:nth-child(1)")).getText();
    		 Reporter.log("PNR No is:- " +el);
    		 Thread.sleep(300);
    		 
    		 if(el.equals("2242050 Confirmed"))
    		 {
    			 Reporter.log("PNR No matched..");
    		 }
    		 else
    		 {
    			 Reporter.log("PNR No is not matched..");
    		 }
    		 
    	 }
    	 catch(Exception e)
    	 {
    		 e.getMessage();
    	 }
    	 
    	 try
    	 {
    		 String ell = driver.findElement(By.cssSelector("#MainForm > div.booking-details > div > div.search-booking-list-details > div > div.BookingRow1 > div:nth-child(3)")).getText();
    		 Reporter.log("Lastname is:- " +ell);
    		 Thread.sleep(300);
    		 
    		 if(ell.equals("Westhenry, Paul Glen, Sheila"))
    		 {
    			 Reporter.log("Lastname is matched..");
    		 }
    		 
    		 else
    		 {
    			 Reporter.log("Lastname is not matched..");
    		 }
    		 
    	 }
    	 catch(Exception e)
    	 {
    		 e.getMessage();
    	 }
    	     
                                  
      }
     
     @DataProvider
     public String[][] Authentications() throws Exception
     {
     	 
 	     String[][] testObjArray = VivaVoyageCustomerBookingAccessUtils.getTableArray("D:\\Ajit\\Automation\\Workspace\\Odysseus_Product\\src\\main\\java\\testData\\VivaVoyageCustomerBookingAccessData.xlsx","Sheet1");
 	     return testObjArray;
 	     
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
