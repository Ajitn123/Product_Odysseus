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
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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
import Utility.LocalCruiseUtils;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.screentaker.ViewportPastingStrategy;


public class LocalCruiseBookingTest 
{

	  
	    LocalCruisebkngLoginpgobjct crsbkng;
	    LocalCruisebkngpgeobjct crsbkngpge;
	    LocalCruisePaymentpgeobjct hldncnfrm;
	    DLCPurchasepgeobjct crspurchpge;
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
     driver.get("https://localhost/odyssey/admin/login.aspx");
     Thread.sleep(2000);

     //Save console
     String testResultFile="D:\\Ajit\\Script_SS\\ConsoleError\\LocalCruiseBookingError.txt";
     File file = new File(testResultFile);  
     FileOutputStream fis = new FileOutputStream(file);  
     PrintStream out = new PrintStream(fis);  
     System.setOut(out); 
          
     Thread.sleep(1000);

     final Screenshot screenshot1 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
     final BufferedImage image1 = screenshot1.getImage();
     ImageIO.write(image1, "PNG", new File("D:\\Ajit\\Script_SS\\LocalCruisebkng\\1_Searchpage.png"));
     Thread.sleep(1000);
     System.out.println("\n");
     System.out.println("Searchpage Logs..");
     System.out.println("\n");
     ExtractJSLogs();
    
