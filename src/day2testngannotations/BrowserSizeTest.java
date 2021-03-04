package day2testngannotations;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.Dimension;
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
	  Thread.sleep(3000);
  }
  @Test
  public void f2() throws Exception {
	  driver.get("http://openclinic.sourceforge.net/openclinic/home/index.php");
	  Dimension d1=new Dimension(100,50);
	  Thread.sleep(3000);
	  driver.manage().window().setSize(d1);
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
