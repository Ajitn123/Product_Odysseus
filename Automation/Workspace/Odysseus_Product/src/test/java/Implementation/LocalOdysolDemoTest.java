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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Utility.LocalAirUtils;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.screentaker.ViewportPastingStrategy;


public class LocalOdysolDemoTest 
{
	    
	       AirLocalLoginPgeobjct lgnpge;
	       LocalOdysolDemoBookingpgeobjct airbk;
		   LocalAirCheckoutpageobjct chckout;
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
         Thread.sleep(2000);
         
         //Save console
         String testResultFile="D:\\Ajit\\Script_SS\\ConsoleError\\Local_AlanitaConfirmbookingError.txt";
         File file = new File(testResultFile);  
         FileOutputStream fis = new FileOutputStream(file);  
         PrintStream out = new PrintStream(fis);  
         System.setOut(out); 
                       
         Thread.sleep(1000);
         
         final Screenshot screenshot01 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
         final BufferedImage image01 = screenshot01.getImage();
         ImageIO.write(image01, "PNG", new File("D:\\Ajit\\Script_SS\\LocalAlanitaConfirm\\Loginpage.png"));

         //driver.navigate().to("https://localhost/odyssey/website/air/results.aspx?");
         Thread.sleep(4000);
         lgnpge = PageFactory.initElements(driver, AirLocalLoginPgeobjct.class);
         airbk = PageFactory.initElements(driver, LocalOdysolDemoBookingpgeobjct.class);
         chckout = PageFactory.initElements(driver, LocalAirCheckoutpageobjct.class);
            
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
	   
	         final Screenshot screenshot = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	         final BufferedImage image = screenshot.getImage();
	         ImageIO.write(image, "PNG", new File("D:\\Ajit\\Script_SS\\LocalAlanitaConfirm\\Searchpage.png"));
	      
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
		          ImageIO.write(image1, "PNG", new File("D:\\Ajit\\Script_SS\\LocalAlanitaConfirmError\\Invalidcredentials.png"));
		          
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
	       
	          driver.get("https://192.168.1.138/odyssey/website/air/results.aspx?showtrace=true");
	   
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
				     
		             final Screenshot screenshot2 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
			         final BufferedImage image2 = screenshot2.getImage();
			         ImageIO.write(image2, "PNG", new File("D:\\Ajit\\Script_SS\\LocalAlanitaConfirmError\\Flightnotavailable.png"));
				     
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
			      ImageIO.write(image3, "PNG", new File("D:\\Ajit\\Script_SS\\LocalAlanitaConfirm\\Flightdetailpage.png"));
	       
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
			 ImageIO.write(image4, "PNG", new File("D:\\Ajit\\Script_SS\\LocalAlanitaConfirmError\\Timeout.png"));
	  	 
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
	        ImageIO.write(image44, "PNG", new File("D:\\Ajit\\Script_SS\\LocalAlanitaConfirmError\\Statusfail.png"));
	   	 
	        Assert.assertFalse(false, "FAIL");
	  	    Reporter.log("Time out..");
	        AssertJUnit.assertTrue("Time out...", chckout.isDisplayed());
	        throw(e);
	    }
	    

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
		             ImageIO.write(image11, "PNG", new File("D:\\Ajit\\Script_SS\\LocalAlanitaConfirmError\\ConfirmbookingFail.png"));
		             
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
	          ImageIO.write(image12, "PNG", new File("D:\\Ajit\\Script_SS\\LocalAlanitaConfirmError\\FlightConfirmed.png"));
	          
	          System.out.println("Flight confirmed successfully..");
	           
	          Reporter.log("Flight confirmed successfully..");  // For displaying message on report
	           
	          Thread.sleep(9000);
	          
	          
	          
	      }


	  }

	  @DataProvider
	  public String[][] Authentication() throws Exception
	  {

	       String[][] testObjArray = LocalAirUtils.getTableArray("D:\\Ajit\\Automation\\Workspace\\Odysseus_Product\\src\\main\\java\\testData\\LocalAirData.xlsx","Sheet1");

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
