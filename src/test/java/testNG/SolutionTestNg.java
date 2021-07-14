package testNG;

import org.testng.annotations.Test;

import pomWithPageFactory.Solution_Page;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class SolutionTestNg {
	WebDriver driver;
	
	static FileReader reader;
	static Properties property;
	
	static Solution_Page solutionPageFactory;
	
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
	      solutionPageFactory= new Solution_Page(driver);
	  }


	  @BeforeMethod
	  public void solutions() throws InterruptedException 
	  {
		  solutionPageFactory.clickSolutions();
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
  public void enterprise() throws InterruptedException 
  {
	  solutionPageFactory.clickEnterprise();
	  Thread.sleep(1000);
	  System.out.println("Enterprise options");   
  }
  
  @Test(priority=4)
  public void navigate() throws InterruptedException 
  {
	  driver.navigate().back();   
  }
  @Test(priority=5)
  public void startups() throws InterruptedException 
  {
	  solutionPageFactory.clickStartupsSMBTeams();
	  Thread.sleep(1000);
	  System.out.println("Start-ups & SMB Teams options"); 
  }
  
  @Test(priority=6)
  public void openSourceProjects() throws InterruptedException 
  {
	  solutionPageFactory.clickOpenSourceProjects();
	  Thread.sleep(1000);
	  System.out.println("Open Source Projects options");  
  }
  @Test(priority=7)
  public void continuousTesting() throws InterruptedException 
  {
	  solutionPageFactory.clickContinuousTesting();
	  Thread.sleep(1000);
	  System.out.println("Continuous Testing options"); 
  }
  
  @Test(priority=8)
  public void automatedTesting() throws InterruptedException 
  {
	  solutionPageFactory.clickAutomatedTesting();
	 Thread.sleep(1000);
     System.out.println("Automated Testing options"); 
  }
  
  @Test(priority=9)
  public void liveTesting() throws InterruptedException 
  {
	  solutionPageFactory.clickLiveTesting();
	 Thread.sleep(1000);
	 System.out.println("Live Testing options");  
  }
  
  
  @AfterClass
  public void afterClass() 
  {
	  driver.quit();  
  }

}
