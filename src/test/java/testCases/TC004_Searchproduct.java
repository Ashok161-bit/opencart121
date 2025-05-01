package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SearchProductTest;

public class TC004_Searchproduct extends BaseClass {

	
	@Test
	public void verify_productSearch() {
		
      logger.info("Starting TC004_Searchproduct");
      
      
      try {
    	  
      
      HomePage hp =new HomePage(driver);
      
	   hp.enterProductName("mac");
	
	   hp.clickSearch();
	   
	   SearchProductTest sp =new SearchProductTest(driver);
	   sp.isProductExist("MacBook");
	   
	   
	   Assert.assertEquals(sp.isProductExist("MacBook"),true);
      }catch(Exception e) {
    	  Assert.fail();
      }
      
      logger.info("finished TC_004_Searchprocuct");
	}
	
	
}
