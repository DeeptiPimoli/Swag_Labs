package testNG;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilitity.ExcelUtil;
import pomWithPageFactory.About_Page;


public class AboutTestNg {
	
	WebDriver driver=null;
	public static ExcelUtil excel;
	
	static FileReader reader;
	static Properties property;
	
	public static About_Page pageFactory;
	
	@BeforeTest
	public void setUpTest() throws IOException
	{
		System.out.println("BeforeMethod");
		reader = new FileReader("C:\\Users\\Hp\\Desktop\\deepti\\Sprint2\\Configuration\\config.property");
		property=new Properties();
		property.load(reader);
		System.setProperty("webdriver.chrome.driver",property.getProperty("ChromeDriver"));
		
		driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(property.getProperty("baseUrl"));
        driver.manage().timeouts().pageLoadTimeout(35, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); 
        pageFactory= new About_Page(driver);
		  

	}
	
	@DataProvider(name = "test1data")
	public Object[][] getData() {
		String excelPath = "C:\\Users\\Hp\\Desktop\\deepti\\Sprint2\\TestData\\ExcelSheet.xlsx";
		Object data[][] = testData(excelPath, "LoginTestData");
		return data;
		
	}
	
	@Test(priority=1,dataProvider="test1data")
	public void test1(String username, String password) throws Exception {
		
		System.out.println(username+" | "+password);
		
//		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("login-button")).click();
		
		String expectedTitle1=property.getProperty("expectedTitle1");
		
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(),expectedTitle1);
		System.out.println("-------Verified--------");
        System.out.println("The user is on SwagLabs home page");
        pageFactory.clickHamburgerMenu();
	    System.out.println("The hamburger menu is selected");
	    driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); 
	    pageFactory.clickAboutOption();
	    System.out.println("The about button clicked");
	    System.out.println("The user is in about page");

	}
	@Test(priority=2)
	public void homepage()
	{
		String expectedTitle= "Swag Labs";
		Assert.assertEquals(driver.getTitle(), expectedTitle);
		System.out.println("SwagLAbs home page is displayed");
	}
		
	public Object[][] testData(String excelPath, String sheetName) {
		
		 excel = new ExcelUtil(excelPath, sheetName);
		
		int rowCount=excel.getRowCount();
		int colCount=excel.getColCount();
		
		
		Object data[][] = new Object[rowCount-1][colCount];
		
		for(int i=1; i<rowCount; i++) {
			for(int j=0; j<colCount; j++) {
				
				String cellData = ExcelUtil.getCellDataString(i, j);
				System.out.print(cellData+" | ");
				data[i-1][j] = cellData;
			
			}
			System.out.println();
		}
		return data;
		
	}
	@AfterTest
	public void quit() {
		driver.quit();
	}
}