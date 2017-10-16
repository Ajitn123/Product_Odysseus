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
import Utility.DLCUtils;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.screentaker.ViewportPastingStrategy;


public class DLCPackageOneTest 
{
	   
	        DLCPurchasepgeobjct crspurchpge;
		    DLCBookingpgeobjct crsbkngpge;  // For DLC Package 1
	        public static WebDriver driver;
	        Reporter report = new Reporter();
	        
	        String Log = "D:\\Ajit\\Script_SS\\Differences of Images\\Logs\\DLCPackageOne.txt";

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
	        driver.get("https://book.dlcagencymenu.net/web/cruises/search.aspx?");
	        Thread.sleep(2000);
	       
	  /*     
	        Dimension d = new Dimension(414,736);
	        //Resize current window to the set dimension
	        driver.manage().window().setSize(d);
	  */
	        //Save console
	        String testResultFile="D:\\Ajit\\Script_SS\\ConsoleError\\DLCPackageOneBookingError.txt";
	        File file = new File(testResultFile);  
	        FileOutputStream fis = new FileOutputStream(file);  
	        PrintStream out = new PrintStream(fis);  
	        System.setOut(out); 
	             
	        Thread.sleep(1000);

	        final Screenshot screenshot1 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	        final BufferedImage image1 = screenshot1.getImage();
	        ImageIO.write(image1, "PNG", new File("D:\\Ajit\\Script_SS\\DLCPackageOne\\1_Searchpage.png"));
	        Thread.sleep(1000);
	        
	        String myArg1 = "D:\\Ajit\\Script_SS\\DLCPackageOne\\1_Searchpage.png";
	        String myArg2 = "D:\\Ajit\\Script_SS\\Daily Sanity\\Oct_2017\\11 Oct\\DLC_Package 1\\DLCPackageOne\\1_Searchpage.png";
	        String myCommand = "D:\\Ajit\\Script_SS\\ImageCompConsole.exe";
	        String Output = "D:\\Ajit\\Script_SS\\Differences of Images\\DLCPackageOne\\1_Searchpage.png";
	         
	        ProcessBuilder pb = new ProcessBuilder(myCommand, myArg1, myArg2, Output, Log);
	        pb.directory(new File("D:\\Ajit\\Script_SS"));
	        Process p = pb.start();
	        
	        System.out.println("" +p);
	        
	        System.out.println("\n");
	        System.out.println("Searchpage Logs..");
	        System.out.println("\n");
	        ExtractJSLogs();
	       
	        Thread.sleep(4000); 
	      
