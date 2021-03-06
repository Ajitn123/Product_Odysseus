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
import org.openqa.selenium.Keys;
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
import Utility.LocalDynamicPackagingUtils;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.screentaker.ViewportPastingStrategy;


public class LocalDynamicPackagingTest 
{
 
	   LocalDynamicPackagingLoginpgeobjct lgnpge;
	   LocalDynamicPackagingBookingpgeobjct airbk;
	   LocalDynamicPackagingPurchasepgobjct chckout;
	   LocalDynamicPackagingPaymentpgobjct hldncnfrm;
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
     String testResultFile="D:\\Ajit\\Script_SS\\ConsoleError\\Local_DynamicPackagingError.txt";
     File file = new File(testResultFile);  
     FileOutputStream fis = new FileOutputStream(file);  
     PrintStream out = new PrintStream(fis);  
     System.setOut(out); 
                   
     Thread.sleep(1000);
     
     final Screenshot screenshot01 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
     final BufferedImage image01 = screenshot01.getImage();
     ImageIO.write(image01, "PNG", new File("D:\\Ajit\\Script_SS\\LocalDynamicPackaging\\1_Loginpage.png"));

     //driver.navigate().to("https://localhost/odyssey/website/air/results.aspx?");
     Thread.sleep(4000);
     lgnpge = PageFactory.initElements(driver, LocalDynamicPackagingLoginpgeobjct.class);
     airbk = PageFactory.initElements(driver, LocalDynamicPackagingBookingpgeobjct.class);
     chckout = PageFactory.initElements(driver, LocalDynamicPackagingPurchasepgobjct.class);
     hldncnfrm = PageFactory.initElements(driver, LocalDynamicPackagingPaymentpgobjct.class);
      
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
public void Confirmlogin_data(String sUsername, String sPassword, String CardNo, String CardCvvNo, String CardHolderName) throws Exception
{
try
{  
	    //For web site and booking details
        Reporter.log("Website Name :- Ajit");
        Thread.sleep(200);
        Reporter.log("Cruise line :- Norwegian");
        Thread.sleep(900);
	    
 	    System.out.println("sUsername: " + sUsername);
        System.out.println("sPassword: " + sPassword);
                   
        lgnpge.DynamicToTittle(sUsername, sPassword);
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
    	      
	          final Screenshot screenshot1 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	          final BufferedImage image1 = screenshot1.getImage();
	          ImageIO.write(image1, "PNG", new File("D:\\Ajit\\Script_SS\\LocalDynamicPackagingError\\0_Invalidcredentials.png"));
	          
	          Assert.assertFalse(false, "FAIL");
	          Reporter.log("Username and Password are invalid..");
        	  AssertJUnit.assertTrue("Username Or Password are invalid...", lgnpge.isDisplayed());
        	  throw(e);
          	  
   }     
        
   try
   {
        airbk.DynamicBookingToTittle();
        long start = System.currentTimeMillis();
        
        final Screenshot screenshot = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
        final BufferedImage image = screenshot.getImage();
        ImageIO.write(image, "PNG", new File("D:\\Ajit\\Script_SS\\LocalDynamicPackaging\\2_Searchpage.png"));
        Thread.sleep(4000);
        
         System.out.println("\n");
        System.out.println("Searchpage Logs..");
        System.out.println("\n");
        ExtractJSLogs();
        Thread.sleep(350);
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
	      
	       final Screenshot screenshot1 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	       final BufferedImage image1 = screenshot1.getImage();
	       ImageIO.write(image1, "PNG", new File("D:\\Ajit\\Script_SS\\LocalDynamicPackagingError\\1_InvaliddetailsorError.png"));
	          
	       Assert.assertFalse(false, "FAIL");
	       Reporter.log("Invalid search details or displaying error message..");
 	       AssertJUnit.assertTrue("Invalid search details or displaying error message...", lgnpge.isDisplayed());
 	       throw(e);
 	   
   }
   
         Thread.sleep(11000);

    try
    {
   	 
   // For select dynamic cruise from result page
    
          driver.navigate().refresh();
  
          driver.get("https://localhost/odyssey/website/cruises/results.aspx?showtrace=true");

	       driver.manage().window().maximize();
	       
	       System.out.println("\n");
	       System.out.println("Resultpage Logs..");
	       System.out.println("\n");
	       ExtractJSLogs();
	       
	       Thread.sleep(3000);
	       
	       final Screenshot screenshot003 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
		   final BufferedImage image003 = screenshot003.getImage();
		   ImageIO.write(image003, "PNG", new File("D:\\Ajit\\Script_SS\\LocalDynamicPackaging\\3_Resultpage.png"));

	       Thread.sleep(7000);
	  
         // For select cruise 
	      driver.findElement(By.cssSelector("#PriceList_1 > div > ul.item-list-grid-alter > li.grid-btn.btn-container > a")).click();
	      long start = System.currentTimeMillis();
	      Thread.sleep(4000);
	      long finish = System.currentTimeMillis();
          long totalTime = finish - start; 
          Reporter.log("Total Time for result page to details page load(Milisec) - "+totalTime); 
          Thread.sleep(1000);
    }
    catch(Exception e)
    {
   	       final Screenshot screenshot800 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
           final BufferedImage image800 = screenshot800.getImage();
           ImageIO.write(image800, "PNG", new File("D:\\Ajit\\Script_SS\\LocalDynamicPackagingError\\03_Cruisenotselectedoravailable.png"));
       
	        Assert.assertFalse(false, "FAIL");
	        Reporter.log("Cruise not selected or available...");
	        AssertJUnit.assertTrue("Cruise not selected or available...", lgnpge.isDisplayed());
	        throw(e);
    }
          System.out.println("\n");
          System.out.println("Cruise detailspage Logs..");
          System.out.println("\n");
          ExtractJSLogs();              
          Thread.sleep(1000);
         
            final Screenshot screenshot3 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
		    final BufferedImage image3 = screenshot3.getImage();
		    ImageIO.write(image3, "PNG", new File("D:\\Ajit\\Script_SS\\LocalDynamicPackaging\\4_Detailspage.png"));
		    
		    Thread.sleep(2000);
		    
		  //For the Cruise details page
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
	                   driver.findElement(By.id("_ctl0_MainContentsPH__ctl0__ctl0_CategoryLNK")).click();
	                   Thread.sleep(500);
	                   
	                   long start = System.currentTimeMillis();
	                   System.out.println("\n");
	         	       System.out.println("Categorypage Logs..");
	         	       System.out.println("\n");
	         	       ExtractJSLogs();
	                   
	                   Thread.sleep(8000);
	                   long finish = System.currentTimeMillis();
	                   long totalTime = finish - start; 
	                   Reporter.log("Total Time for details page to category page load(Milisec) - "+totalTime); 
	                   Thread.sleep(1000);
	        }
	        catch(Exception e)
	        {
	                  	System.out.println("\n");
	         	        System.out.println("Invalid guest information on cruise detailspage Logs..");
	         	        System.out.println("\n");
	         	        ExtractJSLogs();
	          	 
	     	            final Screenshot screenshot80 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	     	            final BufferedImage image80 = screenshot80.getImage();
	     	            ImageIO.write(image80, "PNG", new File("D:\\Ajit\\Script_SS\\LocalDynamicPackagingError\\3_InvalidGuestinformation.png"));
	     	          
	          	        Assert.assertFalse(false, "FAIL");
	          	        Reporter.log("Invalid guest information's on detailspage...");
	          	        AssertJUnit.assertTrue("Invalid guest information's on detailspage...", lgnpge.isDisplayed());
	          	        throw(e);
	         }
	        
	        
	      // Verify error on category page
	      try
	      {
	           if(driver.findElement(By.cssSelector("#wrapper > div.content > div.content-area > div:nth-child(6) > div.stop.msg-notification > div.msg-notification-right > div > div > label")).isDisplayed())
	           {
	        	   String err = driver.findElement(By.cssSelector("#wrapper > div.content > div.content-area > div:nth-child(6) > div.stop.msg-notification > div.msg-notification-right > div > div > label")).getText();
	        	   Thread.sleep(1000);
	        	   Reporter.log("Error message: " +err);
	        	   Thread.sleep(500);
	        	   
	        	   final Screenshot screenshot82 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	               final BufferedImage image82 = screenshot82.getImage();
	               ImageIO.write(image82, "PNG", new File("D:\\Ajit\\Script_SS\\LocalDynamicPackagingError\\07_Error.png"));
	               Thread.sleep(1000);
	               AssertJUnit.assertTrue(" " +err, lgnpge.isDisplayed());
	               return;
	           }
	      }
	      catch(Exception e)
	      {
	    	  e.getMessage();
	      }
	      
