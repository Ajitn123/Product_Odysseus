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
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
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
import Utility.CDNCruiseUtils;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.screentaker.ViewportPastingStrategy;


public class CDNCruiseBookingTest 
{
	  
	  CDNLoginpgeobjct crsbkng;
	  CDNSearchpgeobjct crsbkngpge;
	  CDNCDORParchasepgeobjct cdrpurchse;
	  CDNCDORPaymentpgeobjct hldncnfrm;
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
   driver.get("https://ui.odysol.com/admin/login.aspx");
   Thread.sleep(2000);

   //Save console
   String testResultFile="D:\\Ajit\\Script_SS\\ConsoleError\\CDNCDORError.txt";
   File file = new File(testResultFile);  
   FileOutputStream fis = new FileOutputStream(file);  
   PrintStream out = new PrintStream(fis);  
   System.setOut(out); 
        
       Thread.sleep(1000);

       final Screenshot screenshot1 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
       final BufferedImage image1 = screenshot1.getImage();
       ImageIO.write(image1, "PNG", new File("D:\\Ajit\\Script_SS\\CDNCDOR\\1_Searchpage.png"));
       Thread.sleep(1000);
       System.out.println("\n");
	   System.out.println("Searchpage Logs..");
	   System.out.println("\n");
	   ExtractJSLogs();
  
       Thread.sleep(4000);
       crsbkng = PageFactory.initElements(driver, CDNLoginpgeobjct.class);
       crsbkngpge = PageFactory.initElements(driver, CDNSearchpgeobjct.class);
       hldncnfrm = PageFactory.initElements(driver, CDNCDORPaymentpgeobjct.class);
       cdrpurchse = PageFactory.initElements(driver, CDNCDORParchasepgeobjct.class);

}

public void ExtractJSLogs()
{
  LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);

    for (LogEntry entry : logEntries) 
    {
         System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
    }
}

