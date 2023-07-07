package mos;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NewTest {
  @Test
  
	  @Parameters("url")
	  public void f(String path) 
  {
	  System.setProperty("webdriver.chrome.driver",path);
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		driver.get("https://sandbox.swinkpay-fintech.com");
		
  }
}
