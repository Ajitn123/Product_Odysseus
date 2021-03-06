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
import Utility.LocalTravelportUtils;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.screentaker.ViewportPastingStrategy;


public class LocalDynamicPackagingAirTest 
{

	 
	   LocalDynamicPackagingLoginpgeobjct lgnpge;
	   LocalDynamicPackagingAirpgobjct airbk;
	   LocalDynamicPackagingAirPurchasepgobjct chckout;
	   LocalDynamicPackagingAirPayment hldncnfrm;
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
    String testResultFile="D:\\Ajit\\Script_SS\\ConsoleError\\Local_DynamicPackagingAirError.txt";
    File file = new File(testResultFile);  
    FileOutputStream fis = new FileOutputStream(file);  
    PrintStream out = new PrintStream(fis);  
    System.setOut(out); 
                  
    Thread.sleep(1000);
    
    final Screenshot screenshot01 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
    final BufferedImage image01 = screenshot01.getImage();
    ImageIO.write(image01, "PNG", new File("D:\\Ajit\\Script_SS\\LocalDynamicPackagingAir\\1_Loginpage.png"));

    //driver.navigate().to("https://localhost/odyssey/website/air/results.aspx?");
    Thread.sleep(4000);
    lgnpge = PageFactory.initElements(driver, LocalDynamicPackagingLoginpgeobjct.class);
    airbk = PageFactory.initElements(driver, LocalDynamicPackagingAirpgobjct.class);
    chckout = PageFactory.initElements(driver, LocalDynamicPackagingAirPurchasepgobjct.class);
    hldncnfrm = PageFactory.initElements(driver, LocalDynamicPackagingAirPayment.class);
       
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
public void Confirmlogin_data(String sUsername, String sPassword, String FromLocation, String ToLocation, String Firstname_Of_Adult1, String Middlename_of_Adult1, String Lastname_Of_Adult1, String Firstname_Of_Adult2, String Middlename_of_Adult2, String Lastname_Of_Adult2, String Firstname_Of_Adult3, String Middlename_of_Adult3, String Lastname_Of_Adult3, String Firstname_Of_Infunt4, String Middlename_of_Infunt4, String Lastname_Of_Infunt4, String Firstname_Of_SeatInfunt5, String Middlename_of_SeatInfunt5, String Lastname_Of_SeatInfunt5, String Email, String ConEmail, String Phone_No, String DestinationPhone_No, String CardHolderName, String CardNo, String CardCvvNo, String Address, String City, String Zipcode, String Phone_Number, String Bank_No) throws Exception
{
try
{  
	 Reporter.log("Website Name:- Ajit");
	 	 
    System.out.println("sUsername: " + sUsername);
    System.out.println("sPassword: " + sPassword);
    System.out.println("FromLocation: " + FromLocation);
    System.out.println("ToLocation: " + ToLocation);
          
    lgnpge.DynamicToTittle(sUsername, sPassword);
    
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
    ImageIO.write(image, "PNG", new File("D:\\Ajit\\Script_SS\\LocalDynamicPackagingAir\\2_Searchpage.png"));
 
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
	      ImageIO.write(image1, "PNG", new File("D:\\Ajit\\Script_SS\\LocalDynamicPackagingAirError\\1_Invalidcredentials.png"));
	          
	      Assert.assertFalse(false, "FAIL");
	      Reporter.log("Username and Password are invalid..");
	      AssertJUnit.assertTrue("Username Or Password are invalid...", lgnpge.isDisplayed());
	      AssertJUnit.assertTrue("Flight locations are invalid...", airbk.isDisplayed());
	      throw(e);
	  
  }
 
      Thread.sleep(15000);

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

	      Thread.sleep(20000);
/*	
	  try
	  {
	  		  
	      // For Technical Stops
	      driver.findElement(By.id("stops1")).click();
	      Thread.sleep(3000);
	      driver.findElement(By.id("stops2")).click();
	      Thread.sleep(3000);
	      
	         final Screenshot screenshot004 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
		     final BufferedImage image004 = screenshot004.getImage();
		     ImageIO.write(image004, "PNG", new File("D:\\Ajit\\Script_SS\\LocalTravelport\\02_OnlyNonstop.png"));
		     Thread.sleep(3000);
		     
		     driver.navigate().refresh();
		     Thread.sleep(6000);
		     
		      driver.findElement(By.id("stops0")).click();
		      Thread.sleep(3000);
		      driver.findElement(By.id("stops2")).click();
		      Thread.sleep(3000);
		      
		         final Screenshot screenshot04 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
			     final BufferedImage image04 = screenshot04.getImage();
			     ImageIO.write(image04, "PNG", new File("D:\\Ajit\\Script_SS\\LocalTravelport\\002_OnlyOnestop.png"));
			     Thread.sleep(3000);
			     
			     driver.navigate().refresh();
			     Thread.sleep(6000);
			     
			      driver.findElement(By.id("stops0")).click();
			      Thread.sleep(3000);
			      driver.findElement(By.id("stops1")).click();
			      Thread.sleep(3000);
			      
			         final Screenshot screenshot044 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
				     final BufferedImage image044 = screenshot044.getImage();
				     ImageIO.write(image044, "PNG", new File("D:\\Ajit\\Script_SS\\LocalTravelport\\0002_OnlyMultistop.png"));
				     Thread.sleep(3000);
		     
	  }
	  catch(Exception e)
	  {
		  Assert.assertFalse(false, "FAIL");
		  AssertJUnit.assertTrue("Something went wrong in Technical Stops...", lgnpge.isDisplayed());
	      AssertJUnit.assertTrue("Something went wrong in Technical Stops...", airbk.isDisplayed());
	      throw(e);
	  }
*/	         
	         driver.navigate().refresh();
	         Thread.sleep(9000);
	 
	         final Screenshot screenshot003 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
		     final BufferedImage image003 = screenshot003.getImage();
		     ImageIO.write(image003, "PNG", new File("D:\\Ajit\\Script_SS\\LocalDynamicPackagingAir\\3_Resultpage.png"));
		     
		     Thread.sleep(3000);
		     
		     //Price check on result page
		     String priceonrslt = driver.findElement(By.cssSelector("[id*='flight-summary_'] > div.pricebox.btn-container > span.flprice [class*='tot-price PkgPriceTotal']")).getText();
		     Reporter.log("Price on result page:- " +priceonrslt);

	         Thread.sleep(5000);
	   	         
     List<WebElement> options = driver.findElements(By.className("print-select-flight"));
     
  
     if(options.size()>0)
     {
          options.get(1).click();  // 1 for AmadeusWS or 2 for Sabre
     }
     else 
     {
			     System.out.println("Flight not available..");
			     
	             final Screenshot screenshot2 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
		         final BufferedImage image2 = screenshot2.getImage();
		         ImageIO.write(image2, "PNG", new File("D:\\Ajit\\Script_SS\\LocalDynamicPackagingAirError\\2_Flightnotavailable.png"));
			     
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
		      ImageIO.write(image3, "PNG", new File("D:\\Ajit\\Script_SS\\LocalDynamicPackagingAir\\4_Checkoutpage.png"));
  
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
         
         String priceonpurchase = driver.findElement(By.cssSelector("#trip_summary_package_total")).getText();
         Reporter.log("Price on purchasepage is:- "+ priceonpurchase);
         
         Thread.sleep(2000);
         
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
     System.out.println("Firstname_Of_Infunt4: " + Firstname_Of_Infunt4);
     System.out.println("Middlename_of_Infunt4:" + Middlename_of_Infunt4);
     System.out.println("Lastname_Of_Infunt4: " + Lastname_Of_Infunt4);
     System.out.println("Firstname_Of_SeatInfunt5: " + Firstname_Of_SeatInfunt5);
     System.out.println("Middlename_of_SeatInfunt5:" + Middlename_of_SeatInfunt5);
     System.out.println("Lastname_Of_SeatInfunt5: " + Lastname_Of_SeatInfunt5);
     System.out.println("Email: " + Email);
 //    System.out.println("ConEmail: " + ConEmail);
     System.out.println("Phone_No: " + Phone_No);
     System.out.println("Phone_No: " + DestinationPhone_No);
      
     chckout.TravelportpurchaseToTitle(Firstname_Of_Adult1,Middlename_of_Adult1, Lastname_Of_Adult1, Firstname_Of_Adult2,Middlename_of_Adult2, Lastname_Of_Adult2, Firstname_Of_Adult3,Middlename_of_Adult3, Lastname_Of_Adult3, Firstname_Of_Infunt4, Middlename_of_Infunt4, Lastname_Of_Infunt4, Firstname_Of_SeatInfunt5, Middlename_of_SeatInfunt5, Lastname_Of_SeatInfunt5, Email, ConEmail, Phone_No, DestinationPhone_No);
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
		 ImageIO.write(image4, "PNG", new File("D:\\Ajit\\Script_SS\\LocalDynamicPackagingAirError\\3_Timeout.png"));
	 
	     Assert.assertFalse(false, "FAIL");
	     Reporter.log("Time out..");
	     AssertJUnit.assertTrue("Time out...", chckout.isDisplayed());
	     throw(e); 	
}

try
{
  //Held Booking
  
      driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_HoldBTN")).click();
      Thread.sleep(30000);
      
      System.out.println("\n");
      System.out.println("Confirmationpage Logs..");
      System.out.println("\n");
      ExtractJSLogs();
      
      Thread.sleep(1000);
      
             
      final Screenshot screenshot12 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
      final BufferedImage image12 = screenshot12.getImage();
      ImageIO.write(image12, "PNG", new File("D:\\Ajit\\Script_SS\\LocalDynamicPackagingAir\\5_FlightHeld.png"));
      
      System.out.println("Flight Held successfully..");
       
      Reporter.log("Flight Held successfully..");  // For displaying message on report
       
      Thread.sleep(9000);
      
   
}
catch(Exception e)
{
	   System.out.println("\n");
	   System.out.println("Statusfail on confirmationpage Logs..");
	   System.out.println("\n");
	   ExtractJSLogs();
	 
	  final Screenshot screenshot44 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
      final BufferedImage image44 = screenshot44.getImage();
      ImageIO.write(image44, "PNG", new File("D:\\Ajit\\Script_SS\\LocalDynamicPackagingAirError\\5_Statusfail.png"));
	 
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
      ImageIO.write(image74, "PNG", new File("D:\\Ajit\\Script_SS\\LocalDynamicPackagingAir\\6_Paymentpage.png"));
      Thread.sleep(6000);
  	
  	// For Payment details
  	
      String priceonpaymnt = driver.findElement(By.cssSelector("#_ctl0_MainContentsPH__ctl0__ctl4_BillingAddressContainer > div.amount-to-charge-cont > a > span")).getText();
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
						
							 Thread.sleep(15000);	
							 
  }
  catch(Exception e)
  {
  	  final Screenshot screenshot94 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
      final BufferedImage image94 = screenshot94.getImage();
      ImageIO.write(image94, "PNG", new File("D:\\Ajit\\Script_SS\\LocalDynamicPackagingAirError\\6_Paymentdetails.png"));

        Assert.assertFalse(false, "FAIL");
        Reporter.log("Something went wrong...");
        AssertJUnit.assertTrue("Something went wrong...", chckout.isDisplayed());
        throw(e);
  }	
  
try
{
  	// For Payment details
      System.out.println("CardCvvNo: " + CardCvvNo);
      System.out.println("CardNo: " + CardNo);
      System.out.println("CardHolderName: " + CardHolderName);
      System.out.println("Address: " + Address);
      System.out.println("City: " + City);
      System.out.println("Zipcode: " + Zipcode);
      System.out.println("Phone_Number: " + Phone_Number);
      System.out.println("Bank_No: " + Bank_No);
     
      hldncnfrm.DynamicPaymentToTitle(CardCvvNo, CardNo, CardHolderName, Address, City, Zipcode, Phone_Number);
      long start78 = System.currentTimeMillis();  
          
      Thread.sleep(30000);
          
          long finish1117 = System.currentTimeMillis();
          long totalTime1117 = finish1117 - start78; 
          Reporter.log("Total Time for Payment page to Confirm booking page load(Milisec) - "+totalTime1117); 
          Thread.sleep(1000);
          
          System.out.println("\n");
          System.out.println("Confirm booking page Logs..");
          System.out.println("\n");
          ExtractJSLogs();              
          Thread.sleep(1000);
          
            final Screenshot screenshot76 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
            final BufferedImage image76 = screenshot76.getImage();
            ImageIO.write(image76, "PNG", new File("D:\\Ajit\\Script_SS\\LocalDynamicPackagingAir\\8_ConfirmBooking.png"));
            Thread.sleep(6000);
          
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
     ImageIO.write(image94, "PNG", new File("D:\\Ajit\\Script_SS\\LocalDynamicPackagingAirError\\7_Paymentpage.png"));

     Assert.assertFalse(false, "FAIL");
     Reporter.log("Something went wrong...");
     AssertJUnit.assertTrue("Something went wrong...", chckout.isDisplayed());
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
	      ImageIO.write(image11, "PNG", new File("D:\\Ajit\\Script_SS\\LocalDynamicPackagingAir\\9_Admindefaultpage.png"));

          Thread.sleep(7000); 

     //For Cross check booking
     driver.get("https://localhost/odyssey/admin/default.aspx");
     driver.navigate().refresh();
     driver.manage().window().maximize();

     Thread.sleep(4000);
     
     try
     {
    	 
        driver.findElement(By.className("manage_btn")).click();
        Thread.sleep(200);
        driver.findElement(By.xpath("//a[@class='crosscheck_icon show_True']")).click(); 
        Thread.sleep(25000);
        driver.switchTo().frame(driver.findElement(By.tagName("iframe")));

       Thread.sleep(10000);
       System.out.println("\n");
       System.out.println("Crosscheckbooking on admin defaultpage Logs..");
       System.out.println("\n");
       ExtractJSLogs();
	
       Thread.sleep(200);

          final Screenshot screenshot16 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	      final BufferedImage image16 = screenshot16.getImage();
	      ImageIO.write(image16, "PNG", new File("D:\\Ajit\\Script_SS\\LocalDynamicPackagingAir\\10_Crosscheckbookingpopup.png"));

driver.switchTo().defaultContent();
Thread.sleep(6000);
driver.navigate().refresh();

}catch(Exception e)
{
 System.out.println("\n");
 System.out.println("crosscheck booking fail on admin defaultpage Logs..");
 System.out.println("\n");
 ExtractJSLogs();

     final Screenshot screenshot17 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	 final BufferedImage image17 = screenshot17.getImage();
	 ImageIO.write(image17, "PNG", new File("D:\\Ajit\\Script_SS\\LocalDynamicPackagingAirError\\8_CrosscheckbookingFail.png"));
       
 Assert.assertFalse(false, "FAIL");
 Reporter.log("Booking cancel failed...");
 AssertJUnit.assertTrue("Booking cancel failed...", chckout.isDisplayed());
 return;
 
}
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
	      ImageIO.write(image16, "PNG", new File("D:\\Ajit\\Script_SS\\LocalDynamicPackagingAir\\10_Cancelbookingpopup.png"));

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
	 ImageIO.write(image17, "PNG", new File("D:\\Ajit\\Script_SS\\LocalDynamicPackagingAirError\\8_CancelbookingFail.png"));
       
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
		 	 ImageIO.write(image18, "PNG", new File("D:\\Ajit\\Script_SS\\LocalDynamicPackagingAirError\\9_CancelbookingstatusFail.png"));
	               
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
	     ImageIO.write(image19, "PNG", new File("D:\\Ajit\\Script_SS\\LocalDynamicPackagingAir\\12_Bookingcancelled.png"));
 
   System.out.println("Booking cancelled successfully..");
 
   Reporter.log("Booking cancelled successfully..");

   Thread.sleep(4000);

     
}


}

@DataProvider
public String[][] Authentication() throws Exception
{

  String[][] testObjArray = LocalTravelportUtils.getTableArray("D:\\Ajit\\Automation\\Workspace\\Odysseus_Product\\src\\main\\java\\testData\\LocalTravelportData.xlsx","Sheet1");

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
