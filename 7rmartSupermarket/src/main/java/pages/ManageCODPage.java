package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageCODPage {
	public WebDriver driver;
	@FindBy(xpath="(//a[@class='small-box-footer'])[6]") WebElement moreInfoManageCOD;
	@FindBy(xpath="//input[@value='yes']") WebElement radioButtonCOD;
	@FindBy(xpath="//button[@name='create']") WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alert;
	public ManageCODPage(WebDriver driver) {
		this.driver=driver;	
		PageFactory.initElements(driver, this);
		}
	/*public void clickMoreInfoManageCOD() {
		moreInfoManageCOD.click();
	}*/
	public ManageCODPage clickCODRadioButton() {
	if(radioButtonCOD.isSelected())	
		System.out.println("Yes is already selected");
	else
		radioButtonCOD.click();
	return this;
	}
	public ManageCODPage clickSave() {
		saveButton.click();
		return this;
	}
	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}
}
