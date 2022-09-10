package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomer {

	WebDriver ldriver;

	public AddCustomer(WebDriver rdriver) {

		ldriver = rdriver;

		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'New Customer')]")
	@CacheLookup
	WebElement AddCustomer;
	
	@FindBy(xpath = "(//table[@align='center']//input)[1]")
	@CacheLookup
	WebElement CustomerName;
	
	@FindBy(xpath = "//input[@type='radio'][@value='m']")
	@CacheLookup
	WebElement Gender;
	
	@FindBy(xpath = "//textarea[@name='addr']")
	@CacheLookup
	WebElement Address;
	
	@FindBy(xpath = "//input[@name='city']")
	@CacheLookup
	WebElement City;
	
	@FindBy(xpath = "//input[@name='state']")
	@CacheLookup
	WebElement State;
	
	@FindBy(xpath = "//input[@name='pinno']")
	@CacheLookup
	WebElement Pincode;
	
	@FindBy(xpath = "//input[@name='telephoneno']")
	@CacheLookup
	WebElement Mobilenumber;
	
	@FindBy(xpath = "//input[@name='emailid']")
	@CacheLookup
	WebElement Email;
	
	@FindBy(xpath = "//input[@name='password']")
	@CacheLookup
	WebElement Password;
	
	@FindBy(xpath = "//input[@type='submit']")
	@CacheLookup
	WebElement Submit;
	
	
	
	
	public void ClickLinkaddCutomer() {
		AddCustomer.click();
	}

	public void setGender() {
		Gender.click();
	}
	
	public void setCustomerName(String customername) {
		CustomerName.sendKeys(customername);
	}
	
	
	
	
}
