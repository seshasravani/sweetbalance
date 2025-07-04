package utilities;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import webdriver.DriverFactory;


public class CommonMethods {

	public static final int DEFAULT_TIMEOUT = 10;

	public static void waitForElementVisibilityOf(WebElement locator) {
		try {
			WebDriver driver = DriverFactory.getDriver();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
			wait.until(ExpectedConditions.visibilityOf(locator));
		} catch (Exception e) {
			
			LoggerLoad.info("No element found within timeout: " + DEFAULT_TIMEOUT + " seconds");
			
		}
	}
	
	public static String getAlertText(WebDriver driver) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
			wait.until(ExpectedConditions.alertIsPresent());
			String alertMsg = driver.switchTo().alert().getText();
			driver.switchTo().alert().accept();
			return alertMsg;
		} catch (Exception e) {

			LoggerLoad.info("No alert found within timeout: " + DEFAULT_TIMEOUT + " seconds");
			return null;
		}
	}

	public static void waitForElementTobeClick(WebElement locator) {
		try {
			WebDriver driver = DriverFactory.getDriver();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
			wait.until(ExpectedConditions.elementToBeClickable(locator));
		} catch (Exception e) {
			LoggerLoad.info("No element found within timeout: " + DEFAULT_TIMEOUT + " seconds");
		}
	}
	public static void waitForElementVisibilityOfAll(List<WebElement> elements) {
	    try {
	        WebDriver driver = DriverFactory.getDriver();
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
	        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
	    } catch (Exception e) {
	        LoggerLoad.info("No elements found within timeout: " + DEFAULT_TIMEOUT + " seconds");
	    }
	}
	public static boolean isElementVisible(WebElement element) {
	    try {
	        waitForElementVisibilityOf(element);
	        return element.isDisplayed();
	    } catch (Exception e) {
	        return false;
	    }
	}
	public static void selectFromDropdown(WebElement dropdownElement, String visibleText) {
	    try {
	        waitForElementVisibilityOf(dropdownElement);
	        Select select = new Select(dropdownElement);
	        select.selectByVisibleText(visibleText);
	        LoggerLoad.info("Selected option: " + visibleText);
	    } catch (Exception e) {
	        LoggerLoad.info("Failed to select option: " + visibleText);
	    }
	}

	public static String getSelectedDropdownOption(WebElement dropdownElement) {
	    try {
	        waitForElementVisibilityOf(dropdownElement);
	        Select select = new Select(dropdownElement);
	        return select.getFirstSelectedOption().getText().trim();
	    } catch (Exception e) {
	        LoggerLoad.info("Could not retrieve selected dropdown option.");
	        return null;
	    }
	}
	public static String getSelectedOptionText(WebElement dropdownElement) {
	    try {
	        waitForElementVisibilityOf(dropdownElement);
	        Select select = new Select(dropdownElement);
	        return select.getFirstSelectedOption().getText().trim();
	    } catch (Exception e) {
	        LoggerLoad.info("Unable to get selected option from dropdown.");
	        return null;
	    }
	}

	


}