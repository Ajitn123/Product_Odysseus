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
import Utility.FaregeekUtils;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.screentaker.ViewportPastingStrategy;


public class FaregeekTest
{

	        FaregeekBookingpgeobjct airbkpge;
	        testpgeobjct faregkpurchse;
	        public static WebDriver driver;
	        Reporter report = new Reporter();
	        HSSFWorkbook workbook;
	  	   //define an Excel Work sheet
	  	    HSSFSheet sheet;
	  	   //define a test result data object
	  	    Map<String, Object[]> testresultdata;
	  	   	        
	        String Log = "D:\\Ajit\\Script_SS\\Differences of Images\\Logs\\Faregeek.txt";

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
		                 //   LoggingPreferences loggingprefs = new LoggingPreferences();
		                 //   loggingprefs.enable(LogType.BROWSER, Level.ALL);
		                //    capabilities.setCapability(CapabilityType.LOGGING_PREFS, loggingprefs);
		                    driver = new ChromeDriver();
		                   
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
             driver.get("http://faregeek.com/");
             Thread.sleep(8000);
      /*       
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
    
             //Save console
             String testResultFile="D:\\Ajit\\Script_SS\\ConsoleError\\FaregeekError.txt";
             File file = new File(testResultFile);  
             FileOutputStream fis = new FileOutputStream(file);  
             PrintStream out = new PrintStream(fis);  
             System.setOut(out); 
                  
             Thread.sleep(1000);
            
             final Screenshot screenshot1 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
             final BufferedImage image1 = screenshot1.getImage();
             ImageIO.write(image1, "PNG", new File("D:\\Ajit\\Script_SS\\Faregeek\\1_Searchpage.png"));
             Thread.sleep(3000);
             
             String ActualImage = "D:\\Ajit\\Script_SS\\Faregeek\\1_Searchpage.png";
             String Referance = "D:\\Ajit\\Script_SS\\Daily Sanity\\Oct_2017\\11 Oct\\Faregeek\\Faregeek\\1_Searchpage.png";
             String myCommand = "D:\\Ajit\\Script_SS\\ImageCompConsole.exe";
             String Output = "D:\\Ajit\\Script_SS\\Differences of Images\\Faregeek\\1_DifferenceSearchpage.png";
              
             ProcessBuilder pb = new ProcessBuilder(myCommand, ActualImage, Referance, Output, Log);
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
            airbkpge = PageFactory.initElements(driver, FaregeekBookingpgeobjct.class);
            faregkpurchse = PageFactory.initElements(driver, testpgeobjct.class);
	    
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
	    @Test(dataProvider="Authentication")
	    public void Fregeek_Data(String FromLocation, String ToLocation, String Firstname_Of_Adult1, String Middlename_of_Adult1, String Lastname_Of_Adult1, String Phone_Adult1, String Email, String Confirm_Email, String Firstname_Of_Adult2, String Middlename_of_Adult2, String Lastname_Of_Adult2, String Firstname_Of_Adult3, String Middlename_of_Adult3, String Lastname_Of_Adult3, String Phone_Adult3) throws Exception
	    {
	    	
	    	   try
	    	   {
	    		     //For web site and booking details
	                 Reporter.log("Website Name :- Faregeek");
	                 Thread.sleep(200);
	     		 
	                 System.out.println("FromLocation: " + FromLocation);
	                 System.out.println("ToLocation: " + ToLocation);
	                 
	                 airbkpge.FaregeekbookingToTitle(FromLocation, ToLocation);
	                 long start = System.currentTimeMillis();
	         	     Thread.sleep(4000);
	         	     long finish = System.currentTimeMillis();
	                 long totalTime = finish - start; 
	                 Reporter.log("Total Time for search page to result page load(Milisec) - "+totalTime); 
	                 Thread.sleep(1000);
	         	     System.out.println("\n");
	    	         System.out.println("Resultpage Logs..");
	    	         System.out.println("\n");
	    	    //     ExtractJSLogs();
	            
	                 Thread.sleep(10000);
	             
	           }
	           catch(Exception e)
	           {
	        	     System.out.println("\n");
	   	             System.out.println("Time out or Invalid search criteria on resultpage Logs..");
	   	             System.out.println("\n");
	   	        //     ExtractJSLogs();
	    	 
	 	             final Screenshot screenshot33 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	 	             final BufferedImage image33 = screenshot33.getImage();
	 	             ImageIO.write(image33, "PNG", new File("D:\\Ajit\\Script_SS\\FaregeekError\\1_TimeoutORinvalidsearchdetails.png"));
	 	          
	    	         Assert.assertFalse(false, "FAIL");
	    	         Reporter.log("Time out or Invalid search criteria on resultpage..");
	    	         AssertJUnit.assertTrue("Time out or Invalid search criteria on resultpage...", airbkpge.isDisplayed());
	    	         throw(e);
	           }
	    	   
	    	 
	    	 // For select dynamic flights from result page
	         
	    	        driver.navigate().refresh();
	          
	                driver.get("https://air.faregeek.com/web/air/results.aspx?showtrace=true");
	      
	    	        driver.manage().window().maximize();
	    	        
	    	        System.out.println("\n");
	    	        System.out.println("Resultpage Logs..");
	    	        System.out.println("\n");
	    	   //     ExtractJSLogs();
	    	        
	                Thread.sleep(1000);
	    	/* 
	                final Screenshot screenshot4 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	                final BufferedImage image4 = screenshot4.getImage();
	                ImageIO.write(image4, "PNG", new File("D:\\Ajit\\Script_SS\\Faregeek\\2_Resultpage.png"));
	                Thread.sleep(2000);
	                
	                String myArg1 = "D:\\Ajit\\Script_SS\\Faregeek\\2_Resultpage.png";
	                String myArg2 = "D:\\Ajit\\Script_SS\\Daily Sanity\\Oct_2017\\11 Oct\\Faregeek\\Faregeek\\2_Resultpage.png";
	                String myCommand = "D:\\Ajit\\Script_SS\\ImageCompConsole.exe";
	                String Output = "D:\\Ajit\\Script_SS\\Differences of Images\\Faregeek\\2_DifferenceResultpage.png";
	                 
	                ProcessBuilder pb = new ProcessBuilder(myCommand, myArg1, myArg2, Output, Log);
	                pb.directory(new File("D:\\Ajit\\Script_SS"));
	                Process p = pb.start();
	                
	                System.out.println("" +p);
	        */
	    	        Thread.sleep(4000);
	    	        
