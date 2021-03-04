package day2testngannotations;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
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
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nazia\\Documents\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("http://openclinic.sourceforge.net/openclinic/home/index.php");
	  driver.manage().window().maximize();
		
  }

  @AfterMethod
  public void afterMethod() throws Exception {
	  Thread.sleep(3000);	 
	  driver.quit();
  }

}
