package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	// Constructor
	public HomePage(WebDriver driver) {
		super(driver);
	}

	// Elements
	@FindBy(xpath = "//a[@title='My Account']")
	private WebElement myAccount;

	@FindBy(xpath = "//a[normalize-space()='Register']")
	private WebElement register;

	@FindBy(xpath = "//a[normalize-space()='Login']")
	private WebElement login;

	@FindBy(xpath = "//input[@placeholder='Search']")
	private WebElement searchBox;

	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
	private WebElement searchButton;

	// Actions
	public void clickMyAccount() {
		try {
			if (myAccount != null) {
				myAccount.click();
			}
		} catch (Exception e) {
			System.out.println("Error clicking 'My Account': " + e.getMessage());
		}
	}

	public void clickRegister() {
		try {
			if (register != null) {
				register.click();
			}
		} catch (Exception e) {
			System.out.println("Error clicking 'Register': " + e.getMessage());
		}
	}

	public void clickLogin() {
		try {
			if (login != null) {
				login.click();
			}
		} catch (Exception e) {
			System.out.println("Error clicking 'Login': " + e.getMessage());
		}
	}

	public void enterSearchText(String product) {
		try {
			if (searchBox != null) {
				searchBox.clear();
				searchBox.sendKeys(product);
			}
		} catch (Exception e) {
			System.out.println("Error entering search text: " + e.getMessage());
		}
	}

	public void clickSearchButton() {
		try {
			if (searchButton != null) {
				searchButton.click();
			}
		} catch (Exception e) {
			System.out.println("Error clicking 'Search' button: " + e.getMessage());
		}
	}
}