package org.seleniumhowto.test_architect_pom.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(xpath = "//h1[.='YOUR SHOPPING CART IS EMPTY']")
    private WebElement emptyMessage;

    @FindBy(xpath = "//a[contains(@class, 'btn black')]")
    private WebElement returnToShopButton;

    @FindBy(xpath = "//div[contains(@class, 'pos-static')]//div[contains(@class, 'cart-type1')]/a")
    private WebElement cartIcon;

    @FindBy(xpath = "//div[contains(@class, 'pos-static')]//span[contains(@class, 'et-cart-quantity')]")
    private WebElement cartIconIndex;

    @FindBy(xpath = "//div[contains(@class, 'pos-static')]//span[contains(@class, 'amount')]")
    private WebElement priceCart;

    @FindBy(xpath = "//div[@class='cart-checkout-nav']")
    private WebElement cartCheckoutNav;

    @FindBy(xpath = "//div[@class='content-product ']//h2/a[.='AirPods']")
    private WebElement productName;

    @FindBy(xpath = "//div[@class='content-product ']//footer[@class='footer-product']//a[@data-product_name='AirPods']")
    private WebElement addToCartButton;

    // bat dynamic nameProduct
    @FindBy(xpath = "//tr[contains(@class, 'woocommerce-cart-form__cart-item')]//td[@class='product-details']//div[@class='cart-item-details']/a[.='AirPods']")
    private WebElement getNameProduct;

    @FindBy(xpath = "//tr[contains(@class, 'woocommerce-cart-form__cart-item')]//td[@class='product-price']//bdi")
    private WebElement getPrice;

    @FindBy(xpath = "//tr[contains(@class, 'woocommerce-cart-form__cart-item')]//td[@class='product-quantity']//input")
    private WebElement getQuantity;

    @FindBy(xpath = "//tr[contains(@class, 'woocommerce-cart-form__cart-item')]//td[@class='product-subtotal']//bdi")
    private WebElement getSubTotal;

    @FindBy(xpath = "//tr[contains(@class, 'woocommerce-cart-form__cart-item')]//td[@class='product-details']//div[@class='cart-item-details']/a[.='Remove']")
    private WebElement clickRemove;

    @FindBy(xpath = "//h1[.='YOUR SHOPPING CART IS EMPTY']")
    private WebElement textAfterCartEmpty;

    @FindBy(xpath = "//div[contains(@class, 'connect-block-element-ochYn')]/div[contains(@class, 'et_element et_b_header-cart')]//span[@class='et_b-icon']/span[2]")
    private WebElement getQuantityCartIndex;

    public int getQuantityCartIndex(){
        return Integer.parseInt(getQuantityCartIndex.getText());
    }

    public void clickRemoveProduct(){
        clickRemove.click();
    }

    public String getTextAfterCartEmpty(){
        return textAfterCartEmpty.getText();
    }

    // Get lấy tên sản phẩm
    public String getActualProductName() {
        return getNameProduct.getText();
    }
    // Get lấy giá sản phẩm
    public String getActualPriceProduct() {
        return getPrice.getText();
    }
    // Get lấy số lượng sản phẩm
    public int getActualQuantityProduct() {
        return Integer.parseInt(getQuantity.getAttribute("value")); // Lấy giá trị từ input
    }
    // Get lấy tổng tiền sản phẩm
    public String getActualSubTotalProduct() {
        return getSubTotal.getText();
    }

    public ShoppingCartPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public String getPriceItem() {
        return priceCart.getText().trim();
    }

    public String getNameProduct() {
        return productName.getText().trim();
    }

    public String getEmptyCartMessage() {
        return emptyMessage.getText();
    }

    public void clickReturnToShop() {
        returnToShopButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(org.openqa.selenium.By.xpath("//h1[.='Shop']")));
    }

    public void addIConCartItem() {
        addToCartButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(org.openqa.selenium.By.xpath("//div[@data-type='success']")));
    }

    public String getCartIconIndex() {
        return cartIconIndex.getText();
    }

    public void clickCartIcon() {
        cartIcon.click();
        wait.until(ExpectedConditions.visibilityOf(cartCheckoutNav));
    }

    public void checkBlackText() {
        WebElement step1 = wait.until(ExpectedConditions.visibilityOfElementLocated(org.openqa.selenium.By.xpath("//a[@data-step='1']")));
        String color = step1.getCssValue("color");
        Assert.assertEquals("Color did not match!", "rgba(34, 34, 34, 1)", color);
        System.out.println("Step 1 color is correct: " + color);
    }

    public void checkGreyInCheckoutText() {
        WebElement step2 = wait.until(ExpectedConditions.visibilityOfElementLocated(org.openqa.selenium.By.xpath("//a[@data-step='2']")));
        String color = step2.getCssValue("color");
        Assert.assertEquals("Color did not match!", "rgba(154, 154, 154, 1)", color);
        System.out.println("Step 2 color is correct: " + color);
    }

    public void checkGreyInOrderStatusText() {
        WebElement step3 = wait.until(ExpectedConditions.visibilityOfElementLocated(org.openqa.selenium.By.xpath("//a[@data-step='3']")));
        String color = step3.getCssValue("color");
        Assert.assertEquals("Color did not match!", "rgba(154, 154, 154, 1)", color);
        System.out.println("Step 3 color is correct: " + color);
    }
}
