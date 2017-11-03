package Implementation;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import javax.imageio.ImageIO;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
import Utility.FaredepotUtils;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.screentaker.ViewportPastingStrategy;


public class FaredepotTest 
{
	   
	   FaredepotBookingpgeobjct faredeptbkpge;
	   FaredepotPurchasepgeobjct faredptpurchse;
       public static WebDriver driver;
       Reporter report = new Reporter();
       HSSFWorkbook workbook;
  	   //define an Excel Work sheet
  	    HSSFSheet sheet;
  	   //define a test result data object
  	    Map<String, Object[]> testresultdata;
	
       String Log = "D:\\Ajit\\Script_SS\\Differences of Images\\Logs\\Faredepot.txt";

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
          //       driver = new FirefoxDriver(capabilities);
	   
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
          driver.get("http://faredepot.com/");
          Thread.sleep(7000);
          
          workbook = new HSSFWorkbook();
          //create a new work sheet
          sheet = workbook.createSheet("Test Result");
          testresultdata = new LinkedHashMap<String, Object[]>();
          //add test result excel file column header
          //write the header in the first row
          testresultdata.put("1", new Object[] {"", "Faregeek", "Faredepot"});
          testresultdata.put("2", new Object[] {"", "Price", "Price"});
          testresultdata.put("3", new Object[] {"Results"});
          testresultdata.put("4", new Object[] {""});
          testresultdata.put("5", new Object[] {"Checkout"});
          testresultdata.put("6", new Object[] {"Best Price Gaurantee"});
          testresultdata.put("7", new Object[] {"Best Price Gaurantee Applied"});
          testresultdata.put("8", new Object[] {"Best Price Gaurantee Removed"});
          testresultdata.put("9", new Object[] {"Insurance Price"});
          testresultdata.put("10", new Object[] {"Insurance Applied"});
          testresultdata.put("11", new Object[] {"Insurance Removed"});
          testresultdata.put("12", new Object[] {"Payment"});
          Thread.sleep(3000);
          
        try
        {
           if(driver.findElement(By.cssSelector("#image-f4e1bb6dacbba2cca5ceef5ba601f25c")).isDisplayed()) //#norilskLoadedContent [class*='padiClose']
           {
         	 driver.findElement(By.cssSelector("#image-f4e1bb6dacbba2cca5ceef5ba601f25c")).click();  //For handle unnecessary pop up
              Thread.sleep(3000);
           }
        }  
        catch (Exception e) 
        {
				e.getMessage();
		}  

         //Save console
         String testResultFile="D:\\Ajit\\Script_SS\\ConsoleError\\FaredepotError.txt";
         File file = new File(testResultFile);  
         FileOutputStream fis = new FileOutputStream(file);  
         PrintStream out = new PrintStream(fis);  
         System.setOut(out); 
              
         Thread.sleep(2000);

