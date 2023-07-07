package profile;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class profile_dropdown 
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
		  
		  String Expectedurl="https://sandbox.swinkpay-fintech.com/mosv1/verify/otp";
		  driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/form/div/div[5]/a")).click();
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//*[@id=\"mpin\"]")).sendKeys("2255");
		  driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/form/div/button")).click();
		  Thread.sleep(3000);
		  System.out.println(driver.getCurrentUrl());
		  WebElement el=driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/header/div/div[2]/div/div/div/div/div/div"));
		  Thread.sleep(1000);
		  el.click();
		  List<WebElement> options =el.findElements(By.xpath("//*[@id=\"base-menu-2-QPA8gS8e2Y\"]"));
		  int size=  options.size();
		  System.out.println(size);
		  for (WebElement option : options)
		  {
		     System.out.println(option.getText());
		  }
		  
}
}

