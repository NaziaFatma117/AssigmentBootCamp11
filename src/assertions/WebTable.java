package assertions;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class WebTable {
	WebDriver driver;
  @Test
  public void f() {
	  SoftAssert assertion=new SoftAssert();
	  WebElement table=driver.findElement(By.xpath("/html/body/table/tbody/tr[3]/td[2]/table[1]"));
	  List<WebElement> rows=table.findElements(By.tagName("tr"));
	  
	  for(int i=3;i<25;i++)
	  {
		  List<WebElement> cols=rows.get(i).findElements(By.tagName("td"));
		  double value=Double.valueOf(cols.get(2).getText());
		  System.out.println("Value1: "+value+" "+i);
		  for(int j=i+1;j<25;j++)
		  {
		   List<WebElement> cols2=rows.get(j).findElements(By.tagName("td")); 
		   System.out.println("Value2: "+cols2.get(2).getText() +" "+j);
		  if(value==(Double.valueOf(cols2.get(2).getText())))
		  {
			 
			 assertion.assertFalse(value==(Double.valueOf(cols2.get(2).getText())));
			 System.out.println("Same Pincodes for row number: "+i+" and "+j);
		  }
		   
		  }
	  }
	  assertion.assertAll();
  }
  @BeforeMethod
  public void beforeMethod() throws Exception {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nazia\\Documents\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("https://chennaiiq.com/chennai/pincode-by-name.php");
	  driver.manage().window().maximize();
	  File img=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(img,new File("E:\\NAZIA\\Infosys\\ss5.png"));
  }

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
