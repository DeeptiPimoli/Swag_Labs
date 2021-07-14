package stepDefinitions;

import java.io.File;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pomWithPageFactory.About_Page;


public class AboutSteps 
{
	
	public static WebDriver driver;
	
	static FileReader reader;
	static Properties property;
	
	static About_Page pageFactory;
	
	//launching application
	@Before("@about")
	public void launchApplication() throws IOException 
	{
		System.out.println("Before");
		reader = new FileReader("C:\\Users\\Hp\\Desktop\\deepti\\Sprint2\\Configuration\\config.property");
		property=new Properties();
		property.load(reader);
		System.setProperty("webdriver.chrome.driver",property.getProperty("ChromeDriver"));
		
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(property.getProperty("baseUrl"));
        driver.manage().timeouts().pageLoadTimeout(35, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); 
        pageFactory= new About_Page(driver);
	}
	
	// take screenshots
	public void takeSS(String FileName) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
        File source=ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source,new File(".\\Screenshots\\"+FileName+".png" ));
	}
	
	//Home page
	@Given("The user is on SwagLabs home page")
	public void the_user_is_on_SwagLabs_home_page() throws IOException, InterruptedException 
	{

		pageFactory.enterUserName();
		pageFactory.enterPasswd();
		pageFactory.login();

        String expectedTitle1=property.getProperty("expectedTitle1");
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(),expectedTitle1);
		
		System.out.println("-------Verified--------");
		
        System.out.println("The user is on SwagLabs home page");
        takeSS("HomePage");
   
	}

	//Hamburger menu
	@When("user clicks on Hamburger menu")
	public void user_clicks_on_Hamburger_menu() throws InterruptedException 
	{
		pageFactory.clickHamburgerMenu();
	    System.out.println("The hamburger menu is selected");
	    
	}
	

	//about option
	@When("user click on about option")
	public void user_click_on_about_option() throws InterruptedException 
	{
		pageFactory.clickAboutOption();
	    System.out.println("The about button clicked");
	    
	}
	 
	@Then("user should be on About Page")
	public void user_should_be_on_About_Page() 
	{
	    System.out.println("The user is in about page");
	}

	@Then("user closes the browser")
	public void user_closes_the_browser() 
	{
	    System.out.println("Browser is closed");
	}
	
	//closing browser
	@After("@about")
	public void closeBrowser() 
	{
	    driver.quit();   
	}



}

