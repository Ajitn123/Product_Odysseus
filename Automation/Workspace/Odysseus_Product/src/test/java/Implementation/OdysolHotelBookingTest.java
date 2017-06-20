package Implementation;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Date;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import javax.imageio.ImageIO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import Utility.OdysolHotelUtils;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.screentaker.ViewportPastingStrategy;


public class OdysolHotelBookingTest 
{

	  Login lgnpge;
	  OdysolHotelBookingpgeobjct airbk;
	  OdysolHotelBookingPurchasepgeobjct purchse;
      public static WebDriver driver;
      Reporter report = new Reporter();
      static final ExtentReports extent = ExtentReports.get(OdysolAirHeldConfirmAndTicketedTest.class); 
   
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
                   //   driver = new FirefoxDriver();
   
                 } 
                 else if (browser.equalsIgnoreCase("chrome")) 
                 {
	                    System.setProperty("webdriver.chrome.driver", "D:\\Ajit\\Driver\\chromedriver_win32\\chromedriver.exe");
	                    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	                    LoggingPreferences loggingprefs = new LoggingPreferences();
	                    loggingprefs.enable(LogType.BROWSER, Level.ALL);
	                    capabilities.setCapability(CapabilityType.LOGGING_PREFS, loggingprefs);
	                    driver = new ChromeDriver(capabilities);
	                   
                 }  
                 else if (browser.equalsIgnoreCase("IE")) 
                 {
	                   System.setProperty("webdriver.ie.driver", "D:\\Ajit\\Driver\\IEDriverServer_Win32_2.53.0\\IEDriverServer.exe");
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
    driver.get("https://ui.odysol.com/admin/login.aspx");
    Thread.sleep(2000);
    
    //Save console
    String testResultFile="D:\\Ajit\\Script_SS\\ConsoleError\\OdysolHotelBookingError.txt";
    File file = new File(testResultFile);  
    FileOutputStream fis = new FileOutputStream(file);  
    PrintStream out = new PrintStream(fis);  
    System.setOut(out); 
                  
   
    //driver.navigate().to("https://localhost/odyssey/website/air/results.aspx?");
    Thread.sleep(4000);
    lgnpge = PageFactory.initElements(driver, Login.class);
    airbk = PageFactory.initElements(driver, OdysolHotelBookingpgeobjct.class);
    purchse = PageFactory.initElements(driver, OdysolHotelBookingPurchasepgeobjct.class);
     
}

