package Transaction_list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.TimeUnit;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Transactionlist_columns 
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
		  List<String> actual=new ArrayList<String>();
		  List<String> listexpected=new ArrayList<String>();
		  listexpected.add("Terminal ID");
		  listexpected.add("Original Transaction ID");
		  listexpected.add("Transaction ID");
		  listexpected.add("RRN/UTR");
		  listexpected.add("Amount");
		  listexpected.add("Date & Time");
		  listexpected.add("Status");
		  listexpected.add("Refunded for Transaction ID");
		  listexpected.add("Action");
		  listexpected.add("Description");

		  driver.findElement(By.xpath("//*[@id=\"signin-phone\"]")).sendKeys("9034217848");
		  
		  String Expectedurl="https://sandbox.swinkpay-fintech.com/mosv1/verify/otp";
		  driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/form/div/div[5]/a")).click();
		  Thread.sleep(3000);
		  driver.findElement(By.xpath("//*[@id=\"mpin\"]")).sendKeys("2255");
		  driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/div[2]/form/div/button")).click();
		  Thread.sleep(3000);
		  System.out.println(driver.getCurrentUrl());
		  Thread.sleep(1000);
	      List<WebElement> listofdata= driver.findElements(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div/div/main/div/div/div/div[2]/div/div[2]/div[1]/table/thead/tr/th/div"));
	      int lstexpected=listexpected.size();
	      
	      
	      for(WebElement w:listofdata)
	      {
	    	  String replacedtext=w.getText();
	    	  String updatedtext=replacedtext.replaceAll("\n"," ");
	    	  actual.add(updatedtext);
	      }
	      int lstactual1=actual.size();
	      int lstexpected1=listexpected.size();
	      System.out.println(lstactual1);
	      System.out.println(lstexpected1);
	      
	      
	      if(listexpected.equals(actual)&&(lstactual1==lstexpected1))
	    		  {
	    	        System.out.println("Testcases passed");
	    	        System.out.println("actual list"+actual);
	  	    	    System.out.println("Expected list"+listexpected);
	    	        
	    		  }
	      else
	      {
	    	  System.out.println("Failed");
	    	  System.out.println("actual list"+actual);
	    	  System.out.println("Expected list"+listexpected);
	    	  Assert.fail();
	    	  
	      }
	 	  
	  }
}
