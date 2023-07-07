package siginwithotp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class empty_mpin_validation {
	@Test
	  @Parameters({"url","path"})
	  public void f(String url,String path) throws InterruptedException 
	  {
		System.setProperty("Webdriver.chrome.driver",path);
		  ChromeDriver driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		  driver.get(url);
		  driver.findElement(By.xpath("//*[@id=\"signin-phone\"]")).clear();
		  Thread.sleep(3000);

		  driver.findElement(By.xpath("//*[@id=\"signin-phone\"]")).sendKeys("6133322211");
		  
		  
		  driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/form/div/div[5]/a")).click();
		  Thread.sleep(2000);
		 String expectederror="This is Mandatory Field *";
		  String value=driver.findElement(By.xpath("//*[@id=\"mpin\"]")).getAttribute("value");
		  driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/form/div/button")).click();
		  Thread.sleep(1000);
		  String valuetxt=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/form/div/div[1]/div/div")).getText();
		  
		 
		  if(valuetxt.equals(expectederror))
		  {
			  System.out.println("Testcase passed");
			  System.out.println("Expected text is"+expectederror);
			  System.out.println("Actualtext is"+valuetxt);
			  
			 
		  }
		  else
		  {
			
			  System.out.println("Testcase failed not showing error message");
			  System.out.println("Expected text is"+expectederror);
			  System.out.println("Actualtext is"+valuetxt);
			  
			  Assert.fail();
			  
			  
		  }
	  }
}
