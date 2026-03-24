package testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import automationcore.Base;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {
	@Test(priority = 1, description = "Validating new News entry")
	public void verifyWhetherUserIsAbleToAddANewNews() throws IOException {
		String userName = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(userName);
		login.enterPasswordOnPasswordField(password);
		login.clickLoginButton();

		HomePage home = new HomePage(driver);
		home.clickOnMoreInfoNews();

		ManageNewsPage news = new ManageNewsPage(driver);
		news.clickOnNewIcon();
		news.enterNewNewsOnNewsField();
		news.clickOnSaveButton();
	}

	@Test(priority = 2, description = "Validating search news option")
	public void verifyWhetherUserIsAbleToSearchANews() throws IOException {
		String userName = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(userName);
		login.enterPasswordOnPasswordField(password);
		login.clickLoginButton();

		HomePage home = new HomePage(driver);
		home.clickOnMoreInfoNews();

		ManageNewsPage news = new ManageNewsPage(driver);
		news.clickOnSearchIcon();
		news.enterNewsOnNewsSearchField();
		news.clickOnSearchButton();

	}

	@Test(priority = 3, description = "Validating reset news option")
	public void verifyWhetherUserIsAbleToReset() throws IOException {
		String userName = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(userName);
		login.enterPasswordOnPasswordField(password);
		login.clickLoginButton();

		HomePage home = new HomePage(driver);
		home.clickOnMoreInfoNews();

		ManageNewsPage news = new ManageNewsPage(driver);
		news.clickOnResetIcon();
	}

}
