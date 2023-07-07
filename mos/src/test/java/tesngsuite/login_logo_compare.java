package tesngsuite;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class login_logo_compare {
	 @Test
	  @Parameters({"path","url"})
	  public void f(String path,String url) throws InterruptedException, IOException 
	  {
		  System.setProperty("WebDriver.chrome.driver", path);
		 ChromeDriver driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		 driver.get(url);
		 Thread.sleep(3000);
	     WebElement getscreenshotimg= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div[2]/div[1]/img"));
	     
	     
	   // Capture the screenshot of the logo element
	     
	     File file=getscreenshotimg.getScreenshotAs(OutputType.FILE);
	    
	
	// Define the destination file path to save the logo image
	
	    String destinationFilePath ="D:/compare/logo/logo.png";
	    FileHandler.copy(file, new File(destinationFilePath));
		System.out.println("stored successfully");
		
		// Define the paths of the two files to compare
        String actualfilepath = "D:/compare/logo/logo.png";
        String expectedfilepath = "D:/compare/logoactual/logo.png";
        
        
		
		//compare
        File file1 = new File(actualfilepath);
        File file2 = new File(expectedfilepath);
        
        boolean isSame = FileUtils.contentEquals(file1, file2);

        if (isSame) 
        {
            System.out.println("The files are identical.");
        }
        else 
        {
            System.out.println("The files are different.");
        }
		
	
		
		
		
		 
 }
}