package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageCODPage;
import utilities.ExcelUtility;

public class ManageCODTest extends Base{
		@Test(retryAnalyzer = retry.Retry.class, groups = { "Regression" })
		public void manageCOD() throws IOException {
			String usernameValue = ExcelUtility.getStringData(1, 0, "loginpage");
			// String usernameValue=ExcelUtility.getIntegerData(1, 0, "loginpage");//if
			// giving integer as credential
			String passwordValue = ExcelUtility.getStringData(1, 1, "loginpage");
			LoginPage loginpage = new LoginPage(driver);
			loginpage.enterUsername(usernameValue);
			loginpage.enterPassword(passwordValue);
			loginpage.signIn();
			ManageCODPage managecodpage=new ManageCODPage(driver);
			managecodpage.clickMoreInfoManageCOD();
			managecodpage.clickCODRadioButton();
			managecodpage.clickSave();
			boolean alert=managecodpage.isAlertDisplayed();
			Assert.assertTrue(alert);
		}
}
