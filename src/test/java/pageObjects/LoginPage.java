package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


 @FindBy(xpath="//input[@id='input-email']") 
 WebElement textemail;
 
 @FindBy(xpath="//input[@id='input-password']") 
 WebElement textpassword;
 
 @FindBy(xpath="//input[@value='Login']") 
 WebElement textlogin;
	

//Actions

public void setEmail(String email) {
	
	textemail.sendKeys(email);
}

public void setPassword(String pass) {
	textpassword.sendKeys(pass);
}

public void clicklogin() {
	textlogin.click();
}

}
