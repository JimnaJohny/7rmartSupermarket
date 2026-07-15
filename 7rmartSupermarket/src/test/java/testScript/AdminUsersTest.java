package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminUsersTest extends Base {
	@Test(retryAnalyzer = retry.Retry.class, groups = { "Regression" },description="testcase is for adding admin users")
	public void saveNewCredentials() throws IOException {
		String usernameValue = ExcelUtility.getStringData(1, 0, "loginpage");
		// String usernameValue=ExcelUtility.getIntegerData(1, 0, "loginpage");//if
		// giving integer as credential
		String passwordValue = ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernameValue);
		loginpage.enterPassword(passwordValue);
		loginpage.signIn();
		AdminUsersPage adminuserspage = new AdminUsersPage(driver);
		/*
		 * String userNameValue="jimna"; String passWordValue="123456";
		 */
		String newUsernameValue = ExcelUtility.getStringData(1, 0, "adminusers");
		String newPasswordValue = ExcelUtility.getStringData(1, 0, "adminusers");
		adminuserspage.clickMoreInfoAdminUsers();
		adminuserspage.clickNewButton();
		adminuserspage.enterUserName(newUsernameValue);
		adminuserspage.enetrPassword(newPasswordValue);
		adminuserspage.selectUserType();
		adminuserspage.clickSave();
		boolean alert=adminuserspage.isAlertDisplayed();
		Assert.assertTrue(alert);
	}
}
