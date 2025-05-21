package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchProductTest extends BasePage {

    // Constructor
    public SearchProductTest(WebDriver driver) {
        super(driver);
    }

    // WebElements
    @FindBy(xpath = "//div[@class='caption']/h4")
    private List<WebElement> productTitles;

    @FindBy(xpath = "//div[@class='caption']/h4/a")
    private List<WebElement> productLinks;

    @FindBy(id = "input-quantity")
    private WebElement quantityField;

    @FindBy(id = "button-cart")
    private WebElement addToCartButton;

    @FindBy(css = "div.alert.alert-success.alert-dismissible")
    private WebElement confirmationMessage;

    // Actions

    public boolean isProductExist(String productName) {
        try {
            if (productTitles != null) {
                for (WebElement product : productTitles) {
                    if (product.getText().equalsIgnoreCase(productName)) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error checking product existence: " + e.getMessage());
        }
        return false;
    }

    public void selectProduct(String productName) {
        try {
            if (productLinks != null) {
                for (WebElement product : productLinks) {
                    if (product.getText().equalsIgnoreCase(productName)) {
                        product.click();
                        break;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error selecting product: " + e.getMessage());
        }
    }

    public void setQuantity(String quantity) {
        try {
            if (quantityField != null) {
                quantityField.clear();
                quantityField.sendKeys(quantity);
            }
        } catch (Exception e) {
            System.out.println("Error setting quantity: " + e.getMessage());
        }
    }

    public void addToCart() {
        try {
            if (addToCartButton != null) {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
            }
        } catch (Exception e) {
            System.out.println("Error adding product to cart: " + e.getMessage());
        }
    }

    public boolean checkConfirmationMessage() {
        try {
            if (confirmationMessage != null) {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
                return wait.until(ExpectedConditions.visibilityOf(confirmationMessage)).isDisplayed();
            }
        } catch (Exception e) {
            System.out.println("Error checking confirmation message: " + e.getMessage());
        }
        return false;
    }
}