	    	        //For View Details 
	    	        if(driver.findElement(By.cssSelector("[id*='flight-summary_'] > div.col-md-12.links > a.details")).isDisplayed())
	    	        {
	    	        	  driver.findElement(By.cssSelector("[id*='flight-summary_'] > div.col-md-12.links > a.details")).sendKeys(Keys.ENTER);
	    	        	  Thread.sleep(500);
	  	    	   /*     
	  	                  File scr02 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
       	                  org.codehaus.plexus.util.FileUtils.copyFile(scr02, new File("D:\\Ajit\\Script_SS\\Faregeek\\3_ViewDetails.png")); 
	  	                  Thread.sleep(2000);
	  	                  
	  	                  String myArg3 = "D:\\Ajit\\Script_SS\\Faregeek\\3_ViewDetails.png";
		                  String myArg4 = "D:\\Ajit\\Script_SS\\Daily Sanity\\Oct_2017\\11 Oct\\Faregeek\\Faregeek\\3_ViewDetails.png";
		                  String myCommand1 = "D:\\Ajit\\Script_SS\\ImageCompConsole.exe";
		                  String Output1 = "D:\\Ajit\\Script_SS\\Differences of Images\\Faregeek\\3_DifferenceViewDetails.png";
		                 
		                  ProcessBuilder pb1 = new ProcessBuilder(myCommand1, myArg3, myArg4, Output1, Log);
		                  pb1.directory(new File("D:\\Ajit\\Script_SS"));
		                  Process p1 = pb1.start();
		                
		                  System.out.println("" +p1);
	  	           */     
	  	                  driver.navigate().refresh();
	  	                  Thread.sleep(3000);
	    	        }
	    	        
