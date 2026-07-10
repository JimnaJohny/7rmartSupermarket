package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageLocationPage;
import utilities.ExcelUtility;

public class ManageLocationTest extends Base{
	@Test(retryAnalyzer = retry.Retry.class, groups = { "Regression" })
	public void manageLocation() throws IOException {
		String usernameValue = ExcelUtility.getStringData(1, 0, "loginpage");
		// String usernameValue=ExcelUtility.getIntegerData(1, 0, "loginpage");//if
		// giving integer as credential
		String passwordValue = ExcelUtility.getStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUsername(usernameValue);
		loginpage.enterPassword(passwordValue);
		loginpage.signIn();
		ManageLocationPage managelocationpage=new ManageLocationPage(driver);
		managelocationpage.clickMoreInfoManageLocation();
		managelocationpage.clickNewButton();
		managelocationpage.country();
		managelocationpage.selectState();
		//String country = ExcelUtility.getStringData(1, 0, "managelocation");
		/*String state = ExcelUtility.getStringData(1, 1, "managelocation");*/
		//String location = ExcelUtility.getStringData(1, 2, "managelocation");
		//String deliveryCharge = ExcelUtility.getStringData(1, 3, "managelocation");
		//managelocationpage.selectCountry(country);
		//managelocationpage.location(location);
		//managelocationpage.delivery(String.valueOf(deliveryCharge));
		managelocationpage.clickSave();
		boolean alert=managelocationpage.isAlertDisplayed();
		Assert.assertTrue(alert);
	}
}
