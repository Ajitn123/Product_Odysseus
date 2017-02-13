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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.ExtentReports;
import Utility.ExcelUtils;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.screentaker.ViewportPastingStrategy;


public class HeldConfirmAndTicketedTest 
{
	
	      Login lgnpge;
	      AirBookingpgeobjct airbk;
	      AirCheckoutpageobjct chckout;
	      HoldAndConfirmPgeobjct hldncnfrm;
	      public static WebDriver driver;
              Reporter report = new Reporter();
              static final ExtentReports extent = ExtentReports.get(HeldConfirmAndTicketedTest.class); 
	   
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
	                       driver = new FirefoxDriver();
 	   
	                 } 
	                 else if (browser.equalsIgnoreCase("chrome")) 
	                 {
	                	//    System.setProperty("webdriver.chrome.driver", "D:\\Ajit\\Driver\\chromedriver_win32 (1)\\chromedriver.exe");
		                //    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		                //    LoggingPreferences loggingprefs = new LoggingPreferences();
		                //    loggingprefs.enable(LogType.BROWSER, Level.ALL);
		                //    capabilities.setCapability(CapabilityType.LOGGING_PREFS, loggingprefs);
		                //    driver = new ChromeDriver(capabilities);
		                   
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
           
               driver.manage().window().maximize();
               driver.get("https://localhost/odyssey/admin/login.aspx");
               Thread.sleep(2000);
               
               //Save console
               String testResultFile="D:\\Ajit\\Script_SS\\ConsoleError\\HeldConfirmTicketedAndCancelbookingError.txt";
               File file = new File(testResultFile);  
               FileOutputStream fis = new FileOutputStream(file);  
               PrintStream out = new PrintStream(fis);  
               System.setOut(out); 
                             
               Thread.sleep(1000);
               
               final Screenshot screenshot01 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
               final BufferedImage image01 = screenshot01.getImage();
               ImageIO.write(image01, "PNG", new File("D:\\Ajit\\Script_SS\\HeldConfirmAndTicketed\\Loginpage.png"));

               //driver.navigate().to("https://localhost/odyssey/website/air/results.aspx?");
               Thread.sleep(4000);
               lgnpge = PageFactory.initElements(driver, Login.class);
               airbk = PageFactory.initElements(driver, AirBookingpgeobjct.class);
               chckout = PageFactory.initElements(driver, AirCheckoutpageobjct.class);
               hldncnfrm = PageFactory.initElements(driver, HoldAndConfirmPgeobjct.class);
           
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
    public void Heldlogin_data(String sUsername, String sPassword, String FromLocation, String ToLocation, String Firstname_Of_Adult1, String Middlename_of_Adult1, String Lastname_Of_Adult1, String Firstname_Of_Adult2, String Middlename_of_Adult2, String Lastname_Of_Adult2, String Firstname_Of_Adult3, String Middlename_of_Adult3, String Lastname_Of_Adult3, String Email, String Phone_No, String CardHolderName, String CardNo, String CardCvvNo, String Address, String City, String Zipcode, String Phone_Number, String BankName) throws Exception
    {
       try
       {
    	    extent.init("D:\\Ajit\\Automation\\Workspace\\Odysseus_Product\\test-output\\emailable-report.html", true);
    	    extent.startTest("HeldConfirmAndTicketedTest");
     	    System.out.println("sUsername: " + sUsername);
            System.out.println("sPassword: " + sPassword);
            System.out.println("FromLocation: " + FromLocation);
            System.out.println("ToLocation: " + ToLocation);
              
            lgnpge.LoginToTittle(sUsername, sPassword);
            System.out.println("\n");
            System.out.println("Loginpage Logs..");
            System.out.println("\n");
            ExtractJSLogs();
            airbk.AirBookingToTitle(FromLocation, ToLocation);
            System.out.println("\n");
            System.out.println("Searchpage Logs..");
            System.out.println("\n");
            ExtractJSLogs();
         
            //File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            //org.codehaus.plexus.util.FileUtils.copyFile(scr, new File("D:\\Ajit\\Script_SS\\HeldConfirmAndTicketed\\Searchpage.jpg"));
            final Screenshot screenshot = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
            final BufferedImage image = screenshot.getImage();
            ImageIO.write(image, "PNG", new File("D:\\Ajit\\Script_SS\\HeldConfirmAndTicketed\\Searchpage.png"));
      
            System.out.println("Page title verified:- User login successfully");
        }    
        catch(Exception e)
        {
        	  System.out.println("\n");
      	      System.out.println("Login with invalid credentials on Loginpage Logs..");
      	      System.out.println("\n");
      	      ExtractJSLogs();
      	  
        	  //File scr02 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	          //org.codehaus.plexus.util.FileUtils.copyFile(scr02, new File("D:\\Ajit\\Script_SS\\Error\\Invalidcredentials.jpg"));
	          final Screenshot screenshot1 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	          final BufferedImage image1 = screenshot1.getImage();
	          ImageIO.write(image1, "PNG", new File("D:\\Ajit\\Script_SS\\HeldConfirmAndTicketedError\\Invalidcredentials.png"));
	          
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
      
           driver.get("https://localhost/odyssey/website/air/results.aspx");
  
	       driver.manage().window().maximize();
	       
	       System.out.println("\n");
  	       System.out.println("Resultpage Logs..");
  	       System.out.println("\n");
  	       ExtractJSLogs();
	       
  	       Thread.sleep(1000);
  	   	 
	       final Screenshot screenshot003 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
		   final BufferedImage image003 = screenshot003.getImage();
		   ImageIO.write(image003, "PNG", new File("D:\\Ajit\\Script_SS\\HeldConfirmAndTicketed\\Resultpage.png"));
    
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
         	
          	   //File scr01 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	           //org.codehaus.plexus.util.FileUtils.copyFile(scr01, new File("D:\\Ajit\\Script_SS\\Error\\Flightnotavailable.jpg"));
	           final Screenshot screenshot2 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
		       final BufferedImage image2 = screenshot2.getImage();
		       ImageIO.write(image2, "PNG", new File("D:\\Ajit\\Script_SS\\HeldConfirmAndTicketedError\\Invalidcredentials.png"));
         	
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
      
            //File scr1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            //org.codehaus.plexus.util.FileUtils.copyFile(scr1, new File("D:\\Ajit\\Script_SS\\HeldConfirmAndTicketed\\Flightdetailpage.jpg"));
            final Screenshot screenshot3 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
		    final BufferedImage image3 = screenshot3.getImage();
		    ImageIO.write(image3, "PNG", new File("D:\\Ajit\\Script_SS\\HeldConfirmAndTicketed\\Flightdetailpage.png"));
     
            System.out.println("Flight selected successfully..");
             
            Thread.sleep(1000);
     try
     {
         //For Hold
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
         System.out.println("Phone_No: " + Phone_No);
               
         chckout.HoldToTitle(Firstname_Of_Adult1, Middlename_of_Adult1, Lastname_Of_Adult1, Firstname_Of_Adult2, Middlename_of_Adult2, Lastname_Of_Adult2, Firstname_Of_Adult3, Middlename_of_Adult3, Lastname_Of_Adult3, Email, Phone_No);
          
     }
     catch(Exception e)
     {
    	 System.out.println("\n");
    	 System.out.println("Timeout on checkoutpage Logs..");
    	 System.out.println("\n");
    	 ExtractJSLogs();
    	 
    	 //File scr07 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
         //org.codehaus.plexus.util.FileUtils.copyFile(scr07, new File("D:\\Ajit\\Script_SS\\Error\\Timeouterror.jpg"));
         final Screenshot screenshot4 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
		 final BufferedImage image4 = screenshot4.getImage();
		 ImageIO.write(image4, "PNG", new File("D:\\Ajit\\Script_SS\\HeldConfirmAndTicketedError\\Timeouterror.png"));
         
         Assert.assertFalse(false, "FAIL");
         Reporter.log("Timeout error...");
   	     AssertJUnit.assertTrue("Timeout error...", chckout.isDisplayed());
   	     throw(e);
     }
     
     try
     {
        //Held Booking
        driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_HoldBTN")).click();
        System.out.println("\n");
        System.out.println("Heldbooking Logs..");
        System.out.println("\n");
        ExtractJSLogs();
     }
     catch(Exception e)
     {
    	 System.out.println("\n");
    	 System.out.println("Statusfail on confirmationpage Logs..");
    	 System.out.println("\n");
    	 ExtractJSLogs();
    	 
    	 final Screenshot screenshot44 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
         final BufferedImage image44 = screenshot44.getImage();
         ImageIO.write(image44, "PNG", new File("D:\\Ajit\\Script_SS\\HeldConfirmAndTicketedError\\Statusfail.png"));
         
         Assert.assertFalse(false, "FAIL");
   	     Reporter.log("Time out..");
      	 AssertJUnit.assertTrue("Time out...", chckout.isDisplayed());
      	 throw(e);
     }
     
   /*     
         //Verify passenger name validation
         //For passenger 1 
         String Passengerfirstnme = driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl0_TravelerAccount_1_FirstName")).getText();
               
         if(Passengerfirstnme.trim().length()<=29)
         {
         	 System.out.println("You didn't enter any thing. Enter maximum 29 characters for the firstname");	
         	 System.out.println("Actual Result is" +Passengerfirstnme);
         	 Reporter.log("You didn't enter any thing. Enter maximum 29 characters for the firstname");
         	 Reporter.log("Actual Result is:- " +Passengerfirstnme);	
         	 
         	 final Screenshot screenshot5 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
              final BufferedImage image5 = screenshot5.getImage();
              ImageIO.write(image5, "PNG", new File("D:\\Ajit\\Script_SS\\HeldError\\Invalidfirstname.png"));
         	 //File scr013 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	       	     //org.codehaus.plexus.util.FileUtils.copyFile(scr013, new File("D:\\Ajit\\Script_SS\\Error\\Invalidfirstname.jpg")); 
		       	   
         }
         
         String Passengerlastnme = driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl0_TravelerAccount_1_LastName")).getText();
         
         if(Passengerlastnme.trim().length()<=29)
         {
         	 System.out.println("You didn't enter any thing. Enter maximum 29 characters for the last");	
         	 System.out.println("Actual Result is" +Passengerlastnme);
         	 Reporter.log("You didn't enter any thing. Enter maximum 29 characters for the firstname");
         	 Reporter.log("Actual Result is:- " +Passengerlastnme);	
         	 
         	 //File scr014 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	       	     //org.codehaus.plexus.util.FileUtils.copyFile(scr014, new File("D:\\Ajit\\Script_SS\\Error\\Invalidlastname.jpg")); 
         	 final Screenshot screenshot6 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
              final BufferedImage image6 = screenshot6.getImage();
              ImageIO.write(image6, "PNG", new File("D:\\Ajit\\Script_SS\\HeldError\\Invalidlastname.png"));
           
         }
         
         //For passenger 2
         String Passengerfirstnme2 = driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl1_TravelerAccount_2_FirstName")).getText();
         
         if(Passengerfirstnme2.trim().length()<=29)
         {
         	 System.out.println("You didn't enter any thing. Enter maximum 29 characters for the firstname");	
         	 System.out.println("Actual Result is" +Passengerfirstnme2);
         	 Reporter.log("You didn't enter any thing. Enter maximum 29 characters for the firstname");
         	 Reporter.log("Actual Result is:- " +Passengerfirstnme2);	
         	 
         	 //File scr015 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	       	     //org.codehaus.plexus.util.FileUtils.copyFile(scr015, new File("D:\\Ajit\\Script_SS\\Error\\Invalidfirstname2.jpg")); 
	       	     final Screenshot screenshot7 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
              final BufferedImage image7 = screenshot7.getImage();
              ImageIO.write(image7, "PNG", new File("D:\\Ajit\\Script_SS\\HeldError\\Invalidfirstname2.png"));
	       	     
             
         }
         
         String Passengerlastnme2 = driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl1_TravelerAccount_2_LastName")).getText();
         
         if(Passengerlastnme2.trim().length()<=29)
         {
         	 System.out.println("You didn't enter any thing. Enter maximum 29 characters for the last");	
         	 System.out.println("Actual Result is" +Passengerlastnme2);
         	 Reporter.log("You didn't enter any thing. Enter maximum 29 characters for the firstname");
         	 Reporter.log("Actual Result is:- " +Passengerlastnme2);	
         	 
         	 //File scr016 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	       	     //org.codehaus.plexus.util.FileUtils.copyFile(scr016, new File("D:\\Ajit\\Script_SS\\Error\\Invalidlastname2.jpg")); 
         	 final Screenshot screenshot8 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
              final BufferedImage image8 = screenshot8.getImage();
              ImageIO.write(image8, "PNG", new File("D:\\Ajit\\Script_SS\\HeldError\\Invalidlastname2.png"));
             
         }
         
       //For passenger 3
         String Passengerfirstnme3 = driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl2_TravelerAccount_3_FirstName")).getText();
         
         if(Passengerfirstnme3.trim().length()<=29)
         {
         	 System.out.println("You didn't enter any thing. Enter maximum 29 characters for the firstname");	
         	 System.out.println("Actual Result is" +Passengerfirstnme3);
         	 Reporter.log("You didn't enter any thing. Enter maximum 29 characters for the firstname");
         	 Reporter.log("Actual Result is:- " +Passengerfirstnme3);	
         	 
         	 //File scr017 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	       	     //org.codehaus.plexus.util.FileUtils.copyFile(scr017, new File("D:\\Ajit\\Script_SS\\Error\\Invalidfirstname3.jpg"));
         	 final Screenshot screenshot9 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
              final BufferedImage image9 = screenshot9.getImage();
              ImageIO.write(image9, "PNG", new File("D:\\Ajit\\Script_SS\\HeldError\\Invalidfirstname3.png"));
             
         }
      
         String Passengerlastnme3 = driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl2_TravelerAccount_3_LastName")).getText();
         
         if(Passengerlastnme3.trim().length()<=29)
         {
         	 System.out.println("You didn't enter any thing. Enter maximum 29 characters for the last");	
         	 System.out.println("Actual Result is" +Passengerlastnme3);
         	 Reporter.log("You didn't enter any thing. Enter maximum 29 characters for the firstname");
         	 Reporter.log("Actual Result is:- " +Passengerlastnme3);	
         	 
         	 //File scr018 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	       	     //org.codehaus.plexus.util.FileUtils.copyFile(scr018, new File("D:\\Ajit\\Script_SS\\Error\\Invalidlastname3.jpg")); 
         	 final Screenshot screenshot10 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
              final BufferedImage image10 = screenshot10.getImage();
              ImageIO.write(image10, "PNG", new File("D:\\Ajit\\Script_SS\\HeldError\\Invalidlastname3.png"));
             
         }
   */           
         
         Thread.sleep(30000);
    
    try
    {
         //For the verify held condition
         String status = driver.findElement(By.xpath("//*[@id='conf_details']/div/div[6]/div")).getText(); 
         //String text = driver.getTitle();  
                   
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
				
				//File scr2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	            //org.codehaus.plexus.util.FileUtils.copyFile(scr2, new File("D:\\Ajit\\Script_SS\\Error\\StatusFailed.jpg"));
	            final Screenshot screenshot5 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	   		    final BufferedImage image5 = screenshot5.getImage();
	   		    ImageIO.write(image5, "PNG", new File("D:\\Ajit\\Script_SS\\HeldConfirmAndTicketedError\\HeldbookingFail.png"));
	            
	            Reporter.log("Actual status is:-" +status);
	            Assert.assertFalse(false, "FAIL");
	            Reporter.log("Status Fail b'coz status are differ to expected..");
			    AssertJUnit.assertTrue("Status Fail b'coz status are differ to expected...", chckout.isDisplayed());
			    return;
		 }
        
         System.out.println("Actual status is:- "+ status);
         Reporter.log("Actual status is:- " + status);
         
         //Assert.assertEquals(status, text);
         
         //File scr7 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
         //org.codehaus.plexus.util.FileUtils.copyFile(scr7, new File("D:\\Ajit\\Script_SS\\HeldConfirmAndTicketed\\Heldflight.jpg"));
         final Screenshot screenshot6 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
		 final BufferedImage image6 = screenshot6.getImage();
		 ImageIO.write(image6, "PNG", new File("D:\\Ajit\\Script_SS\\HeldConfirmAndTicketed\\Flightheld.png"));
         
         System.out.println("Flight held Successfully..");
         
         Reporter.log("Flight held successfully..");  // For displaying message on report
         
         Thread.sleep(13000);
         
       }
     catch(Exception e)
     {
    	    System.out.println("Time out..");
			
			//File scr12 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            //org.codehaus.plexus.util.FileUtils.copyFile(scr12, new File("D:\\Ajit\\Script_SS\\Error\\Timeout.jpg"));
            final Screenshot screenshot7 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
   		    final BufferedImage image7 = screenshot7.getImage();
   		    ImageIO.write(image7, "PNG", new File("D:\\Ajit\\Script_SS\\HeldConfirmAndTicketedError\\Timeout.png"));
         
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
         System.out.println("BankName: " + BankName);
        
         hldncnfrm.HoldAfterConfirmToTitle(CardHolderName, CardNo, CardCvvNo, Address, City, Zipcode, Phone_Number, BankName);
     }
     catch(Exception e)
     {
    	 System.out.println("\n");
         System.out.println("Timeout on Checkoutpage Logs..");
         System.out.println("\n");
         ExtractJSLogs();
         
    	 //File scr08 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
         //org.codehaus.plexus.util.FileUtils.copyFile(scr08, new File("D:\\Ajit\\Script_SS\\Error\\Timeouterror.jpg"));
         final Screenshot screenshot8 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
		 final BufferedImage image8 = screenshot8.getImage();
		 ImageIO.write(image8, "PNG", new File("D:\\Ajit\\Script_SS\\HeldConfirmAndTicketedError\\Timeouterror.png"));
         
         Assert.assertFalse(false, "FAIL");
         Reporter.log("Timeout error...");
   	     AssertJUnit.assertTrue("Timeout error...", chckout.isDisplayed());
   	     throw(e);
     }
         
          System.out.println("\n");
          System.out.println("Confirmationpage Logs..");
          System.out.println("\n");
          ExtractJSLogs();
          
          Thread.sleep(9000);
     
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
				
				 //File scr8 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		         //org.codehaus.plexus.util.FileUtils.copyFile(scr8, new File("D:\\Ajit\\Script_SS\\HeldConfirmAndTicketed\\FailedStatus.jpg"));
		         final Screenshot screenshot9 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
				 final BufferedImage image9 = screenshot9.getImage();
				 ImageIO.write(image9, "PNG", new File("D:\\Ajit\\Script_SS\\HeldConfirmAndTicketed\\ConfirmbookingFail.png"));
		               
		         Reporter.log("Actual status is:-" +status1);
		         Assert.assertFalse(false, "FAIL");
		         Reporter.log("Status Fail b'coz status are differ to expected..");
		         AssertJUnit.assertTrue("Status Fail b'coz status are differ to expected...", chckout.isDisplayed());
			     return;
	     }
        
           System.out.println("Actual status is:- "+ status1);
           Reporter.log("Actual status is:- " + status1);
         
           //File scr3 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
           //org.codehaus.plexus.util.FileUtils.copyFile(scr3, new File("D:\\Ajit\\Script_SS\\HeldConfirmAndTicketed\\Confirmflight.jpg"));
           final Screenshot screenshot10 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
		   final BufferedImage image10 = screenshot10.getImage();
		   ImageIO.write(image10, "PNG", new File("D:\\Ajit\\Script_SS\\HeldConfirmAndTicketed\\Confirmbooking.png"));
         
           System.out.println("Flight confirmed successfully..");
         
           Reporter.log("Flight confirmed successfully..");  // For displaying message on report
           
           Thread.sleep(18000);

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
 		    ImageIO.write(image11, "PNG", new File("D:\\Ajit\\Script_SS\\HeldConfirmAndTicketed\\Admindefaultpage.png"));
            
            Thread.sleep(1000);
            
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
			
            System.out.println("\n");
            System.out.println("Ticketed booking on admin defaultpage Logs..");
            System.out.println("\n");
            ExtractJSLogs();
            
            Thread.sleep(2000);
           // driver.navigate().refresh();
            
      }
      catch(Exception e)
      {
    	     Reporter.log("Status Ticketed fail..");
    	     
    	     System.out.println("\n");
             System.out.println("Ticketed status fail on admin defaultpage Logs..");
             System.out.println("\n");
             ExtractJSLogs();
    	  
    	     //File scr8 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	         //org.codehaus.plexus.util.FileUtils.copyFile(scr8, new File("D:\\Ajit\\Script_SS\\Error\\FailedStatusETickets.jpg"));
	         final Screenshot screenshot12 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	 		 final BufferedImage image12 = screenshot12.getImage();
	 		 ImageIO.write(image12, "PNG", new File("D:\\Ajit\\Script_SS\\HeldConfirmAndTicketedError\\ETicketedstatusFail.png"));
	         
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
			System.out.println("Actual status is:- "+ status3);
				
			//File scr8 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		    //org.codehaus.plexus.util.FileUtils.copyFile(scr8, new File("D:\\Ajit\\Script_SS\\Error\\ETicketedstatusfailed.jpg"));
		    final Screenshot screenshot14 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	 		final BufferedImage image14 = screenshot14.getImage();
	 		ImageIO.write(image14, "PNG", new File("D:\\Ajit\\Script_SS\\HeldConfirmAndTicketedError\\ETicketedStatusFail.png"));
		 
		    Assert.assertFalse(false, "FAIL");
		    Reporter.log("Ticketed status:- FAIL");
		    System.out.println("Booking ticketed fail..");
		    driver.findElement(By.xpath("/html/body/div[6]/div[1]/button/span[1]")).click();
			     
	     }
     
            System.out.println("Actual status is:- "+ status3);
            Reporter.log("Actual status is:- " + status3);
                  
            //File scr4 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            //org.codehaus.plexus.util.FileUtils.copyFile(scr4, new File("D:\\Ajit\\Script_SS\\HeldConfirmAndTicketed\\Confirmflight.jpg"));
            final Screenshot screenshot15 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	 		final BufferedImage image15 = screenshot15.getImage();
	 		ImageIO.write(image15, "PNG", new File("D:\\Ajit\\Script_SS\\HeldConfirmAndTicketed\\FlightETicketed.png"));
                   
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
            ExtractJSLogs();
			
			Thread.sleep(200);
    	    
    	    final Screenshot screenshot16 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	 		final BufferedImage image16 = screenshot16.getImage();
	 		ImageIO.write(image16, "PNG", new File("D:\\Ajit\\Script_SS\\HeldConfirmAndTicketed\\Cancelbookingpopup.png"));
    	    
    	    driver.switchTo().defaultContent();
    	    Thread.sleep(6000);
    	    driver.navigate().refresh();
    	    
      }catch(Exception e)
      {
    	      System.out.println("\n");
              System.out.println("Cancel booking fail on admin defaultpage Logs..");
              System.out.println("\n");
              ExtractJSLogs();
              
    	     //File scr8 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	         //org.codehaus.plexus.util.FileUtils.copyFile(scr8, new File("D:\\Ajit\\Script_SS\\Error\\FailedCancel.jpg"));
	         final Screenshot screenshot17 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
		 	 final BufferedImage image17 = screenshot17.getImage();
		 	 ImageIO.write(image17, "PNG", new File("D:\\Ajit\\Script_SS\\HeldConfirmAndTicketedError\\CancelbookingFail.png"));
	               
	         Assert.assertFalse(false, "FAIL");
	         Reporter.log("Booking cancel failed...");
	         AssertJUnit.assertTrue("Booking cancel failed...", hldncnfrm.isDisplayed());
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
    				
    				 //File scr8 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    		         //org.codehaus.plexus.util.FileUtils.copyFile(scr8, new File("D:\\Ajit\\Script_SS\\Error\\CancelStatusFailed.jpg"));
    		         final Screenshot screenshot18 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
    			 	 final BufferedImage image18 = screenshot18.getImage();
    			 	 ImageIO.write(image18, "PNG", new File("D:\\Ajit\\Script_SS\\HeldConfirmAndTicketedError\\CancelbookingstatusFail.png"));
    		               
    		         Reporter.log("Actual status is:- " + status2);
    		         Assert.assertFalse(false, "FAIL");
    		         Reporter.log("Cancel status fail..");
    		         AssertJUnit.assertTrue("Cancel Status Fail...", hldncnfrm.isDisplayed());
    			     return;
    	     }
            
               System.out.println("Actual status is:- "+ status2);
               Reporter.log("Actual status is:- " + status2);
             
               //File scr3 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
               //org.codehaus.plexus.util.FileUtils.copyFile(scr3, new File("D:\\Ajit\\Script_SS\\HeldConfirmAndTicketed\\Cancelbooking.jpg"));
               final Screenshot screenshot19 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
			   final BufferedImage image19 = screenshot19.getImage();
			   ImageIO.write(image19, "PNG", new File("D:\\Ajit\\Script_SS\\HeldConfirmAndTicketedError\\Bookingcancelled.png"));
             
               System.out.println("Booking cancelled successfully..");
             
               Reporter.log("Booking cancelled successfully..");
            
               Thread.sleep(4000);
               
               
   }


   @DataProvider
   public String[][] Authentication() throws Exception
   {

	     String[][] testObjArray = ExcelUtils.getTableArray("D:\\Ajit\\Automation\\Workspace\\Odysseus_Product\\src\\main\\java\\testData\\TestData.xlsx","Sheet1");

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
