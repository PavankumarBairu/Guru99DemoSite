package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.AddCustomer;
import PageObjects.LoginPage;
import Utilities.ScreenshotProvider;

public class TC_Login_001 extends BaseClass {

	@Test
	public void logintest() throws Exception {
		driver.get(baseURl);
		logger.info("URL is Opened");
		
				
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		logger.info("Entered Username");
		
		lp.setPassword(password);
		logger.info("Entered Password");
		
		lp.clickSubmit();
		String act_tittle = "Guru99 Bank Manager HomePage";
		String exp_tittle = driver.getTitle();

		logger.info("Validating Title");
		if (act_tittle.equals(exp_tittle))
		{
			Assert.assertTrue(true);
			logger.info("Test is Passed");
		}
		else 
		{
			Assert.assertTrue(false);
			logger.info("Test is Failed");
		
		}
	}
		
		
	
	
	
	
	
	
}
