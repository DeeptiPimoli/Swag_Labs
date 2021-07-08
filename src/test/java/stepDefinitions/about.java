package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pomWithPageFactory.aboutPage;

public class about 
{
	
	public static WebDriver driver;
	String baseUrl="https://www.saucedemo.com/";
	
	aboutPage PF1;
	
	public void takeSS(String FileName) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
        File source=ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source,new File(".\\Screenshots\\"+FileName+".png" ));
	}

	@Given("The user is on SwagLabs home page")
	public void the_user_is_on_SwagLabs_home_page() throws IOException, InterruptedException 
	{
		
		System.setProperty("webdriver.chrome.driver","C:\\Software\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        
        String expectedTitle="Swag Labs";
		Thread.sleep(4000);
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(),expectedTitle);
		System.out.println("-------Verified--------");
		
       System.out.println("The user is on SwagLabs home page");
       takeSS("HomePage");
       
       PF1= new aboutPage(driver);
	}

	@When("user clicks on Hamburger menu")
	public void user_clicks_on_Hamburger_menu() throws InterruptedException 
	{
	
	        driver.findElement(By.id("react-burger-menu-btn")).click();
	        System.out.println("The hamburger menu is selected");
	        Thread.sleep(1800);
	}
	

	@When("user click on about option")
	public void user_click_on_about_option() throws InterruptedException 
	{
		
	        driver.findElement(By.id("about_sidebar_link")).click();
	        System.out.println("The about button clicked");
	        Thread.sleep(1800);
	    }
	 
	

	@Then("user should be on About Page")
	public void user_should_be_on_About_Page() 
	{
	    System.out.println("The user is in about page");
	}

	@Then("user closes the browser")
	public void user_closes_the_browser() 
	{
	    driver.quit();
	    System.out.println("Browser is closed");
	}


}
