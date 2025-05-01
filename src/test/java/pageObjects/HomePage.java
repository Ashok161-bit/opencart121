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
	    WebElement myAccount;

	    @FindBy(xpath = "//a[normalize-space()='Register']")
	    WebElement register;

	    @FindBy(xpath = "//a[normalize-space()='Login']")
	    WebElement login;

	    @FindBy(xpath = "//input[@placeholder='Search']")
	    WebElement enterText;

	    @FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
	    WebElement searchButton;

	    // Actions
	    public void clickMyAccount() {
	        myAccount.click();
	    }

	    public void clickRegister() {
	        register.click();
	    }

	    public void clickLogin() {
	        login.click();
	    }

	    public void enterProductName(String product) {
	        enterText.clear();
	        enterText.sendKeys(product);
	    }

	    public void clickSearch() {
	        searchButton.click();
	    }
	}

	
	

