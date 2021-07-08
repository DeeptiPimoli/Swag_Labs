package stepDefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pomWithPageFactory.aboutPage;

public class about1 
{
	
	public static WebDriver driver;
	String baseUrl="https://www.saucedemo.com/";
	
	static Properties property;
	static FileReader reader;
	
	aboutPage PF;
	
	public void takeSS(String FileName) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
        File source=ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source,new File(".\\Screenshots\\"+FileName+".png" ));
	}
	
//	public static WebDriver launchApplication(int browser) throws IOException {
//		reader=new FileReader("C:\\Users\\Hp\\Desktop\\deepti\\Sprint2\\Configuration\\config.property");
//		
//		property=new Properties();
//		property.load(reader);
//		
//		switch (property.getProperty("browser")) {
//        case "chrome":
//            System.setProperty("webdriver.chrome.driver","C:\\\\Software\\\\chromedriver.exe");
//            driver=new ChromeDriver();
//            break;
//
// 
//
//        default:
//            break;
//        case "firefox":
//            System.setProperty("webdriver.gecko.driver","C:\\Users\\rrohi\\Downloads\\geckodriver.exe");
//            driver=new FirefoxDriver();
//            break;
//            
//        case "ie":
//            System.setProperty("webdriver.ie.driver","C:\\Users\\rrohi\\Downloads\\chromedriver_win32\\chromedriver.exe");
//            driver=new InternetExplorerDriver();
//            break;
//        }
//		return driver;
//	}
	
	public static WebDriver configProperty(String browser) throws IOException
	{
		WebDriver driver = null;
		 Properties prop=new Properties();
		 
		 //File src=new File(".Configuration/config.property");
		 FileInputStream fis= new FileInputStream("C:\\Users\\Hp\\Desktop\\deepti\\Sprint2\\Configuration\\config.property");
		 
		 prop.load(fis);
		 
		 System.out.println(prop.getProperty("browser"));
		 String browserName = prop.getProperty("browser");
		 
		 if(browserName.equals("chrome")) 
		 {
			 System.setProperty("webdriver.chrome.driver","C:\\Software\\chromedriver.exe");
			 driver = new ChromeDriver();
		 }
		 else if(browserName.equals("ff"))
		 {
			 driver = new FirefoxDriver();
		 }
		 else if(browserName.equals("Safari"))
		 {
			 driver = new SafariDriver();
		 }
		 else
		 {
			 System.out.println("No Browser value is given");
		 }
		 
		 driver.get(prop.getProperty("URL"));
		 driver.findElement(By.id("user-name")).sendKeys(prop.getProperty("username"));
	     driver.findElement(By.id("password")).sendKeys(prop.getProperty("password"));
	     driver.findElement(By.id("login-button")).click();
	
	     return driver;
	}
		
			
	

	@Given("The user is on SwagLabs home page")
	public void the_user_is_on_SwagLabs_home_page() throws IOException, InterruptedException 
	{
		
//		System.setProperty("webdriver.chrome.driver","C:\\Software\\chromedriver.exe");
//        driver=new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get(baseUrl);
//        driver.findElement(By.id("user-name")).sendKeys("standard_user");
//        driver.findElement(By.id("password")).sendKeys("secret_sauce");
//        driver.findElement(By.id("login-button")).click();
//        
		configProperty("chrome");
		driver.manage().window().maximize();
		
        String expectedTitle="Swag Labs";
		Thread.sleep(4000);
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(),expectedTitle);
		System.out.println("-------Verified--------");
		
       System.out.println("The user is on SwagLabs home page");
       takeSS("HomePage");
       
       PF= new aboutPage(driver);
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