	    	        // For verify price on result page
	    	        String perperson = driver.findElement(By.cssSelector("[id*='flight-summary_'] > div.col-md-2.no-padding.pull-right.fix-price > div > h4:nth-child(1)")).getText();
	    	        Reporter.log("Price per person on result page: " +perperson);
	    	        Thread.sleep(1000);
	    /*	        
	    	        try
	                {
		                    testresultdata.put("3", new Object[] {"Results", perperson});
	                    
	                    Thread.sleep(1000);
	       	      
	                 }   
	                 catch(Exception e)
	                 {
	        	        //add fail entry to the excel sheet
	        	        testresultdata.put("3", new Object[] {"Results", perperson});
	        	        System.out.println("Result page per persion price not available..");
	        	        Reporter.log("Result page per persion price not available..");
	        	        System.out.println(e.getMessage());
	        	   
	                 }
	    */	        
	    	        String totalpriceonresult = driver.findElement(By.cssSelector("#tootltipdetails")).getText();
	    	        Reporter.log("Total Price on result page: " +totalpriceonresult);
	    	        Thread.sleep(2000);
	    /*	        
	    	        try
	                {
		                    testresultdata.put("4", new Object[] {"", totalpriceonresult});
	                    
	                    Thread.sleep(1000);
	       	      
	                 }   
	                 catch(Exception e)
	                 {
	        	        //add fail entry to the excel sheet
	        	        testresultdata.put("4", new Object[] {"", totalpriceonresult});
	        	        System.out.println("Result page Total price not available..");
	        	        Reporter.log("Result page Total price not available..");
	        	        System.out.println(e.getMessage());
	        	   
	                 }
	    	*/  
	             // For select flight on result page
	             if(driver.findElement(By.cssSelector("[id*='flight-summary_'] > div.col-md-2.no-padding.pull-right.fix-price > div > a")).isDisplayed())
	             {
	            	   driver.findElement(By.cssSelector("[id*='flight-summary_'] > div.col-md-2.no-padding.pull-right.fix-price > div > a")).sendKeys(Keys.ENTER);
	            	   Thread.sleep(7000);
	             }
	             else if(driver.findElement(By.cssSelector("#mainBody > div.error-box.priceErr")).isDisplayed()) // For error handling
          	     {
          		       driver.navigate().refresh();
          		       driver.findElement(By.cssSelector("[id*='flight-summary_'] > div.col-md-2.no-padding.pull-right.fix-price > div > a")).sendKeys(Keys.ENTER);
	            	   Thread.sleep(6000);
          	     }
	             else if(driver.findElement(By.cssSelector("#mainBody > div.error-box.priceErr")).isDisplayed())
	             {
	            	  String errormess = driver.findElement(By.cssSelector("#mainBody > div.error-box.priceErr")).getText();
	            	  Reporter.log("Error on result page: " +errormess);
	            	  Thread.sleep(500);
	            	  AssertJUnit.assertTrue(" " +errormess, airbkpge.isDisplayed());
		    		  return;
	             }

	             else 
	             {
	             	System.out.println("Flight not available..");
	             	System.out.println("\n");
	             	System.out.println("Flight not available on resultpage Logs..");
	             	System.out.println("\n");
	            //	ExtractJSLogs();
	             	
	             	final Screenshot screenshot2 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	                final BufferedImage image2 = screenshot2.getImage();
	                ImageIO.write(image2, "PNG", new File("D:\\Ajit\\Script_SS\\FaregeekError\\2_Flightnotavailable.png"));
	                
	                Assert.assertFalse(false, "FAIL");
	    	        Reporter.log("Flights not available..");
	    			AssertJUnit.assertTrue("Flight not available...", airbkpge.isDisplayed());
	    			return;
	    		 }
	                long start = System.currentTimeMillis();
	                Thread.sleep(2500);
	                long finish = System.currentTimeMillis();
	                long totalTime = finish - start; 
	                Reporter.log("Total Time for result page to checkout page load(Milisec) - "+totalTime); 
	                Thread.sleep(1000);
	                System.out.println("\n");
	                System.out.println("Checkoutpage Logs..");
	                System.out.println("\n");
	           //     ExtractJSLogs();              
	                Thread.sleep(1000);
	          /*      
	                final Screenshot screenshot3 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	                final BufferedImage image3 = screenshot3.getImage();
	                ImageIO.write(image3, "PNG", new File("D:\\Ajit\\Script_SS\\Faregeek\\4_Checkoutpage.png"));
	                Thread.sleep(2000);
	                
	                  String myArg3 = "D:\\Ajit\\Script_SS\\Faregeek\\4_Checkoutpage.png";
	                  String myArg4 = "D:\\Ajit\\Script_SS\\Daily Sanity\\Oct_2017\\11 Oct\\Faregeek\\Faregeek\\4_Checkoutpage.png";
	                  String myCommand1 = "D:\\Ajit\\Script_SS\\ImageCompConsole.exe";
	                  String Output1 = "D:\\Ajit\\Script_SS\\Differences of Images\\Faregeek\\4_DifferenceCheckoutpage.png";
	                 
	                  ProcessBuilder pb1 = new ProcessBuilder(myCommand1, myArg3, myArg4, Output1, Log);
	                  pb1.directory(new File("D:\\Ajit\\Script_SS"));
	                  Process p1 = pb1.start();
	                
	                  System.out.println("" +p1);
	            */   
	                 Thread.sleep(3000);
	                
