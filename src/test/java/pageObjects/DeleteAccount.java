package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteAccount extends BasePage{
	
	public DeleteAccount(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(xpath="//a[text()=' Delete Account']")
	WebElement lnkdeleteaccount;
	
	public void clickdeleteaccount()
	{
		lnkdeleteaccount.click();	
	}
	
	public boolean verifytext()
	{
		try
		{
		return (lnkdeleteaccount.isDisplayed());
		}
		catch(Exception e)
		{
			return (false);
		}
	}
	
}
