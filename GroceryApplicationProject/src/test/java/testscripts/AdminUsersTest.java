package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constants.Constant;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;

public class AdminUsersTest extends Base {

	HomePage home;

	@Test(priority = 1, description = "Validating new user entry")
	public void verifyWhetherUserIsAbleToAddANewUser() throws IOException {
		FakerUtility faker = new FakerUtility();
		String newUserName = faker.createRandomUserName();
		String newPassword = faker.createRandomPassword();
		String userName = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(userName).enterPasswordOnPasswordField(password);
		home = login.clickLoginButton();

		// HomePage home = new HomePage(driver);
		home.clickOnMoreInfoAdminUsers();

		AdminUsersPage admin = new AdminUsersPage(driver);
		admin.clickOnNewIcon().enterNewUserNameOnUserNameField(newUserName).enterNewPasswordOnPasswordField(newPassword)
				.clickOnUserTypeField().selectUserType().clickOnSaveIcon();

		boolean alertDisplay = admin.isAlertDisplayed();
		Assert.assertTrue(alertDisplay, Constant.UserEntryError);
	}

	@Test(priority = 2, description = "Validating user details search")
	public void verifyWhetherUserIsAbleToSearchAnUser() throws IOException {
		String userName = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(userName).enterPasswordOnPasswordField(password);
		home = login.clickLoginButton();

		// HomePage home = new HomePage(driver);
		home.clickOnMoreInfoAdminUsers();

		AdminUsersPage admin = new AdminUsersPage(driver);
		admin.clickOnSearchIcon().enterUserNameOnUserNameSearch().clickOnUserTypeSearch().selectUserCategory()
				.clickOnSearchButton();

		boolean usersList = admin.adminUsersList();
		Assert.assertTrue(usersList, Constant.UserSearchError);
	}

	@Test(priority = 3, description = "Validating reset users option")
	public void verifyWhetherUserIsAbleToReset() throws IOException {
		String userName = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(userName).enterPasswordOnPasswordField(password);
		home = login.clickLoginButton();

		// HomePage home = new HomePage(driver);
		home.clickOnMoreInfoAdminUsers();

		AdminUsersPage admin = new AdminUsersPage(driver);
		admin.clickOnResetButton();

		boolean resetList = admin.adminUsersList();
		Assert.assertTrue(resetList, Constant.UserResetError);
	}
}
