package day2testngannotations;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;

public class DragandDropTest {
	WebDriver driver;
  @Test
  public void f() throws Exception {
	  Thread.sleep(3000);
	  WebElement frame=driver.findElement(By.className("demo-frame"));
	  driver.switchTo().frame(frame);
	  WebElement drag=driver.findElement(By.xpath("/html/body/div[1]"));
	  Thread.sleep(3000);
	  WebElement drop=driver.findElement(By.xpath("/html/body/div[2]"));
	  Actions action=new Actions(driver);
	  action.dragAndDrop(drag, drop).build().perform();
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nazia\\Documents\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://jqueryui.com/droppable/");
	  driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() throws Exception {
	  Thread.sleep(3000);
	  driver.quit();
  }

}
