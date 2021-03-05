package dataprovider;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class NewTest {
	WebDriver driver;
  @Test(dataProvider = "formdetails")
  public void f(String firstname,String lastname,String emailid,String comments) throws Exception {
	  driver.findElement(By.name("first_name")).sendKeys(firstname);
	  Thread.sleep(3000);
	  driver.findElement(By.name("last_name")).sendKeys(lastname);
	  Thread.sleep(3000);
	  driver.findElement(By.name("email")).sendKeys(emailid);
	  Thread.sleep(3000);
	  driver.findElement(By.name("message")).sendKeys(comments);
	  Thread.sleep(3000);
	  File img=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(img,new File("E:\\NAZIA\\Infosys\\ss2.png"));
	  driver.findElement(By.xpath("/html/body/div[1]/div/div/section/div/div[2]/form/div/input[2]")).click();
	  Thread.sleep(3000);
	  
    }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nazia\\Documents\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://webdriveruniversity.com/Contact-Us/contactus.html");
	  driver.manage().window().maximize();
	  
	  
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }


  @DataProvider(name="formdetails")
  public Object[][] dp() {
	  Object[][] ob=new Object[2][4];
	  ob[0][0]="John";
	  ob[0][1]="Dsouza";
	  ob[0][2]="j@xyz.com";
	  ob[0][3]="Good resource";
	  
	  ob[1][0]="Mary";
	  ob[1][1]="Mathew";
	  ob[1][2]="mary@xyz.com";
	  ob[1][3]="Reliable Demos";
	  
	  
	  return ob;
	  

  }
}
