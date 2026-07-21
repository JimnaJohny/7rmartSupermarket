package testScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;

public class LogoutTest extends Base {
	@Test(retryAnalyzer = retry.Retry.class,groups= {"Regression"})
	public void verifyUserCanLogOutSuccessfullyFromDashBoard() {
		String usernameValue = "admin";
		String passwordValue = "admin";
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernameValue).enterPassword(passwordValue).signIn();
		/*loginpage.enterPassword(passwordValue);
		loginpage.signIn();*/
		HomePage logoutpage = new HomePage(driver);
		logoutpage.clickAdminButton().clickLogOutButton();
		//logoutpage.clickLogOutButton();
		boolean loginPage=logoutpage.isLoginDisplayed();
		Assert.assertTrue(loginPage, Constant.LOGOUT);
	}
}