   /*      
         final Screenshot screenshot1 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
         final BufferedImage image1 = screenshot1.getImage();
         ImageIO.write(image1, "PNG", new File("D:\\Ajit\\Script_SS\\Faredepot\\1_Searchpage.png"));
         Thread.sleep(2000);
         
         String myArg1 = "D:\\Ajit\\Script_SS\\Faredepot\\1_Searchpage.png";
         String myArg2 = "D:\\Ajit\\Script_SS\\Daily Sanity\\Oct_2017\\11 Oct\\Faredepot\\Faredepot\\1_Searchpage.png";
         String myCommand = "D:\\Ajit\\Script_SS\\ImageCompConsole.exe";
         String Output = "D:\\Ajit\\Script_SS\\Differences of Images\\Faredepot\\1_Searchpage.png";
          
         ProcessBuilder pb = new ProcessBuilder(myCommand, myArg1, myArg2, Output, Log);
         pb.directory(new File("D:\\Ajit\\Script_SS"));
         Process p = pb.start();
         
         System.out.println("" +p);
   */
        //driver.navigate().to("https://localhost/odyssey/website/air/results.aspx?");
        Thread.sleep(4000);
        faredeptbkpge = PageFactory.initElements(driver, FaredepotBookingpgeobjct.class);
        faredptpurchse = PageFactory.initElements(driver, FaredepotPurchasepgeobjct.class);
   //     faredptpurchse = PageFactory.initElements((WebDriver) driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS), FaredepotPurchasepgeobjct.class);
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
   public void Faredepot_data(String FromLocation, String ToLocation, String Firstname_Of_Adult1, String Middlename_of_Adult1, String Lastname_Of_Adult1, String Firstname_Of_Adult2, String Middlename_of_Adult2, String Lastname_Of_Adult2, String Firstname_Of_Adult3, String Middlename_of_Adult3, String Lastname_Of_Adult3, String Email, String Confirm_Email, String Phone, String Destination_Phone) throws Exception
   {                                                                        
   	
   	   try
   	   {
   		        //For web site and booking details
                Reporter.log("Website Name :- Faredepot");
                Thread.sleep(200);
    		 
                System.out.println("FromLocation: " + FromLocation);
                System.out.println("ToLocation: " + ToLocation);
                
                faredeptbkpge.FaredepotBookingToTitle(FromLocation, ToLocation);
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
           
                Thread.sleep(11000);
            
          }
          catch(Exception e)
          {
       	         System.out.println("\n");
  	             System.out.println("Time out or Invalid search criteria on resultpage Logs..");
  	             System.out.println("\n");
  	             ExtractJSLogs();
   	    /*
	             final Screenshot screenshot33 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	             final BufferedImage image33 = screenshot33.getImage();
	             ImageIO.write(image33, "PNG", new File("D:\\Ajit\\Script_SS\\FaredepotError\\1_TimeoutORinvalidsearchdetails.png"));
	    */      
   	            Assert.assertFalse(false, "FAIL");
   	            Reporter.log("Time out or Invalid search criteria on resultpage..");
   	            AssertJUnit.assertTrue("Time out or Invalid search criteria on resultpage...", faredeptbkpge.isDisplayed());
   	            throw(e);
          }
   	   
   	 
   	        // For select dynamic flights from result page
        
   	        driver.navigate().refresh();
         
            driver.get("https://res.faredepot.com/web/air/results.aspx?showtrace=true");
     
   	        driver.manage().window().maximize();
   	        
   	        System.out.println("\n");
   	        System.out.println("Resultpage Logs..");
   	        System.out.println("\n");
   	        ExtractJSLogs();
   	        
            Thread.sleep(4000);
   	 /*
            final Screenshot screenshot4 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
            final BufferedImage image4 = screenshot4.getImage();
            ImageIO.write(image4, "PNG", new File("D:\\Ajit\\Script_SS\\Faredepot\\2_Resultpage.png"));
   	        Thread.sleep(4000);
   	        
   	        String myArg1 = "D:\\Ajit\\Script_SS\\Faredepot\\2_Resultpage.png";
            String myArg2 = "D:\\Ajit\\Script_SS\\Daily Sanity\\Oct_2017\\11 Oct\\Faredepot\\Faredepot\\2_Resultpage.png";
            String myCommand = "D:\\Ajit\\Script_SS\\ImageCompConsole.exe";
            String Output = "D:\\Ajit\\Script_SS\\Differences of Images\\Faredepot\\2_Resultpage.png";
          
            ProcessBuilder pb = new ProcessBuilder(myCommand, myArg1, myArg2, Output, Log);
            pb.directory(new File("D:\\Ajit\\Script_SS"));
            Process p = pb.start();
         
            System.out.println("" +p);
   	    */    
   	        //For View Details 
   	        if(driver.findElement(By.cssSelector("[id*='flight-summary_'] > div.row.result-box-footer > div.col-lg-2.col-md-2.col-sm-3.col-xs-3.flight-details-box-right [id*='details_']")).isDisplayed())
   	        {
   	        	      WebElement element = driver.findElement(By.cssSelector("[id*='flight-summary_'] > div.row.result-box-footer > div.col-lg-2.col-md-2.col-sm-3.col-xs-3.flight-details-box-right [id*='details_']"));
                      JavascriptExecutor js =(JavascriptExecutor)driver;
                      js.executeScript("window.scrollTo(0,'element.getLocation().y+')");
                      element.sendKeys(Keys.ENTER);
   	        	      
   	        	      Thread.sleep(500);
 	    	   /*     
   	        	      final Screenshot screenshot22 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
   	                  final BufferedImage image22 = screenshot22.getImage();
   	                  ImageIO.write(image22, "PNG", new File("D:\\Ajit\\Script_SS\\Faredepot\\3_ViewDetails.png"));
 	                  Thread.sleep(1000);
 	                  
 	                 String myArg3 = "D:\\Ajit\\Script_SS\\Faredepot\\3_ViewDetails.png";
 	                 String myArg4 = "D:\\Ajit\\Script_SS\\Daily Sanity\\Oct_2017\\11 Oct\\Faredepot\\Faredepot\\3_ViewDetails.png";
 	                 String myCommand1 = "D:\\Ajit\\Script_SS\\ImageCompConsole.exe";
 	                 String Output1 = "D:\\Ajit\\Script_SS\\Differences of Images\\Faredepot\\3_ViewDetails.png";
 	              
 	                 ProcessBuilder pb1 = new ProcessBuilder(myCommand1, myArg3, myArg4, Output1, Log);
 	                 pb1.directory(new File("D:\\Ajit\\Script_SS"));
 	                 Process p1 = pb1.start();
 	             
 	                 System.out.println("" +p1);
 	           */     
 	                  driver.findElement(By.cssSelector("[id*='flight-summary_'] > div.row.result-box-footer > div.col-lg-2.col-md-2.col-sm-3.col-xs-3.flight-details-box-right [id*='details_']")).sendKeys(Keys.ENTER);
 	                  Thread.sleep(3000);
   	        }
   	        
   	        // For verify price on result page
   	        String perperson = driver.findElement(By.cssSelector("[id*='flight-summary_'] > div.row.result-box-header > div.col-md-4.col-sm-4.col-xs-12.result-box-header-left.pull-right > div > div.price-box.col-md-6.col-sm-6.col-xs-6 > h3.price")).getText();
   	        Reporter.log("Price per person on result page: " +perperson);
   	        Thread.sleep(2000);
   	        
   	     try
         {
                 testresultdata.put("3", new Object[] {"Results", "", perperson});
             
             Thread.sleep(1000);
	      
          }   
          catch(Exception e)
          {
 	        //add fail entry to the excel sheet
 	        testresultdata.put("3", new Object[] {"Results", "", perperson});
 	        System.out.println("Result page per persion price not available..");
 	        Reporter.log("Result page per persion price not available..");
 	        System.out.println(e.getMessage());
 	   
          }
   	        
   	        String totalpriceonresult = driver.findElement(By.cssSelector("[id*='Price_']")).getText();
   	        Reporter.log("Total Price on result page: " +totalpriceonresult);
   	        Thread.sleep(1000);
   	  
            // For select flight
            if(driver.findElement(By.cssSelector("[id*='flight-summary_'] > div.row.result-box-header > div.col-md-4.col-sm-4.col-xs-12.result-box-header-left.pull-right > div > div.booknow-box.col-md-6.col-sm-6.col-xs-6 [class*='btn btn-orange btn-lg btn-block orange text-uppercase btn-booknow']")).isDisplayed())
            {
           	   driver.findElement(By.cssSelector("[id*='flight-summary_'] > div.row.result-box-header > div.col-md-4.col-sm-4.col-xs-12.result-box-header-left.pull-right > div > div.booknow-box.col-md-6.col-sm-6.col-xs-6 [class*='btn btn-orange btn-lg btn-block orange text-uppercase btn-booknow']")).sendKeys(Keys.ENTER);
           	   Thread.sleep(4000);
            }
            else if (driver.findElement(By.cssSelector("#mainBody > div:nth-child(2) > div > div.error-box.priceErr")).isDisplayed()) 
            {                                          
				  driver.navigate().refresh();
				  driver.findElement(By.cssSelector("[id*='flight-summary_'] > div.row.result-box-header > div.col-md-4.col-sm-4.col-xs-12.result-box-header-left.pull-right > div > div.booknow-box.col-md-6.col-sm-6.col-xs-6 [class*='btn btn-orange btn-lg btn-block orange text-uppercase btn-booknow']")).click();
	           	  Thread.sleep(4000);
			}
            else if (driver.findElement(By.cssSelector("#mainBody > div:nth-child(2) > div > div.error-box.priceErr")).isDisplayed())
            {
            	String errorm = driver.findElement(By.cssSelector("#mainBody > div:nth-child(2) > div > div.error-box.priceErr")).getText();
            	Reporter.log("Error on result page: " +errorm);
            	Thread.sleep(1000);
            	AssertJUnit.assertTrue(" " +errorm, faredeptbkpge.isDisplayed());
	    		return;
			}
            else 
            {
            	System.out.println("Flight not available..");
            	System.out.println("\n");
            	System.out.println("Flight not available on resultpage Logs..");
            	System.out.println("\n");
            	ExtractJSLogs();
           /*  	
            	final Screenshot screenshot2 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                final BufferedImage image2 = screenshot2.getImage();
                ImageIO.write(image2, "PNG", new File("D:\\Ajit\\Script_SS\\FaredepotError\\2_Flightnotavailable.png"));
           */    
                Assert.assertFalse(false, "FAIL");
   	            Reporter.log("Flights not available..");
   			    AssertJUnit.assertTrue("Flight not available...", faredeptbkpge.isDisplayed());
   			    return;
   		 }
               long start = System.currentTimeMillis();
               Thread.sleep(1500);
               System.out.println("\n");
               System.out.println("Checkoutpage Logs..");
               System.out.println("\n");
               ExtractJSLogs();              
               Thread.sleep(1000);
               long finish = System.currentTimeMillis();
               long totalTime = finish - start; 
               Reporter.log("Total Time for result page to checkout page load(Milisec) - "+totalTime); 
               Thread.sleep(1000);
        /*      
               final Screenshot screenshot3 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
               final BufferedImage image3 = screenshot3.getImage();
               ImageIO.write(image3, "PNG", new File("D:\\Ajit\\Script_SS\\Faredepot\\4_Checkoutpage.png"));
        
               System.out.println("Flight selected successfully..");
                
               Thread.sleep(1000);
               
                String myArg3 = "D:\\Ajit\\Script_SS\\Faredepot\\4_Checkoutpage.png";
                String myArg4 = "D:\\Ajit\\Script_SS\\Daily Sanity\\Oct_2017\\11 Oct\\Faredepot\\Faredepot\\4_Checkoutpage.png";
                String myCommand1 = "D:\\Ajit\\Script_SS\\ImageCompConsole.exe";
                String Output1 = "D:\\Ajit\\Script_SS\\Differences of Images\\Faredepot\\4_Checkoutpage.png";
             
                ProcessBuilder pb1 = new ProcessBuilder(myCommand1, myArg3, myArg4, Output1, Log);
                pb1.directory(new File("D:\\Ajit\\Script_SS"));
                Process p1 = pb1.start();
            
                System.out.println("" +p1);
          */     
             //For Trip details on checkout page
	  	      String frmloc = driver.findElement(By.cssSelector("#flight_details > div:nth-child(1) > div > div.flt-descprition")).getText();
	  	      Reporter.log("Departure Trip: " +frmloc);
	  	      Thread.sleep(500);
	  	      String toloc = driver.findElement(By.cssSelector("#flight_details > div:nth-child(2) > div > div.flt-descprition")).getText();
	  	      Reporter.log("Return Trip: " +toloc);
	  	      Thread.sleep(500);
	             
             //Price verify on checkout page
 	      	  String priceoncheckout = driver.findElement(By.xpath("//*[@id='trip_summary_package_total']")).getText();
 	      	  Reporter.log("Price on checkout page: " +priceoncheckout);
 	      	  Thread.sleep(1000);
 	      	 
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
 	          Thread.sleep(4000);
      
 	   //For Passenger details         
      try
      {
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
          System.out.println("Phone_No: " + Phone);
    //      System.out.println("Destination_Phone: " + Destination_Phone); 
          
          faredptpurchse.FaredepotToTitle(Firstname_Of_Adult1, Middlename_of_Adult1, Lastname_Of_Adult1, Firstname_Of_Adult2, Middlename_of_Adult2, Lastname_Of_Adult2, Firstname_Of_Adult3, Middlename_of_Adult3, Lastname_Of_Adult3, Email, Confirm_Email, Phone, Destination_Phone);
          
      }
      catch(Exception e)
      {
     	  System.out.println("\n");
     	  System.out.println("Invalid guest information on checkoutpage Logs..");
     	  System.out.println("\n");
     	  ExtractJSLogs();
     /*	 
          final Screenshot screenshot44 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
 		  final BufferedImage image44 = screenshot44.getImage();
 		  ImageIO.write(image44, "PNG", new File("D:\\Ajit\\Script_SS\\FaredepotError\\3_InvalidGuestInfo.png"));
     */     
          Assert.assertFalse(false, "FAIL");
          Reporter.log("Invalid guest information on checkoutpage...");
    	  AssertJUnit.assertTrue("Invalid guest information on checkoutpage..", faredptpurchse.isDisplayed());
    	  throw(e);
      }
      
              Thread.sleep(6000);
             
  
         //For Insurance
         
         try
         {
        	 if(driver.findElement(By.xpath("//*[@id='_ctl0__ctl0_MainContentsParentPH_MainContentsPH__ctl0_GuestResidency_CountrySel']")).isDisplayed())
        	 {
        		 driver.findElement(By.xpath("//*[@id='_ctl0__ctl0_MainContentsParentPH_MainContentsPH__ctl0_GuestResidency_CountrySel']")).click();
        		 Thread.sleep(2000);
        		 driver.findElement(By.xpath("//*[@id='_ctl0__ctl0_MainContentsParentPH_MainContentsPH__ctl0_GuestResidency_CountrySel']/option[215]")).click();
                 Thread.sleep(14000);          
                 driver.findElement(By.xpath("//*[@id='_ctl0__ctl0_MainContentsParentPH_MainContentsPH__ctl0_GuestResidency_StateSel']")).click();
                 Thread.sleep(2000);
                 driver.findElement(By.xpath("//*[@id='_ctl0__ctl0_MainContentsParentPH_MainContentsPH__ctl0_GuestResidency_StateSel']/option[13]")).click();
                 Thread.sleep(6000);
        	 }
        	 
        	     Thread.sleep(6000);
        	     
        	     //For check insurance price
                 String insuranceprice = driver.findElement(By.cssSelector("#section_insurance > div.insurance-sec > div > div.travel-box > div.preferences-insurance-box.spcInsuContianer > div.insurance-travelguard-yes-text > span.priceUp")).getText();
                 Reporter.log("Insurance Price:- " +insuranceprice);
                 Thread.sleep(5000); 
         }
         catch(Exception e)
         {
        	 e.getMessage();
         }
              
         try
         {
         	 
         	 if( driver.findElement(By.cssSelector("[id*='InsurranceCHK_']")).isDisplayed())
         	 {	
               //    driver.findElement(By.cssSelector("[id*='InsurranceCHK_']")).click();
                   WebElement element1 = driver.findElement(By.cssSelector("[id*='InsurranceCHK_']"));
		           JavascriptExecutor executor1 = (JavascriptExecutor) driver;
		           executor1.executeScript("arguments[0].click();", element1);
                   Thread.sleep(5000);
                   
                   // Switch to new window opened
                   String winHandleBefore = driver.getWindowHandle();
                   
                   for(String winHandle : driver.getWindowHandles())
                   {
                       driver.switchTo().window(winHandle);
                   }
                   
                   // Close the new window
                      driver.close();
                      
                      driver.switchTo().window(winHandleBefore);
                   
                    Reporter.log("Insurance applied successfully..");
                   
                    Thread.sleep(2000);
                    
                   //For check insurance price
                    String insurprice = driver.findElement(By.cssSelector("#trip_summary_package_total")).getText(); 
                    Reporter.log("Prices of After applied insurance on the Payment page:- " +insurprice);
                    Thread.sleep(4000); 
              /*      
                   final Screenshot screenshot64 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                   final BufferedImage image64 = screenshot64.getImage();
                   ImageIO.write(image64, "PNG", new File("D:\\Ajit\\Script_SS\\Faredepot\\7_AppliedInsurance.png"));
                   Thread.sleep(7000);
                   
                   String myArg5 = "D:\\Ajit\\Script_SS\\Faredepot\\7_AppliedInsurance.png";
                   String myArg6 = "D:\\Ajit\\Script_SS\\Daily Sanity\\Oct_2017\\11 Oct\\Faredepot\\Faredepot\\7_AppliedInsurance.png";
                   String myCommand2 = "D:\\Ajit\\Script_SS\\ImageCompConsole.exe";
                   String Output2 = "D:\\Ajit\\Script_SS\\Differences of Images\\Faredepot\\7_AppliedInsurance.png";
                
                   ProcessBuilder pb2 = new ProcessBuilder(myCommand2, myArg5, myArg6, Output2, Log);
                   pb2.directory(new File("D:\\Ajit\\Script_SS"));
                   Process p2 = pb2.start();
               
                   System.out.println("" +p2);
            */       
                   //For Remove insurance
        /*            
                   WebElement element = driver.findElement(By.cssSelector("#section_insurance > div.insurance-sec > div > div.travel-box > div.preferences-insurance-box.spcInsuContianer > div.insurance-travelguard-no-text > p [id*='InsurranceCHK_NON"));
                   JavascriptExecutor js =(JavascriptExecutor)driver;
                   js.executeScript("window.scrollTo(0,'element.getLocation().y+')");
                   element.sendKeys(Keys.ENTER);
        */           
                   WebElement element11 = driver.findElement(By.cssSelector("#section_insurance > div.insurance-sec > div > div.travel-box > div.preferences-insurance-box.spcInsuContianer > div.insurance-travelguard-no-text > p [id*='InsurranceCHK_NON"));
		           JavascriptExecutor executor11 = (JavascriptExecutor) driver;
		           executor11.executeScript("arguments[0].click();", element11);
                   Thread.sleep(1000);
                   
                   driver.findElement(By.cssSelector("#DivTravlGuardPopup > div.inscontent > div.inscontentbox > div.button2 [class*='select-op bPopup-close']")).click();
                   Thread.sleep(6000);
                   
                   Reporter.log("Insurance Removed successfully..");
                   
                   //For check insurance price
                   String insprice = driver.findElement(By.cssSelector("#trip_summary_package_total")).getText();
                   Reporter.log("Prices of After removed insurance on the Payment page:- " +insprice);
                   Thread.sleep(3000);  
             /*      
                   final Screenshot screenshot66 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                   final BufferedImage image66 = screenshot66.getImage();
                   ImageIO.write(image66, "PNG", new File("D:\\Ajit\\Script_SS\\Faredepot\\8_RemovedInsurance.png"));
                   Thread.sleep(4000);
                   
                   String myArg7 = "D:\\Ajit\\Script_SS\\Faredepot\\8_RemovedInsurance.png";
                   String myArg8 = "D:\\Ajit\\Script_SS\\Daily Sanity\\Oct_2017\\11 Oct\\Faredepot\\Faredepot\\8_RemovedInsurance.png";
                   String myCommand3 = "D:\\Ajit\\Script_SS\\ImageCompConsole.exe";
                   String Output3 = "D:\\Ajit\\Script_SS\\Differences of Images\\Faredepot\\8_RemovedInsurance.png";
                
                   ProcessBuilder pb3 = new ProcessBuilder(myCommand3, myArg7, myArg8, Output3, Log);
                   pb3.directory(new File("D:\\Ajit\\Script_SS"));
                   Process p3 = pb3.start();
               
                   System.out.println("" +p3);
              */    
         	 }     
         }
         catch(Exception e)
         {
         	   System.out.println("Insurance not applied/removed...");
  	           System.out.println("\n");
  	           System.out.println("Insurance not applied/removed on confirmation page...");
  	           System.out.println("\n");
  	           ExtractJSLogs();
        /*     
               final Screenshot screenshot72 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
               final BufferedImage image72 = screenshot72.getImage();
               ImageIO.write(image72, "PNG", new File("D:\\Ajit\\Script_SS\\FaredepotError\\9_InsurancenotAppliedOrRemoved.png"));
      */
               Assert.assertFalse(false, "FAIL");
               Reporter.log("Insurance not applied/removed...");
	           AssertJUnit.assertTrue("Insurance not applied/removed....", faredptpurchse.isDisplayed());
	           throw(e);
         }
         
         //For Additional Services
         try
         {
        	  driver.findElement(By.cssSelector("#st-accordion > ul > li:nth-child(4) > a")).sendKeys(Keys.ENTER);
        	  Thread.sleep(1000);
        /*	  
        	  File scr03 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
              org.codehaus.plexus.util.FileUtils.copyFile(scr03, new File("D:\\Ajit\\Script_SS\\Faredepot\\9_AdditionalServiceOnCheckoutpage.png")); 
        	  Thread.sleep(1500);
        	  
        	  String myArg7 = "D:\\Ajit\\Script_SS\\Faredepot\\9_AdditionalServiceOnCheckoutpage.png";
              String myArg8 = "D:\\Ajit\\Script_SS\\Daily Sanity\\Oct_2017\\11 Oct\\Faredepot\\Faredepot\\9_AdditionalServiceOnCheckoutpage.png";
              String myCommand3 = "D:\\Ajit\\Script_SS\\ImageCompConsole.exe";
              String Output3 = "D:\\Ajit\\Script_SS\\Differences of Images\\Faredepot\\9_AdditionalServiceOnCheckoutpage.png";
           
              ProcessBuilder pb3 = new ProcessBuilder(myCommand3, myArg7, myArg8, Output3, Log);
              pb3.directory(new File("D:\\Ajit\\Script_SS"));
              Process p3 = pb3.start();
          
              System.out.println("" +p3);
		*/	  
         }
         catch(Exception e)
         {
		 /*	 
        	 final Screenshot screenshot74 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
             final BufferedImage image74 = screenshot74.getImage();
             ImageIO.write(image74, "PNG", new File("D:\\Ajit\\Script_SS\\FaredepotError\\10_ErrorOnAdditionalService.png"));
             Thread.sleep(1000);
        */     
             AssertJUnit.assertTrue("Additional Service not working or showing error on additional service page", faredptpurchse.isDisplayed());
	         throw(e);
         }
         
        //For Payment Information
         try
         {
        	  driver.findElement(By.xpath("//*[@id='st-accordion']/ul/li[5]/a")).click();
        	  Thread.sleep(2000);
        /*	  
        	  final Screenshot screenshot76 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
              final BufferedImage image76 = screenshot76.getImage();
              ImageIO.write(image76, "PNG", new File("D:\\Ajit\\Script_SS\\Faredepot\\11_PaymentInfoPage.png"));
        	  Thread.sleep(2000);
        	  
        	  String myArg7 = "D:\\Ajit\\Script_SS\\Faredepot\\11_PaymentInfoPage.png";
              String myArg8 = "D:\\Ajit\\Script_SS\\Daily Sanity\\Oct_2017\\11 Oct\\Faredepot\\Faredepot\\11_PaymentInfoPage.png";
              String myCommand3 = "D:\\Ajit\\Script_SS\\ImageCompConsole.exe";
              String Output3 = "D:\\Ajit\\Script_SS\\Differences of Images\\Faredepot\\11_PaymentInfoPage.png";
           
              ProcessBuilder pb3 = new ProcessBuilder(myCommand3, myArg7, myArg8, Output3, Log);
              pb3.directory(new File("D:\\Ajit\\Script_SS"));
              Process p3 = pb3.start();
          
              System.out.println("" +p3);
		*/	  
         }
         catch(Exception e)
         {
		/*	 
        	 final Screenshot screenshot77 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
             final BufferedImage image77 = screenshot77.getImage();
             ImageIO.write(image77, "PNG", new File("D:\\Ajit\\Script_SS\\FaredepotError\\10_ErrorOnPaymentInfoPage.png"));
             Thread.sleep(1000);
         */    
             AssertJUnit.assertTrue("Payment information tab is not working or showing error on payment page", faredptpurchse.isDisplayed());
	         throw(e);
         }
         
         // Price verify for the checkout page to result page
         if(priceoncheckout.equals(totalpriceonresult))
         {
                System.out.println("Result page and Checkout page's Price matched");
                Reporter.log("Result page and Checkout page's Price matched..");
                   	 
                 System.out.println("Actual price is:- " +priceoncheckout);
			     Reporter.log("Actual price is:- " +priceoncheckout);
         }
         else
         {
					  System.out.println("Result page and Checkout page's Price not match..");
					  Reporter.log("Result page and Checkout page's Price not match..");
					  System.out.println("Actual price is:- " +priceoncheckout);
					  Reporter.log("Actual price is:- " +priceoncheckout);
		  }
         
                    Thread.sleep(1500);
         
         //For verify prices on payment page (Payment page to Checkout page)
         String priceonpaymnt = driver.findElement(By.xpath("//*[@id='_ctl0__ctl0_MainContentsParentPH_MainContentsPH__ctl0__ctl4_BillingAddressContainer']/div[1]/a/span")).getText();
         Reporter.log("Price on payment page: " +priceonpaymnt);
         
         if(priceonpaymnt.equals(priceoncheckout))
         {
             System.out.println("Checkout page and Payment page's Price matched");
             Reporter.log("Checkout page and Payment page's Price matched..");
                   	 
             System.out.println("Actual price is:- " +priceoncheckout);
			 Reporter.log("Actual price is:- " +priceoncheckout);
         }
         else
         {
					  System.out.println("Checkout page and Payment page's Price not match..");
					  Reporter.log("Checkout page and Payment page's Price not match..");
					  System.out.println("Actual price is:- " +priceoncheckout);
					  Reporter.log("Actual price is:- " +priceoncheckout);
		  }
         
                    Thread.sleep(1500);
                    
                  //For the compare logs
       		        String ConsleArgument = "D:\\Ajit\\Script_SS\\ConsoleError\\FaredepotError.txt";
                    String ConsoleCommand = "D:\\Ajit\\Script_SS\\ConsoleApplication2.exe";
                    String ConsoleOutput = "D:\\Ajit\\Script_SS\\FaredepotError\\UncaughtFaredepot.txt";
                    
                    ProcessBuilder pb05 = new ProcessBuilder(ConsoleCommand, ConsleArgument, ConsoleOutput);
                    pb05.directory(new File("D:\\Ajit\\Script_SS"));
                    Process p05 = pb05.start();
                    
                    System.out.println("" +p05);    
                      
                    Thread.sleep(1000);
          
    }
   
