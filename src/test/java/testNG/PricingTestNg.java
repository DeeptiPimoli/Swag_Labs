package testNG;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilitity.ExcelUtil;
import pomWithPageFactory.Pricing_Page;

public class PricingTestNg 
{		
		WebDriver driver;
		public static ExcelUtil excel;
		
		static FileReader reader;
		static Properties property;
		
//		 WebElement pricing;
//		 WebElement customEnterprise;
//		 WebElement firstName;
//		 WebElement lastName;
//		 WebElement company;
//		 WebElement email;
//		 WebElement phone;
//		 WebElement submitButton;
		
		public static Pricing_Page pricingPageFactory;
		
		@BeforeTest
		public void setUpTest() throws IOException {
			System.out.println("BeforeMethod");
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
	        pricingPageFactory.clickPricing();
	        pricingPageFactory.clickCustomEnterprise();
	        
	          

		}
		
		@DataProvider
		public Object[][] form() {
			String excelPath = "C:\\Users\\Hp\\Desktop\\deepti\\Sprint2\\TestData\\ExcelSheet.xlsx";
			Object data[][] = testData(excelPath, "pricing");
			return data;
			
		}
		
		@Test(priority=1,dataProvider="form")
		public void data(String FirstName, String LastName,String Company,String Email, String PhNo) {
				
			Pricing_Page pricepage =new Pricing_Page(driver);
			pricepage.enterFirstName(FirstName);
			pricepage.enterLastName(LastName);
			pricepage.enterCompany(Company);
			pricepage.enterEmail(Email);
			pricepage.enterPhoneNo(PhNo);
			System.out.println("========================================");
		    Assert.assertEquals("",Pricing_Page.firstName.getText());
		    Assert.assertEquals("",Pricing_Page.lastName.getText());
		    Assert.assertEquals("",Pricing_Page.company.getText());
		    Assert.assertEquals("",Pricing_Page.email.getText());
		    Assert.assertEquals("",Pricing_Page.phone.getText());
//		    pricepage.clickSubmitButton();
		    WebElement submit = driver.findElement(By.xpath("//button[text()='Submit']"));
	        JavascriptExecutor js = (JavascriptExecutor)driver;
	        js.executeScript("arguments[0].click();", submit);
		  }
		
		@AfterTest
		public void quit() {
			driver.quit();
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
	
}

























