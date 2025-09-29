package org.seleniumhowto.railway.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyTicketPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private Select select;
    private By pageHeader = By.xpath("//h1[.='Manage ticket']");
    private By filterTable = By.xpath("//div[@class='Filter']/table/tbody");
    private By inforTableAfterFilter = By.xpath("//table[@class='MyTable']/tbody");

    public MyTicketPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateTo() {
        driver.findElement(By.xpath("//a[@href='/Page/ManageTicket.cshtml']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageHeader));
    }

    public void applyFilter(String departStation, String arriveStation, String departDate, String status) {
        WebElement tableElement = wait.until(ExpectedConditions.visibilityOfElementLocated(filterTable));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tableElement);

        // String departStation
        select = new Select(driver.findElement(By.xpath("//select[@name='FilterDpStation']")));
        select.selectByVisibleText(departStation);

        // String arriveStation
        select = new Select(driver.findElement(By.xpath("//select[@name='FilterArStation']")));
        select.selectByVisibleText(arriveStation);

        // String departDate
        driver.findElement(By.xpath("//input[@name='FilterDpDate']")).sendKeys(departDate);

        // String status
        select = new Select(driver.findElement(By.xpath("//select[@name='FilterStatus']")));
        select.selectByVisibleText(status);

        // click button apply filter
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    public void scrollToTableAfterFilter() {
        WebElement tableElement = wait.until(ExpectedConditions.visibilityOfElementLocated(inforTableAfterFilter));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tableElement);
    }

    public Map<String, String> getInforTableAfterFilMap () {
        // th: table header, td: table data
        List<WebElement> rowName = driver.findElements(By.xpath("//table[@class='MyTable']/tbody/tr[1]/th"));
        List<WebElement> rowValue = driver.findElements(By.xpath("//table[@class='MyTable']/tbody/tr[2]/td"));
        Map<String, String> inforTableAfterFilMap = new HashMap<>();
        for(int i = 0 ; i < rowName.size(); i++) {
            inforTableAfterFilMap.put(rowName.get(i).getText(), rowValue.get(i).getText());
        }
    //    System.out.println("Giá trị inforTableAfterFilMap: " + inforTableAfterFilMap);

        // Print formatted output
        System.out.println("=== Ticket Information ===");
        System.out.printf("%-20s | %-30s%n", "Field", "Value");
        System.out.println("-".repeat(20) + "-+-" + "-".repeat(30));
        for (Map.Entry<String, String> entry : inforTableAfterFilMap.entrySet()) {
            // Format Total Price with commas for readability
            String value = entry.getKey().equals("Total Price") ?
                    String.format("%,d VND", Long.parseLong(entry.getValue())) :
                    entry.getValue();
            System.out.printf("%-20s | %-30s%n", entry.getKey(), value);
        }
        System.out.println("========================");

        return inforTableAfterFilMap;
    }

}
