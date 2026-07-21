package testScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;

public class LogoutTest extends Base {
	HomePage homepage;
	@Test(retryAnalyzer = retry.Retry.class,groups= {"Regression"})
	public void verifyUserCanLogOutSuccessfullyFromDashBoard() {
		String usernameValue = "admin";
		String passwordValue = "admin";
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernameValue).enterPassword(passwordValue);
		homepage=loginpage.signIn();
		/*loginpage.enterPassword(passwordValue);
		loginpage.signIn();*/
		loginpage=homepage.clickAdminButton().clickLogOutButton();
		//logoutpage.clickLogOutButton();
		boolean loginPage=homepage.isLoginDisplayed();
		Assert.assertTrue(loginPage, Constant.LOGOUT);
	}
}
