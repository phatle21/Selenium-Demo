package org.seleniumhowto.test_architect_pom.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class CheckoutPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final JavascriptExecutor js; // ✅ Thêm JS executor

    @FindBy(xpath = "//input[@id='billing_first_name']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@id='billing_last_name']")
    private WebElement lastNameField;

    @FindBy(xpath = "//span[@id='select2-billing_country-container']")
    private WebElement dropdownCountry;

    @FindBy(xpath = "//input[@class='select2-search__field']")
    private WebElement searchCountryField;

    @FindBy(xpath = "//ul[@id='select2-billing_country-results']/li")
    private WebElement selectCountry;

    @FindBy(xpath = "//input[@id='billing_address_1']")
    private WebElement streetAddressField;

    @FindBy(xpath = "//input[@id='billing_city']")
    private WebElement cityField;

    @FindBy(xpath = "//input[@id='billing_postcode']")
    private WebElement zipCodeField;

    @FindBy(xpath = "//input[@id='billing_phone']")
    private WebElement phoneNumberField;

    @FindBy(xpath = "//input[@id='billing_email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='createaccount']")
    private WebElement createAccountCheckbox;

    @FindBy(id = "payment_method_cod")
    private WebElement cashOnDeliveryRadio;

    @FindBy(id = "place_order")
    private WebElement placeOrderButton;

    @FindBy(xpath = "//p[.='Thank you. Your order has been received.']")
    private WebElement orderStatusMessage;

    @FindBy(xpath = "//div[@class='cart-checkout-nav']//a[.=' Checkout']")
    private WebElement checkoutNav;

    public CheckoutPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        this.js = (JavascriptExecutor) driver; // ✅ Khởi tạo JS executor
        PageFactory.initElements(driver, this);
    }

    // ✅ Click bằng JS khi element bị che khuất
    private void clickWithJS(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        js.executeScript("arguments[0].click();", element);
    }

    // ✅ Đợi trang load hoàn toàn
    private void waitForPageLoad() {
        wait.until(driver ->
                js.executeScript("return document.readyState").equals("complete"));
    }

    public void clickCheckoutNav() {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutNav)).click();
        wait.until(ExpectedConditions.attributeContains(
                By.xpath("//a[@class='active no-click']"), "data-step", "2"));
    }

    public void checkBlackText() {
        WebElement step1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[@data-step='1']")));
        String color = step1.getCssValue("color");
        System.out.println("Step 1 color: " + color);
    }

    public String getRandomCity() {
        String[] cities = {"Ho Chi Minh", "Hue", "Da Nang"};
        return cities[new Random().nextInt(cities.length)];
    }

    public String getTodayDate() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
        return today.format(formatter);
    }

    public void fillBillingDetails() {
        try {
            firstNameField.sendKeys("Phat");
            lastNameField.sendKeys("Le");

            dropdownCountry.click();
            searchCountryField.sendKeys("Vietnam");
            wait.until(ExpectedConditions.elementToBeClickable(selectCountry)).click();

            streetAddressField.sendKeys("123 ABC XYZ");
            cityField.sendKeys(getRandomCity());
            zipCodeField.sendKeys("760895");
            phoneNumberField.sendKeys("0147852369");
            emailField.sendKeys("abc.xyz.111111@mailinator.com");

            if (createAccountCheckbox.isSelected()) {
                createAccountCheckbox.click();
                System.out.println("Unchecked create account checkbox");
            }

            // ✅ Dùng JS click cho an toàn (tránh element bị che)
            clickWithJS(cashOnDeliveryRadio);
            clickWithJS(placeOrderButton);

            // ✅ Đợi trang load và thông báo hiển thị
            waitForPageLoad();
            wait.until(ExpectedConditions.visibilityOf(orderStatusMessage));
            System.out.println("Order placed successfully");

        } catch (Exception e) {
            throw new RuntimeException("Failed to fill billing details: " + e.getMessage());
        }
    }
}
