package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base {

	HomePage home;

	@Test(description = "Validating successful logout of user")
	public void verifyUserIsAbleToSuccessfullyLogOut() throws IOException {
		String userName = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(userName).enterPasswordOnPasswordField(password);
		home = login.clickLoginButton();

		// HomePage home = new HomePage(driver);
		home.clickOnAdminProfileIcon();
		login = home.clickOnLogOutIcon();
		String actual = login.getPageText();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Constant.UnsuccessfulLogoutError);

	}

}
