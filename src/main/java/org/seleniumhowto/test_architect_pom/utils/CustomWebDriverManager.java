package org.seleniumhowto.test_architect_pom.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager; // ✅ thêm import này
import java.util.concurrent.TimeUnit;

public class CustomWebDriverManager {
    private static WebDriver driver;

    public static WebDriver createNewChromeDriver() {
        try {
            io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
            WebDriver freshDriver = new ChromeDriver();
            freshDriver.manage().window().maximize();
            freshDriver.manage().deleteAllCookies();
            freshDriver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
            freshDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            return freshDriver;
        } catch (Exception e) {
            throw new RuntimeException("Failed to create new ChromeDriver: " + e.getMessage());
        }
    }


    public static WebDriver getDriver() {
        if (driver == null) {
            try {
                // ✅ Dòng này mới đúng
                WebDriverManager.chromedriver().setup();

                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().deleteAllCookies();
                driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            } catch (Exception e) {
                throw new RuntimeException("Failed to initialize WebDriver: " + e.getMessage());
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception e) {
                throw new RuntimeException("Failed to quit WebDriver: " + e.getMessage());
            } finally {
                driver = null;
            }
        }
    }
}
