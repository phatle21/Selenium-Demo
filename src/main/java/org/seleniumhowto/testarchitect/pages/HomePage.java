package org.seleniumhowto.testarchitect.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    public WebDriver driver;
    public WebDriverWait wait;

    private By clickCartICon = By.xpath("//div[contains(@class, 'et-quantity-right') and contains(@class, 'cart-type1') and contains(@class, 'et-content-dropdown')]");
    private By closePopupAd = By.xpath("//div[@id='popmake-5700']//button");


    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void goToHomePage() {
        driver.get("https://demo.testarchitect.com/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='popmake-5700']")));

    }

    public void clickPopupAd() {
        driver.findElement(closePopupAd).click();
    }


    public void setClickCartICon() {
        driver.findElement(clickCartICon).click();
    }
}
