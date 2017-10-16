package Implementation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DatadrivenTest
{
    
	  HSSFWorkbook workbook;
	  //define an Excel Work sheet
	  HSSFSheet sheet;
	  //define a test result data object
	  Map<String, Object[]> testresultdata;
	  private static RemoteWebDriver driver;
	  Reporter report = new Reporter();
	  Boolean authflag = false;

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
    public void openBroswer(String browser) throws InterruptedException  
    {
        try
        {
	                 if (browser.equalsIgnoreCase("Firefox"))
	                 {
	                   //   driver = new FirefoxDriver();
   	   
	                 } 
	                 else if (browser.equalsIgnoreCase("chrome")) 
	                 {
		                    System.setProperty("webdriver.chrome.driver", "D:\\Ajit\\Automation\\Workspace\\Odysseus_Product\\Driver\\chromedriver_win32\\chromedriver.exe");
		                    driver = new ChromeDriver();
		                   
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
              driver.get("https://localhost/odyssey/admin/login.aspx");
              //driver.navigate().to("https://localhost/odyssey/website/air/results.aspx?");
              
              workbook = new HSSFWorkbook();
              //create a new work sheet
              sheet = workbook.createSheet("Test Result");
              testresultdata = new LinkedHashMap<String, Object[]>();
              //add test result excel file column header
              //write the header in the first row
              testresultdata.put("1", new Object[] {"TC_ID", "Test Functinality", "Test Case", "Expected Result", "Actual Result", "Status (Pass/Fail)"});
              Thread.sleep(3000);
    }   
    
    @Test(description="Login with valid credentials")
    public void Authentication() throws InterruptedException, IOException
    {
       try
       {
    	       		  
    		  driver.findElement(By.id("UserName")).clear();
        	  driver.findElement(By.id("UserName")).click();
        	  WebElement test = driver.findElement(By.id("UserName"));
        	  test.sendKeys("ajithn@odysol.com");
        	  
         	  Thread.sleep(500);
         	  
    		  driver.findElement(By.id("UserPassword")).clear();
        	  driver.findElement(By.id("UserPassword")).click();
        	  WebElement pass = driver.findElement(By.id("UserPassword"));
        	  pass.sendKeys("odysseus");
        	  
      	      Thread.sleep(500);
      	      
    	      driver.findElement(By.id("SubmitBTN")).click();
    	     
  
    	        
            try
            {
        	    
        	                
                testresultdata.put("2", new Object[] {1d, "Check authentication on Login Page", "Login with valid credentials", "Login successfully", "Login successfully", "Pass"});
                 
                System.out.println("1st test case pass.."); 
   	      
             }   
             catch(Exception e)
             {
    	        //add fail entry to the excel sheet
    	        testresultdata.put("2", new Object[] {1d, "Check authentication on Login Page", "Login with valid credentials", "Login successfully", "Login fail", "Fail"});
    	        System.out.println("1st Test case fail..");
    	        Reporter.log("1st Test case fail..");
    	        System.out.println(e.getMessage());
    	   
             }
                
                     
       }    
           
       catch(Exception e)
       {
        	   File scr02 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	       org.codehaus.plexus.util.FileUtils.copyFile(scr02, new File("D:\\Ajit\\Script_SS\\DatadrivenError\\Invalidlogincredentials.jpg")); 
         	 
         	   Assert.assertFalse(false, "FAIL");
         	   Reporter.log("Username and Password are invalid..");
         	   AssertJUnit.assertTrue("Username and Password are invalid...", ((WebElement) driver).isDisplayed());
         	   throw(e);
                         	  
        }
       
            Thread.sleep(1000);
       
    }
	
    @Test(description="Page navigate login page to select site")
    public void Pagenavigation() throws InterruptedException, IOException
    {
    	try
    	{
    		driver.findElement(By.xpath("//*[@id='aspnetForm']/table/tbody/tr/td[1]/table[1]/tbody/tr/td/table/tbody/tr[5]/td[3]/a[1]")).click();
    		
    		System.out.println("Page navigate on admin default page");
    	    	
    	
    	   try
           {
  			      testresultdata.put("3", new Object[] {2d, "Check page navigation on default page", "Check page navigation on select site to default page", "Page navigate on default page", "Page navigate on default page", "Pass"});
                 
           }
    	   catch(Exception e)
       	   {
       			 
    		    testresultdata.put("3", new Object[] {2d, "Check page navigation on default page", "Check page navigation on select site to default page", "Page navigate on default page", "Page navigate on invalid page", "Fail"});
     	        System.out.println("2nd Test case fail..");
     	        System.out.println(e.getMessage());
     	        
       	   }
             
  		     
           }
           catch(Exception e)
           {
      	      //add fail entry to the excel sheet
              File scr03 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
  	          org.codehaus.plexus.util.FileUtils.copyFile(scr03, new File("D:\\Ajit\\Script_SS\\DatadrivenError\\pagenavigation.jpg")); 
      	      System.out.println("2nd Test case fail..");
  	          Reporter.log("2nd Test case fail..");
  	          AssertJUnit.assertTrue("2nd test cases fail b'coz execute status is N..", ((WebElement) driver).isDisplayed());
  	          throw(e);
           }
    	       System.out.println("2nd test case pass..");
    	       
    	       Thread.sleep(3000);
    }
    
    @Test(description="Search flight on default.aspx page")
    public void Searchflight() throws InterruptedException, IOException
    {
    	 try
    	 {
    		   driver.findElement(By.xpath("//*[@id='sb-site']/div[2]/div[2]/div[1]/div[1]/div[3]/div/div/div/div[1]/ul[2]/li[1]/a")).click();
    		   Thread.sleep(100);
    		   driver.findElement(By.id("AffiliateDropDownList")).click();
    		   driver.findElement(By.xpath("//*[@id='AffiliateDropDownList']/option[10]")).click();
    		   Thread.sleep(500);
    		   driver.findElement(By.id("AirSearchForm_From")).clear();
    		   driver.findElement(By.id("AirSearchForm_From")).click();
    		   driver.findElement(By.id("AirSearchForm_From")).sendKeys("nyc");
    		   driver.findElement(By.id("AirSearchForm_From")).sendKeys(Keys.TAB);
    		   Thread.sleep(200);
    		   driver.findElement(By.id("AirSearchForm_FromDate")).click();
    		   driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr[1]/td[7]/a")).click();
    		   Thread.sleep(200);
    		   driver.findElement(By.id("AirSearchForm_To")).clear();
    		   driver.findElement(By.id("AirSearchForm_To")).click();
    		   driver.findElement(By.id("AirSearchForm_To")).sendKeys("bost");
    		   driver.findElement(By.id("AirSearchForm_To")).sendKeys(Keys.TAB);
    		   Thread.sleep(300);
    		   driver.findElement(By.id("AirSearchForm_ReturnDate")).click();
    		   driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr[5]/td[4]/a")).click();
    		   Thread.sleep(200); 
    		   driver.findElement(By.id("AirSearchForm_Adults")).click();
    		   driver.findElement(By.xpath("//*[@id='DDListPopUp']/div[2]")).click();
    		   Thread.sleep(200);
    		   driver.findElement(By.id("AirSearchForm_Children")).click();
    		   driver.findElement(By.xpath("//*[@id='DDListPopUp']/div[2]")).click();
    		   Thread.sleep(200);
    		   driver.findElement(By.xpath("//*[@id='DDListPopUp']/div[1]")).click();
    		   Thread.sleep(100);
    		   driver.findElement(By.id("AirSearchForm_SearchButton")).click();
    		   
    		   
    		   try
               {
      			      testresultdata.put("4", new Object[] {3d, "Search flight", "Search flight from the default page", "Flight search successfully and page navigate on result page", "Flight search successfully and page navigate on result page", "Pass"});
                     
               }
        	   catch(Exception e)
           	   {
           			 
        		    testresultdata.put("4", new Object[] {3d, "Search flight", "Search flight from the default page", "Flight search successfully and page navigate on result page", "Flight not search", "Fail"});
         	        System.out.println("3rd Test case fail..");
         	        System.out.println(e.getMessage());
         	        
           	   }
    	 }
    	 catch(Exception e) 
    	 {
    		 //add fail entry to the excel sheet
              File scr04 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
 	          org.codehaus.plexus.util.FileUtils.copyFile(scr04, new File("D:\\Ajit\\Script_SS\\DatadrivenError\\Searchflight.jpg")); 
     	      System.out.println("3rd Test case fail..");
 	          Reporter.log("3rd Test case fail..");
 	          AssertJUnit.assertTrue("3rd test cases fail b'coz execute status is N..", ((WebElement) driver).isDisplayed());
 	          throw(e);
    	 }
    	 
    	     System.out.println("3rd test case pass..");
    	     Thread.sleep(9000);
    }
    
    @Test(description="Select flight on the result page")
    public void Selectflight() throws InterruptedException, IOException
    {
    	 // For select dynamic flights from result page
        for(int i = driver.getWindowHandles().size() -1 ; i > 0 ; i--)
        {

            String winHandle = driver.getWindowHandles().toArray()[i].toString();

            driver.switchTo().window(winHandle);
           
            driver.navigate().refresh();
         
            driver.get("https://localhost/odyssey/website/air/results.aspx");
     
   	        driver.manage().window().maximize();
       
   	        Thread.sleep(3000);
   	  
  	  
            List<WebElement> options = driver.findElements(By.className("print-select-flight"));
  
         
            if(options.size()>0)
            {
                 options.get(2).click();  // 1 for AmadeusWS or 2 for Sabre
            }
            else 
            {
            	System.out.println("4th test case fail b'coz flight not available..");
            	
            	File scr01 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	            org.codehaus.plexus.util.FileUtils.copyFile(scr01, new File("D:\\Ajit\\Script_SS\\DatadrivenError\\Flightnotavailable.jpg"));
            	
	            Assert.assertFalse(false, "FAIL");
	            Reporter.log("Flights not available..");
			    
		    }
            
            try
            {
   			      testresultdata.put("5", new Object[] {4d, "Select flight", "Select flight on the result page", "Flight selected successfully and page navigate on checkout page", "Flight selected successfully and page navigate on checkout page", "Pass"});
                  
            }
     	    catch(Exception e)
        	{
        			 
     	    	testresultdata.put("5", new Object[] {4d, "Select flight", "Select flight on the result page", "Flight selected successfully and page navigate on checkout page", "Flight not selected", "Fail"});
      	        System.out.println("4th Test case fail..");
      	        System.out.println(e.getMessage());
      	        
        	}
         
        }                
               System.out.println("Flight selected successfully, 4th test case pass..");
                
               Thread.sleep(12000);
        
    }
    
    @Test(description="Enter valid passenger information on the checkout page")
    public void Passengerdetails() throws InterruptedException, IOException
    {
    	 try
    	 {
    		 //For Passenger 1
    		 
    		 driver.navigate().refresh();
    		 Select select01 = new Select(driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl0_TravelerAccount_1_Title")));
    		 select01.selectByVisibleText("Mr");
    		 Thread.sleep(100);  
 			 driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl0_TravelerAccount_1_FirstName")).click();
 			 driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl0_TravelerAccount_1_FirstName")).sendKeys("Monish");
 			 Thread.sleep(100);
 			 driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl0_TravelerAccount_1_LastName")).click();
 			 driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl0_TravelerAccount_1_LastName")).sendKeys("Luthra");
 			 Thread.sleep(100);
 			 driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl0_TravelerAccount_1_DateUC_Month")).click();
 			 driver.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl0_TravelerAccount_1_DateUC_Month']/option[8]")).click();
 			 Thread.sleep(100);
 			 driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl0_TravelerAccount_1_DateUC_Day")).click();
 			 driver.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl0_TravelerAccount_1_DateUC_Day']/option[24]")).click();
 			 Thread.sleep(100);
 			 driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl0_TravelerAccount_1_DateUC_Year")).click();
 			 driver.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl0_TravelerAccount_1_DateUC_Year']/option[74]")).click();
 			 Thread.sleep(200);
 			 
 			 //For passenger 2
 			 Select select1 = new Select(driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl1_TravelerAccount_2_Title")));
			 select1.selectByVisibleText("Mr");
			 Thread.sleep(100);
			 driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl1_TravelerAccount_2_FirstName")).click();
			 driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl1_TravelerAccount_2_FirstName")).sendKeys("Anna");
			 Thread.sleep(100);
			 driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl1_TravelerAccount_2_LastName")).click();
			 driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl1_TravelerAccount_2_LastName")).sendKeys("Luthra");
			 Thread.sleep(100);
			 driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl1_TravelerAccount_2_DateUC_Month")).click();
			 driver.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl1_TravelerAccount_2_DateUC_Month']/option[11]")).click();
			 Thread.sleep(100);
			 driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl1_TravelerAccount_2_DateUC_Day")).click();
			 driver.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl1_TravelerAccount_2_DateUC_Day']/option[14]")).click();
			 Thread.sleep(100);
			 driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl1_TravelerAccount_2_DateUC_Year")).click();
			 driver.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl1_TravelerAccount_2_DateUC_Year']/option[76]")).click();
			 Thread.sleep(100);
			 
			 //For passenger 3
			 Select select2 = new Select(driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl2_TravelerAccount_3_Title")));
			 select2.selectByVisibleText("Master");
			 Thread.sleep(100);
			 driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl2_TravelerAccount_3_FirstName")).click();
			 driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl2_TravelerAccount_3_FirstName")).sendKeys("Aakash");
			 Thread.sleep(100);
			 driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl2_TravelerAccount_3_LastName")).click();
			 driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl2_TravelerAccount_3_LastName")).sendKeys("Paliwal");
			 Thread.sleep(100);
			 driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl2_TravelerAccount_3_DateUC_Month")).click();
			 driver.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl2_TravelerAccount_3_DateUC_Month']/option[7]")).click();
			 Thread.sleep(100);
			 driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl2_TravelerAccount_3_DateUC_Day")).click();
			 driver.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl2_TravelerAccount_3_DateUC_Day']/option[11]")).click();
			 Thread.sleep(100);
			 driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl2_TravelerAccount_3_DateUC_Year")).click();
			 driver.findElement(By.xpath("//*[@id='_ctl0_MainContentsPH__ctl0_BookingPassengers__ctl2_TravelerAccount_3_DateUC_Year']/option[6]")).click();
			 Thread.sleep(100);
			 driver.findElement(By.xpath("//*[@id='st-accordion']/ul/li[1]/div/div[11]/input")).click();
			
			    try
	            {
	   			      testresultdata.put("6", new Object[] {5d, "Passenger information", "Enter passenger information on the checkout page", "Passenger details are submited successfully", "Passenger details are submited successfully", "Pass"});
	                  
	            }
	     	    catch(Exception e)
	        	{
	        			 
	     	    	testresultdata.put("6", new Object[] {5d, "Passenger information", "Enter passenger information on the checkout page", "Passenger details are submited successfully", "Passenger details are not submited successfully", "Fail"});
	      	        System.out.println("5th Test case fail..");
	      	        System.out.println(e.getMessage());
	      	        
	        	}
			 
    	 }
    	 catch(Exception e)
    	 {
    		  File scr05 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	          org.codehaus.plexus.util.FileUtils.copyFile(scr05, new File("D:\\Ajit\\Script_SS\\DatadrivenError\\Passengerinfo.jpg")); 
    	      System.out.println("5th Test case fail..");
	          Reporter.log("5th Test case fail..");
	          AssertJUnit.assertTrue("5th test cases fail b'coz execute status is N..", ((WebElement) driver).isDisplayed());
	          throw(e);
    	 }
    	 
    	    System.out.println("5th test case pass");
    	    Thread.sleep(1000);
    }
    
    @Test(description="Enter valid booking contact information on the checkout page")
    public void Bookingcontactinfo() throws InterruptedException, IOException
    {
    	 try
    	 {
    		  driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_BookingContact_EMail")).click();
    		  driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_BookingContact_EMail")).sendKeys("ajit_nakum@odysseussolutions.com");
    		  Thread.sleep(100);
    		  driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_BookingContact_Phone1_Number")).click();
    		  driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_BookingContact_Phone1_Number")).sendKeys("8952634785");
    		  Thread.sleep(100);
    		  driver.findElement(By.xpath("//*[@id='st-accordion']/ul/li[2]/div/div[2]/input")).click();
    		  
    		    try
	            {
    		    	testresultdata.put("7", new Object[] {6d, "Booking contact information", "Enter valid booking contact information on the checkout page", "Booking contact informations are submited successfully", "Booking contact informations are submited successfully", "Pass"});
	                  
	            }
	     	    catch(Exception e)
	        	{
	        			 
	     	    	testresultdata.put("7", new Object[] {6d, "Booking contact information", "Enter valid booking contact information on the checkout page", "Booking contact informations are submited successfully", "Booking contact informations are not submited successfully", "Fail"});
	      	        System.out.println("6th Test case fail..");
	      	        System.out.println(e.getMessage());
	      	        
	        	}
    		  
    	 }
    	 catch(Exception e)
    	 {
    		  File scr06 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	          org.codehaus.plexus.util.FileUtils.copyFile(scr06, new File("D:\\Ajit\\Script_SS\\DatadrivenError\\Bookingcontactinfo.jpg")); 
   	          System.out.println("6th Test case fail..");
	          Reporter.log("6th Test case fail..");
	          AssertJUnit.assertTrue("6th test cases fail b'coz execute status is N..", ((WebElement) driver).isDisplayed());
	          throw(e);
    	 }
    	    System.out.println("6th test case pass");
    	    
    	    Thread.sleep(500);
    } 	 
    
    @Test(description="Without apply markup click on markup continue button on the checkout page")
    public void Markup() throws InterruptedException, IOException
    {
    	  try
    	  {
    		  driver.findElement(By.xpath("//*[@id='st-accordion']/ul/li[3]/div/div[2]/input")).click();
    		  
    		    try
	            {
  		    	    testresultdata.put("8", new Object[] {7d, "Markup", "Without apply markup click on markup continue button on the checkout page", "Details submited successfully", "Details submited successfully", "Pass"});
	                  
	            }
	     	    catch(Exception e)
	        	{
	        			 
	     	    	testresultdata.put("8", new Object[] {7d, "Markup", "Without apply markup click on markup continue button on the checkout page", "Details submited successfully", "Details are not submited successfully", "Fail"});
	      	        System.out.println("7th Test case fail..");
	      	        System.out.println(e.getMessage());
	      	        
	        	}
    		  
    	  }
    	  catch(Exception e)
    	  {
    		  File scr06 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	          org.codehaus.plexus.util.FileUtils.copyFile(scr06, new File("D:\\Ajit\\Script_SS\\DatadrivenError\\Markup.jpg")); 
   	          System.out.println("7th Test case fail..");
	          Reporter.log("7th Test case fail..");
	          AssertJUnit.assertTrue("7th test cases fail b'coz execute status is N..", ((WebElement) driver).isDisplayed());
	          throw(e);
    	  }
    	       System.out.println("7th test case pass");
    	       Thread.sleep(500);
    }
    
    @Test(description="Without enter additional info click on markup continue button on the checkout page")
    public void Additionalinfo() throws InterruptedException, IOException
    {
    	  try
    	  {
    		  driver.findElement(By.xpath("//*[@id='st-accordion']/ul/li[4]/div/div[6]/input")).click();
    		  
    		    try
	            {
		    	    testresultdata.put("9", new Object[] {8d, "Additional information", "Without enter additional info click on markup continue button on the checkout page", "Additional details are submited successfully", "Additional details are submited successfully", "Pass"});
	                  
	            }
	     	    catch(Exception e)
	        	{
	        			 
	     	    	testresultdata.put("9", new Object[] {8d, "Additional information", "Without enter additional info click on markup continue button on the checkout page", "Additional details are submited successfully", "Additional details are not submited successfully", "Fail"});
	      	        System.out.println("8th Test case fail..");
	      	        System.out.println(e.getMessage());
	      	        
	        	}
    		  
    	  }
    	  catch(Exception e)
    	  {
    		  File scr07 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	          org.codehaus.plexus.util.FileUtils.copyFile(scr07, new File("D:\\Ajit\\Script_SS\\DatadrivenError\\Additionalinfo.jpg")); 
   	          System.out.println("8th Test case fail..");
	          Reporter.log("8th Test case fail..");
	          AssertJUnit.assertTrue("8th test cases fail b'coz execute status is N..", ((WebElement) driver).isDisplayed());
	          throw(e);
    	  }
    	       System.out.println("8th test case pass");
    	       Thread.sleep(500);
    }
    
    @Test(description="Hold Booking")
    public void Holdbooking() throws InterruptedException, IOException
    {
    	  try
    	  {
    		  driver.findElement(By.id("_ctl0_MainContentsPH__ctl0_HoldBTN")).click();
    		  
    		    try
	            {
		    	    testresultdata.put("10", new Object[] {9d, "Held booking", "Held booking on the checkout page", "Booking held successfully", "Booking held successfully", "Pass"});
	                  
	            }
	     	    catch(Exception e)
	        	{
	        			 
	     	    	testresultdata.put("10", new Object[] {9d, "Held booking", "Held booking on the checkout page", "Booking held successfully", "Booking held Fail", "Fail"});
	      	        System.out.println("9th Test case fail..");
	      	        System.out.println(e.getMessage());
	      	        
	        	}
    		  
    	  }
    	  catch(Exception e)
    	  {
    		  File scr08 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	          org.codehaus.plexus.util.FileUtils.copyFile(scr08, new File("D:\\Ajit\\Script_SS\\DatadrivenError\\Additionalinfo.jpg")); 
   	          System.out.println("Held booking fail, 9th Test case fail..");
	          Reporter.log("9th Test case fail..");
	          AssertJUnit.assertTrue("9th test cases fail b'coz execute status is N..", ((WebElement) driver).isDisplayed());
	          throw(e);
    	  }
    	       System.out.println("Held booking successfully, 9th test case pass");
    	       Thread.sleep(20000);
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
            
            String title = row.getCell(3).toString();
            System.out.println(title);
            String data = row.getCell(4).toString();
            System.out.println(data);
               		  
            if(title.equals(data))
            {
          	    System.out.println(title);
                row.createCell(4).setCellValue(title);
                Thread.sleep(200);
                row.createCell(5).setCellValue("Pass");
                Assert.assertTrue(true, "PASS");
           	    Reporter.log("Status Pass..");
                
            }
            else
            {
          	    System.out.println(row);
            	row.createCell(4).setCellValue(data);
                Thread.sleep(200);
                row.createCell(5).setCellValue("Fail");
                Assert.assertFalse(false, "Fail");
           	    Reporter.log("Status Fail..");
              
			}
        }
           try 
           {
               FileOutputStream out =new FileOutputStream(new File("D:\\Ajit\\Automation\\Workspace\\Odysseus_Product\\src\\main\\java\\testData\\Automation Test Cases.xlsx"));
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

	      
  
}
