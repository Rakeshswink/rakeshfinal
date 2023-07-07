package forgetmpin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class mpin_and_confirm_mpin_validation {                
	@Test
	  @Parameters({"url","path"})
	  public void f(String url,String path) throws InterruptedException            //without pin click on login
	  {
		  System.setProperty("Webdriver.chrome.driver",path);
		  ChromeDriver driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		  driver.get(url);
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//*[@id=\"signin-phone\"]")).clear();
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//*[@id=\"signin-phone\"]")).sendKeys("9034217848");
		  driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/form/div/div[3]/a")).click();
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//*[@id=\"mpin\"]")).sendKeys("2255");
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/form/div/button")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/form/div/button")).click();
		  Thread.sleep(2000);
		  
		  driver.findElement(By.xpath("//*[@id=\"mpin\"]")).sendKeys("2255");
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//*[@id=\"confirmmpin\"]")).sendKeys("2455");
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/form/div/button")).click();
		  Thread.sleep(1000);
		  String actualerrortxt=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/form/div/div[2]/div/div")).getText();
		 String expectedtext="New MPIN and Confirm MPIN does not match.";
		 if(actualerrortxt.equals(expectedtext))
		 {
			  System.out.println("Testcase passed");
			  System.out.println("expected text is"+expectedtext);
			  System.out.println("actual text is"+actualerrortxt);
		 }
		  else
		  {
			  System.out.println("Test case failed");
			  System.out.println("expected text is"+expectedtext);
			  System.out.println("actual text is"+actualerrortxt);
			  
			  Assert.fail();
		  }
		  
  }
}
