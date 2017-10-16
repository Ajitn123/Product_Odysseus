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
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
import Utility.LocalAirBookingUtils;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.screentaker.ViewportPastingStrategy;


public class EarlTicketTest 
{
	  
	   AirLocalLoginPgeobjct lgnpge;
	   LocalAirBookingpgeobjectforOdysseus airbk;
	   EarlTicketAirPurchasepgeobjct chckout;
	   LocalCruisePaymentpgeobjct hldncnfrm;
	   public static WebDriver driver;
       Reporter report = new Reporter();
	 
	 public static boolean implicitwait(long time)
	 {
	   try 
	   {
	 	         driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	              System.out.println("Waited for"+30+"sec implicitly.");
	 	
	   }
	   catch (Exception e) 
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
	 		               //  driver = new InternetExplorerDriver();
	 		                   
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
	       driver.get("https://localhost/odyssey/admin/login.aspx");
	       Thread.sleep(4000);
	       
	       //Save console
	       String testResultFile="D:\\Ajit\\Script_SS\\ConsoleError\\Local_EarlTicketError.txt";
	       File file = new File(testResultFile);  
	       FileOutputStream fis = new FileOutputStream(file);  
	       PrintStream out = new PrintStream(fis);  
	       System.setOut(out); 
	                     
	       Thread.sleep(1000);
	       
	       final Screenshot screenshot01 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	       final BufferedImage image01 = screenshot01.getImage();
	       ImageIO.write(image01, "PNG", new File("D:\\Ajit\\Script_SS\\EarlTicket\\1_Loginpage.png"));

	       //driver.navigate().to("https://localhost/odyssey/website/air/results.aspx?");
	       Thread.sleep(4000);
	       lgnpge = PageFactory.initElements(driver, AirLocalLoginPgeobjct.class);
	       airbk = PageFactory.initElements(driver, LocalAirBookingpgeobjectforOdysseus.class);
	       chckout = PageFactory.initElements(driver, EarlTicketAirPurchasepgeobjct.class);
	       hldncnfrm = PageFactory.initElements(driver, LocalCruisePaymentpgeobjct.class);
	       
	  
	  }

	 public void ExtractJSLogs1()
	 {
	     LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
	     
	   for (LogEntry entry : logEntries) 
	   {
	       System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
	   }
	 }
	 

