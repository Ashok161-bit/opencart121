package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyaccountPage;
import utilities.DataProviders;

public class TC003_Login_DDT extends BaseClass {

/* data is vaid -login Success -test pass-logout
 * data is valid  -login failed -test fail
 * 
 * data is invalid  -login success  -test fail
 * data is invalid -- login failed =test pass
 * 
 */
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class) //getting data provider from different class that reason data.class
	public void Verify_LoginDDT(String email, String pwd,String exp)  {
		
		logger.info("******* Starting TC_003_LogingDDT*****");
		//homepa ge
		
		try {
			
		
		HomePage hp= new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		//Login Page
		LoginPage lp= new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clicklogin();
		
		//My account page
		
		MyaccountPage macc= new MyaccountPage(driver);
		boolean targetPage=macc.isMyAccountExist();
		
		
		if(exp.equalsIgnoreCase("Valid"))
		{
			
			if(targetPage==true)
			{
				macc.ClickLogout();
				Assert.assertTrue(true);
				
			}
			
			else {
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("Invalid")) {
			
			if(targetPage==true) {
				
				macc.ClickLogout();
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(true);
			}
		}
		}catch(Exception e) {
			Assert.fail();
		}
		logger.info("******* Finished TC_003_LogingDDT*****");
	}

	
	
}
