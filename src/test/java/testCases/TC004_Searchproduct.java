package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;

import pageObjects.SearchProductTest;

public class TC004_Searchproduct extends BaseClass {

	@Test
	public void verify_addProductToCart() {

		logger.info("Starting TC005_AddProductToCart");

		try {
			// Navigate to Home Page
			HomePage hp = new HomePage(driver);
			hp.enterSearchText("mac");
			hp.clickSearchButton();

			// Verify Product Exists
			SearchProductTest sp = new SearchProductTest(driver);
			boolean productExists = sp.isProductExist("macBook");
			Assert.assertEquals(productExists, true);

			
		} catch (Exception e) {
			logger.error("Exception occurred: " + e.getMessage());
			Assert.fail();
		}
	}
}	
				
				
				
				
				