	              //For Trip details on checkout page
		  	      String frmloc = driver.findElement(By.cssSelector("#Flights > div:nth-child(1) > div > div.col-md-10.col-sm-10")).getText();
		  	      Reporter.log("Departure Trip: " +frmloc);
		  	      Thread.sleep(500);
		  	      String toloc = driver.findElement(By.cssSelector("#Flights > div:nth-child(2) > div > div.col-md-10.col-sm-10")).getText();
		  	      Reporter.log("Return Trip: " +toloc);
		  	      Thread.sleep(500);
		  	      String noofadult = driver.findElement(By.cssSelector("#FareDetails > div.panel-body.fare-details > div:nth-child(1) > div > p")).getText();
		  	      Reporter.log(" " +noofadult);
		  	      Thread.sleep(500);
		  	      String noofchilds = driver.findElement(By.cssSelector("#FareDetails > div.panel-body.fare-details > div:nth-child(2) > div > p")).getText();
		  	      Reporter.log(" " +noofchilds);
		  	      Thread.sleep(500);
		  	      String taxes = driver.findElement(By.cssSelector("#FareDetails > div.total-price.no-padding > div:nth-child(1) > div")).getText();
		  	      Reporter.log(" " +taxes);
		  	      Thread.sleep(500);
	                
	              //Price verify on checkout page
	  	      	  String priceoncheckout = driver.findElement(By.xpath("//*[@id='PricesGTotal']")).getText();
	  	      	  Reporter.log("Price on checkout page: " +priceoncheckout);
	  	      	  Thread.sleep(1000);
	  	 /*    	  
	  	      	try
                {
	                    testresultdata.put("5", new Object[] {"Checkout", priceoncheckout});
                    
                        Thread.sleep(2000);
                 }   
                 catch(Exception e)
                 {
        	        //add fail entry to the excel sheet
        	        testresultdata.put("5", new Object[] {"Checkout", priceoncheckout});
        	        System.out.println("Checkout page Total price not available..");
        	        Reporter.log("Checkout page Total price not available..");
        	        System.out.println(e.getMessage());
                 }
		*/		 
				 Reporter.log("Test dataaaaa..");
	  	      	 
	  	      	  //For check API, Office id And Environment on checkout page
	  	      	  String expr = driver.findElement(By.id("TracerBlock")).getText();
	  	          String api = expr.split("OdysseyGateway")[7].split(":")[1].trim();
	  	          //List<String> items = Arrays.asList(expr.split("$($('#TracerBlock')[0].innerHTML.split('OdysseyGateway')[2])[0].nodeValue.toString().split(':')[1]"));
	  	          Reporter.log("API :- " +api);
	  	          Thread.sleep(900);
	  	   //       String envrnmnt = expr.split("OdysseyGateway")[7].split(":")[2].trim();
	  	   //       Reporter.log("Environment :- " +envrnmnt);
	  	    //      Thread.sleep(1000);
	  	    //      String officeid = expr.split("OdysseyGateway")[7].split(":")[3].trim();
	  	    //      Reporter.log("Office Id :- " +officeid);
	  	    //      Thread.sleep(4000);
	       
	  	   //For Passenger details         
	       try
	       {
	    	   System.out.println("Firstname_Of_Adult1: " + Firstname_Of_Adult1);
	           System.out.println("Middlename_of_Adult1:" + Middlename_of_Adult1);
	           System.out.println("Lastname_Of_Adult1: " + Lastname_Of_Adult1);
	           System.out.println("Lastname_Of_Adult1: " + Phone_Adult1);
	           System.out.println("Email: " + Email);
	           System.out.println("Confirm_Email: " + Confirm_Email);
	           System.out.println("Firstname_Of_Adult2: " + Firstname_Of_Adult2);
	           System.out.println("Middlename_of_Adult2:" + Middlename_of_Adult2);
	           System.out.println("Lastname_Of_Adult2: " + Lastname_Of_Adult2);
	        //   System.out.println("Lastname_Of_Adult2: " + Phone_Adult2);
	           System.out.println("Firstname_Of_Adult3: " + Firstname_Of_Adult3);
	           System.out.println("Middlename_of_Adult3:" + Middlename_of_Adult3);
	           System.out.println("Lastname_Of_Adult3: " + Lastname_Of_Adult3);
	           System.out.println("Phone_No: " + Phone_Adult3);
	                 
	           faregkpurchse.FaregeekToTitle(Firstname_Of_Adult1, Middlename_of_Adult1, Lastname_Of_Adult1, Phone_Adult1, Email, Confirm_Email, Firstname_Of_Adult2, Middlename_of_Adult2, Lastname_Of_Adult2, Firstname_Of_Adult3, Middlename_of_Adult3, Lastname_Of_Adult3, Phone_Adult3);
	       }
	       catch(Exception e)
	       {
	      	  System.out.println("\n");
	      	  System.out.println("Timeout on checkoutpage Logs..");
	      	  System.out.println("\n");
	      //	  ExtractJSLogs();
	     	 
	          final Screenshot screenshot44 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	  		  final BufferedImage image44 = screenshot44.getImage();
	  		  ImageIO.write(image44, "PNG", new File("D:\\Ajit\\Script_SS\\FaregeekError\\3_Timeouterror.png"));
	          
	          Assert.assertFalse(false, "FAIL");
	          Reporter.log("Timeout error...");
	     	  AssertJUnit.assertTrue("Timeout error...", faregkpurchse.isDisplayed());
	     	  throw(e);
	       }
	       
