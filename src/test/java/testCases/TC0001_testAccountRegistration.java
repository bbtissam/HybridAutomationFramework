package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC0001_testAccountRegistration extends BaseClass{
	
  @Test(groups = {"regression","master"})
  public void testRegister() {
	  
	  try {
	  
	  HomePage hp=new HomePage(driver);
	  logger.info("***** Starting test Account Registration *****");
	  logger.info("***** click my account *****");
	  hp.clickMyAccount();
	  logger.info("***** click Register *****");
	  hp.ClickRegister();
	  
	  logger.info("***** Fill Your Personal Details *****");
	  AccountRegistrationPage arp=new AccountRegistrationPage(driver);
	  
	  arp.setFirstName(randomString());
	  arp.setLastName(randomString());
	  arp.setEmail(randomString()+"@gmail.com");
	  arp.setTelephone("06"+randomNumber());
	  
	  String pwd=randomStringNumber();
	  arp.setPassword(pwd);
	  arp.setPasswordConfirm(pwd);
	  
	  arp.clickCheckBoxAgree();
	  arp.clickBtnContinue();
	  
	  String confirmMessage=arp.getConfirmationMsg();
	  if(confirmMessage.equals("Congratulations! Your new account has been successfully created!")) {
		  Assert.assertTrue(true);
	  }else {
		  logger.error("***** test Failed *****");
		  logger.debug("***** debug test *****");
		  Assert.assertTrue(false);
	  }
	  //Assert.assertEquals(arp.getConfirmationMsg(), "Congratulations! Your new account has been successfully created!");
	  
	  }catch(Exception e) {
		 
		  Assert.fail();
	  }
	  logger.info("***** Finished test Account Registration *****");
	  
  }
}
