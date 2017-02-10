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
import Utility.ExcelUtils;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.screentaker.ViewportPastingStrategy;


public class AirBookingTest 
{

	   Login lgnpge;
	   AirBookingpgeobjct airbk;
	   AirCheckoutpageobjct chckout;
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
	                	    System.setProperty("webdriver.chrome.driver", "D:\\Ajit\\Driver\\chromedriver_win32 (1)\\chromedriver.exe");
		                    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		                    LoggingPreferences loggingprefs = new LoggingPreferences();
		                    loggingprefs.enable(LogType.BROWSER, Level.ALL);
		                    capabilities.setCapability(CapabilityType.LOGGING_PREFS, loggingprefs);
		                    driver = new ChromeDriver(capabilities);
                 
		                   
	                 }  
	                 else if (browser.equalsIgnoreCase("IE")) 
	                 {
		                   System.setProperty("webdriver.ie.driver", "D:\\Ajit\\Driver\\IEDriverServer_Win32_2.53.0\\IEDriverServer.exe");
		               //  driver = new InternetExplorerDriver();
		                   
	                 } 

         } catch (WebDriverException e) 
           {
	                   System.out.println(e.getMessage());
           }
               
               driver.manage().window().maximize();
               driver.get("https://localhost/odyssey/admin/login.aspx");
               Thread.sleep(2000);
               
               //Save console
               String testResultFile="D:\\Ajit\\Script_SS\\ConsoleError\\ConfirmbookingError.txt";
               File file = new File(testResultFile);  
               FileOutputStream fis = new FileOutputStream(file);  
               PrintStream out = new PrintStream(fis);  
               System.setOut(out); 
                             
               Thread.sleep(1000);
               
               final Screenshot screenshot01 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
               final BufferedImage image01 = screenshot01.getImage();
               ImageIO.write(image01, "PNG", new File("D:\\Ajit\\Script_SS\\Confirm\\Loginpage.png"));

               //driver.navigate().to("https://localhost/odyssey/website/air/results.aspx?");
               Thread.sleep(4000);
               lgnpge = PageFactory.initElements(driver, Login.class);
               airbk = PageFactory.initElements(driver, AirBookingpgeobjct.class);
               chckout = PageFactory.initElements(driver, AirCheckoutpageobjct.class);
               
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
    public void Confirmlogin_data(String sUsername, String sPassword, String FromLocation, String ToLocation, String Firstname_Of_Adult1, String Middlename_of_Adult1, String Lastname_Of_Adult1, String Firstname_Of_Adult2, String Middlename_of_Adult2, String Lastname_Of_Adult2, String Firstname_Of_Adult3, String Middlename_of_Adult3, String Lastname_Of_Adult3, String Email, String Phone_No, String CardHolderName, String CardNo, String CardCvvNo, String Address, String City, String Zipcode, String Phone_Number, String BankName) throws Exception
    {
       try
       {  
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
            //org.codehaus.plexus.util.FileUtils.copyFile(scr, new File("D:\\Ajit\\Script_SS\\Confirm\\Searchpage.jpg"));
            final Screenshot screenshot = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
            final BufferedImage image = screenshot.getImage();
            ImageIO.write(image, "PNG", new File("D:\\Ajit\\Script_SS\\Confirm\\Searchpage.png"));
         
            System.out.println("Page title verified:- User login successfully");
         }
         catch(Exception e)
         {
        	  System.out.println("\n");
       	      System.out.println("Login with invalid credentials on Loginpage Logs..");
       	      System.out.println("\n");
       	      ExtractJSLogs();
        	  //File scr02 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	          //org.codehaus.plexus.util.FileUtils.copyFile(scr02, new File("D:\\Ajit\\Script_SS\\ConfirmError\\Invalidcredentials.jpg"));
	          final Screenshot screenshot1 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	          final BufferedImage image1 = screenshot1.getImage();
	          ImageIO.write(image1, "PNG", new File("D:\\Ajit\\Script_SS\\ConfirmError\\Invalidcredentials.png"));
	          
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
        
    	     Thread.sleep(3000);
    	   	         
             List<WebElement> options = driver.findElements(By.className("print-select-flight"));
             
          
             if(options.size()>0)
             {
                  options.get(2).click();  // 1 for AmadeusWS or 2 for Sabre
             }
             else 
             {
			     System.out.println("Flight not available..");
			     
			     //File scr01 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	             //org.codehaus.plexus.util.FileUtils.copyFile(scr01, new File("D:\\Ajit\\Script_SS\\Error\\Flightnotavailable.jpg"));
	             final Screenshot screenshot2 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
		         final BufferedImage image2 = screenshot2.getImage();
		         ImageIO.write(image2, "PNG", new File("D:\\Ajit\\Script_SS\\ConfirmError\\Flightnotavailable.png"));
			     
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
               //org.codehaus.plexus.util.FileUtils.copyFile(scr1, new File("D:\\Ajit\\Script_SS\\Confirm\\Flightdetailpage.jpg"));
               final Screenshot screenshot3 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
		       final BufferedImage image3 = screenshot3.getImage();
		       ImageIO.write(image3, "PNG", new File("D:\\Ajit\\Script_SS\\Confirm\\Flightdetailpage.png"));
          
               System.out.println("Flight selected successfully..");
    	
    	
               Thread.sleep(1000);
       try   
       {
             //For Checkout page
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
             System.out.println("CardHolderName: " + CardHolderName);
             System.out.println("CardNo: " + CardNo);
             System.out.println("CardCvvNo: " + CardCvvNo);
             System.out.println("Address: " + Address);
             System.out.println("City: " + City);
             System.out.println("Zipcode: " + Zipcode);
             System.out.println("Phone_Number: " + Phone_Number);
             System.out.println("BankName: " + BankName);
          
             chckout.ConfirmToTitle(Firstname_Of_Adult1, Middlename_of_Adult1, Lastname_Of_Adult1, Firstname_Of_Adult2, Middlename_of_Adult2, Lastname_Of_Adult2, Firstname_Of_Adult3, Middlename_of_Adult3, Lastname_Of_Adult3, Email, Phone_No, CardHolderName, CardNo, CardCvvNo, Address, City, Zipcode, Phone_Number, BankName);
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
		     ImageIO.write(image4, "PNG", new File("D:\\Ajit\\Script_SS\\ConfirmError\\Timeout.png"));
     	 
     	     Assert.assertFalse(false, "FAIL");
     	     Reporter.log("Time out..");
        	 AssertJUnit.assertTrue("Time out...", chckout.isDisplayed());
        	 throw(e); 	
       }
       
       try
       {
             //Confirm Booking
             driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_ConfirmBkgBTN")).click();
             System.out.println("\n");
             System.out.println("Confirmationpage Logs..");
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
           ImageIO.write(image44, "PNG", new File("D:\\Ajit\\Script_SS\\HeldError\\Statusfail.png"));
      	 
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
                	 
                	 //File scr013 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	       	     //org.codehaus.plexus.util.FileUtils.copyFile(scr013, new File("D:\\Ajit\\Script_SS\\Error\\Invalidfirstname.jpg")); 
    	       	     final Screenshot screenshot5 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
		             final BufferedImage image5 = screenshot5.getImage();
		             ImageIO.write(image5, "PNG", new File("D:\\Ajit\\Script_SS\\ConfirmError\\Invalidfirstname.png"));
    	       	     
    	       	     AssertJUnit.assertTrue("You didn't enter any thing. Enter maximum 29 characters for the firstname...", chckout.isDisplayed());
    	          	 return;
                    
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
		             ImageIO.write(image6, "PNG", new File("D:\\Ajit\\Script_SS\\ConfirmError\\Invalidlastname.png"));
    	       	     
    	       	     AssertJUnit.assertTrue("You didn't enter any thing. Enter maximum 29 characters for the lastname...", chckout.isDisplayed());
    	          	 return;
                    
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
		             ImageIO.write(image7, "PNG", new File("D:\\Ajit\\Script_SS\\ConfirmError\\Invalidfirstname2.png"));
    	       	     
    	       	     AssertJUnit.assertTrue("You didn't enter any thing. Enter maximum 29 characters for the firstname...", chckout.isDisplayed());
    	          	 return;
                    
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
		             ImageIO.write(image8, "PNG", new File("D:\\Ajit\\Script_SS\\ConfirmError\\Invalidlastname2.png"));
    	       	     
    	       	     AssertJUnit.assertTrue("You didn't enter any thing. Enter maximum 29 characters for the lastname...", chckout.isDisplayed());
    	          	 return;
                    
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
		             ImageIO.write(image9, "PNG", new File("D:\\Ajit\\Script_SS\\ConfirmError\\Invalidfirstname3.png"));
    	       	     
    	       	     AssertJUnit.assertTrue("You didn't enter any thing. Enter maximum 29 characters for the firstname...", chckout.isDisplayed());
    	          	 return;
                    
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
		             ImageIO.write(image10, "PNG", new File("D:\\Ajit\\Script_SS\\ConfirmError\\Invalidlastname3.png"));
    	       	     
    	       	     AssertJUnit.assertTrue("You didn't enter any thing. Enter maximum 29 characters for the lastname...", chckout.isDisplayed());
    	          	 return;
                    
                }
                
      */     
             Thread.sleep(10000);
             
             //For the verify confirm condition
             String status = driver.findElement(By.xpath("//*[@id='conf_details']/div/div[6]/div")).getText(); 
                               
             if(status.toLowerCase().trim().matches("confirmed"))
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
	             ImageIO.write(image11, "PNG", new File("D:\\Ajit\\Script_SS\\ConfirmError\\ConfirmbookingFail.png"));
 	             
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
             ImageIO.write(image12, "PNG", new File("D:\\Ajit\\Script_SS\\ConfirmError\\FlightConfirmed.png"));
             
             System.out.println("Flight confirmed successfully..");
              
             Reporter.log("Flight confirmed successfully..");  // For displaying message on report
              
             Thread.sleep(9000);
     /*         
             
              //For the price comparison
              String Price1 = driver.findElement(By.xpath("//*[@id='flight-summary_0']/div[2]/span[1]/span[3]")).getCssValue("");  // Result page
              String price2 = driver.findElement(By.xpath("//*[@id='trip_summary_package_total']")).getCssValue("");      // Checkout page
              String price3 = driver.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0__ctl4_BillingAddressContainer']/div[1]/a/span")).getCssValue("");  // Payment gateway page 
             
              if(Price1.equalsIgnoreCase(price2))
              {
            	  System.out.println("Price1 And Price2 are matched..");
              	  Reporter.log("Prices matched..");
              }
              else if (price2.equalsIgnoreCase(price3)) 
              {
 			      System.out.println("Price2 And Price3 are matched..");	
 			      Reporter.log("Prices matched..");
 			  }
              else if (price3.equalsIgnoreCase(Price1))
              {
 			      System.out.println("Price3 And Price1 are matched..");	
 			      Reporter.log("Prices matched..");
 			  }
              else 
              {
 			      System.out.println("Price not matched..");	
 			      Reporter.log("Price not matched..");
 			  }
              
        
               class:- tot-price PkgPriceTotal
              //*[@id="flight-summary_0"]/div[2]/span[1]/span[3]

              id:- trip_summary_package_total
              //*[@id="trip_summary_package_total"]
              class:- payment_uc_package_total
              //*[@id="_ctl0_MainContentsPH__ctl0__ctl4_BillingAddressContainer"]/div[1]/a/span


                  if(Price1.equals(price2))
                  {
                 	 System.out.println("Prices matched..");
                 	 Reporter.log("Prices matched..");
                  }
                  else if (price2.equals(price3)) 
                  {
     			      System.out.println("Prices matched..");	
     			      Reporter.log("Prices matched..");
     			  }
                  else if (price3.equals(Price1))
                  {
     			      System.out.println("Prices matched..");	
     			      Reporter.log("Prices matched..");
     			  }
                  else 
                  {
     			      System.out.println("Price not matched..");	
     			      Reporter.log("Price not matched..");
     			  }
     */
         }
  
 
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
