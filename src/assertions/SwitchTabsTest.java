package assertions;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class SwitchTabsTest {
	WebDriver driver;
  @Test
  public void f() throws Exception {
	  driver.findElement(By.xpath("/html/body/div/div[1]/div/ul/li[2]/a")).click();
	  Thread.sleep(3000);
	  Set<String> wh=driver.getWindowHandles();
	  for(String s: wh)
	  {
		  driver.switchTo().window(s);
		  if(driver.getCurrentUrl().equals("http://openclinic.sourceforge.net/openclinic/medical/index.php"))
		  {
			  break;
		  }
	  }
	  driver.findElement(By.xpath("/html/body/div/div[3]/ul/li[2]/a")).click();
	  Set<String> wh2=driver.getWindowHandles();
	  for(String s: wh2)
	  {
		  driver.switchTo().window(s);
		  if(driver.getCurrentUrl().equals("http://openclinic.sourceforge.net/openclinic/medical/patient_search_form.php"))
		  {
			  break;
		  }
	  }
	  Thread.sleep(8000);
	  WebElement dropdown=driver.findElement(By.id("search_type"));
	  Select list=new Select(dropdown);
	  list.selectByValue("3");
	  File img=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(img,new File("E:\\NAZIA\\Infosys\\ss4.png"));
	  Thread.sleep(3000);
	  driver.findElement(By.id("search_patient")).click();
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nazia\\Documents\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("http://openclinic.sourceforge.net/openclinic/home/index.php");
	  driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
