package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyaccountPage;

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
	lp.clicklogin();
	
	//My account page
	
	MyaccountPage macc= new MyaccountPage(driver);
	boolean targetPage=macc.isMyAccountExist();
	
	Assert.assertEquals(targetPage, true,"Login Failed");
	
	logger.info("*****Finishing TC_002_Logintest***********");
	
	}
	catch(Exception e) {
		Assert.fail();
	}
	}
	
}
