package com.enginizer.testing.driver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * Factory class for creating the appropriate #{WebDriver} for the tests
 */
public class WebDriverFactory {

	private int implicitlyWait;

	private int maxPageloadTimeout;

	private String chromeDriverPath;

	private boolean useCustomChomeDriver;

	public WebDriverFactory(final int implicitlyWait, final int maxPageloadTimeout, final String chromeDriverPath, final boolean useCustomChomeDriver) {
		this.implicitlyWait = implicitlyWait;
		this.maxPageloadTimeout = maxPageloadTimeout;
		this.chromeDriverPath = chromeDriverPath;
		this.useCustomChomeDriver = useCustomChomeDriver;
	}

	public WebDriver create(final String driverType) {
		if (this.useCustomChomeDriver) {
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		}
		WebDriver webDriver = null;
		try {
			switch (driverType) {
			case "ie":
				webDriver = new InternetExplorerDriver();
				break;
			case "ff":
				webDriver = new FirefoxDriver();
				break;
			case "chrome":
				webDriver = new ChromeDriver();
				break;
			case "opera":
				webDriver = null;
				break;
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		webDriver.manage().timeouts().pageLoadTimeout(maxPageloadTimeout, TimeUnit.SECONDS);
		webDriver.manage().timeouts().implicitlyWait(implicitlyWait, TimeUnit.SECONDS);
		return webDriver;
	}
}
