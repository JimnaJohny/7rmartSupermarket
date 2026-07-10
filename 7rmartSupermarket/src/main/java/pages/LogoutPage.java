package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	public WebDriver driver;
	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement adminButton;
	@FindBy(xpath = "//a[@class='dropdown-item' and @href='https://groceryapp.uniqassosiates.com/admin/logout']")
	WebElement logOutButton;
	@FindBy(xpath="//button[text()='Sign In']")WebElement loginButton;

	public LogoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickAdminButton() {
		adminButton.click();
	}

	public void clickLogOutButton() {
		logOutButton.click();
	}
	public boolean isLoginDisplayed() {
		return loginButton.isDisplayed();
	}
}
