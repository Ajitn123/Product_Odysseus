package Implementation;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Date;
import java.util.List;
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
import Utility.OdysolAirUtils;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.screentaker.ViewportPastingStrategy;


public class AlanitaETicketedCancelBtoBTest 
{

	   AlanitLoginapgeobjct lgnpge;
	   AlanitaBookingpgeobjct airbk;
	   OdysolAirCheckoutpageobjct chckout;
	   OdysolAirHoldAndConfirmPgeobjct hldncnfrm;
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
	                       //   driver = new FirefoxDriver();
	   
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
        driver.get("https://ui.odysol.com/admin/login.aspx");
        Thread.sleep(2000);
    
        //Save console
        String testResultFile="D:\\Ajit\\Script_SS\\ConsoleError\\AlanitaETicketedCancelBookingError.txt";
        File file = new File(testResultFile);  
        FileOutputStream fis = new FileOutputStream(file);  
        PrintStream out = new PrintStream(fis);  
        System.setOut(out); 
                  
        Thread.sleep(1000);
    
        final Screenshot screenshot01 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
        final BufferedImage image01 = screenshot01.getImage();
        ImageIO.write(image01, "PNG", new File("D:\\Ajit\\Script_SS\\AlanitaETicketedCancel\\1_Loginpage.png"));
   
