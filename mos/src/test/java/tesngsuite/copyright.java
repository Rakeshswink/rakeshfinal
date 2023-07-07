package tesngsuite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class copyright {
	  @Test
	  @Parameters({"url","path"})
	  public void f(String url,String path) 
	  {
		  System.setProperty("Webdriver.chrome.driver",path);
		  ChromeDriver driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		  driver.get(url);
		 String ExpectedString=("© Copyright 2023. All Rights Reserved.");
		  String ActualText = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/footer/div/span")).getText();
		  System.out.println(ActualText);
		  
	  
		  if(ActualText.equals(ExpectedString))
		 {
			  System.out.println("Test case passed");
			  System.out.println("actual text"+" "+ActualText);
			  System.out.println("actual text"+" "+ExpectedString);
		 }
		 else
		  {
			  System.out.println("testcase failed not matched");
			  System.out.println("actual text"+" "+ActualText);
			  System.out.println("actual text"+" "+ExpectedString);
			  Assert .fail();
			  
		  }	  
	  }
}