	      try
	      {
	                 //For verify Suite category on category page
	       //          if(driver.findElement(By.cssSelector("#MainForm > div.cruise-detail-box > div.category-tab-content-box > div > ul > li:nth-child(1) > a > div > span:nth-child(2)")).isDisplayed())
	       //          {
	      //          	 driver.findElement(By.cssSelector("#MainForm > div.cruise-detail-box > div.category-tab-content-box > div > ul > li:nth-child(1) > a > div > span:nth-child(2)")).click();
	        //        	 Thread.sleep(1500);
	                	 
	                	 final Screenshot screenshot61 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	                     final BufferedImage image61 = screenshot61.getImage();
	                     ImageIO.write(image61, "PNG", new File("D:\\Ajit\\Script_SS\\LocalDynamicPackaging\\5_Categorypage.png"));
	                     Thread.sleep(3000);
	   /*                  	                     
	                     // For open price tab..
	                     driver.findElement(By.cssSelector("#category_4 > div:nth-child(1) > div.categoryview-price-gride > ul.categoryview-price-gride-even > li.btn-container > div.cat_price_container [class*='pricenow secondary-btn']")).click();
	                     Thread.sleep(2000);
	                     
	                     // Switch to new window opened
	                     String winHandleBefore = driver.getWindowHandle();
	                     
	                     for(String winHandle : driver.getWindowHandles())
	                     {
	                         driver.switchTo().window(winHandle);
	                     }
	                     
	                       final Screenshot screenshot63 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	                       final BufferedImage image63 = screenshot63.getImage();
	                       ImageIO.write(image63, "PNG", new File("D:\\Ajit\\Script_SS\\LocalDynamicPackaging\\6_PriceonCategorypage.png"));
	                       Thread.sleep(2000); 
	                     
	                       // For verify price on category price tab..
	                        String priceoncategorypage = driver.findElement(By.cssSelector("#PricesGTotal")).getText();
	                        Reporter.log("Price on category price tab:- " +priceoncategorypage);
	                        Thread.sleep(800);
	                        
	                 try
	                 {
	                        if(driver.findElement(By.cssSelector("#Res_PassengerPriceSummery > div.passenger-price-summary-bottom > ul:nth-child(2) > li:nth-child(2)")).isDisplayed())
	                        {
	                                 String Graduatyoncategorypage = driver.findElement(By.cssSelector("#Res_PassengerPriceSummery > div.passenger-price-summary-bottom > ul:nth-child(2) > li:nth-child(2)")).getText();
	                                 Reporter.log("Pre-Paid Gratuities (for 2 guests) on category price tab:- " +Graduatyoncategorypage);
	                                 Thread.sleep(800);
	                        }        
	                     
	                 }
	                 catch(Exception e)
	                 {
	                	 e.getMessage();
	                 }
	                        
	                     // Close the new window
	                        driver.close();
	                        
	                        driver.switchTo().window(winHandleBefore);
	                        
	     */
	                     // Select category..
	                	 driver.findElement(By.cssSelector("#category_2 > div:nth-child(5) > div.categoryview-price-gride > ul.categoryview-price-gride-even > li.btn-container > a")).sendKeys(Keys.ENTER);
	                	 long start = System.currentTimeMillis();
	                	 Thread.sleep(4500);
	                	 long finish = System.currentTimeMillis();
	                     long totalTime = finish - start; 
	                     Reporter.log("Total Time for category page to cabin selection page load(Milisec) - "+totalTime); 
	                     Thread.sleep(1000);
	           //      }
	                 //For verify Suite category on category page
	         /*        else if (driver.findElement(By.cssSelector("#MainForm > div > div.category-tab-content-box > div > ul > li:nth-child(4) > a > div > span.category-tab-content-img > img")).isDisplayed())
	                 {
	                 	 driver.findElement(By.cssSelector("#MainForm > div > div.category-tab-content-box > div > ul > li:nth-child(4) > a > div > span.category-tab-content-img > img")).click();
	                	 Thread.sleep(1000);
	                	 
	                	 final Screenshot screenshot62 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	                     final BufferedImage image62 = screenshot62.getImage();
	                     ImageIO.write(image62, "PNG", new File("D:\\Ajit\\Script_SS\\LocalDynamicPackaging\\6_Categorypage.png"));
	                     Thread.sleep(2000);
	                     
	                  // For open price tab..
	                     driver.findElement(By.cssSelector("#category_3 > div:nth-child(1) > div.categoryview-price-gride > ul.categoryview-price-gride-even > ul:nth-child(7) > li:nth-child(5) [class*='pricenow']")).click();
	                     Thread.sleep(3000);
	                     
	                     // Switch to new window opened
	                     String winHandleBefore = driver.getWindowHandle();
	                     
	                     for(String winHandle : driver.getWindowHandles())
	                     {
	                         driver.switchTo().window(winHandle);
	                     }
	                     
	                       final Screenshot screenshot63 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	                       final BufferedImage image63 = screenshot63.getImage();
	                       ImageIO.write(image63, "PNG", new File("D:\\Ajit\\Script_SS\\LocalDynamicPackaging\\6_PriceonCategorypage.png"));
	                       Thread.sleep(6000); 
	                     
	                       // For verify price on category price tab..
	                        String priceoncategorypage = driver.findElement(By.cssSelector("#PricesGTotal")).getText();
	                        Reporter.log("Price on category price tab:- " +priceoncategorypage);
	                        Thread.sleep(2000);
	                        
	                   //     String Graduatyoncategorypage = driver.findElement(By.cssSelector("#Res_PassengerPriceSummery > div.passenger-price-summary-bottom > ul:nth-child(2) > li:nth-child(2)")).getText();
	                   //     Reporter.log("Pre-Paid Gratuities (for 2 guests) on category price tab:- " +Graduatyoncategorypage);
	                   //     Thread.sleep(800);
	                     
	                       // Close the new window
	                        driver.close();
	                        
	                        driver.switchTo().window(winHandleBefore);
	                        
	                     // Select category
	                	 driver.findElement(By.xpath("//*[@id='category_4']/div[1]/div[4]/ul[2]/li[5]/a")).click();
	                	 long start = System.currentTimeMillis();
	                	 Thread.sleep(4000);
	                	 long finish = System.currentTimeMillis();
	                     long totalTime = finish - start; 
	                     Reporter.log("Total Time for category page to cabin selection page load(Milisec) - "+totalTime); 
	                     Thread.sleep(1000);
					 }
	       */          
	    }
	    catch (Exception e) 
	    {
	    	final Screenshot screenshot103 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
            final BufferedImage image103 = screenshot103.getImage();
            ImageIO.write(image103, "PNG", new File("D:\\Ajit\\Script_SS\\LocalDynamicPackagingError\\4_Categorynotavailable.png"));
     
            Assert.assertFalse(false, "FAIL");
            Reporter.log("Category not available..");
	        AssertJUnit.assertTrue("Category not available...", lgnpge.isDisplayed());
	        throw(e);
		}             
	                 
