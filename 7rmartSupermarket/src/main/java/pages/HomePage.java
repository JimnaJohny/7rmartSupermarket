package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;
	@FindBy(xpath = "(//a[@class='small-box-footer'])[13]")
	WebElement moreInfoManageNews;
	@FindBy(xpath = "(//a[@class='small-box-footer'])[11]")
	WebElement moreInfoManageLocation;
	@FindBy(xpath = "(//a[@class='small-box-footer'])[6]")
	WebElement moreInfoManageCOD;
	@FindBy(xpath = "(//a[@class='small-box-footer'])[3]")
	WebElement moreInfoManageCategory;
	@FindBy(xpath = "(//a[@class='small-box-footer'])[2]")
	WebElement moreInfoAdminUsers;

	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement adminButton;
	@FindBy(xpath = "//a[@class='dropdown-item' and @href='https://groceryapp.uniqassosiates.com/admin/logout']")
	WebElement logOutButton;
	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement loginButton;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public ManageNewsPage clickMoreInfoManageNews() {
		moreInfoManageNews.click();
		return new ManageNewsPage(driver);
	}

	public ManageLocationPage clickMoreInfoManageLocation() {
		moreInfoManageLocation.click();
		return new ManageLocationPage(driver);
	}

	public ManageCODPage clickMoreInfoManageCOD() {
		moreInfoManageCOD.click();
		return new ManageCODPage(driver);
	}

	public ManageCategoryPage clickMoreInfoManageCategory() {
		moreInfoManageCategory.click();
		return new ManageCategoryPage(driver);
	}

	public AdminUsersPage clickMoreInfoAdminUsers() {
		moreInfoAdminUsers.click();
		return new AdminUsersPage(driver);
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