public void ExtractJSLogs()
{
       LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
   
   for (LogEntry entry : logEntries) 
   {
       System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
   }
}


  @Test(dataProvider="Authentication")
  public void HotelBooking_data(String sUsername, String sPassword, String FirstName, String MidleName, String LastName, String Email, String Phone, String FirstNameTwo, String MidleNameTwo, String LastNameTwo, String EmailTwo, String PhoneTwo) throws Exception
  {
  
    try
    {
	    extent.init("D:\\Ajit\\Automation\\Workspace\\Odysseus_Product\\test-output\\emailable-report.html", true);
	    extent.startTest("OdysolAirHeldConfirmAndTicketedTest");
	    
	    //For web site and booking details
        Reporter.log("Website Name :- Odysol Hotel");
        Thread.sleep(200);
     	    
	    System.out.println("sUsername: " + sUsername);
        System.out.println("sPassword: " + sPassword);
                
        lgnpge.LoginToTittle(sUsername, sPassword);
        long start = System.currentTimeMillis();
        Thread.sleep(2000);
     
        System.out.println("\n");
        System.out.println("Loginpage Logs..");
        System.out.println("\n");
        ExtractJSLogs();
        Thread.sleep(3000);
        long finish = System.currentTimeMillis();
        long totalTime = finish - start; 
        Reporter.log("Total Time for login page to search page load(Milisec) - "+totalTime); 
        Thread.sleep(1000);

     }     
     catch(Exception e)
     {
     	     System.out.println("\n");
 	         System.out.println("Login with invalid credentials on Loginpage Logs..");
 	         System.out.println("\n");
 	         ExtractJSLogs();
 	      
	         
	          Assert.assertFalse(false, "FAIL");
	          Reporter.log("Username and Password are invalid..");
     	      AssertJUnit.assertTrue("Username Or Password are invalid...", lgnpge.isDisplayed());
     	      throw(e);
       	  
      }     
     
  try
  {
	     
	  
        airbk.HotelBookingToTitle();
        long start = System.currentTimeMillis();
        Thread.sleep(6000);     
          
        System.out.println("\n");
        System.out.println("Searchpage Logs..");
        System.out.println("\n");
        ExtractJSLogs();
        Thread.sleep(400);
        long finish = System.currentTimeMillis();
        long totalTime = finish - start; 
        Reporter.log("Total Time for search page to result page load(Milisec) - "+totalTime); 
        Thread.sleep(1000);

      
 }    
 catch(Exception e)
 {
	   System.out.println("\n");
       System.out.println("Invalid search details or displaying error message on Searchpage Logs..");
       System.out.println("\n");
       ExtractJSLogs();
      
      
       Assert.assertFalse(false, "FAIL");
       Reporter.log("Invalid search details or displaying error message..");
	   AssertJUnit.assertTrue("Invalid search details or displaying error message...", lgnpge.isDisplayed());
	   throw(e);
	   
}

      Thread.sleep(1000);

      // For select dynamic Hotel from result page
     for(int i = driver.getWindowHandles().size() -1 ; i > 0 ; i--)
     {

          String winHandle = driver.getWindowHandles().toArray()[i].toString();

          driver.switchTo().window(winHandle);
	 
	 
          driver.navigate().refresh();

          driver.get("https://ui.odysol.com/web/hotel/results.aspx?showtrace=true");

          driver.manage().window().maximize();
       
          System.out.println("\n");
          System.out.println("Resultpage Logs..");
          System.out.println("\n");
          ExtractJSLogs();
       
          
         Thread.sleep(8000);
  
     // For select Hotel 
     if(driver.findElement(By.cssSelector("[id*='hotel_summary_'] > div > div.Hrightblock > div.booknow-btn [id*='HotelBtnlbl']")).isDisplayed())
     {	  
        driver.findElement(By.cssSelector("[id*='hotel_summary_'] > div > div.Hrightblock > div.booknow-btn [id*='HotelBtnlbl']")).click();
        long start = System.currentTimeMillis();
        Thread.sleep(4000);
        long finish = System.currentTimeMillis();
        long totalTime = finish - start; 
        Reporter.log("Total Time for result page to details page load(Milisec) - "+totalTime); 
        Thread.sleep(1000);
     }   
     else
     {
    	        
    	Assert.assertFalse(false, "FAIL");
        Reporter.log("Cruise not selected or available...");
        AssertJUnit.assertTrue("Cruise not selected or available...", lgnpge.isDisplayed());
        return;
     }  
 
       System.out.println("\n");
       System.out.println("Hotel detailspage Logs..");
       System.out.println("\n");
       ExtractJSLogs();              
       Thread.sleep(1000);
      
        
	    
	  //For the Hotel details page
        try
        {
                	
                   driver.findElement(By.cssSelector("#room_types > div:nth-child(2) > div.hcatprice > div [id*='_ctl0_MainContentsPH__ctl0__ctl0_Categories__ctl1_HotelFares__ctl0_SelectButton']")).click();
                   long start = System.currentTimeMillis();
                   Thread.sleep(4000);
                                      
                   System.out.println("\n");
         	       System.out.println("Checkout page Logs..");
         	       System.out.println("\n");
         	       ExtractJSLogs();
                   Thread.sleep(1000);
                   long finish = System.currentTimeMillis();
                   long totalTime = finish - start; 
                   Reporter.log("Total Time for details page to checkout page load(Milisec) - "+totalTime); 
                   Thread.sleep(1000);
        }
        catch(Exception e)
        {
                  	System.out.println("\n");
         	        System.out.println("Hotels not available on hotel detailspage Logs..");
         	        System.out.println("\n");
         	        ExtractJSLogs();
          	 
          	        Assert.assertFalse(false, "FAIL");
          	        Reporter.log("Hotels not available on detailspage...");
          	        AssertJUnit.assertTrue("Hotels not available on detailspage...", lgnpge.isDisplayed());
          	        throw(e);
         }
        
                 //For check API, Office id And Environment on checkout page
     	         String expr = driver.findElement(By.id("TracerBlock")).getText();
                 String api = expr.split("OdysseyGateway")[7].split(":")[1].trim();
                 //List<String> items = Arrays.asList(expr.split("$($('#TracerBlock')[0].innerHTML.split('OdysseyGateway')[2])[0].nodeValue.toString().split(':')[1]"));
                 Reporter.log("API :- " +api);
                 Thread.sleep(500);
                 String envrnmnt = expr.split("OdysseyGateway")[7].split(":")[2].trim();
                 Reporter.log("Environment :- " +envrnmnt);
                 Thread.sleep(500);
                 String officeid = expr.split("OdysseyGateway")[7].split(":")[3].trim();
                 Reporter.log("Office Id :- " +officeid);
                 Thread.sleep(3000);
                 
         //For Purchase page                 
          try
          {
                String bookngadd = driver.findElement(By.cssSelector("#MainForm > div > div.purchase-right > div > div:nth-child(3) > table > tbody > tr > td.booking-location")).getText();
                Thread.sleep(500);
                Reporter.log("Booking Address:- " +bookngadd);
                Thread.sleep(900);
                String Checkin = driver.findElement(By.cssSelector("#MainForm > div > div.purchase-right > div > div:nth-child(8) > div:nth-child(1) > ul > li:nth-child(1)")).getText();
                Thread.sleep(500);
                Reporter.log(" " +Checkin);
                Thread.sleep(900);
                String Checkout = driver.findElement(By.cssSelector("#MainForm > div > div.purchase-right > div > div:nth-child(8) > div:nth-child(1) > ul > li:nth-child(2)")).getText();
                Thread.sleep(500);
                Reporter.log(" " +Checkout);
                Thread.sleep(900);
                String roomonedetails = driver.findElement(By.cssSelector("#MainForm > div > div.purchase-right > div > div:nth-child(8) > div:nth-child(2) > strong")).getText();
                Thread.sleep(500);
                Reporter.log(" " +roomonedetails);
                Thread.sleep(900);
                String mealplan = driver.findElement(By.cssSelector("#MainForm > div > div.purchase-right > div > div:nth-child(8) > div:nth-child(2) > ul > li:nth-child(1)")).getText();
                Thread.sleep(500);
                Reporter.log(" " +mealplan);
                Thread.sleep(900);
                String Basefare = driver.findElement(By.cssSelector("#MainForm > div > div.purchase-right > div > div:nth-child(8) > div:nth-child(2) > ul > li:nth-child(2)")).getText();
                Thread.sleep(500);
                Reporter.log(" " +Basefare);
                Thread.sleep(900);
                String roomtwodetails = driver.findElement(By.cssSelector("#MainForm > div > div.purchase-right > div > div:nth-child(8) > div:nth-child(3) > strong")).getText();
                Thread.sleep(500);
                Reporter.log(" " +roomtwodetails);
                Thread.sleep(900);
                String mealplanroomtwo = driver.findElement(By.cssSelector("#MainForm > div > div.purchase-right > div > div:nth-child(8) > div:nth-child(3) > ul > li:nth-child(1)")).getText();
                Thread.sleep(500);
                Reporter.log(" " +mealplanroomtwo);
                Thread.sleep(900);
                String Basefareroomtwo = driver.findElement(By.cssSelector("#MainForm > div > div.purchase-right > div > div:nth-child(8) > div:nth-child(3) > ul > li:nth-child(2)")).getText();
                Thread.sleep(500);
                Reporter.log(" " +Basefareroomtwo);
                Thread.sleep(900);
                String pricedetailsonpurchsepge = driver.findElement(By.cssSelector("#MainForm > div > div.purchase-right > div > div.p-booking-price")).getText();
                Thread.sleep(500);
                Reporter.log(" " +pricedetailsonpurchsepge);
                Thread.sleep(1000);
                
          }
          catch(Exception e)
          {
        	    Assert.assertFalse(false, "FAIL");
        	    Reporter.log("Something went on hotel details...");
        		AssertJUnit.assertTrue("Something went on hotel details....", lgnpge.isDisplayed());
        		throw(e);
          }
          
           try
           {
        	    
        	   System.out.println("FirstName: " + FirstName);
               System.out.println("MidleName: " + MidleName);
               System.out.println("LastName: " + LastName);
               System.out.println("Email: " + Email);
               System.out.println("Phone: " + Phone);
               System.out.println("FirstNameTwo: " + FirstNameTwo);
               System.out.println("MidleNameTwo: " + MidleNameTwo);
               System.out.println("LastNameTwo: " + LastNameTwo);
               System.out.println("EmailTwo: " + EmailTwo);
               System.out.println("PhoneTwo: " + PhoneTwo);
                 
               
        	   purchse.HotelToTitle(FirstName, MidleName, LastName, Email, Phone, FirstNameTwo, MidleNameTwo, LastNameTwo, EmailTwo, PhoneTwo);
           }
           catch(Exception e)
           {
                                    System.out.println("Invalid guest information on purchase page, Please enter valid details for the required fields...");
                                    System.out.println("\n");
                                    System.out.println("Invalid guest information on purchasepage Logs..");
                                    System.out.println("\n");
                                    ExtractJSLogs();
                                             
                                        
                                    Assert.assertFalse(false, "FAIL");
                              	    Reporter.log("Invalid guest information on purchase page, Please enter valid details for the required fields...");
                              		AssertJUnit.assertTrue("Invalid guest information on purchase page, Please enter valid details for the required fields....", lgnpge.isDisplayed());
                              		throw(e);
             }
                                    long start = System.currentTimeMillis();   
                                    Thread.sleep(7000);
                                    long finish = System.currentTimeMillis();
             	                    long totalTime = finish - start; 
             	                    Reporter.log("Total Time for checkout page to confirmation page load(Milisec) - "+totalTime); 
             	                    Thread.sleep(1000);
                                    System.out.println("\n");
                                    System.out.println("Confirmationpage Logs..");
                                    System.out.println("\n");
                                    ExtractJSLogs();              
                                               
                                    Thread.sleep(2000);
                                    
             try
             {
                                    
                                    //For Verify price on confirmation page
                                    String pricedetailsoncon = driver.findElement(By.cssSelector("#_ctl0__ctl10_HotelCTN > div > div.p-booking-price")).getText();
                                    Reporter.log(" " +pricedetailsoncon);
                                                                        
   							        Thread.sleep(1500);
                          							 
              }     							 
              catch (Exception e) 
              {
            	  
                  Assert.assertFalse(false, "FAIL");
            	  Reporter.log("Something went wrong...");
            	  AssertJUnit.assertTrue("Something went wrong...", lgnpge.isDisplayed());
            	  throw(e);
			  }                        
     }
  }


@DataProvider
public String[][] Authentication() throws Exception
{

     String[][] testObjArray = OdysolHotelUtils.getTableArray("D:\\Ajit\\Automation\\Workspace\\Odysseus_Product\\src\\main\\java\\testData\\OdysolHotelData.xlsx","Sheet1");

     return (testObjArray);

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
