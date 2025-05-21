package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistationPage;

import pageObjects.HomePage;

public class TC001_Registration extends BaseClass {

	@Test
	public void verifyAccountRegistration() {

		logger.info("******* Starting TC001_AccountRegistrationTest *********");

		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("Clicked on My Account link");
			hp.clickRegister();
			logger.info("Clicked on Register link");

			AccountRegistationPage regPage = new AccountRegistationPage(driver);

			logger.info("Providing customer details");
			regPage.setFirstName(randomString().toUpperCase());
			regPage.setLastName(randomString().toUpperCase());
			regPage.setEmail(randomString() + "@gmail.com");
			regPage.setTelephone(randomNumeric());

			String password = randomAlphaNumeric();
			regPage.setPassword(password);
			regPage.setConfPassword(password);
			regPage.setPrivacyPolicy();
			regPage.clickContinueButton();

			logger.info("Validating expected message...");

			String confirmMsg = regPage.getConfirmationMsg();
			if (confirmMsg.equals("Your Account Has Been Created!")) {
				Assert.assertTrue(true);
				logger.info("Account registration test passed");
			} else {
				logger.error("Account registration test failed");
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			logger.error("Exception occurred: " + e.getMessage());
			Assert.fail();
		}

		logger.info("******* TC001_AccountRegistrationTest Finished *********");
	}
}