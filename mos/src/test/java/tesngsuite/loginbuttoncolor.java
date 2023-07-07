package tesngsuite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class loginbuttoncolor 
{
	  @Test
	  @Parameters({"path","url"})
	  public void f(String path,String url) throws InterruptedException 
	  {
		  System.setProperty("WebDriver.chrome.driver", path);
		 ChromeDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		 driver.get(url);
		 Thread.sleep(3000);
		WebElement el= driver.findElement(By.cssSelector("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/form/div/button"));
		 WebElement el2=driver.findElement(By.className("button bg-blue-600 hover:bg-blue-500 active:bg-blue-700 text-white radius-round h-11 px-8 py-2 w-full"));
		String color=el2.getCssValue("background-color");
		System.out.println(color);
	  }
}
