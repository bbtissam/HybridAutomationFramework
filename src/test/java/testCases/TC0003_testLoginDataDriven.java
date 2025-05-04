package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC0003_testLoginDataDriven extends BaseClass{
	
	@Test(dataProvider = "LoginData",dataProviderClass = DataProviders.class)
	public void testLogin(String email,String pwd,String exp) throws InterruptedException {
		
		logger.info("***** Starting TC0002test Login *****");
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();
		
		AccountPage ap=new AccountPage(driver);
		boolean status=ap.isMyAccountDisplayed();
		
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(status==true)
			{			
				ap.clickLogout();
				Assert.assertTrue(true);
				
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(status==true)
			{
				ap.clickLogout();
				Assert.assertTrue(false);
				
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		
		}catch(Exception e)
		{
			Assert.fail();
		}
		Thread.sleep(3000);
		logger.info("***** Finished TC0002test Login *****");
	}

}