	                 System.out.println("\n");
	                 System.out.println("Cabin selection page Logs..");
	                 System.out.println("\n");
	                 ExtractJSLogs();              
	                 Thread.sleep(1000);
	     
	                 final Screenshot screenshot62 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	                 final BufferedImage image62 = screenshot62.getImage();
	                 ImageIO.write(image62, "PNG", new File("D:\\Ajit\\Script_SS\\LocalDynamicPackaging\\7_Cabinselectionpage.png"));

	                 System.out.println("Category selected successfully..");
	                  
	                 Thread.sleep(5000);
	                 
	                 //For the Cruise details print on test report
	                 String departport = driver.findElement(By.cssSelector("#wrapper > div.content > div.content-area > div.content-left > div.cruise-details-outer.res_cruise_details > div > div:nth-child(3) > ul > li:nth-child(3)")).getText();
	                 Reporter.log(" " +departport);
	                 Thread.sleep(500);
	                 String guest = driver.findElement(By.cssSelector("#wrapper > div.content > div.content-area > div.content-left > div.cruise-details-outer.res_cruise_details > div > div:nth-child(3) > ul > li:nth-child(6)")).getText();
	                 Reporter.log(" " +guest);
	                 Thread.sleep(800);
	                 String shp = driver.findElement(By.cssSelector("#wrapper > div.content > div.content-area > div.content-left > div.cruise-details-outer.res_cruise_details > div > div:nth-child(3) > ul > li:nth-child(1)")).getText();
	                 Reporter.log(" " +shp);
	                 Thread.sleep(500);
	                 String dstntn = driver.findElement(By.cssSelector("#wrapper > div.content > div.content-area > div.content-left > div.cruise-details-outer.res_cruise_details > div > div:nth-child(3) > ul > li:nth-child(2)")).getText();
	                 Reporter.log(" " +dstntn);
	                 Thread.sleep(400);
	                 String depart = driver.findElement(By.cssSelector("#wrapper > div.content > div.content-area > div.content-left > div.cruise-details-outer.res_cruise_details > div > div:nth-child(3) > ul > li:nth-child(4)")).getText();
	                 Reporter.log(" " + depart);
	                 Thread.sleep(400);
	                 String arrival = driver.findElement(By.cssSelector("#wrapper > div.content > div.content-area > div.content-left > div.cruise-details-outer.res_cruise_details > div > div:nth-child(3) > ul > li:nth-child(5)")).getText();
	                 Reporter.log(" " + arrival);
	                 Thread.sleep(400);
	                 String ctgory = driver.findElement(By.cssSelector("#wrapper > div.content > div.content-area > div.content-left > div.cruise-details-outer.res_cruise_details > div > div:nth-child(3) > ul > li:nth-child(7)")).getText();
	                 Reporter.log(" " + ctgory);
	                 Thread.sleep(400);
	      
