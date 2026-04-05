package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='nav-link']//parent::li[@class='nav-item dropdown']")
	WebElement adminIcon;
	@FindBy(xpath = "//a[@class='dropdown-item']//following::a[@class='dropdown-item']")
	WebElement logOutIcon;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']//parent::a[@class='small-box-footer']")
	WebElement moreInfoIcon;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news']//parent::a[@class='small-box-footer']")
	WebElement moreInfoNews;

	// Assertion
	@FindBy(xpath = "//b[text()='7rmart supermarket']")
	WebElement pageText;

	public HomePage clickOnAdminProfileIcon() {
		adminIcon.click();
		return this;
	}

	public LoginPage clickOnLogOutIcon() {
		logOutIcon.click();
		return new LoginPage(driver);
	}

	public AdminUsersPage clickOnMoreInfoAdminUsers() {
		moreInfoIcon.click();
		return new AdminUsersPage(driver);
	}

	public ManageNewsPage clickOnMoreInfoNews() {
		moreInfoNews.click();
		return new ManageNewsPage(driver);
	}

	// Assertion

	public String getPageText() {
		return pageText.getText();
	}

}