	          crsbkngpge = PageFactory.initElements(driver, DLCBookingpgeobjct.class);    // For DLC Package One
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
	   public void DLC_data(String Firstname_GuestOne, String Middlename_GuestOne, String Lastname_GuestOne, String Email, String Street_Address, String City, String Zipcode, String Phone, String Firstname_GuestTwo, String Middlename_GuestTwo, String Lastname_GuestTwo) throws Exception
	   {
		
	   	   try
	       {
	  		     //For web site and booking details
	             Reporter.log("Website Name :- DLC");
	             Thread.sleep(200);
	  		 
	  		     Reporter.log("Cruise line :- Disney");
	  		     Thread.sleep(1500);
	  		 
	      	     crsbkngpge.BookingToTittle();          // For DLC Package One
	      	  
	      	     long start = System.currentTimeMillis();
	      	     
	      	     Thread.sleep(3982);
	      	     long finish = System.currentTimeMillis();
	             long totalTime = finish - start; 
	        //   int seconds = (int) (totalTime / 1000) % 60 ;
	             Reporter.log("Total Time for serch page to result page load(Milisec) - "+totalTime); 
	             Thread.sleep(1000);
	      	     System.out.println("\n");
	 	         System.out.println("Resultpage Logs..");
	 	         System.out.println("\n");
	 	         ExtractJSLogs();
	 	        
	             Thread.sleep(1000);
	              
	 	          final Screenshot screenshot4 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	              final BufferedImage image4 = screenshot4.getImage();
	              ImageIO.write(image4, "PNG", new File("D:\\Ajit\\Script_SS\\DLCPackageOne\\2_Resultpage.png"));
	              Thread.sleep(2000);
	              
	              String myArg1 = "D:\\Ajit\\Script_SS\\DLCPackageOne\\2_Resultpage.png";
	              String myArg2 = "D:\\Ajit\\Script_SS\\Daily Sanity\\Oct_2017\\11 Oct\\DLC_Package 1\\DLCPackageOne\\2_Resultpage.png";
	              String myCommand = "D:\\Ajit\\Script_SS\\ImageCompConsole.exe";
	              String Output = "D:\\Ajit\\Script_SS\\Differences of Images\\DLCPackageOne\\2_Resultpage.png";
	              
	              
	              ProcessBuilder pb = new ProcessBuilder(myCommand, myArg1, myArg2, Output, Log);
	              pb.directory(new File("D:\\Ajit\\Script_SS"));
	              Process p = pb.start();
	              
	              System.out.println("" +p);
	          
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
		         ImageIO.write(image33, "PNG", new File("D:\\Ajit\\Script_SS\\DLCPackageOneError\\1_TimeoutORinvalidsearchdetails.png"));
		          
	  	         Assert.assertFalse(false, "FAIL");
	  	         Reporter.log("Time out or Invalid search criteria on resultpage..");
	  	         AssertJUnit.assertTrue("Time out or Invalid search criteria on resultpage...", crsbkngpge.isDisplayed());
	  	         throw(e);
	       }
	   	
	   	   //For Select cruise from result page
	       try
	       {
	                     driver.navigate().refresh();
	                     
	                     driver.get("https://book.dlcagencymenu.net/web/cruises/results.aspx?showtrace=true");
	                      
	                     Thread.sleep(3000);  
	          /*                  
	                     // For the bonus offers
	                     if(driver.findElement(By.cssSelector("#PriceList_1 > div > ul:nth-child(1) > li.grid-bonus.res_grid_bonus > a > img")).isDisplayed())
	                     {
	                     	  Reporter.log("Bonus Offers are available..");
	                     	  driver.findElement(By.cssSelector("#PriceList_1 > div > ul:nth-child(1) > li.grid-bonus.res_grid_bonus > a > img")).click();
	                          Thread.sleep(1500);
	                         
	                          File scr22 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	           	              org.codehaus.plexus.util.FileUtils.copyFile(scr22, new File("D:\\Ajit\\Script_SS\\DLCPackageOne\\3_Bonusoffers.png")); 
	                         
	                          Thread.sleep(3000);
	                         
	                     	  driver.navigate().refresh();
	                     	  Thread.sleep(3000);
	                     }
	            */         
	                          driver.findElement(By.cssSelector("[id*='PriceList_'] > div > ul > li.grid-btn.btn-container [class*='booknow res_Cruise_detai_mo primary-btn']")).click();  // For package 1 & 2
	                 
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
	                ImageIO.write(image5, "PNG", new File("D:\\Ajit\\Script_SS\\DLCPackageOneError\\2_Cruisenotavailable.png"));
	         
	                Assert.assertFalse(false, "FAIL");
	                Reporter.log("Cruise not available..");
			        AssertJUnit.assertTrue("Cruise not available...", crsbkngpge.isDisplayed());
			        throw(e);
		       }
	               long start = System.currentTimeMillis();  
	               Thread.sleep(2200); 
	               
	               long finish = System.currentTimeMillis();
	               long totalTime = finish - start; 
	               Reporter.log("Total Time for result page to details page load(Milisec) - "+totalTime); 
	               Thread.sleep(1000);
	      
	               System.out.println("\n");
	               System.out.println("Cruise detailspage Logs..");
	               System.out.println("\n");
	               ExtractJSLogs();              
	               Thread.sleep(1000);
	              
	               final Screenshot screenshot60 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	               final BufferedImage image60 = screenshot60.getImage();
	               ImageIO.write(image60, "PNG", new File("D:\\Ajit\\Script_SS\\DLCPackageOne\\4_Cruisedetailspage.png"));
	               Thread.sleep(2000);
	               
	               String myArg1 = "D:\\Ajit\\Script_SS\\DLCPackageOne\\4_Cruisedetailspage.png";
	               String myArg2 = "D:\\Ajit\\Script_SS\\Daily Sanity\\Oct_2017\\11 Oct\\DLC_Package 1\\DLCPackageOne\\4_Cruisedetailspage.png";
	               String myCommand = "D:\\Ajit\\Script_SS\\ImageCompConsole.exe";
	               String Output = "D:\\Ajit\\Script_SS\\Differences of Images\\DLCPackageOne\\3_Cruisedetailspage.png";
	               
	               ProcessBuilder pb = new ProcessBuilder(myCommand, myArg1, myArg2, Output, Log);
	               pb.directory(new File("D:\\Ajit\\Script_SS"));
	               Process p = pb.start();
	               
	               System.out.println("" +p);

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
	                   Thread.sleep(500);
	                   driver.findElement(By.id("_ctl0:MainContentsPH:_ctl0:_ctl0_GuestAge_2")).sendKeys("30");
	                   Thread.sleep(700);
	                   driver.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0__ctl0_ResidentState']")).click();
	                   Thread.sleep(800);
	                   driver.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0__ctl0_ResidentState']/option[3]")).click();
	                   Thread.sleep(900);
	                   driver.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0__ctl0_CategoryLNK']")).sendKeys(Keys.ENTER);
	                   Thread.sleep(500);
	                   
	                   
	        }
	        catch(Exception e)
	        {
	                  	System.out.println("\n");
	         	        System.out.println("Invalid guest information on cruise detailspage Logs..");
	         	        System.out.println("\n");
	         	        ExtractJSLogs();
	          	 
	     	            final Screenshot screenshot80 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	     	            final BufferedImage image80 = screenshot80.getImage();
	     	            ImageIO.write(image80, "PNG", new File("D:\\Ajit\\Script_SS\\DLCPackageOneError\\3_InvalidGuestinformation.png"));
	     	          
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
	                   
	                   Thread.sleep(9890);
	                   
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
	               ImageIO.write(image82, "PNG", new File("D:\\Ajit\\Script_SS\\DLCPackageOneError\\07_Error.png"));
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
	                     ImageIO.write(image61, "PNG", new File("D:\\Ajit\\Script_SS\\DLCPackageOne\\5_Categorypage.png"));
	                     Thread.sleep(3000);
	                     
	                     String myArg3 = "D:\\Ajit\\Script_SS\\DLCPackageOne\\5_Categorypage.png";
	                     String myArg4 = "D:\\Ajit\\Script_SS\\Daily Sanity\\Oct_2017\\11 Oct\\DLC_Package 1\\DLCPackageOne\\5_Categorypage.png";
	                     String myCommand1 = "D:\\Ajit\\Script_SS\\ImageCompConsole.exe";
	                     String Output1 = "D:\\Ajit\\Script_SS\\Differences of Images\\DLCPackageOne\\4_Categorypage.png";
	                     
	                     ProcessBuilder pb1 = new ProcessBuilder(myCommand1, myArg3, myArg4, Output1, Log);
	                     pb1.directory(new File("D:\\Ajit\\Script_SS"));
	                     Process p1 = pb1.start();
	                     
	                     System.out.println("" +p1);
	                     
	                     Thread.sleep(3000);
	   /*             
	                  try
	                  {
	                	if(driver.findElement(By.xpath("//*[contains(text(), 'Processing finished')]")).isDisplayed())
	                	{
	                		   
	                		   String expr1 = driver.findElement(By.id("TracerBlock")).getText();
	                		   expr1.toLowerCase().trim().equals("processing finished");
	                      //     String proccessingloops = expr1.split("WEB-93")[95].split(":")[2].trim();
	                           
	                             String proccessingloop = expr1.split(":")[3].trim();
	                                                          
	                      //     String a ;
	                      //       expr1.split(":")[1].trim();
	                             
	                             Reporter.log("Category processing loop :- " +proccessingloop);
	                             Thread.sleep(500);
	                	}
	                	
	                     for (String str : proccessingloop) 
	                     {
	                         if (str.split(":")[2].trim() != null)
	                         {
	                             a = str;
	                             
	                             a.split(":")[2].trim();
	                             
	                             Reporter.log("Category processing loop :- " +str);
	                             Thread.sleep(500);
	                         }
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
	                        String totalprocesstime = expr1.split("WEB-93")[2987].split(":")[2].trim();
	                        Reporter.log("TotalProcessing Time on category page:- " +totalprocesstime);
	                        Thread.sleep(3000);
	                	} 
	                  }
	                  catch(Exception e)
	                  {
	                	  e.getMessage();
	                  } 
	        */     
	                     
	                   //For Package One : xpath("//*[@id='BX']/div/div[4]/ul[2]/li[5]/a")	
	                	 WebElement element = driver.findElement(By.cssSelector("#category_3 > div:nth-child(1) > div.categoryview-price-gride > ul.categoryview-price-gride-even > li:nth-child(5) [class*='booknow']"));
	               	     JavascriptExecutor executor = (JavascriptExecutor) driver;
	                     executor.executeScript("arguments[0].click();", element);
	                	 Thread.sleep(4000); 
	                  	 
	                	try
	                	{
	                    	 if(driver.findElement(By.xpath("//*[@id='Fare_0f2ICpRFCdUZMVdNFHpHvLbp6cY=_PopUP']/div[3]/div/a[2]")).isDisplayed())
	                    	 {
	                    		 
	                    		 WebElement elll = driver.findElement(By.xpath("//*[@id='Fare_0f2ICpRFCdUZMVdNFHpHvLbp6cY=_PopUP']/div[3]/div/a[2]"));
	                    		 elll.click();
	                    		 Thread.sleep(1000);
	                     		
	                    	 }
	                	}
	                	catch(Exception e)
	                	{
	                		e.getMessage();
	                	}
	                	
	                	try
	                	{
	                    	 if(driver.findElement(By.xpath("//*[@id='Fare_W6ZENoTasWeQEfIuAuhK9PbwiUo=_PopUP']/div[3]/div/a[2]")).isDisplayed())
	                    	 {
	                    		 
	                    		 WebElement ell2 = driver.findElement(By.xpath("//*[@id='Fare_W6ZENoTasWeQEfIuAuhK9PbwiUo=_PopUP']/div[3]/div/a[2]"));
	                    		 ell2.click();
	                    		 Thread.sleep(1000);
	                     		
	                    	 }
	                	}
	                	catch(Exception e)
	                	{
	                		e.getMessage();
	                	}
	                  	 
	                 }
	                 //For verify Suite category on category page
	                 else if (driver.findElement(By.cssSelector("#MainForm > div > div.category-tab-content-box > div > ul > li:nth-child(4) > a > div > span:nth-child(2)")).isDisplayed())
	                 {
	                 	 driver.findElement(By.cssSelector("#MainForm > div > div.category-tab-content-box > div > ul > li:nth-child(4) > a > div > span:nth-child(2)")).click();
	                	 Thread.sleep(1000);
	                	 
	                	 final Screenshot screenshot62 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	                     final BufferedImage image62 = screenshot62.getImage();
	                     ImageIO.write(image62, "PNG", new File("D:\\Ajit\\Script_SS\\DLCPackageOne\\6_Categorypage.png"));
	                     Thread.sleep(2000);
	                     
	                     String myArg3 = "D:\\Ajit\\Script_SS\\DLCPackageOne\\6_Categorypage.png";
	                     String myArg4 = "D:\\Ajit\\Script_SS\\Daily Sanity\\Oct_2017\\11 Oct\\DLC_Package 1\\DLCPackageOne\\6_Categorypage.png";
	                     String myCommand1 = "D:\\Ajit\\Script_SS\\ImageCompConsole.exe";
	                     String Output1 = "D:\\Ajit\\Script_SS\\Differences of Images\\DLCPackageOne\\4_Categorypage.png";
	                     
	                     ProcessBuilder pb1 = new ProcessBuilder(myCommand1, myArg3, myArg4, Output1, Log);
	                     pb1.directory(new File("D:\\Ajit\\Script_SS"));
	                     Process p1 = pb1.start();
	                     
	                     System.out.println("" +p1);
	                     
	                     String expr1 = driver.findElement(By.id("TracerBlock")).getText();
	                     String proccessingloops = expr1.split("WEB-93")[58].split(":")[1].trim();
	                     Reporter.log("Category processing loop :- " +proccessingloops);
	                     Thread.sleep(500);
	                     String totalprocesstime = expr1.split("WEB-93")[69].split(":")[1].trim();
	                     Reporter.log("TotalProcessing Time on category page:- " +totalprocesstime);
	                     Thread.sleep(3000);
	                     
	                	 driver.findElement(By.cssSelector("#category_4 > div.categoryview-container > div.categoryview-price-gride > ul.categoryview-price-gride-even > li:nth-child(5) > a")).click();
	                	 Thread.sleep(4000);
					 }
	                 
