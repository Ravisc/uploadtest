package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utility.captureScreenshot;




public abstract class BaseTest implements AutoConst{
	public WebDriver driver;
	
//	ExtentHtmlReporter htmlReporter;
   public ExtentReports extent;
   public  ExtentTest test;
    
    
	
	
	
    
	@BeforeTest
	public void setExtent(){
		
		  
	//        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/MyOwnReport.html");
	        extent = new ExtentReports(System.getProperty("user.dir") +"/test-output/ExtentReport.html",true);
	     //   extent.attachReporter(htmlReporter);
	        
	        extent.addSystemInfo("OS", "Mac Sony");
	        extent.addSystemInfo("Host Name", "sony");
	        extent.addSystemInfo("Environment", "QA");
	        extent.addSystemInfo("User Name", "Ravi");
	    
	       	}
	
	@AfterTest
	public void testDown()
	
    {
		
			extent.flush();
		//	extent.close();
			
    }
	
	
	        @BeforeMethod
	    	public void precondition(){
		
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		//System.setProperty(GECKO_KEY, GECKO_VALUE);
		driver=new ChromeDriver();
		//driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost");
				
	}

	
	
	@AfterMethod
	public void getResult(ITestResult result) throws Exception {
		
        if(result.getStatus() == ITestResult.FAILURE)
        {
            test.log(LogStatus.FAIL, " Test case FAILED due to below issues:"+result.getName()+result.getThrowable());
          //  test.fail(result.getThrowable());
         String screenshotpath=  captureScreenshot.takeScreenShot(driver,result.getName());
         test.log(LogStatus.FAIL,  test.addScreenCapture(screenshotpath));
         
            
            
            
        }
        else if(result.getStatus() == ITestResult.SUCCESS)
        {
            test.log(LogStatus.PASS, " Test Case PASSED"+result.getName());
        }
        else
        {
            test.log(LogStatus.SKIP," Test Case SKIPPED"+result.getName());
            
        }
        
        extent.endTest(test);
	//	driver.quit();
    }
	
	//public void postcondition(){
	//	extent.endTest(test);
	//	driver.quit();
	//}
}
