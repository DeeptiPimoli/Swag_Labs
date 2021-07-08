package stepDefinitions;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pomWithPageFactory.platformPage;


public class platform 
{
	WebDriver driver;
	String baseUrl="https://saucelabs.com/";

	platformPage PF;

	@Given("user should be on About Home Page")
	public void user_should_be_on_About_Home_Page() throws InterruptedException 
	{
		String expectedTitle="Solutions,Platform,Pricing,Resources,Company,Contacts";
		Thread.sleep(4000);
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(),expectedTitle);
		System.out.println("-------Verified--------");
		
		System.setProperty("webdriver.chrome.driver","C:\\Software\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        
       System.out.println("The user is on About home page");
	  
       PF=new platformPage(driver);
	}
	
	@When("user clicks Platform options")
	public void user_clicks_Platform_options() throws InterruptedException 
	{
		driver.findElement(By.linkText("Platform")).click();
		Thread.sleep(3000);
	    System.out.println("Platform options"); 
	}

	@Then("user should be able to view various Platform options")
	public void user_should_be_able_to_view_various_Platform_options() 
	{
		System.out.println("The user is able to view Platform options");
	}

	@Then("user clicks on Overview link")
	public void user_clicks_on_Overview_link() throws InterruptedException 
	{
		driver.findElement(By.linkText("Overview")).click();
		Thread.sleep(3000);
	    System.out.println("Overview options");
	}

	@Then("user should be on Overview page")
	public void user_should_be_on_Overview_page() 
	{
		System.out.println("The user is able to view Overview page");
	}

	@Then("user should go back to About Home page")
	public void user_should_go_back_to_About_home_page() 
	{
	    driver.navigate().back();
	}

	@Then("user clicks on Mobile Testing link")
	public void user_clicks_on_Mobile_Testing_link() throws InterruptedException 
	{
		driver.findElement(By.linkText("Mobile Testing")).click();
		Thread.sleep(3000);
	    System.out.println("Mobile Testing options");
	}

	@Then("user should be on Mobile Testing page")
	public void user_should_be_on_Mobile_Testing_page() 
	{
		System.out.println("The user is able to view Mobile Testing page");
	}

	
	@Then("user clicks on Cross-browser Testing link")
	public void user_clicks_on_Cross_browser_Testing_link() throws InterruptedException 
	{
		driver.findElement(By.linkText("Cross-browser Testing")).click();
		Thread.sleep(3000);
	    System.out.println("Cross-browser Testing options");
	}

	@Then("user should be on Cross-browser Testing page")
	public void user_should_be_on_Cross_browser_Testing_page()
	{
		System.out.println("The user is able to view Cross-browser Testing page");
	}
	
	@Then("user clicks on API Testing link")
	public void user_clicks_on_API_Testing_link() throws InterruptedException
	{
		driver.findElement(By.linkText("API Testing")).click();
		Thread.sleep(3000);
	    System.out.println("API Testing options");
	}

	@Then("user should be on API Testing page")
	public void user_should_be_on_API_Testing_page() 
	{
		System.out.println("The user is able to view API Testing page");
	}


	
	@Then("user clicks on Low-code Testing link")
	public void user_clicks_on_Low_code_Testing_link() throws InterruptedException
	{
		driver.findElement(By.linkText("Low Code Testing")).click();
		Thread.sleep(3000);
	    System.out.println("Low Code Testing options");
	}

	@Then("user should be on Low-code Testing page")
	public void user_should_be_on_Low_code_Testing_page() 
	{
		System.out.println("The user is able to view Low Code Testing page");
	}

	

	@Then("user clicks on Visual Testing link")
	public void user_clicks_on_Visual_Testing_link() throws InterruptedException
	{
		driver.findElement(By.linkText("Visual Testing")).click();
		Thread.sleep(3000);
	    System.out.println("Visual Testing options");
	}

	@Then("user should be on Visual Testing page")
	public void user_should_be_on_Visual_Testing_page() 
	{
		System.out.println("The user is able to view Visual Testing page");
	}


	@Then("user clicks on End-To-End Testing link")
	public void user_clicks_on_End_To_End_Testing_link() throws InterruptedException 
	{
		driver.findElement(By.linkText("End-to-End Testing")).click();
		Thread.sleep(3000);
	    System.out.println("End-to-End Testing options");
	}

	@Then("user should be on End-To-End Testing page")
	public void user_should_be_on_End_To_End_Testing_page() 
	{
		System.out.println("The user is able to view End-to-End Testing page");
	}

	

	@Then("user clicks on Supported Integration link")
	public void user_clicks_on_Supported_Integration_link() throws InterruptedException 
	{
		driver.findElement(By.linkText("Supported Integrations")).click();
		Thread.sleep(3000);
	    System.out.println("Supported Integrations options");
	}

	@Then("user should be on Supported Integration page")
	public void user_should_be_on_Supported_Integration_page() 
	{
		System.out.println("The user is able to view Supported Integrations page");
	}

	

	@Then("user clicks on Browsers & devices link")
	public void user_clicks_on_Browsers_devices_link() throws InterruptedException 
	{
		driver.findElement(By.linkText("Browsers & Devices")).click();
		Thread.sleep(3000);
	    System.out.println("Browsers & Devices options");
	}

	@Then("user should be on Browsers & devices page")
	public void user_should_be_on_Browsers_devices_page() 
	{
		System.out.println("The user is able to view Browsers & Devices page");
	}

	

	@Then("user clicks on Sauce Performance link")
	public void user_clicks_on_Sauce_Performance_link() throws InterruptedException
	{
		driver.findElement(By.linkText("Sauce Performance")).click();
		Thread.sleep(3000);
	    System.out.println("Sauce Performance options");
	}

	@Then("user should be on Sauce Performance page")
	public void user_should_be_on_Sauce_Performance_page() 
	{
		System.out.println("The user is able to view Sauce Performance page");
	}

	

	@Then("user clicks on Sauce Insights link")
	public void user_clicks_on_Sauce_Insights_link() throws InterruptedException 
	{
		driver.findElement(By.linkText("Sauce Insights")).click();
		Thread.sleep(3000);
	    System.out.println("Sauce Insights options");
	}

	@Then("user should be on Sauce Insights page")
	public void user_should_be_on_Sauce_Insights_page() 
	{
		System.out.println("The user is able to view Sauce Insights page");
	}

	

	@Then("user clicks on Extended Debugging link")
	public void user_clicks_on_Extended_Debugging_link() throws InterruptedException 
	{
		driver.findElement(By.linkText("Extended Debugging")).click();
		Thread.sleep(3000);
	    System.out.println("Extended Debugging options");
	}

	@Then("user should be on Extended Debugging page")
	public void user_should_be_on_Extended_Debugging_page() 
	{
		System.out.println("The user is able to view Extended Debugging page");
	}

	

	@Then("user clicks on Selenium link")
	public void user_clicks_on_Selenium_link() throws InterruptedException 
	{
		driver.findElement(By.linkText("Selenium")).click();
		Thread.sleep(3000);
	    System.out.println("Selenium options");
	}

	@Then("user should be on Selenium page")
	public void user_should_be_on_Selenium_page() 
	{
		System.out.println("The user is able to view Selenium page");
	}



	@Then("user clicks on Espresso link")
	public void user_clicks_on_Espresso_link() throws InterruptedException 
	{
		driver.findElement(By.linkText("Espresso")).click();
		Thread.sleep(3000);
	    System.out.println("Espresso options");
	}

	@Then("user should be on Espresso page")
	public void user_should_be_on_Espresso_page() 
	{
		System.out.println("The user is able to view Espresso page");
	}


}
