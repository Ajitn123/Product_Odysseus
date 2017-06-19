package Implementation;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import javax.imageio.ImageIO;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.screentaker.ViewportPastingStrategy;


public class OdysseusTicketLocalTest
{

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
 
    final Screenshot screenshot1 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
    final BufferedImage image1 = screenshot1.getImage();
    ImageIO.write(image1, "PNG", new File("D:\\Ajit\\Script_SS\\BPC\\1_Searchpage.png"));
    
    Thread.sleep(4000);
    
}


@Test
public void Local_data() throws Exception
{
     
    try
    {
           
             	driver.findElement(By.id("UserName")).click();
             	Thread.sleep(500);
             	driver.findElement(By.id("UserName")).sendKeys("bparth@odysol.com");
             	Thread.sleep(500);
             	driver.findElement(By.id("UserPassword")).click();
             	Thread.sleep(500);
             	driver.findElement(By.id("UserPassword")).sendKeys("parth123");
             	Thread.sleep(500);
             	driver.findElement(By.id("SubmitBTN")).click();
             	Thread.sleep(2000);
             	driver.findElement(By.xpath("//*[@id='sb-site']/div[3]/div/div[1]/div[1]/div/div/div[2]/div/div/div/div/div[1]/div/div[2]/table/tbody/tr[7]/td[3]/a[1]")).click(); // For akhil website
             	Thread.sleep(4000);
            	
              	//Select affiliate
             	WebElement wel = driver.findElement(By.cssSelector("#select2-AffiliateDropDownList-container"));
             	wel.click();
             	Thread.sleep(700);
             	WebElement webel = driver.findElement(By.className("select2-search__field"));
             	webel.click();
             	webel.sendKeys("viva"); //direct line , viva voyage uk
             	webel.sendKeys(Keys.TAB);
             	Thread.sleep(1500);
           	
             	driver.findElement(By.xpath("//*[@id='CruiseSearchForm_CruiseLine']/option[16]")).click();  // For princes
             	Thread.sleep(1500);
             	driver.findElement(By.xpath("//*[@id='CruiseSearchForm_Month']/option[4]")).click(); // july 2017
             	Thread.sleep(500);
             	driver.findElement(By.xpath("//*[@id='CruiseSearchForm_OpenTarget']")).click();
             	Thread.sleep(1000);
             	
             	final Screenshot screenshot1 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                final BufferedImage image1 = screenshot1.getImage();
                ImageIO.write(image1, "PNG", new File("D:\\Ajit\\Script_SS\\Odysseus\\1_Searchpage.png"));
                Thread.sleep(3000);
             	
             	driver.findElement(By.xpath("//*[@id='CruiseSearchForm_tab2']/div[2]/div[3]/div/input")).click();
             	Thread.sleep(5000);
             	
             	final Screenshot screenshot2 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                final BufferedImage image2 = screenshot2.getImage();
                ImageIO.write(image2, "PNG", new File("D:\\Ajit\\Script_SS\\Odysseus\\2_Resultpage.png"));
                Thread.sleep(7000);
                
                driver.findElement(By.xpath("#PriceList_7 > div > ul > li.grid-btn > a")).click();
                Thread.sleep(4000);
                
                driver.navigate().refresh();
                Thread.sleep(2000);
                
                final Screenshot screenshot3 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                final BufferedImage image3 = screenshot3.getImage();
                ImageIO.write(image3, "PNG", new File("D:\\Ajit\\Script_SS\\Odysseus\\3_Detailspage.png"));
                Thread.sleep(2000);
                
                driver.findElement(By.id("_ctl0:MainContentsPH:_ctl0:_ctl0_GuestAge_1")).click();
                Thread.sleep(800);
                driver.findElement(By.id("_ctl0:MainContentsPH:_ctl0:_ctl0_GuestAge_1")).sendKeys("24");
                Thread.sleep(700);
                driver.findElement(By.id("_ctl0:MainContentsPH:_ctl0:_ctl0_GuestAge_2")).click();
                Thread.sleep(700);
                driver.findElement(By.id("_ctl0:MainContentsPH:_ctl0:_ctl0_GuestAge_2")).sendKeys("30");
                Thread.sleep(700);
                driver.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0__ctl0_ResidentCity']")).click();
                Thread.sleep(800);
                driver.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0__ctl0_ResidentCity']/option[20]")).click();
                Thread.sleep(900);
                driver.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0__ctl0_CategoryLNK']")).click();
                Thread.sleep(5000);
                
                final Screenshot screenshot4 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                final BufferedImage image4 = screenshot4.getImage();
                ImageIO.write(image4, "PNG", new File("D:\\Ajit\\Script_SS\\Odysseus\\4_Categorypage.png"));
                Thread.sleep(4000);
    /*            
                //For Gaurantees
                if(driver.findElement(By.xpath("//*[@id='category_1']/div[1]/div[4]/ul[2]/li[5]/a")).isDisplayed())
                {
                	driver.findElement(By.xpath("//*[@id='category_1']/div[1]/div[4]/ul[2]/li[5]/a")).click();
                    Thread.sleep(3000);
                }
    */
                // For Cabin Assignments Available
                if(driver.findElement(By.xpath("//*[@id='category_0']/div[1]/div[4]/ul[2]/li[4]/a")).isDisplayed())
                {
                	driver.findElement(By.xpath("//*[@id='category_0']/div[1]/div[4]/ul[2]/li[4]/a")).click();
                	Thread.sleep(1000);
                     
                }
                
                final Screenshot screenshot5 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                final BufferedImage image5 = screenshot5.getImage();
                ImageIO.write(image5, "PNG", new File("D:\\Ajit\\Script_SS\\Odysseus\\5_Cabinpage.png"));
                Thread.sleep(2000);
                
                //Select cabin
                driver.findElement(By.cssSelector("[id*='CabinBook_']")).click();
                Thread.sleep(3000);
                
                final Screenshot screenshot6 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                final BufferedImage image6 = screenshot6.getImage();
                ImageIO.write(image6, "PNG", new File("D:\\Ajit\\Script_SS\\Odysseus\\6_CustomerSearchpage.png"));
                Thread.sleep(2000);
                
                driver.findElement(By.id("_ctl0_MainContent_fName")).click();
                driver.findElement(By.id("_ctl0_MainContent_fName")).sendKeys("Monish");
                Thread.sleep(2000);
                
                driver.findElement(By.id("_ctl0_MainContent_SearchBTN")).click();
                Thread.sleep(3000);
                
                driver.findElement(By.xpath("//*[@id='_ctl0_MainContent_CustResults__ctl1_SelectLinkButton']/img")).click();
                Thread.sleep(2000);
                
                final Screenshot screenshot7 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                final BufferedImage image7 = screenshot7.getImage();
                ImageIO.write(image7, "PNG", new File("D:\\Ajit\\Script_SS\\Odysseus\\7_Checkoutpage.png"));
                Thread.sleep(2000);
                
                driver.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_GroupPassID_2']")).click();
                Thread.sleep(500);
                driver.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_GroupPassID_2']/option[6]")).click();
                Thread.sleep(2000);
                driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_ContinueLNK")).click();
                Thread.sleep(3000);
                
                final Screenshot screenshot8 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                final BufferedImage image8 = screenshot8.getImage();
                ImageIO.write(image8, "PNG", new File("D:\\Ajit\\Script_SS\\Odysseus\\8_Confirmationpage.png"));
                Thread.sleep(2000);
   /* 	
                //decline insurance
                driver.findElement(By.id("InsurranceCHK_NON")).click();
                Thread.sleep(1500);
                driver.switchTo().alert().accept();
                Thread.sleep(500);
                
                //For full payment
                driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_ContinueBTN")).click(); // Click on full payment
                Thread.sleep(4000);
                driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_CreditCardInfo_cardType")).click();
                Thread.sleep(500);
                driver.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_CreditCardInfo_cardType']/option[6]")).click();
                Thread.sleep(500);
                driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_CreditCardInfo_cardNumber")).click();
                driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_CreditCardInfo_cardNumber")).sendKeys("4111111111111111");
                Thread.sleep(1000);
                driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_CreditCardInfo_cardCCV")).click();
                driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_CreditCardInfo_cardCCV")).sendKeys("123");
                Thread.sleep(800);
                driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_CreditCardInfo_expireDate_Month")).click();
                Thread.sleep(500);
                driver.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_CreditCardInfo_expireDate_Month']/option[6]")).click();
                Thread.sleep(500);
                driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_CreditCardInfo_expireDate_Year")).click();
                Thread.sleep(500);
                driver.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_CreditCardInfo_expireDate_Year']/option[7]")).click();
                Thread.sleep(500);
                driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_CreditCardInfo_cardHolderName")).click();
                driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_CreditCardInfo_cardHolderName")).sendKeys("Monish Luthra");
                Thread.sleep(1000);
                
                driver.findElement(By.id("AgreeTermsCHK")).click();
                Thread.sleep(500);
                
                driver.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_ContinueLNK']")).click();
                Thread.sleep(6000);
                
                final Screenshot screenshot9 = new AShot().shootingStrategy(new ViewportPastingStrategy(500)).takeScreenshot(driver);
                final BufferedImage image9 = screenshot9.getImage();
                ImageIO.write(image9, "PNG", new File("D:\\Ajit\\Script_SS\\Odysseus\\9_Confirmbookingpage.png"));
                Thread.sleep(2000);
    */          
                
    }
    catch(Exception e)
    {
    	e.getMessage();
    }
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
