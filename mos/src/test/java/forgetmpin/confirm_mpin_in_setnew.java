package forgetmpin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class confirm_mpin_in_setnew 
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
		  driver.findElement(By.xpath("//*[@id=\"signin-phone\"]")).sendKeys("9034217848");
		  driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/form/div/div[3]/a")).click();
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//*[@id=\"mpin\"]")).sendKeys("2255");
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/form/div/button")).click();
		  Thread.sleep(2000);
		  String actualtext=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/form/div/div[2]/label")).getText();
		  String Expectedtxt="Confirm MPIN";
		  if(actualtext.equals(Expectedtxt))
				  {
			  System.out.println("Testcase passed");
			  System.out.println("expected text is"+Expectedtxt);
			  System.out.println("actual text is"+actualtext);
				  }
		  else
		  {
			  System.out.println("Testcase Failed");
			  System.out.println("expected text is"+Expectedtxt);
			  System.out.println("actual text is"+actualtext);
			  Assert.fail();
		  }
			  
	  }        
 
}
