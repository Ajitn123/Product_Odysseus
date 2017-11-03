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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.screentaker.ViewportPastingStrategy;
import Utility.CDORUtils;


public class CDORTest 
{

	    CDORPurchasepageobjct crspurchpge;
	    CDORBookingpgeobjct crsbkngpge;
        public static WebDriver driver;
        Reporter report = new Reporter();
        
        String Log = "D:\\Ajit\\Script_SS\\Differences of Images\\Logs\\CDOR.txt";

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
          driver.navigate().to("https://book.cruisedirect.com/web/cruises/search.aspx?");
          Thread.sleep(4000);
          
     try
     {
          if(driver.findElement(By.cssSelector("#cbar_popup_20148 > img")).isDisplayed())
          {
        	  driver.findElement(By.cssSelector("#cbar_popup_20148 > img")).click();
        	  Thread.sleep(2000);
          }
          
     }
     catch(Exception e)
     {
    	 e.getMessage();
     }
/*
          //Save console
          String testResultFile="D:\\Ajit\\Script_SS\\ConsoleError\\CDORBookingError.txt";
          File file = new File(testResultFile);  
          FileOutputStream fis = new FileOutputStream(file);  
          PrintStream out = new PrintStream(fis);  
          System.setOut(out); 
               
          Thread.sleep(1000);
 
          final Screenshot screenshot1 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
          final BufferedImage image1 = screenshot1.getImage();
          ImageIO.write(image1, "PNG", new File("D:\\Ajit\\Script_SS\\CDOR\\1_Searchpage.png"));
          Thread.sleep(1000);
          
          String myArg1 = "D:\\Ajit\\Script_SS\\CDOR\\1_Searchpage.png";
          String myArg2 = "D:\\Ajit\\Script_SS\\Daily Sanity\\Oct_2017\\11 Oct\\CDOR\\CDOR\\1_Searchpage.png";
          String myCommand = "D:\\Ajit\\Script_SS\\ImageCompConsole.exe";
          String Output = "D:\\Ajit\\Script_SS\\Differences of Images\\CDOR\\1_Searchpage.png";
           
          ProcessBuilder pb = new ProcessBuilder(myCommand, myArg1, myArg2, Output, Log);
          pb.directory(new File("D:\\Ajit\\Script_SS"));
          Process p = pb.start();
          
          System.out.println("" +p);
             
          System.out.println("\n");
	      System.out.println("Searchpage Logs..");
	      System.out.println("\n");
	      ExtractJSLogs();
	*/      	      
         //driver.navigate().to("https://localhost/odyssey/website/air/results.aspx?");
         Thread.sleep(4000);
         crsbkngpge = PageFactory.initElements(driver, CDORBookingpgeobjct.class);
         crspurchpge = PageFactory.initElements(driver, CDORPurchasepageobjct.class);
         
     } 
      
      
 /*
    public void ExtractJSLogs()
    {
         LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);

           for (LogEntry entry : logEntries) 
           {
                System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
           }
    }
*/
    @Test(dataProvider="Authentications")
    public void CDOR_data(String Firstname_GuestOne, String Middlename_GuestOne, String Lastname_GuestOne, String Email, String Phone, String Firstname_GuestTwo, String Middlename_GuestTwo, String Lastname_GuestTwo) throws Exception
    {
	
    	try
        {
   		     //For web site and booking details
             Reporter.log("Website Name :- CDOR");
             Thread.sleep(200);
   		 
   		     Reporter.log("Cruise line :- Viking Ocean Cruises");
   		     Thread.sleep(1500);
   		 
       	     crsbkngpge.BookingToTittle();
       	     long start = System.currentTimeMillis();
       	     Thread.sleep(4010);
       	     
       	     long finish = System.currentTimeMillis();
             long totalTime = finish - start; 
             Reporter.log("Total Time for serch page to result page load(Milisec) - "+totalTime); 
             Thread.sleep(1000);
          
       	     System.out.println("\n");
  	         System.out.println("Resultpage Logs..");
  	         System.out.println("\n");
  	     //    ExtractJSLogs();
  	        
             Thread.sleep(1000);
       
        //For verify error message on result page     
        try
        {
            	  if(driver.findElement(By.cssSelector("#main-content > div.site-content.scw-690 > div > div.error-message-wrapper > div > div > div > table > tbody > tr:nth-child(2) > td")).isDisplayed())
                  {
                 	   String err = driver.findElement(By.cssSelector("#MainForm > table > tbody > tr:nth-child(2) > td")).getText();
                	   Thread.sleep(300);
                	   Reporter.log("Error message: " +err);
                	   Thread.sleep(1000);
                	/* 
                	   final Screenshot screenshot87 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
      	               final BufferedImage image87 = screenshot87.getImage();
      	               ImageIO.write(image87, "PNG", new File("D:\\Ajit\\Script_SS\\CDORError\\04_Erroronresultpage.png"));
      	          */
           	           Assert.assertFalse(false, "FAIL");
           	           AssertJUnit.assertTrue("Error on result page..: " +err, crsbkngpge.isDisplayed());
           	           return;
                  }
                  else
                  {
    			      driver.navigate().refresh();	
    			  }
        }
        catch(Exception e)
        {
            	  e.getMessage();
        }      
  	 /*
               Thread.sleep(300);
  	           final Screenshot screenshot4 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
               final BufferedImage image4 = screenshot4.getImage();
               ImageIO.write(image4, "PNG", new File("D:\\Ajit\\Script_SS\\CDOR\\2_Resultpage.png"));
           
               Thread.sleep(7000);
               
               String myArg1 = "D:\\Ajit\\Script_SS\\CDOR\\2_Resultpage.png";
               String myArg2 = "D:\\Ajit\\Script_SS\\Daily Sanity\\Oct_2017\\11 Oct\\CDOR\\CDOR\\2_Resultpage.png";
               String myCommand = "D:\\Ajit\\Script_SS\\ImageCompConsole.exe";
               String Output = "D:\\Ajit\\Script_SS\\Differences of Images\\CDOR\\2_Resultpage.png";
               
               ProcessBuilder pb = new ProcessBuilder(myCommand, myArg1, myArg2, Output, Log);
               pb.directory(new File("D:\\Ajit\\Script_SS"));
               Process p = pb.start();
                
               System.out.println("" +p);
              */
        }
        catch(Exception e)
        {
       	     System.out.println("\n");
  	         System.out.println("Time out or Invalid search criteria on resultpage Logs..");
  	         System.out.println("\n");
  	   //      ExtractJSLogs();
   	 /*
	         final Screenshot screenshot33 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	         final BufferedImage image33 = screenshot33.getImage();
	         ImageIO.write(image33, "PNG", new File("D:\\Ajit\\Script_SS\\CDORError\\1_TimeoutORinvalidsearchdetails.png"));
	     */     
   	         Assert.assertFalse(false, "FAIL");
   	         Reporter.log("Time out or Invalid search criteria on resultpage..");
   	         AssertJUnit.assertTrue("Time out or Invalid search criteria on resultpage...", crsbkngpge.isDisplayed());
   	         throw(e);
        }
    	
    	//For Select cruise from result page
        try
        {
                      driver.navigate().refresh();
                      
                      driver.get("https://book.cruisedirect.com/web/cruises/results.aspx?showtrace=true");
                       
                      Thread.sleep(3000);  
                             
                      // For the bonus offers
                 try
                 {
                      if(driver.findElement(By.cssSelector("#ResultsContainer > div.page-content.mar-lg-top.search > section > div:nth-child(3) > section > table > tbody > tr:nth-child(1) > td.bonus-td.hidden-xs > a:nth-child(2) > img")).isDisplayed())
                      {
                      	  Reporter.log("Bonus Offers are available..");
                      	  driver.findElement(By.cssSelector("#ResultsContainer > div.page-content.mar-lg-top.search > section > div:nth-child(3) > section > table > tbody > tr:nth-child(1) > td.bonus-td.hidden-xs > a:nth-child(2) > img")).click();
                          Thread.sleep(1500);
               /*           
                          File scr22 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            	          org.codehaus.plexus.util.FileUtils.copyFile(scr22, new File("D:\\Ajit\\Script_SS\\CDOR\\3_Bonusoffers.png")); 
                          
                          Thread.sleep(3000);
                          
                          String myArg1 = "D:\\Ajit\\Script_SS\\CDOR\\3_Bonusoffers.png";
                          String myArg2 = "D:\\Ajit\\Script_SS\\Daily Sanity\\Oct_2017\\11 Oct\\CDOR\\CDOR\\3_Bonusoffers.png";
                          String myCommand = "D:\\Ajit\\Script_SS\\ImageCompConsole.exe";
                          String Output = "D:\\Ajit\\Script_SS\\Differences of Images\\CDOR\\3_Bonusoffers.png";
                          
                          ProcessBuilder pb = new ProcessBuilder(myCommand, myArg1, myArg2, Output);
                          pb.directory(new File("D:\\Ajit\\Script_SS"));
                          Process p = pb.start();
                          
                          System.out.println("" +p);
                           */ 
                      	  driver.navigate().refresh();
                      	  Thread.sleep(3000);
                      }
                 }
                 catch(Exception e)
                 {
                	 e.getMessage();
                 }
                       
                         driver.findElement(By.cssSelector("#ResultsContainer > div.page-content.mar-lg-top.search > section > div:nth-child(5) > section > table > tbody > tr:nth-child(3) > td.text-center.btn-td [class*='red-btn']")).sendKeys(Keys.ENTER);  // Select cruise
	                                          
	      }
	      catch(Exception e)
	      {
       	         System.out.println("Cruise not available..");
       	         System.out.println("\n");
       	         System.out.println("Cruise not available on resultpage Logs..");
       	         System.out.println("\n");
       	    //     ExtractJSLogs();
          /*
                 final Screenshot screenshot5 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                 final BufferedImage image5 = screenshot5.getImage();
                 ImageIO.write(image5, "PNG", new File("D:\\Ajit\\Script_SS\\CDORError\\2_Cruisenotavailable.png"));
          */
                 Assert.assertFalse(false, "FAIL");
                 Reporter.log("Cruise not available..");
		         AssertJUnit.assertTrue("Cruise not available...", crsbkngpge.isDisplayed());
		         throw(e);
	       }
        
                long start = System.currentTimeMillis(); 
                Thread.sleep(2040); 
                
                System.out.println("\n");
                System.out.println("Cruise detailspage Logs..");
                System.out.println("\n");
           //     ExtractJSLogs();              
                Thread.sleep(700);
                
                long finish = System.currentTimeMillis();
                long totalTime = finish - start; 
                Reporter.log("Total Time for result page to details page load(Milisec) - "+totalTime); 
                Thread.sleep(1000);
    /*
                final Screenshot screenshot60 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                final BufferedImage image60 = screenshot60.getImage();
                ImageIO.write(image60, "PNG", new File("D:\\Ajit\\Script_SS\\CDOR\\4_Cruisedetailspage.png"));
                Thread.sleep(2000);
                
                String myArg11 = "D:\\Ajit\\Script_SS\\CDOR\\4_Cruisedetailspage.png";
                String myArg12 = "D:\\Ajit\\Script_SS\\Daily Sanity\\Oct_2017\\11 Oct\\CDOR\\CDOR\\4_Cruisedetailspage.png";
                String myCommand7 = "D:\\Ajit\\Script_SS\\ImageCompConsole.exe";
                String Output7 = "D:\\Ajit\\Script_SS\\Differences of Images\\CDOR\\4_Cruisedetailspage.png";
                
                ProcessBuilder pb7 = new ProcessBuilder(myCommand7, myArg11, myArg12, Output7, Log);
                pb7.directory(new File("D:\\Ajit\\Script_SS"));
                Process p7 = pb7.start();
                
                System.out.println("" +p7);
               */
                System.out.println("Cruise selected successfully..");
                 
                Thread.sleep(4000);

              //For the Cruise details print on test report
                String depart = driver.findElement(By.cssSelector("#left-panel > div.card.step-three-page > div.text-center.card-content > div.card-container > div.row > div > div:nth-child(1) > div.col-xs-7.text-right > p")).getText();
                Reporter.log("Departure Port:- " +depart);
                Thread.sleep(500);
                String sailing = driver.findElement(By.cssSelector("#left-panel > div.card.step-three-page > div.text-center.card-content > div.card-container > div.row > div > div:nth-child(2) > div.col-xs-7.text-right > p")).getText();
                Reporter.log("Sailing Dates:- " +sailing);
                Thread.sleep(800);
                String shp = driver.findElement(By.cssSelector("#left-panel > div.card.step-three-page > div.text-center.card-content > div.card-container > div.row > div > div:nth-child(3) > div.col-xs-7.text-right > p")).getText();
                Reporter.log("Ship:- " +shp);
                Thread.sleep(500);
                String dstntn = driver.findElement(By.cssSelector("#left-panel > div.card.step-three-page > div.text-center.card-content > div.card-container > div.row > div > div:nth-child(4) > div.col-xs-8.col-md-8.text-right.padleft0.padright0 > p")).getText();
                Reporter.log("Destination:- " +dstntn);
                Thread.sleep(400);
                String drtn = driver.findElement(By.cssSelector("#left-panel > div.card.step-three-page > div.text-center.card-content > div.card-container > div.row > div > div:nth-child(5) > div.col-xs-7.text-right > p")).getText();
                Reporter.log("Duration:- " + drtn);
                Thread.sleep(400);
                
                
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
                    Thread.sleep(300);
                    driver.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0__ctl0_ResidentState']/option[3]")).click();
                    Thread.sleep(300);
                  if(driver.findElement(By.id("_ctl0_MainContentsPH__ctl0__ctl0_EmailTXT")).isDisplayed())
                  {
                      driver.findElement(By.id("_ctl0_MainContentsPH__ctl0__ctl0_EmailTXT")).click();
                      Thread.sleep(300);
                      driver.findElement(By.id("_ctl0_MainContentsPH__ctl0__ctl0_EmailTXT")).sendKeys("ajit_nakum@odysseussolutions.com");
                      Thread.sleep(300);
                  }  
                    driver.findElement(By.id("_ctl0_MainContentsPH__ctl0__ctl0_CategoryBTN")).click();
                    long start1 = System.currentTimeMillis();
                    Thread.sleep(7012);
                    
                    System.out.println("\n");
          	        System.out.println("Categorypage Logs..");
          	        System.out.println("\n");
          	  //      ExtractJSLogs();
                    
                    Thread.sleep(700);
                    long finish1 = System.currentTimeMillis();
                    long totalTime1 = finish1 - start1; 
                    Reporter.log("Total Time for details page to category page load(Milisec) - "+totalTime1); 
                    Thread.sleep(1000);
         }
         catch(Exception e)
         {
                   	System.out.println("\n");
          	        System.out.println("Invalid guest information on cruise detailspage Logs..");
          	        System.out.println("\n");
          	   //     ExtractJSLogs();
           	 /*
      	            final Screenshot screenshot80 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
      	            final BufferedImage image80 = screenshot80.getImage();
      	            ImageIO.write(image80, "PNG", new File("D:\\Ajit\\Script_SS\\CDORError\\3_InvalidGuestinformation.png"));
      	     */     
           	        Assert.assertFalse(false, "FAIL");
           	        Reporter.log("Invalid guest information's on detailspage...");
           	        AssertJUnit.assertTrue("Invalid guest information's on detailspage...", crsbkngpge.isDisplayed());
           	        throw(e);
          }
                  driver.navigate().refresh();
                  Thread.sleep(2000);
           /*       
                  final Screenshot screenshot61 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                  final BufferedImage image61 = screenshot61.getImage();
                  ImageIO.write(image61, "PNG", new File("D:\\Ajit\\Script_SS\\CDOR\\5_Categorypage.png"));
                  Thread.sleep(3000);
                  
                  String myArg3 = "D:\\Ajit\\Script_SS\\CDOR\\5_Categorypage.png";
                  String myArg4 = "D:\\Ajit\\Script_SS\\Daily Sanity\\Oct_2017\\11 Oct\\CDOR\\CDOR\\5_Categorypage.png";
                  String myCommand1 = "D:\\Ajit\\Script_SS\\ImageCompConsole.exe";
                  String Output1 = "D:\\Ajit\\Script_SS\\Differences of Images\\CDOR\\5_Categorypage.png";
                  
                  ProcessBuilder pb1 = new ProcessBuilder(myCommand1, myArg3, myArg4, Output1, Log);
                  pb1.directory(new File("D:\\Ajit\\Script_SS"));
                  Process p1 = pb1.start();
                  
                  System.out.println("" +p1);
                 */
           try
           {
        	   if(driver.findElement(By.id("TracerBlock")).isDisplayed())
        	   {
                  String expr1 = driver.findElement(By.id("TracerBlock")).getText();
                  String proccessingloops = expr1.split("WEB-93")[29].split(":")[2].trim();
                  Reporter.log("Category processing loop :- " +proccessingloops);
                  Thread.sleep(500);
        	   }   
           }
           catch(Exception e)
           {
        	   e.getMessage();
           }
           
           try
           {
        	   if(driver.findElement(By.id("TracerBlock")).isDisplayed())
        	   {
        		  String expr1 = driver.findElement(By.id("TracerBlock")).getText();
                  String totalprocesstime = expr1.split("WEB-93")[35].split(":")[2].trim();
                  Reporter.log("TotalProcessing Time on category page:- " +totalprocesstime);
                  Thread.sleep(3000);
        	   }   
           }
           catch(Exception e)
           {
        	   e.getMessage();
           }
         
         try
         {
             //For select category on the category page
        //	 driver.findElement(By.cssSelector("#main-item > table > tbody > tr > td:nth-child(4) > div > a > span [class*='hidden-xs hidden-sm']")).click();
        	 WebElement element = driver.findElement(By.cssSelector("#main-item > table > tbody > tr > td:nth-child(4) > div > a > span [class*='hidden-xs hidden-sm']"));
        	 JavascriptExecutor executor = (JavascriptExecutor) driver;
             executor.executeScript("arguments[0].click();", element);
        	 Thread.sleep(3000); 
             
           try
           {
                // For verify error on category page
            	if(driver.findElement(By.cssSelector("#main-content > div.site-content.scw-690 > div > div:nth-child(6) > div > div > div > table > tbody > tr:nth-child(2) > td")).isDisplayed())
            	{
            		String err = driver.findElement(By.cssSelector("#main-content > div.site-content.scw-690 > div > div:nth-child(6) > div > div > div > table > tbody > tr:nth-child(2) > td")).getText();
            	    Thread.sleep(300);
            	    Reporter.log("Error on categpry page: " +err);
            	    Thread.sleep(1000);
            /*	    
            	    final Screenshot screenshot87 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
     	            final BufferedImage image87 = screenshot87.getImage();
     	            ImageIO.write(image87, "PNG", new File("D:\\Ajit\\Script_SS\\CDORError\\04_Erroroncategorypage.png"));
     	       */   
          	        Assert.assertFalse(false, "FAIL");
          	        AssertJUnit.assertTrue("Error on categpry page..: " +err, crsbkngpge.isDisplayed());
          	        return;
            	}
           }
           catch(Exception e)
           {
        	    e.getMessage();
           }
             
         }
         catch(Exception e)
         {
        	/* 
          	   final Screenshot screenshot80 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	           final BufferedImage image80 = screenshot80.getImage();
	           ImageIO.write(image80, "PNG", new File("D:\\Ajit\\Script_SS\\CDORError\\4_Pricenotavailableoncategorypage.png"));
	        */  
     	       Assert.assertFalse(false, "FAIL");
     	       Reporter.log("Category not availabe...");
     	       AssertJUnit.assertTrue("Category not availabe...", crsbkngpge.isDisplayed());
     	       throw(e);
          }	    
                long start2 = System.currentTimeMillis();
                Thread.sleep(4600);
               
               System.out.println("\n");
               System.out.println("Cabin selection page Logs..");
               System.out.println("\n");
          //     ExtractJSLogs();              
               Thread.sleep(750);
               
               long finish1 = System.currentTimeMillis();
               long totalTime1 = finish1 - start2; 
               Reporter.log("Total Time for category page to cabin selection page load(Milisec) - "+totalTime1); 
               Thread.sleep(1000);
