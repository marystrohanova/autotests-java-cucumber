package testBase;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.RemoteWebDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	public static ThreadLocal<RemoteWebDriver> sharedDriver = new ThreadLocal<RemoteWebDriver>();

	@Before
	public void setup() {		
		RemoteWebDriver driver = null;

		driver = BrowserManager.getDriver();
		sharedDriver.set(driver);

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		System.out.println("LOG: Starting driver");
	}

	@After
	//Embed a screenshot in test report if test is marked as failed
	public void embedScreenshot(Scenario scenario) {
		RemoteWebDriver driver = sharedDriver.get();

		if(scenario.isFailed()) {
			try {
				scenario.write("Current Page URL is " + driver.getCurrentUrl());
				byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
			} catch (WebDriverException somePlatformsDontSupportScreenshots) {
				System.err.println(somePlatformsDontSupportScreenshots.getMessage());
			}

		}
		System.out.println("LOG: Closing driver");

		//driver.quit();
	}
}
