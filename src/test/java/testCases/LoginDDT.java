package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DeleteAccount;
import pageObjects.HomePage;
import pageObjects.Signup_Login;
import testBase.BaseClass;
import utilities.DataProviders;

public class LoginDDT extends BaseClass {
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups= {"master"})
	public void verifyloginwithmultiplesetsofdata(String email, String pswd, String exp)
	{
		try
		{
		HomePage hp= new HomePage(driver);
		hp.clickonsignuporlogin();
		logger.info("************* clicked on signup or login ********** ");
		
		Signup_Login sl=new Signup_Login(driver);
		sl.txtloginemail(email);
		sl.txtloginpwd(pswd);
		sl.clicklogin();
		
		DeleteAccount da=new DeleteAccount(driver);
		boolean value=da.verifytext();
		
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(value==true)
			{
				sl.clicklogout();
				Assert.assertTrue(value);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(value==true)
			{
				sl.clicklogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
