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
    List<WebElement> productTitles;

    @FindBy(xpath = "//div[@class='caption']/h4/a")
    List<WebElement> productLinks;

    @FindBy(id = "input-quantity")
    WebElement qty;

    @FindBy(id = "button-cart")
    WebElement addCart;

    @FindBy(css = "div.alert.alert-success.alert-dismissible")
    WebElement confMess;

    // Actions

    public boolean isProductExist(String productName) {
        for (WebElement product : productTitles) {
            if (product.getText().equalsIgnoreCase(productName)) {
                return true;
            }
        }
        return false;
    }

    public void selectProduct(String productName) {
        for (WebElement product : productLinks) {
            if (product.getText().equalsIgnoreCase(productName)) {
                product.click();
                break;
            }
        }
    }

    public void setQuantity(String quantity) {
        qty.clear();
        qty.sendKeys(quantity);
    }

    public void addToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(addCart)).click();
    }

    public boolean checkConfMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(confMess)).isDisplayed();
    }
}
