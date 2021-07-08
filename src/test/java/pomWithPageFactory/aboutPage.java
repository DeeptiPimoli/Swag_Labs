package pomWithPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class aboutPage 
{
	public WebDriver driver;
	
	@FindBy(how=How.ID,using="user-name") WebElement userName;
	@FindBy(how=How.ID,using="password") WebElement passwd;
	@FindBy(how=How.ID,using="login-button") WebElement login;
	@FindBy(how=How.ID,using="react-burger-menu-btn") WebElement HamburgerMenu;
	@FindBy(how=How.ID,using="about_sidebar_link") WebElement aboutOption;
	
	public aboutPage(WebDriver driver) 
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
		Thread.sleep(5000);
		driver.quit();
	}
	public void clickHamburgerMenu()
	{
		HamburgerMenu.click();
	}
	
	public void clickAboutOption()
	{
		aboutOption.click();
	}
	
	

}
