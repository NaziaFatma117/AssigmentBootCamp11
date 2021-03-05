package day2testngannotations;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class BrowserSizeTest {
	WebDriver driver;
  @Test
  public void f() throws Exception {
	  driver.get("http://openclinic.sourceforge.net/openclinic/home/index.php");
	  Thread.sleep(3000);
	  driver.manage().window().maximize();
	  File img=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(img,new File("E:\\NAZIA\\Infosys\\ss8.png"));
	  Thread.sleep(3000);
  }
  @Test
  public void f2() throws Exception {
	  driver.get("http://openclinic.sourceforge.net/openclinic/home/index.php");
	  Dimension d1=new Dimension(100,50);
	  Thread.sleep(3000);
	  driver.manage().window().setSize(d1);
	  File img=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(img,new File("E:\\NAZIA\\Infosys\\ss9.png"));
	  Thread.sleep(3000);
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nazia\\Documents\\chromedriver.exe");
	  driver=new ChromeDriver();
	  
	  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
