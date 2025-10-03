package org.seleniumhowto.testarchitect.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderStatusPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public OrderStatusPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    private By item = By.xpath("//div[@class='woocommerce-order-overview-wrapper']//li[contains(@class, '%s')]/strong");
 //   private By name = By.xpath("")

    public By getItemByClass(String className) {
        String xpath = String.format("//div[@class='woocommerce-order-overview-wrapper']//li[contains(@class, '%s')]/strong", className);
        return By.xpath(xpath);
    }
    public Map<String, String> getData() {
        Map<String, String> orderData = new HashMap<>();

        orderData.put("Order Number", driver.findElement(getItemByClass("order")).getText().trim());
        orderData.put("Date", driver.findElement(getItemByClass("date")).getText().trim());
        orderData.put("Total", driver.findElement(getItemByClass("total")).getText().trim());
        orderData.put("Payment Method", driver.findElement(getItemByClass("method")).getText().trim());

        // ko cần chạy for loop

        for(Map.Entry<String, String> entry: orderData.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        return orderData;
    }

    public boolean isInteger(Object obj) {
        return obj instanceof Integer;
    }

}
