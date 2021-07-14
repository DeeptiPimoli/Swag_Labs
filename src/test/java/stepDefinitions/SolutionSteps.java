package stepDefinitions;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pomWithPageFactory.Solution_Page;

	public class SolutionSteps 
	{
		
		WebDriver driver;
//		String baseUrl="https://saucelabs.com/";
		
		static FileReader reader;
		static Properties property;
		
		static Solution_Page solutionPageFactory;
		

        @Before("@Solution")
		public void launchApplication() throws IOException 
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
		
		

		
		@Given("user should be on About home Page")
		public void user_should_be_on_About_home_Page() throws InterruptedException, IOException 
		{
	        
	       String expectedTitle2=property.getProperty("expectedTitle2");
		   Thread.sleep(4000);
		   System.out.println(driver.getTitle());
		   Assert.assertEquals(driver.getTitle(),expectedTitle2);
		   System.out.println("-------Verified--------");
			
	       System.out.println("The user is on About home page");
	       
	  	  
		}
		
		@When("user clicks Solutions options")
		public void user_clicks_Solutions_options() throws InterruptedException 
		{
//			driver.findElement(By.linkText("Solutions")).click();
			solutionPageFactory.clickSolutions();
			Thread.sleep(5000);
		    System.out.println("Solutions options"); 
		}

		@Then("user should be able to view various solutions")
		public void user_should_be_able_to_view_various_solutions() 
		{
		    System.out.println("The user is able to view various solutions");
		}

		@Then("user clicks on Enterprise link")
		public void user_clicks_on_Enterprise_link() throws InterruptedException
		{
//			driver.findElement(By.linkText("Enterprise")).click();
			solutionPageFactory.clickEnterprise();
			Thread.sleep(5000);
		    System.out.println("Enterprise options"); 
		}

		@Then("user should be on Enterprise page")
		public void user_should_be_on_Enterprise_page() 
		{
			System.out.println("The user is on Enterprise page");
		}
		
		@Then("user should go back to About home page")
		public void user_should_go_back_to_About_home_page() 
		{
		    driver.navigate().back();
		}

		
		@Then("user clicks on Start-ups & SMB Teams link")
		public void user_clicks_on_Start_ups_SMB_Teams_link() throws InterruptedException 
		{
//			driver.findElement(By.linkText("Start-ups & SMB Teams")).click();
			solutionPageFactory.clickStartupsSMBTeams();
			Thread.sleep(5000);
		    System.out.println("Start-ups & SMB Teams options"); 
		}

		@Then("user should be on Start-ups & SMB Teams page")
		public void user_should_be_on_Start_ups_SMB_Teams_page() 
		{
			System.out.println("The user is on Start-ups & SMB Teams page");
		}

		

		@Then("user clicks on Open Source Projects link")
		public void user_clicks_on_Open_Source_Projects_link() throws InterruptedException 
		{
//			driver.findElement(By.linkText("Open Source Projects")).click();
			solutionPageFactory.clickOpenSourceProjects();
			Thread.sleep(5000);
		    System.out.println("Open Source Projects options"); 
		}

		@Then("user should be on Open Source Projects page")
		public void user_should_be_on_Open_Source_Projects_page() 
		{
			System.out.println("The user is on Open Source Projects page");
		}

		

		@Then("user clicks on Continuous Testing link")
		public void user_clicks_on_Continuous_Testing_link() throws InterruptedException 
		{
//			driver.findElement(By.linkText("Continuous Testing")).click();
			solutionPageFactory.clickContinuousTesting();
			Thread.sleep(5000);
		    System.out.println("Continuous Testing options"); 
		}

		@Then("user should be on Continuous Testing page")
		public void user_should_be_on_Continuous_Testing_page() 
		{
			System.out.println("The user is on Continuous Testing page");
		}



		@Then("user clicks on Automated Testing link")
		public void user_clicks_on_Automated_Testing_link() throws InterruptedException 
		{
//			driver.findElement(By.linkText("Automated Testing")).click();
			solutionPageFactory.clickAutomatedTesting();
			Thread.sleep(5000);
		    System.out.println("Automated Testing options"); 
		}

		@Then("user should be on Automated Testing page")
		public void user_should_be_on_Automated_Testing_page() 
		{
			System.out.println("The user is on Automated Testing page");
		}

		

		@Then("user clicks on Live Testing link")
		public void user_clicks_on_Live_Testing_link() throws InterruptedException 
		{
//			driver.findElement(By.linkText("Live Testing")).click();
			solutionPageFactory.clickLiveTesting();
			Thread.sleep(5000);
		    System.out.println("Live Testing options"); 
		}

		@Then("user should be on Live Testing page")
		public void user_should_be_on_Live_Testing_page()
		{
			System.out.println("The user is on Testing  page");
		}

		@Then("user Closes the browser")
		public void user_Closes_the_browser() 
		{
//			driver.quit();
			System.out.println("Browser is closed");
		}
		
		@After("@Solution")
		public void closeBrowser() 
		{
		    driver.quit();  
		}
		

	}
