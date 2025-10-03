package org.seleniumhowto.testarchitect.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShoppingCartPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private WebElement element;

    private By emptyMessage = By.xpath("//h1[.='YOUR SHOPPING CART IS EMPTY']");
    private By returnToShop = By.xpath("//a[contains(@class, 'btn black')]");
    private By cartIcon = By.xpath("//div[contains(@class, 'pos-static')]//div[contains(@class, 'cart-type1')]/a");
    private By getCartIconIndex = By.xpath("//div[contains(@class, 'pos-static')]//span[contains(@class, 'justify-content-center')]//span[contains(@class, 'et-cart-quantity')]");
    private By priceCart = By.xpath("//div[contains(@class, 'pos-static')]//span[contains(@class, 'justify-content-center')]//span[contains(@class, 'amount')]");
    private By cartCheckoutNav = By.xpath("//div[@class='cart-checkout-nav']");

    private By getNameProduct = By.xpath("//div[contains(@class, 'row-count-3')]//div[@class='content-product ']//h2/a[.='AirPods']");

    public ShoppingCartPage(WebDriver driver, WebDriverWait wait, WebElement element) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.element = element;
    }

    public By getNameItemByClass(String className) {
        String xpath = String.format("//div[contains(@class, 'row-count-3')]//div[@class='content-product ']//h2/a[.='%s']", className);
        return By.xpath(xpath);
    }

    public String getPriceItem() {
        String priceCt = driver.findElement(priceCart).getText();
        return priceCt;
//        priceIt.replace("$", "");
//        System.out.println("Giá: " + priceIt);
//        return priceIt;
    }

    public String getNameProduct() {
        String namePrd = driver.findElement(getNameProduct).getText().trim();
        return namePrd;
    }

    public String getEmptyCartMessage() {
        return driver.findElement(emptyMessage).getText();
    }

    public void clickReturnToShop() {
        driver.findElement(returnToShop).click();
        // Wait cho trang Shop load xong
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[.='Shop']")));
    }

    public void addIConCartItem() {
        // click random: //h2[@class='product-title'] for loop

        driver.findElement(By.xpath("//div[@class='content-product ']//footer[@class='footer-product']//a[@data-product_name='AirPods']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-type='success']")));
     //   element = driver.findElement(By.xpath("//div[@data-type='success']"));
     //   Assert.assertTrue(element.isDisplayed());

        // dynamic số lượng
    }

    public String getCartIconIndex() {
        return driver.findElement(getCartIconIndex).getText();
    }

    public void clickCartIcon() {
        driver.findElement(cartIcon).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartCheckoutNav));
    }

    public void checkBlackText() {
        element= driver.findElement(By.xpath("//a[@data-step='1']"));
        String blackText = element.getCssValue("color");
        System.out.println("Element is color: " + blackText);
//        if (element.equals("rgb(34, 34, 34, 1)")) {
//            System.out.println("The color is black!");
//        } else {
//            System.out.println("The color is not black.");
//        }
        String expectedColor = "rgba(34, 34, 34, 1)";
        Assert.assertEquals("Color did not match!", expectedColor, blackText);
        System.out.println("The color is correct!");
    }

    public void checkGreyInCheckoutText() {
        element = driver.findElement(By.xpath("//a[@data-step='2']"));
        String greyText = element.getCssValue("color");
        System.out.println("Element is color data step 2: " + greyText);
        String expectedColor = "rgba(154, 154, 154, 1)";
        Assert.assertEquals("Color did not match!", expectedColor, greyText);
        System.out.println("The color is correct! của data-step2");
    }

    public void checkGreyInOrderStatusText() {
        element = driver.findElement(By.xpath("//a[@data-step='3']"));
        String greyText = element.getCssValue("color");
        System.out.println("Element is color data step 2: " + greyText);
        String expectedColor = "rgba(154, 154, 154, 1)";
        Assert.assertEquals("Color did not match!", expectedColor, greyText);
        System.out.println("The color is correct! của data-step3");
    }

}
