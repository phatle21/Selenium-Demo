package org.seleniumhowto.test_architect_pom.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.seleniumhowto.test_architect_pom.base.BaseTest;
import org.seleniumhowto.test_architect_pom.pages.CheckoutPage;
import org.seleniumhowto.test_architect_pom.pages.HomePage;
import org.seleniumhowto.test_architect_pom.pages.OrderStatusPage;
import org.seleniumhowto.test_architect_pom.pages.ShoppingCartPage;

public class ClearingShoppingCart extends BaseTest {
    private HomePage homePage;
    private ShoppingCartPage shoppingCartPage;
    private CheckoutPage checkoutPage;
    private OrderStatusPage orderStatusPage;

    @Before
    public void setUpPages() {
        homePage = new HomePage(driver, wait);
        shoppingCartPage = new ShoppingCartPage(driver, wait);
        checkoutPage = new CheckoutPage(driver, wait);
        orderStatusPage = new OrderStatusPage(driver, wait);
    }

    @Test
    public void verifyingClearingShoppingCart() {
        // Step 1: Go to home page and close popup
        homePage.goToHomePage();
        homePage.clickPopupAd();

        // Step 2: Click on Shop link
        homePage.clickShopNav();

        // Step 3: Click on cart icon to add product to cart
        shoppingCartPage.addIConCartItem();
        String cartIconText = shoppingCartPage.getCartIconIndex();
        // VP: Cart icon number at the top right of Shop page is increased correctly
        Assert.assertEquals("Cart icon count is incorrect!", "1", cartIconText);
        System.out.println("Verified cart contains 1 item");

        // Step 4: Click on cart icon to add product to cart
        shoppingCartPage.clickCartIcon();
        // VP: SHOPPING CART is shown with corrected info (item name, price, quantity, total)
        String actualProductName = shoppingCartPage.getActualProductName();
        String expectedProductName = "AirPods";
        Assert.assertEquals("Sai tên product", expectedProductName, actualProductName);
        System.out.println("Passed name");

        String actualPriceProduct = shoppingCartPage.getActualPriceProduct();
        String expectedPriceProduct = "$290.00";
        Assert.assertEquals("Sai giá sản phẩm", expectedPriceProduct, actualPriceProduct);
        System.out.println("Passed price");

        int actualQuantityProduct = shoppingCartPage.getActualQuantityProduct();
        int expectedQuantityProduct = 1;
        Assert.assertEquals("Sai giá sản phẩm", expectedQuantityProduct, actualQuantityProduct);
        System.out.println("Passed quantity");

        String actualSubTotalPrice = shoppingCartPage.getActualSubTotalProduct();
        String expectedSubTotalPrice = "$290.00";
        Assert.assertEquals("Sai tổng giá sản phẩm", expectedSubTotalPrice, actualSubTotalPrice);
        System.out.println("Passed subtotal");

        // Step 5: Click on "Clear Shopping Cart" (button is disabled) thay bằng click remove
        // VP: Pop-up "Are you sure" is shown (ngưng verify)

        // Step 6: Click OK
        shoppingCartPage.clickRemoveProduct();
        shoppingCartPage.checkBlackText();
        // VP: "YOUR SHOPPING CART IS EMPTY" is shown, There is no more item in Shopping Cart page.
        String actualTextAfterCartEmpty = shoppingCartPage.getTextAfterCartEmpty();
        String expectedTextAfterCartEmpty = "YOUR SHOPPING CART IS EMPTY";
        Assert.assertEquals("Thông báo không đúng", expectedTextAfterCartEmpty, actualTextAfterCartEmpty);
        System.out.println("Passed checked text");

        int actualIConIndexCart = shoppingCartPage.getQuantityCartIndex();
        int expectedIconIndexCart = 0;
        Assert.assertEquals("Không bằng nhau", expectedIconIndexCart, actualIConIndexCart);
        System.out.println("Passed checked quantity");

    }
}
