package org.seleniumhowto.test_architect_pom.base;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.seleniumhowto.test_architect_pom.utils.CustomWebDriverManager;
import org.slf4j.Logger;
import io.github.bonigarcia.wdm.WebDriverManager; // ✅ thêm import này

import org.slf4j.LoggerFactory;

import java.time.Duration;

public class BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
    protected WebDriver driver;
    protected WebDriverWait wait;
    private final boolean useFreshChromeDriver; // Flag to choose between getDriver and chromedriver

    // Constructor to allow flexibility in driver selection
    public BaseTest() {
        this.useFreshChromeDriver = false; // Default to singleton driver
    }

    // Constructor for tests needing a fresh ChromeDriver
    public BaseTest(boolean useFreshChromeDriver) {
        this.useFreshChromeDriver = useFreshChromeDriver;
    }

    @Before
    public void setUp() {
        try {
            if (useFreshChromeDriver) {
                logger.info("Initializing fresh ChromeDriver instance");
                driver = CustomWebDriverManager.createNewChromeDriver();
            } else {
                logger.info("Initializing singleton WebDriver");
                driver = CustomWebDriverManager.getDriver();
            }
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            logger.info("WebDriver and WebDriverWait initialized successfully");
        } catch (Exception e) {
            logger.error("Failed to initialize WebDriver", e);
            throw new RuntimeException("Failed to initialize WebDriver: " + e.getMessage());
        }
    }

    @After
    public void tearDown() {
        try {
            if (driver != null) {
                if (useFreshChromeDriver) {
                    logger.info("Quitting fresh ChromeDriver instance");
                    driver.quit();
                } else {
                    logger.info("Quitting singleton WebDriver");
                    CustomWebDriverManager.quitDriver();
                }
                logger.info("WebDriver quit successfully");
            }
        } catch (Exception e) {
            logger.error("Failed to quit WebDriver", e);
            throw new RuntimeException("Failed to quit WebDriver: " + e.getMessage());
        } finally {
            driver = null;
            wait = null;
        }
    }
}