package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.testng.TestListenerAdapter;

public class Readconfig {

	Properties pro;
	
	public Readconfig() {
		
		File src = new File("./configuration/config.properties");
		try {
		FileInputStream fis = new FileInputStream(src);
		pro= new Properties();
		pro.load(fis);
		}
		catch (Exception e) {
			System.out.println("Exception is "+e.getMessage());
		}
		
	}
	
	public String getApplicationURL() {
		String url=pro.getProperty("baseURl");
		return url;		
	}
	
	public String getUsername() {
		String username= pro.getProperty("username");
		return username;
	}
	public String getPassword() {
		String password= pro.getProperty("password");
		return password;
	}
	
	public String getChromepath() {
		String chromepath= pro.getProperty("chromepath");
		return chromepath;
	}
	
	public String getFirefoxpath() {
		String firefoxpath= pro.getProperty("firefoxpath");
		return firefoxpath;
	}
	
}
