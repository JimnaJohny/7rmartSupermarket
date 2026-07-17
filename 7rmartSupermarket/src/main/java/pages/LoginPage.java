package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class LoginPage {
public WebDriver driver;
@FindBy(xpath="//input[@name='username']")WebElement username;
@FindBy(xpath="//input[@name='password']")WebElement password;
@FindBy(xpath="//button[@type='submit']")WebElement signIn;
@FindBy(xpath="//p[text()='Dashboard']")WebElement dashboard;
@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")WebElement alert;
public LoginPage(WebDriver driver) {
this.driver=driver;	
PageFactory.initElements(driver, this);
}
public LoginPage enterUsername(String usernameValue) {
	username.sendKeys(usernameValue);
	return this;	
}
public LoginPage enterPassword(String passwordValue) {
	password.sendKeys(passwordValue);
	return this;
}
public HomePage signIn() {
	/*WaitUtility obj=new WaitUtility();
	obj.waitForElementToBeClickable(driver, signIn);*/
	signIn.click();
	return new HomePage(driver);
}
public boolean isDashboardDisplayed() {
	return dashboard.isDisplayed();
}
public boolean isAlertDisplayed() {
	return alert.isDisplayed();
}
}
