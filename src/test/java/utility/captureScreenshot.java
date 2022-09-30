package utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class captureScreenshot {
	
//	public static WebDriver driver;
	
	public static String takeScreenShot(WebDriver driver,String screenshotname) throws Exception{
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String destination="D:\\screenshot test\\"+screenshotname+".png";
		File desc=new File(destination);
		FileUtils.copyFile(src, desc);
	//	System.out.println("screenshot taken");
		Reporter.log("screenshot taken",true);
		
		return destination;
	
	}

	

}
