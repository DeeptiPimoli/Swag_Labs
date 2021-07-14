package testNG;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pomWithPageFactory.Platform_Page;


public class PlatformTestNg {
WebDriver driver;
	
	static FileReader reader;
	static Properties property;
	
	static Platform_Page platformPageFactory;
	
	@BeforeClass
	  public void beforeClass() throws IOException 
	  {
		  System.out.println("Before");
			reader = new FileReader("C:\\Users\\Hp\\Desktop\\deepti\\Sprint2\\Configuration\\config.property");
			property=new Properties();
			property.load(reader);
			System.setProperty("webdriver.chrome.driver",property.getProperty("ChromeDriver"));
			
	      driver=new ChromeDriver();
	      driver.manage().window().maximize();
	      driver.get(property.getProperty("URL"));
	      driver.manage().timeouts().pageLoadTimeout(35, TimeUnit.SECONDS);
	      driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); 
	      platformPageFactory= new Platform_Page(driver);
	  }


	  @BeforeMethod
	  public void solutions() throws InterruptedException 
	  {
		  platformPageFactory.clickPlatform();
		  Thread.sleep(1000);
		  System.out.println("Solutions options");   
	  }

  @Test(priority=1)
  public void aboutPage() throws InterruptedException 
  {

      String expectedTitle2=property.getProperty("expectedTitle2");
		Thread.sleep(1000);
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(),expectedTitle2);
		System.out.println("-------Verified--------");
		
      
     System.out.println("The user is on About home page");
     
    
  }
  
  
  @Test(priority=3)
  public void overview() throws InterruptedException 
  {
	  platformPageFactory.clickOverview();
	  Thread.sleep(1000);
	  System.out.println("Overview options");   
  }
  
  @Test(priority=4)
  public void navigate() throws InterruptedException 
  {
	  driver.navigate().back();   
  }
  @Test(priority=5)
  public void crossBrowser() throws InterruptedException 
  {
	  platformPageFactory.clickCrossBrowser();
	  Thread.sleep(1000);
	  System.out.println("CrossBrowsers options"); 
  }
  
  @Test(priority=6)
  public void mobileTesting() throws InterruptedException 
  {
	  platformPageFactory.clickMobileTesting();
	  Thread.sleep(1000);
	  System.out.println("Mobile Testing options");  
  }
  @Test(priority=7)
  public void lowCodeTesting() throws InterruptedException 
  {
	  platformPageFactory.clickLowCodeTesting();
	  System.out.println("LowCode Testing options"); 
  }
  
  @Test(priority=8)
  public void errorReporting() throws InterruptedException 
  {
	  platformPageFactory.clickErrorReporting();
	 Thread.sleep(1000);
     System.out.println("Error Reporting options"); 
  }
 
  
  
  @AfterClass
  public void afterClass() 
  {
	  driver.quit();  
  }

}
