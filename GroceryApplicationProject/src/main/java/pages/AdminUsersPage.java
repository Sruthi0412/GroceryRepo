package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;
import utilities.WaitUtility;

public class AdminUsersPage {
	public WebDriver driver;
	WaitUtility wait= new WaitUtility();
	PageUtility page = new PageUtility();

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// New User
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newIcon;
	@FindBy(id = "username")
	WebElement userNameField;
	@FindBy(id = "password")
	WebElement passwordField;
	@FindBy(id = "user_type")
	WebElement userTypeIcon;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-danger']//parent::button[@name='Create']")
	WebElement saveIcon;

	// Search
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchIcon;
	@FindBy(id = "un")
	WebElement userNameIcon;
	@FindBy(id = "ut")
	WebElement userType;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-danger']//parent::button[@name='Search']")
	WebElement searchButton;

	// Reset
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	WebElement ResetButton;

	// Assertion
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement AlertMsg;
	@FindBy(xpath = "//h4[text()='Admin Users']")
	WebElement usersList;

	// New User
	public AdminUsersPage clickOnNewIcon() {
		newIcon.click();
		return this;
	}

	public AdminUsersPage enterNewUserNameOnUserNameField(String newUserName) {
		userNameField.sendKeys(newUserName);
		return this;
	}

	public AdminUsersPage enterNewPasswordOnPasswordField(String newPassword) {
		passwordField.sendKeys(newPassword);
		return this;
	}

	public AdminUsersPage clickOnUserTypeField() {
		userTypeIcon.click();
		return this;
	}

	public AdminUsersPage selectUserType() {
		page.selectDropdownWithValue(userTypeIcon, "staff");
		// Select select = new Select(userTypeIcon);
		// select.selectByValue("staff");
		userTypeIcon.click();
		return this;
	}

	public AdminUsersPage clickOnSaveIcon() {
		saveIcon.click();
		return this;
	}

	// Search
	public AdminUsersPage clickOnSearchIcon() {
		wait.waitUntilElementToBeClickable(driver, searchIcon);
		searchIcon.click();
		return this;
	}

	public AdminUsersPage enterUserNameOnUserNameSearch() {
		userNameIcon.sendKeys("Sruthi Sankar");
		return this;
	}

	public AdminUsersPage clickOnUserTypeSearch() {
		userType.click();
		return this;
	}

	public AdminUsersPage selectUserCategory() {
		page.selectDropdownWithValue(userType, "staff");
		// Select select = new Select(userType);
		// select.selectByValue("staff");
		userType.click();
		return this;
	}

	public AdminUsersPage clickOnSearchButton() {
		searchButton.click();
		return this;
	}

	// Reset
	public AdminUsersPage clickOnResetButton() {
		ResetButton.click();
		return this;
	}

	// Assertion
	public boolean isAlertDisplayed() {
		return AlertMsg.isDisplayed();
	}

	public boolean adminUsersList() {
		return usersList.isDisplayed();
	}
}
