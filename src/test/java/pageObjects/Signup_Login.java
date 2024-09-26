package pageObjects;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Signup_Login extends BasePage {
	
	public Signup_Login(WebDriver driver)
	{
		super(driver);
	}
	
	//locators
	
	@FindBy(xpath="//input[@data-qa='signup-name']")
	WebElement signupname;
	
	@FindBy(xpath="//input[@data-qa='signup-email']")
	WebElement signupemail;
	
	@FindBy(xpath="//button[@data-qa='signup-button']")
	WebElement btnsignup;
	
	@FindBy(xpath="//b[text()='Enter Account Information']")
	WebElement txtaccountverification;
	
	@FindBy(xpath="//a[text()=' Logout']")
	WebElement lnklogout;
	
	@FindBy(xpath="//input[@data-qa='login-email']")
	WebElement loginemail;
	
	@FindBy(xpath="//input[@data-qa='login-password']")
	WebElement loginpwd;
	
	@FindBy(xpath="//button[@data-qa='login-button']")
	WebElement btnlogin;
	
	public void txtsignupname(String name)
	{
		signupname.sendKeys(name);
	}
	
	public void txtsignuemail(String email)
	{
		signupemail.sendKeys(email);
	}
	
	public void clicksignup()
	{
		btnsignup.click();
	}
	
	public String getaccountinformpage()
	{
		try {
		return (txtaccountverification.getText());
		}
		catch(Exception e)
		{
			return(e.getMessage());
		}
	}
	
	public void verifyaccountinformation()
	{
		try 
		{
		String txt=getaccountinformpage();
		Assert.assertEquals(txt, "ENTER ACCOUNT INFORMATION");
		}
		catch(Exception e)
		{
		  System.out.println(e.getMessage());
		}
	}
	
	public void clicklogout()
	{
		lnklogout.click();
	}
	
	public void txtloginemail(String name)
	{
		loginemail.sendKeys(name);
	}
	
	public void txtloginpwd(String email)
	{
		loginpwd.sendKeys(email);
	}
	
	public void clicklogin()
	{
		btnlogin.click();
	}

}
