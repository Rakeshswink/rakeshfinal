package siginwithotp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class signin_btn_textvalidation {
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
		  
		 String expectedtxt="Sign In";
		  driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/form/div/div[5]/a")).click();
		  Thread.sleep(2000);
		  WebElement btn=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/form/div/button"));
		  String btntext=btn.getText();
		  if(btntext.equals("Sign In"))
		  {
			  System.out.println("Testcase passed");
			  System.out.println("Test case passed expected text is"+expectedtxt);
			  System.out.println("Test case passed actual text is"+btntext);
			  
		  }
		  else
		  {
			  System.out.println("Testcase failed");
			  System.out.println(" expected text is"+expectedtxt);
			  System.out.println(" actual text is"+btntext);
			  Assert.fail();
		  }
}
}
