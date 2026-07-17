package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageNewsPage {
	public WebDriver driver;
	@FindBy(xpath="(//a[@class='small-box-footer'])[13]") WebElement moreInfoManageNews;
	@FindBy(xpath="//a[@onclick='click_button(1)']") WebElement newButton;
	@FindBy(css="textarea#news") WebElement newsArea;
	@FindBy(xpath="//button[@name='create']") WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alert;
	public ManageNewsPage(WebDriver driver) {
		this.driver=driver;	
		PageFactory.initElements(driver, this);
		}
	public void scroll() {
		PageUtility obj=new PageUtility();
		obj.scrollToBottom(driver);
	}
	public void waitForNews() {
		WaitUtility obj=new WaitUtility();
		obj.waitForElementToBeClickable(driver, moreInfoManageNews);
		}
	/*public void clickMoreInfoManageNews() {
		moreInfoManageNews.click();
	}*/
	public ManageNewsPage clickNewButton() {
		newButton.click();
		return this;
	}
	public ManageNewsPage enterNews(String news) {
		newsArea.sendKeys(news);
		return this;
	}
	public ManageNewsPage clickSave() {
		saveButton.click();
		return this;
	}
	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}
}
