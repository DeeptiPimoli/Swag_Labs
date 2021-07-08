package Configuration;


import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class configRead {
	
	public static void main(String[] args) throws IOException 
	{
		 WebDriver driver = null;
		 Properties prop=new Properties();
		 
		 //File src=new File(".Configuration/config.property");
		 FileInputStream fis= new FileInputStream("C:\\Users\\Hp\\Desktop\\deepti\\Sprint2\\Configuration\\config.property");
		 
		 prop.load(fis);
		 
		 System.out.println(prop.getProperty("browser"));
		 String browserName = prop.getProperty("browser");
		 
		 if(browserName.equals("chrome")) 
		 {
			 System.setProperty("webdriver.chrome.driver","C:\\Software\\chromedriver.exe");
			 driver = new ChromeDriver();
		 }
		 else if(browserName.equals("ff"))
		 {
			 driver = new FirefoxDriver();
		 }
		 else if(browserName.equals("Safari"))
		 {
			 driver = new SafariDriver();
		 }
		 else
		 {
			 System.out.println("No Browser value is given");
		 }
		 
		 driver.get(prop.getProperty("URL"));
		 driver.findElement(By.id("user-name")).sendKeys(prop.getProperty("username"));
	     driver.findElement(By.id("password")).sendKeys(prop.getProperty("password"));
	     driver.findElement(By.id("login-button")).click();
	}

}
