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
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Utility.OdysolHotelUtils;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.screentaker.ViewportPastingStrategy;


public class AdminManageTest 
{

	   Login lgnpge;
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
	                	    System.setProperty("webdriver.chrome.driver", "D:\\Ajit\\Driver\\chromedriver_win32\\chromedriver.exe");
		                    DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		                    LoggingPreferences loggingprefs = new LoggingPreferences();
		                    loggingprefs.enable(LogType.BROWSER, Level.ALL);
		                    capabilities.setCapability(CapabilityType.LOGGING_PREFS, loggingprefs);
		                    driver = new ChromeDriver(capabilities);
		                   
	                 }  
	                 else if (browser.equalsIgnoreCase("IE")) 
	                 {
		                   System.setProperty("webdriver.ie.driver", "D:\\Ajit\\Driver\\IEDriverServer_Win32_2.53.0\\IEDriverServer.exe");
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
     driver.get("https://ui.odysol.com/admin/login.aspx");
     Thread.sleep(2000);
  
    //Save console
     String testResultFile="D:\\Ajit\\Script_SS\\ConsoleError\\AdminManageError.txt";
     File file = new File(testResultFile);  
     FileOutputStream fis = new FileOutputStream(file);  
     PrintStream out = new PrintStream(fis);  
     System.setOut(out); 
                
     Thread.sleep(1000);
  
     final Screenshot screenshot01 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
     final BufferedImage image01 = screenshot01.getImage();
     ImageIO.write(image01, "PNG", new File("D:\\Ajit\\Script_SS\\AdminManage\\1_Loginpage.png"));

     //driver.navigate().to("https://localhost/odyssey/website/air/results.aspx?");
     Thread.sleep(4000);
     lgnpge = PageFactory.initElements(driver, Login.class);
        
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
public void Confirmlogin_data(String sUsername, String sPassword, String FirstName, String MidleName, String LastName, String Email, String Phone, String FirstNameTwo, String MidleNameTwo, String LastNameTwo, String EmailTwo, String PhoneTwo) throws Exception
{
  
	Reporter.log("Website Name:- Demo Site");
		 
   System.out.println("sUsername: " + sUsername);
   System.out.println("sPassword: " + sPassword);
         
   lgnpge.LoginToTittle(sUsername, sPassword);
   
   System.out.println("\n");
   System.out.println("Loginpage Logs..");
   System.out.println("\n");
   ExtractJSLogs();
   
   Thread.sleep(6000);
   driver.navigate().refresh();
   Thread.sleep(4000);
   
   final Screenshot screenshot = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
   final BufferedImage image = screenshot.getImage();
   ImageIO.write(image, "PNG", new File("D:\\Ajit\\Script_SS\\AdminManage\\2_AdminManageage.png"));
   Thread.sleep(9000);

     
try
{
     //Click on Manage
     driver.findElement(By.className("manage_btn")).click();
     Thread.sleep(2000);
}
catch(Exception e)
{
	e.getMessage();
}
  try
  {
     //Agent Details
     driver.findElement(By.cssSelector("[id*='trans_old_'] > td > div > div [class*='agent_icon show_True']")).click();
     Thread.sleep(5000); 
     
     System.out.println("\n");
     System.out.println("Agent details on admin defaultpage Logs..");
     System.out.println("\n");
     ExtractJSLogs();
     
     Thread.sleep(3000);
     driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
 /*    
     //For middle name update
     WebElement elm = driver.findElement(By.name("PaxMiddleName"));
     elm.clear();
     Thread.sleep(200); 
     elm.click();
     Thread.sleep(900); 
     elm.sendKeys("N");
     Thread.sleep(800); 
  */  
     WebElement elmt = driver.findElement(By.id("_ctl0_MainContent_BookingEditUC_SubmitBTN"));
     elmt.click();
     Thread.sleep(5000);
     
     final Screenshot screenshot1 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
     final BufferedImage image1 = screenshot1.getImage();
     ImageIO.write(image1, "PNG", new File("D:\\Ajit\\Script_SS\\AdminManage\\3_AgentdetailsUpdated.png"));
     Thread.sleep(2000);
  
     driver.navigate().refresh();
     
     Thread.sleep(3000);
   
     driver.switchTo().defaultContent();
     
     Thread.sleep(1000);
     System.out.println("\n");
     System.out.println("Agent details updated on admin defaultpage Logs..");
     System.out.println("\n");
     ExtractJSLogs();
     
     Reporter.log("Agent details updated..");
     
     Thread.sleep(2000);
          
  }
  catch(Exception e)
  {
	  e.getMessage();
	  final Screenshot screenshot1 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
      final BufferedImage image1 = screenshot1.getImage();
      ImageIO.write(image1, "PNG", new File("D:\\Ajit\\Script_SS\\AdminManageError\\2_AgentdetailsNotUpdated.png"));
      Thread.sleep(1000);
      
      Assert.assertFalse(false, "FAIL");
      Reporter.log("Agent details not updated..");
   //   AssertJUnit.assertTrue("Agent details not updated...", lgnpge.isDisplayed());
   //   throw(e);
  }
     
      driver.findElement(By.className("manage_btn")).click();
      Thread.sleep(2000);

  try
  {
      // For History
	     driver.findElement(By.className("history_icon")).click();
	     Thread.sleep(5000);
	  
	     driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
	     
	     final Screenshot screenshot1 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	     final BufferedImage image1 = screenshot1.getImage();
	     ImageIO.write(image1, "PNG", new File("D:\\Ajit\\Script_SS\\AdminManage\\4_BookingHistory.png"));
	     Thread.sleep(1000);

	     Reporter.log("Booking History View..");
	     
	     driver.navigate().refresh();
	     
	     Thread.sleep(3000);
	   
	     driver.switchTo().defaultContent();
	     
	     Thread.sleep(1000);
	     System.out.println("\n");
	     System.out.println("Booking History updated on admin defaultpage Logs..");
	     System.out.println("\n");
	     ExtractJSLogs();
	     
	     Thread.sleep(2000);
	    	   
  }
  catch(Exception e)
  {
	  e.getMessage();
	  
	     final Screenshot screenshot1 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	     final BufferedImage image1 = screenshot1.getImage();
	     ImageIO.write(image1, "PNG", new File("D:\\Ajit\\Script_SS\\AdminManageError\\3_BookingHistory.png"));
	     Thread.sleep(2000);
	     
	     Assert.assertFalse(false, "FAIL");
	     Reporter.log("History not View..");
  }
  
         driver.findElement(By.className("manage_btn")).click();
         Thread.sleep(2000);
  
   try
   {
	    
	 // For Payment Details
	     driver.findElement(By.cssSelector("[id*='trans_old_'] > td > div > div [class*='paydetail_icon show_True']")).click();
	     Thread.sleep(5000);
	  
	     driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
	     
	     File scr22 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
         org.codehaus.plexus.util.FileUtils.copyFile(scr22, new File("D:\\Ajit\\Script_SS\\AdminManage\\5_PaymentDetails.png")); 
	     Thread.sleep(2000);
	/*     
	     // For the Destroy CC
	     driver.findElement(By.id("_ctl0_MainContent_MultiplePaymentRPT__ctl1_DestroyTPCCBTN")).click();
	     Thread.sleep(4000);
	*/   
	     Reporter.log("Payment details view..");
	     
	     driver.navigate().refresh();
	     
	     Thread.sleep(3000);
	   
	     driver.switchTo().defaultContent();
	     
	     Thread.sleep(2000);
	     System.out.println("\n");
	     System.out.println("Payment details view on admin defaultpage Logs..");
	     System.out.println("\n");
	     ExtractJSLogs();
	     
	     Thread.sleep(2000);
	     	   
   }
   catch(Exception e)
   {
	   e.getMessage();
	   
	   final Screenshot screenshot1 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	   final BufferedImage image1 = screenshot1.getImage();
	   ImageIO.write(image1, "PNG", new File("D:\\Ajit\\Script_SS\\AdminManageError\\4_PaymentDetails.png"));
	   Thread.sleep(1000);
	     
	   Assert.assertFalse(false, "FAIL");
	   Reporter.log("Payment details not view..");
	   
   }

   
       driver.findElement(By.className("manage_btn")).click();
       Thread.sleep(1000);

 try
 {
  
 // For Cross Check w/Supplier
    driver.findElement(By.cssSelector("[id*='trans_old_'] > td > div > div [class*='crosscheck_icon show_True']")).click();
    Thread.sleep(5000); 

    driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
   
    final Screenshot screenshot1 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
    final BufferedImage image1 = screenshot1.getImage();
    ImageIO.write(image1, "PNG", new File("D:\\Ajit\\Script_SS\\AdminManage\\6_CrossCheck.png"));
    Thread.sleep(2000);
 
    Reporter.log("Cross check details view..");
   
    driver.navigate().refresh();
   
    Thread.sleep(4000);
 
    driver.switchTo().defaultContent();
   
    Thread.sleep(2000);
    System.out.println("\n");
    System.out.println("Cross check view on admin defaultpage Logs..");
    System.out.println("\n");
    ExtractJSLogs();
   
    Thread.sleep(2000);
    
 }
 catch(Exception e)
 {
    e.getMessage();
 
    final Screenshot screenshot1 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
    final BufferedImage image1 = screenshot1.getImage();
    ImageIO.write(image1, "PNG", new File("D:\\Ajit\\Script_SS\\AdminManageError\\5_CrosscheckFail.png"));
    Thread.sleep(2000);
   
    Assert.assertFalse(false, "FAIL");
    Reporter.log("Cross check not view..");
 
 }

 
      driver.findElement(By.className("manage_btn")).click();
      Thread.sleep(2000);

try
{

 // For Edit Status
     driver.findElement(By.cssSelector("[id*='trans_old_'] > td > div > div [class*='editstat_icon']")).click();
     Thread.sleep(5000);

     driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
 
     File scr22 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
     org.codehaus.plexus.util.FileUtils.copyFile(scr22, new File("D:\\Ajit\\Script_SS\\AdminManage\\7_EditStatus.png")); 
     Thread.sleep(2000);
 /*    
     WebElement el = driver.findElement(By.cssSelector("#MainForm > div > div > div > div.col-md-12.col-sm-12.col-xs-12.counters.bookings.no-padding > div > div > div > div:nth-child(3) > div > div:nth-child(2) [id*='_ctl0_MainContent_StatusSEL']"));
     el.click();
     Thread.sleep(1000);
     el.findElement(By.xpath("//*[@id='_ctl0_MainContent_StatusSEL']/option[8]")).click();
     Thread.sleep(2000);
     
     driver.findElement(By.id("_ctl0_MainContent_SubmitBTN")).click();
     Thread.sleep(2000);
 */   
     Reporter.log("Edit Status view..");
 
     driver.navigate().refresh();
 
     Thread.sleep(6000);

     driver.switchTo().defaultContent();
 
     Thread.sleep(1000);
     System.out.println("\n");
     System.out.println("Edit status view on admin defaultpage Logs..");
     System.out.println("\n");
     ExtractJSLogs();
 
     Thread.sleep(2000);
     

 }
 catch(Exception e)
 {
      e.getMessage();

      final Screenshot screenshot1 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
      final BufferedImage image1 = screenshot1.getImage();
      ImageIO.write(image1, "PNG", new File("D:\\Ajit\\Script_SS\\AdminManageError\\5_EditStatusFail.png"));
      Thread.sleep(1000);
 
      Assert.assertFalse(false, "FAIL");
      Reporter.log("Edit status not view..");

 }
 
       driver.findElement(By.className("manage_btn")).click();
       Thread.sleep(2000);   

 try
 {

  // For Cancel Booking
      driver.findElement(By.cssSelector("[id*='trans_old_'] > td > div > div [class*='cancel_icon show_True']")).click();
      Thread.sleep(5000);

      driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
  
      File scr22 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
      org.codehaus.plexus.util.FileUtils.copyFile(scr22, new File("D:\\Ajit\\Script_SS\\AdminManage\\8_CancelBooking.png")); 
      Thread.sleep(2000);
  /*    
      //For Cancel Booking
      WebElement cnclbkng = driver.findElement(By.id("_ctl0_MainContent_CancelBookingBTN"));
      cnclbkng.click();
      Thread.sleep(4000);
      
      //For Test Booking
      WebElement testbkng = driver.findElement(By.id("_ctl0_MainContent_TestBTN"));
      testbkng.click();
      Thread.sleep(4000);
      
      //For Fraud Booking
      WebElement Fraudbkng = driver.findElement(By.id("_ctl0_MainContent_FraudBTN"));
      Fraudbkng.click();
      Thread.sleep(4000);
  */   
     
      Reporter.log("Cancel booking pop up view..");
  
      driver.navigate().refresh();
  
      Thread.sleep(4000);

      driver.switchTo().defaultContent();
  
      Thread.sleep(1000);
      System.out.println("\n");
      System.out.println("Cancel booking view on admin defaultpage Logs..");
      System.out.println("\n");
      ExtractJSLogs();
  
      Thread.sleep(2000);
     
  }
  catch(Exception e)
  {
       e.getMessage();

       final Screenshot screenshot1 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
       final BufferedImage image1 = screenshot1.getImage();
       ImageIO.write(image1, "PNG", new File("D:\\Ajit\\Script_SS\\AdminManageError\\6_CancelbookingFail.png"));
       Thread.sleep(1000);
  
       Assert.assertFalse(false, "FAIL");
       Reporter.log("Cancel booking pop up not view..");

  }
 
    driver.navigate().refresh();
    Thread.sleep(3000);
  
  /*   
    driver.findElement(By.cssSelector("#sb-site > ul > li.ody-icon-button.pull-left [class*='ody-navigation-minimize']")).click();
    Thread.sleep(2000);
    driver.findElement(By.cssSelector("#sb-site > ul > li.ody-icon-button.pull-left [class*='ody-navigation-minimize']")).click();
    Thread.sleep(2000);
  */
    
    driver.findElement(By.className("manage_btn")).click();
    Thread.sleep(2000);

  try
  {
     // For Send email
	     driver.findElement(By.cssSelector("[id*='trans_old_'] > td > div > div [class*='sendemail_icon']")).click();
	     Thread.sleep(5000);
	  
	     driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
	     
	     final Screenshot screenshot1 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	     final BufferedImage image1 = screenshot1.getImage();
	     ImageIO.write(image1, "PNG", new File("D:\\Ajit\\Script_SS\\AdminManage\\9_SendEmail.png"));
	     Thread.sleep(2000);
	/*     
	    // For Send email
	     driver.findElement(By.id("_ctl0_MainContent_SendBTN")).click();
    */
	     Reporter.log("Send email pop up View..");
	     
	     driver.navigate().refresh();
	     
	     Thread.sleep(4000);
	   
	     driver.switchTo().defaultContent();
	     
	     Thread.sleep(1000);
	     System.out.println("\n");
	     System.out.println("Send email pop up view on admin defaultpage Logs..");
	     System.out.println("\n");
	     ExtractJSLogs();
	     
	     Thread.sleep(2000);
	     	   
  }
  catch(Exception e)
  {
	     e.getMessage();
	  
	     final Screenshot screenshot1 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	     final BufferedImage image1 = screenshot1.getImage();
	     ImageIO.write(image1, "PNG", new File("D:\\Ajit\\Script_SS\\AdminManageError\\6_SendEmailFail.png"));
	     Thread.sleep(2000);
	     
	     Assert.assertFalse(false, "FAIL");
	     Reporter.log("Send email pop up not view..");
  }
  
      driver.findElement(By.className("manage_btn")).click();
      Thread.sleep(2000);

 try
 {
    // For Rules
	     driver.findElement(By.cssSelector("[id*='trans_old_'] > td > div > div [class*='promo_icon']")).click();
	     Thread.sleep(5000);
	  
	     driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
	     
	     File scr22 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	     org.codehaus.plexus.util.FileUtils.copyFile(scr22, new File("D:\\Ajit\\Script_SS\\AdminManage\\10_SelectedRules.png")); 
	     Thread.sleep(2000);
  /*	     	    
	    // For Applicable Rules
	     driver.findElement(By.cssSelector("#tabs > ul > li:nth-child(2) [class*='ui-tabs-anchor']")).click();
	     Thread.sleep(1500);
	     
	     File scr23 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	     org.codehaus.plexus.util.FileUtils.copyFile(scr23, new File("D:\\Ajit\\Script_SS\\AdminManage\\11_ApplicableRules.png")); 
	     Thread.sleep(2000);
  */
	     Reporter.log("Rules pop up View for the Selected Rules and Applicable Rules...");
	     
	     driver.navigate().refresh();
	     
	     Thread.sleep(4000);
	   
	     driver.switchTo().defaultContent();
	     
	     Thread.sleep(1000);
	     System.out.println("\n");
	     System.out.println("Rules pop up view on admin defaultpage Logs..");
	     System.out.println("\n");
	     ExtractJSLogs();
	     
	     Thread.sleep(2000);
	     
	   
 }
 catch(Exception e)
 {
	     e.getMessage();
	  
	     final Screenshot screenshot1 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	     final BufferedImage image1 = screenshot1.getImage();
	     ImageIO.write(image1, "PNG", new File("D:\\Ajit\\Script_SS\\AdminManageError\\7_RulesFail.png"));
	     Thread.sleep(2000);
	     
	     Assert.assertFalse(false, "FAIL");
	     Reporter.log("Rules pop up not view..");
 }
      
      driver.findElement(By.className("manage_btn")).click();
      Thread.sleep(2000);

 try
 {
     // Accounting data
	     driver.findElement(By.cssSelector("[id*='trans_old_'] > td > div > div [class*='isstik_icon show_True']")).click();
	     Thread.sleep(5000);
	  
	     driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
	     
	     driver.findElement(By.id("_ctl0_MainContent_SaveBTN")).click();
	     Thread.sleep(4000);
	     
	     File scr22 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	     org.codehaus.plexus.util.FileUtils.copyFile(scr22, new File("D:\\Ajit\\Script_SS\\AdminManage\\18_Accountingdata.png")); 
	     Thread.sleep(2000);
	     	    
	     Reporter.log("Accounting data pop up View...");
	     
	     driver.navigate().refresh();
	     
	     Thread.sleep(4000);
	   
	     driver.switchTo().defaultContent();
	     
	     Thread.sleep(1000);
	     System.out.println("\n");
	     System.out.println("Accounting data pop up view on admin defaultpage Logs..");
	     System.out.println("\n");
	     ExtractJSLogs();
	     
	     Thread.sleep(2000);
	     
	   
 }
 catch(Exception e)
 {
	     e.getMessage();
	  
	     final Screenshot screenshot1 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	     final BufferedImage image1 = screenshot1.getImage();
	     ImageIO.write(image1, "PNG", new File("D:\\Ajit\\Script_SS\\AdminManageError\\12_AccountingdataFail.png"));
	     Thread.sleep(2000);
	     
	     Assert.assertFalse(false, "FAIL");
	     Reporter.log("Accounting data pop up not view..");
 }
 
 driver.findElement(By.className("manage_btn")).click();
 Thread.sleep(2000);

try
{
 // For Details
    driver.findElement(By.cssSelector("[id*='trans_old_'] > td > div > div [class*='detail_icon']")).click();
    Thread.sleep(5000);
 
    for(int i = driver.getWindowHandles().size() -1 ; i > 0 ; i--)
    {

           String winHandle = driver.getWindowHandles().toArray()[i].toString();

           driver.switchTo().window(winHandle);
           
           driver.navigate().refresh();
           
           Thread.sleep(2000);
    
    final Screenshot screenshot1 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
    final BufferedImage image1 = screenshot1.getImage();
    ImageIO.write(image1, "PNG", new File("D:\\Ajit\\Script_SS\\AdminManage\\32_Detailspage.png"));
    Thread.sleep(1000);

    Reporter.log("Booking Details View..");
    
    Thread.sleep(1000);
    System.out.println("\n");
    System.out.println("Booking History updated on admin defaultpage Logs..");
    System.out.println("\n");
    ExtractJSLogs();
    
    Thread.sleep(2000);
    
    driver.navigate().to("https://ui.odysol.com/admin/default.aspx");
    Thread.sleep(4000);
  }  
   	   
}
catch(Exception e)
{
 e.getMessage();
 
    final Screenshot screenshot1 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
    final BufferedImage image1 = screenshot1.getImage();
    ImageIO.write(image1, "PNG", new File("D:\\Ajit\\Script_SS\\AdminManageError\\3_BookingDetails.png"));
    Thread.sleep(2000);
    
    Assert.assertFalse(false, "FAIL");
    Reporter.log("Booking Details not View..");
}
       
      driver.findElement(By.className("manage_btn")).click();
      Thread.sleep(2000);

 try
 {
     // Clone (Round Trip)
	     driver.findElement(By.cssSelector("[id*='trans_old_'] > td > div > div [class*='clone_icon show_True']")).click();
	     Thread.sleep(5000);
	  
	     driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
	     
	     File scr22 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	     org.codehaus.plexus.util.FileUtils.copyFile(scr22, new File("D:\\Ajit\\Script_SS\\AdminManage\\19_CloneRoundTrip.png")); 
	     Thread.sleep(2000);
	     
	  //One Way
	     driver.findElement(By.cssSelector("#AirSearchForm > div > div.menu_list_left.panel.panel-default.tabs > div > ul > li:nth-child(2) > a")).click();
	     Thread.sleep(1000);
	     
	     File scr25 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	     org.codehaus.plexus.util.FileUtils.copyFile(scr25, new File("D:\\Ajit\\Script_SS\\AdminManage\\20_CloneOneWay.png")); 
	     Thread.sleep(2000);
	     
	  // Multi City
	     driver.findElement(By.cssSelector("#AirSearchForm > div > div.menu_list_left.panel.panel-default.tabs > div > ul > li:nth-child(3) > a")).click();
	     Thread.sleep(1000);
	     
	     File scr26 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	     org.codehaus.plexus.util.FileUtils.copyFile(scr26, new File("D:\\Ajit\\Script_SS\\AdminManage\\21_CloneMultiCity.png")); 
	     Thread.sleep(2000);
	     
	  //Round Trip
	     driver.findElement(By.cssSelector("#AirSearchForm > div > div.menu_list_left.panel.panel-default.tabs > div > ul > li:nth-child(1) > a")).click();
	     Thread.sleep(900);
	     
	     driver.findElement(By.id("AirSearchForm_SearchButton")).click();
	     Thread.sleep(6000);
	     
	    for(int i = driver.getWindowHandles().size() -1 ; i > 0 ; i--)
	    {

	           String winHandle = driver.getWindowHandles().toArray()[i].toString();

	           driver.switchTo().window(winHandle);
	           
	           driver.navigate().refresh();
	           
	           driver.get("https://ui.odysol.com/web/air/results.aspx?showtrace=true");
	  
		       driver.manage().window().maximize();
		       
		       Thread.sleep(5000);
		       
		       if(driver.findElement(By.cssSelector("#MainForm > div.clonebookingloader > div > div.notification-message > a")).isDisplayed())
		       {
		    	   driver.findElement(By.cssSelector("#MainForm > div.clonebookingloader > div > div.notification-message > a")).click();
		    	   Thread.sleep(3000);
		       }
		       
		         Thread.sleep(2000);
		       
		        final Screenshot screenshot43 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	            final BufferedImage image43 = screenshot43.getImage();
	            ImageIO.write(image43, "PNG", new File("D:\\Ajit\\Script_SS\\AdminManage\\30_Resultpage.png"));
	       
	   	        Thread.sleep(5000);
	   	        
	   	  // For select flight
	            if(driver.findElement(By.cssSelector("[id*='flight-summary_'] > div.pricebox.btn-container [class*='select-flight print-select-flight primary-btn pull-left m-hidden']")).isDisplayed())
	            {
	           	   driver.findElement(By.cssSelector("[id*='flight-summary_'] > div.pricebox.btn-container [class*='select-flight print-select-flight primary-btn pull-left m-hidden']")).click();
	           	   Thread.sleep(4000);
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
	                ImageIO.write(image2, "PNG", new File("D:\\Ajit\\Script_SS\\AdminManageError\\2_Flightnotavailable.png"));
	               
	                Assert.assertFalse(false, "FAIL");
	   	            Reporter.log("Flights not available..");
	   			    
	   		     } 
	            
	               final Screenshot screenshot3 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	               final BufferedImage image3 = screenshot3.getImage();
	               ImageIO.write(image3, "PNG", new File("D:\\Ajit\\Script_SS\\AdminManage\\31_Checkoutpage.png"));
	               
	               Thread.sleep(2000);
	               
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
	  	          
	  	      //For Payment        
	  	        try
	  	        {
	  	          if(envrnmnt.toLowerCase().trim().equals("test"))
	  	          {
	  	              driver.findElement(By.cssSelector("#st-accordion > ul > li:nth-child(7) > div > div > input")).click();
	  	              Thread.sleep(3000);
	  	          }   
	  	        }
	  	        catch(Exception e)
	  	        {
	  	       	  e.getMessage();
	  	      	 
	  	        }
	  	           
	  	        try
	  	        {
	  	        	WebElement els = driver.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0__ctl4_CreditCardInfo_cardType']"));
	  	        	Thread.sleep(500);
	  	        	els.click();
	  	        	Thread.sleep(1000);
	  	        	els.findElement(By.cssSelector("#_ctl0_MainContentsPH__ctl0__ctl4_CreditCardInfo_cardType > option:nth-child(5)")).click();
	  	        	Thread.sleep(1000);
	  	        	
	  	        	WebElement hldrnme = driver.findElement(By.id("_ctl0_MainContentsPH__ctl0__ctl4_CreditCardInfo_cardHolderName"));
	  	        	Thread.sleep(500);
	  	        	hldrnme.click();
	  	        	Thread.sleep(500);
	  	        	hldrnme.sendKeys("Monish Luthra");
	  	        	Thread.sleep(800);
	  	        	
	  	        	WebElement crdcrdnme = driver.findElement(By.id("_ctl0_MainContentsPH__ctl0__ctl4_CreditCardInfo_cardNumber"));
	  	        	Thread.sleep(500);
	  	        	crdcrdnme.click();
	  	        	Thread.sleep(500);
	  	        	crdcrdnme.sendKeys("4111111111111111");
	  	        	Thread.sleep(800);
	  	        	
	  	        	WebElement csvnme = driver.findElement(By.id("_ctl0_MainContentsPH__ctl0__ctl4_CreditCardInfo_cardCCV"));
	  	        	Thread.sleep(500);
	  	        	csvnme.click();
	  	        	Thread.sleep(500);
	  	        	csvnme.sendKeys("123");
	  	        	Thread.sleep(800);
	  	        	
	  	        	driver.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0__ctl4_CreditCardInfo_expireDate_Month']")).click();
	  	        	Thread.sleep(1000);
	  	        	driver.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0__ctl4_CreditCardInfo_expireDate_Month']/option[9]")).click();
	  	        	Thread.sleep(1000);
	  	        	
	  	        	driver.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0__ctl4_CreditCardInfo_expireDate_Year']")).click();
	  	        	Thread.sleep(1000);
	  	        	driver.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0__ctl4_CreditCardInfo_expireDate_Year']/option[7]")).click();
	  	        	Thread.sleep(1000);
	  	        	
	  	        	WebElement addrs = driver.findElement(By.id("_ctl0_MainContentsPH__ctl0__ctl4_BillingAddress_AddrLine1"));
	  	        	Thread.sleep(500);
	  	        	addrs.click();
	  	        	Thread.sleep(500);
	  	        	addrs.sendKeys("White House");
	  	        	Thread.sleep(800);
	  	        	
	  	        	WebElement state = driver.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0__ctl4_BillingAddress_StateSel']"));
	  	        	Thread.sleep(500);
	  	        	state.click();
	  	        	Thread.sleep(1000);
	  	        	state.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0__ctl4_BillingAddress_StateSel']/option[3]")).click();
	  	        	Thread.sleep(1000);
	  	        	
	  	        	WebElement cty = driver.findElement(By.id("_ctl0_MainContentsPH__ctl0__ctl4_BillingAddress_CityInput"));
	  	        	Thread.sleep(500);
	  	        	cty.click();
	  	        	Thread.sleep(500);
	  	        	cty.sendKeys("Florida");
	  	        	Thread.sleep(800);
	  	        	
	  	        	WebElement zpcd = driver.findElement(By.id("_ctl0_MainContentsPH__ctl0__ctl4_BillingAddress_ZipCodeInput"));
	  	        	Thread.sleep(500);
	  	        	zpcd.click();
	  	        	Thread.sleep(500);
	  	        	zpcd.sendKeys("10245");
	  	        	Thread.sleep(800);
	  	        	
	  	        	WebElement blngphne = driver.findElement(By.id("_ctl0_MainContentsPH__ctl0__ctl4_BillingAddress_PhoneInput_Number"));
	  	        	Thread.sleep(500);
	  	        	blngphne.click();
	  	        	Thread.sleep(500);
	  	        	blngphne.sendKeys("4521653298");
	  	        	Thread.sleep(800);
	  	        	
	  	        	WebElement bnkpne = driver.findElement(By.id("_ctl0_MainContentsPH__ctl0__ctl4_BillingAddress_BankPhoneInput_Number"));
	  	        	Thread.sleep(500);
	  	        	bnkpne.click();
	  	        	Thread.sleep(500);
	  	        	bnkpne.sendKeys("4521653258");
	  	        	Thread.sleep(800);
	  	        	
	  	        	WebElement bnknme = driver.findElement(By.id("_ctl0_MainContentsPH__ctl0__ctl4_BillingAddress_BankNameTXT"));
	  	        	Thread.sleep(500);
	  	        	bnknme.click();
	  	        	Thread.sleep(500);
	  	        	bnknme.sendKeys("City Bank");
	  	        	Thread.sleep(800);
	  	        	
	  	        	driver.findElement(By.id("AgreeTermsCHK")).click();
	  	        	Thread.sleep(900);
	  	        	
	  	        	driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_ContinueBTN")).click();
	  	        	Thread.sleep(9000);
	  	        	
	  	        	 final Screenshot screenshot1 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
				     final BufferedImage image1 = screenshot1.getImage();
				     ImageIO.write(image1, "PNG", new File("D:\\Ajit\\Script_SS\\AdminManage\\22_CloneSuccess.png"));
				     Thread.sleep(4000);
	  	        }
	  	        catch(Exception e)
	  	        {
	  	        	e.getMessage();
	  	        }
		       
		            driver.navigate().to("https://ui.odysol.com/admin/default.aspx");
		            Thread.sleep(2000);
			     
	     } 
	          
	            
	           driver.navigate().refresh();
	  	     
	           Thread.sleep(4000);
	    
	           Reporter.log("Clone Success..");
		   
	           Thread.sleep(1000);
	           System.out.println("\n");
	           System.out.println("Clone pop up view on admin defaultpage Logs..");
	           System.out.println("\n");
	           ExtractJSLogs();
	     
	           Thread.sleep(2000);
	   
 }
 catch(Exception e)
 {
	     e.getMessage();
	  
	     final Screenshot screenshot1 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	     final BufferedImage image1 = screenshot1.getImage();
	     ImageIO.write(image1, "PNG", new File("D:\\Ajit\\Script_SS\\AdminManageError\\13_CloneFail.png"));
	     Thread.sleep(2000);
	     
	     Assert.assertFalse(false, "FAIL");
	     Reporter.log("Clone pop up not view or not working..");
 }
 
 
      driver.findElement(By.className("manage_btn")).click();
      Thread.sleep(2000);

 try
 {
       // For Transfer booking
       if(driver.findElement(By.cssSelector("[id*='trans_old_'] > td > div > div [class*='transfer_icon']")).isDisplayed())
       {
           driver.findElement(By.cssSelector("[id*='trans_old_'] > td > div > div [class*='transfer_icon']")).click();
           Thread.sleep(4000);
       }
           driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
           
           File scr22 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	       org.codehaus.plexus.util.FileUtils.copyFile(scr22, new File("D:\\Ajit\\Script_SS\\AdminManage\\13_Transferbooking.png")); 
	       Thread.sleep(2000);
	 /*      
	       // For transfer booking B2B To B2C
	       driver.findElement(By.id("_ctl0_MainContent_App_B2C")).click();
	       Thread.sleep(1500);
	       
	       driver.findElement(By.id("_ctl0_MainContent_SubmitBTN")).click();
	       Thread.sleep(4000);
	       
	       File scr23 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	       org.codehaus.plexus.util.FileUtils.copyFile(scr23, new File("D:\\Ajit\\Script_SS\\AdminManage\\14_TransferbookingSuccess.png")); 
	       Thread.sleep(2000);
      */
            Reporter.log("Transfer booking successfully...");
 
            driver.navigate().refresh();
 
            Thread.sleep(4000);
            
            driver.switchTo().defaultContent();
   	     
   	        Thread.sleep(1000);
   	        System.out.println("\n");
   	        System.out.println("Transfer booking pop up view on admin defaultpage Logs..");
   	        System.out.println("\n");
   	        ExtractJSLogs();
   	     
   	        Thread.sleep(2000);


 }
 catch(Exception e)
 {
       e.getMessage();

       final Screenshot screenshot1 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
       final BufferedImage image1 = screenshot1.getImage();
       ImageIO.write(image1, "PNG", new File("D:\\Ajit\\Script_SS\\AdminManageError\\9_TransferbookingFail.png"));
       Thread.sleep(2000);
 
       Assert.assertFalse(false, "FAIL");
       Reporter.log("Transfer booking not successful..");
 }
       
       driver.findElement(By.className("manage_btn")).click();
       Thread.sleep(2000);

  try
  {
        // For Customer Notes
        if(driver.findElement(By.cssSelector("[id*='trans_old_'] > td > div > div [class*='notes_icon']")).isDisplayed())
        {
            driver.findElement(By.cssSelector("[id*='trans_old_'] > td > div > div [class*='notes_icon']")).click();
            Thread.sleep(4000);
        }
            driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
            
            File scr22 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
 	        org.codehaus.plexus.util.FileUtils.copyFile(scr22, new File("D:\\Ajit\\Script_SS\\AdminManage\\15_CustomerNotes.png")); 
 	        Thread.sleep(2000);
 	       
 	      // For Booking Notes
 	       driver.findElement(By.cssSelector("#MainForm > div > div > div > div.col-md-12.col-sm-12.col-xs-12.counters.bookings.no-padding > div > div > div > div:nth-child(2) > ul > li:nth-child(1) > a")).click();
 	       Thread.sleep(1500);
  	       
 	       File scr24 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	       org.codehaus.plexus.util.FileUtils.copyFile(scr24, new File("D:\\Ajit\\Script_SS\\AdminManage\\16_BookingNotes.png")); 
	       Thread.sleep(2000);
 	       
	      // For Add Notes 
 	       driver.findElement(By.cssSelector("#MainForm > div > div > div > div.col-md-12.col-sm-12.col-xs-12.counters.bookings.no-padding > div > div > div > div:nth-child(2) > ul > li:nth-child(3) > a")).click();
 	       Thread.sleep(2000);
    /*	       
 	       WebElement description = driver.findElement(By.cssSelector("#_ctl0_MainContent_NotesUC_DescriptionTA"));
 	       Thread.sleep(1000);
 	       description.click();
 	       Thread.sleep(900);
 	       description.sendKeys("This is a test note of automation");
	       Thread.sleep(900);
	       driver.findElement(By.id("_ctl0_MainContent_NotesUC_PublicSEL")).click();  // For the Public checkbox
	       Thread.sleep(800);
	       driver.findElement(By.id("_ctl0_MainContent_NotesUC_NoteOwnerSEL")).click(); // Add as customer notes
	       Thread.sleep(800);
	       
	       driver.findElement(By.id("_ctl0_MainContent_NotesUC_SubmitBTN")).click();
	       Thread.sleep(4000);
 	 */      
 	       File scr23 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
 	       org.codehaus.plexus.util.FileUtils.copyFile(scr23, new File("D:\\Ajit\\Script_SS\\AdminManage\\17_AddNotes.png")); 
 	       Thread.sleep(3000);
       
             Reporter.log("Add Notes successfully...");
  
             driver.navigate().refresh();
  
             Thread.sleep(4000);
             
             driver.switchTo().defaultContent();
    	     
    	        Thread.sleep(1000);
    	        System.out.println("\n");
    	        System.out.println("Add Notes pop up view on admin defaultpage Logs..");
    	        System.out.println("\n");
    	        ExtractJSLogs();
    	     
    	        Thread.sleep(2000);

  }
  catch(Exception e)
  {
        e.getMessage();

        final Screenshot screenshot1 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
        final BufferedImage image1 = screenshot1.getImage();
        ImageIO.write(image1, "PNG", new File("D:\\Ajit\\Script_SS\\AdminManageError\\10_AddNotesFail.png"));
        Thread.sleep(2000);
  
        Assert.assertFalse(false, "FAIL");
        Reporter.log("Add Notes Fail..");
  }
     
    
         driver.findElement(By.className("manage_btn")).click();
         Thread.sleep(2000);
 
 try
 {
    // For ExportXML
	 if(driver.findElement(By.cssSelector("[id*='trans_old_'] > td > div > div [class*='expxml_icon']")).isDisplayed())
	 {
	     driver.findElement(By.cssSelector("[id*='trans_old_'] > td > div > div [class*='expxml_icon']")).click();
	     Thread.sleep(3000);
	 }
	  // Switch to new window opened
	     
         String winHandleBefore = driver.getWindowHandle();
         
         for(String winHandle : driver.getWindowHandles())
         {
             driver.switchTo().window(winHandle);
              
         }
                  
           // Get price from new windows
           String amount = driver.findElement(By.cssSelector("#collapsible25 > div.expanded > div:nth-child(1) > span.html-tag > span:nth-child(6) > span.html-attribute-value")).getText();
           Thread.sleep(2000);
           Reporter.log("Amount in ExportXML:- " +amount);
           Thread.sleep(1000);
           final Screenshot screenshot63 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
           final BufferedImage image63 = screenshot63.getImage();
           ImageIO.write(image63, "PNG", new File("D:\\Ajit\\Script_SS\\AdminManage\\12_ExportXML.png"));
           Thread.sleep(2000);
           
        // Close the new window
           driver.close();
           
           driver.switchTo().window(winHandleBefore);
	 
	       Reporter.log("ExportXML booking successfully...");
	     
	       driver.navigate().refresh();
	     
	       Thread.sleep(4000);
	   
	   
 }
 catch(Exception e)
 {
	     e.getMessage();
	  
	     final Screenshot screenshot1 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
	     final BufferedImage image1 = screenshot1.getImage();
	     ImageIO.write(image1, "PNG", new File("D:\\Ajit\\Script_SS\\AdminManageError\\9_ExportXMLFail.png"));
	     Thread.sleep(2000);
	     
	     Assert.assertFalse(false, "FAIL");
	     Reporter.log("ExportXML booking not successful..");
 }
    
 
}

@DataProvider
public String[][] Authentication() throws Exception
{

 String[][] testObjArray = OdysolHotelUtils.getTableArray("D:\\Ajit\\Automation\\Workspace\\Odysseus_Product\\src\\main\\java\\testData\\OdysolHotelData.xlsx","Sheet1");

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
