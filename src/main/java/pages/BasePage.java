package pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testBase.Hooks;


public class BasePage {
	RemoteWebDriver driver = null;
	WebDriverWait wait = null;
	
	public BasePage() {
		this.driver = Hooks.sharedDriver.get();
		this.wait = new WebDriverWait(driver, 50);
	}
	
	//Navigate to menu item
	public void navigateTo(String menuName) {
		By menuSpan = By.xpath("//span[@class='wrapper-item']/a[contains(text(),'" + menuName + "')]");
		driver.findElement(menuSpan).click();
	}

	//Fill in text field
	public void fillInTextField(By textFld, String sendKeysValue) {
		WebElement element = driver.findElement(textFld);
		element.clear();
		element.sendKeys(sendKeysValue);
	}


	//Method to return WebElement
	public WebElement returnWebElement (String locatorType, String locatorValue) {
		WebElement element = null;
		try {
			element = wait.until(ExpectedConditions.visibilityOfElementLocated
					(getElement(locatorType, locatorValue)));
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		return element;
	}

	//Return page element
	public static  By getElement(String locatorType, String locatorValue) {
		By pElement = null;
		switch (locatorType) {
		case "xpath": 
			pElement = By.xpath(locatorValue);
			break;
		case "id":
			pElement = By.id(locatorValue);
			break;
		case "class":
			pElement = By.className(locatorValue);
			break;
		case "linkText":
			pElement = By.linkText(locatorValue);
			break;
		default:
			System.out.println("Undefined locator type: " + locatorType);
			break;
		}
		return pElement;
	}

	//Return WebElements
	public List<WebElement> returnWebElements (String locatorType, String locatorValue ) {
		List<WebElement> elements = null;
		elements = driver.findElements(getElement(locatorType,locatorValue));

		return elements;      
	}

	//Simulate js click on element
	public void jsClick(WebElement element){
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);                    
	}

	//Set driver wait time
	public void driverWait(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	//Scroll to the element
	public void scrollToElement(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

}
