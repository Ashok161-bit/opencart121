package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // WebElements
    @FindBy(xpath = "//input[@id='input-email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='input-password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@value='Login']")
    private WebElement loginButton;

    // Action Methods
    public void setEmail(String email) {
        try {
            if (emailField != null) {
                emailField.clear();
                emailField.sendKeys(email);
            }
        } catch (Exception e) {
            System.out.println("Error setting email: " + e.getMessage());
        }
    }

    public void setPassword(String password) {
        try {
            if (passwordField != null) {
                passwordField.clear();
                passwordField.sendKeys(password);
            }
        } catch (Exception e) {
            System.out.println("Error setting password: " + e.getMessage());
        }
    }

    public void clickLogin() {
        try {
            if (loginButton != null) {
                loginButton.click();
            }
        } catch (Exception e) {
            System.out.println("Error clicking login button: " + e.getMessage());
        }
    }
}