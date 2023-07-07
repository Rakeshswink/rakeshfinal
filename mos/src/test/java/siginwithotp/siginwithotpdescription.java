package siginwithotp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class siginwithotpdescription 
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
		  
		  String Expectedurl="We have sent an OTP to your Mobile 91*******211.\n"
		  		+ "The OTP received is valid for 15 minutes.\n"
		  		+ "Kindly verify before the OTP becomes invalid.";
		  driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/form/div/div[5]/a")).click();
		  Thread.sleep(2000);
		  String  ActualText=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[1]/p")).getText();
		  
	  
		  if(ActualText.equals(Expectedurl))
		 {
			  System.out.println("Test case passed");
			  System.out.println("Expected text is"+" " +Expectedurl);
			  System.out.println("Actual text is"+" " +ActualText);
		 }
		 else
		  {
			  System.out.println("testcase failed not matched");
			  System.out.println("Expected text is"+" " +Expectedurl);
			  System.out.println("Actual text is"+" " +ActualText);
			  Assert.fail();
			  
		  }	  
		  driver.quit();
	  }

 
  }

