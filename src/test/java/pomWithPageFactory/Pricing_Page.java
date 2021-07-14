package pomWithPageFactory;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Pricing_Page 
{
	public WebDriver driver;
	
	@FindBy(how=How.LINK_TEXT,using="Pricing") 
	public static WebElement pricing;
	@FindBy(how=How.LINK_TEXT,using="Custom Enterprise Pricing") 
	public static WebElement customEnterprise;
	@FindBy(how=How.NAME,using="FirstName")
	public 
	static WebElement firstName;
	@FindBy(how=How.NAME,using="LastName") 
	public static WebElement lastName;
	@FindBy(how=How.NAME,using="Company") 
	public static WebElement company;
	@FindBy(how=How.NAME,using="Email") 
	public static WebElement email;
	@FindBy(how=How.NAME,using="Phone") 
	public static WebElement phone;
	@FindBy(how=How.NAME,using="productInterest") 
	public static WebElement interest;
	@FindBy(how=How.ID,using="Sales_Contact_Comments__c") 
	public static WebElement comments;
	@FindBy(how=How.NAME,using="sauceLabsContactConsent") 
	public static WebElement chkBox;
	@FindBy(how=How.XPATH,using="//button[text()='Submit']") 
//	@FindBy(how=How.XPATH,using="//.mktoButtonRow button[@type='submit']") 
	public static WebElement submitButton;
	
	public Pricing_Page(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	public void clickPricing()
	{
		pricing.click();
	}
	public void clickCustomEnterprise()
	{
		customEnterprise.click();
	}
	public void enterFirstName(String FirstName)
	{
		firstName.sendKeys(FirstName);
	}
	public void enterLastName(String LastName)
	{
		lastName.sendKeys(LastName);
	}
	public void enterCompany(String Company)
	{
		company.sendKeys(Company);
	}
	public void enterEmail(String BusinessEmail)
	{
		email.sendKeys(BusinessEmail);
	}
	public void enterPhoneNo(String PhNo)
	{
		phone.sendKeys(PhNo);
	}
	public void enterInterest(String Intrest)
	{
		interest.sendKeys(Intrest);
	}
	public void enterComments(String Comments)
	{
		comments.sendKeys(Comments);
	}
	public void clickChkBox()
	{
		chkBox.click();
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//      js.executeScript("arguments[0].click();", chkBox);
	}
	public void clickSubmitButton()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", submitButton);
		submitButton.click();
	}
	

	

}
