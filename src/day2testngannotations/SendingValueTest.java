package day2testngannotations;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class SendingValueTest {
	WebDriver driver;
  @Test
  public void f() throws Exception {
	  JavascriptExecutor js= (JavascriptExecutor)driver;
	  js.executeScript("document.getElementsByName('q')[0].value='TestNG Annotations';");
	  Thread.sleep(3000);
	  File img=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(img,new File("E:\\NAZIA\\Infosys\\jqueryss.png"));
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nazia\\Documents\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://www.google.com/");
	  driver.manage().window().maximize();
     
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
