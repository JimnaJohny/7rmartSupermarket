package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class ManageLocationPage {
	public WebDriver driver;
	@FindBy(xpath="(//a[@class='small-box-footer'])[11]") WebElement moreInfoManageLocation;
	@FindBy(xpath="//a[@onclick='click_button(1)']") WebElement newButton;
	@FindBy(xpath="//select[@name='country_id']") WebElement country;
	@FindBy(xpath="//select[@name='state_id']") WebElement state;
	@FindBy(css="input#location") WebElement location;
	@FindBy(css="input#delivery") WebElement delivery;
	@FindBy(xpath="//button[@name='create']") WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alert;
	public ManageLocationPage(WebDriver driver) {
		this.driver=driver;	
		PageFactory.initElements(driver, this);
		}
	public void clickMoreInfoManageLocation() {
		moreInfoManageLocation.click();
	}
	public void clickNewButton() {
		newButton.click();
	}
	/*public void fillForm(String countryName,String stateName, String locationName,String deliveryCharge) {
		PageUtility obj=new PageUtility();
		//obj.dropDownVisibleText(country, countryName);
		//obj.dropDownVisibleText(state, stateName);
		location.sendKeys(locationName);
		delivery.sendKeys(deliveryCharge);	
	}*/
	public void country() {
		PageUtility obj=new PageUtility();
		obj.dropDownVisibleText(country, "Select");
		obj.dropDownVisibleText(country, "United Kingdom");
	}
	public void selectState() {
		/*WaitUtility obj1 = new WaitUtility();
	    obj1.waitForVisibilityOf(driver, state);
	    PageUtility obj=new PageUtility();
		obj.dropDownVisibleText(state, "Argyll");*/
		location.sendKeys("Regal Drive");
		delivery.sendKeys("20");
	}
	/*public void selectCountry(String countryName) {
		WaitUtility obj1 = new WaitUtility();
	    obj1.waitForVisibilityOf(driver, country);
		PageUtility obj=new PageUtility();
		obj.dropDownVisibleText(country, countryName);
	}*/
	/*public void location(String locationName) {
		WaitUtility obj = new WaitUtility();
	    obj.waitForVisibilityOf(driver, location);
		location.sendKeys(locationName);
	}
	public void delivery(String deliveryCharge) {
		WaitUtility obj = new WaitUtility();
	    obj.waitForVisibilityOf(driver, delivery);
		delivery.sendKeys(deliveryCharge);
	}*/
	public void clickSave() {
		saveButton.click();
	}
	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}
}
