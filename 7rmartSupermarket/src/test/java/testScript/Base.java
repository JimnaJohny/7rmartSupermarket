package testScript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Optional;

public class Base {
	public WebDriver driver;
	@BeforeMethod
	@Parameters("browser")
	public void initializeBrowser(@Optional("chrome")String browser) throws Exception {
		if(browser.equalsIgnoreCase("chrome"))
			driver = new ChromeDriver();
		else if(browser.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
		else
			throw new Exception("Invalid Browser");
		driver.get("https://groceryapp.uniqassosiates.com/admin/login");
		driver.manage().window().maximize();

	}
	//@AfterMethod
	public void closeBrowser()
	{
		//driver.close();
		driver.quit();
	}
}