	                //For verify price's on cabin page
	                 String priceoncabin= driver.findElement(By.cssSelector("#MainForm > div.cruise-detail-box > div.guest-top-right > div > span.item-list-price > em")).getText();
	                 System.out.println("Prices on cabin page is:- " +priceoncabin);
	                 Reporter.log("Prices on cabin page is:- " +priceoncabin);
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

	         
	         //For select cabin from the cabin selection page
	         try
	         {
	        	            driver.findElement(By.cssSelector("#Stateroom-price > div > ul:nth-child(2) > li.btn-container [id*='CabinBook_']")).click();
	        	            long start = System.currentTimeMillis();
	        	            Thread.sleep(1000);
	                        long finish = System.currentTimeMillis();
	                        long totalTime = finish - start; 
	                        Reporter.log("Total Time for cabin selection page to search customer page load(Milisec) - "+totalTime); 
	                        Thread.sleep(1000);
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
	                              ImageIO.write(image13, "PNG", new File("D:\\Ajit\\Script_SS\\LocalDynamicPackagingError\\4_Cabinnotavailable.png"));
	                       
	                              Assert.assertFalse(false, "FAIL");
	        	                  Reporter.log("Cabin not available..");
	        			          AssertJUnit.assertTrue("Cabin not available...", lgnpge.isDisplayed());
	        			          throw(e);
	          }
	                            
