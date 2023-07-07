package tesngsuite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class forgetmpin_link_validation 
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
	  
	 if((isenabledstatus==true)&&((isdisplayedstatus==true)&&(Currenturl.equals(Expectedurl))))
	  
	 {
		  System.out.println("validation for visible,enabled and url matched testcase is passed");
		  System.out.println("is link visible status is" +" "+isdisplayedstatus);
		  System.out.println("is link enabled status is" +" "+isenabledstatus);
		  System.out.println("is link current url is" +" "+Currenturl);
		  System.out.println("is link current url is" +" "+Expectedurl);
	 }
	
	 else
	 {
		 System.out.println("testcase failed");
		 System.out.println("is link visible status is" +" "+isdisplayedstatus);
		 System.out.println("is link enabled status is" +" "+isenabledstatus);
		 System.out.println("is link current url is" +" "+Currenturl);
		 System.out.println("is link current url is" +" "+Expectedurl);
		 Assert.fail();
	 }
}
}
