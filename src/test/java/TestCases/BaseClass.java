package TestCases;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import Utilities.Readconfig;
import Utilities.ScreenshotProvider;

public class BaseClass {

	Readconfig readconfig = new Readconfig();

	public String baseURl = readconfig.getApplicationURL();
	public String username = readconfig.getUsername();
	public String password = readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;

	/*
	 * system.getproperty("user.dir") -------> Only used in java class ./
	 * -----------------------------------> in java class & in in properties
	 * 
	 * forward slash for java class & backward slash for properties file
	 * 
	 */

//	1	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
//		driver= new ChromeDriver();

	@Parameters("browser")
	@BeforeClass
	public void setup(String browser) {
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j.properties");

		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", readconfig.getChromepath());
			driver = new ChromeDriver();
		}

		else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxpath());
			driver = new FirefoxDriver();
		}

	}
	
	@AfterClass
	public void TeardownBrowser() {
		driver.close();
	}

	@AfterMethod
	public void teardown(ITestResult result) {
		SimpleDateFormat dft= new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
		if(ITestResult.FAILURE==result.getStatus()) {
			ScreenshotProvider.CaptureScreenshot(driver, result.getTestContext().getName()+"-"+result.getMethod().getMethodName());
			System.out.println("Thank you,Screenshot taken is :- "+result.getTestContext().getName()+"-"+result.getMethod().getMethodName()+dft.format(new Date()));
		}
		
	}

}
