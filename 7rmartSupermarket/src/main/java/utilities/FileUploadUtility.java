package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;

public class FileUploadUtility {
	public void fileUploadUsingSendKeys(WebElement elementname, String filePath) {
		elementname.sendKeys(filePath);
	}

	public void fileUploadUsingRobotClass(WebElement elementname, String filePath) throws AWTException {
		StringSelection obj = new StringSelection("C:\\Users\\jimna\\Downloads\\Book 1.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(obj, null);
		Robot r = new Robot();
		r.delay(2000);
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
}
