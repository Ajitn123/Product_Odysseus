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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Utility.BPCUtils;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.screentaker.ViewportPastingStrategy;


public class BPCCruiseBookingTest 
{

	     BPCCruisePurchasepageobjct crspurchpge;
	     BPCCruiseBookingpgeobjct crsbkngpge;
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
	                       driver = new FirefoxDriver();
  	   
	                 } 
	                 else if (browser.equalsIgnoreCase("chrome")) 
	                 {
	                	//    System.setProperty("webdriver.chrome.driver", "D:\\Ajit\\Driver\\chromedriver_win32\\chromedriver.exe");
		                //    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		                //    LoggingPreferences loggingprefs = new LoggingPreferences();
		                //    loggingprefs.enable(LogType.BROWSER, Level.ALL);
		                //    capabilities.setCapability(CapabilityType.LOGGING_PREFS, loggingprefs);
		                //    driver = new ChromeDriver(capabilities);
		                   
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
               driver.get("https://book.bestpricecruises.com/");
               Thread.sleep(2000);
            
               //Save console
               String testResultFile="D:\\Ajit\\Script_SS\\ConsoleError\\BPCCruisebookingError.txt";
               File file = new File(testResultFile);  
               FileOutputStream fis = new FileOutputStream(file);  
               PrintStream out = new PrintStream(fis);  
               System.setOut(out); 
                          
               Thread.sleep(1000);
            
               final Screenshot screenshot1 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
               final BufferedImage image1 = screenshot1.getImage();
               ImageIO.write(image1, "PNG", new File("D:\\Ajit\\Script_SS\\BPC\\1_Searchpage.png"));
               Thread.sleep(1000);
               System.out.println("\n");
     	       System.out.println("Searchpage Logs..");
     	       System.out.println("\n");
     	       ExtractJSLogs();

               //driver.navigate().to("https://localhost/odyssey/website/air/results.aspx?");
               Thread.sleep(4000);
               crsbkngpge = PageFactory.initElements(driver, BPCCruiseBookingpgeobjct.class);
               crspurchpge = PageFactory.initElements(driver, BPCCruisePurchasepageobjct.class);
            
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
     public void BPC_data(String FirstName_Of_Guest1, String MiddleName_Of_Guest1, String LastName_Of_Guest1, String Address, String CityName, String PinCode, String EmailAddress, String Phone, String Firstname_of_Guest2, String Middlename_of_Guest2, String Lastname_of_Guest2) throws Exception
     {
          
         try
         {
        	//For web site and booking details
             Reporter.log("Website Name:- BPC");
             Thread.sleep(200);
        	 
        	 crsbkngpge.BookingToTittle();
        	 Thread.sleep(4000);
        	 System.out.println("\n");
   	         System.out.println("Resultpage Logs..");
   	         System.out.println("\n");
   	         ExtractJSLogs();
   	        
             Thread.sleep(1000);
             
         //For verify error message on result page  
         try
         {
        	  if(driver.findElement(By.cssSelector("#MainForm > table > tbody > tr:nth-child(2) > td")).isDisplayed())
              {
             	   String err = driver.findElement(By.cssSelector("#MainForm > table > tbody > tr:nth-child(2) > td")).getText();
            	   Thread.sleep(300);
            	   Reporter.log("Error message: " +err);
            	   Thread.sleep(1000);
            	 
            	   final Screenshot screenshot87 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
  	               final BufferedImage image87 = screenshot87.getImage();
  	               ImageIO.write(image87, "PNG", new File("D:\\Ajit\\Script_SS\\BPCError\\04_Erroronresultpage.png"));
  	          
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
   	 
                Thread.sleep(300);
   	            final Screenshot screenshot4 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                final BufferedImage image4 = screenshot4.getImage();
                ImageIO.write(image4, "PNG", new File("D:\\Ajit\\Script_SS\\BPC\\2_Resultpage.png"));
            
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
	          ImageIO.write(image33, "PNG", new File("D:\\Ajit\\Script_SS\\BPCError\\1_TimeoutORinvalidsearchdetails.png"));
	          
    	      Assert.assertFalse(false, "FAIL");
    	      Reporter.log("Time out or Invalid search criteria on resultpage..");
    	      AssertJUnit.assertTrue("Time out or Invalid search criteria on resultpage...", crsbkngpge.isDisplayed());
    	      throw(e);
         }
          
              driver.navigate().refresh();
              driver.get("https://book.bestpricecruises.com/web/cruises/results.aspx?showtrace=true");
              Thread.sleep(1000);
         
               //For Select cruise from result page
          	   try
          	   {
         	       driver.findElement(By.xpath("//*[@id='sr5']/div[2]/div[3]/div[2]/button[2]")).click();
         	       Thread.sleep(1000); 
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
                          ImageIO.write(image5, "PNG", new File("D:\\Ajit\\Script_SS\\BPCError\\2_Cruisenotavailable.png"));
                      
                          Assert.assertFalse(false, "FAIL");
       	                  Reporter.log("Cruise not available..");
       			          AssertJUnit.assertTrue("Cruise not available...", crsbkngpge.isDisplayed());
       			          throw(e);
       		   }
          	   
        for(int i = driver.getWindowHandles().size() -1 ; i > 0 ; i--)
        {

                            String winHandle = driver.getWindowHandles().toArray()[i].toString();

                            driver.switchTo().window(winHandle);
                           
                            driver.navigate().refresh();
                            
                            Thread.sleep(3000);  
                            
                            driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
                            
                            if(driver.findElement(By.xpath("//*[@id='PopUp']/div[2]/div/div[7]/div[3]/button")).isDisplayed())
                            {	
                                
                                driver.findElement(By.xpath("//*[@id='PopUp']/div[2]/div/div[7]/div[3]/button")).click(); //Handle popup on details page
                    	        Thread.sleep(100);
                                 
                            }
                                driver.switchTo().defaultContent();
                                Thread.sleep(3000);
            	   
                          System.out.println("\n");
                          System.out.println("Cruise detailspage Logs..");
                          System.out.println("\n");
                          ExtractJSLogs();              
                          Thread.sleep(1000);
                       
                      final Screenshot screenshot6 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                      final BufferedImage image6 = screenshot6.getImage();
                      ImageIO.write(image6, "PNG", new File("D:\\Ajit\\Script_SS\\BPC\\3_Cruisedetailspage.png"));
               
                      System.out.println("Cruise selected successfully..");
                       
                      Thread.sleep(4000);
                  
                      //For the Cruise details are print on HTML report
                      String CruiseLine = driver.findElement(By.cssSelector("#sailingDetails > div > table > tbody > tr:nth-child(1) > td.sdInfo")).getText();
                      Reporter.log("Cruise Line:- " +CruiseLine);
                      Thread.sleep(500);
                      String shp = driver.findElement(By.cssSelector("#sailingDetails > div > table > tbody > tr:nth-child(2) > td.sdInfo")).getText();
                      Reporter.log("Ship: " +shp);
                      Thread.sleep(800);
                      String Length = driver.findElement(By.cssSelector("#sailingDetails > div > table > tbody > tr:nth-child(3) > td.sdInfo")).getText();
                      Reporter.log("Length:- " +Length);
                      Thread.sleep(500);
                      String Itinerary = driver.findElement(By.cssSelector("#sailingDetails > div > table > tbody > tr:nth-child(4) > td.p2")).getText();
                      Reporter.log("Itinerary:- " +Itinerary);
                      Thread.sleep(100);
                      String Departing = driver.findElement(By.cssSelector("#sailingDetails > div > table > tbody > tr:nth-child(5) > td.sdInfo")).getText();
                      Reporter.log("Departing:- " + Departing);
                      String Returning = driver.findElement(By.cssSelector("#sailingDetails > div > table > tbody > tr:nth-child(6) > td.sdInfo")).getText();
                      Reporter.log("Returning:- " +Returning);
                      Thread.sleep(400);
                      

                //For the Cruise details page
                try
                {
                 	
                    driver.findElement(By.id("_ctl0:MainContentsPH:_ctl0:_ctl2_GuestAge_1")).clear();
                    Thread.sleep(100);
                    driver.findElement(By.id("_ctl0:MainContentsPH:_ctl0:_ctl2_GuestAge_1")).click();
                    Thread.sleep(100);
                    driver.findElement(By.id("_ctl0:MainContentsPH:_ctl0:_ctl2_GuestAge_1")).sendKeys("10");
                    Thread.sleep(300);
                    driver.findElement(By.id("_ctl0:MainContentsPH:_ctl0:_ctl2_GuestAge_2")).clear();
                    Thread.sleep(100);
                    driver.findElement(By.id("_ctl0:MainContentsPH:_ctl0:_ctl2_GuestAge_2")).click();
                    Thread.sleep(100);
                    driver.findElement(By.id("_ctl0:MainContentsPH:_ctl0:_ctl2_GuestAge_2")).sendKeys("67");
                    Thread.sleep(300);
                    driver.findElement(By.id("_ctl0_MainContentsPH__ctl0__ctl2_ResidentState")).click();
                    Thread.sleep(300);
                    driver.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0__ctl2_ResidentState']/option[3]")).click();
                    Thread.sleep(500);
                    driver.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0__ctl2_CategoryLNK']/span[1]")).click();
                    
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
           	 
      	            final Screenshot screenshot8 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
      	            final BufferedImage image8 = screenshot8.getImage();
      	            ImageIO.write(image8, "PNG", new File("D:\\Ajit\\Script_SS\\BPCError\\3_InvalidGuestinformation.png"));
      	          
           	        Assert.assertFalse(false, "FAIL");
           	        Reporter.log("Invalid guest information on detailspage...");
           	        AssertJUnit.assertTrue("Invalid guest information on detailspage...", crsbkngpge.isDisplayed());
           	        throw(e);
                }
                
                   
                   //For select category from the category page
                   try
                   {
                	 /* 
                	   driver.findElement(By.id("showIn")).click();
                	   Thread.sleep(1000);
                	   driver.findElement(By.id("showOut")).click();
                	   Thread.sleep(3000);
                	 */
                 	   final Screenshot screenshot9 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                       final BufferedImage image9 = screenshot9.getImage();
                       ImageIO.write(image9, "PNG", new File("D:\\Ajit\\Script_SS\\BPC\\4_Categorypage.png"));
                       Thread.sleep(4000);
                       driver.findElement(By.xpath("//a[@class='btn btn-sm btn-default active']")).click();
                	   WebElement viewcat = driver.findElement(By.xpath("//a[@class='btn btn-default btn-block catDescBtn visible-md visible-lg']"));
                	   viewcat.click();
                	   Thread.sleep(3000);
                	   System.out.println("\n");
             	       System.out.println("View category info on categorypage Logs..");
             	       System.out.println("\n");
             	       ExtractJSLogs();
             	       Thread.sleep(2000);
                	   final Screenshot screenshot99 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                       final BufferedImage image99 = screenshot99.getImage();
                       ImageIO.write(image99, "PNG", new File("D:\\Ajit\\Script_SS\\BPC\\5_Viewcategoryinfo.png"));
                	   Thread.sleep(5000);
                	   driver.findElement(By.xpath("//a[@class='btn btn-default btn-block catDescBtn visible-md visible-lg']")).click();
                	   Thread.sleep(8000);
                	   
                	    //For the Bonus offers
                	     if(driver.findElement(By.id("va_OBC_ctl0_MainContentsPH_Categories_Categories__ctl0__ctl0__ctl0_BestPricesRPT__ctl1_PromotionsUC_OBCredit__ctl0")).isDisplayed())
                	     {
                	    	 
                	    	 WebElement bonusoffr = driver.findElement(By.id("va_OBC_ctl0_MainContentsPH_Categories_Categories__ctl0__ctl0__ctl0_BestPricesRPT__ctl1_PromotionsUC_OBCredit__ctl0"));
                	    	 bonusoffr.click();
                	    	 System.out.println("Bonus offers are available..");
                	    	 Reporter.log("Bonus offers are available..");
                   		     Thread.sleep(3000);
                   		     File scr02 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            	             org.codehaus.plexus.util.FileUtils.copyFile(scr02, new File("D:\\Ajit\\Script_SS\\BPC\\6_BonusoffersAvailable.png")); 
                    	     Thread.sleep(2000);
                    	     driver.findElement(By.xpath("//*[@id='full-terms_24403__ctl0_MainContentsPH_Categories_Categories__ctl0__ctl0__ctl0_BestPricesRPT__ctl1_PromotionsUC_OBCredit__ctl0']/div/div/div[1]/button/span")).click();
                    	     Thread.sleep(2000);
                    	     System.out.println("\n");
                   	         System.out.println("Bonus offers on categorypage Logs..");
                   	         System.out.println("\n");
                   	         ExtractJSLogs();
                   	         Thread.sleep(4000);
                	     }
                	     else
                	     {
						      System.out.println("Bonus offers are not available..");	
						      Reporter.log("Bonus offers not are available..");
						      System.out.println("\n");
			          	      System.out.println("Bonus offers are not available on categorypage Logs..");
			          	      System.out.println("\n");
			          	      ExtractJSLogs();
			          	      Thread.sleep(1000);
						      final Screenshot screenshot93 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	                          final BufferedImage image93 = screenshot93.getImage();
	                          ImageIO.write(image93, "PNG", new File("D:\\Ajit\\Script_SS\\BPC\\7_BonusoffersNotavailable.png"));
	                    	  Thread.sleep(1000);
						 }
                	     
                	    try
                        {
                            //For price check on the category page
                            String pricesoncat = driver.findElement(By.cssSelector("#IndividualCat-OW > div.col-md-8.catFCrows > div:nth-child(2) > div > div.panel-body > div.col-xs-12.catFCrvp > span.catFCfinCost")).getText();
                            System.out.println("Prices on category page is:- " +pricesoncat);
                            Reporter.log("Prices on category page is:- " +pricesoncat);
                            Thread.sleep(4000);
                        }
                        catch(Exception e)
                        {
                         	final Screenshot screenshot80 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
               	            final BufferedImage image80 = screenshot80.getImage();
               	            ImageIO.write(image80, "PNG", new File("D:\\Ajit\\Script_SS\\BPCError\\4_Pricenotavailableoncategorypage.png"));
               	          
                    	    Assert.assertFalse(false, "FAIL");
                    	    Reporter.log("Price not availabe on category page...");
                    	    AssertJUnit.assertTrue("Price not availabe on category page...", crsbkngpge.isDisplayed());
                    	    throw(e);
                         }	     
                	     
                	   driver.findElement(By.cssSelector("[id*='IndividualCat-'] > div.col-md-8.catFCrows > div:nth-child(2) > div > div.panel-body > div.col-xs-12.catFCsub [class*='btn btn-default btn-block']")).click();
                	   Thread.sleep(2000);
                	   
                	   //For handle pop up on category page
                       if(driver.findElement(By.xpath("//button[@class='btn btn-block btn-default noteBtn']")).isDisplayed())
                       {	
                           
                           driver.findElement(By.xpath("//button[@class='btn btn-block btn-default noteBtn']")).click(); //Handle popup on details page
               	           Thread.sleep(100);
                            
                       }
                          
                           Thread.sleep(3000);
                           
                   }
                   catch(Exception e)
                   {
                 	      System.out.println("Category not available..");
                 	      System.out.println("\n");
                 	      System.out.println("Category not available on categorypage Logs..");
                 	      System.out.println("\n");
                 	      ExtractJSLogs();
                    
                          final Screenshot screenshot10 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                          final BufferedImage image10 = screenshot10.getImage();
                          ImageIO.write(image10, "PNG", new File("D:\\Ajit\\Script_SS\\BPCError\\5_Categorynotavailable.png"));
                    
                          Assert.assertFalse(false, "FAIL");
     	                  Reporter.log("Category not available..");
     			          AssertJUnit.assertTrue("Category not available...", crsbkngpge.isDisplayed());
     			          throw(e);
     		         }
                    
                          System.out.println("Category selected successfully..");
                
                          Thread.sleep(5000); 
              
                         //For select cabin from the cabin selection page
                         try
                         {
                        	//For check API, Office id And Test environment on cabin page (If cabin available then put below code on before print category success message)
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
                        	 
                        	if(driver.findElement(By.xpath("//button[@class='btn btn-default btn-block']")).isDisplayed())
                        	{
                        		driver.findElement(By.xpath("//button[@class='btn btn-default btn-block']")).click();
                                Thread.sleep(2000);
                                
                                System.out.println("\n");
                                System.out.println("Cabin selectionpage Logs..");
                                System.out.println("\n");
                                ExtractJSLogs();              
                                Thread.sleep(1000);
                      
                                final Screenshot screenshot11 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                                final BufferedImage image11 = screenshot11.getImage();
                                ImageIO.write(image11, "PNG", new File("D:\\Ajit\\Script_SS\\BPC\\8_Cabinselectionpage.png"));
                                Thread.sleep(2000);

                        	}
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
                                  ImageIO.write(image13, "PNG", new File("D:\\Ajit\\Script_SS\\BPCError\\6_Cabinnotavailable.png"));
                           
                                  Assert.assertFalse(false, "FAIL");
            	                  Reporter.log("Cabin not available..");
            			        //  AssertJUnit.assertTrue("Cabin not available...", crsbkngpge.isDisplayed());
            			        // throw(e);
            		         }
                           
                                 System.out.println("\n");
                                 System.out.println("Continue without signing page Logs..");
                                 System.out.println("\n");
                                 ExtractJSLogs();              
                                 Thread.sleep(1000);
                                 
                                //For handle unnecessary pop up
                                try
                                {
                                	if(driver.findElement(By.cssSelector("#cabinBypassPopup > div > div > div.modal-body > div:nth-child(3) > div:nth-child(3) [class*='btn btn-block btn-default noteBtn']")).isDisplayed())
                                	{	
                                 	    driver.findElement(By.cssSelector("#cabinBypassPopup > div > div > div.modal-body > div:nth-child(3) > div:nth-child(3) [class*='btn btn-block btn-default noteBtn']")).click();
                               	        Thread.sleep(1000);
                                	}    
                                }
                                catch(Exception e)
                                {
                                	e.getMessage();
                                }
                                    
                                 final Screenshot screenshot12 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                                 final BufferedImage image12 = screenshot12.getImage();
                                 ImageIO.write(image12, "PNG", new File("D:\\Ajit\\Script_SS\\BPC\\9_Continuewithoutsigningpage.png"));
               
                                 System.out.println("Cabin selected successfully..");
                       
                                 Thread.sleep(4000);
                                 
                             //For Continue without signing In
                             try
                             {
                               	 if(driver.findElement(By.xpath("//*[@id='loginForms']/div[2]/a/span[1]")).isDisplayed())
                            	 {
                            		 driver.findElement(By.xpath("//*[@id='loginForms']/div[2]/a/span[1]")).click();  
                                     Thread.sleep(1000);	 
                            	 }
                            	 
                             }
                             catch(Exception e)
                             {
                            	 System.out.println("Continue without signing in button is not click or Not available..");
                       	         System.out.println("\n");
                       	         System.out.println("Continue without signing on statementpage Logs..");
                       	         System.out.println("\n");
                       	         ExtractJSLogs();
                          
                                 final Screenshot screenshot33 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                                 final BufferedImage image33 = screenshot33.getImage();
                                 ImageIO.write(image33, "PNG", new File("D:\\Ajit\\Script_SS\\BPCError\\7_Continuewithoutsigningnotclickonstatementpage.png"));
                          
                                 Assert.assertFalse(false, "FAIL");
           	                     Reporter.log("Continue without signing in button is not click or Not available...");
           			             AssertJUnit.assertTrue("Continue without signing in button is not click or Not available....", crsbkngpge.isDisplayed());
           			             throw(e);
                             }
                                 System.out.println("\n");
                                 System.out.println("Purchasepage Logs..");
                                 System.out.println("\n");
                                 ExtractJSLogs();              
                                 Thread.sleep(1000);
                   
                                 final Screenshot screenshot22 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                                 final BufferedImage image22 = screenshot22.getImage();
                                 ImageIO.write(image22, "PNG", new File("D:\\Ajit\\Script_SS\\BPC\\10_Purchasepage.png"));
           
                                 System.out.println("Continue without signing in successfully..");
                    
                                 Thread.sleep(4000);
                                           
                             //For purchase page
                             String pricesonpur = driver.findElement(By.xpath("//*[@id='pricingBD']/tbody/tr[4]/td[2]/strong")).getText();
                             System.out.println("Price on purchase page is:- " +pricesonpur);
                             Reporter.log("Price on purchase page is:- " +pricesonpur);
                             Thread.sleep(800);
                                 
                             try
                             {
                            	 System.out.println("FirstName_Of_Guest1: " + FirstName_Of_Guest1);
                            	 System.out.println("MiddleName_Of_Guest1: " + MiddleName_Of_Guest1);
                            	 System.out.println("LastName_Of_Guest1: " + LastName_Of_Guest1);
                            	 System.out.println("Address: " + Address);
                            	 System.out.println("CityName: " + CityName);
                            	 System.out.println("PinCode: " + PinCode);
                            	 System.out.println("EmailAddress: " + EmailAddress);
                            	 System.out.println("Phone: " + Phone);
                            	 System.out.println("Firstname_of_Guest2: " + Firstname_of_Guest2);
                            	 System.out.println("Middlename_of_Guest2: " + Middlename_of_Guest2);
                            	 System.out.println("Lastname_of_Guest2: " + Lastname_of_Guest2);
                            	 
                            	 crspurchpge.PurchaseToTittle(FirstName_Of_Guest1, MiddleName_Of_Guest1, LastName_Of_Guest1, Address, CityName, PinCode, EmailAddress, Phone, Firstname_of_Guest2, Middlename_of_Guest2, Lastname_of_Guest2);
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
                                 ImageIO.write(image34, "PNG", new File("D:\\Ajit\\Script_SS\\BPCError\\8_InvalidGuestinfoonPurchasepage.png"));
                          
                                 Assert.assertFalse(false, "FAIL");
           	                     Reporter.log("Invalid guest information on purchase page, Please enter valid details for the required fields...");
           			             AssertJUnit.assertTrue("Invalid guest information on purchase page, Please enter valid details for the required fields....", crsbkngpge.isDisplayed());
           			             throw(e);
                             }
                              
                                 System.out.println("\n");
                                 System.out.println("Confirmationpage Logs..");
                                 System.out.println("\n");
                                 ExtractJSLogs();              
                                 Thread.sleep(1000);
                                 
                                 final Screenshot screenshot44 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                                 final BufferedImage image44 = screenshot44.getImage();
                                 ImageIO.write(image44, "PNG", new File("D:\\Ajit\\Script_SS\\BPC\\11_Confirmationpage.png"));
                                 
                                 Thread.sleep(2000);
                                 
                               //For Price on confirmation page
                               String price = driver.findElement(By.cssSelector("#pricingBD > tbody > tr.pricingTotal.psGrTotal > td:nth-child(2) > strong")).getText();
                               Reporter.log("Price on the passenger details page is:- " +price);
                               Thread.sleep(1000);  
                               
                            //For Insurance
                            try
                            {
                            	 if( driver.findElement(By.cssSelector("#insSelect > tbody > tr:nth-child(1) > td.bkInsRd [id*='InsurranceCHK_']")).isDisplayed())
                            	 {	
                                      driver.findElement(By.cssSelector("#insSelect > tbody > tr:nth-child(1) > td.bkInsRd [id*='InsurranceCHK_']")).click();
                                      Thread.sleep(1500);
                                      Reporter.log("Insurance applied successfully..");
                                      
                                      //For check insurance price
                                      String insurprice = driver.findElement(By.cssSelector("#pricingBD > tbody > tr.pricingTotal.psGrTotal > td:nth-child(2) > strong")).getText();
                                      Reporter.log("Prices of After applied insurance on the passenger details page is:- " +insurprice);
                                      Thread.sleep(1000);  
                                      
                                      final Screenshot screenshot64 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                                      final BufferedImage image64 = screenshot64.getImage();
                                      ImageIO.write(image64, "PNG", new File("D:\\Ajit\\Script_SS\\BPC\\12_AppliedInsurance.png"));
                                      
                                      Thread.sleep(2000);
                                      
                                      // Applied insurance price
                                      String appliedinsurprice = driver.findElement(By.cssSelector("#paymentSched > tbody > tr:nth-child(3) > td.pmtsAmt")).getText();
                                      Reporter.log("Insurance price:- " +appliedinsurprice);
                                      Thread.sleep(1000);
                                      
                                      //For Remove insurance
                                      WebElement insurnc = driver.findElement(By.id("InsurranceCHK_NON"));
                                      insurnc.click();
                                      Thread.sleep(1500);
                                      driver.switchTo().alert().accept();
                                      Thread.sleep(500);
                                      
                                      Reporter.log("Insurance Removed successfully..");
                                      
                                      //For check insurance price
                                      String insprice = driver.findElement(By.cssSelector("#pricingBD > tbody > tr.pricingTotal.psGrTotal > td:nth-child(2) > strong")).getText();
                                      Reporter.log("Prices of After removed insurance on the passenger details page is:- " +insprice);
                                      Thread.sleep(1000);  
                                      
                                      final Screenshot screenshot66 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                                      final BufferedImage image66 = screenshot66.getImage();
                                      ImageIO.write(image66, "PNG", new File("D:\\Ajit\\Script_SS\\BPC\\13_RemovedInsurance.png"));
                                      
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
                                 ImageIO.write(image72, "PNG", new File("D:\\Ajit\\Script_SS\\BPCError\\9_InsurancenotAppliedOrRemoved.png"));
                        
                                 Assert.assertFalse(false, "FAIL");
         	                     Reporter.log("Insurance not applied/removed...");
         			             AssertJUnit.assertTrue("Insurance not applied/removed....", crsbkngpge.isDisplayed());
         			             throw(e);
                            }
                            
                            try
                            {
                                 //For select terms and condition check box
                                 driver.findElement(By.id("AgreeTermsCON")).click();
                                 Thread.sleep(1000);
                                 
                                 //Click on Pay in full payment button
                                 driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_ContinueBTN")).click();
                                 Thread.sleep(1000);
                            }
                            catch(Exception e)
                            {
                                 
                            	 System.out.println("Page navigate on invalid page Or Displaying Error message on confirmation page...");
                      	         System.out.println("\n");
                      	         System.out.println("Page navigate on invalid page Or Displaying Error message on confirmation page...");
                      	         System.out.println("\n");
                      	         ExtractJSLogs();
                         
                                 final Screenshot screenshot27 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                                 final BufferedImage image27 = screenshot27.getImage();
                                 ImageIO.write(image27, "PNG", new File("D:\\Ajit\\Script_SS\\BPCError\\10_PageNavigateonInvalidPageOrErrormessaage.png"));
                         
                                 Assert.assertFalse(false, "FAIL");
          	                     Reporter.log("Page navigate on invalid page Or Displaying Error message on confirmation page...");
          			             AssertJUnit.assertTrue("Page navigate on invalid page Or Displaying Error message on confirmation page....", crsbkngpge.isDisplayed());
          			             throw(e);
                                  
                            }  
                                 System.out.println("\n");
                                 System.out.println("Paymentpage Logs..");
                                 System.out.println("\n");
                                 ExtractJSLogs();              
                                 Thread.sleep(1000);
                            
                                 final Screenshot screenshot49 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                                 final BufferedImage image49 = screenshot49.getImage();
                                 ImageIO.write(image49, "PNG", new File("D:\\Ajit\\Script_SS\\BPC\\14_Paymentpage.png"));
                                 
                                 Thread.sleep(2000);
                                 
                                 String paymntprice = driver.findElement(By.xpath("//*[@id='PayPrice']")).getText();
                                 Reporter.log("Price on payment page is:- "+ paymntprice);
                                 
                                 if(paymntprice.equals(price))
                                 {
                                	
                                	 System.out.println("Actual String: " +price);
                                 	 System.out.println("Passenger details page and Payment page's Price matched");
                                	 Reporter.log("Passenger details page and Payment page's Price matched..");
                                	 
                                	 System.out.println("Actual price is:- " +price);
							         Reporter.log("Actual price is:- " +price);
                                 }
                                 else
                                 {
								     System.out.println("Passenger details page and Payment page's Price not match..");
								     Reporter.log("Passenger details page and Payment page's Price not match..");
								     System.out.println("Actual price is:- " +price);
								     Reporter.log("Actual price is:- " +price);
								 }
 							         
							         Thread.sleep(1500);
           }
        
     }

     @DataProvider
     public String[][] Authentications() throws Exception
     {
     	 
 	     String[][] testObjArray = BPCUtils.getTableArray("D:\\Ajit\\Automation\\Workspace\\Odysseus_Product\\src\\main\\java\\testData\\BPCData.xlsx","Sheet1");
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
