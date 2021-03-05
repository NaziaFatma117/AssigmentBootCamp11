package assertions;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class ExcelTest {
	WebDriver driver;
	
  @Test
  public void f() throws Exception {
	  File file=new File("E:\\NAZIA\\Infosys\\Data.xlsx");
	  FileInputStream fis=new FileInputStream(file);
	  XSSFWorkbook book=new XSSFWorkbook(fis);
	  XSSFSheet sheet1=book.getSheet("Sheet1");
	  int lastrow=sheet1.getLastRowNum();
	  for(int i=1;i<=lastrow;i++)
	  {
		  String firstname=sheet1.getRow(i).getCell(0).getStringCellValue();
		  String lastname=sheet1.getRow(i).getCell(1).getStringCellValue();
		  String emailid=sheet1.getRow(i).getCell(2).getStringCellValue();
		  String comment=sheet1.getRow(i).getCell(3).getStringCellValue();
		  driver.findElement(By.name("first_name")).sendKeys(firstname);
		  driver.findElement(By.name("last_name")).sendKeys(lastname);
		  driver.findElement(By.name("email")).sendKeys(emailid);
		  driver.findElement(By.name("message")).sendKeys(comment);
		  File img=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(img,new File("E:\\NAZIA\\Infosys\\ss4.png"));
		  driver.findElement(By.xpath("/html/body/div[1]/div/div/section/div/div[2]/form/div/input[2]")).click();
		  Thread.sleep(3000);
		  Set<String> wh=driver.getWindowHandles();
		  for(String s: wh)
		  {
			  driver.switchTo().window(s);
			  if(driver.getCurrentUrl().equals("https://webdriveruniversity.com/Contact-Us/contact-form-thank-you.html"))
			  {
				  Row row=sheet1.getRow(i);
				  Cell cell=row.createCell(4);
				  cell.setCellValue("Passed");
			  }
		  }
		  driver.navigate().back();
		  Thread.sleep(3000);
		  driver.navigate().refresh();
		  Thread.sleep(3000);
	  }
	  FileOutputStream fos=new FileOutputStream(file);
	  book.write(fos);
	  book.close();
	  
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

}
