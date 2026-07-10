package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constant.Constant;
import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageCategoryPage {
	public WebDriver driver;
	@FindBy(xpath="(//a[@class='small-box-footer'])[3]") WebElement moreInfoManageCategory;
	@FindBy(xpath="//a[@onclick='click_button(1)']") WebElement newButton;
	@FindBy(css="input#category") WebElement category;
	@FindBy(xpath="(//span[text()='Goodness'])[1]") WebElement selectGroups;
	@FindBy(css="input#main_img") WebElement chooseFileButton;
	@FindBy(xpath="//button[@type='submit']") WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")WebElement alert;
	public ManageCategoryPage(WebDriver driver) {
		this.driver=driver;	
		PageFactory.initElements(driver, this);
		}
	public void clickMoreInfoManageCategory() {
		moreInfoManageCategory.click();
	}
	public void clickNewButton() {
		newButton.click();
	}
	public void enterCategory(String categoryName) {
		category.sendKeys(categoryName);
	}
	public void selectGroups() {
		selectGroups.click();
	}
	public void fileUpload() {
		//Constant obj1=new Constant();
		FileUploadUtility obj=new FileUploadUtility();
		obj.fileUploadUsingSendKeys(chooseFileButton,Constant.IMAGE);
	}
	public void scroll() {
		PageUtility obj=new PageUtility();
		obj.scrollToBottom(driver);
		//obj.javaScriptExecutorPageScroll(driver, 1000, 1000);
	}
	public void waitForSave() {
	WaitUtility obj=new WaitUtility();
	obj.waitForElementToBeClickable(driver, saveButton);
	}
	public void clickSave() {
		saveButton.click();
	}
	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}
}
