package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyaccountPage extends BasePage {

	public MyaccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

		
	@FindBy(xpath=("//h2[normalize-space()='My Account']"))
	WebElement Msgheading;
	
	@FindBy(xpath=("//a[@class='list-group-item'][normalize-space()='Logout']"))
	WebElement linkLogout;
	
	
	public boolean isMyAccountExist() {
		
		try 
		{
					
	       return (Msgheading.isDisplayed());	
		} 
		catch(Exception e) {
			
			return false;
		}
	
		
	}
	
	public void ClickLogout() {
		linkLogout.click();
	}
	
}
