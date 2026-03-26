package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constants.Constant;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {

	@Test(priority = 1, description = "Validating user login with valid credentials", groups = { "smoke" })
	public void verifyUserLoginWithValidCredentials() throws IOException {
		String userName = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(userName);
		login.enterPasswordOnPasswordField(password);
		login.clickLoginButton();
		boolean dashboardDisplay = login.isDashboardDisplayed();
		Assert.assertTrue(dashboardDisplay, Constant.ValidCredsError);
	}

	@Test(priority = 2, description = "Validating user login with invalid username")
	public void verifyUserLoginWithInvalidUserName() throws IOException {
		String userName = ExcelUtility.readStringData(1, 0, "LoginPage");
		String password = ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(userName);
		login.enterPasswordOnPasswordField(password);
		login.clickLoginButton();
		String actual = login.getPageText();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Constant.InvalidUsernameError);
	}

	@Test(priority = 3, description = "Validating user login with invalid password")
	public void verifyUserLoginWithInvalidPassword() throws IOException {
		String userName = ExcelUtility.readStringData(2, 0, "LoginPage");
		String password = ExcelUtility.readStringData(2, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(userName);
		login.enterPasswordOnPasswordField(password);
		login.clickLoginButton();
		String actual = login.getPageText();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Constant.InvalidPasswordError);
	}

	@Test(priority = 4, description = "Validating user login with invalid credentials", groups = { "smoke" })
	public void verifyUserLoginWithInvalidCredentials() throws IOException {
		String userName = ExcelUtility.readStringData(3, 0, "LoginPage");
		String password = ExcelUtility.readStringData(3, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(userName);
		login.enterPasswordOnPasswordField(password);
		login.clickLoginButton();
		String actual = login.getPageText();
		String expected = "7rmart supermarket";
		Assert.assertEquals(actual, expected, Constant.InvalidCredsError);

	}
}
