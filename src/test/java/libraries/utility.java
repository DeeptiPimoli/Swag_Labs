package libraries;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class utility {
	
	public static WebDriver launchApplication(int browser,String baseUrl)
	{
		WebDriver driver;
		switch(browser) {
		  case 1:
			  System.setProperty("webdriver.chrome.driver","C:\\Software\\chromedriver.exe");
			  driver=new ChromeDriver();
			  break;
		  
	     case 2:
		      System.setProperty("webdriver.gecko.driver","C:\\Software\\geckodriver.exe");
		      driver=new ChromeDriver();
		      break;
		  
        case 3:
	          System.setProperty("webdriver.ie.driver","C:\\Software\\IE_driverServer.exe");
	          driver=new ChromeDriver();
	          break;

       default:
    	      System.setProperty("webdriver.chrome.driver","C:\\Software\\chromedriver.exe");
	          driver=new ChromeDriver();
	          break;
	   }
		driver.manage().window().maximize();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		return driver;
		
	}
	
public static void loginToApplication(WebDriver driver,String uName, String passwd)
{
	 driver.findElement(By.id("ctl00_MainContent_username")).sendKeys(uName);
	 driver.findElement(By.id("ctl00_MainContent_password")).sendKeys(passwd);
	 driver.findElement(By.className("button")).click();
     
}

	public static void captureScreenshot(WebDriver driver,String filename) throws IOException
	{
		  TakesScreenshot ts= (TakesScreenshot)driver;
	      File source =ts.getScreenshotAs(OutputType.FILE);
	      FileUtils.copyFile(source, new File(".\\Screenshots\\" + filename + ".png"));
	      
	}
	
	public static String getPageTitle(WebDriver driver)
	{
		return driver.getTitle();
	}
	public static void logout(WebDriver driver) 
	{
		driver.findElement(By.linkText("Logout")).click();
		driver.quit();
	}
	
    }
