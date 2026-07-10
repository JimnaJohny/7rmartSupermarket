package utilities;

import java.time.Duration;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
public static final int IMPLICITWAIT=5;
public static final int EXPLICITWAIT=10;
public static final int FLUENTWAIT=30;
public static final int POLLWAIT=5;
public void waitForElementToBeClickable(WebDriver driver, WebElement element) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
	wait.until(ExpectedConditions.elementToBeClickable(element));
}
public void waitForVisibilityOf(WebDriver driver, WebElement element) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
	wait.until(ExpectedConditions.visibilityOf(element));
}
public void waitForAlertIsPresent(WebDriver driver) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITWAIT));
	wait.until(ExpectedConditions.alertIsPresent());
}
public void fluentWaitForElementToBeClickable(WebDriver driver,WebElement element)
{
	Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
	        .withTimeout(Duration.ofSeconds(FLUENTWAIT))
	        .pollingEvery(Duration.ofSeconds(POLLWAIT))
	        .ignoring(NoSuchElementException.class);
	fluentWait.until(ExpectedConditions.elementToBeClickable(element));
}
public void fluentWaitForAlertIsPresent(WebDriver driver)
{
	Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
	        .withTimeout(Duration.ofSeconds(FLUENTWAIT))
	        .pollingEvery(Duration.ofSeconds(POLLWAIT))
	        .ignoring(NoSuchElementException.class);
	fluentWait.until(ExpectedConditions.alertIsPresent());
}
}
