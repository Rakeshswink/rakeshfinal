package forgetmpin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class submitbtn_enabled_or_not 
{

	@Test
	  @Parameters({"url","path"})
	  public void f(String url,String path) throws InterruptedException 
	  {
			System.setProperty("Webdriver.chrome.driver",path);
			  ChromeDriver driver=new ChromeDriver();
			  driver.manage().window().maximize();
			  driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
			  driver.get(url);
			  Thread.sleep(2000);
			  driver.findElement(By.xpath("//*[@id=\"signin-phone\"]")).clear();
			  Thread.sleep(3000);
			  driver.findElement(By.xpath("//*[@id=\"signin-phone\"]")).sendKeys("6133322211");
			  driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/form/div/div[3]/a")).click();
			  Thread.sleep(3000);
		      boolean btnstatus = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/form/div/button")).isEnabled();
		      Thread.sleep(2000);
		      if(btnstatus==true)
			  {
				  System.out.println("Testcase passed");
				  System.out.println("Test case passed expected status is"+btnstatus);
				 
				  
			  }
			  else
			  {
				  System.out.println("Testcase failed");
				  System.out.println("actual status is text is"+btnstatus);
			
				  Assert.fail();
			  }
	}
	  }


