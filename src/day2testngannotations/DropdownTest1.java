package day2testngannotations;

import static org.junit.Assert.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownTest1 {
	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Nazia\\Documents\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() throws Exception {
		Thread.sleep(3000);
		driver.quit();
	}

	@Test
	public void test() throws Exception {
		WebElement web_element_drop_down=driver.findElement(By.id("dropdowm-menu-1"));
		Select dropdown=new Select(web_element_drop_down);
		dropdown.selectByValue("java");
		Thread.sleep(3000);
		WebElement web_element_drop_down2=driver.findElement(By.id("dropdowm-menu-2"));
		Select dropdown2=new Select(web_element_drop_down2);
		dropdown2.selectByVisibleText("TestNG");;
		Thread.sleep(3000);
		WebElement web_element_drop_down3=driver.findElement(By.id("dropdowm-menu-3"));
		Select dropdown3=new Select(web_element_drop_down3);
		dropdown3.selectByIndex(2);
		File img=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(img,new File("E:\\NAZIA\\Infosys\\jqueryss.png"));
		Thread.sleep(3000);
	}

}
