package org.seleniumhowto.test_architect_pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

public class OrderStatusPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(xpath = "//div[@class='woocommerce-order-overview-wrapper']//li[contains(@class, 'order')]/strong")
    private WebElement orderNumber;

    @FindBy(xpath = "//div[@class='woocommerce-order-overview-wrapper']//li[contains(@class, 'date')]/strong")
    private WebElement orderDate;

    @FindBy(xpath = "//div[@class='woocommerce-order-overview-wrapper']//li[contains(@class, 'total')]/strong")
    private WebElement orderTotal;

    @FindBy(xpath = "//div[@class='woocommerce-order-overview-wrapper']//li[contains(@class, 'method')]/strong")
    private WebElement paymentMethod;

    public OrderStatusPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public Map<String, String> getData() {
        Map<String, String> orderData = new HashMap<>();
        orderData.put("Order Number", orderNumber.getText().trim());
        orderData.put("Date", orderDate.getText().trim());
        orderData.put("Total", orderTotal.getText().trim());
        orderData.put("Payment Method", paymentMethod.getText().trim());
        printOrderData(orderData);
        return orderData;
    }

    private void printOrderData(Map<String, String> orderData) {
        orderData.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
