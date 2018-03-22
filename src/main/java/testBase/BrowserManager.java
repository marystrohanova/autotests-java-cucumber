package testBase;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import utils.PropertiesLoader;

public class BrowserManager {
	public static RemoteWebDriver getDriver() {

		RemoteWebDriver driver = null;

		//set the browser value through maven property on command line
		String browser = System.getProperty("browser");
		
		//if the browser not specified through maven property on command line
		if (browser == null) {
			browser = PropertiesLoader.getValue("browser");
		}
		
		switch (browser) {
		case "chrome":
			System.out.println("LOG: Browser requested: Chrome");

			driver = new ChromeDriver();

			break;

		case "firefox":
			System.out.println("LOG: Browser requested: Firefox");
			System.setProperty("webdriver.firefox.marionette","/usr/bin/geckodriver");

		    DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		    capabilities.setCapability("marionette", true);

			driver = new FirefoxDriver();
			break;

		default:
			String message = "LOG: Unknown browser requested: " + browser +
						". Lounching Chrome as default browser";
			System.out.println(message);
			driver = new ChromeDriver();
			break;
		}

		return driver;
	}



}
