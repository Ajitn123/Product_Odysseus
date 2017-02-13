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
import Utility.CruiseUtils;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.screentaker.ViewportPastingStrategy;


public class CruiseBookingTest 
{

	     CruisePurchasepageobjct crspurchpge;
	     CruiseBookingpgeobjct crsbkngpge;
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
	                	//    System.setProperty("webdriver.chrome.driver", "D:\\Ajit\\Driver\\chromedriver_win32 (1)\\chromedriver.exe");
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
               driver.get("https://localhost/odyssey/website/cruises/search.aspx?siid=143693");
               Thread.sleep(2000);
            
               //Save console
               String testResultFile="D:\\Ajit\\Script_SS\\ConsoleError\\CruisebookingError.txt";
               File file = new File(testResultFile);  
               FileOutputStream fis = new FileOutputStream(file);  
               PrintStream out = new PrintStream(fis);  
               System.setOut(out); 
                          
               Thread.sleep(1000);
            
               final Screenshot screenshot1 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
               final BufferedImage image1 = screenshot1.getImage();
               ImageIO.write(image1, "PNG", new File("D:\\Ajit\\Script_SS\\Cruisebooking\\Searchpage.png"));
               Thread.sleep(1000);
               System.out.println("\n");
     	       System.out.println("Searchpage Logs..");
     	       System.out.println("\n");
     	       ExtractJSLogs();

