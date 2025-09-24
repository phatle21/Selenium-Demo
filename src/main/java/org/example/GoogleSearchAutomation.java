package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class GoogleSearchAutomation {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\phat.le\\Downloads\\chromedriver-win64\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://the-internet.herokuapp.com/horizontal_slider");

            Actions actions = new Actions(driver);
            WebElement input = driver.findElement(By.cssSelector(".sliderContainer input"));
            int width = input.getSize().getWidth();

            actions.clickAndHold(input)
                    .moveByOffset(width, 0)
                    .perform();

            String actualValue = driver.findElement(By.id("range")).getText();

            if (!"5".equals(actualValue)) {
                System.out.println("Test failed! Expected 5 but got " + actualValue);
            } else {
                System.out.println("Test passed!");
            }
        } finally {
            driver.quit();
        }
    }
}