/*
               final Screenshot screenshot62 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
               final BufferedImage image62 = screenshot62.getImage();
               ImageIO.write(image62, "PNG", new File("D:\\Ajit\\Script_SS\\CDOR\\6_Cabinselectionpage.png"));
               Thread.sleep(3000);
               
               String myArg5 = "D:\\Ajit\\Script_SS\\CDOR\\6_Cabinselectionpage.png";
               String myArg6 = "D:\\Ajit\\Script_SS\\Daily Sanity\\Oct_2017\\11 Oct\\CDOR\\CDOR\\6_Cabinselectionpage.png";
               String myCommand3 = "D:\\Ajit\\Script_SS\\ImageCompConsole.exe";
               String Output3 = "D:\\Ajit\\Script_SS\\Differences of Images\\CDOR\\6_Cabinpage.png";
               
               ProcessBuilder pb3 = new ProcessBuilder(myCommand3, myArg5, myArg6, Output3, Log);
               pb3.directory(new File("D:\\Ajit\\Script_SS"));
               Process p3 = pb3.start();
               
               System.out.println("" +p3);
            */  
               System.out.println("Category selected successfully..");
          
               Thread.sleep(5000);
             
               //For check price and booking details on cabin page
               String priceoncabin= driver.findElement(By.cssSelector("#left-panel > div.card.step-three-page > div.text-center.card-content > div:nth-child(2) > div.hidden-xs > div > div:nth-child(2) > div.col-xs-6.col-sm-6.text-right > p")).getText();
               System.out.println("Prices on cabin page is:- " +priceoncabin);
               Reporter.log("Prices on cabin page is:- " +priceoncabin);
               Thread.sleep(2000);
               String pricewthtaxoncabin= driver.findElement(By.cssSelector("#left-panel > div.card.step-three-page > div.text-center.card-content > div:nth-child(2) > div.hidden-xs > div > div:nth-child(3) > div.col-xs-6.col-sm-6.text-right > p")).getText();
               System.out.println("Estimates Taxes & Fees on cabin page is:- " +pricewthtaxoncabin);
               Reporter.log("Estimates Taxes & Fees on cabin page is:- " +pricewthtaxoncabin);
               Thread.sleep(2000);
               String noofguestoncabin= driver.findElement(By.cssSelector("#left-panel > div.card.step-three-page > div.text-center.card-content > div.card-container > div.hidden-xs.additional-info > div:nth-child(3) > div.col-xs-6.passengers.text-right > p")).getText();
               System.out.println("No of Guests:- " +noofguestoncabin);
               Reporter.log("No of Guest:- " +noofguestoncabin);
               Thread.sleep(2000);
                              
               //For check API, Office id And Test environment on cabin page
               String expr = driver.findElement(By.id("TracerBlock")).getText();
               String api = expr.split("OdysseyGateway")[6].split(":")[1].trim();
             //List<String> items = Arrays.asList(expr.split("$($('#TracerBlock')[0].innerHTML.split('OdysseyGateway')[2])[0].nodeValue.toString().split(':')[1]"));
               Reporter.log("API :- " +api);
               Thread.sleep(500);
               String envrnmnt = expr.split("OdysseyGateway")[6].split(":")[2].trim();
               Reporter.log("Environment :- " +envrnmnt);
               Thread.sleep(500);
               String officeid = expr.split("OdysseyGateway")[6].split(":")[3].trim();
               Reporter.log("Office Id :- " +officeid);
               Thread.sleep(3000);
               
          //For select cabin from the cabin selection page
          try
          {
                              driver.findElement(By.cssSelector("#MainForm > div.step-three-page > div > div > div.step-block > div > div.step-3 > div > div.room-selection > div:nth-child(2) > div.col-xs-4.btn-wrap [id*='CabinBook_']")).sendKeys(Keys.ENTER);
                              Thread.sleep(2000);
                              driver.navigate().refresh();
                              
          }
          catch(Exception e)
          {
                          	      System.out.println("Cabin not available..");
                          	      System.out.println("\n");
                          	      System.out.println("Cabin not available on select cabinpage Logs..");
                          	      System.out.println("\n");
                          	 //     ExtractJSLogs();
                          /*   
                                  final Screenshot screenshot13 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                                  final BufferedImage image13 = screenshot13.getImage();
                                  ImageIO.write(image13, "PNG", new File("D:\\Ajit\\Script_SS\\VivaVoyageError\\4_Cabinnotavailable.png"));
                             */
                                  Assert.assertFalse(false, "FAIL");
              	                  Reporter.log("Cabin not available..");
              			          AssertJUnit.assertTrue("Cabin not available...", crsbkngpge.isDisplayed());
              			          throw(e);
           }
                                   long start4 = System.currentTimeMillis();
                                   Thread.sleep(1000);
                                   System.out.println("\n");
                                   System.out.println("Purchase page Logs..");
                                   System.out.println("\n");
                            //       ExtractJSLogs();              
                                   Thread.sleep(1000);
                                   
                                   long finish11 = System.currentTimeMillis();
                                   long totalTime11 = finish11 - start4; 
                                   Reporter.log("Total Time for cabin selection page to purchase page load(Milisec) - "+totalTime11); 
                                   Thread.sleep(1000);
                                   
                                   driver.navigate().refresh();
                                   Thread.sleep(2000);
                         /*
                                   final Screenshot screenshot102 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                                   final BufferedImage image102 = screenshot102.getImage();
                                   ImageIO.write(image102, "PNG", new File("D:\\Ajit\\Script_SS\\CDOR\\7_Purchasepage.png"));
                                   Thread.sleep(2000);
                                   
                                   String myArg7 = "D:\\Ajit\\Script_SS\\CDOR\\7_Purchasepage.png";
                                   String myArg8 = "D:\\Ajit\\Script_SS\\Daily Sanity\\Oct_2017\\11 Oct\\CDOR\\CDOR\\7_Purchasepage.png";
                                   String myCommand4 = "D:\\Ajit\\Script_SS\\ImageCompConsole.exe";
                                   String Output4 = "D:\\Ajit\\Script_SS\\Differences of Images\\CDOR\\7_Purchasepage.png";
                                   
                                   ProcessBuilder pb4 = new ProcessBuilder(myCommand4, myArg7, myArg8, Output4, Log);
                                   pb4.directory(new File("D:\\Ajit\\Script_SS"));
                                   Process p4 = pb4.start();
                                   
                                   System.out.println("" +p4);
                  */
                                   System.out.println("Cabin selected successfully..");
                         
                                   Thread.sleep(4000);
                                   
                                   //Check price on purchase page
                                   String priceonpurchase= driver.findElement(By.cssSelector("#MainForm > div.booking-steps-body > div.step-block > div.step-content > div > div.step-5.booking-step > div:nth-child(2) > div.bg-blue.bonuses-summary > div > div.col-xs-4.col-sm-2.text-center.pad-fix > p")).getText();
                                   System.out.println("Prices on purchase page is:- " +priceonpurchase);
                                   Reporter.log("Prices on purchase page is:- " +priceonpurchase);
                                   Thread.sleep(2000);   
                                   
             //For Purchase page                 
             try
             {
                                        System.out.println("FirstName_Of_Guest1: " + Firstname_GuestOne);
                                        System.out.println("MiddleName_Of_Guest1: " + Middlename_GuestOne);
                                        System.out.println("LastName_Of_Guest1: " + Lastname_GuestOne);
                                        System.out.println("Email: " + Email);
                                        System.out.println("Phone: " + Phone);
                                        System.out.println("FirstName_Of_Guest2: " + Firstname_GuestTwo);
                                        System.out.println("MiddleName_Of_Guest2: " + Middlename_GuestTwo);
                                        System.out.println("Lastname_of_Guest2: " + Lastname_GuestTwo);
                                                   	                                	 
                                        crspurchpge.PurchaseToTittle(Firstname_GuestOne, Middlename_GuestOne, Lastname_GuestOne, Email, Phone, Firstname_GuestTwo, Middlename_GuestTwo, Lastname_GuestTwo);
                                        
                                        Thread.sleep(1000);
               }
               catch(Exception e)
               {
                                        System.out.println("Invalid guest information on purchase page, Please enter valid details for the required fields...");
                                        System.out.println("\n");
                                        System.out.println("Invalid guest information on purchasepage Logs..");
                                        System.out.println("\n");
                                   //     ExtractJSLogs();
                              /*                   
                                        final Screenshot screenshot34 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                                        final BufferedImage image34 = screenshot34.getImage();
                                        ImageIO.write(image34, "PNG", new File("D:\\Ajit\\Script_SS\\CDORError\\5_InvalidGuestinfoonPurchasepage.png"));
                               */                  
                                        Assert.assertFalse(false, "FAIL");
                                  	    Reporter.log("Invalid guest information on purchase page, Please enter valid details for the required fields...");
                                  		AssertJUnit.assertTrue("Invalid guest information on purchase page, Please enter valid details for the required fields....", crsbkngpge.isDisplayed());
                                  		throw(e);
                 }
             
                                     //For Book My cruise button
                                     try
                                     {
                                        driver.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_FastBookLNK']")).sendKeys(Keys.ENTER);
                                        Thread.sleep(5000);
                                     }
                                     catch(Exception e)
                                     {
                                    	 e.getMessage();
                                     }
             
                                        long start5 = System.currentTimeMillis();
                                        Thread.sleep(1990);           
                                        System.out.println("\n");
                                        System.out.println("Paymentpage Logs..");
                                        System.out.println("\n");
                                  //      ExtractJSLogs();              
                                        Thread.sleep(870);
                                        
                                        long finish12 = System.currentTimeMillis();
                                        long totalTime12 = finish12 - start5; 
                                        Reporter.log("Total Time for purchase page to payment page load(Milisec) - "+totalTime12); 
                                        Thread.sleep(1000);
                               /*         
                                        final Screenshot screenshot44 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                                        final BufferedImage image44 = screenshot44.getImage();
                                        ImageIO.write(image44, "PNG", new File("D:\\Ajit\\Script_SS\\CDOR\\9_Paymentpage.png"));
                                        Thread.sleep(2000);
                                        
                                        String myArg9 = "D:\\Ajit\\Script_SS\\CDOR\\9_Paymentpage.png";
                                        String myArg10 = "D:\\Ajit\\Script_SS\\Daily Sanity\\Oct_2017\\11 Oct\\CDOR\\CDOR\\9_Paymentpage.png";
                                        String myCommand5 = "D:\\Ajit\\Script_SS\\ImageCompConsole.exe";
                                        String Output5 = "D:\\Ajit\\Script_SS\\Differences of Images\\CDOR\\9_Paymentpage.png";
                                        
                                        ProcessBuilder pb5 = new ProcessBuilder(myCommand5, myArg9, myArg10, Output5, Log);
                                        pb5.directory(new File("D:\\Ajit\\Script_SS"));
                                        Process p5 = pb5.start();
                                        
                                        System.out.println("" +p5);
                                   */      
                                        String priceonpaymnt = driver.findElement(By.cssSelector("#MainForm > div > div.step-block > div > div.step-6.booking-step.main.step-six-page > div.step-5.booking-step > div:nth-child(2) > div.bg-blue.bonuses-summary > div > div.col-xs-4.col-sm-2.text-center.pad-fix > p")).getText();
                                        Reporter.log("Price on payment page is:- "+ priceonpaymnt);
                                                        
                                          if(priceonpaymnt.equals(priceonpurchase))
                                          {
                                                       	
                                                 System.out.println("Actual String: " +priceonpurchase);
                                                 System.out.println("Purchase page and Payment page's Price matched");
                                                 Reporter.log("Purchase page and Payment page's Price matched..");
                                                       	 
                                                 System.out.println("Actual price is:- " +priceonpurchase);
                       							 Reporter.log("Actual price is:- " +priceonpurchase);
                                           }
                                           else
                                           {
                       							  System.out.println("Purchase page and Payment page's Price not match..");
                       							  Reporter.log("Purchase page and Payment page's Price not match..");
                       							  System.out.println("Actual price is:- " +priceonpurchase);
                       							  Reporter.log("Actual price is:- " +priceonpurchase);
                       					   }
                        							         
                       							 Thread.sleep(2500);
                       							 
                       				//For the insurance
                       				try
                       				{
                       					if(driver.findElement(By.cssSelector("#MainForm > div > div.step-block > div > div.step-6.booking-step.main.step-six-page > div.step-5.booking-step > div:nth-child(2) > div.insurance_ > div.travel-ins.light-gray.insurance > div.insurance-yes-text.mar-xs-top > label > span")).isDisplayed())
                       					{
                       						WebElement element = driver.findElement(By.cssSelector("#MainForm > div > div.step-block > div > div.step-6.booking-step.main.step-six-page > div.step-5.booking-step > div:nth-child(2) > div.insurance_ > div.travel-ins.light-gray.insurance > div.insurance-yes-text.mar-xs-top > label > span"));
                       		        	    JavascriptExecutor executor = (JavascriptExecutor) driver;
                       		                executor.executeScript("arguments[0].click();", element);
                       						
                       						Thread.sleep(6000);
                       						
                       						//Insurance price
                       						String Insuranceprice = driver.findElement(By.xpath("//*[@id='paymentSched']/div[2]/div[3]/div[4]")).getText();
                       						Thread.sleep(900);
                       						Reporter.log("Insurance Price:- " +Insuranceprice);
                       						Thread.sleep(1500);
                       						
                       						Reporter.log("Insurance applied successfully...");
                       						
                       						//AFTER Applied insurance
                       						String AfterappliedInsuranceprice = driver.findElement(By.cssSelector("#MainForm > div > div.step-block > div > div.step-6.booking-step.main.step-six-page > div.step-5.booking-step > div:nth-child(2) > div.bg-blue.bonuses-summary > div > div.col-xs-4.col-sm-2.text-center.pad-fix > p")).getText();
                       						Thread.sleep(900);
                       						Reporter.log("After applied Insurance Price:- " +AfterappliedInsuranceprice);
                       						Thread.sleep(1500);
                       						
                       						//Remove insurance
                       			//			WebElement elll = driver.findElement(By.id("InsurranceCHK_NON"));
                       			//			elll.sendKeys(Keys.ENTER);
                       						WebElement element1 = driver.findElement(By.id("InsurranceCHK_NON"));
                       		        	    JavascriptExecutor executor1 = (JavascriptExecutor) driver;
                       		                executor1.executeScript("arguments[0].click();", element1);
                       						Thread.sleep(3000);
                       						
                       						driver.switchTo().alert().accept();
                                            Thread.sleep(500);
                                            
                                            Reporter.log("Insurance Removed successfully..");
                                            
                                            //After removed insurance price
                                            String AfterremovedInsuranceprice = driver.findElement(By.cssSelector("#MainForm > div > div.step-block > div > div.step-6.booking-step.main.step-six-page > div.step-5.booking-step > div:nth-child(2) > div.bg-blue.bonuses-summary > div > div.col-xs-4.col-sm-2.text-center.pad-fix > p")).getText();
                       						Thread.sleep(900);
                       						Reporter.log("After Insurance removed Price:- " +AfterremovedInsuranceprice);
                       						Thread.sleep(1500);
                                            
                       					}
                       				}
                       				catch(Exception e)
                       				{
                       					e.getMessage();
                       				}
                    /*   				
                       			//For the compare logs
                       				String ConsleArgument = "D:\\Ajit\\Script_SS\\ConsoleError\\CDORBookingError.txt";
                                    String ConsoleCommand = "D:\\Ajit\\Script_SS\\ConsoleApplication2.exe";
                                    String ConsoleOutput = "D:\\Ajit\\Script_SS\\CDORError\\UncaughtCDOR.txt";
                                    
                                    ProcessBuilder pb05 = new ProcessBuilder(ConsoleCommand, ConsleArgument, ConsoleOutput);
                                    pb05.directory(new File("D:\\Ajit\\Script_SS"));
                                    Process p05 = pb05.start();
                                    
                                    System.out.println("" +p05);    
                     */                 
                                    Thread.sleep(1000);
    	
    }
    
    @DataProvider
    public String[][] Authentications() throws Exception
    {
    	 
	     String[][] testObjArray = CDORUtils.getTableArray("D:\\Ajit\\Automation\\Workspace\\Odysseus_Product\\src\\main\\java\\testData\\CDORData.xlsx","Sheet1");
	     return testObjArray;
	     
    }
    
    @AfterClass
    public void closeBrowser() throws InterruptedException
    {
    	
    //	 driver.close();
	 
	   /*  
	         if(driver!=null) 
	         {
		           System.out.println("Closing the browser");
		           driver.quit();
	         }   
       */
    }
	
}
