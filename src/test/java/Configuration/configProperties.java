package Configuration;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class configProperties 
{

public static void main(String[] args) throws IOException {
		
		FileReader reader =new FileReader("C:\\Users\\Hp\\Desktop\\deepti\\Sprint2\\Configuration\\config.property");
		
		Properties properties=new  Properties();
	    properties.load(reader);
	    
	    System.out.println(properties.getProperty("ChromeDriver"));
	    System.out.println(properties.getProperty("URL"));
	    
	    
	}
	
	
}
