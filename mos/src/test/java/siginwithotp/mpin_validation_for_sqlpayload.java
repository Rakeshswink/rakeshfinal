package siginwithotp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class mpin_validation_for_sqlpayload 
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
		  driver.findElement(By.xpath("//*[@id=\"signin-phone\"]")).clear();
		  Thread.sleep(3000);

		  driver.findElement(By.xpath("//*[@id=\"signin-phone\"]")).sendKeys("6133322211");
		  
		  
		  driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/form/div/div[5]/a")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.xpath("//*[@id=\"mpin\"]")).sendKeys("><*,");
		  String value=driver.findElement(By.xpath("//*[@id=\"mpin\"]")).getAttribute("value");
		  Thread.sleep(2000);
		  
		  System.out.println(value);
		  if(value.equals("><*,"))
		  {
			  System.out.println("failed allowing special character");	
			  
		  }
		  else
		  {
			
			  System.out.println("passed not allowing special character");
			  
		  }
}
}
  