	           Thread.sleep(4000);
	           
	           
	        // For Apply Best Price Guarantee   
	        if(driver.findElement(By.cssSelector("#MainForm > div.col-md-9.col-xs-12.col-sm-9.pull-right.pax-main-cont > div.row.booking-section.satisfaction.panel-box.pax-info-mo > div > div > div > label [id*='ex_gr_']")).isDisplayed())
	        {                                     
	        	// driver.findElement(By.cssSelector("#MainForm > div.col-md-9.col-xs-12.col-sm-9.pull-right.pax-main-cont > div.row.booking-section.satisfaction.panel-box.pax-info-mo > div > div > div > label [id*='ex_gr_']")).click();
	        	 WebElement element1 = driver.findElement(By.cssSelector("#MainForm > div.col-md-9.col-xs-12.col-sm-9.pull-right.pax-main-cont > div.row.booking-section.satisfaction.panel-box.pax-info-mo > div > div > div > label [id*='ex_gr_']"));
	        	 JavascriptExecutor executor1 = (JavascriptExecutor) driver;
	             executor1.executeScript("arguments[0].click();", element1);
	        	Thread.sleep(2000);
	        	Reporter.log("Best Price Gaurantee Applied successfully..");
	        	Thread.sleep(500);
			/*	
	        	final Screenshot screenshot37 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                final BufferedImage image37 = screenshot37.getImage();
                ImageIO.write(image37, "PNG", new File("D:\\Ajit\\Script_SS\\Faregeek\\05_AppliedBestPriceGaurantee.png"));
                Thread.sleep(1000);
                
                String myArg5 = "D:\\Ajit\\Script_SS\\Faregeek\\05_AppliedBestPriceGaurantee.png";
                String myArg6 = "D:\\Ajit\\Script_SS\\Daily Sanity\\Oct_2017\\11 Oct\\Faregeek\\Faregeek\\05_AppliedBestPriceGaurantee.png";
                String myCommand2 = "D:\\Ajit\\Script_SS\\ImageCompConsole.exe";
                String Output2 = "D:\\Ajit\\Script_SS\\Differences of Images\\Faregeek\\05_DifferenceAppliedBestPriceGaurantee.png";
               
                ProcessBuilder pb2 = new ProcessBuilder(myCommand2, myArg5, myArg6, Output2, Log);
                pb2.directory(new File("D:\\Ajit\\Script_SS"));
                Process p2 = pb2.start();
              
                System.out.println("" +p2);
           */     
                //For Additional payment display in testng report
                String additionalitems = driver.findElement(By.xpath("//*[@id='60']")).getText();
	        	Reporter.log(" " +additionalitems);
	        	Thread.sleep(1000);
	      /*  	
	        	try
                {
	                    testresultdata.put("6", new Object[] {"Best Price Gaurantee", additionalitems});
                    
                        Thread.sleep(1000);
                 }   
                 catch(Exception e)
                 {
        	        //add fail entry to the excel sheet
        	        testresultdata.put("6", new Object[] {"Best Price Gaurantee", additionalitems});
        	        System.out.println("Best Price Gaurantee's price not available..");
        	        Reporter.log("Best Price Gaurantee's price not available..");
        	        System.out.println(e.getMessage());
                 }
	        */	
	        	// Verify price After Applied Best Price Guarantee
	        	String afteradditional = driver.findElement(By.xpath("//*[@id='PricesGTotal']")).getText();
	        	Reporter.log("After applied Best Price Guarantee: " +afteradditional);
	        	Thread.sleep(1000);
	       /* 	
	        	try
                {
	                    testresultdata.put("7", new Object[] {"Best Price Gaurantee Applied", afteradditional});
                    
                        Thread.sleep(1000);
                 }   
                 catch(Exception e)
                 {
        	        //add fail entry to the excel sheet
        	        testresultdata.put("7", new Object[] {"Best Price Gaurantee Applied", afteradditional});
        	        System.out.println("Best Price Gaurantee not applied..");
        	        Reporter.log("Best Price Gaurantee not applied..");
        	        System.out.println(e.getMessage());
                 }
	        */	
	        	// For remove Best Price Guarantee
	    //    	driver.findElement(By.cssSelector("#MainForm > div.col-md-9.col-xs-12.col-sm-9.pull-right.pax-main-cont > div.row.booking-section.satisfaction.panel-box.pax-info-mo > div > div > div > label [id*='ex_gr_']")).click();
	        	WebElement element11 = driver.findElement(By.cssSelector("#MainForm > div.col-md-9.col-xs-12.col-sm-9.pull-right.pax-main-cont > div.row.booking-section.satisfaction.panel-box.pax-info-mo > div > div > div > label [id*='ex_gr_']"));
	        	JavascriptExecutor executor11 = (JavascriptExecutor) driver;
	            executor11.executeScript("arguments[0].click();", element11);
	        	Thread.sleep(1000);
	       /* 	
	        	final Screenshot screenshot39 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                final BufferedImage image39 = screenshot39.getImage();
                ImageIO.write(image39, "PNG", new File("D:\\Ajit\\Script_SS\\Faregeek\\5_RemovedBestPriceGaurantee.png"));
                Thread.sleep(1500);
                
                String myArg7 = "D:\\Ajit\\Script_SS\\Faregeek\\5_RemovedBestPriceGaurantee.png";
                String myArg8 = "D:\\Ajit\\Script_SS\\Daily Sanity\\Oct_2017\\11 Oct\\Faregeek\\Faregeek\\5_RemovedBestPriceGaurantee.png";
                String myCommand3 = "D:\\Ajit\\Script_SS\\ImageCompConsole.exe";
                String Output3 = "D:\\Ajit\\Script_SS\\Differences of Images\\Faregeek\\5_DifferenceRemovedBestPriceGaurantee.png";
               
                ProcessBuilder pb3 = new ProcessBuilder(myCommand3, myArg7, myArg8, Output3, Log);
                pb3.directory(new File("D:\\Ajit\\Script_SS"));
                Process p3 = pb3.start();
              
                System.out.println("" +p3);
	       */ 	
	        	Reporter.log("Best Price Gaurantee Removed successfully..");
	        	Thread.sleep(500);
	        	
	        	// Verify price After Removed Best Price Guarantee
	        	String Removedadditional = driver.findElement(By.xpath("//*[@id='PricesGTotal']")).getText();
	        	Reporter.log("After Removed Best Price Guarantee: " +Removedadditional);
	        	Thread.sleep(1000);
	      /*  	
	        	try
                {
	                    testresultdata.put("8", new Object[] {"Best Price Gaurantee Removed", Removedadditional});
                    
                        Thread.sleep(1000);
                 }   
                 catch(Exception e)
                 {
        	        //add fail entry to the excel sheet
        	        testresultdata.put("8", new Object[] {"Best Price Gaurantee Removed", Removedadditional});
        	        System.out.println("Best Price Gaurantee not removed..");
        	        Reporter.log("Best Price Gaurantee not removed..");
        	        System.out.println(e.getMessage());
                 }
	       */ 	
	        }
	    
	           
	      try
	      {
	           //Click on Continue to Payment Button
	           driver.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_ContinueLNK']")).sendKeys(Keys.ENTER);
	           long start1 = System.currentTimeMillis();
	           Thread.sleep(4000);
	           long finish1 = System.currentTimeMillis();
	           long totalTime1 = finish1 - start1; 
	           Reporter.log("Total Time for checkout page to payment page load(Milisec) - "+totalTime1); 
	           Thread.sleep(1000);
	      }
	      catch(Exception e)
	      {
	    	  System.out.println("\n");
	      	  System.out.println("Invalid guest information on checkoutpage Logs..");
	      	  System.out.println("\n");
	     // 	  ExtractJSLogs();
	      	 
	          final Screenshot screenshot44 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	  		  final BufferedImage image44 = screenshot44.getImage();
	  		  ImageIO.write(image44, "PNG", new File("D:\\Ajit\\Script_SS\\FaregeekError\\3_InvalidGuestInfo.png"));
	           
	          Assert.assertFalse(false, "FAIL");
	          Reporter.log("Invalid guest information on checkoutpage...");
	     	  AssertJUnit.assertTrue("Invalid guest information on checkoutpage...", faregkpurchse.isDisplayed());
	     	  throw(e);
	       }
	      
