package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {
	@Test(retryAnalyzer = retry.Retry.class, groups = { "Regression" })
	public void enterNews() throws IOException {
		String usernameValue = ExcelUtility.getStringData(1, 0, "loginpage");
		// String usernameValue=ExcelUtility.getIntegerData(1, 0, "loginpage");//if
		// giving integer as credential
		String passwordValue = ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernameValue);
		loginpage.enterPassword(passwordValue);
		loginpage.signIn();
		ManageNewsPage managenewspage = new ManageNewsPage(driver);
		// String news="Hello world";
		String news = ExcelUtility.getStringData(0, 1, "managenews");
		managenewspage.scroll();
		managenewspage.waitForNews();
		managenewspage.clickMoreInfoManageNews();
		managenewspage.clickNewButton();
		managenewspage.enterNews(news);
		managenewspage.clickSave();
		boolean alert=managenewspage.isAlertDisplayed();
		Assert.assertTrue(alert);
	}
}
