package testCases;

import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.Signup_Login;
import testBase.BaseClass;

public class Registeruser extends BaseClass {
	
	@Test(groups= {"regression","master"})
	public void verifyuserregistration()
	{
		logger.info("************* started with Registeruser********** ");
		HomePage hp= new HomePage(driver);
		hp.clickonsignuporlogin();
		logger.info("************* clicked on signup or login ********** ");
		
		Signup_Login sl=new Signup_Login(driver);
		sl.txtsignupname(Randomstring());
		sl.txtsignuemail(Randomstring()+"@gmail.com");
		logger.info("************* entered new user details ********** ");
		sl.clicksignup();
		logger.info("************* clicked on signupbutton ********** ");
		sl.verifyaccountinformation();
		
	}

}
