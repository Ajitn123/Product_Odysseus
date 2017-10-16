package Implementation;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import Utility.OdysolAirUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;


public class LoginTest
{

	 Login lgnpge;
	 static WebDriver driver;
     Reporter report = new Reporter();
	   
  public static boolean implicitwait(long time)
  {
      try {
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
  public void openBroswer(String browser) throws InterruptedException  
  {
      try {
	                 if (browser.equalsIgnoreCase("Firefox"))
	                 {
	                	   driver = new FirefoxDriver();
      	   
	                 } 
	                 else if (browser.equalsIgnoreCase("chrome")) 
	                 {
		                    System.setProperty("webdriver.chrome.driver", "D:\\Ajit\\Automation\\Workspace\\Odysseus_Product\\Driver\\chromedriver_win32\\chromedriver.exe");
		               //   driver = new ChromeDriver();
		                   
	                 }  
	                 else if (browser.equalsIgnoreCase("IE")) 
	                 {
		                   System.setProperty("webdriver.ie.driver", "D:\\Ajit\\Automation\\Workspace\\Odysseus_Product\\Driver\\IEDriverServer_Win32_2.53.0\\IEDriverServer.exe");
		                // driver = new InternetExplorerDriver();
		                   
	                 } 

          } catch (WebDriverException e) 
            {
	                   System.out.println(e.getMessage());
            }
                driver.manage().window().maximize();
                driver.navigate().to("https://localhost/odyssey/admin/");
                Thread.sleep(2000);
                lgnpge = PageFactory.initElements(driver, Login.class);
                
  }
	

  @Test(dataProvider="Authentication")
  public void login_data(String sUsername, String sPassword, String FromLocation, String ToLocation, String Firstname_Of_Adult1, String Middlename_of_Adult1, String Lastname_Of_Adult1, String Firstname_Of_Adult2, String Middlename_of_Adult2, String Lastname_Of_Adult2, String Firstname_Of_Adult3, String Middlename_of_Adult3, String Lastname_Of_Adult3, String Email, String Phone_No, String CardHolderName, String CardNo, String CardCvvNo, String Address, String City, String Zipcode, String Phone_Number, String BankName) throws Exception
  {
       String Credentials = "Login Successfully..!";
       Reporter.log("User Login :- " + Credentials);

       System.out.println("sUsername: " + sUsername);
       System.out.println("sPassword: " + sPassword);
                   
       lgnpge.LoginToTittle(sUsername, sPassword);
              
       Thread.sleep(500);
     
   //    Assert.assertEquals("Username is:-" +Uname+"Should be ajithn@odysol.com",Uname,"ajithn@odysol.com");
       
       System.out.println("Page title verified:- User login successfully");
  }
  
  @DataProvider
  public String[][] Authentication() throws Exception{

	  String[][] testObjArray = OdysolAirUtils.getTableArray("D:\\Ajit\\Automation\\Workspace\\Odysseus_Product\\src\\main\\java\\testData\\OdysolAirData.xlsx","Sheet1");

       return (testObjArray);

		}


  @AfterClass
  public void closeBrowser()
  {/*
	    if(driver!=null) 
	    {
		     System.out.println("Closing the browser");
		     driver.quit();
	    }   
    */
  }

}
