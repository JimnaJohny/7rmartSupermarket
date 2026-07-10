package testScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LogoutPage;
import pages.LoginPage;

public class LogoutTest extends Base {
	@Test
	public void verifyUserCanLogOutSuccessfullyFromDashBoard() {
		String usernameValue = "admin";
		String passwordValue = "admin";
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernameValue);
		loginpage.enterPassword(passwordValue);
		loginpage.signIn();
		LogoutPage logoutpage = new LogoutPage(driver);
		logoutpage.clickAdminButton();
		logoutpage.clickLogOutButton();
		boolean loginPage=logoutpage.isLoginDisplayed();
		Assert.assertTrue(loginPage);
	}
}
