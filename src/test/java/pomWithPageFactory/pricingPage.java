package pomWithPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class pricingPage 
{
	public WebDriver driver;
	
	@FindBy(how=How.LINK_TEXT,using="Pricing") WebElement pricing;
	@FindBy(how=How.LINK_TEXT,using="Custom Enterprise Pricing") WebElement customEnterprise;
	@FindBy(how=How.NAME,using="FirstName") WebElement firstName;
	@FindBy(how=How.NAME,using="LastName") WebElement lastName;
	@FindBy(how=How.NAME,using="Company") WebElement company;
	@FindBy(how=How.NAME,using="Email") WebElement email;
	@FindBy(how=How.NAME,using="Phone") WebElement phone;
	@FindBy(how=How.NAME,using="productInterest") WebElement interest;
	@FindBy(how=How.ID,using="Sales_Contact_Comments__c") WebElement comments;
	@FindBy(how=How.ID,using="LblmktoCheckbox_26673_0") WebElement chkBox;
	@FindBy(how=How.XPATH,using="//button[text()='Submit']") WebElement submitButton;
	
	public pricingPage(WebDriver driver) 
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
	}
	public void clickSubmitButton()
	{
		submitButton.click();
	}
	

}