	                 try
	            	 {
	            		 if(driver.findElement(By.cssSelector("#Fare_W6ZENoTasWeQEfIuAuhK9PbwiUo\3d _PopUP > div.popup-ratecode-footer > div > a:nth-child(2)")).isDisplayed())
	            		 {
	            			 driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
	            			 WebElement elmt = driver.findElement(By.cssSelector("#Fare_W6ZENoTasWeQEfIuAuhK9PbwiUo\3d _PopUP > div.popup-ratecode-footer > div > a:nth-child(2)"));
	            		     elmt.click();
	            		     Thread.sleep(5000);
	            		     driver.switchTo().defaultContent();
	            		 }
	            	 }
	            	 catch(Exception e)
	            	 {
	            		 e.getMessage();
	            	 }
	                 
	                 long start2 = System.currentTimeMillis();
	                 System.out.println("\n");
	                 System.out.println("Cabin selection page Logs..");
	                 System.out.println("\n");
	                 ExtractJSLogs();              
	                 Thread.sleep(1100);
	                 long finish11 = System.currentTimeMillis();
	                 long totalTime11 = finish11 - start2; 
	                 Reporter.log("Total Time for category page to cabin selection page load(Milisec) - "+totalTime11); 
	                 Thread.sleep(1000);
	     
