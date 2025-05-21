package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchProductTest;

public class TC005_AddToCartPage extends BaseClass{

	@Test
	public void verify_addToCart() {
		
		 logger.info("Starting TC004_AddRToCartPage");
		
		 try {
					 
		 HomePage hp= new HomePage(driver);
		 hp.enterSearchText("iphone");
		 hp.clickSearchButton();
		 
		 SearchProductTest sp= new SearchProductTest(driver);
		 
		 if(sp.isProductExist("iphone")) 
		 
		 {
			sp.selectProduct("iphone");
			sp.setQuantity("2");
			sp.addToCart();			 			 
		 }
		 Assert.assertEquals(sp.checkConfirmationMessage(), true);
		
	}
	catch(Exception e) {
		Assert.fail();
	}
		 
		 logger.info("Finished TC004_AddRToCartPage");		 
	
}
}