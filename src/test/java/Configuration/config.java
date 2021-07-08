package Configuration;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class config 
{
   @Test
   public void testConfig() throws IOException
   {
	 File src=new File(".Configuration/config.property");
	 
	 FileInputStream fis= new FileInputStream(src);
	 
	 Properties pro=new Properties();
	 
	 pro.load(fis);
	 
	 String chromepath=pro.getProperty("ChromeDriver");
	 
	 System.out.println("Path is:"+chromepath);
	 
   }
}
