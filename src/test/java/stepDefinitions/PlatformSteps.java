package stepDefinitions;


import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pomWithPageFactory.Platform_Page;



public class PlatformSteps
{
	WebDriver driver;
//	String baseUrl="https://saucelabs.com/";
	
	static FileReader reader;
	static Properties property;

	Platform_Page PF;
	
	@Before("@Platform")
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
        PF= new Platform_Page(driver);
	}
	
	@After("@Platform")
	public void closeBrowser() 
	{
	    driver.quit();  
	}
	
	@Given("user should be on About Home Page")
	public void user_should_be_on_About_Home_Page() throws InterruptedException, IOException 
	{
		String expectedTitle2=property.getProperty("expectedTitle2");
		Thread.sleep(4000);
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(),expectedTitle2);
		System.out.println("-------Verified--------");
				
        System.out.println("The user is on About home page");
	  
        PF=new Platform_Page(driver);
	}
	
	@When("user clicks Platform options")
	public void user_clicks_Platform_options() throws InterruptedException 
	{
//		driver.findElement(By.linkText("Platform")).click();
		PF.clickPlatform();
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
//		driver.findElement(By.linkText("Overview")).click();
		PF.clickOverview();
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
//		driver.findElement(By.linkText("Mobile Testing")).click();
		PF.clickMobileTesting();
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
//		driver.findElement(By.linkText("Cross-browser Testing")).click();
		PF.clickCrossBrowser();
		Thread.sleep(3000);
	    System.out.println("Cross-browser Testing options");
	}

	@Then("user should be on Cross-browser Testing page")
	public void user_should_be_on_Cross_browser_Testing_page()
	{
		System.out.println("The user is able to view Cross-browser Testing page");
	}
	
	@Then("user clicks on Error Reporting link")
	public void user_clicks_on_Error_Reporting_link() throws InterruptedException 
	{
//		driver.findElement(By.linkText("Error Reporting")).click();
		PF.clickErrorReporting();
		Thread.sleep(3000);
	    System.out.println("Error Reporting options");
	}

	@Then("user should be on Error Reporting page")
	public void user_should_be_on_Error_Reporting_page() 
	{
		System.out.println("The user is able to view Error Reporting page");
	}

	
	@Then("user clicks on API Testing link")
	public void user_clicks_on_API_Testing_link() throws InterruptedException
	{
		WebElement click = driver.findElement(By.linkText("API Testing"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", click);
//		driver.findElement(By.linkText("API Testing")).click();
//		Thread.sleep(3000);
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
		driver.findElement(By.linkText("Low-Code Testing")).click();
		Thread.sleep(3000);
	    System.out.println("Low Code Testing options");
	}

	@Then("user should be on Low-code Testing page")
	public void user_should_be_on_Low_code_Testing_page() 
	{
		System.out.println("The user is able to view Low Code Testing page");
	}

	@Then("user clicks on Supported Integration link")
	public void user_clicks_on_Supported_Integration_link() throws InterruptedException 
	{
//		driver.findElement(By.linkText("Supported Integrations")).click();
		PF.clickSupportedIntegrations();
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
//		driver.findElement(By.linkText("Browsers & Devices")).click();
		PF.clickBrowsersDevices();
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
//		driver.findElement(By.linkText("Sauce Performance")).click();
		PF.clickSaucePerformance();
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
//		driver.findElement(By.linkText("Sauce Insights")).click();
		PF.clickSauceInsights();
		Thread.sleep(3000);
	    System.out.println("Sauce Insights options");
	}

	@Then("user should be on Sauce Insights page")
	public void user_should_be_on_Sauce_Insights_page() 
	{
		System.out.println("The user is able to view Sauce Insights page");
	}

	@Then("user clicks on Selenium link")
	public void user_clicks_on_Selenium_link() throws InterruptedException 
	{
		WebElement click1 = driver.findElement(By.linkText("Selenium"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", click1);
        System.out.println("Selenium options");
//		driver.findElement(By.linkText("Selenium")).click();
//		Thread.sleep(3000);
	    
	}

	@Then("user should be on Selenium page")
	public void user_should_be_on_Selenium_page() 
	{
		System.out.println("The user is able to view Selenium page");
	}



	@Then("user clicks on Espresso link")
	public void user_clicks_on_Espresso_link() throws InterruptedException 
	{
		WebElement click2 = driver.findElement(By.linkText("Espresso"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", click2);
        Thread.sleep(3000);
	    System.out.println("Espresso options");
//		driver.findElement(By.linkText("Espresso")).click();
		
	}

	@Then("user should be on Espresso page")
	public void user_should_be_on_Espresso_page() 
	{
		System.out.println("The user is able to view Espresso page");
	}
	
	@Then("user Closes Browser")
	public void user_Closes_Browser()
	{
//		driver.quit();
		System.out.println("Browser is closed");
	}




}
