package testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import automationcore.TestNGBase;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends TestNGBase
{
	@Test
	public void verifyUserIsAbleToSuccessfullyLogOut() throws IOException
	{
		 String userName=ExcelUtility.readStringData(0, 0, "LoginPage");
		 String password=ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login= new LoginPage(driver);
		login.enterUserNameOnUserNameField(userName);
		login.enterPasswordOnPasswordField(password);
		login.clickLoginButton();
		
		HomePage home= new HomePage(driver);
		home.clickOnAdminProfileIcon();
		home.clickOnLogOutIcon();
	}

}