        //driver.navigate().to("https://localhost/odyssey/website/air/results.aspx?");
        Thread.sleep(4000);
        lgnpge = PageFactory.initElements(driver, AlanitLoginapgeobjct.class);
        airbk = PageFactory.initElements(driver, AlanitaBookingpgeobjct.class);
        chckout = PageFactory.initElements(driver, OdysolAirCheckoutpageobjct.class);
        hldncnfrm = PageFactory.initElements(driver, OdysolAirHoldAndConfirmPgeobjct.class);
              
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
    public void Heldlogin_data(String sUsername, String sPassword, String FromLocation, String ToLocation, String Firstname_Of_Adult1, String Middlename_of_Adult1, String Lastname_Of_Adult1, String Firstname_Of_Adult2, String Middlename_of_Adult2, String Lastname_Of_Adult2, String Firstname_Of_Adult3, String Middlename_of_Adult3, String Lastname_Of_Adult3, String Email, String Confirm_Email, String Phone_No, String CardHolderName, String CardNo, String CardCvvNo, String Address, String City, String Zipcode, String Phone_Number, String BankName) throws Exception
    {
       try
       {
    	   //For web site and booking details
           Reporter.log("Website Name :- Alanita Travel");
           Thread.sleep(200);
    	   
  	       System.out.println("sUsername: " + sUsername);
           System.out.println("sPassword: " + sPassword);
           System.out.println("FromLocation: " + FromLocation);
           System.out.println("ToLocation: " + ToLocation);
       
           lgnpge.LoginToTittle(sUsername, sPassword);
           long start = System.currentTimeMillis();
           Thread.sleep(900);
           System.out.println("\n");
           System.out.println("Loginpage Logs..");
           System.out.println("\n");
           ExtractJSLogs();
           Thread.sleep(500);
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
          	      
              	  final Screenshot screenshot1 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
      	          final BufferedImage image1 = screenshot1.getImage();
      	          ImageIO.write(image1, "PNG", new File("D:\\Ajit\\Script_SS\\AlanitaETicketedCancelError\\0_Invalidcredentials.png"));
      	          
      	          Assert.assertFalse(false, "FAIL");
      	          Reporter.log("Username and Password are invalid..");
              	  AssertJUnit.assertTrue("Username Or Password are invalid...", lgnpge.isDisplayed());
              	  throw(e);
                	  
       }
       try
       {
        
           airbk.AlanitabookingToTitle(FromLocation, ToLocation);
           long start = System.currentTimeMillis();
           Thread.sleep(800);
           System.out.println("\n");
           System.out.println("Searchpage Logs..");
           System.out.println("\n");
           ExtractJSLogs();
           Thread.sleep(700);
           long finish = System.currentTimeMillis();
           long totalTime = finish - start; 
           Reporter.log("Total Time for search page to result page load(Milisec) - "+totalTime); 
           Thread.sleep(1000);
        
           final Screenshot screenshot = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
           final BufferedImage image = screenshot.getImage();
           ImageIO.write(image, "PNG", new File("D:\\Ajit\\Script_SS\\AlanitaETicketedCancel\\2_Searchpage.png"));
        
        
      }  
      catch(Exception e)
      {
 	       System.out.println("\n");
	       System.out.println("Invalid search details or displaying error message on Searchpage Logs..");
	       System.out.println("\n");
	       ExtractJSLogs();
	      
	       //File scr02 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	       //org.codehaus.plexus.util.FileUtils.copyFile(scr02, new File("D:\\Ajit\\Script_SS\\Error\\Invalidcredentials.jpg"));
	       final Screenshot screenshot1 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	       final BufferedImage image1 = screenshot1.getImage();
	       ImageIO.write(image1, "PNG", new File("D:\\Ajit\\Script_SS\\AlanitaETicketedCancelError\\1_InvaliddetailsorError.png"));
	          
	       Assert.assertFalse(false, "FAIL");
	       Reporter.log("Invalid search details or displaying error message..");
	       AssertJUnit.assertTrue("Invalid search details or displaying error message...", airbk.isDisplayed());
	       throw(e);
                     	  
     }
      
          Thread.sleep(12000);

    // For select dynamic flights from result page
    for(int i = driver.getWindowHandles().size() -1 ; i > 0 ; i--)
    {

            String winHandle = driver.getWindowHandles().toArray()[i].toString();

            driver.switchTo().window(winHandle);
     
            driver.navigate().refresh();
   
            driver.get("https://air.alanitatravel.com/web/air/results.aspx?showtrace=true");

	        driver.manage().window().maximize();
	        
	        System.out.println("\n");
	        System.out.println("Resultpage Logs..");
	        System.out.println("\n");
	        ExtractJSLogs();
	        
            Thread.sleep(1000);
	 
	       final Screenshot screenshot04 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
           final BufferedImage image04 = screenshot04.getImage();
           ImageIO.write(image04, "PNG", new File("D:\\Ajit\\Script_SS\\AlanitaETicketedCancel\\3_Resultpage.png"));
     
 
	        Thread.sleep(3000);
	  
	  
       List<WebElement> options = driver.findElements(By.className("print-select-flight"));

   
      if(options.size()>0)
      {
           options.get(2).click();  // 1 for AmadeusWS or 2 for Sabre
      }
      else 
      {
      	  System.out.println("Flight not available..");
      	  System.out.println("\n");
      	  System.out.println("Flight not available on resultpage Logs..");
      	  System.out.println("\n");
      	  ExtractJSLogs();
       	
      	 final Screenshot screenshot2 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
         final BufferedImage image2 = screenshot2.getImage();
         ImageIO.write(image2, "PNG", new File("D:\\Ajit\\Script_SS\\AlanitaETicketedCancelError\\2_Flightnotavailable.png"));
         
            Assert.assertFalse(false, "FAIL");
	        Reporter.log("Flights not available..");
			AssertJUnit.assertTrue("Flight not available...", airbk.isDisplayed());
			return;
	   }
           long start = System.currentTimeMillis();
           Thread.sleep(800);
           System.out.println("\n");
           System.out.println("Checkoutpage Logs..");
           System.out.println("\n");
           ExtractJSLogs();              
           Thread.sleep(1000);
           long finish = System.currentTimeMillis();
           long totalTime = finish - start; 
           Reporter.log("Total Time for result page to checkout page load(Milisec) - "+totalTime); 
           Thread.sleep(1000);
         
           final Screenshot screenshot3 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
           final BufferedImage image3 = screenshot3.getImage();
           ImageIO.write(image3, "PNG", new File("D:\\Ajit\\Script_SS\\AlanitaETicketedCancel\\4_Checkoutpage.png"));
  
           System.out.println("Flight selected successfully..");
          
           Thread.sleep(1000);
  
    try
    {
 	    //For Trip details on checkout page
   	    String frmloc = driver.findElement(By.cssSelector("#TripSummary > div.product-seg.air-summary.checkout_flight_details > div.depart-seg > div.flight-loc")).getText();
   	    Reporter.log("Departure Trip Location: " +frmloc);
   	    Thread.sleep(500);
   	    String toloc = driver.findElement(By.cssSelector("#TripSummary > div.product-seg.air-summary.checkout_flight_details > div.arrive-seg > div.flight-loc")).getText();
   	    Reporter.log("Return Trip Location: " +toloc);
   	    Thread.sleep(500);
   	    String frmdte = driver.findElement(By.cssSelector("#TripSummary > div.product-seg.air-summary.checkout_flight_details > div.depart-seg > div.flight-date")).getText();
   	    Reporter.log("From Date: " +frmdte);
   	    Thread.sleep(500);
   	    String todte = driver.findElement(By.cssSelector("#TripSummary > div.product-seg.air-summary.checkout_flight_details > div.arrive-seg > div.flight-date")).getText();
   	    Reporter.log("To Date: " +todte);
   	    Thread.sleep(500);
   	    String psngr = driver.findElement(By.cssSelector("#TripSummary > div.product-seg.air-summary.checkout_flight_details > div.tkt-pass-cont > div.tkt-pass-num")).getText();
   	    Reporter.log("No of passengers: " +psngr);
   	    Thread.sleep(500);
   	 
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
       Thread.sleep(2000);
   	 
        //For Passenger details
        System.out.println("Firstname_Of_Adult1: " + Firstname_Of_Adult1);
        System.out.println("Middlename_of_Adult1:" + Middlename_of_Adult1);
        System.out.println("Lastname_Of_Adult1: " + Lastname_Of_Adult1);
        System.out.println("Firstname_Of_Adult2: " + Firstname_Of_Adult2);
        System.out.println("Middlename_of_Adult2:" + Middlename_of_Adult2);
        System.out.println("Lastname_Of_Adult2: " + Lastname_Of_Adult2);
        System.out.println("Firstname_Of_Adult3: " + Firstname_Of_Adult3);
        System.out.println("Middlename_of_Adult3:" + Middlename_of_Adult3);
        System.out.println("Lastname_Of_Adult3: " + Lastname_Of_Adult3);
        System.out.println("Email: " + Email);
        System.out.println("Confirm_Email: " + Confirm_Email);
        System.out.println("Phone_No: " + Phone_No);
              
        chckout.AlanitaHoldToTitle(Firstname_Of_Adult1, Middlename_of_Adult1, Lastname_Of_Adult1, Firstname_Of_Adult2, Middlename_of_Adult2, Lastname_Of_Adult2, Firstname_Of_Adult3, Middlename_of_Adult3, Lastname_Of_Adult3, Email, Confirm_Email, Phone_No);
         
    }
    catch(Exception e)
    {
   	   System.out.println("\n");
   	   System.out.println("Timeout on checkoutpage Logs..");
   	   System.out.println("\n");
   	   ExtractJSLogs();
   	 
       final Screenshot screenshot4 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	   final BufferedImage image4 = screenshot4.getImage();
	   ImageIO.write(image4, "PNG", new File("D:\\Ajit\\Script_SS\\AlanitaETicketedCancelError\\3_Timeouterror.png"));
        
       Assert.assertFalse(false, "FAIL");
       Reporter.log("Timeout error...");
  	   AssertJUnit.assertTrue("Timeout error...", chckout.isDisplayed());
  	   throw(e);
    }
 
        Thread.sleep(4000);
    
    //For Held Booking(If test environment Test then Booking Held, Confirm, Ticketed and Cancel)    
    try
    {
        
    	 String expr = driver.findElement(By.id("TracerBlock")).getText();
   	     String testenvrnmnt = expr.split("OdysseyGateway")[6].split(":")[2].trim();
   	     
         if(testenvrnmnt.toLowerCase().trim().equals("test"))
         {
       	    //   driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_HoldBTN")).click();
         }
           
    }
    catch(Exception e)
    {
      	   System.out.println("\n");
      	   System.out.println("Statusfail on confirmationpage Logs..");
      	   System.out.println("\n");
      	   ExtractJSLogs();
      	 
      	   final Screenshot screenshot44 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
           final BufferedImage image44 = screenshot44.getImage();
           ImageIO.write(image44, "PNG", new File("D:\\Ajit\\Script_SS\\AlanitaETicketedCancelError\\4_Statusfail.png"));
           
           Assert.assertFalse(false, "FAIL");
     	   Reporter.log("Held button not click because Production Environment..");
           AssertJUnit.assertTrue("Held button not click because Production Environment...", chckout.isDisplayed());
           throw(e);
       }
       
              Thread.sleep(30000);
              
              System.out.println("\n");
              System.out.println("Heldbooking Logs..");
              System.out.println("\n");
              ExtractJSLogs();
              
              Thread.sleep(1000);
   
  /*            
       //Verify passenger's name validation on checkout page
       try
       {
                //For passenger 1 
                String Passengerfirstnme = driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl0_TravelerAccount_1_FirstName")).getText();
                      
                if(Passengerfirstnme.trim().length()<=29)
                {
                	 System.out.println("Error message: " +Passengerfirstnme);
                	 Reporter.log("Error message: " +Passengerfirstnme);	
                	 
                	 final Screenshot screenshot5 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
		             final BufferedImage image5 = screenshot5.getImage();
		             ImageIO.write(image5, "PNG", new File("D:\\Ajit\\Script_SS\\AlanitaETicketedCancelError\\9_Invalidfirstname.png"));
    	       	     
    	       	     AssertJUnit.assertTrue("Error message: " +Passengerfirstnme, chckout.isDisplayed());
    	          	 return;
                    
                }
       }        
       catch (Exception e) 
       {
		    e.getMessage();	
	    }        
        
       try
       {
                String Passengermdlnme = driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl0_TravelerAccount_1_MiddleName")).getText();
                
                if(Passengermdlnme.trim().length()<=29)
                {
                  	 System.out.println("Error message: " +Passengermdlnme);
                	 Reporter.log("Error message: " +Passengermdlnme);	
                	 
                	 final Screenshot screenshot6 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
		             final BufferedImage image6 = screenshot6.getImage();
		             ImageIO.write(image6, "PNG", new File("D:\\Ajit\\Script_SS\\AlanitaETicketedCancelError\\10_Invalidlastname.png"));
    	       	     
    	       	     AssertJUnit.assertTrue("Error message: " +Passengermdlnme, chckout.isDisplayed());
    	          	 return;
                    
                }
        }       
        catch (Exception e)
        {
			 e.getMessage();
		 }       
       
       try
       {
                String Passengerlastnme = driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl0_TravelerAccount_1_LastName")).getText();
                
                if(Passengerlastnme.trim().length()<=29)
                {
                  	 System.out.println("Error message: " +Passengerlastnme);
                	 Reporter.log("Error message: " +Passengerlastnme);	
                	 
                	 final Screenshot screenshot6 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
		             final BufferedImage image6 = screenshot6.getImage();
		             ImageIO.write(image6, "PNG", new File("D:\\Ajit\\Script_SS\\AlanitaETicketedCancelError\\11_Invalidlastname.png"));
    	       	     
    	       	     AssertJUnit.assertTrue("Error message: " +Passengerlastnme, chckout.isDisplayed());
    	          	 return;
                    
                }
         }       
         catch (Exception e)
         {
			  e.getMessage();
		  }       
          
         try
         {
                //For passenger 2
                String Passengerfirstnme2 = driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl1_TravelerAccount_2_FirstName")).getText();
                
                if(Passengerfirstnme2.trim().length()<=29)
                {
                	 	
                	 System.out.println("Error message: " +Passengerfirstnme2);
                  	 Reporter.log("Error message: " +Passengerfirstnme2);	
                	 
                	 final Screenshot screenshot7 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
		             final BufferedImage image7 = screenshot7.getImage();
		             ImageIO.write(image7, "PNG", new File("D:\\Ajit\\Script_SS\\AlanitaETicketedCancelError\\11_Invalidfirstname2.png"));
    	       	     
    	       	     AssertJUnit.assertTrue("Error message: " +Passengerfirstnme2, chckout.isDisplayed());
    	          	 return;
                }
         }
         catch(Exception e)
         {
        	 e.getMessage();
         }
         
         try
         {
                String Passengermdlnme2 = driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl1_TravelerAccount_2_MiddleName")).getText();
                
                if(Passengermdlnme2.trim().length()<=29)
                {
                	 System.out.println("Error message: " +Passengermdlnme2);
                	 Reporter.log("Error message: " +Passengermdlnme2);	
                	 
    	       	     final Screenshot screenshot8 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
		             final BufferedImage image8 = screenshot8.getImage();
		             ImageIO.write(image8, "PNG", new File("D:\\Ajit\\Script_SS\\AlanitaETicketedCancelError\\12_Invalidlastname2.png"));
    	       	     
    	       	     AssertJUnit.assertTrue("Error message: " +Passengermdlnme2, chckout.isDisplayed());
    	          	 return;
                 }
         }
         catch(Exception e)
         {
        	 e.getMessage();
         }
         
         
         try
         {
                String Passengerlastnme2 = driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl1_TravelerAccount_2_LastName")).getText();
                
                if(Passengerlastnme2.trim().length()<=29)
                {
                	 System.out.println("Error message: " +Passengerlastnme2);
                	 Reporter.log("Error message: " +Passengerlastnme2);	
                	 
    	       	     final Screenshot screenshot8 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
		             final BufferedImage image8 = screenshot8.getImage();
		             ImageIO.write(image8, "PNG", new File("D:\\Ajit\\Script_SS\\AlanitaETicketedCancelError\\13_Invalidlastname2.png"));
    	       	     
    	       	     AssertJUnit.assertTrue("Error message: " +Passengerlastnme2, chckout.isDisplayed());
    	          	 return;
                 }
         }
         catch(Exception e)
         {
        	 e.getMessage();
         }
         
         try
         {
                //For passenger 3
                String Passengerfirstnme3 = driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl2_TravelerAccount_3_FirstName")).getText();
                
                if(Passengerfirstnme3.trim().length()<=29)
                {
                	 System.out.println("Error message: " +Passengerfirstnme3);
                 	 Reporter.log("Error message: " +Passengerfirstnme3);	
                	 
    	       	     final Screenshot screenshot9 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
		             final BufferedImage image9 = screenshot9.getImage();
		             ImageIO.write(image9, "PNG", new File("D:\\Ajit\\Script_SS\\AlanitaETicketedCancelError\\13_Invalidfirstname3.png"));
    	       	     
    	       	     AssertJUnit.assertTrue("Error message: " +Passengerfirstnme3, chckout.isDisplayed());
    	          	 return;
                 }
         }
         catch(Exception e)
         {
        	 e.getMessage();
         }
         
         try
         {
                String Passengermdlnme3 = driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl2_TravelerAccount_3_MiddleName")).getText();
                
                if(Passengermdlnme3.trim().length()<=29)
                {
                 	 System.out.println("Error message: " +Passengermdlnme3);
                	 Reporter.log("Error message: " +Passengermdlnme3);	
                	 
    	       	     final Screenshot screenshot10 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
		             final BufferedImage image10 = screenshot10.getImage();
		             ImageIO.write(image10, "PNG", new File("D:\\Ajit\\Script_SS\\AlanitaETicketedCancelError\\14_Invalidlastname3.png"));
    	       	     
    	       	     AssertJUnit.assertTrue("Error message: " +Passengermdlnme3, chckout.isDisplayed());
    	          	 return;
                }
         }
         catch(Exception e)
         {
        	 e.getMessage();
         }
         
         try
         {
                String Passengerlastnme3 = driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl2_TravelerAccount_3_LastName")).getText();
                
                if(Passengerlastnme3.trim().length()<=29)
                {
                 	 System.out.println("Error message: " +Passengerlastnme3);
                	 Reporter.log("Error message: " +Passengerlastnme3);	
                	 
    	       	     final Screenshot screenshot10 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
		             final BufferedImage image10 = screenshot10.getImage();
		             ImageIO.write(image10, "PNG", new File("D:\\Ajit\\Script_SS\\AlanitaETicketedCancelError\\14_Invalidlastname3.png"));
    	       	     
    	       	     AssertJUnit.assertTrue("Error message: " +Passengerlastnme3, chckout.isDisplayed());
    	          	 return;
                }
         }
         catch(Exception e)
         {
        	   e.getMessage();
         }
         
               Thread.sleep(1000);
    */          
     
       //For the verify held condition
       try
       {       
           String status = driver.findElement(By.xpath("//*[@id='conf_details']/div/div[6]/div")).getText(); 
                     
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
  	   		    ImageIO.write(image5, "PNG", new File("D:\\Ajit\\Script_SS\\AlanitaETicketedCancelError\\5_HeldbookingFail.png"));
  	            
  	            Reporter.log("Actual status is:-" +status);
  	            Assert.assertFalse(false, "FAIL");
  	            Reporter.log("Status Fail b'coz status are differ to expected..");
  			    AssertJUnit.assertTrue("Status Fail b'coz status are differ to expected...", chckout.isDisplayed());
  			    return;
  		   }
          
              System.out.println("Actual status is:- "+ status);
              Reporter.log("Actual status is:- " + status);
           
              final Screenshot screenshot6 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
  		      final BufferedImage image6 = screenshot6.getImage();
  		      ImageIO.write(image6, "PNG", new File("D:\\Ajit\\Script_SS\\AlanitaETicketedCancel\\5_Flightheld.png"));
           
              System.out.println("Flight held Successfully..");
           
              Reporter.log("Flight held successfully..");  // For displaying message on report
           
              Thread.sleep(10000);
           
        }
        catch(Exception e)
        {
      	     System.out.println("Time out..");
  			
            final Screenshot screenshot7 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
     	    final BufferedImage image7 = screenshot7.getImage();
     	    ImageIO.write(image7, "PNG", new File("D:\\Ajit\\Script_SS\\AlanitaETicketedCancelError\\6_Timeout.png"));
           
            Assert.assertFalse(false, "FAIL");
            Reporter.log("Time out..");
  		    AssertJUnit.assertTrue("Time out...", chckout.isDisplayed());
  		    return;
       }
      
      try
      {
          // For Payment details
          System.out.println("CardHolderName: " + CardHolderName);
          System.out.println("CardNo: " + CardNo);
          System.out.println("CardCvvNo: " + CardCvvNo);
          System.out.println("Address: " + Address);
          System.out.println("City: " + City);
          System.out.println("Zipcode: " + Zipcode);
          System.out.println("Phone_Number: " + Phone_Number);
     //   System.out.println("BankName: " + BankName);
         
          hldncnfrm.HoldAfterConfirmToTitle(CardHolderName, CardNo, CardCvvNo, Address, City, Zipcode, Phone_Number);
      }
      catch(Exception e)
      {
     	  System.out.println("\n");
          System.out.println("Timeout on Checkoutpage Logs..");
          System.out.println("\n");
          ExtractJSLogs();
          
     	   final Screenshot screenshot8 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
 		   final BufferedImage image8 = screenshot8.getImage();
 		   ImageIO.write(image8, "PNG", new File("D:\\Ajit\\Script_SS\\AlanitaETicketedCancelError\\7_Timeouterror.png"));
          
           Assert.assertFalse(false, "FAIL");
           Reporter.log("Timeout error...");
    	   AssertJUnit.assertTrue("Timeout error...", chckout.isDisplayed());
    	   throw(e);
      }
          
           Thread.sleep(500);  
           System.out.println("\n");
           System.out.println("Confirmationpage Logs..");
           System.out.println("\n");
           ExtractJSLogs();
           
           Thread.sleep(18000);
      
          // For the verify confirm condition
          String status1 = driver.findElement(By.xpath("//*[@id='conf_details']/div/div[6]/div")).getText(); 
                            
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
 				
  		         final Screenshot screenshot9 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
 				 final BufferedImage image9 = screenshot9.getImage();
 				 ImageIO.write(image9, "PNG", new File("D:\\Ajit\\Script_SS\\AlanitaETicketedCancel\\6_ConfirmbookingFail.png"));
 		               
 		         Reporter.log("Actual status is:-" +status1);
 		         Assert.assertFalse(false, "FAIL");
 		         Reporter.log("Status Fail b'coz status are differ to expected..");
 		         AssertJUnit.assertTrue("Status Fail b'coz status are differ to expected...", chckout.isDisplayed());
 			     return;
 	     }
         
