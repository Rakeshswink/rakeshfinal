package tesngsuite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class userinputvalidatation_alphabets {

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

		  driver.findElement(By.xpath("//*[@id=\"signin-phone\"]")).sendKeys("abcdefyyy");
		  WebElement value=driver.findElement(By.xpath("//*[@id=\"signin-phone\"]"));
		  driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/form/div/button")).click();
		   String maxlength=value.getAttribute("maxlength");
		   System.out.println("max value"+maxlength);
		   int mlength=Integer.parseInt(maxlength);
		   String usrlength=value.getAttribute("value");
		   int ulength=usrlength.length();
		   
		  
		  
		  if(0==ulength)
		  {
			  System.out.println("not accepted characted in userinput field for username");
			  
		  }
		  else
		  {
			  System.out.println("testcase fialed allowing characters");
			  Assert.fail();
		  }
}
}