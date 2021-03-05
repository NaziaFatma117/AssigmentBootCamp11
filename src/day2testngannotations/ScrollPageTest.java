package day2testngannotations;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class ScrollPageTest {
	WebDriver driver;
  @Test
  public void f() throws Exception {
	  JavascriptExecutor js=(JavascriptExecutor) driver;
	  Thread.sleep(3000);
	  js.executeScript("window.scrollBy(0,1000)");
	  File img=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(img,new File("E:\\NAZIA\\Infosys\\jqueryss.png"));
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nazia\\Documents\\chromedriver.exe");
	  driver=new ChromeDriver();
	  //driver.get("http://openclinic.sourceforge.net/openclinic/home/index.php");
	  driver.get("https://www.javatpoint.com/selenium-webdriver-scrolling-web-page");
	  driver.manage().window().maximize();
		
  }

  @AfterMethod
  public void afterMethod() throws Exception {
	  Thread.sleep(3000);	 
	  driver.quit();
  }

}
