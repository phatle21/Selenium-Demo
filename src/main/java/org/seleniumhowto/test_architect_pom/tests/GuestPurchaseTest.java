package org.seleniumhowto.test_architect_pom.tests;

import org.junit.*;
import org.seleniumhowto.test_architect_pom.base.BaseTest;
import org.seleniumhowto.test_architect_pom.pages.CheckoutPage;
import org.seleniumhowto.test_architect_pom.pages.HomePage;
import org.seleniumhowto.test_architect_pom.pages.OrderStatusPage;
import org.seleniumhowto.test_architect_pom.pages.ShoppingCartPage;

import java.util.Map;

public class GuestPurchaseTest extends BaseTest {
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
    public void verifyPurchasingByAGuest() {
        // Step 1: Go to home page and close popup
        homePage.goToHomePage();
        homePage.clickPopupAd();

        // Step 2: Click on Cart icon and verify empty cart message
        homePage.setClickCartICon();
        String emptyCartMessage = shoppingCartPage.getEmptyCartMessage();
        Assert.assertEquals("Empty cart message did not match!", "YOUR SHOPPING CART IS EMPTY", emptyCartMessage);

        // Step 3: Return to Shop page
        shoppingCartPage.clickReturnToShop();

        // Step 4: Add a product to cart and verify cart icon
        shoppingCartPage.addIConCartItem();
        String cartIconText = shoppingCartPage.getCartIconIndex();
        Assert.assertEquals("Cart icon count is incorrect!", "1", cartIconText);
        System.out.println("Verified cart contains 1 item");

        // Step 5: Click Cart icon and verify navigation colors
        shoppingCartPage.clickCartIcon();
        shoppingCartPage.checkBlackText();
        shoppingCartPage.checkGreyInCheckoutText();
        shoppingCartPage.checkGreyInOrderStatusText();

        // Step 6: Proceed to checkout
        checkoutPage.clickCheckoutNav();

        // Step 7: Fill billing details and place order
        checkoutPage.fillBillingDetails();

        // Step 8: Verify order details
        Map<String, String> orderData = orderStatusPage.getData();
        String orderDate = orderData.get("Date");
        String expectedDate = checkoutPage.getTodayDate();
        Assert.assertEquals("Order date did not match!", expectedDate, orderDate);
        System.out.println("Order date verified: " + orderDate);

        String orderTotal = orderData.get("Total");
        String cartPrice = shoppingCartPage.getPriceItem();
    //    Assert.assertEquals("Order total did not match cart price!", orderTotal, cartPrice);
     //   System.out.println("Order total verified: " + orderTotal);
    }
}
