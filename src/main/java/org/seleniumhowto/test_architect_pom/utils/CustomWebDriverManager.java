package org.seleniumhowto.test_architect_pom.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomWebDriverManager {

    private static WebDriver driver;

    // Singleton pattern for getting the WebDriver instance
    public static WebDriver getDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();  // Setup the chromedriver automatically
            driver = new ChromeDriver();  // Initialize the WebDriver
        }
        return driver;
    }

    // Create a new ChromeDriver instance each time
    public static WebDriver createNewChromeDriver() {
        WebDriverManager.chromedriver().setup();  // Setup chromedriver
        return new ChromeDriver();  // Return a new instance of ChromeDriver
    }

    // Quit the WebDriver instance
    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
