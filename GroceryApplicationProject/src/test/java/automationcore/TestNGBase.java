package automationcore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestNGBase 
{
    public WebDriver driver;
	
	@BeforeMethod	
	public void browserLaunch() 
	{
		driver=new ChromeDriver();
		driver.get("https://groceryapp.uniqassosiates.com/admin");
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void closeAndQuit() 
	{
		//driver.close();
		//driver.quit();
		
	}
}
