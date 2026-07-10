package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AdminUsersPage {
	public WebDriver driver;
	@FindBy(xpath = "(//a[@class='small-box-footer'])[2]")
	WebElement moreInfoAdminUsers;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement newButton;
	@FindBy(css = "input#username")
	WebElement userName;
	@FindBy(css = "input#password")
	WebElement password;
	@FindBy(css = "select#user_type")
	WebElement userType;
	@FindBy(xpath = "//button[@type='submit' and @name='Create']")
	WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")WebElement alert;

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickMoreInfoAdminUsers() {
		moreInfoAdminUsers.click();
	}

	public void clickNewButton() {
		newButton.click();
	}

	public void enterUserName(String usernameValue) {
		userName.clear();
		userName.sendKeys(usernameValue);
	}

	public void enetrPassword(String passwordValue) {
		password.clear();
		password.sendKeys(passwordValue);
	}

	public void selectUserType() {
		Select obj = new Select(userType);
		obj.selectByVisibleText("Partner");
	}

	public void clickSave() {
		saveButton.click();
	}
	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}
}
