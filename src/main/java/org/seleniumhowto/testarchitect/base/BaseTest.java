package org.seleniumhowto.testarchitect.base;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.seleniumhowto.railway.utils.WebDriverManager;

import java.time.Duration;

public class BaseTest {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static WebElement element;

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));  // Adjust wait time as needed
        driver.manage().window().maximize();

    }

    @AfterClass
    public static void tearDown() {
        WebDriverManager.quitDriver();
    }
}
