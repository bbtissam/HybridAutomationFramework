package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC0002_testLogin extends BaseClass{

	@Test(groups = {"sanity","master"})
	public void testLogin() {
		logger.info("***** Starting TC0002test Login *****");
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("psswd"));
		lp.clickLogin();
		
		AccountPage ap=new AccountPage(driver);
		boolean status=ap.isMyAccountDisplayed();
		Assert.assertTrue(status);
		}catch(Exception e) {
			Assert.fail();
		}
		logger.info("***** Finished TC0002test Login *****");
	}
}