	                 final Screenshot screenshot62 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	                 final BufferedImage image62 = screenshot62.getImage();
	                 ImageIO.write(image62, "PNG", new File("D:\\Ajit\\Script_SS\\DLCPackageOne\\7_Cabinselectionpage.png"));
	                 Thread.sleep(1000);
	                 
	                 String myArg3 = "D:\\Ajit\\Script_SS\\DLCPackageOne\\7_Cabinselectionpage.png";
	                 String myArg4 = "D:\\Ajit\\Script_SS\\Daily Sanity\\Oct_2017\\11 Oct\\DLC_Package 1\\DLCPackageOne\\7_Cabinselectionpage.png";
	                 String myCommand1 = "D:\\Ajit\\Script_SS\\ImageCompConsole.exe";
	                 String Output1 = "D:\\Ajit\\Script_SS\\Differences of Images\\DLCPackageOne\\5_Cabinselectionpage.png";
	                 
	                 ProcessBuilder pb1 = new ProcessBuilder(myCommand1, myArg3, myArg4, Output1, Log);
	                 pb1.directory(new File("D:\\Ajit\\Script_SS"));
	                 Process p1 = pb1.start();
	                 
	                 System.out.println("" +p1);

	                 System.out.println("Category selected successfully..");
	                  
	                 Thread.sleep(5000);
	                 
