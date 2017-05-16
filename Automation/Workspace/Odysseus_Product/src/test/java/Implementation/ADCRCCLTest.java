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
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
import Utility.ADCUtils;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.screentaker.ViewportPastingStrategy;


public class ADCRCCLTest 
{
	    
	    ADCRCCLPurchasepgeobjct crspurchpge;
	    ADCBookingpgeobjct crsbkngpge;
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
                        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
                        LoggingPreferences loggingprefs = new LoggingPreferences();
                        loggingprefs.enable(LogType.BROWSER, Level.ALL);
                        capabilities.setCapability(CapabilityType.LOGGING_PREFS, loggingprefs);
			            driver = new FirefoxDriver(capabilities);
	   
            } 
            else if (browser.equalsIgnoreCase("chrome")) 
            {
           	              System.setProperty("webdriver.chrome.driver", "D:\\Ajit\\Driver\\chromedriver_win32\\chromedriver.exe");
	                      DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	                      LoggingPreferences loggingprefs = new LoggingPreferences();
	                      loggingprefs.enable(LogType.BROWSER, Level.ALL);
	                      capabilities.setCapability(CapabilityType.LOGGING_PREFS, loggingprefs);
	           //         driver = new ChromeDriver(capabilities);
	                   
            }  
            else if (browser.equalsIgnoreCase("IE")) 
            {
	                   System.setProperty("webdriver.ie.driver", "D:\\Ajit\\Driver\\IEDriverServer_Win32_2.53.0\\IEDriverServer.exe");
	                   //driver = new InternetExplorerDriver();
	                   
            } 

      } catch (WebDriverException e) 
        {
              System.out.println(e.getMessage());
        }
   
            driver.manage().window().maximize();
            driver.get("https://deals.americandiscountcruises.com/web/cruises/search.aspx?");
            Thread.sleep(2000);
   
            //Save console
            String testResultFile="D:\\Ajit\\Script_SS\\ConsoleError\\ADCRCCLBookingError.txt";
            File file = new File(testResultFile);  
            FileOutputStream fis = new FileOutputStream(file);  
            PrintStream out = new PrintStream(fis);  
            System.setOut(out); 
                 
            Thread.sleep(1000);
   
            final Screenshot screenshot1 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
            final BufferedImage image1 = screenshot1.getImage();
            ImageIO.write(image1, "PNG", new File("D:\\Ajit\\Script_SS\\ADC\\1_Searchpage.png"));
            Thread.sleep(1000);
            System.out.println("\n");
	        System.out.println("Searchpage Logs..");
	        System.out.println("\n");
	        ExtractJSLogs();
           
            Thread.sleep(4000);
            crsbkngpge = PageFactory.initElements(driver, ADCBookingpgeobjct.class);
            crspurchpge = PageFactory.initElements(driver, ADCRCCLPurchasepgeobjct.class);
   
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
   public void ADCRCCL_data(String Firstname_GuestOne, String Middlename_GuestOne, String Lastname_GuestOne, String Email, String Phone, String Street_Address, String City, String Zipcode, String Firstname_GuestTwo, String Middlename_GuestTwo, String Lastname_GuestTwo) throws Exception
   {
	
   	   try
       {
  		     //For web site and booking details
             Reporter.log("Website Name :- ADC");
             Thread.sleep(200);
  		 
       	     crsbkngpge.BookingToTittle();
      	     Thread.sleep(4000);
      	     System.out.println("\n");
 	         System.out.println("Resultpage Logs..");
 	         System.out.println("\n");
 	         ExtractJSLogs();
 	        
             Thread.sleep(1000);
              
 	          final Screenshot screenshot4 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
              final BufferedImage image4 = screenshot4.getImage();
              ImageIO.write(image4, "PNG", new File("D:\\Ajit\\Script_SS\\ADC\\2_Resultpage.png"));
          
              Thread.sleep(8000);
           
       }
       catch(Exception e)
       {
      	     System.out.println("\n");
 	         System.out.println("Time out or Invalid search criteria on resultpage Logs..");
 	         System.out.println("\n");
 	         ExtractJSLogs();
  	 
	         final Screenshot screenshot33 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	         final BufferedImage image33 = screenshot33.getImage();
	         ImageIO.write(image33, "PNG", new File("D:\\Ajit\\Script_SS\\ADCError\\1_TimeoutORinvalidsearchdetails.png"));
	          
  	         Assert.assertFalse(false, "FAIL");
  	         Reporter.log("Time out or Invalid search criteria on resultpage..");
  	         AssertJUnit.assertTrue("Time out or Invalid search criteria on resultpage...", crsbkngpge.isDisplayed());
  	         throw(e);
       }
   	
   	   //For Select cruise from result page
       try
       {
                     driver.navigate().refresh();
                     
                     driver.get("https://deals.americandiscountcruises.com/web/cruises/results.aspx?showtrace=true");
                      
                     Thread.sleep(4000);  
                                 
                     // For the bonus offers
                     if(driver.findElement(By.cssSelector("#ResultsContainer > div:nth-child(2) > div.resultSales > table > tbody > tr:nth-child(1) > td:nth-child(2) > table > tbody > tr:nth-child(2) > td:nth-child(2) > a")).isDisplayed())
                     {
                     	  Reporter.log("Bonus Offers are available..");
                     	  driver.findElement(By.cssSelector("#ResultsContainer > div:nth-child(2) > div.resultSales > table > tbody > tr:nth-child(1) > td:nth-child(2) > table > tbody > tr:nth-child(2) > td:nth-child(2) > a")).sendKeys(Keys.ENTER);
                          Thread.sleep(1500);
                         
                          File scr22 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
           	              org.codehaus.plexus.util.FileUtils.copyFile(scr22, new File("D:\\Ajit\\Script_SS\\ADC\\3_Bonusoffers.png")); 
                         
                          Thread.sleep(3000);
                         
                     	  driver.navigate().refresh();
                     	  Thread.sleep(3000);
                     }
                     
                      
                        driver.findElement(By.cssSelector("#ResultsContainer > div:nth-child(2) > div.resultVendor > div.dateView [id*='PriceLink_']")).click();  // Select cruise
	                    Thread.sleep(1000);
	                    
	                    final Screenshot screenshot36 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	       	            final BufferedImage image36 = screenshot36.getImage();
	       	            ImageIO.write(image36, "PNG", new File("D:\\Ajit\\Script_SS\\ADC\\03_ViewPricingForAllDates.png"));
	       	            Thread.sleep(1000);
	       	            
	       	            driver.findElement(By.xpath("//*[@id='PriceList_0']/table/tbody/tr[2]/td[8]/a")).click();
	                    
                        
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
                ImageIO.write(image5, "PNG", new File("D:\\Ajit\\Script_SS\\ADCError\\2_Cruisenotavailable.png"));
         
                Assert.assertFalse(false, "FAIL");
                Reporter.log("Cruise not available..");
		        AssertJUnit.assertTrue("Cruise not available...", crsbkngpge.isDisplayed());
		        throw(e);
	       }
		          
               Thread.sleep(2000); 
      
               System.out.println("\n");
               System.out.println("Cruise detailspage Logs..");
               System.out.println("\n");
               ExtractJSLogs();              
               Thread.sleep(1000);
   
               final Screenshot screenshot60 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
               final BufferedImage image60 = screenshot60.getImage();
               ImageIO.write(image60, "PNG", new File("D:\\Ajit\\Script_SS\\ADC\\4_Cruisedetailspage.png"));

               System.out.println("Cruise selected successfully..");
                
               Thread.sleep(4000);
               
        
        //For the Cruise details page
        try
        {
                	
                   driver.findElement(By.id("_ctl0:MainContentsPH:_ctl0:_ctl1_GuestAge_1")).clear();
                   Thread.sleep(100);
                   driver.findElement(By.id("_ctl0:MainContentsPH:_ctl0:_ctl1_GuestAge_1")).click();
                   Thread.sleep(100);
                   driver.findElement(By.id("_ctl0:MainContentsPH:_ctl0:_ctl1_GuestAge_1")).sendKeys("24");
                   Thread.sleep(300);
                   driver.findElement(By.id("_ctl0:MainContentsPH:_ctl0:_ctl1_GuestAge_2")).clear();
                   Thread.sleep(100);
                   driver.findElement(By.id("_ctl0:MainContentsPH:_ctl0:_ctl1_GuestAge_2")).click();
                   Thread.sleep(100);
                   driver.findElement(By.id("_ctl0:MainContentsPH:_ctl0:_ctl1_GuestAge_2")).sendKeys("30");
                   Thread.sleep(300);
                   WebElement welm = driver.findElement(By.id("_ctl0_MainContentsPH__ctl0__ctl1_ResidentState"));
                   welm.click();
                   Thread.sleep(800);
                   welm.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0__ctl1_ResidentState']/option[3]")).click();
                   Thread.sleep(1500);
                   
           try
           {
                   // For Select Promo code
                   if(driver.findElement(By.cssSelector("#step2pax > tbody > tr:nth-child(23) > td.step2paxRight [id*='SPromoCode_']")).isDisplayed())
                   {
                 	   WebElement element = driver.findElement(By.cssSelector("#step2pax > tbody > tr:nth-child(23) > td.step2paxRight [id*='SPromoCode_']"));
                 	   JavascriptExecutor executor = (JavascriptExecutor) driver;
                       executor.executeScript("arguments[0].click();", element);
                       
                       Thread.sleep(1000);
                	   
                   }
           }
           catch(Exception e)
           {
        	   e.getMessage();
           }
                   driver.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0__ctl1_CategoryLNK']")).sendKeys(Keys.ENTER);
                   Thread.sleep(1000);
                   
                   System.out.println("\n");
         	       System.out.println("Categorypage Logs..");
         	       System.out.println("\n");
         	       ExtractJSLogs();
                   
                   Thread.sleep(8000);
        }
        catch(Exception e)
        {
                  	System.out.println("\n");
         	        System.out.println("Invalid guest information on cruise detailspage Logs..");
         	        System.out.println("\n");
         	        ExtractJSLogs();
          	 
     	            final Screenshot screenshot80 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
     	            final BufferedImage image80 = screenshot80.getImage();
     	            ImageIO.write(image80, "PNG", new File("D:\\Ajit\\Script_SS\\ADCError\\3_InvalidGuestinformation.png"));
     	          
          	        Assert.assertFalse(false, "FAIL");
          	        Reporter.log("Invalid guest information's on detailspage...");
          	        AssertJUnit.assertTrue("Invalid guest information's on detailspage...", crsbkngpge.isDisplayed());
          	        throw(e);
         }
        
        
      // Verify error on category page
      try
      {
           if(driver.findElement(By.cssSelector("#category_1 > div.categoryview-container")).isDisplayed())
           {
        	   String err = driver.findElement(By.cssSelector("#category_1 > div.categoryview-container")).getText();
        	   Thread.sleep(1000);
        	   Reporter.log("Error message: " +err);
        	   Thread.sleep(500);
        	   
        	   final Screenshot screenshot82 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
               final BufferedImage image82 = screenshot82.getImage();
               ImageIO.write(image82, "PNG", new File("D:\\Ajit\\Script_SS\\ADCError\\07_Error.png"));
               Thread.sleep(1000);
           }
      }
      catch(Exception e)
      {
    	  e.getMessage();
      }
   
                     //For verify Suite category on category page
                     driver.findElement(By.id("outside")).click(); // FOR oceanview(outside/suite)
                 	 Thread.sleep(1000);
                	 
                	 final Screenshot screenshot62 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                     final BufferedImage image62 = screenshot62.getImage();
                     ImageIO.write(image62, "PNG", new File("D:\\Ajit\\Script_SS\\ADC\\6_Categorypage.png"));
                     Thread.sleep(2000);
                     
                	 driver.findElement(By.cssSelector("#catType2 > tbody > tr:nth-child(3) > td > div > table > tbody > tr:nth-child(2) > td:nth-child(5) > a")).click();
                	 Thread.sleep(4000);
				 
                 
                 System.out.println("\n");
                 System.out.println("Cabin selection page Logs..");
                 System.out.println("\n");
                 ExtractJSLogs();              
                 Thread.sleep(1000);
     
                 final Screenshot screenshot63 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                 final BufferedImage image63 = screenshot63.getImage();
                 ImageIO.write(image63, "PNG", new File("D:\\Ajit\\Script_SS\\ADC\\7_Cabinselectionpage.png"));

                 System.out.println("Category selected successfully..");
                  
                 Thread.sleep(5000);
                 
                 //For the Cruise details print on test report
                 String crsline =  driver.findElement(By.cssSelector("#MainForm > div > table > tbody > tr:nth-child(1) > td > div.step2selections > div > div.step2CruiseLine")).getText();
                 Reporter.log(" " +crsline);
      		     Thread.sleep(1500);
                 String departport = driver.findElement(By.cssSelector("#MainForm > div > table > tbody > tr:nth-child(1) > td > div.step2selections > div > div.step2DepartPort")).getText();
                 Reporter.log(" " +departport);
                 Thread.sleep(500);
                 String guest = driver.findElement(By.cssSelector("#MainForm > div > table > tbody > tr:nth-child(1) > td > div.step2selections > div > div.step3Pax")).getText();
                 Reporter.log(" " +guest);
                 Thread.sleep(800);
                 String shp = driver.findElement(By.cssSelector("#MainForm > div > table > tbody > tr:nth-child(1) > td > div.step2selections > div > div.step2ShipName")).getText();
                 Reporter.log(" " +shp);
                 Thread.sleep(500);
                 String departdate = driver.findElement(By.cssSelector("#MainForm > div > table > tbody > tr:nth-child(1) > td > div.step2selections > div > div.step3DepartDate")).getText();
                 Reporter.log(" " +departdate);
                 Thread.sleep(400);
                 String ctgory = driver.findElement(By.cssSelector("#MainForm > div > table > tbody > tr:nth-child(1) > td > div.step2selections > div > div.step4category")).getText();
                 Reporter.log(" " + ctgory);
                 Thread.sleep(400);
      
                //For verify price's on cabin page
                 String priceoncabin= driver.findElement(By.cssSelector("#tabs-1 > div > table > tbody > tr:nth-child(2) > td:nth-child(1) > table.step4cabinList > tbody > tr:nth-child(1) > td > div.step4PriceHolder > div")).getText();
                 System.out.println("Prices on cabin page is:- " +priceoncabin);
                 Reporter.log("Prices on cabin page is:- " +priceoncabin);
                 Thread.sleep(2000);
                 String taxoncabin= driver.findElement(By.cssSelector("#tabs-1 > div > table > tbody > tr:nth-child(2) > td:nth-child(1) > table.step4cabinList > tbody > tr:nth-child(2) > td")).getText();
                 System.out.println(" " +taxoncabin);
                 Reporter.log(" " +taxoncabin);
                 Thread.sleep(2000);
                 
                 //For check API, Office id And Test environment on cabin page
                 String expr = driver.findElement(By.id("TracerBlock")).getText();
                 String api = expr.split("OdysseyGateway")[2].split(":")[1].trim();
               //List<String> items = Arrays.asList(expr.split("$($('#TracerBlock')[0].innerHTML.split('OdysseyGateway')[2])[0].nodeValue.toString().split(':')[1]"));
                 Reporter.log("API :- " +api);
                 Thread.sleep(500);
                 String envrnmnt = expr.split("OdysseyGateway")[2].split(":")[2].trim();
                 Reporter.log("Environment :- " +envrnmnt);
                 Thread.sleep(500);
                 String officeid = expr.split("OdysseyGateway")[2].split(":")[3].trim();
                 Reporter.log("Office Id :- " +officeid);
                 Thread.sleep(3000);

         
         //For select cabin from the cabin selection page
         try
         {
        	            driver.findElement(By.cssSelector("#tabs-1 > div > table > tbody > tr:nth-child(2) > td:nth-child(1) > table.step4cabinList > tbody > tr:nth-child(5) > td.step4cabinSelect [id*='CabinBook_']")).click();
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
                              ImageIO.write(image13, "PNG", new File("D:\\Ajit\\Script_SS\\ADCError\\4_Cabinnotavailable.png"));
                       
                              Assert.assertFalse(false, "FAIL");
        	                  Reporter.log("Cabin not available..");
        			          AssertJUnit.assertTrue("Cabin not available...", crsbkngpge.isDisplayed());
        			          throw(e);
          }
                       
                             System.out.println("\n");
                             System.out.println("Purchase page Logs..");
                             System.out.println("\n");
                             ExtractJSLogs();              
                             Thread.sleep(1000);
                   
                             final Screenshot screenshot102 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                             final BufferedImage image102 = screenshot102.getImage();
                             ImageIO.write(image102, "PNG", new File("D:\\Ajit\\Script_SS\\ADC\\08_Purchasepage.png"));
                             Thread.sleep(1000);
                             
                             System.out.println("Cabin selected successfully..");
                   
                             Thread.sleep(4000);
                             
                             //Verify price on purchase page
                             String priceonpurchase= driver.findElement(By.xpath("//*[@id='tabs-1']/table[1]/tbody/tr[2]/td/table/tbody/tr[6]/td[2]")).getText();
                             System.out.println("Prices on purchase page is:- " +priceonpurchase);
                             Reporter.log("Prices on purchase page is:- " +priceonpurchase);
                             Thread.sleep(2000);
     
          
          //For Purchase page                 
          try
          {
        	                         driver.findElement(By.cssSelector("#tabs-1 > table:nth-child(10) > tbody > tr > td > div > a > strong")).click(); //For click to enter Passenger Information
        	                         Thread.sleep(1000);
        	                         
        	                         final Screenshot screenshot202 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                                     final BufferedImage image202 = screenshot202.getImage();
                                     ImageIO.write(image202, "PNG", new File("D:\\Ajit\\Script_SS\\ADC\\8_GuestInfoOnPurchasepage.png"));
                                     Thread.sleep(1000);
        	                         
                                     System.out.println("FirstName_Of_Guest1: " + Firstname_GuestOne);
                                     System.out.println("MiddleName_Of_Guest1: " + Middlename_GuestOne);
                                     System.out.println("LastName_Of_Guest1: " + Lastname_GuestOne);
                                     System.out.println("Email: " + Email);
                                     System.out.println("Phone: " + Phone);
                                     System.out.println("Email: " + Street_Address);
                                     System.out.println("Email: " + City);
                                     System.out.println("Email: " + Zipcode);
                                     System.out.println("FirstName_Of_Guest2: " + Firstname_GuestTwo);
                                     System.out.println("MiddleName_Of_Guest2: " + Middlename_GuestTwo);
                                     System.out.println("Lastname_of_Guest2: " + Lastname_GuestTwo);
                                                	                                	 
                                     crspurchpge.ADCPurchaseToTittle(Firstname_GuestOne, Middlename_GuestOne, Lastname_GuestOne, Email, Phone, Street_Address, City, Zipcode, Firstname_GuestTwo, Middlename_GuestTwo, Lastname_GuestTwo);
                                     Thread.sleep(2000);
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
                                     ImageIO.write(image34, "PNG", new File("D:\\Ajit\\Script_SS\\ADCError\\5_InvalidGuestinfoonPurchasepage.png"));
                                              
                                     Assert.assertFalse(false, "FAIL");
                               	     Reporter.log("Invalid guest information on purchase page, Please enter valid details for the required fields...");
                               		 AssertJUnit.assertTrue("Invalid guest information on purchase page, Please enter valid details for the required fields....", crspurchpge.isDisplayed());
                               		 throw(e);
              }
                                                  
                                     System.out.println("\n");
                                     System.out.println("Confirmationpage Logs..");
                                     System.out.println("\n");
                                     ExtractJSLogs();              
                                     Thread.sleep(1000);
                                                     
                                     final Screenshot screenshot44 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                                     final BufferedImage image44 = screenshot44.getImage();
                                     ImageIO.write(image44, "PNG", new File("D:\\Ajit\\Script_SS\\ADC\\9_Confirmationpage.png"));
                                                     
                                     Thread.sleep(2000);

              // For confirmation page                       
                                        
              //For Insurance
              try
              {
              	 if( driver.findElement(By.cssSelector("#tabs-1 > table:nth-child(5) > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(4) > td > table > tbody > tr:nth-child(1) > td > div.step6InsuranceYesRadio [id*='InsurranceCHK_']")).isDisplayed())
              	 {	
                        driver.findElement(By.cssSelector("#tabs-1 > table:nth-child(5) > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(4) > td > table > tbody > tr:nth-child(1) > td > div.step6InsuranceYesRadio [id*='InsurranceCHK_']")).click();
                        Thread.sleep(1500);
                        Reporter.log("Insurance applied successfully..");
                        
                        //For check insurance price
                        String insurprice = driver.findElement(By.cssSelector("#tabs-1 > table.step5PriceBox > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(6) > td:nth-child(2)")).getText();
                        Reporter.log("Prices of After applied insurance on the confirmation page is:- " +insurprice);
                        Thread.sleep(1000); 
                        
                        //For insurance price
                        String appliedinsurprice = driver.findElement(By.cssSelector("#tabs-1 > table.step5PriceBox > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(5) > td > table:nth-child(3) > tbody > tr:nth-child(2) > td:nth-child(2) > div")).getText();
                        Reporter.log("Insurance Prices:- " +appliedinsurprice);
                        Thread.sleep(1000);
                        
                        final Screenshot screenshot64 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                        final BufferedImage image64 = screenshot64.getImage();
                        ImageIO.write(image64, "PNG", new File("D:\\Ajit\\Script_SS\\ADC\\12_AppliedInsurance.png"));
                        
                        Thread.sleep(2000);
                        
                        //For Remove insurance
                        WebElement insurnc = driver.findElement(By.id("InsurranceCHK_NON"));
                        insurnc.click();
                        Thread.sleep(1500);
                        driver.switchTo().alert().accept();
                        Thread.sleep(500);
                        
                        Reporter.log("Insurance Removed successfully..");
                        
                        //For check insurance price
                        String insprice = driver.findElement(By.cssSelector("#tabs-1 > table.step5PriceBox > tbody > tr:nth-child(2) > td > table > tbody > tr:nth-child(6) > td:nth-child(2)")).getText();
                        Reporter.log("Prices of After removed insurance on the passenger details page is:- " +insprice);
                        Thread.sleep(1000);  
                        
                        final Screenshot screenshot66 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                        final BufferedImage image66 = screenshot66.getImage();
                        ImageIO.write(image66, "PNG", new File("D:\\Ajit\\Script_SS\\ADC\\13_RemovedInsurance.png"));
                        
                        Thread.sleep(2000);
                        
              	 }     
              }
              catch(Exception e)
              {
              	 System.out.println("Insurance not applied/removed...");
       	         System.out.println("\n");
       	         System.out.println("Insurance not applied/removed on confirmation page...");
       	         System.out.println("\n");
       	         ExtractJSLogs();
          
                 final Screenshot screenshot72 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                 final BufferedImage image72 = screenshot72.getImage();
                 ImageIO.write(image72, "PNG", new File("D:\\Ajit\\Script_SS\\ADCError\\9_InsurancenotAppliedOrRemoved.png"));
          
                 Assert.assertFalse(false, "FAIL");
                 Reporter.log("Insurance not applied/removed...");
		         AssertJUnit.assertTrue("Insurance not applied/removed....", crsbkngpge.isDisplayed());
		         throw(e);
              }
              
                                     
              try
              {
                                      String priceoncon = driver.findElement(By.xpath("//*[@id='tabs-1']/table[1]/tbody/tr[2]/td/table/tbody/tr[6]/td[2]")).getText();
                                      Reporter.log("Price on confirmationpage is:- "+ priceoncon);
                                      Thread.sleep(1000);
                                                     
                                       if(priceoncon.equals(priceonpurchase))
                                       {
                                                    	
                                              System.out.println("Actual String: " +priceonpurchase);
                                              System.out.println("Purchase page and Confirmation page's Price matched");
                                              Reporter.log("Purchase page and Confirmation page's Price matched..");
                                                    	 
                                              System.out.println("Actual price is:- " +priceonpurchase);
                    						  Reporter.log("Actual price is:- " +priceonpurchase);
                                        }
                                        else
                                        {
                    							  System.out.println("Purchase page and Confirmation page's Price not match..");
                    							  Reporter.log("Purchase page and Confirmation page's Price not match..");
                    							  System.out.println("Actual price is:- " +priceonpurchase);
                    							  Reporter.log("Actual price is:- " +priceonpurchase);
                    					   }
                     							         
                    							 Thread.sleep(1500);
               }     							 
               catch (Exception e) 
               {
             	   final Screenshot screenshot94 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                   final BufferedImage image94 = screenshot94.getImage();
                   ImageIO.write(image94, "PNG", new File("D:\\Ajit\\Script_SS\\ADCError\\10_Paymentpage.png"));
                   
                   Assert.assertFalse(false, "FAIL");
             	   Reporter.log("Something went wrong on confirmation page...");
             	   AssertJUnit.assertTrue("Something went wrong on confirmation page...", crspurchpge.isDisplayed());
             	   throw(e);
 			  }                        

    }
    
    @DataProvider
    public String[][] Authentications() throws Exception
    {
    	 
 	     String[][] testObjArray = ADCUtils.getTableArray("D:\\Ajit\\Automation\\Workspace\\Odysseus_Product\\src\\main\\java\\testData\\ADCData.xlsx","Sheet1");
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
