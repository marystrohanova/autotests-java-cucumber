package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import utils.PropertiesLoader;

public class HomePage extends BasePage{
	By h2AgentName = By.className("fadeInUp");
	By section2 = By.xpath("//div[@data-index='1']");
	By topBaner = By.className("top-banner-content");
	By featuredTitle = By.className("featured-wrapper");
	By propsSliderLeft = By.xpath("//section[@class='property-slider']/div[@class='left']");
	By propsSliderRight = By.xpath("//section[@class='property-slider']/div[@class='right']");

	public void open(){
		driver.get(PropertiesLoader.getValue("url"));
	}
	
	public Boolean loaded() {
		return wait.until(ExpectedConditions.presenceOfElementLocated(topBaner)).isDisplayed();
	}

	public String getHeader() {
		return wait.until(ExpectedConditions.presenceOfElementLocated(h2AgentName)).getText();
	}

	public void scrollTo(String string) {
		scrollToElement(driver.findElement(section2));
	}

	public Boolean propsSliderDisplayed() {
		return wait.until(ExpectedConditions.presenceOfElementLocated(propsSliderLeft)).isDisplayed() && 
				wait.until(ExpectedConditions.presenceOfElementLocated(propsSliderRight)).isDisplayed();
	}

	public void hoverCursor() {
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(section2)).perform();
	}
}