	                 //For the Cruise details print on test report
	                 String departport = driver.findElement(By.cssSelector("#_ctl0_PageHeadTD > div.content-area > div.content-left > div.cruise-details-outer.res_cruise_details > div.search-box > div:nth-child(3) > ul > li:nth-child(3)")).getText();
	                 Reporter.log(" " +departport);
	                 Thread.sleep(500);
	                 String guest = driver.findElement(By.cssSelector("#_ctl0_PageHeadTD > div.content-area > div.content-left > div.cruise-details-outer.res_cruise_details > div.search-box > div:nth-child(3) > ul > li:nth-child(6)")).getText();
	                 Reporter.log(" " +guest);
	                 Thread.sleep(800);
	                 String shp = driver.findElement(By.cssSelector("#_ctl0_PageHeadTD > div.content-area > div.content-left > div.cruise-details-outer.res_cruise_details > div.search-box > div:nth-child(3) > ul > li:nth-child(1)")).getText();
	                 Reporter.log(" " +shp);
	                 Thread.sleep(500);
	                 String dstntn = driver.findElement(By.cssSelector("#_ctl0_PageHeadTD > div.content-area > div.content-left > div.cruise-details-outer.res_cruise_details > div.search-box > div:nth-child(3) > ul > li:nth-child(2)")).getText();
	                 Reporter.log(" " +dstntn);
	                 Thread.sleep(400);
	                 String depart = driver.findElement(By.cssSelector("#_ctl0_PageHeadTD > div.content-area > div.content-left > div.cruise-details-outer.res_cruise_details > div.search-box > div:nth-child(3) > ul > li:nth-child(4)")).getText();
	                 Reporter.log(" " + depart);
	                 Thread.sleep(400);
	                 String arrival = driver.findElement(By.cssSelector("#_ctl0_PageHeadTD > div.content-area > div.content-left > div.cruise-details-outer.res_cruise_details > div.search-box > div:nth-child(3) > ul > li:nth-child(5)")).getText();
	                 Reporter.log(" " + arrival);
	                 Thread.sleep(400);
	                 String ctgory = driver.findElement(By.cssSelector("#_ctl0_PageHeadTD > div.content-area > div.content-left > div.cruise-details-outer.res_cruise_details > div.search-box > div:nth-child(3) > ul > li:nth-child(7)")).getText();
	                 Reporter.log(" " + ctgory);
	                 Thread.sleep(400);
	      
