package tesngsuite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class test2 
{
	@Test
	@Parameters({"path","url"})
	public void test(String path, String url)
	{
		System.setProperty("webdriver.chrome.driver","D:\\drv\\chromedriver.exe");
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		driver.get(url);
		

}
}