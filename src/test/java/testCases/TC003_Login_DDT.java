package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;

public class TC003_Login_DDT extends BaseClass {

	/*
	 * Data is valid - login success - test pass - logout
	 * Data is valid - login failed - test fail
	 * Data is invalid - login success - test fail
	 * Data is invalid - login failed - test pass
	 */

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void Verify_LoginDDT(String email, String pwd, String exp) {

		logger.info("******* Starting TC_003_LoginDDT *******");

		try {
			// Navigate to Login Page
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();

			// Perform Login
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(email);
			lp.setPassword(pwd);
			lp.clickLogin();

			// Verify Login
			MyAccountPage macc = new MyAccountPage(driver);
			boolean targetPage = macc.isMyAccountDisplayed();

			if (exp.equalsIgnoreCase("Valid")) {
				if (targetPage) {
					macc.clickLogout();
					Assert.assertTrue(true, "Login successful with valid credentials");
				} else {
					Assert.assertTrue(false, "Login failed with valid credentials");
				}
			} else if (exp.equalsIgnoreCase("Invalid")) {
				if (targetPage) {
					macc.clickLogout();
					Assert.assertTrue(false, "Login successful with invalid credentials");
				} else {
					Assert.assertTrue(true, "Login failed with invalid credentials");
				}
			}
		} catch (Exception e) {
			logger.error("Exception occurred: " + e.getMessage());
			Assert.fail("Test case failed due to an exception");
		}

		logger.info("******* Finished TC_003_LoginDDT *******");
	}
}
