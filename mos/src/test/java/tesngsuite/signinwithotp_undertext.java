package tesngsuite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class signinwithotp_undertext {
	  @Test
	  @Parameters({"url","path"})
	  public void f(String url,String path) 
	  {
		  System.setProperty("Webdriver.chrome.driver",path);
		  ChromeDriver driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		  driver.get(url);
		 String ExpectedString=("Enter Phone Number on top and\n"
		 		+ "click on sign In with OTP link");
		  String ActualText = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/form/div/p")).getText();
		  System.out.println(ActualText);
		  
	  
		  if(ActualText.equals(ExpectedString))
		 {
			  System.out.println("Test case passed");
			  System.out.println("expected text is"+ExpectedString);
			  System.out.println("actual text is"+ActualText);
			  
		 }
		 else
		  {
			 System.out.println("testcase failed");
			 System.out.println("expected text is"+ExpectedString);
			  System.out.println("actual text is"+ActualText);
			  
			  Assert.fail();
			  
		  }	  
	  }
}
