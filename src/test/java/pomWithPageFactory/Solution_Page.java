package pomWithPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Solution_Page 
{
	
	public WebDriver driver;
	
	@FindBy(how=How.LINK_TEXT,using="Solutions") WebElement solutions;
	@FindBy(how=How.LINK_TEXT,using="Enterprise") WebElement enterprise;
	@FindBy(how=How.LINK_TEXT,using="Start-ups & SMB Teams") WebElement startupsSMBTeams;
	@FindBy(how=How.LINK_TEXT,using="Open Source Projects") WebElement openSourceProjects;
	@FindBy(how=How.LINK_TEXT,using="Continuous Testing") WebElement continuousTesting;
	@FindBy(how=How.LINK_TEXT,using="Automated Testing") WebElement automatedTesting;
	@FindBy(how=How.LINK_TEXT,using="Live Testing") WebElement liveTesting;
	
	public Solution_Page(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	public void clickSolutions()
	{
		solutions.click();
	}
	public void clickEnterprise()
	{
		enterprise.click();
	}
	public void clickStartupsSMBTeams()
	{
		startupsSMBTeams.click();
	}
	public void clickOpenSourceProjects()
	{
		openSourceProjects.click();
	}
	public void clickContinuousTesting()
	{
		continuousTesting.click();
	}
	public void clickAutomatedTesting()
	{
		automatedTesting.click();
	}
	public void clickLiveTesting()
	{
		liveTesting.click();
	}
	

}
