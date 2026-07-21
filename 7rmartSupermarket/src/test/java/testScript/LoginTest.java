package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base{
	HomePage homepage;
@Test(retryAnalyzer = retry.Retry.class,groups= {"Regression"})
public void verfyUserIsAbleToLoginWithValidCredentials() throws IOException {
	/*String usernameValue="admin";
	String passwordValue="admin";*/
	String usernameValue=ExcelUtility.getStringData(1, 0, "loginpage");
	//String usernameValue=ExcelUtility.getIntegerData(1, 0, "loginpage");//if giving integer as credential
	String passwordValue=ExcelUtility.getStringData(1, 1, "loginpage");
	LoginPage loginpage=new LoginPage(driver);
	loginpage.enterUsername(usernameValue).enterPassword(passwordValue);
	//loginpage.enterPassword(passwordValue);
	homepage=loginpage.signIn();
	boolean homePage=loginpage.isDashboardDisplayed();
	Assert.assertTrue(homePage,Constant.LOGINVALIDCREDENTIAL);
}

@Test
public void verfyUserIsAbleToLoginWithInvalidPassword() throws IOException {
	/*String usernameValue="admin";
	String passwordValue="Jimna";*/
	String usernameValue=ExcelUtility.getStringData(2, 0, "loginpage");
	String passwordValue=ExcelUtility.getStringData(2, 1, "loginpage");
	LoginPage loginpage=new LoginPage(driver);
	loginpage.enterUsername(usernameValue).enterPassword(passwordValue);
	//loginpage.enterPassword(passwordValue);
	homepage=loginpage.signIn();
	boolean alert=loginpage.isAlertDisplayed();
	Assert.assertTrue(alert,"Homepage is loaded with invalid password");
}
@Test
public void verfyUserIsAbleToLoginWithInvalidUsername() throws IOException {
	/*String usernameValue="Jimna";
	String passwordValue="admin";*/
	String usernameValue=ExcelUtility.getStringData(3, 0, "loginpage");
	String passwordValue=ExcelUtility.getStringData(3, 1, "loginpage");
	LoginPage loginpage=new LoginPage(driver);
	loginpage.enterUsername(usernameValue).enterPassword(passwordValue);
	//loginpage.enterPassword(passwordValue);
	homepage=loginpage.signIn();
	boolean alert=loginpage.isAlertDisplayed();
	Assert.assertTrue(alert);
}
@Test
public void verfyUserIsAbleToLoginWithInvalidCredentials() throws IOException {
	/*String usernameValue="Jimna";
	String passwordValue="Jimna";*/
	String usernameValue=ExcelUtility.getStringData(4, 0, "loginpage");
	String passwordValue=ExcelUtility.getStringData(4, 1, "loginpage");
	LoginPage loginpage=new LoginPage(driver);
	loginpage.enterUsername(usernameValue).enterPassword(passwordValue);
	//loginpage.enterPassword(passwordValue);
	homepage=loginpage.signIn();
	boolean alert=loginpage.isAlertDisplayed();//false bcz added these credentials as a new admin in AdminUser class11	
	Assert.assertTrue(alert);
}
}