	                             System.out.println("Cabin selected successfully..");
	                             
	                             System.out.println("\n");
	                             System.out.println("Search Customer page Logs..");
	                             System.out.println("\n");
	                             ExtractJSLogs();              
	                             Thread.sleep(1000);
	                   
	                             final Screenshot screenshot102 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	                             final BufferedImage image102 = screenshot102.getImage();
	                             ImageIO.write(image102, "PNG", new File("D:\\Ajit\\Script_SS\\LocalDynamicPackaging\\8_SearchCustomerpage.png"));
	           
	                             Thread.sleep(4000);
	                             
	                // For Search & Select customer
	                try
	                {
	                	 driver.findElement(By.id("_ctl0_MainContent_fName")).click();
	                	 Thread.sleep(700);
	                	 driver.findElement(By.id("_ctl0_MainContent_fName")).sendKeys("monish");
	                	 Thread.sleep(800);
	                	 driver.findElement(By.id("_ctl0_MainContent_SearchBTN")).click();
	                	 Thread.sleep(3000);
	                	 
	                	 driver.findElement(By.cssSelector("#_ctl0_MainContent_CustResults__ctl1_SelectLinkButton > img")).click();
	                	 long start = System.currentTimeMillis();
	                	 Thread.sleep(4000);
	                	 long finish = System.currentTimeMillis();
	                     long totalTime = finish - start; 
	                     Reporter.log("Total Time for search customer page to purchase page load(Milisec) - "+totalTime); 
	                     Thread.sleep(1000);
	                }
	                catch(Exception e)
	                {
	                	e.getMessage();
	                }
	                
	               System.out.println("\n");
                   System.out.println("Purchase page Logs..");
                   System.out.println("\n");
                   ExtractJSLogs();              
                   Thread.sleep(1000);
	                
	               final Screenshot screenshot1002 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                   final BufferedImage image1002 = screenshot1002.getImage();
                   ImageIO.write(image1002, "PNG", new File("D:\\Ajit\\Script_SS\\LocalDynamicPackaging\\9_Purchasepage.png"));
                   Thread.sleep(2000);
                   
