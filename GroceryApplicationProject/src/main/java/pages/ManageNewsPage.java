package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constant;
import utilities.WaitUtility;

public class ManageNewsPage {
	public WebDriver driver;
	WaitUtility wait= new WaitUtility();

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// New User
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/news/add']")
	WebElement newIcon;
	@FindBy(id = "news")
	WebElement newNewsField;
	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement saveButton;

	// Search News
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']")
	WebElement searchIcon;
	@FindBy(xpath = "//input[@class='form-control']")
	WebElement searchNewsField;
	@FindBy(xpath = "//button[@class='btn btn-danger btn-fix']")
	WebElement searchButton;

	// Reset
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-warning']")
	WebElement resetIcon;

	// Assertion
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement AlertMsg;
	@FindBy(xpath = "//h4[text()='Manage News']")
	WebElement newsSearch;
	@FindBy(xpath = "//input[@type='text']")
	WebElement userNameField;

	// New News
	public ManageNewsPage clickOnNewIcon() {
		wait.waitUntilElementToBeClickable(driver, newIcon);
		newIcon.click();
		return this;
	}

	public ManageNewsPage enterNewNewsOnNewsField() {
		newNewsField.sendKeys(Constant.NewNewsEntry);
		return this;
	}

	public ManageNewsPage clickOnSaveButton() {
		saveButton.click();
		return this;
	}

	// Search News
	public ManageNewsPage clickOnSearchIcon() {
		searchIcon.click();
		return this;
	}

	public ManageNewsPage enterNewsOnNewsSearchField() {
		searchNewsField.sendKeys(Constant.NewsSearch);
		return this;
	}

	public ManageNewsPage clickOnSearchButton() {
		searchButton.click();
		return this;
	}

	// Reset
	public ManageNewsPage clickOnResetIcon() {
		wait.waitUntilElementToBeClickable(driver, resetIcon);
		resetIcon.click();
		return this;
	}

	// Assertion
	public boolean isAlertDisplayed() {
		return AlertMsg.isDisplayed();
	}

	public boolean searchResult() {
		return newsSearch.isDisplayed();
	}

	public boolean resetList() {
		return userNameField.isDisplayed();
	}

}