	          System.out.println("\n");
	          System.out.println("Paymentpage Logs..");
	          System.out.println("\n");
	       //   ExtractJSLogs();
	        
              Thread.sleep(1000);
	 /*
              final Screenshot screenshot48 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
              final BufferedImage image48 = screenshot48.getImage();
              ImageIO.write(image48, "PNG", new File("D:\\Ajit\\Script_SS\\Faregeek\\6_Paymentpage.png"));
              Thread.sleep(1000);
              
              String myArg7 = "D:\\Ajit\\Script_SS\\Faregeek\\6_Paymentpage.png";
              String myArg8 = "D:\\Ajit\\Script_SS\\Daily Sanity\\Oct_2017\\11 Oct\\Faregeek\\Faregeek\\6_Paymentpage.png";
              String myCommand3 = "D:\\Ajit\\Script_SS\\ImageCompConsole.exe";
              String Output3 = "D:\\Ajit\\Script_SS\\Differences of Images\\Faregeek\\6_DifferencePaymentpage.png";
             
              ProcessBuilder pb3 = new ProcessBuilder(myCommand3, myArg7, myArg8, Output3, Log);
              pb3.directory(new File("D:\\Ajit\\Script_SS"));
              Process p3 = pb3.start();
            
              System.out.println("" +p3);
       */       
              //For Insurance
              try
              {
              	 if( driver.findElement(By.cssSelector("#travel-insurance > div > div.panel-body-outer > div > div > table > tbody > tr:nth-child(3) > td > label:nth-child(1) [id*='InsurranceCHK_']")).isDisplayed())
              	 {	
                   //     driver.findElement(By.cssSelector("#travel-insurance > div > div.panel-body-outer > div > div > table > tbody > tr:nth-child(3) > td > label:nth-child(1) [id*='InsurranceCHK_']")).click();
                        WebElement element = driver.findElement(By.cssSelector("#travel-insurance > div > div.panel-body-outer > div > div > table > tbody > tr:nth-child(3) > td > label:nth-child(1) [id*='InsurranceCHK_']"));
   		        	    JavascriptExecutor executor = (JavascriptExecutor) driver;
   		                executor.executeScript("arguments[0].click();", element);
                        Thread.sleep(1500);
                        Reporter.log("Insurance applied successfully..");
                        
                        //For check insurance price
                        String insurprice = driver.findElement(By.cssSelector("#PricesGTotal")).getText();
                        Reporter.log("Prices of After applied insurance on the Payment page:- " +insurprice);
                        Thread.sleep(1000); 
              /*         
                        try
                        {
        	                    testresultdata.put("10", new Object[] {"Insurance Applied", insurprice});
                            
                                Thread.sleep(1000);
                         }   
                         catch(Exception e)
                         {
                	        //add fail entry to the excel sheet
                	        testresultdata.put("10", new Object[] {"Insurance Applied", insurprice});
                	        System.out.println("Insurance not Applied..");
                	        Reporter.log("Insurance not Applied..");
                	        System.out.println(e.getMessage());
                         }
                        
                        final Screenshot screenshot64 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                        final BufferedImage image64 = screenshot64.getImage();
                        ImageIO.write(image64, "PNG", new File("D:\\Ajit\\Script_SS\\Faregeek\\7_AppliedInsurance.png"));
                        Thread.sleep(2000);
                        
                        String myArg9 = "D:\\Ajit\\Script_SS\\Faregeek\\7_AppliedInsurance.png";
                        String myArg10 = "D:\\Ajit\\Script_SS\\Daily Sanity\\Oct_2017\\11 Oct\\Faregeek\\Faregeek\\7_AppliedInsurance.png";
                        String myCommand4 = "D:\\Ajit\\Script_SS\\ImageCompConsole.exe";
                        String Output4 = "D:\\Ajit\\Script_SS\\Differences of Images\\Faregeek\\7_DifferenceAppliedInsurance.png";
                       
                        ProcessBuilder pb4 = new ProcessBuilder(myCommand4, myArg9, myArg10, Output4, Log);
                        pb4.directory(new File("D:\\Ajit\\Script_SS"));
                        Process p4 = pb4.start();
                      
                        System.out.println("" +p4);
             */           
                        // Applied insurance price
                        String appliedinsurprice = driver.findElement(By.cssSelector("#FareDetails > div.total-price.no-padding > div:nth-child(3) > div > p")).getText();
                        Reporter.log(" " +appliedinsurprice);
                        Thread.sleep(1000);
             /*           
                        try
                        {
        	                    testresultdata.put("9", new Object[] {"Insurance Price", appliedinsurprice});
                            
                                Thread.sleep(1000);
                         }   
                         catch(Exception e)
                         {
                	        //add fail entry to the excel sheet
                	        testresultdata.put("9", new Object[] {"Insurance Price", appliedinsurprice});
                	        System.out.println("Insurance Price not available..");
                	        Reporter.log("Insurance Price not available..");
                	        System.out.println(e.getMessage());
                         }
                */        
                        //For Remove insurance
                  //      WebElement insurnc = driver.findElement(By.id("InsurranceCHK_NON"));
                  //      insurnc.click();
                        WebElement element1 = driver.findElement(By.id("InsurranceCHK_NON"));
   		        	    JavascriptExecutor executor1 = (JavascriptExecutor) driver;
   		                executor1.executeScript("arguments[0].click();", element1);
                        
                        Thread.sleep(1500);
                        driver.switchTo().alert().accept();
                        Thread.sleep(500);
                        
                        Reporter.log("Insurance Removed successfully..");
                        
                        //For check insurance price
                        String insprice = driver.findElement(By.cssSelector("#PricesGTotal")).getText();
                        Reporter.log("Prices of After removed insurance on the Payment page:- " +insprice);
                        Thread.sleep(1000);  
              /*          
                        try
                        {
        	                    testresultdata.put("11", new Object[] {"Insurance Removed", insprice});
                            
                                Thread.sleep(1000);
                         }   
                         catch(Exception e)
                         {
                	        //add fail entry to the excel sheet
                	        testresultdata.put("11", new Object[] {"Insurance Removed", insprice});
                	        System.out.println("Insurance not Removed..");
                	        Reporter.log("Insurance not Removed..");
                	        e.getMessage();
                         }
                       
                        final Screenshot screenshot66 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                        final BufferedImage image66 = screenshot66.getImage();
                        ImageIO.write(image66, "PNG", new File("D:\\Ajit\\Script_SS\\Faregeek\\8_RemovedInsurance.png"));
                        Thread.sleep(2000);
                        
                        String myArg11 = "D:\\Ajit\\Script_SS\\Faregeek\\8_RemovedInsurance.png";
                        String myArg12 = "D:\\Ajit\\Script_SS\\Daily Sanity\\Oct_2017\\11 Oct\\Faregeek\\Faregeek\\8_RemovedInsurance.png";
                        String myCommand5 = "D:\\Ajit\\Script_SS\\ImageCompConsole.exe";
                        String Output5 = "D:\\Ajit\\Script_SS\\Differences of Images\\Faregeek\\8_DifferenceRemovedInsurance.png";
                       
                        ProcessBuilder pb5 = new ProcessBuilder(myCommand5, myArg11, myArg12, Output5, Log);
                        pb5.directory(new File("D:\\Ajit\\Script_SS"));
                        Process p5 = pb5.start();
                      
                        System.out.println("" +p5);
                   */    
              	 }     
              }
              catch(Exception e)
              {
              	   System.out.println("Insurance not applied/removed...");
       	           System.out.println("\n");
       	           System.out.println("Insurance not applied/removed on confirmation page...");
       	           System.out.println("\n");
       	      //     ExtractJSLogs();
          
                   final Screenshot screenshot72 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                   final BufferedImage image72 = screenshot72.getImage();
                   ImageIO.write(image72, "PNG", new File("D:\\Ajit\\Script_SS\\FaregeekError\\9_InsurancenotAppliedOrRemoved.png"));
          
                   Assert.assertFalse(false, "FAIL");
                   Reporter.log("Insurance not applied/removed...");
		           AssertJUnit.assertTrue("Insurance not applied/removed....", faregkpurchse.isDisplayed());
		           throw(e);
              }
              
              
              //For verify prices on payment page
              String priceonpaymnt = driver.findElement(By.xpath("//*[@id='PricesGTotal']")).getText();
              Reporter.log("Price on payment page: " +priceonpaymnt);
              Thread.sleep(500);
        /*      
               try
               {
	                    testresultdata.put("12", new Object[] {"Payment", priceonpaymnt});
                  
                      Thread.sleep(1000);
               }   
               catch(Exception e)
               {
      	         //add fail entry to the excel sheet
      	         testresultdata.put("12", new Object[] {"Payment", priceonpaymnt});
      	         System.out.println("Price not Available on Payment page..");
      	         Reporter.log("Price not Available on Payment page..");
      	         e.getMessage();
              }
        */      
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
               /*          
                       //For the compare logs
            		     String ConsleArgument = "D:\\Ajit\\Script_SS\\ConsoleError\\FaregeekError.txt";
                         String ConsoleCommand = "D:\\Ajit\\Script_SS\\ConsoleApplication2.exe";
                         String ConsoleOutput = "D:\\Ajit\\Script_SS\\FaregeekError\\UncaughtFaregeek.txt";
                         
                         ProcessBuilder pb05 = new ProcessBuilder(ConsoleCommand, ConsleArgument, ConsoleOutput);
                         pb05.directory(new File("D:\\Ajit\\Script_SS"));
                         Process p05 = pb05.start();
                         
                         System.out.println("" +p05);    
                           
                         Thread.sleep(1000);
	    	*/
	    }
	    
	    @DataProvider
	    public String[][] Authentication() throws Exception
	    {
	    	 
	   	     String[][] testObjArray = FaregeekUtils.getTableArray("D:\\Ajit\\Automation\\Workspace\\Odysseus_Product\\src\\main\\java\\testData\\FaregeekData.xlsx","Sheet1");
	   	     return testObjArray;
	   	     
	    }
	    
	    
	    @AfterClass
	    public void closeBrowser() throws InterruptedException
	    {
	    /*	
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
	    */	
	    	//  driver.close();
	   	 
	   	   /*
	   	        if(driver!=null) 
	   	        {
	   		         System.out.println("Closing the browser");
	   		         driver.quit();
	   	        }   
	      */
	    	
	    }
	   
}
