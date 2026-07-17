package testScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;

public class LogoutTest extends Base {
	@Test(retryAnalyzer = retry.Retry.class,groups= {"Regression"})
	public void verifyUserCanLogOutSuccessfullyFromDashBoard() {
		String usernameValue = "admin";
		String passwordValue = "admin";
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernameValue);
		loginpage.enterPassword(passwordValue);
		loginpage.signIn();
		HomePage logoutpage = new HomePage(driver);
		logoutpage.clickAdminButton();
		logoutpage.clickLogOutButton();
		boolean loginPage=logoutpage.isLoginDisplayed();
		Assert.assertTrue(loginPage);
	}
}
