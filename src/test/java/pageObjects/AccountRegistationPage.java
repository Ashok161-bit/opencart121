package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountRegistationPage extends BasePage {

	public AccountRegistationPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this); // Initialize web elements
	}

	// WebElements
	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement firstName;

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement lastName;

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement email;

	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement telephone;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement password;

	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement passwordConfirm;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement privacy;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement continueButton;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirm;

	// Action Methods
	public void setFirstName(String name) {
		firstName.sendKeys(name);
	}

	public void setLastName(String lastname) {
		lastName.sendKeys(lastname);
	}

	public void setEmail(String email) {
		this.email.sendKeys(email);
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

	public void setPrivacyPolicy() {
		privacy.click();
	}

	public void clickContinueButton() {
		continueButton.click();
	}

	public String getConfirmationMsg() {
		try {
			return msgConfirm.getText();
		} catch (Exception e) {
			return e.getMessage();
		}
	}
}