package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminUsersPage 
{
    public WebDriver driver;
	
	public AdminUsersPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//New User
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement newIcon;
	@FindBy(id="username")WebElement userNameField;
	@FindBy(id="password")WebElement passwordField;
	@FindBy(id="user_type")WebElement userTypeIcon;
	@FindBy(xpath="//button[@class='btn btn-block-sm btn-danger']//parent::button[@name='Create']")WebElement saveIcon;
	
	//Search
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")WebElement searchIcon;
	@FindBy(id="un")WebElement userNameIcon;
	@FindBy(id="ut")WebElement userType;
	@FindBy(xpath="//button[@class='btn btn-block-sm btn-danger']//parent::button[@name='Search']")WebElement searchButton;
	
	//Reset
	@FindBy(xpath="//a[@class='btn btn-rounded btn-warning']")WebElement ResetButton;
	
	
	//New User
	public void clickOnNewIcon()
	{
		newIcon.click();
	}
	public void enterUserNameOnUserNameField()
	{
		userNameField.sendKeys("Sruthi Sankar");
	}
	public void enterPasswordOnPasswordField()
	{
		passwordField.sendKeys("Sruthi");
	}
	public void clickOnUserTypeField()
	{
		userTypeIcon.click();
	}
	public void selectUserType()
	{
		Select select= new Select(userTypeIcon);
		select.selectByValue("staff");
		userTypeIcon.click();
	}
	public void clickOnSaveIcon()
	{
		saveIcon.click();
	}
	
	//Search
	public void clickOnSearchIcon()
	{
		searchIcon.click();
	}
	public void enterUserNameOnUserNameSearch()
	{
		userNameIcon.sendKeys("Sruthi Sankar");
	}
	public void clickOnUserTypeSearch()
	{
		userType.click();
	}
	public void selectUserCategory()
	{
		Select select= new Select(userType);
		select.selectByValue("staff");
		userType.click();
	}
	public void clickOnSearchButton()
	{
		searchButton.click();
	}
	
	//Reset
	public void clickOnResetButton()
	{
		ResetButton.click();
	}
}
