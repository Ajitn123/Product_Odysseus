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
import Utility.CDNDolerisUtils;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.screentaker.ViewportPastingStrategy;


public class CDNDolerisTest 
{

	  
	  CDNDolerisCheckoutpgeobjct faredptpurchse;
	  CDNFaredepotPaymentpgobjct fredpotpymnt;
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
         //     driver = new FirefoxDriver(capabilities);
	   
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
          driver.get("https://cdn.odysol.com/web/air/default.aspx?siid=125608&AirSegCount=2&aCount=2&cCount=1&AirSeg_1=NYC|BOS|08/08/2017||||||||&AirSeg_2=BOS|NYC|09/27/2017||||||||");
          Thread.sleep(7000);
  
        //Save console
        String testResultFile="D:\\Ajit\\Script_SS\\ConsoleError\\CDNDolarisError.txt";
        File file = new File(testResultFile);  
        FileOutputStream fis = new FileOutputStream(file);  
        PrintStream out = new PrintStream(fis);  
        System.setOut(out); 
             
        Thread.sleep(2000);

       //driver.navigate().to("https://localhost/odyssey/website/air/results.aspx?");
       Thread.sleep(4000);
       fredpotpymnt = PageFactory.initElements(driver, CDNFaredepotPaymentpgobjct.class);
       faredptpurchse = PageFactory.initElements(driver, CDNDolerisCheckoutpgeobjct.class);
   
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
  public void Faredepot_data(String FromLocation, String ToLocation, String Firstname_Of_Adult1, String Middlename_of_Adult1, String Lastname_Of_Adult1, String Firstname_Of_Adult2, String Middlename_of_Adult2, String Lastname_Of_Adult2, String Firstname_Of_Adult3, String Middlename_of_Adult3, String Lastname_Of_Adult3, String Email, String Confirm_Email, String Phone, String Destination_Phone, String CardHolderName, String CardNo, String CardCvvNo, String Address, String City, String Zipcode, String Phone_Number, String BankName) throws Exception
  {                                                                        
  	
		    //For web site and booking details
            Reporter.log("Website Name :- Doleris");
            Thread.sleep(200);
 	 
  	        // For select dynamic flights from result page
       
  	        driver.navigate().refresh();
        
            driver.get("https://cdn.odysol.com/web/air/results.aspx?showtrace=true");
    
  	        driver.manage().window().maximize();
  	        
  	        Thread.sleep(2000);
  	        
  	        System.out.println("\n");
  	        System.out.println("Resultpage Logs..");
  	        System.out.println("\n");
  	        ExtractJSLogs();
  	        
           Thread.sleep(2000);
  	 
           final Screenshot screenshot4 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
           final BufferedImage image4 = screenshot4.getImage();
           ImageIO.write(image4, "PNG", new File("D:\\Ajit\\Script_SS\\CDNDolaris\\1_Resultpage.png"));
      
  	        Thread.sleep(3000);
  	        
  	        //For View Details 
  	        if(driver.findElement(By.cssSelector("[id*='flight-summary_0'] > div.bonusrow.cf.airlineBotBg [class*='showadd fdetailsshow print-showadd']")).isDisplayed())
  	        {
  	        	     WebElement element = driver.findElement(By.cssSelector("[id*='flight-summary_0'] > div.bonusrow.cf.airlineBotBg [class*='showadd fdetailsshow print-showadd']"));
                     JavascriptExecutor js =(JavascriptExecutor)driver;
                     js.executeScript("window.scrollTo(0,'element.getLocation().y+')");
                     element.click();
  	        	      
  	        	      Thread.sleep(500);
	    	        
  	        	      final Screenshot screenshot22 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
  	                  final BufferedImage image22 = screenshot22.getImage();
  	                  ImageIO.write(image22, "PNG", new File("D:\\Ajit\\Script_SS\\CDNDolaris\\2_ViewDetails.png"));
	                  Thread.sleep(1000);
	                
	                  driver.findElement(By.cssSelector("[id*='flight-summary_0'] > div.bonusrow.cf.airlineBotBg [class*='showadd fdetailsshow print-showadd']")).click();
	                  Thread.sleep(3000);
  	        }
  	        
  	        // For verify price on result page
  	        String perperson = driver.findElement(By.cssSelector("[id*='flight-summary_'] > div.pricebox.btn-container > span.flprice [class*='avg-price PkgPriceAverage']")).getText();
  	        Reporter.log("Price per person on result page: " +perperson);
  	        Thread.sleep(2000);
  	        
  	        String totalpriceonresult = driver.findElement(By.cssSelector("[id*='flight-summary_'] > div.pricebox.btn-container > span.flprice [class*='tot-price PkgPriceTotal']")).getText();
  	        Reporter.log("Total Price on result page: " +totalpriceonresult);
  	        Thread.sleep(1000);
try
{
           // For select flight
           if(driver.findElement(By.cssSelector("#flight-summary_0 > div.pricebox.btn-container > a.select-flight.print-select-flight.primary-btn.pull-left.m-hidden")).isDisplayed())
           {
          	   driver.findElement(By.cssSelector("#flight-summary_0 > div.pricebox.btn-container > a.select-flight.print-select-flight.primary-btn.pull-left.m-hidden")).click();
          	   long start1 = System.currentTimeMillis();
   	           Thread.sleep(4000);
   	           long finish1 = System.currentTimeMillis();
   	           long totalTime1 = finish1 - start1; 
   	           Reporter.log("Total Time for Result page to Checkout page load(Milisec) - "+totalTime1); 
   	           Thread.sleep(1000);
          	  
           }
           else if (driver.findElement(By.cssSelector("#mainBody > div:nth-child(2) > div > div.error-box.priceErr")).isDisplayed()) 
           {                                          
				  driver.navigate().refresh();
				  driver.findElement(By.cssSelector("#flight-summary_0 > div.pricebox.btn-container > a.select-flight.print-select-flight.primary-btn.pull-left.m-hidden")).click();
				  long start1 = System.currentTimeMillis();
       	          Thread.sleep(4000);
       	          long finish1 = System.currentTimeMillis();
       	          long totalTime1 = finish1 - start1; 
       	          Reporter.log("Total Time for Result page to Checkout page load(Milisec) - "+totalTime1); 
       	          Thread.sleep(1000);
			}
           else if (driver.findElement(By.cssSelector("#mainBody > div:nth-child(2) > div > div.error-box.priceErr")).isDisplayed())
           {
           	     String errorm = driver.findElement(By.cssSelector("#mainBody > div:nth-child(2) > div > div.error-box.priceErr")).getText();
           	     Reporter.log("Error on result page: " +errorm);
           	     Thread.sleep(1000);
           	     AssertJUnit.assertTrue(" " +errorm, fredpotpymnt.isDisplayed());
	    		 return;
			}
           else 
           {
           	  System.out.println("Flight not available..");
           	  System.out.println("\n");
           	  System.out.println("Flight not available on resultpage Logs..");
              System.out.println("\n");
           	  ExtractJSLogs();
            	
           	   final Screenshot screenshot2 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
               final BufferedImage image2 = screenshot2.getImage();
               ImageIO.write(image2, "PNG", new File("D:\\Ajit\\Script_SS\\CDNDolarisError\\2_Flightnotavailable.png"));
              
                Assert.assertFalse(false, "FAIL");
  	            Reporter.log("Flights not available..");
  			    AssertJUnit.assertTrue("Flight not available...", fredpotpymnt.isDisplayed());
  			    return;
  		   }
}           
	        
catch (Exception e) 
{
	// TODO: handle exception
	 e.getMessage();
	 
	 final Screenshot screenshot2 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
     final BufferedImage image2 = screenshot2.getImage();
     ImageIO.write(image2, "PNG", new File("D:\\Ajit\\Script_SS\\CDNDolarisError\\2_Flightnotavailable.png"));
   
        Assert.assertFalse(false, "FAIL");
        Reporter.log("Flights not available..");
	    AssertJUnit.assertTrue("Flight not available...", fredpotpymnt.isDisplayed());
	    throw(e);
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
              
              final Screenshot screenshot3 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
              final BufferedImage image3 = screenshot3.getImage();
              ImageIO.write(image3, "PNG", new File("D:\\Ajit\\Script_SS\\CDNDolaris\\3_Checkoutpage.png"));
       
              System.out.println("Flight selected successfully..");
               
              Thread.sleep(1000);
              
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
    //   System.out.println("Confirm_Email: " + Confirm_Email);
         System.out.println("Phone_No: " + Phone);
         System.out.println("Destination_Phone: " + Destination_Phone); 
         
         faredptpurchse.CDNDolerisToTitle(Firstname_Of_Adult1, Middlename_of_Adult1, Lastname_Of_Adult1, Firstname_Of_Adult2, Middlename_of_Adult2, Lastname_Of_Adult2, Firstname_Of_Adult3, Middlename_of_Adult3, Lastname_Of_Adult3, Email, Confirm_Email, Phone, Destination_Phone);
         
     }
     catch(Exception e)
     {
    	  System.out.println("\n");
    	  System.out.println("Invalid guest information on checkoutpage Logs..");
    	  System.out.println("\n");
    	  ExtractJSLogs();
    	 
          final Screenshot screenshot44 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
		  final BufferedImage image44 = screenshot44.getImage();
		  ImageIO.write(image44, "PNG", new File("D:\\Ajit\\Script_SS\\CDNDolarisError\\3_InvalidGuestInfo.png"));
         
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
       		    Thread.sleep(1000);
       		    driver.findElement(By.xpath("//*[@id='_ctl0__ctl0_MainContentsParentPH_MainContentsPH__ctl0_GuestResidency_CountrySel']/option[215]")).click();
                Thread.sleep(10000);          
                driver.findElement(By.xpath("//*[@id='_ctl0__ctl0_MainContentsParentPH_MainContentsPH__ctl0_GuestResidency_StateSel']")).click();
                Thread.sleep(1000);
                driver.findElement(By.xpath("//*[@id='_ctl0__ctl0_MainContentsParentPH_MainContentsPH__ctl0_GuestResidency_StateSel']/option[13]")).click();
                Thread.sleep(5000);
       	 }
       	 
       	     Thread.sleep(5000);
       	     
       	     //For check insurance price
                String insuranceprice = driver.findElement(By.cssSelector("#section_insurance > div.insurance-sec > div > div.travel-box > div.preferences-insurance-box > div.insurance-travelguard-yes-text > span")).getText();
                Reporter.log("Insurance Price:- " +insuranceprice);
                Thread.sleep(4000); 
        }
        catch(Exception e)
        {
         	 e.getMessage();
        }
             
