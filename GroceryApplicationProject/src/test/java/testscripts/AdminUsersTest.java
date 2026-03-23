package testscripts;

import java.io.IOException;

import org.testng.annotations.Test;

import automationcore.Base;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminUsersTest extends Base
{
	@Test(priority=1,description="Validating new user entry")
  public void verifyWhetherUserIsAbleToAddANewUser() throws IOException
  {
	  String userName=ExcelUtility.readStringData(0, 0, "LoginPage");
		 String password=ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login= new LoginPage(driver);
		login.enterUserNameOnUserNameField(userName);
		login.enterPasswordOnPasswordField(password);
		login.clickLoginButton();
		
		HomePage home= new HomePage(driver);
		home.clickOnMoreInfoAdminUsers();
		
		AdminUsersPage admin= new AdminUsersPage(driver);
		admin.clickOnNewIcon();
		admin.enterUserNameOnUserNameField();
		admin.enterPasswordOnPasswordField();
		admin.clickOnUserTypeField();
		admin.selectUserType();
		admin.clickOnSaveIcon();
  }
	@Test(priority=2,description="Validating user details search")
	public void verifyWhetherUserIsAbleToSearchAnUser() throws IOException
	{
		 String userName=ExcelUtility.readStringData(0, 0, "LoginPage");
		 String password=ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login= new LoginPage(driver);
		login.enterUserNameOnUserNameField(userName);
		login.enterPasswordOnPasswordField(password);
		login.clickLoginButton();
		
		HomePage home= new HomePage(driver);
		home.clickOnMoreInfoAdminUsers();
		
		AdminUsersPage admin= new AdminUsersPage(driver);
		admin.clickOnSearchIcon();
		admin.enterUserNameOnUserNameSearch();
		admin.clickOnUserTypeSearch();
		admin.selectUserCategory();
		admin.clickOnSearchButton();
	}
	@Test(priority=3,description="Validating reset option")
	public void verifyWhetherUserIsAbleToReset() throws IOException
	{
		String userName=ExcelUtility.readStringData(0, 0, "LoginPage");
		 String password=ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login= new LoginPage(driver);
		login.enterUserNameOnUserNameField(userName);
		login.enterPasswordOnPasswordField(password);
		login.clickLoginButton();
		
		HomePage home= new HomePage(driver);
		home.clickOnMoreInfoAdminUsers();
		
		AdminUsersPage admin= new AdminUsersPage(driver);
		admin.clickOnResetButton();
	}
}
