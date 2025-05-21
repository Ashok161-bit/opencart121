package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;


public class TC002_LoginTest extends BaseClass {

	
	@Test
	public void Verify_Login() {
		
	logger.info("*****Starting TC_002_Logintest****");	
	
	try {
		
	
	HomePage hp= new HomePage(driver);
	hp.clickMyAccount();
	hp.clickLogin();
	
	//Login Page
	LoginPage lp= new LoginPage(driver);
	lp.setEmail(p.getProperty("email"));
	lp.setPassword(p.getProperty("password"));
	lp.clickLogin();
	
	//My account page
	
	MyAccountPage macc= new MyAccountPage(driver);
	boolean targetPage=macc.isMyAccountDisplayed();
	
	Assert.assertEquals(targetPage, true,"Login Failed");
	
	logger.info("*****Finishing TC_002_Logintest***********");
	
	}
	catch(Exception e) {
		logger.error("Exception occurred: " + e.getMessage());
		Assert.fail();
	}
	}
	
}
