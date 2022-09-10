package TestCases;

import org.testng.annotations.Test;

import PageObjects.AddCustomer;
import PageObjects.LoginPage;

public class TC_AddCustomer_001 extends BaseClass {

	@Test
	public void AddCustomerMethod() throws Exception {
		driver.get(baseURl);
		logger.info("URL is Opened");
		
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(username);
		logger.info("Entered Username");
		
		lp.setPassword(password);
		logger.info("Entered Password");
		
		lp.clickSubmit();
		
				
		AddCustomer add= new AddCustomer(driver);
		add.ClickLinkaddCutomer();
		add.setCustomerName("Pavan");
		add.setGender();
	
	}
}
