package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistationPage extends BasePage{

	public AccountRegistationPage(WebDriver driver) 
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
    //webelements
	
	@FindBy(xpath=("//input[@id='input-firstname']"))
	WebElement FirstName;
	
	@FindBy(xpath=("//input[@id='input-lastname']"))
	WebElement lastName;
	
	@FindBy(xpath=("//input[@id='input-email']"))
	WebElement Email;
	
	@FindBy(xpath=("//input[@id='input-telephone']"))
	WebElement telephone ;
	
	@FindBy(xpath=("//input[@id='input-password']"))
	WebElement password;
	
	@FindBy(xpath=("//input[@id='input-confirm']"))
	WebElement passwordConfirm;
	
	@FindBy(xpath=("//input[@name='agree']"))
	WebElement privacy;
	
	@FindBy(xpath=("//input[@value='Continue']"))
	WebElement continue_Button;
	
	
	
	@FindBy(xpath=("//h1[normalize-space()='Your Account Has Been Created!']"))
	WebElement msgConfirm;
	
	//Action Methods 
	
	public void setFirstname(String name) {
		FirstName.sendKeys(name);
	}
	
	public void setlastname(String lastname) {
		lastName.sendKeys(lastname);
	}
	public void setEmail(String email) {
		Email.sendKeys(email);
	}
	public void setTelephone(String tel) {
		telephone.sendKeys(tel);
	}
	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void setConfPassword(String pwd) {
		passwordConfirm.sendKeys(pwd);
	}
	
	public void setprivacypolicy() {
		privacy.click();
		
	}
	
	public void SetButton() {
		continue_Button.click();
	}
	
	public String getConfirmationMsg() {
		try {
			return(msgConfirm.getText());
		}catch(Exception e) {
			return(e.getMessage());
		}
	}
	
	
}