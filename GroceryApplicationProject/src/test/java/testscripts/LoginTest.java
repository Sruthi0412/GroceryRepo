package testscripts;


import java.io.IOException;

import org.testng.annotations.Test;

import automationcore.Base;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base
{
	
	@Test
	public void verifyUserLoginWithValidCredentials() throws IOException
	{
		 String userName=ExcelUtility.readStringData(0, 0, "LoginPage");
		 String password=ExcelUtility.readStringData(0, 1, "LoginPage");
		LoginPage login= new LoginPage(driver);
		login.enterUserNameOnUserNameField(userName);
		login.enterPasswordOnPasswordField(password);
		login.clickLoginButton();
	}
	
	@Test
	public void verifyUserLoginWithInvalidUserName() throws IOException
	{
		 String userName=ExcelUtility.readStringData(1, 0, "LoginPage");
		 String password=ExcelUtility.readStringData(1, 1, "LoginPage");
		LoginPage login= new LoginPage(driver);
		login.enterUserNameOnUserNameField(userName);
		login.enterPasswordOnPasswordField(password);
		login.clickLoginButton();
	}
	
	@Test
	public void  verifyUserLoginWithInvalidPassword() throws IOException
	{
		 String userName=ExcelUtility.readStringData(2, 0, "LoginPage");
		 String password=ExcelUtility.readStringData(2, 1, "LoginPage");
		LoginPage login= new LoginPage(driver);
		login.enterUserNameOnUserNameField(userName);
		login.enterPasswordOnPasswordField(password);
		login.clickLoginButton();
	}
	
	@Test
	public void verifyUserLoginWithInvalidCredentials() throws IOException
	{
		 String userName=ExcelUtility.readStringData(3, 0, "LoginPage");
		 String password=ExcelUtility.readStringData(3, 1, "LoginPage");
		LoginPage login= new LoginPage(driver);
		login.enterUserNameOnUserNameField(userName);
		login.enterPasswordOnPasswordField(password);
		login.clickLoginButton();
	}	

}
