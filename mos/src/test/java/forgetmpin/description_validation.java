package forgetmpin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class description_validation {
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
		  String expectedtext="We have sent an OTP to your Mobile 91*******211.\n"
		  		+ "The OTP received is valid for 15 minutes.\n"
		  		+ "Kindly verify before the OTP becomes invalid.";
		  String actualtext=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[1]/p")).getText();
		  if(actualtext.equals(expectedtext))
		  {
			  System.out.println("Testcase passed");
			  System.out.println("expected text is"+" "+expectedtext);
			  System.out.println("actual text is"+" "+actualtext);
		  }
		  else
		  {
			  System.out.println("Testcase Failed");
			  System.out.println("Expected text is"+" "+expectedtext);
			  System.out.println("actual text is"+" "+actualtext);
			  Assert.fail();
			  
		  }
	  }
		  
}
