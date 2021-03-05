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

public class GoogleAccountTest {
	WebDriver driver;
  @Test
  public void f() throws Exception {
	  driver.findElement(By.id("firstName")).sendKeys("abc");
	  driver.findElement(By.id("lastName")).sendKeys("xyz");
	  driver.findElement(By.id("username")).sendKeys("abc7778sel");
	  driver.findElement(By.name("Passwd")).sendKeys("abc@123456sel");
	  driver.findElement(By.name("ConfirmPasswd")).sendKeys("abc@123456sel");
	  File img=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(img,new File("E:\\NAZIA\\Infosys\\ss3.png"));
	  System.out.println("First Name: "+driver.findElement(By.id("firstName")).getAttribute("value"));
	  System.out.println("Last Name: "+driver.findElement(By.id("lastName")).getAttribute("value"));
	  System.out.println("First Name: "+driver.findElement(By.id("username")).getAttribute("value"));
	  driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/div/button")).click();
	  Thread.sleep(3000);
	 
	  
	  
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nazia\\Documents\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://accounts.google.com/signup/v2/webcreateaccount?flowName=GlifWebSignIn&flowEntry=SignUp");
	  driver.manage().window().maximize();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
