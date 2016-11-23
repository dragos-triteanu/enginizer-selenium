package com.enginizer.testing.config;

import com.enginizer.testing.driver.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DriverConfig {

    @Value("${driver.wait.for.element.seconds}")
    private int implicitlyWait;

    @Value("${driver.type}")
    private String driverType;

    @Value("${drive.page.load.seconds}")
    private int maxPageLoadTimeout;

    @Value("${driver.chrome.custom.location}")
    private String driverLocation;

    @Value("${driver.chrome.custom.use}")
    private boolean useCustomChomeDriver;

    @Bean(name = "webDriver")
    public WebDriver webDriver() {
        WebDriverFactory driverFactory = new WebDriverFactory(implicitlyWait, maxPageLoadTimeout, driverLocation, useCustomChomeDriver);
        return driverFactory.create(driverType);
    }
}
