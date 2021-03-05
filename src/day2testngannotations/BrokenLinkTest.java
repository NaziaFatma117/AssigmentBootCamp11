package day2testngannotations;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class BrokenLinkTest {
	WebDriver driver;
  @Test
  public void f() {
	  List<WebElement> tags=driver.findElements(By.tagName("a"));
	  for(WebElement s:tags)
	  {
		  String url=s.getAttribute("href");
		  System.out.println("URL: "+url);
		  if(url==null || url.isEmpty())
		  {
			  System.out.println("Empty Url");
		  }
		  else if(!url.startsWith("https://www.zlti.com"))
		  {
			  System.out.println("Url belongs to another page");
		  }
		  else
		  {
			  try
			  {
				  HttpURLConnection huc=(HttpURLConnection)(new URL(url).openConnection());
				  huc.setRequestMethod("HEAD");
				  huc.connect();
				  if(huc.getResponseCode()==400)
				  {
					  System.out.println("Broken Link");
				  }
				  else
				  {
					  System.out.println("Valid Link");
				  }
				  
			  }
			  catch(Exception e)
			  {
				  System.out.println(e.getMessage());
			  }
		  }
	  }
  }
  @BeforeMethod
  public void beforeMethod() throws Exception {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nazia\\Documents\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://www.zlti.com/");
	  driver.manage().window().maximize();
	  File img=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(img,new File("E:\\NAZIA\\Infosys\\ss7.png"));
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