@Test(dataProvider="Authentications")
public void ADC_data(String sUsername, String sPassword, String Firstname_GuestOne, String Middlename_GuestOne, String Lastname_GuestOne, String Email, String Phone, String Address, String City, String Zipcode, String Firstname_GuestTwo, String Middlename_GuestTwo, String Lastname_GuestTwo, String CardNo, String CardCvvNo, String CardHolderName, String Addres, String CityName, String Zipcodes, String Phone_Number, String BankName) throws Exception
{
	
   try
   {
	   
	    System.out.println("sUsername: " + sUsername);
        System.out.println("sPassword: " + sPassword);
	    crsbkng.cdnLoginToTittle(sUsername, sPassword);
	    
	    Thread.sleep(2000);
	    
   	      //For web site and booking details
            Reporter.log("Website Name :- CDOR 2017");
            Thread.sleep(200);
 		 
		    Reporter.log("Cruise line :- Royal Caribbean");
		    Thread.sleep(1500);
		     
		    crsbkngpge.CDNCDORToTittle();
         
	       long start = System.currentTimeMillis();
	     
	       Thread.sleep(5000);
	       long finish = System.currentTimeMillis();
           long totalTime = finish - start; 
           Reporter.log("Total Time for serch page to result page load(Milisec) - "+totalTime); 
           Thread.sleep(1000);
	       System.out.println("\n");
	       System.out.println("Resultpage Logs..");
	       System.out.println("\n");
	       ExtractJSLogs();
	        
           Thread.sleep(2000);
       
 }
 catch(Exception e)
 {
	         System.out.println("\n");
	         System.out.println("Time out or Invalid search criteria on resultpage Logs..");
	         System.out.println("\n");
	         ExtractJSLogs();
	 
	         final Screenshot screenshot33 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	         final BufferedImage image33 = screenshot33.getImage();
	         ImageIO.write(image33, "PNG", new File("D:\\Ajit\\Script_SS\\CDNCDORError\\1_TimeoutORinvalidsearchdetails.png"));
	          
	         Assert.assertFalse(false, "FAIL");
	         Reporter.log("Time out or Invalid search criteria on resultpage..");
	         AssertJUnit.assertTrue("Time out or Invalid search criteria on resultpage...", crsbkngpge.isDisplayed());
	         throw(e);
 }
	
	 //For Select cruise from result page
     try
     {
  	         
               driver.navigate().refresh();
               
               driver.get("https://cdn.odysol.com/web/cruises/results.aspx?showtrace=true");
                
               Thread.sleep(4000);  
               
               final Screenshot screenshot4 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
               final BufferedImage image4 = screenshot4.getImage();
               ImageIO.write(image4, "PNG", new File("D:\\Ajit\\Script_SS\\CDNCDOR\\3_Resultpage.png"));
           
               Thread.sleep(6000);
        
               driver.findElement(By.cssSelector("#ResultsContainer > div.page-content.mar-lg-top.search > section > div:nth-child(3) > section > table > tbody > tr > td.text-center.btn-td > a")).click();  // Select cruise i.e 0,1,2,3...10                      
               Thread.sleep(2000);                
                          
               long start = System.currentTimeMillis();  
               Thread.sleep(5000); 

               System.out.println("\n");
               System.out.println("Cruise detailspage Logs..");
               System.out.println("\n");
               ExtractJSLogs();              
               Thread.sleep(1000);
               long finish = System.currentTimeMillis();
               long totalTime = finish - start; 
               Reporter.log("Total Time for result page to details page load(Milisec) - "+totalTime); 
               Thread.sleep(1000);
            
                 System.out.println("\n");
                 System.out.println("Cruise detailspage Logs..");
                 System.out.println("\n");
                 ExtractJSLogs();              
                 Thread.sleep(1000);
              
        }
        catch(Exception e)
        {
      	        final Screenshot screenshot80 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	            final BufferedImage image80 = screenshot80.getImage();
	            ImageIO.write(image80, "PNG", new File("D:\\Ajit\\Script_SS\\CDNCDORError\\03_CruiseNotAvailablr.png"));
	          
  	        Assert.assertFalse(false, "FAIL");
  	        Reporter.log("Cruise not Available on detailspage...");
  	        AssertJUnit.assertTrue("Cruise not Available on detailspage...", crsbkngpge.isDisplayed());
  	        throw(e);
        }
             Thread.sleep(4000);
         
  
  //For the Cruise details page
  
   	         
   	          final Screenshot screenshot60 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
              final BufferedImage image60 = screenshot60.getImage();
              ImageIO.write(image60, "PNG", new File("D:\\Ajit\\Script_SS\\CDNCDOR\\4_Cruisedetailspage.png"));
              Thread.sleep(2000);
             
  try
  {
          	
             driver.findElement(By.id("_ctl0:MainContentsPH:_ctl0:_ctl0_GuestAge_1")).clear();
             Thread.sleep(100);
             driver.findElement(By.id("_ctl0:MainContentsPH:_ctl0:_ctl0_GuestAge_1")).click();
             Thread.sleep(100);
             driver.findElement(By.id("_ctl0:MainContentsPH:_ctl0:_ctl0_GuestAge_1")).sendKeys("24");
             Thread.sleep(300);
             driver.findElement(By.id("_ctl0:MainContentsPH:_ctl0:_ctl0_GuestAge_2")).clear();
             Thread.sleep(100);
             driver.findElement(By.id("_ctl0:MainContentsPH:_ctl0:_ctl0_GuestAge_2")).click();
             Thread.sleep(100);
             driver.findElement(By.id("_ctl0:MainContentsPH:_ctl0:_ctl0_GuestAge_2")).sendKeys("30");
             Thread.sleep(300);
             driver.findElement(By.id("_ctl0_MainContentsPH__ctl0__ctl0_ResidentState")).click();
             Thread.sleep(500);
             driver.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0__ctl0_ResidentState']/option[3]")).click();
             Thread.sleep(500);
             driver.findElement(By.id("_ctl0_MainContentsPH__ctl0__ctl0_CategoryBTN")).click();
             Thread.sleep(500);
             
             
  }
  catch(Exception e)
  {
            System.out.println("\n");
   	        System.out.println("Invalid guest information on cruise detailspage Logs..");
   	        System.out.println("\n");
   	        ExtractJSLogs();
    	 
	            final Screenshot screenshot80 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	            final BufferedImage image80 = screenshot80.getImage();
	            ImageIO.write(image80, "PNG", new File("D:\\Ajit\\Script_SS\\CDNCDORError\\3_InvalidGuestinformation.png"));
	          
    	        Assert.assertFalse(false, "FAIL");
    	        Reporter.log("Invalid guest information's on detailspage...");
    	        AssertJUnit.assertTrue("Invalid guest information's on detailspage...", crsbkngpge.isDisplayed());
    	        throw(e);
   }
             long start1 = System.currentTimeMillis();
             System.out.println("\n");
   	         System.out.println("Categorypage Logs..");
   	         System.out.println("\n");
   	         ExtractJSLogs();
             
             Thread.sleep(8000);
             
             long finish1 = System.currentTimeMillis();
             long totalTime1 = finish1 - start1; 
             Reporter.log("Total Time for details page to category page load(Milisec) - "+totalTime1); 
             Thread.sleep(1000);
  
  
// Verify error on category page
try
{
     if(driver.findElement(By.cssSelector("#_ctl0_PageHeadTD > div.content-area > div.top-error.error-box > div.top-error-bottom")).isDisplayed())
     {
  	     String err = driver.findElement(By.cssSelector("#_ctl0_PageHeadTD > div.content-area > div.top-error.error-box > div.top-error-bottom")).getText();
  	     Thread.sleep(1000);
  	     Reporter.log("Error message: " +err);
  	     Thread.sleep(500);
  	   
  	     final Screenshot screenshot82 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
         final BufferedImage image82 = screenshot82.getImage();
         ImageIO.write(image82, "PNG", new File("D:\\Ajit\\Script_SS\\CDNCDORError\\07_Error.png"));
         Thread.sleep(1000);
         AssertJUnit.assertTrue(" " +err, crsbkngpge.isDisplayed());
         return;
     }
}
catch(Exception e)
{
	     e.getMessage();
}

// Select Category(Balcony)
try
{       
		 
		final Screenshot screenshot9 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	    final BufferedImage image9 = screenshot9.getImage();
	    ImageIO.write(image9, "PNG", new File("D:\\Ajit\\Script_SS\\CDNCDOR\\5_Categorypage.png"));
	    Thread.sleep(6000);
	   
	    driver.findElement(By.cssSelector("#main-item > table > tbody > tr > td:nth-child(4) > div [class*='red-btn']")).click();
	    Thread.sleep(5000);
	
}
catch(Exception e)
{
	final Screenshot screenshot80 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
    final BufferedImage image80 = screenshot80.getImage();
    ImageIO.write(image80, "PNG", new File("D:\\Ajit\\Script_SS\\CDNCDORError\\4_Categorynotavailableoncategorypage.png"));
  
        Assert.assertFalse(false, "FAIL");
        Reporter.log("Category not availabe on category page...");
        AssertJUnit.assertTrue("Category not availabe on category page...", crsbkngpge.isDisplayed());
        throw(e);
}


           Thread.sleep(5000);
           
           final Screenshot screenshot67 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
           final BufferedImage image67 = screenshot67.getImage();
           ImageIO.write(image67, "PNG", new File("D:\\Ajit\\Script_SS\\CDNCDOR\\8_Cabinpage.png"));
           Thread.sleep(2000); 
 
      try
      {
           //For the Cruise details print on test report
           String destination = driver.findElement(By.cssSelector("#left-panel > div.card.step-three-page > div.text-center.card-content > div.card-container > div.row > div > div:nth-child(4)")).getText();
           Reporter.log(" " +destination);
           Thread.sleep(500);
           String shp = driver.findElement(By.cssSelector("#left-panel > div.card.step-three-page > div.text-center.card-content > div.card-container > div.row > div > div:nth-child(3)")).getText();
           Reporter.log(" " +shp);
           Thread.sleep(500);
           String Guest = driver.findElement(By.cssSelector("#left-panel > div.card.step-three-page > div.text-center.card-content > div.card-container > div.hidden-xs.additional-info > div:nth-child(3)")).getText();
           Reporter.log(" " +Guest);
           Thread.sleep(400);
           String depart = driver.findElement(By.cssSelector("#left-panel > div.card.step-three-page > div.text-center.card-content > div.card-container > div.row > div > div:nth-child(1)")).getText();
           Reporter.log(" " + depart);
           Thread.sleep(400);
           String departing = driver.findElement(By.cssSelector("#left-panel > div.card.step-three-page > div.text-center.card-content > div.card-container > div.row > div > div:nth-child(2)")).getText();
           Reporter.log(" " + departing);
           Thread.sleep(400);
           String ctgory = driver.findElement(By.cssSelector("#left-panel > div.card.step-three-page > div.text-center.card-content > div.card-container > div.hidden-xs.additional-info > div:nth-child(4)")).getText();
           Reporter.log(" " + ctgory);
           Thread.sleep(400);
         if(driver.findElement(By.cssSelector("#left-panel > div.card.step-three-page > div.text-center.card-content > div:nth-child(2) > div.hidden-xs > div > div:nth-child(2) > div.col-xs-6.col-sm-6.text-right > p")).isDisplayed())
         {
           String roomprice = driver.findElement(By.cssSelector("#left-panel > div.card.step-three-page > div.text-center.card-content > div:nth-child(2) > div.hidden-xs > div > div:nth-child(2) > div.col-xs-6.col-sm-6.text-right > p")).getText();
           Reporter.log("Room Price:- " + roomprice);
           Thread.sleep(400);
         }  
           
         if(driver.findElement(By.cssSelector("#left-panel > div.card.step-three-page > div.text-center.card-content > div:nth-child(2) > div.hidden-xs > div > div:nth-child(3) > div.col-xs-6.col-sm-6.text-right > p")).isDisplayed())
         {
           String taxes = driver.findElement(By.cssSelector("#left-panel > div.card.step-three-page > div.text-center.card-content > div:nth-child(2) > div.hidden-xs > div > div:nth-child(3) > div.col-xs-6.col-sm-6.text-right > p")).getText();
           Reporter.log("Estimated taxes and fees:- " + taxes);
           Thread.sleep(400);
         }  
      }
      catch(Exception e)
      {
    	    final Screenshot screenshot80 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
    	    final BufferedImage image80 = screenshot80.getImage();
    	    ImageIO.write(image80, "PNG", new File("D:\\Ajit\\Script_SS\\CDNCDORError\\4_Categorynotavailableoncategorypage.png"));
    	  
    	        Assert.assertFalse(false, "FAIL");
    	        Reporter.log("Cruise details are not found on category page...");
    	        AssertJUnit.assertTrue("Cruise details are not found on category page...", crsbkngpge.isDisplayed());
    	        throw(e);
      }
           //For check API, Office id And Test environment on cabin page
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
           Thread.sleep(4000);

   
   //For select cabin from the cabin selection page
   try
   {
	   if(driver.findElement(By.cssSelector("#MainForm > div.step-three-page > div > div > div.step-block > div > div.step-3 > div > div.room-selection > div:nth-child(2) > div.col-xs-4.btn-wrap [id*='CabinBook_']")).isDisplayed())
	   {
  	              driver.findElement(By.cssSelector("#MainForm > div.step-three-page > div > div > div.step-block > div > div.step-3 > div > div.room-selection > div:nth-child(2) > div.col-xs-4.btn-wrap [id*='CabinBook_']")).click();
                  Thread.sleep(1000);
	   }          
   }
   catch(Exception e)
   {
              	      System.out.println("Cabin not available..");
              	      System.out.println("\n");
              	      System.out.println("Cabin not available on select cabinpage Logs..");
              	      System.out.println("\n");
              	      ExtractJSLogs();
                 
                        final Screenshot screenshot13 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                        final BufferedImage image13 = screenshot13.getImage();
                        ImageIO.write(image13, "PNG", new File("D:\\Ajit\\Script_SS\\CDNCDORError\\4_Cabinnotavailable.png"));
                 
                      Assert.assertFalse(false, "FAIL");
  	                  Reporter.log("Cabin not available..");
  			          AssertJUnit.assertTrue("Cabin not available...", crsbkngpge.isDisplayed());
  			          throw(e);
    }
                    long start04 = System.currentTimeMillis();
                    Thread.sleep(4000);
                    
                    System.out.println("\n");
                    System.out.println("Purchase page Logs..");
                    System.out.println("\n");
                    ExtractJSLogs();              
                    Thread.sleep(1000);
                    
                    long finish112 = System.currentTimeMillis();
                    long totalTime112 = finish112 - start04; 
                    Reporter.log("Total Time for search customer page to purchase page load(Milisec) - "+totalTime112); 
                    Thread.sleep(1000);
                    
                    try
                    {
                    	if(driver.findElement(By.id("_ctl0_MainContent_ContinueBookingBTN")).isDisplayed())
                    	{
                    		driver.findElement(By.id("_ctl0_MainContent_ContinueBookingBTN")).click();
                    		Thread.sleep(3000);
                    	}
                    }
                    catch(Exception e)
                    {
                    	e.getMessage();
                    }
                    
                    
                    try
                    {
                                  if(driver.findElement(By.cssSelector("#cabinBypassPopup > div > a")).isDisplayed())
                                  {
                               	      driver.findElement(By.cssSelector("#cabinBypassPopup > div > a")).click();
                               	      Thread.sleep(1500);
                                  }
                    }
                    catch(Exception e)
                    {
                   	 e.getMessage();
                    }

                    final Screenshot screenshot103 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                    final BufferedImage image103 = screenshot103.getImage();
                    ImageIO.write(image103, "PNG", new File("D:\\Ajit\\Script_SS\\CDNCDOR\\10_Purchasepage.png"));
                    Thread.sleep(2000);

                       //Check price on purchase page
                       String priceonpurchase= driver.findElement(By.cssSelector("#MainForm > div.booking-steps-body > div.step-block > div.step-content > div > div.step-5.booking-step > div:nth-child(2) > div.bg-blue.bonuses-summary > div > div.col-xs-4.col-sm-2.text-center.pad-fix > p")).getText();
                       System.out.println("Prices on purchase page is:- " +priceonpurchase);
                       Reporter.log("Prices on purchase page is:- " +priceonpurchase);
                       Thread.sleep(2000);
  
   
    //For Purchase page                 
     try
     {
    	          
    	          System.out.println("FirstName_Of_Guest1: " + Firstname_GuestOne);
                  System.out.println("MiddleName_Of_Guest1: " + Middlename_GuestOne);
                  System.out.println("LastName_Of_Guest1: " + Lastname_GuestOne);
                  System.out.println("Email: " + Email);
                  System.out.println("Phone: " + Phone);
                  System.out.println("Address: " + Address);
                  System.out.println("City: " + City);
                  System.out.println("Zipcode: " + Zipcode);
                  System.out.println("FirstName_Of_Guest2: " + Firstname_GuestTwo);
                  System.out.println("MiddleName_Of_Guest2: " + Middlename_GuestTwo);
                  System.out.println("Lastname_of_Guest2: " + Lastname_GuestTwo);
   	           
    	 
    	          cdrpurchse.cdnPurchaseToTittle(Firstname_GuestOne, Middlename_GuestOne, Lastname_GuestOne, Email, Phone, Address, City, Zipcode, Firstname_GuestTwo, Middlename_GuestTwo, Lastname_GuestTwo);
           
    	          Thread.sleep(1500);
    	          
    	       // Click on continue button on purchase page
                  driver.findElement(By.cssSelector("#_ctl0_MainContentsPH__ctl0_FastBookLNK")).click();
                  Thread.sleep(4000);
    	          
    	       /*       
                  if(envrnmnt.toLowerCase().trim().equals("test"))
                  {
                      driver.findElement(By.cssSelector("#_ctl0_MainContentsPH__ctl0_FastHoldLNK")).click();  // Click on Hold
                      Thread.sleep(8000);
                  }     
            */             
     }
     catch(Exception e)
     {
                              System.out.println("Invalid guest information on purchase page, Please enter valid details for the required fields...");
                              System.out.println("\n");
                              System.out.println("Invalid guest information on purchasepage Logs..");
                              System.out.println("\n");
                              ExtractJSLogs();
                                       
                              final Screenshot screenshot34 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                              final BufferedImage image34 = screenshot34.getImage();
                              ImageIO.write(image34, "PNG", new File("D:\\Ajit\\Script_SS\\CDNCDORError\\5_InvalidGuestinfoonPurchasepage.png"));
                                       
                                Assert.assertFalse(false, "FAIL");
                        	    Reporter.log("Invalid guest information on purchase page, Please enter valid details for the required fields...");
                        		AssertJUnit.assertTrue("Invalid guest information on purchase page, Please enter valid details for the required fields....", crsbkngpge.isDisplayed());
                        		throw(e);
       }
                              long start6 = System.currentTimeMillis();
                              Thread.sleep(4000);           
                              System.out.println("\n");
                              System.out.println("Confirmationpage Logs..");
                              System.out.println("\n");
                              ExtractJSLogs();              
                              Thread.sleep(1000);
                              
                              long finish1111 = System.currentTimeMillis();
                              long totalTime1111 = finish1111 - start6; 
                              Reporter.log("Total Time for purchase page to confirmation page load(Milisec) - "+totalTime1111); 
                              Thread.sleep(1000);
                                              
                              final Screenshot screenshot44 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                              final BufferedImage image44 = screenshot44.getImage();
                              ImageIO.write(image44, "PNG", new File("D:\\Ajit\\Script_SS\\CDNCDOR\\11_HeldBooking.png"));
                                              
                              Thread.sleep(2000);
   /*                 
                  //For the verify held condition
                    try
                    {
                                    String status = driver.findElement(By.cssSelector("#MainForm > div.main > div.mar-top.summary-table-wrap > div > div.booking-status > div > div:nth-child(2) > div.col-xs-3.col-sm-4.col-md-3 > p")).getText(); 
                                            
                                    if(status.toLowerCase().trim().matches("held"))
                                    {
                                 	    System.out.println("Status Pass..");
                                 	    Assert.assertTrue(true, "PASS");
                                 	    Reporter.log("Status Pass..");
                                    }
                                    else
                                    {
                                 	    System.out.println("Status Fail b'coz status are differ to expected..");
                         				
                         				System.out.println("Actual status is:- "+ status);
                         				
                         	            final Screenshot screenshot5 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                         	   		    final BufferedImage image5 = screenshot5.getImage();
                         	   		    ImageIO.write(image5, "PNG", new File("D:\\Ajit\\Script_SS\\CDNCDORError\\5_HeldbookingFail.png"));
                         	            
                         	            Reporter.log("Actual status is:-" +status);
                         	            Assert.assertFalse(false, "FAIL");
                         	            Reporter.log("Status Fail b'coz status are differ to expected..");
                         			    AssertJUnit.assertTrue("Status Fail b'coz status are differ to expected...", crsbkngpge.isDisplayed());
                         			    return;
                         		     }
                                 
                                       Reporter.log("Actual status is:- " + status);
                                       
                                       Reporter.log("Status held successfully..");
                                 
                                       Thread.sleep(4000);
                    }       
                     catch (Exception e) {
 						// TODO: handle exception
                   	    e.getMessage();
 					}            
                       
                 // For Click on full payment
                    try
                    {
                    	 driver.findElement(By.cssSelector("#_ctl0_MainContentsPH__ctl0_ConfirmBkgLNK")).click(); 
                    	 Thread.sleep(5000);
                    	 
                    	 final Screenshot screenshot74 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                         final BufferedImage image74 = screenshot74.getImage();
                         ImageIO.write(image74, "PNG", new File("D:\\Ajit\\Script_SS\\CDNCDOR\\015_Paymentpage.png"));
                         Thread.sleep(4000);
                         
                         
                    }
                    catch(Exception e)
                    {
                    	final Screenshot screenshot94 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                        final BufferedImage image94 = screenshot94.getImage();
                        ImageIO.write(image94, "PNG", new File("D:\\Ajit\\Script_SS\\CDNCDORError\\11_Paymentdetails.png"));
                
                        Assert.assertFalse(false, "FAIL");
          	            Reporter.log("Something went wrong...");
          	            AssertJUnit.assertTrue("Something went wrong...", crsbkngpge.isDisplayed());
          	            throw(e);
                    }
                    
         */                   //For Verify price on confirmation page
                              String priceoncon = driver.findElement(By.cssSelector("#MainForm > div > div.step-block > div > div.step-6.booking-step.main.step-six-page > div.step-5.booking-step > div > div.bg-blue.bonuses-summary > div > div.col-xs-4.col-sm-2.text-center.pad-fix > p")).getText();
                              Reporter.log("Price on confirmationpage is:- "+ priceoncon);
                              Thread.sleep(1000);
                        
                    
                  try
                  {
                    	// For Payment details
                        System.out.println("CardNo: " + CardNo);
                        System.out.println("CardCvvNo: " + CardCvvNo);
                        System.out.println("CardHolderName: " + CardHolderName);
                        System.out.println("Address: " + Address);
                        System.out.println("City: " + City);
                        System.out.println("Zipcode: " + Zipcode);
                        System.out.println("Phone_Number: " + Phone_Number);
                   //   System.out.println("BankName: " + BankName);
                       
                        hldncnfrm.CDNPaymentToTitle(CardNo, CardCvvNo, CardHolderName, Address, City, Zipcode, Phone_Number);
                        Thread.sleep(4000);
                       
                        //For terms and condition
                        WebElement ell = driver.findElement(By.cssSelector("#MainForm > div > div.step-block > div > div.step-6.booking-step.main.step-six-page > div.terms-section > div.policy.mar-lg-top > p [id*='AgreeTermsCHK']"));
                        ell.click();
                        Thread.sleep(1000);
                        
                        //For click on confirm booking
                        if(envrnmnt.toLowerCase().trim().equals("test"))
                        {
                            driver.findElement(By.cssSelector("#_ctl0_MainContentsPH__ctl0_ContinueLNK")).click();
                                               
                            long start78 = System.currentTimeMillis();  
                            
                            Thread.sleep(18000);
                            
                            long finish1117 = System.currentTimeMillis();
                            long totalTime1117 = finish1117 - start78; 
                            Reporter.log("Total Time for Payment page to Confirm booking page load(Milisec) - "+totalTime1117); 
                            Thread.sleep(1000);
                            
                            System.out.println("\n");
                            System.out.println("Confirm booking page Logs..");
                            System.out.println("\n");
                            ExtractJSLogs();              
                            Thread.sleep(1000);
                        }   
                         // For the verify confirm condition
                            String status1 = driver.findElement(By.cssSelector("#finalizedInfo > p:nth-child(2) > strong")).getText(); 
                                              
                            if(status1.toLowerCase().trim().matches("confirmed"))
                            {
                           	    System.out.println("Status Pass..");
                           	    Assert.assertTrue(true, "PASS");
                           	    Reporter.log("Status Pass..");
                            }
                            else
                            {
                           	     System.out.println("Status Fail b'coz status are differ to expected..");
                   				
                   				 System.out.println("Actual status is:- "+ status1);
                   		         final Screenshot screenshot90 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                   				 final BufferedImage image90 = screenshot90.getImage();
                   				 ImageIO.write(image90, "PNG", new File("D:\\Ajit\\Script_SS\\CDNCDORError\\6_ConfirmbookingFail.png"));
                   		               
                   		         Reporter.log("Actual status is:-" +status1);
                   		         Assert.assertFalse(false, "FAIL");
                   		         Reporter.log("Status Fail b'coz status are differ to expected..");
                   		         AssertJUnit.assertTrue("Status Fail b'coz status are differ to expected...", crsbkngpge.isDisplayed());
                   			     return;
                   	        }
                           
                              System.out.println("Actual status is:- "+ status1);
                              Reporter.log("Actual status is:- " + status1);
                            
                              final Screenshot screenshot76 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                              final BufferedImage image76 = screenshot76.getImage();
                              ImageIO.write(image76, "PNG", new File("D:\\Ajit\\Script_SS\\CDNCDOR\\17_ConfirmBooking.png"));
                              Thread.sleep(4000);
                            
                              System.out.println("Flight confirmed successfully..");
                            
                              Reporter.log("Flight confirmed successfully..");  // For displaying message on report
                              
                              long start79 = System.currentTimeMillis();  
                              Thread.sleep(10000);
                              long finish1119 = System.currentTimeMillis();
                              long totalTime1119 = finish1119 - start79; 
                              Reporter.log("Total Time for Confirm booking page to Admin default page load(Milisec) - "+totalTime1119); 
                              Thread.sleep(1000);
                            	 
              }     							 
              catch (Exception e) 
              {
      	            final Screenshot screenshot94 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                    final BufferedImage image94 = screenshot94.getImage();
                    ImageIO.write(image94, "PNG", new File("D:\\Ajit\\Script_SS\\CDNCDORError\\10_Paymentpage.png"));
            
                    Assert.assertFalse(false, "FAIL");
      	            Reporter.log("Something went wrong...");
      	            AssertJUnit.assertTrue("Something went wrong...", crsbkngpge.isDisplayed());
      	            throw(e);
			      }   
              
                  driver.get("https://localhost/odyssey/admin/default.aspx");
                  driver.navigate().refresh();
                  driver.manage().window().maximize();
                  
                  System.out.println("\n");
                  System.out.println("Admindefaultpage Logs..");
                  System.out.println("\n");
                  ExtractJSLogs();
                  
                  Thread.sleep(100);
                  
                  final Screenshot screenshot11 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
       		      final BufferedImage image11 = screenshot11.getImage();
       		      ImageIO.write(image11, "PNG", new File("D:\\Ajit\\Script_SS\\CDNCDOR\\18_Admindefaultpage.png"));
                  
                  Thread.sleep(7000);
                  
                  //For Cancel booking
                  driver.get("https://localhost/odyssey/admin/default.aspx");
                  driver.navigate().refresh();
                  driver.manage().window().maximize();
                  
                  Thread.sleep(4000);
            try
            {
          	      driver.findElement(By.className("manage_btn")).click();
        	      Thread.sleep(200);
        	      driver.findElement(By.xpath("//a[@class='cancel_icon show_True']")).click();
        	      driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
          	      WebElement elm = driver.findElement(By.id("_ctl0_MainContent_CancelBookingBTN"));
        	      elm.click();
         	    
      		      Thread.sleep(100);
      			
        	        Alert alert=driver.switchTo().alert();
        	        alert.accept();
        	    
        	      System.out.println("\n");
                  System.out.println("Cancelbooking on admin defaultpage Logs..");
                  System.out.println("\n");
                  ExtractJSLogs();
      			
      		      Thread.sleep(200);
        	    
        	      final Screenshot screenshot16 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
      	 	      final BufferedImage image16 = screenshot16.getImage();
      	 	      ImageIO.write(image16, "PNG", new File("D:\\Ajit\\Script_SS\\CDNCDOR\\19_Cancelbookingpopup.png"));
        	    
        	        driver.switchTo().defaultContent();
        	        Thread.sleep(6000);
        	        driver.navigate().refresh();
        	      
            }catch(Exception e)
            {
          	       System.out.println("\n");
                   System.out.println("Cancel booking fail on admin defaultpage Logs..");
                   System.out.println("\n");
                   ExtractJSLogs();
                
      	         final Screenshot screenshot17 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
      		 	 final BufferedImage image17 = screenshot17.getImage();
      		 	 ImageIO.write(image17, "PNG", new File("D:\\Ajit\\Script_SS\\CDNCDORError\\13_CancelbookingFail.png"));
      	               
      	         Assert.assertFalse(false, "FAIL");
      	         Reporter.log("Booking cancel failed...");
      	         AssertJUnit.assertTrue("Booking cancel failed...", crsbkngpge.isDisplayed());
      		     return;
      	         
            }
                   Thread.sleep(7000);
                   
                   // For the verify cancel condition
                   String status2 = driver.findElement(By.xpath("//*[@id='gridOld']/div[2]/table/tbody/tr[1]/td[2]/strong")).getText(); 
                                     
                   if(status2.toLowerCase().trim().matches("cancelled"))
                   {
                  	    System.out.println("Status Pass..");
                  	    Assert.assertTrue(true, "PASS");
                  	    Reporter.log("Status Pass..");
                   }
                   else
                   {
          				 System.out.println("Status Fail..");
          				 System.out.println("Actual status is:- "+ status2);
          				
           		         final Screenshot screenshot18 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
          			 	 final BufferedImage image18 = screenshot18.getImage();
          			 	 ImageIO.write(image18, "PNG", new File("D:\\Ajit\\Script_SS\\CDNCDORError\\14_CancelbookingstatusFail.png"));
          		               
          		         Reporter.log("Actual status is:- " + status2);
          		         Assert.assertFalse(false, "FAIL");
          		         Reporter.log("Cancel status fail..");
          		         AssertJUnit.assertTrue("Cancel Status Fail...", crsbkngpge.isDisplayed());
          			     return;
          	     }
                  
                     System.out.println("Actual status is:- "+ status2);
                     Reporter.log("Actual status is:- " + status2);
                      
                     final Screenshot screenshot19 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
    			     final BufferedImage image19 = screenshot19.getImage();
    			     ImageIO.write(image19, "PNG", new File("D:\\Ajit\\Script_SS\\CDNCDOR\\20_Bookingcancelled.png"));
                 
                     System.out.println("Booking cancelled successfully..");
                   
                     Reporter.log("Booking cancelled successfully..");
                  
                     Thread.sleep(4000);

}

@DataProvider
public String[][] Authentications() throws Exception
{
	 
	     String[][] testObjArray = CDNCruiseUtils.getTableArray("D:\\Ajit\\Automation\\Workspace\\Odysseus_Product\\src\\main\\java\\testData\\CDNCruiseData.xlsx","Sheet1");
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
