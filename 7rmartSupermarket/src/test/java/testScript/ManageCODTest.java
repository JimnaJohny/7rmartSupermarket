package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageCODPage;
import utilities.ExcelUtility;

public class ManageCODTest extends Base{
	HomePage homepage;
	ManageCODPage managecodpage;
		@Test(retryAnalyzer = retry.Retry.class, groups = { "Regression" },description="testcase is for managing COD")
		public void manageCOD() throws IOException {
			String usernameValue = ExcelUtility.getStringData(1, 0, "loginpage");
			// String usernameValue=ExcelUtility.getIntegerData(1, 0, "loginpage");//if
			// giving integer as credential
			String passwordValue = ExcelUtility.getStringData(1, 1, "loginpage");
			LoginPage loginpage = new LoginPage(driver);
			loginpage.enterUsername(usernameValue).enterPassword(passwordValue);
			//loginpage.enterPassword(passwordValue);
			homepage= loginpage.signIn();
			//ManageCODPage managecodpage=new ManageCODPage(driver);
			managecodpage= homepage.clickMoreInfoManageCOD();
			managecodpage.clickCODRadioButton().clickSave();
			/*managecodpage.clickSave();*/
			boolean alert=managecodpage.isAlertDisplayed();
			Assert.assertTrue(alert, Constant.CODOPTION);
		}
}
