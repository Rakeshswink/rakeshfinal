package Transaction_list;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class duration_dropdownvalues 
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
				  Thread.sleep(1000);
				  WebElement ele=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/main/div/div/div/div[2]/div/div[1]/div/div[1]/div/div"));
		          Select s=new Select(ele);
		         List<WebElement> lst=driver.findElements(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/main/div/div/div/div[2]/div/div[1]/div/div[1]/div/div"));
		         s.selectByValue("Yesterday");
				 }

}
