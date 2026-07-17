package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtility {
	public void getScreenShot(WebDriver driver, String failedTestCase) throws IOException {
		TakesScreenshot scrShot = (TakesScreenshot) driver; // TakesScreenshot capture the current situation of the
															// browser
		File screenShot = scrShot.getScreenshotAs(OutputType.FILE);//capture the screenshot,stores it tempororly as a file
		String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());//create date and time
		                                                              //date is for curent date
		File f1 = new File(System.getProperty("user.dir") + "//OutputScreenShot"); //its a name of the folder,output location
		if (!f1.exists()) {
			f1.mkdirs(); // create a folder if it  does not exist
		}
		String destination = System.getProperty("user.dir") + "//OutputScreenShot//" + failedTestCase + timeStamp
				+ ".png"; //decides final screenshot
		File finalDestination = new File(destination);
		FileHandler.copy(screenShot, finalDestination); // FileHandler-class
	}

}
