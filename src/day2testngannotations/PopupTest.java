package day2testngannotations;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class PopupTest {
	WebDriver driver;
  @Test
  public void f() throws Exception {
	  driver.findElement(By.id("button1")).click();
	  Thread.sleep(3000);
	  String title=driver.switchTo().alert().getText();
	  System.out.println(title);
	  driver.switchTo().alert().accept();
	  Thread.sleep(3000);
	  driver.switchTo().window(driver.getWindowHandle());
	  driver.findElement(By.id("button4")).click();
	  Thread.sleep(3000);
	  String title2=driver.switchTo().alert().getText();
	  System.out.println(title);
	  driver.switchTo().alert().accept();
	  Thread.sleep(3000);
	  driver.switchTo().window(driver.getWindowHandle());
	  driver.findElement(By.id("button4")).click();
	  Thread.sleep(3000);
	  String title3=driver.switchTo().alert().getText();
	  System.out.println(title);
	  driver.switchTo().alert().dismiss();
	  Thread.sleep(3000);
	  driver.switchTo().window(driver.getWindowHandle());
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nazia\\Documents\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://webdriveruniversity.com/Popup-Alerts/index.html");
	  driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() throws Exception {
	  Thread.sleep(3000);
	  driver.quit();
  }

}
