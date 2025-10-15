package org.seleniumhowto.test_architect_pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MyAccountPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public MyAccountPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='reg_email']")
    private WebElement regEmail;

    @FindBy(xpath = "//a[.='Public Inbox']")
    private WebElement textPublicInbox;

    public String generateMailinatorEmail(String yourName) {
        // Get current date
        LocalDate currentDate = LocalDate.now();
        // Format date as yyyymmdd
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String dateString = currentDate.format(formatter);
        // Construct email address
        return yourName + "." + dateString + "@mailinator.com";
    }

    public void goToMailServerPage() {
        driver.get("https://www.mailinator.com/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(org.openqa.selenium.By.xpath("//div[@id='popmake-5700']")));
    }



}
