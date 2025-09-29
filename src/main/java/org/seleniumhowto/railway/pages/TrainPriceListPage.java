package org.seleniumhowto.railway.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TrainPriceListPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By pageHeader = By.xpath("//h1[.='Train ticket price list']");

    public TrainPriceListPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateTo() {
        driver.findElement(By.xpath("//a[@href='/Page/TrainPriceListPage.cshtml']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageHeader));
    }

    public void scrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void clickCheckPrice(String id1, String id2) {
        String checkPriceXpath = String.format("//a[contains(@href, 'TicketPricePage.cshtml?id1=%s&id2=%s')]", id1, id2);
        System.out.println("XPath clickCheckPrice: " + checkPriceXpath);
        driver.findElement(By.xpath(checkPriceXpath)).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//h1[.='Ticket Price']"), "Ticket Price"));
    }
}