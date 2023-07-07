package tesngsuite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class login_image_display {
  @Test
  @Parameters({"path","url"})
  public void f(String path,String url) throws InterruptedException 
  {
	  System.setProperty("WebDriver.chrome.driver", path);
	 ChromeDriver driver=new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	 driver.get(url);
	 Thread.sleep(3000);
	 boolean isdisplayed=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[1]/img")).isDisplayed();
	 boolean isenbld=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[1]/img")).isEnabled();
	 if(isdisplayed==true)
	 {
		 System.out.println("Test case passed is dispyaed status is"+isdisplayed);
     }
	 else
	 {
		 System.out.println("Testcase failed is displayed status is"+isdisplayed);
		
		 
	     Assert.fail();
	  
  }
}
}