               //driver.navigate().to("https://localhost/odyssey/website/air/results.aspx?");
               Thread.sleep(4000);
               crsbkngpge = PageFactory.initElements(driver, CruiseBookingpgeobjct.class);
               crspurchpge = PageFactory.initElements(driver, CruisePurchasepageobjct.class);
            
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
     public void SearchCruise_data(String FirstName_Of_Guest1, String MiddleName_Of_Guest1, String LastName_Of_Guest1, String Address, String CityName, String PinCode, String EmailAddress, String Phone, String Firstname_of_Guest2, String Middlename_of_Guest2, String Lastname_of_Guest2) throws Exception
     {
          
         try
         {
        	 crsbkngpge.BookingToTittle();
        	 Thread.sleep(4000);
        	 System.out.println("\n");
   	         System.out.println("Resultpage Logs..");
   	         System.out.println("\n");
   	         ExtractJSLogs();
   	        
             Thread.sleep(1000);
   	 
   	        final Screenshot screenshot4 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
            final BufferedImage image4 = screenshot4.getImage();
            ImageIO.write(image4, "PNG", new File("D:\\Ajit\\Script_SS\\Cruisebooking\\Resultpage.png"));
            
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
	          ImageIO.write(image33, "PNG", new File("D:\\Ajit\\Script_SS\\CruisebookingError\\TimeoutORinvalidsearchdetails.png"));
	          
    	      Assert.assertFalse(false, "FAIL");
    	      Reporter.log("Time out or Invalid search criteria on resultpage..");
    	      AssertJUnit.assertTrue("Time out or Invalid search criteria on resultpage...", crsbkngpge.isDisplayed());
    	      throw(e);
         }
           /*    
              //For View Itinerary
              WebElement itnrery = driver.findElement(By.xpath("//div[@class='panel-heading itinHeader collapsed']"));
              itnrery.click();
              Thread.sleep(1000);
              final Screenshot screenshot95 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
              final BufferedImage image95 = screenshot95.getImage();
              ImageIO.write(image95, "PNG", new File("D:\\Ajit\\Script_SS\\Cruisebooking\\ViewItinerary.png"));
              Thread.sleep(1000);
              driver.findElement(By.xpath("//div[@class='panel-heading itinHeader collapsed']")).click();
              Thread.sleep(1000);
          */
         
               //For Select cruise from result page
          	   try
          	   {
         	       driver.findElement(By.xpath("//*[@id='sr0']/div[2]/div[3]/div[2]/button[2]")).click();
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
                          ImageIO.write(image5, "PNG", new File("D:\\Ajit\\Script_SS\\CruisebookingError\\Cruisenotavailable.png"));
                      
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
                            
                            Thread.sleep(2000);  	  
                            
                            driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
                            driver.findElement(By.xpath("//*[@id='PopUp']/div[2]/div/div[7]/div[3]/button")).click(); //Handle popup on details page
                    	    Thread.sleep(100);
                    	    driver.switchTo().defaultContent();
                            
                            Thread.sleep(3000);
            	   
                          System.out.println("\n");
                          System.out.println("Cruise detailspage Logs..");
                          System.out.println("\n");
                          ExtractJSLogs();              
                          Thread.sleep(1000);
                       
                      final Screenshot screenshot6 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                      final BufferedImage image6 = screenshot6.getImage();
                      ImageIO.write(image6, "PNG", new File("D:\\Ajit\\Script_SS\\Cruisebooking\\Cruisedetailspage.png"));
               
                      System.out.println("Cruise selected successfully..");
                       
                      Thread.sleep(4000);
                

                //For the Cruise details page
                try
                {
                 	
                    driver.findElement(By.id("_ctl0:MainContentsPH:_ctl0:_ctl2_GuestAge_1")).clear();
                    Thread.sleep(100);
                    driver.findElement(By.id("_ctl0:MainContentsPH:_ctl0:_ctl2_GuestAge_1")).click();
                    Thread.sleep(100);
                    driver.findElement(By.id("_ctl0:MainContentsPH:_ctl0:_ctl2_GuestAge_1")).sendKeys("24");
                    Thread.sleep(300);
                    driver.findElement(By.id("_ctl0:MainContentsPH:_ctl0:_ctl2_GuestAge_2")).clear();
                    Thread.sleep(100);
                    driver.findElement(By.id("_ctl0:MainContentsPH:_ctl0:_ctl2_GuestAge_2")).click();
                    Thread.sleep(100);
                    driver.findElement(By.id("_ctl0:MainContentsPH:_ctl0:_ctl2_GuestAge_2")).sendKeys("30");
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
                    
                    Thread.sleep(6000);
                }
                catch(Exception e)
                {
                	System.out.println("\n");
          	        System.out.println("Invalid guest information on cruise detailspage Logs..");
          	        System.out.println("\n");
          	        ExtractJSLogs();
           	 
      	            final Screenshot screenshot8 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
      	            final BufferedImage image8 = screenshot8.getImage();
      	            ImageIO.write(image8, "PNG", new File("D:\\Ajit\\Script_SS\\CruisebookingError\\InvalidGuestinformation.png"));
      	          
           	        Assert.assertFalse(false, "FAIL");
           	        Reporter.log("Invalid guest information on detailspage...");
           	        AssertJUnit.assertTrue("Invalid guest information on detailspage...", crsbkngpge.isDisplayed());
           	        throw(e);
                }
                           
                   //For select category from the category page
                   try
                   {
                	   driver.findElement(By.id("showIn")).click();
                	   Thread.sleep(1000);
                	   driver.findElement(By.id("showOut")).click();
                	   Thread.sleep(3000);
                 	   final Screenshot screenshot9 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                       final BufferedImage image9 = screenshot9.getImage();
                       ImageIO.write(image9, "PNG", new File("D:\\Ajit\\Script_SS\\Cruisebooking\\Categorypage.png"));
                       Thread.sleep(2000);
                       driver.findElement(By.xpath("//a[@class='btn btn-sm btn-default active']")).click();
                	   WebElement viewcat = driver.findElement(By.xpath("//a[@class='btn btn-default btn-block catDescBtn visible-md visible-lg']"));
                	   viewcat.click();
                	   Thread.sleep(2000);
                	   System.out.println("\n");
             	       System.out.println("View category info on categorypage Logs..");
             	       System.out.println("\n");
             	       ExtractJSLogs();
             	       Thread.sleep(2000);
                	   final Screenshot screenshot99 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                       final BufferedImage image99 = screenshot99.getImage();
                       ImageIO.write(image99, "PNG", new File("D:\\Ajit\\Script_SS\\Cruisebooking\\Viewcategoryinfo.png"));
                	   Thread.sleep(4000);
                	   driver.findElement(By.xpath("//a[@class='btn btn-default btn-block catDescBtn visible-md visible-lg']")).click();
                	   Thread.sleep(7000);
                	   
                	     if(driver.findElement(By.id("va_VAO_ctl0_MainContentsPH_Categories_Categories__ctl0__ctl0__ctl0_BestPricesRPT__ctl1_PromotionsUC_VAOffer__ctl0")).isDisplayed())
                	     {
                	    	 
                	    	 WebElement bonusoffr = driver.findElement(By.id("va_VAO_ctl0_MainContentsPH_Categories_Categories__ctl0__ctl0__ctl0_BestPricesRPT__ctl1_PromotionsUC_VAOffer__ctl0"));
                	    	 bonusoffr.click();
                	    	 System.out.println("Bonus offers are available..");
                	    	 Reporter.log("Bonus offers are available..");
                   		     Thread.sleep(1000);
                		     final Screenshot screenshot93 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                             final BufferedImage image93 = screenshot93.getImage();
                             ImageIO.write(image93, "PNG", new File("D:\\Ajit\\Script_SS\\Cruisebooking\\BonusoffersAvailable.png"));
                    	     Thread.sleep(1000);
                    	     driver.findElement(By.xpath("//*[@id='full-terms_48987__ctl0_MainContentsPH_Categories_Categories__ctl0__ctl0__ctl0_BestPricesRPT__ctl1_PromotionsUC_VAOffer__ctl0']/div/div/div[1]/button/span")).click();
                    	     Thread.sleep(1000);
                    	     System.out.println("\n");
                   	         System.out.println("Bonus offers on categorypage Logs..");
                   	         System.out.println("\n");
                   	         ExtractJSLogs();
                   	         Thread.sleep(1000);
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
	                          ImageIO.write(image93, "PNG", new File("D:\\Ajit\\Script_SS\\Cruisebooking\\BonusoffersNotavailable.png"));
	                    	  Thread.sleep(1000);
						 }
                	   driver.findElement(By.xpath("//a[@class='btn btn-default btn-block']")).click();
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
                          ImageIO.write(image10, "PNG", new File("D:\\Ajit\\Script_SS\\CruisebookingError\\Categorynotavailable.png"));
                    
                          Assert.assertFalse(false, "FAIL");
     	                  Reporter.log("Category not available..");
     			          AssertJUnit.assertTrue("Category not available...", crsbkngpge.isDisplayed());
     			          throw(e);
     		         }
                    
                          System.out.println("\n");
                          System.out.println("Cabin selectionpage Logs..");
                          System.out.println("\n");
                          ExtractJSLogs();              
                          Thread.sleep(1000);
                
                          final Screenshot screenshot11 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                          final BufferedImage image11 = screenshot11.getImage();
                          ImageIO.write(image11, "PNG", new File("D:\\Ajit\\Script_SS\\Cruisebooking\\Cabinselectionpage.png"));
        
                        System.out.println("Category selected successfully..");
                
                          Thread.sleep(4000); 
              
                         //For select cabin from the cabin selection page
                         try
                         {
                            driver.findElement(By.xpath("//button[@class='btn btn-default btn-block']")).click();
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
                                  ImageIO.write(image13, "PNG", new File("D:\\Ajit\\Script_SS\\CruisebookingError\\Cabinnotavailable.png"));
                           
                                  Assert.assertFalse(false, "FAIL");
            	                  Reporter.log("Cabin not available..");
            			          AssertJUnit.assertTrue("Cabin not available...", crsbkngpge.isDisplayed());
            			          throw(e);
            		         }
                           
                                 System.out.println("\n");
                                 System.out.println("Customer searchpage Logs..");
                                 System.out.println("\n");
                                 ExtractJSLogs();              
                                 Thread.sleep(1000);
                       
                                 final Screenshot screenshot12 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                                 final BufferedImage image12 = screenshot12.getImage();
                                 ImageIO.write(image12, "PNG", new File("D:\\Ajit\\Script_SS\\Cruisebooking\\Continuewithoutsigningpage.png"));
               
                                System.out.println("Cabin selected successfully..");
                       
                                 Thread.sleep(4000);
                                 
                             //For Continue without signing In
                             try
                             {
                                 driver.findElement(By.xpath("//*[@id='loginForms']/div[2]/a/span[1]")).click();  
                                 Thread.sleep(1000);
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
                                 ImageIO.write(image33, "PNG", new File("D:\\Ajit\\Script_SS\\CruisebookingError\\Continuewithoutsigningnotclickonstatementpage.png"));
                          
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
                                 ImageIO.write(image22, "PNG", new File("D:\\Ajit\\Script_SS\\Cruisebooking\\Purchasepage.png"));
           
                                 System.out.println("Continue without signing in successfully..");
                    
                                 Thread.sleep(4000);
                             
                             //For click on continue to final booking review button
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
                                 ImageIO.write(image34, "PNG", new File("D:\\Ajit\\Script_SS\\CruisebookingError\\InvalidGuestinfoonPurchasepage.png"));
                          
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
                                 ImageIO.write(image44, "PNG", new File("D:\\Ajit\\Script_SS\\Cruisebooking\\Confirmationpage.png"));
                                 
                                 Thread.sleep(1000);
                                  
                                  
           }                      
     }

     @DataProvider
     public String[][] Authentications() throws Exception
     {
     	 
 	     String[][] testObjArray = CruiseUtils.getTableArray("D:\\Ajit\\Automation\\Workspace\\Odysseus_Product\\src\\main\\java\\testData\\CruisebookingData.xlsx","Sheet1");
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
