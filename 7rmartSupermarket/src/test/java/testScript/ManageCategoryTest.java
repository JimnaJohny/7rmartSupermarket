package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageCategoryPage;
import utilities.ExcelUtility;
import utilities.FakerUtility;
import utilities.PageUtility;

public class ManageCategoryTest extends Base {
	@Test(retryAnalyzer = retry.Retry.class, groups = { "Regression" },description="testcase is for managing Category")
	public void manageCategory() throws IOException {
		String usernameValue = ExcelUtility.getStringData(1, 0, "loginpage");
		// String usernameValue=ExcelUtility.getIntegerData(1, 0, "loginpage");//if
		// giving integer as credential
		String passwordValue = ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernameValue);
		loginpage.enterPassword(passwordValue);
		loginpage.signIn();
		ManageCategoryPage managecategorypage = new ManageCategoryPage(driver);
		/*FakerUtility obj = new FakerUtility();
		String category = obj.generateCategory();*/
		//String category="Noodle";
		String category = ExcelUtility.getStringData(0, 1, "managecategory");
		managecategorypage.clickMoreInfoManageCategory();
		managecategorypage.clickNewButton();
		managecategorypage.enterCategory(category);
		managecategorypage.scroll();
		managecategorypage.selectGroups();
		managecategorypage.fileUpload();
		managecategorypage.scroll();
		managecategorypage.waitForSave();
		managecategorypage.clickSave();
		boolean alert=managecategorypage.isAlertDisplayed();
		Assert.assertTrue(alert);
	}
}
