package forgetmpin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class forget_mpin_link_validation 
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
		  driver.findElement(By.xpath("//*[@id=\"signin-phone\"]")).sendKeys("9034217848");
		  String Expectedurl="https://sandbox.swinkpay-fintech.com/mosv1/forgot-password";
		  boolean isdisplayedstatus= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/form/div/div[3]/a")).isDisplayed();
		  boolean isenabledstatus= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/form/div/div[3]/a")).isEnabled();
		  driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/form/div/div[3]/a")).click();
		  Thread.sleep(3000);
		  String Currenturl=driver.getCurrentUrl();
		  if(Expectedurl.equals(Currenturl))
		  {
			  System.out.println("Test cases passed navigate to proper url");
			  System.out.println("actual url is"+" "+Currenturl);
			  System.out.println("expected url is"+" "+Expectedurl);
	       }
		  else
		  {
			  System.out.println("Test cases Failed navigate to incorrect url");
			  System.out.println("actual url is"+" "+Currenturl);
			  System.out.println("expected url is"+" "+Expectedurl);
			  Assert.fail();

		  }
}
}
