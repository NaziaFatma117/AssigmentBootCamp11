package day2testngannotations;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class PropertyTest {
	WebDriver driver;
	File file=new File("E:\\NAZIA\\Infosys\\WorkSpace_Ass_Batch11\\SeleniumFrameworkSetup\\Configs\\Configuration.properties");
	FileInputStream fis=null;
  @Test
  public void f() {
	  System.out.println("Inside Test");
	  
  }
  @BeforeMethod
  public void beforeMethod() throws Exception {
	  fis=new FileInputStream(file);
	  Properties prop=new Properties();
	  prop.load(fis);
	  System.setProperty(prop.getProperty("driver"), prop.getProperty("driverpath"));
	  driver=new ChromeDriver();
	  Thread.sleep(3000);
	  driver.get(prop.getProperty("url"));
  }

  @AfterMethod
  public void afterMethod() throws Exception {
	  Thread.sleep(3000);
	  driver.quit();
  }

}
