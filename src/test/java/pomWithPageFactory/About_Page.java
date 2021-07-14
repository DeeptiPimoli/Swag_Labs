package pomWithPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class About_Page 
{
	public WebDriver driver;
	
	@FindBy(how=How.ID,using="user-name")
	static WebElement userName;
	@FindBy(how=How.ID,using="password") WebElement passwd;
	@FindBy(how=How.ID,using="login-button") WebElement login;
	@FindBy(how=How.ID,using="react-burger-menu-btn") WebElement hamburgerMenu;
	@FindBy(how=How.ID,using="about_sidebar_link") WebElement aboutOption;
	
	public About_Page(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	public void enterUserName()
	{
		userName.sendKeys("standard_user");
	}
	public void enterPasswd()
	{
		passwd.sendKeys("secret_sauce");
	}
	public void login() throws InterruptedException
	{
		login.click();

	}
	public void clickHamburgerMenu()
	{
		hamburgerMenu.click();
	}
	
	public void clickAboutOption()
	{
		aboutOption.click();
	}
	
	

}
