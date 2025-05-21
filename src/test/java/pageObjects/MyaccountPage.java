package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	// WebElements
	@FindBy(xpath = "//h2[normalize-space()='My Account']")
	private WebElement msgHeading;

	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
	private WebElement linkLogout;

	// Action Methods
	public boolean isMyAccountDisplayed() {
		try {
			return msgHeading.isDisplayed();
		} catch (Exception e) {
			System.out.println("Error checking 'My Account' heading: " + e.getMessage());
			return false;
		}
	}

	public void clickLogout() {
		try {
			if (linkLogout != null) {
				linkLogout.click();
			}
		} catch (Exception e) {
			System.out.println("Error clicking 'Logout' link: " + e.getMessage());
		}
	}
}