package tesngsuite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class usernamelength_validation 
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

			  driver.findElement(By.xpath("//*[@id=\"signin-phone\"]")).sendKeys("");
			  WebElement value=driver.findElement(By.xpath("//*[@id=\"signin-phone\"]"));
			  driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/form/div/button")).click();
			   String maxlength=value.getAttribute("maxlength");
			   System.out.println("max value"+maxlength);
			   int mlength=Integer.parseInt(maxlength);
			   String usrlength=value.getAttribute("value");
			   int ulength=usrlength.length();
			   
			   System.out.println("userlength"+ulength);
			  
			  if(mlength==ulength)
			  {
				  System.out.println("validation handled for max length");
				  
			  }
			  else if(0==ulength)
			  {
				  String errormsg=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/form/div/div[1]/div/div[2]")).getText();
				  if(errormsg.equals("This is Mandatory Field *"))
				  {
				  System.out.println("validation error message handled for empty length"+ " "+errormsg);
				  }
				  
			      else
			      {
			    	    System.out.println("validation not handled testcase failed for empty username");
				  		Assert.fail();
			      }
			  }
				  else if(ulength!=mlength)
				  {
					  String errormsg2=driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/form/div/div[1]/div/div[2]")).getText();
					  if(errormsg2.equals("Please enter 10 digits only"))
					  {
					  System.out.println("validation error message handled for incorrect length"+ " "+errormsg2);
					  }
					  else
					  {
						  System.out.println("validation not handled testcase failed if incorrect username");
					  	  Assert.fail();
					  }
				   }
			  }
			  
}


			  
		
  
