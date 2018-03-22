package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomeSearchPage extends BasePage{
	By priceSlider = By.className("rc-slider-step");
	By searchForm = By.className("search-form-generic");
	By searchPropBed = By.className("search-property-bed");

	public Boolean loaded() {
		return wait.until(ExpectedConditions.presenceOfElementLocated(searchForm)).isDisplayed();
	}

	//Open and set dropdown filter 
	public void setFilter(String filterName, String filterValue) {
		WebElement filter = driver.findElementByXPath("//div[@class='"+ filterName +"-container']//h4");
		driverWait(3000);
		jsClick(filter);
		WebElement selectComponent = driver.findElementByXPath
				("//div[@class='select-component']/div[contains(text(), '" + filterValue + "')]");
		selectComponent.click();
		driverWait(2000);
	}

	//Check number of of all found properties
	public boolean foundPropertiesBadsCountIs(int minBedCount) {
		List<WebElement> elements = null;
		elements = driver.findElements(searchPropBed);
		for (WebElement el : elements) {
			int num = Integer.parseInt(el.getText().split("\\s+")[0]);
			if (num < minBedCount) {
				System.out.println("LOG: " + num);
				return false;
			}
		}
		return true;
	}

}
