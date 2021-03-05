package dataprovider;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeMethod;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class ExtentReportTest {
	WebDriver driver;
	ExtentReports report;
	ExtentTest test;
	
  @Test
  public void f() {
	  report=new ExtentReports("E:\\NAZIA\\Infosys\\report.html");
	  test=report.startTest("ExtentReportTest");
	  if(driver.getTitle().equals("WebDriver | Popups & Alerts"))
	  {
		  test.log(LogStatus.PASS, "Title Matched Status is Passed");
	  }
	  else
	  {
		  test.log(LogStatus.FAIL, "Title Not Matched Status is Failed");
	  }
	  
  }
  @BeforeMethod
  public void beforeMethod() throws Exception {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nazia\\Documents\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://webdriveruniversity.com/Popup-Alerts/index.html");
	  driver.manage().window().maximize();
	  Thread.sleep(3000);
	  File img=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(img,new File("E:\\NAZIA\\Infosys\\ss1.png"));
  }

  @AfterMethod
  public void afterMethod() {
	  report.endTest(test);
	  report.flush();
	  driver.quit();
  }

}