	//For Round Trip (Held Booking)
	 @Test(dataProvider="Authentication")
	 public void HeldBooking_data(String sUsername, String sPassword, String FromLocation, String ToLocation, String Firstname_Of_Adult1, String Middlename_of_Adult1, String Lastname_Of_Adult1, String EmailAddress, String ConfirmEmail, String Phone, String DestinationPhone, String Firstname_Of_Adult2, String Middlename_of_Adult2, String Lastname_Of_Adult2, String Firstname_Of_Adult3, String Middlename_of_Adult3, String Lastname_Of_Adult3, String Email, String Phone_No, String CardHolderName, String CardNo, String CardCvvNo,  String Address, String City, String Zipcode, String Phone_Number, String Bank_Name) throws Exception
	 {
	  try
	  {  
	  	 Reporter.log("Website Name:- Earl");
	  	 Reporter.log("Affiliate Name:- Odysseus Template");
	  	 
	       System.out.println("sUsername: " + sUsername);
	       System.out.println("sPassword: " + sPassword);
	       System.out.println("FromLocation: " + FromLocation);
	       System.out.println("ToLocation: " + ToLocation);
	             
	       lgnpge.LoginToTittle(sUsername, sPassword);
	       
	       System.out.println("\n");
	       System.out.println("Loginpage Logs..");
	       System.out.println("\n");
	       ExtractJSLogs1();
	       
	       airbk.AirBookingToTitle(FromLocation, ToLocation);
	       
	       System.out.println("\n");
	       System.out.println("Searchpage Logs..");
	       System.out.println("\n");
	       ExtractJSLogs1();
	   
	       System.out.println("Page title verified:- User login successfully");
	    }
	    catch(Exception e)
	    {
	   	      System.out.println("\n");
	  	      System.out.println("Login with invalid credentials on Loginpage Logs..");
	  	      System.out.println("\n");
	  	      ExtractJSLogs1();
	   	     
	 	          final Screenshot screenshot1 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	 	          final BufferedImage image1 = screenshot1.getImage();
	 	          ImageIO.write(image1, "PNG", new File("D:\\Ajit\\Script_SS\\EarlTicketError\\1_Invalidcredentials.png"));
	 	          
	   	      Assert.assertFalse(false, "FAIL");
	   	      Reporter.log("Username and Password are invalid..");
	   	      AssertJUnit.assertTrue("Username Or Password are invalid...", lgnpge.isDisplayed());
	   	      AssertJUnit.assertTrue("Flight locations are invalid...", airbk.isDisplayed());
	   	      throw(e);
	   	  
	     }
	    
	         Thread.sleep(12000);
	  
	    // For select dynamic flights from result page
	    for(int i = driver.getWindowHandles().size() -1 ; i > 0 ; i--)
	    {

	        String winHandle = driver.getWindowHandles().toArray()[i].toString();

	        driver.switchTo().window(winHandle);
	       
	        driver.navigate().refresh();
	     
	        driver.get("https://localhost/odyssey/website/air/results.aspx?showtrace=true");

	 	      driver.manage().window().maximize();
	 	     
	 	      System.out.println("\n");
	 	      System.out.println("Resultpage Logs..");
	 	      System.out.println("\n");
	 	      ExtractJSLogs1();
	   
	 	      Thread.sleep(3000);
	 	      
	 	         final Screenshot screenshot003 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	 		     final BufferedImage image003 = screenshot003.getImage();
	 		     ImageIO.write(image003, "PNG", new File("D:\\Ajit\\Script_SS\\EarlTicket\\3_Resultpage.png"));

	 	         Thread.sleep(7000);
	 	    
	 	     try
	 	     {
	 	         if(driver.findElement(By.cssSelector("[id*='flight-summary_'] > div.bonusrow.cf.airlineBotBg [class*='showadd fdetailsshow print-showadd']")).isDisplayed())
	 	         {
	 	        	driver.findElement(By.cssSelector("[id*='flight-summary_'] > div.bonusrow.cf.airlineBotBg [class*='showadd fdetailsshow print-showadd']")).click();
	 	        	Thread.sleep(1000);
	 	        	driver.findElement(By.cssSelector("[id*='flight-summary_'] > div.bonusrow.cf.airlineBotBg [class*='showadd fdetailsshow print-showadd']")).click();
	 	        	Thread.sleep(2000);
	 	         }
	 	     }
	 	     catch(Exception e)
	 	     {
	 	    	 e.getMessage();
	 	     }
	 	   	         
	        List<WebElement> options = driver.findElements(By.className("print-select-flight"));
	        
	     
	        if(options.size()>0)
	        {
	             options.get(2).click();  // 1 for AmadeusWS or 2 for Sabre
	        }
	        else 
	        {
	 			     System.out.println("Flight not available..");
	 			     
	 	             final Screenshot screenshot2 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	 		         final BufferedImage image2 = screenshot2.getImage();
	 		         ImageIO.write(image2, "PNG", new File("D:\\Ajit\\Script_SS\\EarlTicketError\\2_Flightnotavailable.png"));
	 			     
	 	             Assert.assertFalse(false, "FAIL");
	 	             Reporter.log("Flights not available..");
	 		         AssertJUnit.assertTrue("Flight not available...", airbk.isDisplayed());
	 			     return;
	 			     
	 		     }
	        
	           System.out.println("\n");
	           System.out.println("Checkoutpage Logs..");
	           System.out.println("\n");
	           ExtractJSLogs1();
	           
	           Thread.sleep(1000);
	        
	              final Screenshot screenshot3 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	 	          final BufferedImage image3 = screenshot3.getImage();
	 		      ImageIO.write(image3, "PNG", new File("D:\\Ajit\\Script_SS\\EarlTicket\\4_Checkoutpage.png"));
	     
	            System.out.println("Flight selected successfully..");
	 	
	 	
	            Thread.sleep(1000);
	            
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
	            Thread.sleep(3000);
	            
	            // Price on checkout page
	            String priceonpurchase = driver.findElement(By.cssSelector("#PricesGTotal")).getText();
	            Reporter.log("Price on purchase page :- " +priceonpurchase);
	            Thread.sleep(3000);
	            
	            //For click on more flights details
	            try
	            {
	            	if(driver.findElement(By.cssSelector("#flight-summary_0 > div.bonusrow.cf.airlineBotBg > a > span")).isDisplayed())
	            	{
	            		driver.findElement(By.cssSelector("#flight-summary_0 > div.bonusrow.cf.airlineBotBg > a > span")).click();
	            		Thread.sleep(1500);
	            		File scr22 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
          	            org.codehaus.plexus.util.FileUtils.copyFile(scr22, new File("D:\\Ajit\\Script_SS\\EarlTicket\\3_Moreflightsdetails.png")); 
	            		Thread.sleep(2000);
	            		driver.navigate().refresh();
	            		Thread.sleep(4000);
	            	}
	            }
	            catch(Exception e)
	            {
	            	e.getMessage();
	            }
	            
	            
	  try   
	  {
	        //For Checkout page
	  	
	 	    System.out.println("Firstname_Of_Adult1: " + Firstname_Of_Adult1);
	        System.out.println("Middlename_of_Adult1:" + Middlename_of_Adult1);
	        System.out.println("Lastname_Of_Adult1: " + Lastname_Of_Adult1);
	        System.out.println("EmailAddress: " + EmailAddress);
	        System.out.println("ConfirmEmail: " + ConfirmEmail);
	        System.out.println("Phone: " + Phone);
	        System.out.println("DestinationPhone: " + DestinationPhone);
	        System.out.println("Firstname_Of_Adult2: " + Firstname_Of_Adult2);
	        System.out.println("Middlename_of_Adult2:" + Middlename_of_Adult2);
	        System.out.println("Lastname_Of_Adult2: " + Lastname_Of_Adult2);
	        System.out.println("Firstname_Of_Adult3: " + Firstname_Of_Adult3);
	        System.out.println("Middlename_of_Adult3:" + Middlename_of_Adult3);
	        System.out.println("Lastname_Of_Adult3: " + Lastname_Of_Adult3);
	        System.out.println("Email: " + Email);
	        System.out.println("Phone_No: " + Phone_No);
      //    System.out.println("Email: " + CardHolderName);
	  //    System.out.println("Phone_No: " + CardNo);
	  //    System.out.println("Email: " + CardCvvNo);
	  //    System.out.println("Phone_No: " + Address);
	  //    System.out.println("Email: " + City);
	  //    System.out.println("Phone_No: " + Zipcode);
	  //    System.out.println("Email: " + Phone_Number);
	  //    System.out.println("Email: " + Bank_Name);
	          
	        chckout.ConfirmToTitle(Firstname_Of_Adult1, Middlename_of_Adult1, Lastname_Of_Adult1, EmailAddress, ConfirmEmail, Phone, DestinationPhone, Firstname_Of_Adult2, Middlename_of_Adult2, Lastname_Of_Adult2, Firstname_Of_Adult3,Middlename_of_Adult3, Lastname_Of_Adult3, Email, Phone_No, CardHolderName, CardNo, CardCvvNo, Address, City, Zipcode, Phone_Number, Bank_Name);
	        Thread.sleep(1000);
	  }
	  catch(Exception e)
	  {
	 	     System.out.println("\n");
	 	     System.out.println("Timeout on checkoutpage Logs..");
	 	     System.out.println("\n");
	 	     ExtractJSLogs1();
	 	     
	 	     Thread.sleep(1000);
	 	     
	 	     final Screenshot screenshot4 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	 		 final BufferedImage image4 = screenshot4.getImage();
	 		 ImageIO.write(image4, "PNG", new File("D:\\Ajit\\Script_SS\\EarlTicketError\\3_Timeout.png"));
	 	 
	 	     Assert.assertFalse(false, "FAIL");
	 	     Reporter.log("Time out..");
	   	     AssertJUnit.assertTrue("Time out...", chckout.isDisplayed());
	   	     throw(e); 	
	  }


	  
	  try
	  {
	     //Held Booking
	     if(envrnmnt.toLowerCase().trim().equals("test"))
	     {
	         driver.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_HoldLNK']/span")).click();
	         Thread.sleep(25000);
	         
	         System.out.println("\n");
	         System.out.println("Confirmationpage Logs..");
	         System.out.println("\n");
	         ExtractJSLogs1();
	         
	         Thread.sleep(1000);
	         
	         //For the verify held condition
	         String status = driver.findElement(By.cssSelector("#MainForm > div.cruise-detail-box.step-4 > div > div.passenger-info-box.booking-details > div.confirmation-info-1.booking-info-mo > ul > li:nth-child(2)")).getText(); 
	                           
	         if(status.toLowerCase().trim().matches("status : held"))
	         {
	        	   System.out.println("Status Pass..");
	        	   Assert.assertTrue(true, "PASS");
	        	   Reporter.log("Status Pass..");
	         }
	         else
	         {
	        	     System.out.println("Status Fail b'coz status are differ to expected..");
	 				
	 				 System.out.println("Actual status is:- "+ status);
	 				  				
	 	             final Screenshot screenshot11 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	 	             final BufferedImage image11 = screenshot11.getImage();
	 	             ImageIO.write(image11, "PNG", new File("D:\\Ajit\\Script_SS\\EarlTicketError\\4_ConfirmbookingFail.png"));
	 	             
	 	             Reporter.log("Actual status is:-" +status);
	 	             Assert.assertFalse(false, "FAIL");
	 	             Reporter.log("Status Fail b'coz status are differ to expected..");
	 			     AssertJUnit.assertTrue("Status Fail b'coz status are differ to expected...", chckout.isDisplayed());
	 			     return;
	 			 }
	        
	         System.out.println("Actual status is:- "+ status);
	         Reporter.log("Actual status is:- " + status);
	         
	         final Screenshot screenshot12 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	         final BufferedImage image12 = screenshot12.getImage();
	         ImageIO.write(image12, "PNG", new File("D:\\Ajit\\Script_SS\\EarlTicket\\5_FlightHeld.png"));
	         
	         System.out.println("Flight Held successfully..");
	          
	         Reporter.log("Flight Held successfully..");  // For displaying message on report
	          
	         Thread.sleep(9000);
	         
	     }  
	  }
	  catch(Exception e)
	  {
	 	   System.out.println("\n");
	 	   System.out.println("Statusfail on confirmationpage Logs..");
	 	   System.out.println("\n");
	 	   ExtractJSLogs1();
	 	 
	 	   final Screenshot screenshot44 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	       final BufferedImage image44 = screenshot44.getImage();
	       ImageIO.write(image44, "PNG", new File("D:\\Ajit\\Script_SS\\EarlTicketError\\5_Statusfail.png"));
	 	 
	       Assert.assertFalse(false, "FAIL");
	 	   Reporter.log("Time out..");
	       AssertJUnit.assertTrue("Time out...", chckout.isDisplayed());
	       throw(e);
	      
	   }
	     	        
	 }

   }


/*
    //For One Way (Confirm Booking)
    @Test(dataProvider="Authentication")
    public void ConfirmBooking_data(String sUsername, String sPassword, String FromLocation, String ToLocation, String Firstname_Of_Adult1, String Middlename_of_Adult1, String Lastname_Of_Adult1, String EmailAddress, String ConfirmEmail, String Phone, String DestinationPhone, String Firstname_Of_Adult2, String Middlename_of_Adult2, String Lastname_Of_Adult2, String Firstname_Of_Adult3, String Middlename_of_Adult3, String Lastname_Of_Adult3, String Email, String Phone_No, String CardHolderName, String CardNo, String CardCvvNo,  String Address, String City, String Zipcode, String Phone_Number, String Bank_Name) throws Exception
    {
      try
      {  
      	   Reporter.log("Website Name:- Earl");
      	   Reporter.log("Affiliate Name:- Odysseus Template");
      	 
          System.out.println("sUsername: " + sUsername);
          System.out.println("sPassword: " + sPassword);
          System.out.println("FromLocation: " + FromLocation);
          System.out.println("ToLocation: " + ToLocation);
                
          lgnpge.LoginToTittle(sUsername, sPassword);
          
          System.out.println("\n");
          System.out.println("Loginpage Logs..");
          System.out.println("\n");
          ExtractJSLogs();
          
          airbk.OneWayAirBookingToTitle(FromLocation, ToLocation);
          
          System.out.println("\n");
          System.out.println("Searchpage Logs..");
          System.out.println("\n");
          ExtractJSLogs();
       
          System.out.println("Page title verified:- User login successfully");
       }
       catch(Exception e)
       {
      	      System.out.println("\n");
      	      System.out.println("Login with invalid credentials on Loginpage Logs..");
      	      System.out.println("\n");
      	      ExtractJSLogs();
      	     
      	          final Screenshot screenshot1 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
      	          final BufferedImage image1 = screenshot1.getImage();
      	          ImageIO.write(image1, "PNG", new File("D:\\Ajit\\Script_SS\\EarlTicketError\\1_Invalidcredentials.png"));
      	          
      	      Assert.assertFalse(false, "FAIL");
      	      Reporter.log("Username and Password are invalid..");
      	      AssertJUnit.assertTrue("Username Or Password are invalid...", lgnpge.isDisplayed());
      	      AssertJUnit.assertTrue("Flight locations are invalid...", airbk.isDisplayed());
      	      throw(e);
      	  
        }
       
            Thread.sleep(12000);

       // For select dynamic flights from result page
       for(int i = driver.getWindowHandles().size() -1 ; i > 0 ; i--)
       {

           String winHandle = driver.getWindowHandles().toArray()[i].toString();

           driver.switchTo().window(winHandle);
          
           driver.navigate().refresh();
        
           driver.get("https://localhost/odyssey/website/air/results.aspx?showtrace=true");

      	      driver.manage().window().maximize();
      	     
      	      System.out.println("\n");
      	      System.out.println("Resultpage Logs..");
      	      System.out.println("\n");
      	      ExtractJSLogs();

      	      Thread.sleep(3000);
      	      
      	         final Screenshot screenshot003 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
      		     final BufferedImage image003 = screenshot003.getImage();
      		     ImageIO.write(image003, "PNG", new File("D:\\Ajit\\Script_SS\\EarlTicket\\3_Resultpage.png"));

      	         Thread.sleep(7000);
      	     
      	     //For select Flights details    
      	     try
	 	     {
	 	         if(driver.findElement(By.cssSelector("[id*='flight-summary_'] > div.bonusrow.cf.airlineBotBg [class*='showadd fdetailsshow print-showadd']")).isDisplayed())
	 	         {
	 	        	driver.findElement(By.cssSelector("[id*='flight-summary_'] > div.bonusrow.cf.airlineBotBg [class*='showadd fdetailsshow print-showadd']")).click();
	 	        	Thread.sleep(1000);
	 	        	driver.findElement(By.cssSelector("[id*='flight-summary_'] > div.bonusrow.cf.airlineBotBg [class*='showadd fdetailsshow print-showadd']")).click();
	 	        	Thread.sleep(2000);
	 	         }
	 	     }
	 	     catch(Exception e)
	 	     {
	 	    	 e.getMessage();
	 	     }
      	   	         
           List<WebElement> options = driver.findElements(By.className("print-select-flight"));
           
        
           if(options.size()>0)
           {
                options.get(2).click();  // 1 for AmadeusWS or 2 for Sabre
           }
           else 
           {
      			     System.out.println("Flight not available..");
      			     
      	             final Screenshot screenshot2 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
      		         final BufferedImage image2 = screenshot2.getImage();
      		         ImageIO.write(image2, "PNG", new File("D:\\Ajit\\Script_SS\\EarlTicketError\\2_Flightnotavailable.png"));
      			     
      	             Assert.assertFalse(false, "FAIL");
      	             Reporter.log("Flights not available..");
      		         AssertJUnit.assertTrue("Flight not available...", airbk.isDisplayed());
      			     return;
      			     
      		     }
           
              System.out.println("\n");
              System.out.println("Checkoutpage Logs..");
              System.out.println("\n");
              ExtractJSLogs();
              
              Thread.sleep(1000);
           
                  final Screenshot screenshot3 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
      	          final BufferedImage image3 = screenshot3.getImage();
      		      ImageIO.write(image3, "PNG", new File("D:\\Ajit\\Script_SS\\EarlTicket\\4_Checkoutpage.png"));
        
               System.out.println("Flight selected successfully..");
      	
      	
               Thread.sleep(2000);
               
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
               Thread.sleep(3000);
               
             //For click on more flights details
	            try
	            {
	            	if(driver.findElement(By.cssSelector("#flight-summary_0 > div.bonusrow.cf.airlineBotBg > a > span")).isDisplayed())
	            	{
	            		driver.findElement(By.cssSelector("#flight-summary_0 > div.bonusrow.cf.airlineBotBg > a > span")).click();
	            		Thread.sleep(1500);
	            		File scr22 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
         	            org.codehaus.plexus.util.FileUtils.copyFile(scr22, new File("D:\\Ajit\\Script_SS\\EarlTicket\\3_Moreflightsdetails.png")); 
	            		Thread.sleep(2000);
	            		driver.navigate().refresh();
	            		Thread.sleep(4000);
	            	}
	            }
	            catch(Exception e)
	            {
	            	e.getMessage();
	            }
               
               // Price on checkout page
               String priceonpurchase = driver.findElement(By.cssSelector("#PricesGTotal")).getText();
               Reporter.log("Price on purchase page :- " +priceonpurchase);
               Thread.sleep(3000);
               
               
      try   
      {
           //For Checkout page
      	
      	   System.out.println("Firstname_Of_Adult1: " + Firstname_Of_Adult1);
           System.out.println("Middlename_of_Adult1:" + Middlename_of_Adult1);
           System.out.println("Lastname_Of_Adult1: " + Lastname_Of_Adult1);
           System.out.println("EmailAddress: " + EmailAddress);
           System.out.println("ConfirmEmail: " + ConfirmEmail);
           System.out.println("Phone: " + Phone);
           System.out.println("DestinationPhone: " + DestinationPhone);
           System.out.println("Firstname_Of_Adult2: " + Firstname_Of_Adult2);
           System.out.println("Middlename_of_Adult2:" + Middlename_of_Adult2);
           System.out.println("Lastname_Of_Adult2: " + Lastname_Of_Adult2);
           System.out.println("Firstname_Of_Adult3: " + Firstname_Of_Adult3);
           System.out.println("Middlename_of_Adult3:" + Middlename_of_Adult3);
           System.out.println("Lastname_Of_Adult3: " + Lastname_Of_Adult3);
           System.out.println("Email: " + Email);
           System.out.println("Phone_No: " + Phone_No);
     //    System.out.println("Email: " + CardHolderName);
     //    System.out.println("Phone_No: " + CardNo);
     //    System.out.println("Email: " + CardCvvNo);
     //    System.out.println("Phone_No: " + Address);
     //    System.out.println("Email: " + City);
     //    System.out.println("Phone_No: " + Zipcode);
     //    System.out.println("Email: " + Phone_Number);
     //    System.out.println("Email: " + Bank_Name);
          
             
           chckout.ConfirmToTitle(Firstname_Of_Adult1, Middlename_of_Adult1, Lastname_Of_Adult1, EmailAddress, ConfirmEmail, Phone, DestinationPhone, Firstname_Of_Adult2, Middlename_of_Adult2, Lastname_Of_Adult2, Firstname_Of_Adult3,Middlename_of_Adult3, Lastname_Of_Adult3, Email, Phone_No, CardHolderName, CardNo, CardCvvNo, Address, City, Zipcode, Phone_Number, Bank_Name);
           Thread.sleep(1000);
      }
      catch(Exception e)
      {
      	     System.out.println("\n");
      	     System.out.println("Timeout on checkoutpage Logs..");
      	     System.out.println("\n");
      	     ExtractJSLogs();
      	     
      	     Thread.sleep(1000);
      	     
      	     final Screenshot screenshot4 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
      		 final BufferedImage image4 = screenshot4.getImage();
      		 ImageIO.write(image4, "PNG", new File("D:\\Ajit\\Script_SS\\EarlTicketError\\3_Timeout.png"));
      	 
      	     Assert.assertFalse(false, "FAIL");
      	     Reporter.log("Time out..");
      	     AssertJUnit.assertTrue("Time out...", chckout.isDisplayed());
      	     throw(e); 	
      }



      try
      {
        //For Continue Booking
        if(envrnmnt.toLowerCase().trim().equals("test"))
        {
            driver.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_ContinueLNK]")).click();
            Thread.sleep(8000);
            
            System.out.println("\n");
            System.out.println("Confirmationpage Logs..");
            System.out.println("\n");
            ExtractJSLogs();
            
            Thread.sleep(1000);
         }  
      }
      catch(Exception e)
      {
      	   System.out.println("\n");
      	   System.out.println("continue button not working on confirmationpage Logs..");
      	   System.out.println("\n");
      	   ExtractJSLogs();
      	 
      	  final Screenshot screenshot44 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
          final BufferedImage image44 = screenshot44.getImage();
          ImageIO.write(image44, "PNG", new File("D:\\Ajit\\Script_SS\\LocalAirBookingError\\5_Statusfail.png"));
      	 
          Assert.assertFalse(false, "FAIL");
      	  Reporter.log("Continue button  not clickable on purchase page..");
          AssertJUnit.assertTrue("Continue button  not clickable on purchase page...", chckout.isDisplayed());
          throw(e);
         
      }

       
        try
        {
        	
            final Screenshot screenshot74 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
            final BufferedImage image74 = screenshot74.getImage();
            ImageIO.write(image74, "PNG", new File("D:\\Ajit\\Script_SS\\LocalAirBooking\\6_Paymentpage.png"));
            Thread.sleep(4000);
        	
        // For Payment details
            String priceonpaymnt = driver.findElement(By.cssSelector("#PricesGTotal")).getText();
            Reporter.log("Price on paymentpage is:- "+ priceonpaymnt);
                            
              if(priceonpaymnt.equals(priceonpurchase))
              {
                           	
                     System.out.println("Purchase and Payment page's Price matched");
                     Reporter.log("Purchase and Payment page's Price matched..");
                           	 
                           System.out.println("Actual price is:- " +priceonpurchase);
      						 Reporter.log("Actual price is:- " +priceonpurchase);
               }
               else
               {
      						  System.out.println("Purchase and Payment page's Price not match..");
      						  Reporter.log("Purchase and Payment page's Price not match..");
      						  System.out.println("Actual price is:- " +priceonpurchase);
      						  Reporter.log("Actual price is:- " +priceonpurchase);
      				   }
      						
      							 Thread.sleep(9000);	
      							 
        }
        catch(Exception e)
        {
        	  final Screenshot screenshot94 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
              final BufferedImage image94 = screenshot94.getImage();
              ImageIO.write(image94, "PNG", new File("D:\\Ajit\\Script_SS\\LocalAirBookingError\\6_Paymentdetails.png"));

              Assert.assertFalse(false, "FAIL");
              Reporter.log("Something went wrong...");
              AssertJUnit.assertTrue("Something went wrong...", chckout.isDisplayed());
              throw(e);
        }	
       
        
        
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
            System.out.println("BankName: " + Bank_Name);
           
            hldncnfrm.PaymentToTitle(CardNo, CardCvvNo, CardHolderName, Address, City, Zipcode, Phone_Number, Bank_Name);
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
                
             // For the verify confirm condition
                String status1 = driver.findElement(By.cssSelector("#MainForm > div.cruise-detail-box.step-4 > div > div.passenger-info-box.booking-details > div.confirmation-info-1.booking-info-mo > ul > li:nth-child(2)")).getText(); 
                                  
                if(status1.toLowerCase().trim().matches("status : confirmed"))
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
       				 ImageIO.write(image9, "PNG", new File("D:\\Ajit\\Script_SS\\LocalAirBooking\\7_ConfirmbookingFail.png"));
       		               
       		         Reporter.log("Actual status is:-" +status1);
       		         Assert.assertFalse(false, "FAIL");
       		         Reporter.log("Status Fail b'coz status are differ to expected..");
       		         AssertJUnit.assertTrue("Status Fail b'coz status are differ to expected...", chckout.isDisplayed());
       			     return;
       	        }
               
                  System.out.println("Actual status is:- "+ status1);
                  Reporter.log("Actual status is:- " + status1);
                
                  final Screenshot screenshot76 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                  final BufferedImage image76 = screenshot76.getImage();
                  ImageIO.write(image76, "PNG", new File("D:\\Ajit\\Script_SS\\LocalAirBooking\\8_ConfirmBooking.png"));
                  Thread.sleep(4000);
                
                  System.out.println("Flight confirmed successfully..");
                
                  Reporter.log("Flight confirmed successfully..");  // For displaying message on report
                  
                  long start79 = System.currentTimeMillis();  
                  Thread.sleep(10000);
                  long finish1119 = System.currentTimeMillis();
                  long totalTime1119 = finish1119 - start79; 
                  Reporter.log("Total Time for Confirm booking page to Admin default page load(Milisec) - "+totalTime1119); 
                  Thread.sleep(2000);
                	 
      }     							 
      catch (Exception e) 
      {
          final Screenshot screenshot94 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
          final BufferedImage image94 = screenshot94.getImage();
          ImageIO.write(image94, "PNG", new File("D:\\Ajit\\Script_SS\\LocalAirBookingError\\7_Paymentpage.png"));

          Assert.assertFalse(false, "FAIL");
          Reporter.log("Something went wrong...");
          AssertJUnit.assertTrue("Something went wrong...", chckout.isDisplayed());
          throw(e);
      }   

     }
   }

*/

/*     
    //For Multicity (Held + Confirmed + Cancel)
     @Test(dataProvider="Authentication")
     public void ConfirmCancelBooking_data(String sUsername, String sPassword, String FromLocation, String ToLocation, String Firstname_Of_Adult1, String Middlename_of_Adult1, String Lastname_Of_Adult1, String EmailAddress, String ConfirmEmail, String Phone, String DestinationPhone, String Firstname_Of_Adult2, String Middlename_of_Adult2, String Lastname_Of_Adult2, String Firstname_Of_Adult3, String Middlename_of_Adult3, String Lastname_Of_Adult3, String Email, String Phone_No, String CardHolderName, String CardNo, String CardCvvNo,  String Address, String City, String Zipcode, String Phone_Number, String Bank_Name) throws Exception
     {
       try
       {  
       	   Reporter.log("Website Name:- Earl");
       	   Reporter.log("Affiliate Name:- Odysseus Template");
       	 
           System.out.println("sUsername: " + sUsername);
           System.out.println("sPassword: " + sPassword);
           System.out.println("FromLocation: " + FromLocation);
           System.out.println("ToLocation: " + ToLocation);
                 
           lgnpge.LoginToTittle(sUsername, sPassword);
           
           System.out.println("\n");
           System.out.println("Loginpage Logs..");
           System.out.println("\n");
           ExtractJSLogs();
           
           airbk.MulticityAirBookingToTitle(FromLocation, ToLocation);
           
           System.out.println("\n");
           System.out.println("Searchpage Logs..");
           System.out.println("\n");
           ExtractJSLogs();
        
           System.out.println("Page title verified:- User login successfully");
        }
        catch(Exception e)
        {
       	      System.out.println("\n");
       	      System.out.println("Login with invalid credentials on Loginpage Logs..");
       	      System.out.println("\n");
       	      ExtractJSLogs();
       	     
       	          final Screenshot screenshot1 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
       	          final BufferedImage image1 = screenshot1.getImage();
       	          ImageIO.write(image1, "PNG", new File("D:\\Ajit\\Script_SS\\EarlTicketError\\1_Invalidcredentials.png"));
       	          
       	      Assert.assertFalse(false, "FAIL");
       	      Reporter.log("Username and Password are invalid..");
       	      AssertJUnit.assertTrue("Username Or Password are invalid...", lgnpge.isDisplayed());
       	      AssertJUnit.assertTrue("Flight locations are invalid...", airbk.isDisplayed());
       	      throw(e);
       	  
         }
        
             Thread.sleep(12000);

        // For select dynamic flights from result page
        for(int i = driver.getWindowHandles().size() -1 ; i > 0 ; i--)
        {

            String winHandle = driver.getWindowHandles().toArray()[i].toString();

            driver.switchTo().window(winHandle);
           
            driver.navigate().refresh();
         
            driver.get("https://localhost/odyssey/website/air/results.aspx?showtrace=true");

       	      driver.manage().window().maximize();
       	     
       	      System.out.println("\n");
       	      System.out.println("Resultpage Logs..");
       	      System.out.println("\n");
       	      ExtractJSLogs();

       	      Thread.sleep(3000);
       	      
       	         final Screenshot screenshot003 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
       		     final BufferedImage image003 = screenshot003.getImage();
       		     ImageIO.write(image003, "PNG", new File("D:\\Ajit\\Script_SS\\EarlTicket\\3_Resultpage.png"));

       	         Thread.sleep(7000);
       	         
       	     try
	 	     {
	 	         if(driver.findElement(By.cssSelector("[id*='flight-summary_'] > div.bonusrow.cf.airlineBotBg [class*='showadd fdetailsshow print-showadd']")).isDisplayed())
	 	         {
	 	        	driver.findElement(By.cssSelector("[id*='flight-summary_'] > div.bonusrow.cf.airlineBotBg [class*='showadd fdetailsshow print-showadd']")).click();
	 	        	Thread.sleep(1000);
	 	        	driver.findElement(By.cssSelector("[id*='flight-summary_'] > div.bonusrow.cf.airlineBotBg [class*='showadd fdetailsshow print-showadd']")).click();
	 	        	Thread.sleep(2000);
	 	         }
	 	     }
	 	     catch(Exception e)
	 	     {
	 	    	 e.getMessage();
	 	     }
       	   	         
            List<WebElement> options = driver.findElements(By.className("print-select-flight"));
            
         
            if(options.size()>0)
            {
                 options.get(2).click();  // 1 for AmadeusWS or 2 for Sabre
              //   Alert alert=driver.switchTo().alert();
              //   alert.accept();
            }
            else 
            {
       			     System.out.println("Flight not available..");
       			     
       	             final Screenshot screenshot2 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
       		         final BufferedImage image2 = screenshot2.getImage();
       		         ImageIO.write(image2, "PNG", new File("D:\\Ajit\\Script_SS\\EarlTicketError\\2_Flightnotavailable.png"));
       			     
       	             Assert.assertFalse(false, "FAIL");
       	             Reporter.log("Flights not available..");
       		         AssertJUnit.assertTrue("Flight not available...", airbk.isDisplayed());
       			     return;
       			     
       		  }
            
               System.out.println("\n");
               System.out.println("Checkoutpage Logs..");
               System.out.println("\n");
               ExtractJSLogs();
               
               Thread.sleep(4000);
            
                  final Screenshot screenshot3 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
       	          final BufferedImage image3 = screenshot3.getImage();
       		      ImageIO.write(image3, "PNG", new File("D:\\Ajit\\Script_SS\\EarlTicket\\4_Checkoutpage.png"));
         
                System.out.println("Flight selected successfully..");
       	
       	
                Thread.sleep(2000);
                
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
                Thread.sleep(3000);
                
                // Price on checkout page
                String priceonpurchase = driver.findElement(By.cssSelector("#PricesGTotal")).getText();
                Reporter.log("Price on purchase page :- " +priceonpurchase);
                Thread.sleep(3000);
                
                
       try   
       {
            //For Checkout page
       	
       	    System.out.println("Firstname_Of_Adult1: " + Firstname_Of_Adult1);
            System.out.println("Middlename_of_Adult1:" + Middlename_of_Adult1);
            System.out.println("Lastname_Of_Adult1: " + Lastname_Of_Adult1);
            System.out.println("EmailAddress: " + EmailAddress);
            System.out.println("ConfirmEmail: " + ConfirmEmail);
            System.out.println("Phone: " + Phone);
            System.out.println("DestinationPhone: " + DestinationPhone);
            System.out.println("Firstname_Of_Adult2: " + Firstname_Of_Adult2);
            System.out.println("Middlename_of_Adult2:" + Middlename_of_Adult2);
            System.out.println("Lastname_Of_Adult2: " + Lastname_Of_Adult2);
            System.out.println("Firstname_Of_Adult3: " + Firstname_Of_Adult3);
            System.out.println("Middlename_of_Adult3:" + Middlename_of_Adult3);
            System.out.println("Lastname_Of_Adult3: " + Lastname_Of_Adult3);
            System.out.println("Email: " + Email);
            System.out.println("Phone_No: " + Phone_No);
      //    System.out.println("Email: " + CardHolderName);
      //    System.out.println("Phone_No: " + CardNo);
      //    System.out.println("Email: " + CardCvvNo);
      //    System.out.println("Phone_No: " + Address);
      //    System.out.println("Email: " + City);
      //    System.out.println("Phone_No: " + Zipcode);
      //    System.out.println("Email: " + Phone_Number);
      //    System.out.println("Email: " + Bank_Name);
           
              
            chckout.MulticityConfirmToTitle(Firstname_Of_Adult1, Middlename_of_Adult1, Lastname_Of_Adult1, EmailAddress, ConfirmEmail, Phone, DestinationPhone, Firstname_Of_Adult2, Middlename_of_Adult2, Lastname_Of_Adult2, Firstname_Of_Adult3,Middlename_of_Adult3, Lastname_Of_Adult3, Email, Phone_No, CardHolderName, CardNo, CardCvvNo, Address, City, Zipcode, Phone_Number, Bank_Name);
            Thread.sleep(1000);
       }
       catch(Exception e)
       {
       	     System.out.println("\n");
       	     System.out.println("Timeout on checkoutpage Logs..");
       	     System.out.println("\n");
       	     ExtractJSLogs();
       	     
       	     Thread.sleep(1000);
       	     
       	     final Screenshot screenshot4 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
       		 final BufferedImage image4 = screenshot4.getImage();
       		 ImageIO.write(image4, "PNG", new File("D:\\Ajit\\Script_SS\\EarlTicketError\\3_Timeout.png"));
       	 
       	     Assert.assertFalse(false, "FAIL");
       	     Reporter.log("Time out..");
       	     AssertJUnit.assertTrue("Time out...", chckout.isDisplayed());
       	     throw(e); 	
       }



       try
       {
         //Held Booking
         if(envrnmnt.toLowerCase().trim().equals("test"))
         {
             driver.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_HoldLNK']/span")).click();
             Thread.sleep(25000);
             
             System.out.println("\n");
             System.out.println("Confirmationpage Logs..");
             System.out.println("\n");
             ExtractJSLogs();
             
             Thread.sleep(1000);
             
             //For the verify held condition
             String status = driver.findElement(By.cssSelector("#MainForm > div.cruise-detail-box.step-4 > div > div.passenger-info-box.booking-details > div.confirmation-info-1.booking-info-mo > ul > li:nth-child(2)")).getText(); 
                               
             if(status.toLowerCase().trim().matches("status : held"))
             {
            	   System.out.println("Status Pass..");
            	   Assert.assertTrue(true, "PASS");
            	   Reporter.log("Status Pass..");
             }
             else
             {
            	     System.out.println("Status Fail b'coz status are differ to expected..");
       				
       				 System.out.println("Actual status is:- "+ status);
       				  				
       	             final Screenshot screenshot11 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
       	             final BufferedImage image11 = screenshot11.getImage();
       	             ImageIO.write(image11, "PNG", new File("D:\\Ajit\\Script_SS\\LocalAirBookingError\\4_ConfirmbookingFail.png"));
       	             
       	             Reporter.log("Actual status is:-" +status);
       	             Assert.assertFalse(false, "FAIL");
       	             Reporter.log("Status Fail b'coz status are differ to expected..");
       			     AssertJUnit.assertTrue("Status Fail b'coz status are differ to expected...", chckout.isDisplayed());
       			     return;
       			 }
            
             System.out.println("Actual status is:- "+ status);
             Reporter.log("Actual status is:- " + status);
             
             final Screenshot screenshot12 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
             final BufferedImage image12 = screenshot12.getImage();
             ImageIO.write(image12, "PNG", new File("D:\\Ajit\\Script_SS\\LocalAirBooking\\5_FlightHeld.png"));
             
             System.out.println("Flight Held successfully..");
              
             Reporter.log("Flight Held successfully..");  // For displaying message on report
              
             Thread.sleep(9000);
             
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
           ImageIO.write(image44, "PNG", new File("D:\\Ajit\\Script_SS\\LocalAirBookingError\\5_Statusfail.png"));
       	 
           Assert.assertFalse(false, "FAIL");
       	    Reporter.log("Time out..");
           AssertJUnit.assertTrue("Time out...", chckout.isDisplayed());
           throw(e);
          
       }

        
         try
         {
         	
         	// Click on Full payment 
         	driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_ConfirmBkgBTN")).click();
         	long start77 = System.currentTimeMillis();  
         	Thread.sleep(8000);
         	
         	 long finish1114 = System.currentTimeMillis();
             long totalTime1114 = finish1114 - start77; 
             Reporter.log("Total Time for Held booking page to Payment page load(Milisec) - "+totalTime1114); 
             Thread.sleep(1000);
             
             System.out.println("\n");
             System.out.println("Payment page Logs..");
             System.out.println("\n");
             ExtractJSLogs();              
             Thread.sleep(1000);
            
             final Screenshot screenshot74 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
             final BufferedImage image74 = screenshot74.getImage();
             ImageIO.write(image74, "PNG", new File("D:\\Ajit\\Script_SS\\LocalAirBooking\\6_Paymentpage.png"));
             Thread.sleep(5000);
         	
         	// For Payment details
         	
             String priceonpaymnt = driver.findElement(By.cssSelector("#PricesGTotal")).getText();
             Reporter.log("Price on paymentpage is:- "+ priceonpaymnt);
                             
               if(priceonpaymnt.equals(priceonpurchase))
               {
                            	
                      System.out.println("Purchase and Payment page's Price matched");
                      Reporter.log("Purchase and Payment page's Price matched..");
                            	 
                            System.out.println("Actual price is:- " +priceonpurchase);
       						 Reporter.log("Actual price is:- " +priceonpurchase);
                }
                else
                {
       						  System.out.println("Purchase and Payment page's Price not match..");
       						  Reporter.log("Purchase and Payment page's Price not match..");
       						  System.out.println("Actual price is:- " +priceonpurchase);
       						  Reporter.log("Actual price is:- " +priceonpurchase);
       				   }
       						
       							 Thread.sleep(9000);	
       							 
         }
         catch(Exception e)
         {
         	 final Screenshot screenshot94 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
             final BufferedImage image94 = screenshot94.getImage();
             ImageIO.write(image94, "PNG", new File("D:\\Ajit\\Script_SS\\LocalAirBookingError\\6_Paymentdetails.png"));

               Assert.assertFalse(false, "FAIL");
               Reporter.log("Something went wrong Purchase or payment page...");
               AssertJUnit.assertTrue("Something went wrong on Purchase or payment page...", chckout.isDisplayed());
               throw(e);
         }	
        
         
         
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
             System.out.println("BankName: " + Bank_Name);
            
             hldncnfrm.MulticityPaymentToTitle(CardHolderName, CardNo, CardCvvNo, Address, City, Zipcode, Phone_Number, Bank_Name);
             long start78 = System.currentTimeMillis();  
                 
             Thread.sleep(18000);
                 
                 long finish1117 = System.currentTimeMillis();
                 long totalTime1117 = finish1117 - start78; 
                 Reporter.log("Total Time for Payment page to Confirm booking page load(Milisec) - "+totalTime1117); 
                 Thread.sleep(1000);
                 
                 System.out.println("\n");
                 System.out.println("Confirm booking page Logs..");
                 System.out.println("\n");
                 ExtractJSLogs1();              
                 Thread.sleep(1000);
                 
              // For the verify confirm condition
                 String status1 = driver.findElement(By.cssSelector("#MainForm > div.cruise-detail-box.step-4 > div > div.passenger-info-box.booking-details > div.confirmation-info-1.booking-info-mo > ul > li:nth-child(2)")).getText(); 
                                   
                 if(status1.toLowerCase().trim().matches("status : confirmed"))
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
        				 ImageIO.write(image9, "PNG", new File("D:\\Ajit\\Script_SS\\LocalAirBooking\\7_ConfirmbookingFail.png"));
        		               
        		         Reporter.log("Actual status is:-" +status1);
        		         Assert.assertFalse(false, "FAIL");
        		         Reporter.log("Status Fail b'coz status are differ to expected..");
        		         AssertJUnit.assertTrue("Status Fail b'coz status are differ to expected...", chckout.isDisplayed());
        			     return;
        	        }
                
                   System.out.println("Actual status is:- "+ status1);
                   Reporter.log("Actual status is:- " + status1);
                 
                   final Screenshot screenshot76 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                   final BufferedImage image76 = screenshot76.getImage();
                   ImageIO.write(image76, "PNG", new File("D:\\Ajit\\Script_SS\\LocalAirBooking\\8_ConfirmBooking.png"));
                   Thread.sleep(4000);
                 
                   System.out.println("Flight confirmed successfully..");
                 
                   Reporter.log("Flight confirmed successfully..");  // For displaying message on report
                   
                   long start79 = System.currentTimeMillis();  
                   Thread.sleep(10000);
                   long finish1119 = System.currentTimeMillis();
                   long totalTime1119 = finish1119 - start79; 
                   Reporter.log("Total Time for Confirm booking page to Admin default page load(Milisec) - "+totalTime1119); 
                   Thread.sleep(2000);
                 	 
       }     							 
       catch (Exception e) 
       {
           final Screenshot screenshot94 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
           final BufferedImage image94 = screenshot94.getImage();
           ImageIO.write(image94, "PNG", new File("D:\\Ajit\\Script_SS\\LocalAirBookingError\\7_Paymentpage.png"));

           Assert.assertFalse(false, "FAIL");
           Reporter.log("Something went wrong...");
           AssertJUnit.assertTrue("Something went wrong...", chckout.isDisplayed());
           throw(e);
       }   
      
       //For Insurance modify
       try
       {
    	   if(driver.findElement(By.cssSelector("#travel-insurance > div > div.insurance-button.btn-container > a")).isDisplayed())
    	   {
    		   driver.findElement(By.cssSelector("#travel-insurance > div > div.insurance-button.btn-container > a")).click();
    		   driver.findElement(By.id("InsurranceCHK_167022")).click();
    		   Thread.sleep(8000);
     	   }
    	   
    	   if(driver.findElement(By.cssSelector("#travel-insurance > div > p.insurance-travelguard-name > strong > label")).isDisplayed())
    	   {
    		   String insu = driver.findElement(By.cssSelector("#travel-insurance > div > p.insurance-travelguard-name > strong > label")).getText();
    		   Reporter.log("Insurance details:- " +insu);
    		   Thread.sleep(1000);
    	   }
    	   
       }
       catch(Exception e)
       {
    	   e.getMessage();
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
       	      ImageIO.write(image11, "PNG", new File("D:\\Ajit\\Script_SS\\LocalAirBooking\\9_Admindefaultpage.png"));

       Thread.sleep(7000);

       try
       {
           //Click on Manage
            driver.findElement(By.className("manage_btn")).click();
            Thread.sleep(2000);
       }
       catch(Exception e)
       {
       	e.getMessage();
       }
         try
         {
            //Agent Details
            driver.findElement(By.cssSelector("[id*='trans_old_'] > td > div > div [class*='agent_icon show_True']")).click();
            Thread.sleep(5000); 
            
            System.out.println("\n");
            System.out.println("Agent details on admin defaultpage Logs..");
            System.out.println("\n");
            ExtractJSLogs1();
            
            Thread.sleep(3000);
            driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
            
            //For middle name update
            WebElement elm = driver.findElement(By.name("PaxMiddleName"));
            elm.clear();
            Thread.sleep(200); 
            elm.click();
            Thread.sleep(900); 
            elm.sendKeys("N");
            Thread.sleep(800); 
           
            WebElement elmt = driver.findElement(By.id("_ctl0_MainContent_BookingEditUC_SubmitBTN"));
            elmt.click();
            Thread.sleep(5000);
         
            driver.navigate().refresh();
            
            Thread.sleep(3000);
          
            driver.switchTo().defaultContent();
            
            Thread.sleep(1000);
            System.out.println("\n");
            System.out.println("Agent details updated on admin defaultpage Logs..");
            System.out.println("\n");
            ExtractJSLogs1();
            
            Reporter.log("Agent details updated..");
            
            Thread.sleep(2000);
                 
         }
         catch(Exception e)
         {
       	     e.getMessage();
       	     final Screenshot screenshot1 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
             final BufferedImage image1 = screenshot1.getImage();
             ImageIO.write(image1, "PNG", new File("D:\\Ajit\\Script_SS\\AdminManageError\\2_AgentdetailsNotUpdated.png"));
             Thread.sleep(1000);
             
             Assert.assertFalse(false, "FAIL");
             Reporter.log("Agent details not updated..");
          //   AssertJUnit.assertTrue("Agent details not updated...", lgnpge.isDisplayed());
          //   throw(e);
         }
            
             driver.findElement(By.className("manage_btn")).click();
             Thread.sleep(2000);

         try
         {
             // For History
       	     driver.findElement(By.className("history_icon")).click();
       	     Thread.sleep(5000);
       	  
       	     driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
 
       	     Reporter.log("Booking History View..");
       	     
       	     driver.navigate().refresh();
       	     
       	     Thread.sleep(3000);
       	   
       	     driver.switchTo().defaultContent();
       	     
       	     Thread.sleep(1000);
       	     System.out.println("\n");
       	     System.out.println("Booking History updated on admin defaultpage Logs..");
       	     System.out.println("\n");
       	     ExtractJSLogs1();
       	     
       	     Thread.sleep(2000);
       	    	   
         }
         catch(Exception e)
         {
       	  e.getMessage();
       	  
       	     final Screenshot screenshot1 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
       	     final BufferedImage image1 = screenshot1.getImage();
       	     ImageIO.write(image1, "PNG", new File("D:\\Ajit\\Script_SS\\AdminManageError\\3_BookingHistory.png"));
       	     Thread.sleep(2000);
       	     
       	     Assert.assertFalse(false, "FAIL");
       	     Reporter.log("History not View..");
         }
         
                driver.findElement(By.className("manage_btn")).click();
                Thread.sleep(2000);
         
          try
          {
       	    
       	 // For Payment Details
       	     driver.findElement(By.cssSelector("[id*='trans_old_'] > td > div > div [class*='paydetail_icon show_True']")).click();
       	     Thread.sleep(5000);
       	  
       	     driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
        	     
       	    
       	     // For the Destroy CC
      // 	     driver.findElement(By.id("_ctl0_MainContent_MultiplePaymentRPT__ctl1_DestroyTPCCBTN")).click();
      // 	     Thread.sleep(4000);
       	   
       	     Reporter.log("Payment details view..");
       	     
       	     driver.navigate().refresh();
       	     
       	     Thread.sleep(3000);
       	   
       	     driver.switchTo().defaultContent();
       	     
       	     Thread.sleep(2000);
       	     System.out.println("\n");
       	     System.out.println("Payment details view on admin defaultpage Logs..");
       	     System.out.println("\n");
       	     ExtractJSLogs1();
       	     
       	     Thread.sleep(2000);
       	     	   
          }
          catch(Exception e)
          {
       	   e.getMessage();
       	   
       	   final Screenshot screenshot1 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
       	   final BufferedImage image1 = screenshot1.getImage();
       	   ImageIO.write(image1, "PNG", new File("D:\\Ajit\\Script_SS\\AdminManageError\\4_PaymentDetails.png"));
       	   Thread.sleep(1000);
       	     
       	   Assert.assertFalse(false, "FAIL");
       	   Reporter.log("Payment details not view..");
       	   
          }

          
              driver.findElement(By.className("manage_btn")).click();
              Thread.sleep(1000);

        try
        {
         
        // For Cross Check w/Supplier
           driver.findElement(By.cssSelector("[id*='trans_old_'] > td > div > div [class*='crosscheck_icon show_True']")).click();
           Thread.sleep(5000); 

           driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
         
           Reporter.log("Cross check details view..");
          
           driver.navigate().refresh();
          
           Thread.sleep(4000);
        
           driver.switchTo().defaultContent();
          
           Thread.sleep(2000);
           System.out.println("\n");
           System.out.println("Cross check view on admin defaultpage Logs..");
           System.out.println("\n");
           ExtractJSLogs1();
          
           Thread.sleep(2000);
           
        }
        catch(Exception e)
        {
           e.getMessage();
        
           final Screenshot screenshot1 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
           final BufferedImage image1 = screenshot1.getImage();
           ImageIO.write(image1, "PNG", new File("D:\\Ajit\\Script_SS\\AdminManageError\\5_CrosscheckFail.png"));
           Thread.sleep(2000);
          
           Assert.assertFalse(false, "FAIL");
           Reporter.log("Cross check not view..");
        
        }
        
           driver.findElement(By.className("manage_btn")).click();
           Thread.sleep(2000);

        try
        {
           // For Send email
      	     driver.findElement(By.cssSelector("[id*='trans_old_'] > td > div > div [class*='sendemail_icon']")).click();
      	     Thread.sleep(5000);
      	  
      	     driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
        	     
      	     
      	    // For Send email
      //	     driver.findElement(By.id("_ctl0_MainContent_SendBTN")).click();
        
      	     Reporter.log("Send email pop up View..");
      	     
      	     driver.navigate().refresh();
      	     
      	     Thread.sleep(4000);
      	   
      	     driver.switchTo().defaultContent();
      	     
      	     Thread.sleep(1000);
      	     System.out.println("\n");
      	     System.out.println("Send email pop up view on admin defaultpage Logs..");
      	     System.out.println("\n");
      	     ExtractJSLogs1();
      	     
      	     Thread.sleep(2000);
      	     	   
        }
        catch(Exception e)
        {
      	     e.getMessage();
      	  
      	     final Screenshot screenshot1 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
      	     final BufferedImage image1 = screenshot1.getImage();
      	     ImageIO.write(image1, "PNG", new File("D:\\Ajit\\Script_SS\\AdminManageError\\6_SendEmailFail.png"));
      	     Thread.sleep(2000);
      	     
      	     Assert.assertFalse(false, "FAIL");
      	     Reporter.log("Send email pop up not view..");
        }
        
            driver.findElement(By.className("manage_btn")).click();
            Thread.sleep(2000);

       try
       {
          // For Rules
      	     driver.findElement(By.cssSelector("[id*='trans_old_'] > td > div > div [class*='promo_icon']")).click();
      	     Thread.sleep(5000);
      	  
      	     driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
       	    
        	     	    
      	    // For Applicable Rules
      	     driver.findElement(By.cssSelector("#tabs > ul > li:nth-child(2) [class*='ui-tabs-anchor']")).click();
      	     Thread.sleep(1500);
      	     
      	     File scr23 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
      	     org.codehaus.plexus.util.FileUtils.copyFile(scr23, new File("D:\\Ajit\\Script_SS\\AdminManage\\11_ApplicableRules.png")); 
      	     Thread.sleep(2000);
        
      	     Reporter.log("Rules pop up View for the Selected Rules and Applicable Rules...");
      	     
      	     driver.navigate().refresh();
      	     
      	     Thread.sleep(4000);
      	   
      	     driver.switchTo().defaultContent();
      	     
      	     Thread.sleep(1000);
      	     System.out.println("\n");
      	     System.out.println("Rules pop up view on admin defaultpage Logs..");
      	     System.out.println("\n");
      	     ExtractJSLogs1();
      	     
      	     Thread.sleep(2000);
      	     
      	   
       }
       catch(Exception e)
       {
      	     e.getMessage();
      	  
      	     final Screenshot screenshot1 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
      	     final BufferedImage image1 = screenshot1.getImage();
      	     ImageIO.write(image1, "PNG", new File("D:\\Ajit\\Script_SS\\AdminManageError\\7_RulesFail.png"));
      	     Thread.sleep(2000);
      	     
      	     Assert.assertFalse(false, "FAIL");
      	     Reporter.log("Rules pop up not view..");
       }
       
       driver.findElement(By.className("manage_btn")).click();
       Thread.sleep(2000);

    try
    {
        // For Transfer booking
        if(driver.findElement(By.cssSelector("[id*='trans_old_'] > td > div > div [class*='transfer_icon']")).isDisplayed())
        {
            driver.findElement(By.cssSelector("[id*='trans_old_'] > td > div > div [class*='transfer_icon']")).click();
            Thread.sleep(4000);
        }
            driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
  	      
 	       // For transfer booking B2B To B2C
 	       driver.findElement(By.cssSelector("#MainForm > div > div > div > div.col-md-12.col-sm-12.col-xs-12.counters.bookings.no-padding > div > div > div > div > div > div:nth-child(6) > div > div:nth-child(2) > div > label.green > span")).click();
 	       Thread.sleep(1500);
 	       
 	       driver.findElement(By.id("_ctl0_MainContent_SubmitBTN")).click();
 	       Thread.sleep(4000);
        
             Reporter.log("Transfer booking successfully...");
  
             driver.navigate().refresh();
  
             Thread.sleep(4000);
             
             driver.switchTo().defaultContent();
    	     
    	        Thread.sleep(1000);
    	        System.out.println("\n");
    	        System.out.println("Transfer booking pop up view on admin defaultpage Logs..");
    	        System.out.println("\n");
    	        ExtractJSLogs1();
    	     
    	        Thread.sleep(2000);


    }
    catch(Exception e)
    {
        e.getMessage();

        final Screenshot screenshot1 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
        final BufferedImage image1 = screenshot1.getImage();
        ImageIO.write(image1, "PNG", new File("D:\\Ajit\\Script_SS\\AdminManageError\\9_TransferbookingFail.png"));
        Thread.sleep(2000);
  
        Assert.assertFalse(false, "FAIL");
        Reporter.log("Transfer booking not successful..");
    }
         
       try
       {
           //For E-Ticket from Manage(Admin)
           driver.findElement(By.className("manage_btn")).click();
           driver.findElement(By.className("editstat_icon")).click();
           
           System.out.println("\n");
           System.out.println("Editstatus on admin defaultpage Logs..");
           System.out.println("\n");
           ExtractJSLogs1();
           
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
           ExtractJSLogs1();
           
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
              ExtractJSLogs1();
         
             final Screenshot screenshot12 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
       		 final BufferedImage image12 = screenshot12.getImage();
       		 ImageIO.write(image12, "PNG", new File("D:\\Ajit\\Script_SS\\LocalAirBookingError\\12_ETicketedstatusFail.png"));
            
            driver.findElement(By.xpath("/html/body/div[6]/div[1]/button/span[1]")).click();
            AssertJUnit.assertTrue("Status fail for E-Ticketed...", chckout.isDisplayed());
            
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
       		ImageIO.write(image14, "PNG", new File("D:\\Ajit\\Script_SS\\LocalAirBookingError\\13_ETicketedStatusFail.png"));
        
           Assert.assertFalse(false, "FAIL");
           Reporter.log("Ticketed status:- FAIL");
           System.out.println("Booking ticketed fail..");
           driver.findElement(By.xpath("/html/body/div[6]/div[1]/button/span[1]")).click();
       	     
        }

                System.out.println("Actual status is:- "+ status3);
                Reporter.log("Actual status is:- " + status3);
                Reporter.log("Booking Ticketed successfully..");
                 
                 final Screenshot screenshot15 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
       		  final BufferedImage image15 = screenshot15.getImage();
       		  ImageIO.write(image15, "PNG", new File("D:\\Ajit\\Script_SS\\LocalAirBooking\\18_FlightETicketed.png"));
                  
                 Thread.sleep(5000);
           

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
       ExtractJSLogs1();
       	
         Thread.sleep(200);

             final Screenshot screenshot16 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
       	      final BufferedImage image16 = screenshot16.getImage();
       	      ImageIO.write(image16, "PNG", new File("D:\\Ajit\\Script_SS\\LocalAirBooking\\10_Cancelbookingpopup.png"));

       driver.switchTo().defaultContent();
       Thread.sleep(6000);
       driver.navigate().refresh();

       }catch(Exception e)
       {
          System.out.println("\n");
        System.out.println("Cancel booking fail on admin defaultpage Logs..");
        System.out.println("\n");
        ExtractJSLogs1();

        final Screenshot screenshot17 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
       	 final BufferedImage image17 = screenshot17.getImage();
       	 ImageIO.write(image17, "PNG", new File("D:\\Ajit\\Script_SS\\LocalAirBookingError\\8_CancelbookingFail.png"));
              
        Assert.assertFalse(false, "FAIL");
        Reporter.log("Booking cancel failed...");
        AssertJUnit.assertTrue("Booking cancel failed...", chckout.isDisplayed());
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
       		 	 ImageIO.write(image18, "PNG", new File("D:\\Ajit\\Script_SS\\LocalAirBookingError\\9_CancelbookingstatusFail.png"));
       	               
       	         Reporter.log("Actual status is:- " + status2);
       	         Assert.assertFalse(false, "FAIL");
       	         Reporter.log("Cancel status fail..");
       	         AssertJUnit.assertTrue("Cancel Status Fail...", chckout.isDisplayed());
       		     return;
        }

          System.out.println("Actual status is:- "+ status2);
          Reporter.log("Actual status is:- " + status2);
        
            final Screenshot screenshot19 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
       	     final BufferedImage image19 = screenshot19.getImage();
       	     ImageIO.write(image19, "PNG", new File("D:\\Ajit\\Script_SS\\LocalAirBooking\\12_Bookingcancelled.png"));
        
          System.out.println("Booking cancelled successfully..");
        
          Reporter.log("Booking cancelled successfully..");

          Thread.sleep(4000);

            
       }


       }

  */


@DataProvider
public String[][] Authentication() throws Exception
{

    String[][] testObjArray = LocalAirBookingUtils.getTableArray("D:\\Ajit\\Automation\\Workspace\\Odysseus_Product\\src\\main\\java\\testData\\LocalAirBookingData.xlsx","Sheet1");

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
