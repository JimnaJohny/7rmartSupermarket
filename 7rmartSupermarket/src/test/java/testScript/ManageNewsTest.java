package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base {
	HomePage homepage;
	ManageNewsPage managenewspage;
	@Test(retryAnalyzer = retry.Retry.class, groups = { "Regression" },description="testcase is for managing news")
	public void enterNews() throws IOException {
		String usernameValue = ExcelUtility.getStringData(1, 0, "loginpage");
		// String usernameValue=ExcelUtility.getIntegerData(1, 0, "loginpage");//if
		// giving integer as credential
		String passwordValue = ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernameValue).enterPassword(passwordValue);
		//loginpage.enterPassword(passwordValue);
		homepage=loginpage.signIn();
		//ManageNewsPage managenewspage = new ManageNewsPage(driver);
		// String news="Hello world";
		String news = ExcelUtility.getStringData(0, 1, "managenews");
		managenewspage.scroll();
		managenewspage.waitForNews();
		managenewspage=homepage.clickMoreInfoManageNews();
		managenewspage.clickNewButton().enterNews(news).clickSave();
		/*managenewspage.enterNews(news);
		managenewspage.clickSave();*/
		boolean alert=managenewspage.isAlertDisplayed();
		Assert.assertTrue(alert,Constant.NEWS);
	}
}
