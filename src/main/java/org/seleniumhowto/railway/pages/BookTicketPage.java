package org.seleniumhowto.railway.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BookTicketPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By ticketAmountDropdown = By.xpath("//select[@name='TicketAmount']");
    private By submitButton = By.xpath("//input[@type='submit']");
    private By successMessage = By.xpath("//div[@id='content']/h1[.='Ticket booked successfully!']");

    public BookTicketPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void bookTickets(int amount) {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//h1[.='Book ticket']"), "Book ticket"));
        Select selectByValue = new Select(driver.findElement(ticketAmountDropdown));
        selectByValue.selectByValue(String.valueOf(amount));
        driver.findElement(submitButton).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(successMessage, "Ticket booked successfully!"));
    }
}