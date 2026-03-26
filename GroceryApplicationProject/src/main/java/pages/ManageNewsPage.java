package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	public WebDriver driver;

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
	public void clickOnNewIcon() {
		newIcon.click();
	}

	public void enterNewNewsOnNewsField() {
		newNewsField.sendKeys("Game of Thrones between Iran & US");
	}

	public void clickOnSaveButton() {
		saveButton.click();
	}

	// Search News
	public void clickOnSearchIcon() {
		searchIcon.click();
	}

	public void enterNewsOnNewsSearchField() {
		searchNewsField.sendKeys("Black Friday");
	}

	public void clickOnSearchButton() {
		searchButton.click();
	}

	// Reset
	public void clickOnResetIcon() {
		resetIcon.click();
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
