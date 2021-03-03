package day1seleniumframework;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class NewTest {
  @Test(dataProvider = "testdata")
  public void f(String u, String p) {
	  System.out.println("Inside Test Method");
	  System.out.println("Username: "+u);
	  System.out.println("Password: "+p);
	  Reporter.log("Log Messsage from test method f()");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Inside Before Method");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("Inside After Method");
  }


  @DataProvider(name="testdata")
  public Object[][] dp() {
    Object[][] ob=new Object[2][2];
    
    ob[0][0]="Username1";
    ob[0][1]="Password1";
    
    ob[1][0]="Username2";
    ob[1][1]="Password2";
    
    return ob;
  }
  @BeforeClass
  public void beforeClass() {
	  System.out.println("Inside Before Class");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("Inside After Class");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("Inside Before Test");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("Inside After Test");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Inside Before Suite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("Inside After Suite");
  }

}