        try
        {
        	 
        	 if( driver.findElement(By.cssSelector("#section_insurance > div.insurance-sec > div > div.travel-box > div.preferences-insurance-box > div.insurance-travelguard-yes-text > p [id*='InsurranceCHK_']")).isDisplayed())
        	 {	
                  driver.findElement(By.cssSelector("#section_insurance > div.insurance-sec > div > div.travel-box > div.preferences-insurance-box > div.insurance-travelguard-yes-text > p [id*='InsurranceCHK_']")).click();
                  Thread.sleep(4000);
                  
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
                  
                   Thread.sleep(1000);
                   
                  //For check insurance price
                   String insurprice = driver.findElement(By.cssSelector("#trip_summary_package_total")).getText();
                   Reporter.log("Prices of After applied insurance on the Payment page:- " +insurprice);
                   Thread.sleep(4000); 
                   
                  final Screenshot screenshot64 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                  final BufferedImage image64 = screenshot64.getImage();
                  ImageIO.write(image64, "PNG", new File("D:\\Ajit\\Script_SS\\CDNDolaris\\4_AppliedInsurance.png"));
                  
                  Thread.sleep(6000);
                  
                  //For Remove insurance
                  WebElement element = driver.findElement(By.cssSelector("#section_insurance > div.insurance-sec > div > div.travel-box > div.preferences-insurance-box > div.insurance-travelguard-no-text > p [id*='InsurranceCHK_NON"));
                  JavascriptExecutor js =(JavascriptExecutor)driver;
                  js.executeScript("window.scrollTo(0,'element.getLocation().y+')");
                  element.click();
                  Thread.sleep(1000);
                  
                  driver.findElement(By.cssSelector("#DivTravlGuardPopup > div.inscontent > div.inscontentbox > div.button2 [class*='select-op bPopup-close']")).click();
                  Thread.sleep(3000);
                  
                  Reporter.log("Insurance Removed successfully..");
                  
                  //For check insurance price
                  String insprice = driver.findElement(By.cssSelector("#trip_summary_package_total")).getText();
                  Reporter.log("Prices of After removed insurance on the Payment page:- " +insprice);
                  Thread.sleep(3000);  
                  
                  final Screenshot screenshot66 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                  final BufferedImage image66 = screenshot66.getImage();
                  ImageIO.write(image66, "PNG", new File("D:\\Ajit\\Script_SS\\CDNDolaris\\5_RemovedInsurance.png"));
                  
                  Thread.sleep(4000);
                  
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
              ImageIO.write(image72, "PNG", new File("D:\\Ajit\\Script_SS\\CDNDolarisError\\9_InsurancenotAppliedOrRemoved.png"));
    
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
       	  
       	  File scr03 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
          org.codehaus.plexus.util.FileUtils.copyFile(scr03, new File("D:\\Ajit\\Script_SS\\CDNDolaris\\6_AdditionalServiceOnCheckoutpage.png")); 
       	  Thread.sleep(1500);
        }
        catch(Exception e)
        {
       	    final Screenshot screenshot74 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
            final BufferedImage image74 = screenshot74.getImage();
            ImageIO.write(image74, "PNG", new File("D:\\Ajit\\Script_SS\\CDNDolarisError\\10_ErrorOnAdditionalService.png"));
            Thread.sleep(1000);
            
            AssertJUnit.assertTrue("Additional Service not working or showing error on additional service page", faredptpurchse.isDisplayed());
	        throw(e);
        }
        
       //For Payment Information
        try
        {
       	  driver.findElement(By.xpath("//*[@id='st-accordion']/ul/li[5]/a")).click();
       	  Thread.sleep(2000);
       	  
       	     final Screenshot screenshot76 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
             final BufferedImage image76 = screenshot76.getImage();
             ImageIO.write(image76, "PNG", new File("D:\\Ajit\\Script_SS\\CDNDolaris\\7_PaymentInfoPage.png"));
       	     Thread.sleep(2000);
        }
        catch(Exception e)
        {
       	    final Screenshot screenshot77 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
            final BufferedImage image77 = screenshot77.getImage();
            ImageIO.write(image77, "PNG", new File("D:\\Ajit\\Script_SS\\CDNDolarisError\\10_ErrorOnPaymentInfoPage.png"));
            Thread.sleep(1000);
            
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
                   
         try
         {
       	  
       	     System.out.println("CardHolderName: " + CardHolderName);
             System.out.println("CardNo: " + CardNo);
             System.out.println("CardCvvNo: " + CardCvvNo);
             System.out.println("Address: " + Address);
             System.out.println("City: " + City);
             System.out.println("Zipcode: " + Zipcode);
             System.out.println("Phone_Number: " + Phone_Number);
             System.out.println("BankName: " + BankName);
       	  
       	  fredpotpymnt.CDNFaredepotPaymentToTitle(CardHolderName, CardNo, CardCvvNo, Address, City, Zipcode, Phone_Number, BankName);
       	  Thread.sleep(1500);
        	 
        	 if(envrnmnt.toLowerCase().trim().equals("test"))
        	 {
        		 driver.findElement(By.xpath("//*[@id='_ctl0__ctl0_MainContentsParentPH_MainContentsPH__ctl0_ContinueBTN']")).click();
        		 
        		 long start1 = System.currentTimeMillis();
        	     Thread.sleep(8000);
        	     long finish1 = System.currentTimeMillis();
        	     long totalTime1 = finish1 - start1; 
        	     Reporter.log("Total Time for Checkout page to Confirm Booking page load(Milisec) - "+totalTime1); 
        	     Thread.sleep(3000);
        		 
        	 }
         }
         
         catch(Exception e)
         {
       	    e.getMessage();
       	  
       	    final Screenshot screenshot44 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
   		    final BufferedImage image44 = screenshot44.getImage();
   		    ImageIO.write(image44, "PNG", new File("D:\\Ajit\\Script_SS\\CDNDolarisError\\4_InvalidPaymentInfo.png"));
           
              Assert.assertFalse(false, "FAIL");
              Reporter.log("Invalid Payment information on paymentpage...");
     	      AssertJUnit.assertTrue("Invalid Payment information on paymentpage...", fredpotpymnt.isDisplayed());
     	      throw(e);
         }
         
       //For the verify confirm condition
         String status = driver.findElement(By.cssSelector("#conf_details > div > div.flight-conf-status > div")).getText(); 
                           
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
	             ImageIO.write(image11, "PNG", new File("D:\\Ajit\\Script_SS\\CDNDolarisError\\11_ConfirmbookingFail.png"));
	             
	             Reporter.log("Actual status is:-" +status);
	             Assert.assertFalse(false, "FAIL");
	             Reporter.log("Status Fail b'coz status are differ to expected..");
			     AssertJUnit.assertTrue("Status Fail b'coz status are differ to expected...", fredpotpymnt.isDisplayed());
			     return;
		  }
        
                   System.out.println("Actual status is:- "+ status);
                   Reporter.log("Actual status is:- " + status);
         
                   final Screenshot screenshot12 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                   final BufferedImage image12 = screenshot12.getImage();
                   ImageIO.write(image12, "PNG", new File("D:\\Ajit\\Script_SS\\CDNDolaris\\8_FlightConfirmed.png"));
         
                   System.out.println("Flight confirmed successfully..");
          
                   Reporter.log("Flight confirmed successfully..");  // For displaying message on report
         
                   Thread.sleep(1500);
         
   }
  
  @DataProvider
  public String[][] Authentication() throws Exception
  {
  	 
 	     String[][] testObjArray = CDNDolerisUtils.getTableArray("D:\\Ajit\\Automation\\Workspace\\Odysseus_Product\\src\\main\\java\\testData\\CDNDolerisData.xlsx","Sheet1");
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