	                //For verify price's on cabin page
	                 String priceoncabin= driver.findElement(By.cssSelector("#MainForm > div > div.guest-top-right > div > span.item-list-price > em")).getText();
	                 System.out.println("Prices on cabin page is:- " +priceoncabin);
	                 Reporter.log("Prices on cabin page is:- " +priceoncabin);
	                 Thread.sleep(2000);
	                 String taxoncabin= driver.findElement(By.cssSelector("#MainForm > div > div.guest-top-right > div > span.cat-taxamt")).getText();
	                 System.out.println(" " +taxoncabin);
	                 Reporter.log(" " +taxoncabin);
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
	        	            driver.findElement(By.cssSelector("#Stateroom-price > div > ul.stateroom-price-odd > li:nth-child(3) [id*='CabinBook_']")).sendKeys(Keys.ENTER);
	                        Thread.sleep(1000);
	                 //       Alert alert = driver.switchTo().alert();
	                 //       alert.accept();	
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
	                              ImageIO.write(image13, "PNG", new File("D:\\Ajit\\Script_SS\\DLCPackageOneError\\4_Cabinnotavailable.png"));
	                       
	                              Assert.assertFalse(false, "FAIL");
	        	                  Reporter.log("Cabin not available..");
	        			          AssertJUnit.assertTrue("Cabin not available...", crsbkngpge.isDisplayed());
	        			          throw(e);
	          }
	                             long start3 = System.currentTimeMillis();
	                             System.out.println("\n");
	                             System.out.println("Purchase page Logs..");
	                             System.out.println("\n");
	                             ExtractJSLogs();              
	                             Thread.sleep(1000);
	                             
	                             long finish111 = System.currentTimeMillis();
	                             long totalTime111 = finish111 - start3; 
	                             Reporter.log("Total Time for cabin selection page to purchase page load(Milisec) - "+totalTime111); 
	                             Thread.sleep(1000);
	                   
	                             final Screenshot screenshot102 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	                             final BufferedImage image102 = screenshot102.getImage();
	                             ImageIO.write(image102, "PNG", new File("D:\\Ajit\\Script_SS\\DLCPackageOne\\8_Purchasepage.png"));
	                             Thread.sleep(2000);
	                             
	                             String myArg5 = "D:\\Ajit\\Script_SS\\DLCPackageOne\\8_Purchasepage.png";
	                             String myArg6 = "D:\\Ajit\\Script_SS\\Daily Sanity\\Oct_2017\\11 Oct\\DLC_Package 1\\DLCPackageOne\\8_Purchasepage.png";
	                             String myCommand2 = "D:\\Ajit\\Script_SS\\ImageCompConsole.exe";
	                             String Output2 = "D:\\Ajit\\Script_SS\\Differences of Images\\DLCPackageOne\\6_Purchasepage.png";
	                             
	                             ProcessBuilder pb2 = new ProcessBuilder(myCommand2, myArg5, myArg6, Output2, Log);
	                             pb2.directory(new File("D:\\Ajit\\Script_SS"));
	                             Process p2 = pb2.start();
	                             
	                             System.out.println("" +p2);
	           
	                             System.out.println("Cabin selected successfully..");
	                   
	                             Thread.sleep(4000);
	                             
	                             //Check price on purchase page
	                             String priceonpurchase= driver.findElement(By.xpath("//*[@id='PricesGTotal']")).getText();
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
	                                    System.out.println("Email: " + Street_Address);
	                                    System.out.println("Email: " + City);
	                                    System.out.println("Email: " + Zipcode);
	                                    System.out.println("Phone: " + Phone);
	                                    System.out.println("FirstName_Of_Guest2: " + Firstname_GuestTwo);
	                                    System.out.println("MiddleName_Of_Guest2: " + Middlename_GuestTwo);
	                                    System.out.println("Lastname_of_Guest2: " + Lastname_GuestTwo);
	                                               	                                	 
	                                    crspurchpge.DLCPurchaseToTittle(Firstname_GuestOne, Middlename_GuestOne, Lastname_GuestOne, Email, Street_Address, City, Zipcode, Phone, Firstname_GuestTwo, Middlename_GuestTwo, Lastname_GuestTwo);
	                                    
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
	                                    ImageIO.write(image34, "PNG", new File("D:\\Ajit\\Script_SS\\DLCPackageOneError\\5_InvalidGuestinfoonPurchasepage.png"));
	                                             
	                                    Assert.assertFalse(false, "FAIL");
	                              	    Reporter.log("Invalid guest information on purchase page, Please enter valid details for the required fields...");
	                              		AssertJUnit.assertTrue("Invalid guest information on purchase page, Please enter valid details for the required fields....", crspurchpge.isDisplayed());
	                              		throw(e);
	             }
	                                    long start6 = System.currentTimeMillis();
	                                    Thread.sleep(2000);           
	                                    System.out.println("\n");
	                                    System.out.println("Confirmationpage Logs..");
	                                    System.out.println("\n");
	                                    ExtractJSLogs();              
	                                    Thread.sleep(1000);
	                                    
	                                    long finish1111 = System.currentTimeMillis();
	                                    long totalTime1111 = finish1111 - start6; 
	                                    Reporter.log("Total Time for purchase page to confirmation page load(Milisec) - "+totalTime1111); 
	                                    Thread.sleep(1000);
	                                                    
	                                    final Screenshot screenshot44 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	                                    final BufferedImage image44 = screenshot44.getImage();
	                                    ImageIO.write(image44, "PNG", new File("D:\\Ajit\\Script_SS\\DLCPackageOne\\9_Confirmationpage.png"));
	                                    Thread.sleep(2000);
	                                    
	                                    String myArg7 = "D:\\Ajit\\Script_SS\\DLCPackageOne\\9_Confirmationpage.png";
	                                    String myArg8 = "D:\\Ajit\\Script_SS\\Daily Sanity\\Oct_2017\\11 Oct\\DLC_Package 1\\DLCPackageOne\\9_Confirmationpage.png";
	                                    String myCommand3 = "D:\\Ajit\\Script_SS\\ImageCompConsole.exe";
	                                    String Output3 = "D:\\Ajit\\Script_SS\\Differences of Images\\DLCPackageOne\\7_Confirmationpage.png";
	                                    
	                                    ProcessBuilder pb3 = new ProcessBuilder(myCommand3, myArg7, myArg8, Output3, Log);
	                                    pb3.directory(new File("D:\\Ajit\\Script_SS"));
	                                    Process p3 = pb3.start();
	                                    
	                                    System.out.println("" +p3);
	                                                    
	                                    Thread.sleep(2000);
	                                    
	             try
	             {
	                                    
	                                    //For Verify price on confirmation page
	                                    String priceoncon = driver.findElement(By.xpath("//*[@id='PricesGTotal']")).getText();
	                                    Reporter.log("Price on confirmationpage is:- "+ priceoncon);
	                                    Thread.sleep(1000);
	                                    
	                                    // For click on Full payment button
	                                    driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_ContinueBTN")).sendKeys(Keys.ENTER);
	                                    
	                                    Thread.sleep(4000);
	                                    
	                                    System.out.println("\n");
	                                    System.out.println("Paymentpage Logs..");
	                                    System.out.println("\n");
	                                    ExtractJSLogs();              
	                                    Thread.sleep(1000);
	                                    
	                                    final Screenshot screenshot74 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	                                    final BufferedImage image74 = screenshot74.getImage();
	                                    ImageIO.write(image74, "PNG", new File("D:\\Ajit\\Script_SS\\DLCPackageOne\\9_Paymentpage.png"));
	                                    Thread.sleep(1000);
	                                    
	                                    String myArg9 = "D:\\Ajit\\Script_SS\\DLCPackageOne\\9_Paymentpage.png";
	                                    String myArg10 = "D:\\Ajit\\Script_SS\\Daily Sanity\\Oct_2017\\11 Oct\\DLC_Package 1\\DLCPackageOne\\9_Paymentpage.png";
	                                    String myCommand4 = "D:\\Ajit\\Script_SS\\ImageCompConsole.exe";
	                                    String Output4 = "D:\\Ajit\\Script_SS\\Differences of Images\\DLCPackageOne\\8_Paymentpage.png";
	                                    
	                                    ProcessBuilder pb4 = new ProcessBuilder(myCommand4, myArg9, myArg10, Output4, Log);
	                                    pb4.directory(new File("D:\\Ajit\\Script_SS"));
	                                    Process p4 = pb4.start();
	                                    
	                                    System.out.println("" +p4);
	                                                    
	                                    String priceonpaymnt = driver.findElement(By.xpath("//*[@id='PaymentAmountToPay']")).getText();
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
	              }     							 
	              catch (Exception e) 
	              {
	            	  final Screenshot screenshot94 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	                  final BufferedImage image94 = screenshot94.getImage();
	                  ImageIO.write(image94, "PNG", new File("D:\\Ajit\\Script_SS\\DLCPackageOneError\\10_Paymentpage.png"));
	                  
	                  Assert.assertFalse(false, "FAIL");
	            	  Reporter.log("Something went wrong...");
	            	  AssertJUnit.assertTrue("Something went wrong...", crspurchpge.isDisplayed());
	            	  throw(e);
				  }        
	             
	           //For the compare logs
				 String ConsleArgument = "D:\\Ajit\\Script_SS\\ConsoleError\\DLCPackageOneBookingError.txt";
	             String ConsoleCommand = "D:\\Ajit\\Script_SS\\ConsoleApplication2.exe";
	             String ConsoleOutput = "D:\\Ajit\\Script_SS\\DLCPackageOneError\\UncaughtDLC.txt";
	             
	             ProcessBuilder pb05 = new ProcessBuilder(ConsoleCommand, ConsleArgument, ConsoleOutput);
	             pb05.directory(new File("D:\\Ajit\\Script_SS"));
	             Process p05 = pb05.start();
	             
	             System.out.println("" +p05);    
	               
	             Thread.sleep(1000);

	   }


	   @DataProvider
	   public String[][] Authentications() throws Exception
	   {
	   	 
		     String[][] testObjArray = DLCUtils.getTableArray("D:\\Ajit\\Automation\\Workspace\\Odysseus_Product\\src\\main\\java\\testData\\DLCData.xlsx","Sheet1");
		     return testObjArray;
		     
	   }
	   
	   @AfterClass
	   public void closeBrowser() throws InterruptedException
	   {
		 
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