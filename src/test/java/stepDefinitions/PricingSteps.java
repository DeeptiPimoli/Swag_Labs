package stepDefinitions;

import java.io.File;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pomWithPageFactory.Pricing_Page;



public class PricingSteps 
{
	WebDriver driver;
//	String baseUrl="https://saucelabs.com/";
	
	static FileReader reader;
	static Properties property;
	
	static Pricing_Page pricingPageFactory;
	
	@Before("@Pricing")
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
        pricingPageFactory= new Pricing_Page(driver);
	}
	
	
	public void takeSS(String FileName) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
        File source=ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source,new File(".\\Screenshots\\"+FileName+".png" ));
	}
		
	@Given("user should be On About HomePage")
	public void user_should_be_On_About_HomePage() throws IOException, InterruptedException
	{
		reader = new FileReader("C:\\Users\\Hp\\Desktop\\deepti\\Sprint2\\Configuration\\config.property");
		property=new Properties();
		property.load(reader);
        
		String expectedTitle2=property.getProperty("expectedTitle2");
		Thread.sleep(4000);
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(),expectedTitle2);
		System.out.println("-------Verified--------");
        
       System.out.println("The user is on About home page");
       takeSS("PricingPage");
       
	  
       pricingPageFactory=new Pricing_Page(driver);
	}


	
	@When("user clicks Pricing options")
	public void user_clicks_Pricing_options() throws InterruptedException 
	{

		pricingPageFactory.clickPricing();
		Thread.sleep(5000);
	    System.out.println("Pricing options");
	}

	@Then("user should be able to view various Pricing")
	public void user_should_be_able_to_view_various_Pricing()
	{
		System.out.println("The user is able to view various Pricing");
	}

	@Then("user clicks on Custom Enterprise Pricing link")
	public void user_clicks_on_Custom_Enterprise_Pricing_link() throws InterruptedException 
	{
		pricingPageFactory.clickCustomEnterprise();
		Thread.sleep(5000);
	    System.out.println("Custom Enterprise Pricing options");
	}

	@Then("user should be on Custom Enterprise Pricing page")
	public void user_should_be_on_Custom_Enterprise_Pricing_page() 
	{
		System.out.println("The user is able to view Custom Enterprise Pricing page");
	}

	@When("user enter the FirstName as {string}")
	public void user_enter_the_FirstName_as(String FirstName) 
	{
		pricingPageFactory.enterFirstName(FirstName);
	}

	@When("user enter the LastName as {string}")
	public void user_enter_the_LastName_as(String LastName) 
	{
		pricingPageFactory.enterLastName(LastName);
	}

	@When("user enter Company {string}")
	public void user_enter_Company(String Company) 
	{
		pricingPageFactory.enterCompany(Company);
	}

	@When("user enter Business Email as {string}")
	public void user_enter_Business_Email_as(String BusinessEmail) 
	{
		pricingPageFactory.enterEmail(BusinessEmail);
	}

	@When("user enter Phone number as {string}")
	public void user_enter_Phone_number_as(String PhNo) 
	{
		pricingPageFactory.enterPhoneNo(PhNo);
	}

	@When("user select Intrest {string}")
	public void user_select_Intrest(String Intrest)
	{
		pricingPageFactory.enterInterest(Intrest);
	}

	@When("user enter Comments {string}")
	public void user_enter_Comments(String Comments) 
	{
		pricingPageFactory.enterComments(Comments);
	}

	@When("user click Privacy policy")
	public void user_click_Privacy_policy() 
	{        
//		WebElement chkBox = driver.findElement(By.id("mktoCheckbox_26701_0"));
		WebElement chkBox = driver.findElement(By.name("sauceLabsContactConsent"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", chkBox);
         
	}


	@Then("user click submit button")
	public void user_click_submit_button() throws InterruptedException 
	{
		WebElement submit = driver.findElement(By.xpath("//button[text()='Submit']"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", submit);

		System.out.println("User clicked on submit button");
		Thread.sleep(5000);
	}

	@Then("user should get Thanks for submitting your request!")
	public void user_should_get_Thanks_for_submitting_your_request() 
	{
      
		System.out.println("The user is able to view 'Thanks for submitting your request!'");
	}
	@Then("user Closes The Browser")
	public void user_Closes_The_Browser() 
	{
//		driver.quit();
		System.out.println("Browser is closed");
	}

	@After("@Pricing")
	public void closeBrowser() 
	{
	    driver.quit();  
	}

}
