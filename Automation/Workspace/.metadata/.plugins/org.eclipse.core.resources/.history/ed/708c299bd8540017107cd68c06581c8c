package Implementation;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Utility.OdysolAirUtils;


public class AdmindefaultpageTest 
{
	   Login lgnpge;
	   private static RemoteWebDriver driver;

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
			                    System.setProperty("webdriver.chrome.driver", "D:\\Ajit\\Driver\\chromedriver_win32\\chromedriver.exe");
			                    driver = new ChromeDriver();
			                   
		                 }  
		                 else if (browser.equalsIgnoreCase("IE")) 
		                 {
			                   System.setProperty("webdriver.ie.driver", "D:\\Ajit\\Driver\\IEDriverServer_Win32_2.53.0\\IEDriverServer.exe");
			                // driver = new InternetExplorerDriver();
			                   
		                 } 

	        } catch (WebDriverException e) 
	          {
		                   System.out.println(e.getMessage());
	          }
	           
	               driver.manage().window().maximize();
	               driver.get("https://localhost/odyssey/admin/login.aspx");
	               //driver.navigate().to("https://localhost/odyssey/website/air/results.aspx?");
	               Thread.sleep(4000);
	               lgnpge = PageFactory.initElements(driver, Login.class);
	               
	    }
	    
	    @Test(dataProvider="Authentication")
	    public void login_data1(String sUsername, String sPassword, String FromLocation, String ToLocation, String Firstname_Of_Adult1, String Middlename_of_Adult1, String Lastname_Of_Adult1, String Firstname_Of_Adult2, String Middlename_of_Adult2, String Lastname_Of_Adult2, String Firstname_Of_Adult3, String Middlename_of_Adult3, String Lastname_Of_Adult3, String Email, String Phone_No, String CardHolderName, String CardNo, String CardCvvNo, String Address, String City, String Zipcode, String Phone_Number, String BankName) throws Exception
	    {
	      try
	      {
             System.out.println("sUsername: " + sUsername);
	         System.out.println("sPassword: " + sPassword);
	                     
	         lgnpge.LoginToTittle(sUsername, sPassword);
	                
	         Thread.sleep(2000);
	       
	     //    Assert.assertEquals("Username is:-" +Uname+"Should be ajithn@odysol.com",Uname,"ajithn@odysol.com");
	         
	         System.out.println("Page title verified:- User login successfully");
	      }   
	      catch(Exception e)
	      {
	        	  File scr02 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		          org.codehaus.plexus.util.FileUtils.copyFile(scr02, new File("D:\\Ajit\\Script_SS\\Error\\Invalidcredentials.jpg")); 
	        	 
	        	  Assert.assertFalse(false, "FAIL");
	        	  Reporter.log("Username and Password are invalid..");
	           	  AssertJUnit.assertTrue("Username Or Password are invalid...", lgnpge.isDisplayed());
	           	  throw(e);
	      }    
	      
	      try
	      {
	            //For E-Ticket from Manage(Admin)
	            driver.findElement(By.xpath("//*[@id='gridOld']/div[2]/table/tbody/tr[5]/td[1]/a")).click();
	            driver.findElement(By.xpath("//*[@id='trans_old_128291_123339']/td/div/div/a[5]")).click();
	            
	            Thread.sleep(3000);
	            driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
	            WebElement elmt = driver.findElement(By.id("_ctl0_MainContent_StatusSEL"));
	            elmt.click();
	            driver.findElement(By.xpath("//*[@id='_ctl0_MainContent_StatusSEL']/option[8]")).click();
	            driver.findElement(By.id("_ctl0_MainContent_SubmitBTN")).click();
	            driver.switchTo().defaultContent();
	            Thread.sleep(2000);
	           // driver.navigate().refresh();
	            
	      }
	      catch(Exception e)
	      {
	    	     Reporter.log("Status Ticketed fail..");
	    	  
	    	     File scr8 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		         org.codehaus.plexus.util.FileUtils.copyFile(scr8, new File("D:\\Ajit\\Script_SS\\Error\\FailedStatusETickets.jpg"));
		         
		         driver.findElement(By.xpath("/html/body/div[6]/div[1]/button/span[1]")).click();
		         AssertJUnit.assertTrue("Status fail for E-Ticketed...", lgnpge.isDisplayed());
		         
	      }
	      
	      //For Check condition E-Ticketed
	      String status3 = driver.findElement(By.xpath("//*[@id='gridOld']/div[2]/table/tbody/tr[1]/td[2]/strong")).getText(); 
	            
	      if(status3.toLowerCase().trim().matches("ticketed"))
	      {
	     	    System.out.println("Status Pass..");
	     	    Assert.assertTrue(true, "PASS");
	     	    Reporter.log("Status Pass..");
	      }
	      else
	      {
				System.out.println("Status Fail..");
								
				File scr8 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			    org.codehaus.plexus.util.FileUtils.copyFile(scr8, new File("D:\\Ajit\\Script_SS\\Error\\ETicketedstatusfailed.jpg"));
			 
			    Assert.assertFalse(false, "FAIL");
			    Reporter.log("Ticketed status:- FAIL");
			    System.out.println("Booking ticketed fail..");
			    driver.findElement(By.xpath("/html/body/div[6]/div[1]/button/span[1]")).click();
				     
		     }
	     
	            System.out.println("Actual status is:- "+ status3);
	            Reporter.log("Actual status is:- " + status3);
	                  
	            File scr4 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	            org.codehaus.plexus.util.FileUtils.copyFile(scr4, new File("D:\\Ajit\\Script_SS\\HeldConfirmAndTicketed\\Confirmflight.jpg"));
	                   
	            Thread.sleep(5000);
	            
	                      
	            //For Cancel booking
	            driver.get("https://ui.odysol.com/admin/default.aspx");
	            driver.navigate().refresh();
	            driver.manage().window().maximize();
	            
	            Thread.sleep(4000);
	      try
	      {
	    	    driver.findElement(By.className("manage_btn")).click();
	    	    Thread.sleep(200);
	    	    driver.findElement(By.xpath("//a[@class='cancel_icon show_True']")).click();
	    	    driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
	      	    WebElement elm = driver.findElement(By.id("_ctl0_MainContent_CancelBookingBTN"));
	    	    elm.click();
	    	    Alert alert=driver.switchTo().alert();
	    	    alert.accept();
	    	    driver.switchTo().defaultContent();
	    	    Thread.sleep(6000);
	    	    driver.navigate().refresh();
	      }catch(Exception e)
	      {
	    	     File scr8 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		         org.codehaus.plexus.util.FileUtils.copyFile(scr8, new File("D:\\Ajit\\Script_SS\\Error\\FailedCancel.jpg"));
		               
		         Assert.assertFalse(false, "FAIL");
		         Reporter.log("Booking cancel failed...");
		         AssertJUnit.assertTrue("Booking cancel failed...", lgnpge.isDisplayed());
			     return;
		         
	      }
	             Thread.sleep(7000);
	             
	             // For the verify cancel condition
	             String status2 = driver.findElement(By.xpath("//*[@id='gridOld']/div[2]/table/tbody/tr[1]/td[2]/strong")).getText(); 
	                               
	             if(status2.toLowerCase().trim().matches("cancelled"))
	             {
	            	    System.out.println("Status Pass..");
	            	    Assert.assertTrue(true, "PASS");
	            	    Reporter.log("Status Pass..");
	             }
	             else
	             {
	    				 System.out.println("Status Fail..");
	    				 System.out.println("Actual status is:- "+ status2);
	    				
	    				 File scr8 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    		         org.codehaus.plexus.util.FileUtils.copyFile(scr8, new File("D:\\Ajit\\Script_SS\\Error\\CancelStatusFailed.jpg"));
	    		               
	    		         Reporter.log("Actual status is:- " + status2);
	    		         Assert.assertFalse(false, "FAIL");
	    		         Reporter.log("Cancel status fail..");
	    		         AssertJUnit.assertTrue("Cancel Status Fail...", lgnpge.isDisplayed());
	    			     return;
	    	     }
	            
	               System.out.println("Actual status is:- "+ status2);
	               Reporter.log("Actual status is:- " + status2);
	             
	               File scr3 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	               org.codehaus.plexus.util.FileUtils.copyFile(scr3, new File("D:\\Ajit\\Script_SS\\HeldConfirmAndTicketed\\Cancelbooking.jpg"));
	             
	               System.out.println("Booking cancelled successfully..");
	             
	               Reporter.log("Booking cancelled successfully..");
	            
	               Thread.sleep(4000);
	    
	      
	    }
	    
	    @DataProvider
	    public String[][] Authentication() throws Exception
	    {
	    	 
		     String[][] testObjArray = OdysolAirUtils.getTableArray("D:\\Ajit\\Automation\\Workspace\\Odysseus_Product\\src\\main\\java\\testData\\OdysolAirData.xlsx","Sheet1");
		     return testObjArray;
		     
	    }
	
}
