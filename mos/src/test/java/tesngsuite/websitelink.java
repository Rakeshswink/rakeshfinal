package tesngsuite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class websitelink {
	@Test
	  @Parameters({"url","path"})
	  public void f(String url,String path) throws InterruptedException 
	  {
		  System.setProperty("Webdriver.chrome.driver",path);
		  ChromeDriver driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		  driver.get(url);
		 
		  
		  String Expectedurl="https://www.swinkpay-fintech.com/";
		  boolean isdisplayedstatus= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/footer/div/div/a[1]")).isDisplayed();
			 boolean isenabledstatus= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/footer/div/div/a[1]")).isEnabled();
		  driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/footer/div/div/a[1]")).click();
		 
		  Thread.sleep(3000);
		  String Currenturl=driver.getCurrentUrl();
		  
		 if((isenabledstatus==true)&&((isdisplayedstatus==true)&&(Currenturl.equals(Expectedurl))))
		  
		 {
			  System.out.println("validation for visible and enabled is passed");
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