                  //Check price on purchase page
                   String priceonpurchase= driver.findElement(By.cssSelector("#PricesGTotal")).getText();
                   Reporter.log("Prices on purchase page is:- " +priceonpurchase);
                   Thread.sleep(2000);
                   
	          
	         
	         //For Purchase page                 
	          try
	          {
	                driver.findElement(By.cssSelector("#_ctl0_MainContentsPH__ctl0_GroupPassID_2")).click();
	                Thread.sleep(1000);
	                driver.findElement(By.cssSelector("#_ctl0_MainContentsPH__ctl0_GroupPassID_2 > option:nth-child(3)")).click();
	                Thread.sleep(3000);
	                
	                driver.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_ContinueLNK']")).click();
	                long start = System.currentTimeMillis();
	                Thread.sleep(5000);
	                long finish = System.currentTimeMillis();
                    long totalTime = finish - start; 
                    Reporter.log("Total Time for purchase page to confirmation page load(Milisec) - "+totalTime); 
                    Thread.sleep(1000);
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
	                                    ImageIO.write(image34, "PNG", new File("D:\\Ajit\\Script_SS\\LocalDynamicPackagingError\\5_InvalidGuestinfoonPurchasepage.png"));
	                                             
	                                    Assert.assertFalse(false, "FAIL");
	                              	    Reporter.log("Invalid guest information on purchase page, Please enter valid details for the required fields...");
	                              		AssertJUnit.assertTrue("Invalid guest information on purchase page, Please enter valid details for the required fields....", lgnpge.isDisplayed());
	                              		throw(e);
	             }
	                                                 
	                                    System.out.println("\n");
	                                    System.out.println("Confirmationpage Logs..");
	                                    System.out.println("\n");
	                                    ExtractJSLogs();              
	                                    Thread.sleep(1000);
	                                                    
	                                    final Screenshot screenshot44 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	                                    final BufferedImage image44 = screenshot44.getImage();
	                                    ImageIO.write(image44, "PNG", new File("D:\\Ajit\\Script_SS\\LocalDynamicPackaging\\10_Confirmationpage.png"));
	                                                    
	                                    Thread.sleep(2000);
	                                    
