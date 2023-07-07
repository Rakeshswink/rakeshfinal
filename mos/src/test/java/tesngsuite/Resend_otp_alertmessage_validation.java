package tesngsuite;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Resend_otp_alertmessage_validation {
	
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
		  driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/form/div/div[2]/a")).click();
		  Thread.sleep(2000);
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		  WebElement toastEle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"__next\"]/div[2]/div[2]/div/main/div[2]/div/div/div/div[2]/div/div[2]/div[1]/div/div/pre/div/div[2]/code/span[33]")));
		  Alert alrt= driver.switchTo().alert();
		  Thread.sleep(3000);
		  
		String  actualalrtmsg=alrt.getText();
		System.out.println(actualalrtmsg);
		  //not executed need to check
		  }
}