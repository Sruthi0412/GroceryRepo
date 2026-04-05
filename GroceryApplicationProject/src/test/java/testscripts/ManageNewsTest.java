package testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constants.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {

	HomePage home;

	@Test(priority = 1, description = "Validating new News entry")
	public void verifyWhetherUserIsAbleToAddANewNews() throws IOException {
		String userName = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(userName).enterPasswordOnPasswordField(password);
		home = login.clickLoginButton();

		// HomePage home = new HomePage(driver);
		home.clickOnMoreInfoNews();

		ManageNewsPage news = new ManageNewsPage(driver);
		news.clickOnNewIcon().enterNewNewsOnNewsField().clickOnSaveButton();

		boolean alertDisplay = news.isAlertDisplayed();
		Assert.assertTrue(alertDisplay, Constant.NewsEntryError);
	}

	@Test(priority = 2, description = "Validating search news option")
	public void verifyWhetherUserIsAbleToSearchANews() throws IOException {
		String userName = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(userName).enterPasswordOnPasswordField(password);
		home = login.clickLoginButton();

		// HomePage home = new HomePage(driver);
		home.clickOnMoreInfoNews();

		ManageNewsPage news = new ManageNewsPage(driver);
		news.clickOnSearchIcon().enterNewsOnNewsSearchField().clickOnSearchButton();

		boolean searchNews = news.searchResult();
		Assert.assertTrue(searchNews, Constant.NewsSearchError);

	}

	@Test(priority = 3, description = "Validating reset news option", retryAnalyzer = retrymechanism.Retry.class)
	public void verifyWhetherUserIsAbleToReset() throws IOException {
		String userName = ExcelUtility.readStringData(0, 0, "LoginPage");
		String password = ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login = new LoginPage(driver);
		login.enterUserNameOnUserNameField(userName).enterPasswordOnPasswordField(password);
		home = login.clickLoginButton();

		// HomePage home = new HomePage(driver);
		home.clickOnMoreInfoNews();

		ManageNewsPage news = new ManageNewsPage(driver);
		news.clickOnResetIcon();

		boolean resetNews = news.resetList();
		Assert.assertFalse(resetNews, Constant.NewsResetError);

	}

}
