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

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pomWithPageFactory.pricingPage;

public class pricing 
{
	WebDriver driver;
	String baseUrl="https://saucelabs.com/";
	
	pricingPage PF;
	
	
	public void takeSS(String FileName) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
        File source=ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source,new File(".\\Screenshots\\"+FileName+".png" ));
	}
	
	
	@Given("user should be on About home page")
	public void user_should_be_on_About_home_page() throws InterruptedException, IOException 
	{
		
		
		System.setProperty("webdriver.chrome.driver","C:\\Software\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get(baseUrl);
        
        String expectedTitle="Cross Browser Testing, Selenium Testing, Mobile Testing | Sauce Labs";// config file;
		Thread.sleep(4000);
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(),expectedTitle);
		System.out.println("-------Verified--------");
        
       System.out.println("The user is on About home page");
       
       takeSS("PricingPage");
       
	  
       PF=new pricingPage(driver);
	}
	
	@When("user clicks Pricing options")
	public void user_clicks_Pricing_options() throws InterruptedException 
	{
		driver.findElement(By.linkText("Pricing")).click();
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
		driver.findElement(By.linkText("Custom Enterprise Pricing")).click();
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
		driver.findElement(By.name("FirstName")).sendKeys(FirstName);
	}

	@When("user enter the LastName as {string}")
	public void user_enter_the_LastName_as(String LastName) 
	{
		driver.findElement(By.name("LastName")).sendKeys(LastName);
	}

	@When("user enter Company {string}")
	public void user_enter_Company(String Company) 
	{
		driver.findElement(By.name("Company")).sendKeys(Company);
	}

	@When("user enter Business Email as {string}")
	public void user_enter_Business_Email_as(String BusinessEmail) 
	{
		driver.findElement(By.name("Email")).sendKeys(BusinessEmail);
	}

	@When("user enter Phone number as {string}")
	public void user_enter_Phone_number_as(String PhNo) 
	{
		driver.findElement(By.name("Phone")).sendKeys(PhNo);
	}

	@When("user select Intrest {string}")
	public void user_select_Intrest(String Intrest)
	{
		driver.findElement(By.name("productInterest")).sendKeys(Intrest);
	}

	@When("user enter Comments {string}")
	public void user_enter_Comments(String Comments) 
	{
		driver.findElement(By.id("Sales_Contact_Comments__c")).sendKeys(Comments);
	}

	@When("user click Privacy policy")
	public void user_click_Privacy_policy() 
	{        
		WebElement chkBox = driver.findElement(By.id("mktoCheckbox_26687_0"));
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
//		JavascriptExecutor js1 = (JavascriptExecutor) driver;
//        WebElement Element1 = driver.findElement(By.linkText(""));
//        js1.executeScript("arguments[0].scrollIntoView();", Element1);
        
		System.out.println("The user is able to view 'Thanks for submitting your request!'");
	}
	@Then("user Closes the Browser")
	public void user_Closes_the_Browser() 
	{
		driver.quit();
		System.out.println("Browser is closed");
	}

	

}
