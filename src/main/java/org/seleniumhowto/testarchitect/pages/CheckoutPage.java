package org.seleniumhowto.testarchitect.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class CheckoutPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private WebElement element;

    private By setFirstname = By.xpath("//input[@id='billing_first_name']");
    private By setLastname = By.xpath("//input[@id='billing_last_name']");
    private By setNameCountry = By.xpath("");
    private By clickDropdownCountry = By.xpath("//span[@class='selection']//span[@id='select2-billing_country-container']");
    private By inputSearchCountry = By.xpath("//input[@class='select2-search__field']");
    private By clickAfterInputCountry = By.xpath("//ul[@id='select2-billing_country-results']/li");
    private By setStreetAddress = By.xpath("//input[@id='billing_address_1']");
    private By setNameCity = By.xpath("//input[@id='billing_city']");
    private By setPhoneNumber = By.xpath("//input[@id='billing_phone']");
    private By uncheckCreateAnAccount = By.xpath("//input[@id='createaccount']");
    private By setZipCode = By.xpath("//input[@id='billing_postcode']");
    private By setEmailAddress = By.xpath("//input[@id='billing_email']");
    private By clickCashOnDelivery = By.xpath("//div[@class='order-review']//li[3]/input");
    private By clickPlaceOrder = By.xpath("//div[@id='order_review']//div[@id='payment']//div[contains(@class, 'place-order')]/button[@id='place_order']");
    private By textOrderStatus = By.xpath("//p[.='Thank you. Your order has been received.']");


    private By fix = By.xpath("//div[contains(@class, 'cart-order-details')]//div[@class='payment_box payment_method_cod']/p");

    public CheckoutPage(WebDriver driver, WebDriverWait wait, WebElement element) {
        this.driver = driver;
        this.wait = wait;
        this.element = element;
    }

    private By checkoutNav = By.xpath("//div[@class='cart-checkout-nav']//a[.=' Checkout']");

    public void clickCheckoutNav() {
        driver.findElement(checkoutNav).click();
     //   wait.until(ExpectedConditions.urlMatches("https://demo.testarchitect.com/checkout/"));
        wait.until(ExpectedConditions.attributeContains(By.xpath("//a[@class='active no-click']"), "data-step", "2"));
    }

    public void checkBlackText() {
       element= driver.findElement(By.xpath("//a[@data-step='1']"));
        String blackText = element.getCssValue("color");
        System.out.println("Element is color: " + blackText);
    }

    public static String getRandomCity() {
        String[] cities = {"Ho Chi Minh", "Hue", "Da Nang"};
        Random rand = new Random();
        int randomIndex = rand.nextInt(cities.length);
        return cities[randomIndex];
    }

    // dung static thi ko goi dc ??? tsao
    public String getTodayDate() {
        LocalDate today = LocalDate.now();
      //  return today.toString(); // format: yyyy-MM-dd
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        return today.format(formatter);  // Định dạng ngày theo "MMMM d, yyyy"
    }


    public void fillBillingDetails() {

        driver.findElement(setFirstname).sendKeys("Phat");
        driver.findElement(setLastname).sendKeys("Le");
      //  JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].scrollIntoView();", setStreetAddress);
        driver.findElement(clickDropdownCountry).click();
        // dropdown làm dynamic thì đưa vào
        driver.findElement(inputSearchCountry).sendKeys("Vietnam");
        driver.findElement(clickAfterInputCountry).click();

        driver.findElement(setStreetAddress).sendKeys("123 ABC XYZ");
        // random 3 dia diem
        driver.findElement(setNameCity).sendKeys(getRandomCity());
        driver.findElement(setZipCode).sendKeys("760895");
        driver.findElement(setPhoneNumber).sendKeys("0147852369");
        // your.name.yyyymmdd@mailinator.com
        driver.findElement(setEmailAddress).sendKeys("abc.xyz.111111@mailinator.com");

        // check uncheck create account
        element = driver.findElement(uncheckCreateAnAccount);
        if(element.isSelected()) {
            element.click();
            System.out.println("Đã tick vào ô checkbox để mất tick");
        } else {
            System.out.println("Không cần phải tick");
        }

        wait.until(ExpectedConditions.elementToBeSelected(By.id("payment_method_bacs")));
        System.out.println("passed chỗ direct bank transfer");


        WebElement placeOrderButton = driver.findElement(By.id("payment_method_cod"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", placeOrderButton);
        WebElement button = driver.findElement(By.id("place_order"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
        System.out.println("passwd click place order");
// Đợi tài liệu tải xong
        wait.until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
        System.out.println("doi tai 1");
// Đợi phần tử mới xuất hiện sau khi tải trang
        wait.until(ExpectedConditions.visibilityOfElementLocated(textOrderStatus));
        System.out.println("end");
    }
}