	             try
	             {
	                                    
	                                    //For Verify price on confirmation page
	                                    String priceoncon = driver.findElement(By.cssSelector("#PricesGTotal")).getText();
	                                    Reporter.log("Price on confirmationpage is:- "+ priceoncon);
	                                    Thread.sleep(1000);
	                                   
	                               try
	                               {
	                                    // Click on decline insurance
	                            	  if(driver.findElement(By.id("InsurranceCHK_NON")).isDisplayed())
	                            	  {
	                                    driver.findElement(By.id("InsurranceCHK_NON")).click();
	                                    Thread.sleep(2000);
	                                    driver.findElement(By.cssSelector("#DivTravlGuardPopup > div.inscontent > div.inscontentbox > div.button2 > a")).click();
	                                    Thread.sleep(2000);
	                            	  }  
	                               }
	                               catch(Exception e)
	                               {
	                            	   e.getMessage();
	                               }
	                               
	                               // Click on Held
	                               driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_HoldCruiseBTN")).click();
	                               Thread.sleep(12000);
	                               
	                               final Screenshot screenshot74 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                                   final BufferedImage image74 = screenshot74.getImage();
                                   ImageIO.write(image74, "PNG", new File("D:\\Ajit\\Script_SS\\LocalDynamicPackaging\\11_Paymentpage.png"));
                                   Thread.sleep(4000);
	                               
	                                    
	                                    // For click on Full payment button
	                                    driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_ConfirmBkgBTN")).click();
	                                    long start = System.currentTimeMillis();
	                                    Thread.sleep(6000);
	                                    long finish = System.currentTimeMillis();
	                                    long totalTime = finish - start; 
	                                    Reporter.log("Total Time for confirmation page to payment page load(Milisec) - "+totalTime); 
	                                    Thread.sleep(1000);
	                                    
	                                    System.out.println("\n");
	                                    System.out.println("Paymentpage Logs..");
	                                    System.out.println("\n");
	                                    ExtractJSLogs();              
	                                    Thread.sleep(1000);
	                                    
	                                    String priceonpaymnt = driver.findElement(By.cssSelector("#PaymentAmountToPay")).getText();
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
	                    							         
	                   							 Thread.sleep(1500);
	                   							 
	                   							 if(priceonpaymnt.equals(priceoncon))
	                                             {
	                                                          	
	                                                    System.out.println("Confirmation and Payment page's Price matched");
	                                                    Reporter.log("Confirmation and Payment page's Price matched..");
	                                                          	 
	                                                    System.out.println("Actual price is:- " +priceoncon);
	                          							 Reporter.log("Actual price is:- " +priceoncon);
	                                              }
	                                              else
	                                              {
	                          							  System.out.println("Confirmation and Payment page's Price not match..");
	                          							  Reporter.log("Confirmation and Payment page's Price not match..");
	                          							  System.out.println("Actual price is:- " +priceoncon);
	                          							  Reporter.log("Actual price is:- " +priceoncon);
	                          					   }
	                           							         
	                          							 Thread.sleep(1500);	
	                          							 
	                        
	                        try
	                        {
	                          	// For Payment details
	                              System.out.println("CardNo: " + CardNo);
	                              System.out.println("CardCvvNo: " + CardCvvNo);
	                              System.out.println("CardHolderName: " + CardHolderName);
	                         //     System.out.println("Address: " + Address);
	                         //     System.out.println("City: " + City);
	                         //     System.out.println("Zipcode: " + Zipcode);
	                         //     System.out.println("Phone_Number: " + Phone_Number);
	                         //   System.out.println("BankName: " + BankName);
	                             
	                              hldncnfrm.DynamicPaymentToTitle(CardNo, CardCvvNo, CardHolderName);
	                              Thread.sleep(2500);
	                              long start78 = System.currentTimeMillis();  
	                                 
	                              // Click on payment button
	                              driver.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_ContinueLNK']")).click();
	                              
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
	                          ImageIO.write(image94, "PNG", new File("D:\\Ajit\\Script_SS\\LocalDynamicPackagingError\\10_Paymentpage.png"));
	                  
	                            Assert.assertFalse(false, "FAIL");
	            	            Reporter.log("Something went wrong...");
	            	            AssertJUnit.assertTrue("Something went wrong...", hldncnfrm.isDisplayed());
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
	             		      ImageIO.write(image11, "PNG", new File("D:\\Ajit\\Script_SS\\LocalDynamicPackaging\\17_Admindefaultpage.png"));
	                        
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
	            	 	      ImageIO.write(image16, "PNG", new File("D:\\Ajit\\Script_SS\\LocalDynamicPackaging\\19_Cancelbookingpopup.png"));
	              	    
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
	            		 	 ImageIO.write(image17, "PNG", new File("D:\\Ajit\\Script_SS\\LocalDynamicPackagingError\\13_CancelbookingFail.png"));
	            	               
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
	                				
	                 		         final Screenshot screenshot18 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	                			 	 final BufferedImage image18 = screenshot18.getImage();
	                			 	 ImageIO.write(image18, "PNG", new File("D:\\Ajit\\Script_SS\\LocalDynamicPackagingError\\14_CancelbookingstatusFail.png"));
	                		               
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
	            			     ImageIO.write(image19, "PNG", new File("D:\\Ajit\\Script_SS\\LocalDynamicPackaging\\20_Bookingcancelled.png"));
	                         
	                           System.out.println("Booking cancelled successfully..");
	                         
	                           Reporter.log("Booking cancelled successfully..");
	                        
	                           Thread.sleep(4000);
	                          							 
	                          							 
	                          							 
	              }     							 
	              catch (Exception e) 
	              {
	            	  final Screenshot screenshot94 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	                  final BufferedImage image94 = screenshot94.getImage();
	                  ImageIO.write(image94, "PNG", new File("D:\\Ajit\\Script_SS\\LocalDynamicPackagingError\\15_Paymentpage.png"));
	                  
	                  Assert.assertFalse(false, "FAIL");
	            	  Reporter.log("Something went wrong...");
	            	  AssertJUnit.assertTrue("Something went wrong...", lgnpge.isDisplayed());
	            	  throw(e);
				  }                        
         
     }
   

@DataProvider
public String[][] Authentication() throws Exception
{

	     String[][] testObjArray = LocalDynamicPackagingUtils.getTableArray("D:\\Ajit\\Automation\\Workspace\\Odysseus_Product\\src\\main\\java\\testData\\LocalDynamicPackagingData.xlsx","Sheet1");

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
