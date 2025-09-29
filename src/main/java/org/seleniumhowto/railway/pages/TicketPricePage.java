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

public class TicketPricePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By seatTypes = By.xpath("//table[@class='MyTable MedTable']//tr[2]/td");
    private By pricesRow = By.xpath("//table[@class='MyTable MedTable']//tr[3]/td");

    public TicketPricePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public Map<String, String> getSeatPriceMap() {
        List<WebElement> seatTypeElements = driver.findElements(seatTypes);
        List<WebElement> priceElements = driver.findElements(pricesRow);
        Map<String, String> seatPriceMap = new HashMap<>();
        for (int i = 0; i < seatTypeElements.size(); i++) {
            seatPriceMap.put(seatTypeElements.get(i).getText(), priceElements.get(i).getText());
        }
        System.out.println("Giá trị seatPriceMap: " + seatPriceMap);
        return seatPriceMap;
    }

    public void clickBookTicket(String id1, String id2, String id3) {
        String bookTicketXpath = String.format("//table[@class='NoBorder']//tr/td/a[contains(@href, 'BookTicketPage.cshtml?id1=%s&id2=%s&id3=%s')]", id1, id2, id3);
        System.out.println("XPath của clickBookTicket: " + bookTicketXpath);
        WebElement bookTicketLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(bookTicketXpath)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bookTicketLink);
        bookTicketLink.click();
    }
}