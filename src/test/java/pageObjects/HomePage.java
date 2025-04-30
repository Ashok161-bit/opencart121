package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	
	//constractor

		public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
		
		
	//elements
	@FindBy(xpath=("//a[@title='My Account']"))
	WebElement My_Account;
	
	@FindBy(xpath=("//a[normalize-space()='Register']"))
	WebElement Register;
		
	@FindBy(xpath=("//a[normalize-space()='Login']"))
	WebElement login;
			
	
     // Action Method
     public void myaccount() {
	  
    	 My_Account.click();
	  
  }
   
    public void Register() {
    	Register.click();
    }
   
    public void clickloginButton() {
    	login.click();
    }
	
	
}
	
	
	