            System.out.println("Actual status is:- "+ status1);
            Reporter.log("Actual status is:- " + status1);
          
            final Screenshot screenshot10 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
 		    final BufferedImage image10 = screenshot10.getImage();
 		    ImageIO.write(image10, "PNG", new File("D:\\Ajit\\Script_SS\\AlanitaETicketedCancel\\7_Confirmbooking.png"));
          
            System.out.println("Flight confirmed successfully..");
          
            Reporter.log("Flight confirmed successfully..");  // For displaying message on report
            
            Thread.sleep(10000);

      }
       
             driver.get("https://ui.odysol.com/admin/default.aspx");
             driver.navigate().refresh();
             driver.manage().window().maximize();
             
             System.out.println("\n");
             System.out.println("Admindefaultpage Logs..");
             System.out.println("\n");
             ExtractJSLogs();
             
             Thread.sleep(100);
             
             final Screenshot screenshot11 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
  		     final BufferedImage image11 = screenshot11.getImage();
  		     ImageIO.write(image11, "PNG", new File("D:\\Ajit\\Script_SS\\AlanitaETicketedCancel\\8_Admindefaultpage.png"));
             
             Thread.sleep(7000);
             
       try
       {
             //For E-Ticket from Manage(Admin)
             driver.findElement(By.className("manage_btn")).click();
             driver.findElement(By.className("editstat_icon")).click();
             
             System.out.println("\n");
             System.out.println("Editstatus on admin defaultpage Logs..");
             System.out.println("\n");
             ExtractJSLogs();
             
             Thread.sleep(3000);
             driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
             WebElement elmt = driver.findElement(By.id("_ctl0_MainContent_StatusSEL"));
             elmt.click();
             driver.findElement(By.xpath("//*[@id='_ctl0_MainContent_StatusSEL']/option[8]")).click();
             driver.findElement(By.id("_ctl0_MainContent_SubmitBTN")).click(); 
             driver.switchTo().defaultContent();
             
             Thread.sleep(1000);
             System.out.println("\n");
             System.out.println("Ticketed booking on admin defaultpage Logs..");
             System.out.println("\n");
             ExtractJSLogs();
             
             Thread.sleep(2000);
             driver.navigate().refresh();
             Thread.sleep(1000);
             
       }
       catch(Exception e)
       {
     	      Reporter.log("Status Ticketed fail..");
     	     
     	      System.out.println("\n");
              System.out.println("Ticketed status fail on admin defaultpage Logs..");
              System.out.println("\n");
              ExtractJSLogs();
     	  
     	     final Screenshot screenshot12 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
 	 		 final BufferedImage image12 = screenshot12.getImage();
 	 		 ImageIO.write(image12, "PNG", new File("D:\\Ajit\\Script_SS\\AlanitaETicketedCancelError\\8_ETicketedstatusFail.png"));
 	         
 	         driver.findElement(By.xpath("/html/body/div[6]/div[1]/button/span[1]")).click();
 	         AssertJUnit.assertTrue("Status fail for E-Ticketed...", hldncnfrm.isDisplayed());
 	         
       }
       
       //For Check condition E-Ticketed
       String status3 = driver.findElement(By.xpath("//*[@id='gridOld']/div[2]/table/tbody/tr[1]/td[2]/strong")).getText(); 
             
       if(status3.toLowerCase().trim().matches("ticketed"))
       {
      	    System.out.println("Status Pass..");
      	    Assert.assertTrue(true, "PASS");
      	    Reporter.log("Status Pass..");
       }
       else
       {
 			System.out.println("Status Fail..");
 							
 			final Screenshot screenshot14 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
 	 		final BufferedImage image14 = screenshot14.getImage();
 	 		ImageIO.write(image14, "PNG", new File("D:\\Ajit\\Script_SS\\AlanitaETicketedCancelError\\9_ETicketedStatusFail.png"));
 		 
 		    Assert.assertFalse(false, "FAIL");
 		    Reporter.log("Ticketed status:- FAIL");
 		    System.out.println("Booking ticketed fail..");
 		    driver.findElement(By.xpath("/html/body/div[6]/div[1]/button/span[1]")).click();
 			     
 	     }
      
             System.out.println("Actual status is:- "+ status3);
             Reporter.log("Actual status is:- " + status3);
                   
             final Screenshot screenshot15 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
 	 		 final BufferedImage image15 = screenshot15.getImage();
 	 		 ImageIO.write(image15, "PNG", new File("D:\\Ajit\\Script_SS\\AlanitaETicketedCancel\\9_FlightETicketed.png"));
                    
             Thread.sleep(5000);
             
                       
             //For Cancel booking
             driver.get("https://ui.odysol.com/admin/default.aspx");
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
 	 	  ImageIO.write(image16, "PNG", new File("D:\\Ajit\\Script_SS\\AlanitaETicketedCancel\\10_Cancelbookingpopup.png"));
   	    
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
 		 	 ImageIO.write(image17, "PNG", new File("D:\\Ajit\\Script_SS\\AlanitaETicketedCancelError\\10_CancelbookingFail.png"));
 	               
 	         Assert.assertFalse(false, "FAIL");
 	         Reporter.log("Booking cancel failed...");
 	         AssertJUnit.assertTrue("Booking cancel failed...", hldncnfrm.isDisplayed());
 		     return;
 	         
       }
              Thread.sleep(7000);
              
      // For the verify cancel condition
      try
      {
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
     			 	 ImageIO.write(image18, "PNG", new File("D:\\Ajit\\Script_SS\\AlanitaETicketedCancelError\\11_CancelbookingstatusFail.png"));
     		               
     		         Reporter.log("Actual status is:- " + status2);
     		         Assert.assertFalse(false, "FAIL");
     		         Reporter.log("Cancel status fail..");
     		         AssertJUnit.assertTrue("Cancel Status Fail...", hldncnfrm.isDisplayed());
     			     return;
     	     }
             
                System.out.println("Actual status is:- "+ status2);
                Reporter.log("Actual status is:- " + status2);
              
                final Screenshot screenshot19 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
 			    final BufferedImage image19 = screenshot19.getImage();
 			    ImageIO.write(image19, "PNG", new File("D:\\Ajit\\Script_SS\\AlanitaETicketedCancel\\11_Bookingcancelled.png"));
              
                System.out.println("Booking cancelled successfully..");
              
                Reporter.log("Booking cancelled successfully..");
             
                Thread.sleep(4000);
                
      }
      catch(Exception e)
      {
    	     System.out.println("Time out or displaying error..");
			
             final Screenshot screenshot7 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
   	         final BufferedImage image7 = screenshot7.getImage();
   	         ImageIO.write(image7, "PNG", new File("D:\\Ajit\\Script_SS\\AlanitaETicketedCancel\\18_Timeout.png"));
         
             Assert.assertFalse(false, "FAIL");
             Reporter.log("Time out..");
		     AssertJUnit.assertTrue("Time out or displaying error...", chckout.isDisplayed());
		     return;
     }
  
   }

   @DataProvider
   public String[][] Authentication() throws Exception
   {
	 
	     String[][] testObjArray = OdysolAirUtils.getTableArray("D:\\Ajit\\Automation\\Workspace\\Odysseus_Product\\src\\main\\java\\testData\\OdysolAirData.xlsx","Sheet1");
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
