package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@type='text']")
	WebElement userNameField;
	@FindBy(xpath = "//input[@type='password']")
	WebElement passwordField;
	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement loginButton;

	// Assertion
	@FindBy(xpath = "//p[text()='Dashboard']")
	WebElement dashboard;
	@FindBy(xpath = "//b[text()='7rmart supermarket']")
	WebElement pageText;

	public void enterUserNameOnUserNameField(String userName) {
		userNameField.sendKeys(userName);
	}

	public void enterPasswordOnPasswordField(String password) {
		passwordField.sendKeys(password);
	}

	public void clickLoginButton() {
		loginButton.click();
	}

	// Assertion
	public boolean isDashboardDisplayed() {
		return dashboard.isDisplayed();
	}

	public String getPageText() {
		return pageText.getText();
	}

}