     Thread.sleep(4000);
     crsbkngpge = PageFactory.initElements(driver, LocalCruisebkngpgeobjct.class);
     crsbkng = PageFactory.initElements(driver, LocalCruisebkngLoginpgobjct.class);
     hldncnfrm = PageFactory.initElements(driver, LocalCruisePaymentpgeobjct.class);
     crspurchpge = PageFactory.initElements(driver, DLCPurchasepgeobjct.class);  
 
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
 public void DLC_data(String sUsername, String sPassword, String Firstname_GuestOne, String Middlename_GuestOne, String Lastname_GuestOne, String Email, String Street_Address, String Cty, String Zpcode, String Phone, String Firstname_GuestTwo, String Middlename_GuestTwo, String Lastname_GuestTwo, String CardNo, String CardCvvNo, String CardHolderName, String Address, String City, String Zipcode, String Phone_Number, String BankName) throws Exception
 {
	
 	   try
       {
 		    System.out.println("sUsername: " + sUsername);
	        System.out.println("sPassword: " + sPassword);
 		    crsbkng.CruiseLoginToTittle(sUsername, sPassword);
 		    
		     //For web site and booking details
      //      Reporter.log("Website Name :- Ajit Website");
      //      Thread.sleep(200);
            
            Reporter.log("Affiliate Name :- Odysseus Template");
            Thread.sleep(200);
		 
		     Reporter.log("Cruise line :- Norwegian");
		     Thread.sleep(1500);
		     
		     Reporter.log("Cruise Ships :- Epic");
		     Thread.sleep(1500);
		 
    	     crsbkngpge.LocalBookingToTittle();
    	     long start = System.currentTimeMillis();
    	     
    	     Thread.sleep(4000);
    	     long finish = System.currentTimeMillis();
             long totalTime = finish - start; 
             Reporter.log("Total Time for serch page to result page load(Milisec) - "+totalTime); 
             Thread.sleep(1000);
    	     System.out.println("\n");
	         System.out.println("Resultpage Logs..");
	         System.out.println("\n");
	         ExtractJSLogs();
	        
             Thread.sleep(1000);
            
	        final Screenshot screenshot4 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
            final BufferedImage image4 = screenshot4.getImage();
            ImageIO.write(image4, "PNG", new File("D:\\Ajit\\Script_SS\\LocalCruisebkng\\2_Resultpage.png"));
            Thread.sleep(2000);
            
            driver.findElement(By.xpath("//*[@id='CruiseSearchForm_tab2']/div[2]/div[3]/div/input")).click();
        
            Thread.sleep(6000);
         
     }
     catch(Exception e)
     {
    	     System.out.println("\n");
	         System.out.println("Time out or Invalid search criteria on resultpage Logs..");
	         System.out.println("\n");
	         ExtractJSLogs();
	 
	         final Screenshot screenshot33 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	         final BufferedImage image33 = screenshot33.getImage();
	         ImageIO.write(image33, "PNG", new File("D:\\Ajit\\Script_SS\\LocalCruisebkngError\\1_TimeoutORinvalidsearchdetails.png"));
	          
	         Assert.assertFalse(false, "FAIL");
	         Reporter.log("Time out or Invalid search criteria on resultpage..");
	         AssertJUnit.assertTrue("Time out or Invalid search criteria on resultpage...", crsbkngpge.isDisplayed());
	         throw(e);
     }
 	
 	   //For Select cruise from result page
     try
     {
                   driver.navigate().refresh();
                   
                   driver.get("https://localhost/odyssey/website/cruises/results.aspx?showtrace=true");
                    
                   Thread.sleep(4000);  
                          
                   // For the bonus offers
                   if(driver.findElement(By.cssSelector("#PriceList_0 > div > ul.item-list-grid-normal > li.grid-bonus.res_grid_bonus > a:nth-child(9) > img")).isDisplayed())
                   {
                   	    Reporter.log("Bonus Offers are available..");
                   	    driver.findElement(By.cssSelector("#PriceList_0 > div > ul.item-list-grid-normal > li.grid-bonus.res_grid_bonus > a:nth-child(9) > img")).click();
                        Thread.sleep(1500);
                       
                          File scr22 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
         	              org.codehaus.plexus.util.FileUtils.copyFile(scr22, new File("D:\\Ajit\\Script_SS\\LocalCruisebkng\\3_Bonusoffers.png")); 
                       
                          Thread.sleep(4000);
                       
                   	      driver.navigate().refresh();
                   	      Thread.sleep(4000);
                   }
                   
                   
                      driver.findElement(By.cssSelector("#PriceList_1 > div > ul.item-list-grid-normal > li.grid-btn [class*='booknow res_Cruise_detai_mo']")).click();  // Select cruise i.e 0,1,2,3...10                      
	      }                                                
	      catch(Exception e)
	      {
    	         System.out.println("Cruise not available..");
    	         System.out.println("\n");
    	         System.out.println("Cruise not available on resultpage Logs..");
    	         System.out.println("\n");
    	         ExtractJSLogs();
       
              final Screenshot screenshot5 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
              final BufferedImage image5 = screenshot5.getImage();
              ImageIO.write(image5, "PNG", new File("D:\\Ajit\\Script_SS\\LocalCruisebkngError\\2_Cruisenotavailable.png"));
       
                Assert.assertFalse(false, "FAIL");
                Reporter.log("Cruise not available..");
		        AssertJUnit.assertTrue("Cruise not available...", crsbkngpge.isDisplayed());
		        throw(e);
	       }
             long start = System.currentTimeMillis();  
             Thread.sleep(2000); 
    
             System.out.println("\n");
             System.out.println("Cruise detailspage Logs..");
             System.out.println("\n");
             ExtractJSLogs();              
             Thread.sleep(1000);
             long finish = System.currentTimeMillis();
             long totalTime = finish - start; 
             Reporter.log("Total Time for result page to details page load(Milisec) - "+totalTime); 
             Thread.sleep(1000);
             
             final Screenshot screenshot60 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
             final BufferedImage image60 = screenshot60.getImage();
             ImageIO.write(image60, "PNG", new File("D:\\Ajit\\Script_SS\\LocalCruisebkng\\4_Cruisedetailspage.png"));

             System.out.println("Cruise selected successfully..");
              
             Thread.sleep(4000);
             
      
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
                 Thread.sleep(1500);
                 
                 
      }
      catch(Exception e)
      {
                System.out.println("\n");
       	        System.out.println("Invalid guest information on cruise detailspage Logs..");
       	        System.out.println("\n");
       	        ExtractJSLogs();
        	 
   	            final Screenshot screenshot80 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
   	            final BufferedImage image80 = screenshot80.getImage();
   	            ImageIO.write(image80, "PNG", new File("D:\\Ajit\\Script_SS\\LocalCruisebkngError\\3_InvalidGuestinformation.png"));
   	          
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
             ImageIO.write(image82, "PNG", new File("D:\\Ajit\\Script_SS\\LocalCruisebkngError\\07_Error.png"));
             Thread.sleep(1000);
             AssertJUnit.assertTrue(" " +err, crsbkngpge.isDisplayed());
             return;
         }
    }
    catch(Exception e)
    {
  	  e.getMessage();
    }
    
               //For verify Balcony category on category page
               if(driver.findElement(By.cssSelector("#MainForm > div > div.category-tab-content-box > div > ul > li:nth-child(3) > a > div > span:nth-child(2)")).isDisplayed())
               {
              	 driver.findElement(By.cssSelector("#MainForm > div > div.category-tab-content-box > div > ul > li:nth-child(3) > a > div > span:nth-child(2)")).click();
              	 Thread.sleep(1500);
              	 
              	   final Screenshot screenshot61 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                   final BufferedImage image61 = screenshot61.getImage();
                   ImageIO.write(image61, "PNG", new File("D:\\Ajit\\Script_SS\\LocalCruisebkng\\5_Categorypage.png"));
                   Thread.sleep(3000);
                   
                // For open price tab..
                   driver.findElement(By.cssSelector("#category_3 > div:nth-child(1) > div.categoryview-price-gride > ul.categoryview-price-gride-even > li.btn-container > div.cat_price_container [class*='pricenow secondary-btn']")).click(); 
                   Thread.sleep(3000);
                   
                   // Switch to new window opened
                   String winHandleBefore = driver.getWindowHandle();
                   
                   for(String winHandle : driver.getWindowHandles())
                   {
                       driver.switchTo().window(winHandle);
                   }
                   
                     final Screenshot screenshot63 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                     final BufferedImage image63 = screenshot63.getImage();
                     ImageIO.write(image63, "PNG", new File("D:\\Ajit\\Script_SS\\LocalCruisebkng\\6_PriceonCategorypage.png"));
                     Thread.sleep(2000); 
                   
                     // For verify price on category price tab..
                      String priceoncategorypage = driver.findElement(By.cssSelector("#TotalDueWithoutPrepaidGrats")).getText();
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
                   
                   // Select category   
              	   driver.findElement(By.cssSelector("#category_3 > div:nth-child(1) > div.categoryview-price-gride > ul.categoryview-price-gride-even > li:nth-child(5) [class*='booknow']")).click();
              	   long start2 = System.currentTimeMillis();
              	   Thread.sleep(4000);
              	   long finish01 = System.currentTimeMillis();
                   long totalTime01 = finish01 - start2; 
                   Reporter.log("Total Time for category page to cabin selection page load(Milisec) - "+totalTime01); 
                   Thread.sleep(1000);
               }
               //For verify Suite category on category page
               else if (driver.findElement(By.cssSelector("#MainForm > div > div.category-tab-content-box > div > ul > li:nth-child(3) > a > div > span:nth-child(2)")).isDisplayed())
               {
               	  driver.findElement(By.cssSelector("#MainForm > div > div.category-tab-content-box > div > ul > li:nth-child(3) > a > div > span:nth-child(2)")).click();
              	  Thread.sleep(1000);
              	 
              	   final Screenshot screenshot62 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                   final BufferedImage image62 = screenshot62.getImage();
                   ImageIO.write(image62, "PNG", new File("D:\\Ajit\\Script_SS\\LocalCruisebkng\\6_Categorypage.png"));
                   Thread.sleep(2000);
                   
                // For open price tab..
                   driver.findElement(By.cssSelector("#category_3 > div:nth-child(1) > div.categoryview-price-gride > ul.categoryview-price-gride-even > ul:nth-child(7) > li:nth-child(5) [class*='pricenow']")).click();
                   Thread.sleep(2000);
                   
                   // Switch to new window opened
                   String winHandleBefore = driver.getWindowHandle();
                   
                   for(String winHandle : driver.getWindowHandles())
                   {
                       driver.switchTo().window(winHandle);
                   }
                   
                     final Screenshot screenshot63 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                     final BufferedImage image63 = screenshot63.getImage();
                     ImageIO.write(image63, "PNG", new File("D:\\Ajit\\Script_SS\\OdysolCruise\\6_PriceonCategorypage.png"));
                     Thread.sleep(2000); 
                   
                     // For verify price on category price tab..
                      String priceoncategorypage = driver.findElement(By.cssSelector("#PricesGTotal")).getText();
                      Reporter.log("Price on category price tab:- " +priceoncategorypage);
                      Thread.sleep(800);
                      
                      String Graduatyoncategorypage = driver.findElement(By.cssSelector("#Res_PassengerPriceSummery > div.passenger-price-summary-bottom > ul:nth-child(2) > li:nth-child(2)")).getText();
                      Reporter.log("Pre-Paid Gratuities (for 2 guests) on category price tab:- " +Graduatyoncategorypage);
                      Thread.sleep(800);
                   
                   // Close the new window
                      driver.close();
                      
                      driver.switchTo().window(winHandleBefore);
                   
                   // Select category   
              	   driver.findElement(By.cssSelector("[id*='category_1'] > div.categoryview-container > div.categoryview-price-gride > ul.categoryview-price-gride-even > li.btn-container [class*='booknow primary-btn']")).click();
              	   long start022 = System.currentTimeMillis(); 
              	   Thread.sleep(4000);
              	   long finish011 = System.currentTimeMillis();
                   long totalTime011 = finish011 - start022; 
                   Reporter.log("Total Time for category page to cabin selection page load(Milisec) - "+totalTime011); 
                   Thread.sleep(1000);
                   
				 }
               
               
               System.out.println("\n");
               System.out.println("Cabin selection page Logs..");
               System.out.println("\n");
               ExtractJSLogs();              
               Thread.sleep(1000);
    
               final Screenshot screenshot62 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
               final BufferedImage image62 = screenshot62.getImage();
               ImageIO.write(image62, "PNG", new File("D:\\Ajit\\Script_SS\\LocalCruisebkng\\7_Cabinselectionpage.png"));

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
               String priceoncabin= driver.findElement(By.cssSelector("#MainForm > div > div.guest-top-right > div > span.item-list-price > em")).getText();
               System.out.println("Prices on cabin page is:- " +priceoncabin);
               Reporter.log("Prices on cabin page is:- " +priceoncabin);
               Thread.sleep(2000);
           //    String taxoncabin= driver.findElement(By.cssSelector("#MainForm > div > div.guest-top-right > div > span.cat-taxamt")).getText();
           //    System.out.println(" " +taxoncabin);
          //     Reporter.log(" " +taxoncabin);
           //    Thread.sleep(2000);
               
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
      	              driver.findElement(By.cssSelector("[id*='CabinBook_']")).click();
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
                            ImageIO.write(image13, "PNG", new File("D:\\Ajit\\Script_SS\\LocalCruisebkngError\\4_Cabinnotavailable.png"));
                     
                          Assert.assertFalse(false, "FAIL");
      	                  Reporter.log("Cabin not available..");
      			          AssertJUnit.assertTrue("Cabin not available...", crsbkngpge.isDisplayed());
      			          throw(e);
        }
                           long start3 = System.currentTimeMillis();
                           System.out.println("\n");
                           System.out.println("Search customer page Logs..");
                           System.out.println("\n");
                           ExtractJSLogs();              
                           Thread.sleep(1000);
                 
                           final Screenshot screenshot102 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                           final BufferedImage image102 = screenshot102.getImage();
                           ImageIO.write(image102, "PNG", new File("D:\\Ajit\\Script_SS\\LocalCruisebkng\\8_Purchasepage.png"));
         
                           System.out.println("Cabin selected successfully..");
                 
                           Thread.sleep(4000);
                           long finish111 = System.currentTimeMillis();
                           long totalTime111 = finish111 - start3; 
                           Reporter.log("Total Time for cabin selection page to search customer page load(Milisec) - "+totalTime111); 
                           Thread.sleep(1000);
             /*              
                           //Check price on purchase page
                           String priceonpurchase= driver.findElement(By.cssSelector("#PricesGTotal")).getText();
                           System.out.println("Prices on purchase page is:- " +priceonpurchase);
                           Reporter.log("Prices on purchase page is:- " +priceonpurchase);
                           Thread.sleep(2000);
          */  
             // For the search customer page               
             try
             {
                  driver.findElement(By.cssSelector("#_ctl0_MainContent_fName")).sendKeys("monish");
                  Thread.sleep(700);
                  driver.findElement(By.cssSelector("#_ctl0_MainContent_SearchBTN")).click();
                  Thread.sleep(3000);
                  driver.findElement(By.cssSelector("#_ctl0_MainContent_CustResults__ctl1_SelectLinkButton > img")).click();
                  
             }
             catch(Exception e)
             {
            	 e.getMessage();
             }
   
             /*              
                           try
                           {
                                                      System.out.println("FirstName_Of_Guest1: " + Firstname_GuestOne);
                                                      System.out.println("MiddleName_Of_Guest1: " + Middlename_GuestOne);
                                                      System.out.println("LastName_Of_Guest1: " + Lastname_GuestOne);
                                                      System.out.println("Email: " + Email);
                                                      System.out.println("Email: " + Street_Address);
                                                      System.out.println("Email: " + Cty);
                                                      System.out.println("Email: " + Zpcode);
                                                      System.out.println("Phone: " + Phone);
                                                      System.out.println("FirstName_Of_Guest2: " + Firstname_GuestTwo);
                                                      System.out.println("MiddleName_Of_Guest2: " + Middlename_GuestTwo);
                                                      System.out.println("Lastname_of_Guest2: " + Lastname_GuestTwo);
                                                                 	                                	 
                                                      crspurchpge.DLCPurchaseToTittle(Firstname_GuestOne, Middlename_GuestOne, Lastname_GuestOne, Email, Street_Address, Cty, Zpcode, Phone, Firstname_GuestTwo, Middlename_GuestTwo, Lastname_GuestTwo);
                                                      
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
                                                      ImageIO.write(image34, "PNG", new File("D:\\Ajit\\Script_SS\\LocalCruisebkngError\\5_InvalidGuestinfoonPurchasepage.png"));
                                                               
                                                        Assert.assertFalse(false, "FAIL");
                                                	    Reporter.log("Invalid guest information on purchase page, Please enter valid details for the required fields...");
                                                		AssertJUnit.assertTrue("Invalid guest information on purchase page, Please enter valid details for the required fields....", crspurchpge.isDisplayed());
                                                		throw(e);
                               } 
               */
             
           //For Purchase page                 
             try
             {
                          driver.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_GroupPassID_2']")).click();
                          Thread.sleep(1000);
                          driver.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_GroupPassID_2']/option[8]")).click();
                          Thread.sleep(5000);
                          
                          final Screenshot screenshot1002 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                          final BufferedImage image1002 = screenshot1002.getImage();
                          ImageIO.write(image1002, "PNG", new File("D:\\Ajit\\Script_SS\\LocalCruisebkng\\08_Purchasepage.png"));
        
                          
                          driver.findElement(By.cssSelector("#_ctl0_MainContentsPH__ctl0_ContinueLNK")).click();  // Click on Hold
                          Thread.sleep(8000);
                          
                          if(envrnmnt.toLowerCase().trim().equals("test"))
                          {
                              driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_HoldCruiseBTN")).click();  // Click on Hold
                              Thread.sleep(8000);
                          }            
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
                                      ImageIO.write(image34, "PNG", new File("D:\\Ajit\\Script_SS\\LocalCruisebkngError\\5_InvalidGuestinfoonPurchasepage.png"));
                                               
                                        Assert.assertFalse(false, "FAIL");
                                	    Reporter.log("Invalid guest information on purchase page, Please enter valid details for the required fields...");
                                		AssertJUnit.assertTrue("Invalid guest information on purchase page, Please enter valid details for the required fields....", crsbkng.isDisplayed());
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
   
                        final Screenshot screenshot103 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                        final BufferedImage image103 = screenshot103.getImage();
                        ImageIO.write(image103, "PNG", new File("D:\\Ajit\\Script_SS\\LocalCruisebkng\\8_Confirmationpage.png"));
                        Thread.sleep(3000);

                                    
                                  //For Verify price on confirmation page
                                  String priceoncon = driver.findElement(By.cssSelector("#PricesGTotal")).getText();
                                  Reporter.log("Price on confirmationpage is:- "+ priceoncon);
                                  Thread.sleep(1000);
                try{
                	 if(driver.findElement(By.id("InsurranceCHK_STD")).isDisplayed())
                	 {
                		 driver.findElement(By.id("InsurranceCHK_STD")).click();
                		 Thread.sleep(3000);
                		 
                		 final Screenshot screenshot45 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                         final BufferedImage image45 = screenshot45.getImage();
                         ImageIO.write(image45, "PNG", new File("D:\\Ajit\\Script_SS\\LocalCruisebkng\\10_InsuranceApplied.png"));
                         Thread.sleep(2000);   
                         
                         String insuranceprice = driver.findElement(By.xpath("//*[@id='Res_PassengerPriceSummery']/div[2]/ul[1]/li[2]")).getText();
                         Reporter.log("Insurance Details:- " +insuranceprice);
                         Thread.sleep(1000);
                         
                         String afterinsu = driver.findElement(By.cssSelector("#PricesGTotal")).getText();
                         Reporter.log("After Applied insurance:- " +afterinsu);
                         Thread.sleep(1000);
                         
                         //Remove insurance
                         driver.findElement(By.id("InsurranceCHK_NON")).click();
                         Thread.sleep(1000);
                         Alert alert=driver.switchTo().alert();
                 	     alert.accept();
                 	     Thread.sleep(3000);
                 	     
                 	    String afterremoveinsu = driver.findElement(By.xpath("//*[@id='PricesGTotal']")).getText();
                        Reporter.log("After Removed insurance:- " +afterremoveinsu);
                        Thread.sleep(1000);
                        
                        final Screenshot screenshot46 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                        final BufferedImage image46 = screenshot46.getImage();
                        ImageIO.write(image46, "PNG", new File("D:\\Ajit\\Script_SS\\LocalCruisebkng\\11_InsuranceRemoved.png"));
                        Thread.sleep(2000);
                           
                	 }
                	
                }catch(Exception e)
                {
                	e.getMessage();
                }
                      
                /*
                             // For click on Held booking button
                             if(envrnmnt.toLowerCase().trim().equals("test"))
                             {	 
                                  driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_HoldCruiseBTN")).click();
                                  long start7 = System.currentTimeMillis();
                                  
                                  Thread.sleep(6000);
                                  
                                  long finish1112 = System.currentTimeMillis();
                                  long totalTime1112 = finish1112 - start7; 
                                  Reporter.log("Total Time for purchase page to confirmation(Payment) page load(Milisec) - "+totalTime1112); 
                                  Thread.sleep(1000);
                             }   
                             
                   */          
       /*                     
                     //For the verify held condition
                     try
                     {
                                        String status = driver.findElement(By.xpath("//*[@id='MainForm']/div[2]/div/div[2]/div[2]/ul/li[3]/text()")).getText(); 
                                             
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
                          	   		    ImageIO.write(image5, "PNG", new File("D:\\Ajit\\Script_SS\\LocalCruisebkngError\\5_HeldbookingFail.png"));
                          	            
                          	            Reporter.log("Actual status is:-" +status);
                          	            Assert.assertFalse(false, "FAIL");
                          	            Reporter.log("Status Fail b'coz status are differ to expected..");
                          			    AssertJUnit.assertTrue("Status Fail b'coz status are differ to expected...", crsbkngpge.isDisplayed());
                          			    return;
                          		     }
                                  
                                        Reporter.log("Actual status is:- " + status);
                                   
                                       final Screenshot screenshot6 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                          		       final BufferedImage image6 = screenshot6.getImage();
                          		       ImageIO.write(image6, "PNG", new File("D:\\Ajit\\Script_SS\\LocalCruisebkng\\13_BookingHeld.png"));
                                   
                                       Reporter.log("Status held successfully..");
                                  
                                  System.out.println("\n");
                                  System.out.println("Held Confirmation page Logs..");
                                  System.out.println("\n");
                                  ExtractJSLogs();              
                                  Thread.sleep(1000);
                                  
                                  
                     }       
                      catch (Exception e) {
						// TODO: handle exception
                    	  e.getMessage();
					}    
		*/			     
                             
                             final Screenshot screenshot704 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                             final BufferedImage image704 = screenshot704.getImage();
                             ImageIO.write(image704, "PNG", new File("D:\\Ajit\\Script_SS\\LocalCruisebkng\\14_HeldConfirmationpage.png"));
                             Thread.sleep(4000);
                             
                        try
                        {
                        	
                        	// Click on Full payment
                        	driver.findElement(By.cssSelector("#_ctl0_MainContentsPH__ctl0_ConfirmBkgBTN")).click();
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
                            ImageIO.write(image74, "PNG", new File("D:\\Ajit\\Script_SS\\LocalCruisebkng\\15_Paymentpage.png"));
                            Thread.sleep(4000);
                        	
                        	// For Payment details
                        	
                            String priceonpaymnt = driver.findElement(By.cssSelector("#PricesGTotal")).getText();
                            Reporter.log("Price on paymentpage is:- "+ priceonpaymnt);
                /*                            
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
            							         
           			*/
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
                   							         
                  							 Thread.sleep(9000);	
                  							 
                        }
                        catch(Exception e)
                        {
                        	final Screenshot screenshot94 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                            final BufferedImage image94 = screenshot94.getImage();
                            ImageIO.write(image94, "PNG", new File("D:\\Ajit\\Script_SS\\LocalCruisebkngError\\11_Paymentdetails.png"));
                    
                            Assert.assertFalse(false, "FAIL");
              	            Reporter.log("Something went wrong...");
              	            AssertJUnit.assertTrue("Something went wrong...", crsbkngpge.isDisplayed());
              	            throw(e);
                        }	
                        
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
                             System.out.println("BankName: " + BankName);
                           
                            hldncnfrm.PaymentToTitle(CardNo, CardCvvNo, CardHolderName, Address, City, Zipcode, Phone_Number, BankName);
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
                                
                                driver.findElement(By.id("AgreeTermsCHK")).click();
                                Thread.sleep(2000);
                                driver.findElement(By.cssSelector("#_ctl0_MainContentsPH__ctl0_ContinueLNK")).click();
                                Thread.sleep(3000);
               /*                 
                             // For the verify confirm condition
                                String status1 = driver.findElement(By.xpath("//*[@id='MainForm']/div[2]/div/div[2]/div[2]/ul/li[3]/text()")).getText(); 
                                                  
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
                       				 ImageIO.write(image9, "PNG", new File("D:\\Ajit\\Script_SS\\LocalCruisebkngError\\6_ConfirmbookingFail.png"));
                       		               
                       		         Reporter.log("Actual status is:-" +status1);
                       		         Assert.assertFalse(false, "FAIL");
                       		         Reporter.log("Status Fail b'coz status are differ to expected..");
                       		         AssertJUnit.assertTrue("Status Fail b'coz status are differ to expected...", crsbkngpge.isDisplayed());
                       			     return;
                       	        }
                               
                                  System.out.println("Actual status is:- "+ status1);
                                  Reporter.log("Actual status is:- " + status1);
                      */          
                                  final Screenshot screenshot76 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                                  final BufferedImage image76 = screenshot76.getImage();
                                  ImageIO.write(image76, "PNG", new File("D:\\Ajit\\Script_SS\\LocalCruisebkng\\16_ConfirmBooking.png"));
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
                        ImageIO.write(image94, "PNG", new File("D:\\Ajit\\Script_SS\\LocalCruisebkngError\\10_Paymentpage.png"));
                
                        Assert.assertFalse(false, "FAIL");
          	            Reporter.log("Something went wrong...");
          	            AssertJUnit.assertTrue("Something went wrong...", crsbkngpge.isDisplayed());
          	            throw(e);
			      }   
                  
    /*                  driver.get("https://localhost/odyssey/admin/default.aspx");
                      driver.navigate().refresh();
                      driver.manage().window().maximize();
                      
                      System.out.println("\n");
                      System.out.println("Admindefaultpage Logs..");
                      System.out.println("\n");
                      ExtractJSLogs();
                      
                      Thread.sleep(100);
                      
                      final Screenshot screenshot11 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
           		      final BufferedImage image11 = screenshot11.getImage();
           		      ImageIO.write(image11, "PNG", new File("D:\\Ajit\\Script_SS\\LocalCruisebkng\\17_Admindefaultpage.png"));
                      
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
          	 	      ImageIO.write(image16, "PNG", new File("D:\\Ajit\\Script_SS\\LocalCruisebkng\\19_Cancelbookingpopup.png"));
            	    
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
          		 	 ImageIO.write(image17, "PNG", new File("D:\\Ajit\\Script_SS\\LocalCruisebkngError\\13_CancelbookingFail.png"));
          	               
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
              			 	 ImageIO.write(image18, "PNG", new File("D:\\Ajit\\Script_SS\\LocalCruisebkngError\\14_CancelbookingstatusFail.png"));
              		               
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
          			     ImageIO.write(image19, "PNG", new File("D:\\Ajit\\Script_SS\\LocalCruisebkng\\20_Bookingcancelled.png"));
                       
                         System.out.println("Booking cancelled successfully..");
                       
                         Reporter.log("Booking cancelled successfully..");
                      
                         Thread.sleep(4000);
        */              
                                  

 }
 
 @DataProvider
 public String[][] Authentications() throws Exception
 {
 	 
	     String[][] testObjArray = LocalCruiseUtils.getTableArray("D:\\Ajit\\Automation\\Workspace\\Odysseus_Product\\src\\main\\java\\testData\\LocalCruiseData.xlsx","Sheet1");
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
