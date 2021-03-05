package day2testngannotations;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class ResultsListTest {
	WebDriver driver;
  @Test
  public void f() throws Exception {
	  driver.findElement(By.name("q")).sendKeys("Selenium");
	  File img=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(img,new File("E:\\NAZIA\\Infosys\\jqueryss.png"));
	  Thread.sleep(3000);
	  WebElement we=driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[2]/div[1]/div[2]/div[2]/ul"));
	  List<WebElement> list=driver.findElements(By.tagName("li"));
	  List<WebElement> list2=driver.findElements(By.tagName("span"));
	  System.out.println("List Size: "+(list.size()-8));
	  for(WebElement s:list2)
	  {
	     if(s.getText().equals("selenium"))
	     {
	    	 s.click();
	    	 break;
	     }
	  }
	  
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nazia\\Documents\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://www.google.com/");
	  driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() throws Exception {
	  Thread.sleep(3000);
	  driver.quit();
  }

}
