package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public void dropDownVisibleText(WebElement elementname, String visibletext) {
		Select select = new Select(elementname);
		select.selectByVisibleText(visibletext);
	}

	public void dropDownValue(WebElement elementname, String value) {
		Select select = new Select(elementname);
		select.selectByValue(value);
	}

	public void dropDownIndex(WebElement elementname, int index) {
		Select select = new Select(elementname);
		select.selectByIndex(index);
	}

	public void dragAndDrop(WebDriver driver, WebElement draggableitem, WebElement dropzone) {
		Actions action = new Actions(driver);
		action.dragAndDrop(draggableitem, dropzone).perform();
		;
	}

	public void mouseHover(WebDriver driver, WebElement target) {
		Actions action = new Actions(driver);
		action.moveToElement(target).perform();
		;
	}

	public void rightClick(WebDriver driver, WebElement target) {
		Actions action = new Actions(driver);
		action.contextClick(target).perform();
	}

	public void doubleClick(WebDriver driver, WebElement target) {
		Actions action = new Actions(driver);
		action.doubleClick(target).perform();
	}

	public void click(WebDriver driver, WebElement target) {
		Actions action = new Actions(driver);
		action.click(target).perform();
	}

	public void javaScriptExecutorSendKeys(WebDriver driver, String value, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value=arguments[1];", element, value);
	}

	public void javaScriptExecutorClick(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public void javaScriptExecutorPageScroll(WebDriver driver, int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
	}

	public void scrollToBottom(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, document.body.scrollHeight);");
	}
}
