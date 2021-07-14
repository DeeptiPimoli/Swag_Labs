package pomWithPageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Platform_Page {
	public WebDriver driver;
	@FindBy(how=How.LINK_TEXT,using="Platform") WebElement platform;
	@FindBy(how=How.LINK_TEXT,using="Overview") WebElement overview;
	@FindBy(how=How.LINK_TEXT,using="Mobile Testing") WebElement mobileTesting;
	@FindBy(how=How.LINK_TEXT,using="Cross-browser Testing") WebElement crossBrowser;
	@FindBy(how=How.LINK_TEXT,using="Error Reporting") WebElement errorReporting;
	@FindBy(how=How.LINK_TEXT,using="API Testing") WebElement api;
	@FindBy(how=How.LINK_TEXT,using="Low-Code Testing") WebElement lowCode;
	@FindBy(how=How.LINK_TEXT,using="Supported Integrations") WebElement supportedIntegrations;
	@FindBy(how=How.LINK_TEXT,using="Browsers & Devices") WebElement browsersDevices;
	@FindBy(how=How.LINK_TEXT,using="Sauce Performance") WebElement saucePerformance;
	@FindBy(how=How.LINK_TEXT,using="Sauce Insights") WebElement sauceInsights;
//	@FindBy(how=How.LINK_TEXT,using="Extended Debugging") WebElement extendedDebugging;
	@FindBy(how=How.LINK_TEXT,using="Selenium") WebElement selenium;
	@FindBy(how=How.LINK_TEXT,using="Espresso") WebElement espresso;
	
	public Platform_Page(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	public void clickPlatform()
	{
		platform.click();
	}
	public void clickOverview()
	{
		overview.click();
	}
	public void clickMobileTesting()
	{
		mobileTesting.click();
	}
	public void clickCrossBrowser()
	{
		crossBrowser.click();
	}
	public void clickErrorReporting()
	{
		errorReporting.click();
	}
	public void clickApiTesting()
	{
		api.click();
	}
	public void clickLowCodeTesting()
	{
		lowCode.click();
	}
//	public void clickVisualTesting()
//	{
//		visual.click();
//	}
//	public void clickEndToEndTesting()
//	{
//		endToEnd.click();
//	}
	public void clickSupportedIntegrations()
	{
		supportedIntegrations.click();
	}
	public void clickBrowsersDevices()
	{
		browsersDevices.click();
	}
	public void clickSaucePerformance()
	{
		saucePerformance.click();
	}
	public void clickSauceInsights()
	{
		sauceInsights.click();
	}
//	public void clickExtendedDebugging()
//	{
//		extendedDebugging.click();
//	}
	public void clickSelenium()
	{
		selenium.click();
	}
	public void clickEspresso()
	{
		espresso.click();
	}
	

}
