package assertions;

import org.testng.annotations.Test;

import com.google.common.io.Files;

import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.apache.commons.io.*;

public class Screenshot {
	WebDriver driver;
  @Test
  public void f() throws Exception {
	  File img=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(img,new File("E:\\NAZIA\\Infosys\\jqueryss.png"));
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nazia\\Documents\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://api.jquery.com/dblclick/");
	  driver.manage().window().maximize();
	 
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }
  

}
