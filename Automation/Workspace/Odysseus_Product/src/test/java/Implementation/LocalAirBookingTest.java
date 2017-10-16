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
import Utility.LocalAirBookingUtils;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.screentaker.ViewportPastingStrategy;


public class LocalAirBookingTest 
{
	  
	   AirLocalLoginPgeobjct lgnpge;
	   LocalAirBookingpgeobjectforOdysseus airbk;
	   LocalAirCheckoutpageobjct chckout;
	   LocalCruisePaymentpgeobjct hldncnfrm;
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
        String testResultFile="D:\\Ajit\\Script_SS\\ConsoleError\\Local_AirbookingError.txt";
        File file = new File(testResultFile);  
        FileOutputStream fis = new FileOutputStream(file);  
        PrintStream out = new PrintStream(fis);  
        System.setOut(out); 
                      
        Thread.sleep(1000);
        
        final Screenshot screenshot01 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
        final BufferedImage image01 = screenshot01.getImage();
        ImageIO.write(image01, "PNG", new File("D:\\Ajit\\Script_SS\\LocalAirBooking\\1_Loginpage.png"));

        //driver.navigate().to("https://localhost/odyssey/website/air/results.aspx?");
        Thread.sleep(4000);
        lgnpge = PageFactory.initElements(driver, AirLocalLoginPgeobjct.class);
        airbk = PageFactory.initElements(driver, LocalAirBookingpgeobjectforOdysseus.class);
        chckout = PageFactory.initElements(driver, LocalAirCheckoutpageobjct.class);
        hldncnfrm = PageFactory.initElements(driver, LocalCruisePaymentpgeobjct.class);
   
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
public void Confirmlogin_data(String sUsername, String sPassword, String FromLocation, String ToLocation, String Firstname_Of_Adult1, String Middlename_of_Adult1, String Lastname_Of_Adult1, String Firstname_Of_Adult2, String Middlename_of_Adult2, String Lastname_Of_Adult2, String Firstname_Of_Adult3, String Middlename_of_Adult3, String Lastname_Of_Adult3, String Email, String Phone_No, String CardHolderName, String CardNo, String CardCvvNo,  String Address, String City, String Zipcode, String Phone_Number, String Bank_Name) throws Exception
{
   try
   {  
   	 Reporter.log("Website Name:- Ajit");
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
        
        airbk.AirBookingToTitle(FromLocation, ToLocation);
        
        System.out.println("\n");
        System.out.println("Searchpage Logs..");
        System.out.println("\n");
        ExtractJSLogs();
 /* 
        final Screenshot screenshot = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
        final BufferedImage image = screenshot.getImage();
        ImageIO.write(image, "PNG", new File("D:\\Ajit\\Script_SS\\LocalAirBooking\\2_Searchpage.png"));
  */   
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
	          ImageIO.write(image1, "PNG", new File("D:\\Ajit\\Script_SS\\LocalAirBookingError\\1_Invalidcredentials.png"));
	          
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
		     ImageIO.write(image003, "PNG", new File("D:\\Ajit\\Script_SS\\LocalAirBooking\\3_Resultpage.png"));
 
	         Thread.sleep(7000);
	   	         
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
		         ImageIO.write(image2, "PNG", new File("D:\\Ajit\\Script_SS\\LocalAirBookingError\\2_Flightnotavailable.png"));
			     
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
		      ImageIO.write(image3, "PNG", new File("D:\\Ajit\\Script_SS\\LocalAirBooking\\4_Checkoutpage.png"));
      
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
             String priceonpurchase = driver.findElement(By.cssSelector("")).getText();
             Reporter.log("Price on purchase page :- " +priceonpurchase);
             Thread.sleep(3000);
             
             
   try   
   {
         //For Checkout page
   	
	     System.out.println("Firstname_Of_Adult1: " + Firstname_Of_Adult1);
         System.out.println("Middlename_of_Adult1:" + Middlename_of_Adult1);
         System.out.println("Lastname_Of_Adult1: " + Lastname_Of_Adult1);
     //    System.out.println("Phone_No: " + DestinationPhone_No);
         System.out.println("Firstname_Of_Adult2: " + Firstname_Of_Adult2);
         System.out.println("Middlename_of_Adult2:" + Middlename_of_Adult2);
         System.out.println("Lastname_Of_Adult2: " + Lastname_Of_Adult2);
         System.out.println("Firstname_Of_Adult3: " + Firstname_Of_Adult3);
         System.out.println("Middlename_of_Adult3:" + Middlename_of_Adult3);
         System.out.println("Lastname_Of_Adult3: " + Lastname_Of_Adult3);
         System.out.println("Email: " + Email);
         System.out.println("Phone_No: " + Phone_No);
  //       System.out.println("Email: " + CardHolderName);
   //      System.out.println("Phone_No: " + CardNo);
   //      System.out.println("Email: " + CardCvvNo);
    //     System.out.println("Phone_No: " + Address);
    //     System.out.println("Email: " + City);
     //    System.out.println("Phone_No: " + Zipcode);
    //     System.out.println("Email: " + Phone_Number);
    //     System.out.println("Email: " + Bank_Name);
        
           
         chckout.ConfirmToTitle(Firstname_Of_Adult1, Middlename_of_Adult1, Lastname_Of_Adult1, Firstname_Of_Adult2, Middlename_of_Adult2, Lastname_Of_Adult2, Firstname_Of_Adult3,Middlename_of_Adult3, Lastname_Of_Adult3, Email, Phone_No, CardHolderName, CardNo, CardCvvNo, Address, City, Zipcode, Phone_Number, Bank_Name);
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
		 ImageIO.write(image4, "PNG", new File("D:\\Ajit\\Script_SS\\LocalAirBookingError\\3_Timeout.png"));
 	 
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
      	Thread.sleep(7000);
      	
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
    ExtractJSLogs();
	
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
     ExtractJSLogs();
  
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
