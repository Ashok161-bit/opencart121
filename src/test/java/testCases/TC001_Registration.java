package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistationPage;
import pageObjects.HomePage;

public class TC001_Registration extends BaseClass{

		
	@Test
	public void verify_AccountRegistrationPage() {
	
		logger.info("******* starting TC001_AccountRegistationTest*********");
		
		try {
		
		HomePage hp= new HomePage(driver);
		hp.myaccount();
		logger.info("Clicked on Myaccount Link");
		hp.Register();	
		logger.info("Clicked on Registared Link");
		AccountRegistationPage regpage=new AccountRegistationPage(driver);
		
		logger.info("provideing customer details");
		regpage.setFirstname(randomString().toUpperCase());
		regpage.setlastname(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com");
		regpage.setTelephone(randomNumaric());
		
		String password= randomAlphaNumaric();
		regpage.setPassword(password);
		regpage.setConfPassword(password);
		regpage.setprivacypolicy();
		regpage.SetButton();
		logger.info("Validating expected Message.......");
		
		String confimsg=regpage.getConfirmationMsg();	
		//Assert.assertEquals(confimsg, "Your Account Has Been Created!");
		if(confimsg.equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
		}else {
			logger.error("Test failed....");
			logger.debug("Debug logs...");
			Assert.assertTrue(false);
		}
	}
		catch(Exception e) {
			
			Assert.fail();
		}
		
		logger.info("*****Tc001_AccountRegistationtestFinished******");
	}

	
}
