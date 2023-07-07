package tesngsuite;

import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Loadurl {
  @Test
  @Parameters({"url","path"})
  public void f(String url,String path) 
  {
	  System.setProperty("Webdriver.chrome.driver",path);
	  ChromeDriver driver=new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	  driver.get(url);
	  String URL = driver.getCurrentUrl();
  
	  if(URL.equals("https://sandbox.swinkpay-fintech.com/mosv1/signin?redirectUrl=/"))
	  {
		  System.out.println("Test case passed");
	  }
	  else
	  {
		  System.out.println("testcase failed not matched");
		   Assert.fail();
		  
	  }	  
  }
}
