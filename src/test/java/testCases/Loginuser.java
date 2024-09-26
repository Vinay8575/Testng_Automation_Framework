package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DeleteAccount;
import pageObjects.HomePage;
import pageObjects.Signup_Login;
import testBase.BaseClass;

public class Loginuser extends BaseClass{
	
	@Test(groups= {"sanity","master"})
	public void verifyuserlogin()
	{
		logger.info("************* started with Loginuser********** ");
		HomePage hp= new HomePage(driver);
		hp.clickonsignuporlogin();
		logger.info("************* clicked on signup or login ********** ");
		
		Signup_Login sl=new Signup_Login(driver);
		sl.txtloginemail(p.getProperty("email"));
		sl.txtloginpwd(p.getProperty("password"));
		sl.clicklogin();
		
		DeleteAccount da=new DeleteAccount(driver);
		boolean value=da.verifytext();
		
		Assert.assertTrue(value);
	}

}
