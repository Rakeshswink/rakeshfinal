package tesngsuite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class or_text {
	@Test
	  @Parameters({"url","path"})
	  public void f(String url,String path) 
	  {
		  System.setProperty("Webdriver.chrome.driver",path);
		  ChromeDriver driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		  driver.get(url);
		 String ExpectedString=("OR");
		  String ActualText = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/form/div/div[4]/span")).getText();
		  System.out.println("Expected text is"+" " +ExpectedString);
		  System.out.println("Actual text is"+" " +ActualText);
		  
	  
		  if(ActualText.equals(ExpectedString))
		 {
			  System.out.println("Test case passed");
		 }
		 else
		  {
			  System.out.println("testcase failed not matched");
			  Assert.fail();
			  
		  }	  
	  }
}