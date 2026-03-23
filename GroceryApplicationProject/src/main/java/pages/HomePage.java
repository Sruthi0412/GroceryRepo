package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	public WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//a[@class='nav-link']//parent::li[@class='nav-item dropdown']")WebElement adminIcon;
	@FindBy(xpath="//a[@class='dropdown-item']//following::a[@class='dropdown-item']")WebElement logOutIcon;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']//parent::a[@class='small-box-footer']")WebElement moreInfoIcon;
	
	
	public void clickOnAdminProfileIcon()
	{
		adminIcon.click();
	}
	
    public void clickOnLogOutIcon()
    {
    	logOutIcon.click();
    }
    
    public void clickOnMoreInfoAdminUsers()
    {
    	moreInfoIcon.click();
    }
}


