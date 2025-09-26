package org.railway;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserBookTicketWithKnownPrice {
    static ChromeDriver driver;

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\phat.le\\Downloads\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");

    }

    // login

    // click bang

    @Test
    public void hoverTest() throws InterruptedException {
        WebElement select = driver.findElement(By.id("dropdown"));
        Select dropdown = new Select(select);

        dropdown.selectByVisibleText("Option 1"); // text()
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeSelected(
                driver.findElement(By.xpath("//select[@id='dropdown']/option[.='Option 1']"))
        ));
        Assert.assertTrue(driver.findElement(By.xpath("//select[@id='dropdown']/option[.='Option 1']")).isSelected());// text()
        Assert.assertTrue(driver.findElement(By.xpath("//select[@id='dropdown']/option[text()='Option 1']")).isSelected());// text()}
        Thread.sleep(5000);
    }
    @AfterClass
    public static void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }
}
