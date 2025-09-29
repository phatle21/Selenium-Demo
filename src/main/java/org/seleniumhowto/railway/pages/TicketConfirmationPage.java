package org.seleniumhowto.railway.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TicketConfirmationPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By table = By.xpath("//table[@class='MyTable WideTable']");
    private By rowNames = By.xpath("//tr[@class='TableSmallHeader']/th");
    private By rowValues = By.xpath("//tr[@class='OddRow']/td");

    public TicketConfirmationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public Map<String, String> getTicketInformation() {
        WebElement tableElement = wait.until(ExpectedConditions.elementToBeClickable(table));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tableElement);

        List<WebElement> rowNameElements = driver.findElements(rowNames);
        List<WebElement> rowValueElements = driver.findElements(rowValues);
        Map<String, String> inforTable = new HashMap<>();
        for (int i = 0; i < rowNameElements.size(); i++) {
            inforTable.put(rowNameElements.get(i).getText(), rowValueElements.get(i).getText());
        }
        System.out.println("Giá trị inforTable: " + inforTable);
        return inforTable;
    }
}