   @DataProvider
   public String[][] Authentication() throws Exception
   {
   	 
  	     String[][] testObjArray = FaredepotUtils.getTableArray("D:\\Ajit\\Automation\\Workspace\\Odysseus_Product\\src\\main\\java\\testData\\FaredepotData.xlsx","Sheet1");
  	     return testObjArray;
  	     
   }
   
   
   @AfterClass
   public void closeBrowser() throws InterruptedException
   {
   	
	 //write excel file and file name is TestResult.xls 
       Set<String> keyset = testresultdata.keySet();
       int rownum = 0;
       for (String key : keyset)
       {
           Row row = sheet.createRow(rownum++);
           Object [] objArr = testresultdata.get(key);
           int cellnum = 0;
           for (Object obj : objArr) 
           {
               Cell cell = row.createCell(cellnum++);
               if(obj instanceof Date) 
                   cell.setCellValue((Date)obj);
               else if(obj instanceof Boolean)
                   cell.setCellValue((Boolean)obj);
               else if(obj instanceof String)
                   cell.setCellValue((String)obj);
               else if(obj instanceof Double)
                   cell.setCellValue((Double)obj);
           }
           
           try 
           {
               FileOutputStream out =new FileOutputStream(new File("D:\\Ajit\\Automation\\Workspace\\Odysseus_Product\\src\\main\\java\\testData\\AirSanityPrices.xlsx"));
               workbook.write(out);
               out.close();
               System.out.println("Excel written successfully..");
             
           } catch (FileNotFoundException e) 
             {
                  e.printStackTrace();
            
             } catch (IOException e) 
               {
                  e.printStackTrace();
               }
       }
	   
	   driver.close();
  	 
  	   /*
  	        if(driver!=null) 
  	        {
  		         System.out.println("Closing the browser");
  		         driver.quit();
  	        }   
     */
   	
   }

	
}
