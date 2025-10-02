package org.seleniumhowto.testarchitect.tests;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.seleniumhowto.railway.utils.WebDriverManager;
import org.seleniumhowto.testarchitect.base.BaseTest;
import org.seleniumhowto.testarchitect.pages.CheckoutPage;
import org.seleniumhowto.testarchitect.pages.HomePage;
import org.seleniumhowto.testarchitect.pages.ShoppingCartPage;

public class GuestPurchaseTest extends BaseTest {
    HomePage homePage;
    ShoppingCartPage shoppingCartPage;
    CheckoutPage checkoutPage;

    @Before
    public void setUpPages() {
        homePage = new HomePage(driver, wait);
        shoppingCartPage = new ShoppingCartPage(driver, wait, element);
        checkoutPage = new CheckoutPage(driver, wait, element);
    }

    @Test
    public void verifyPurchasingByAGuest() {
        // Step 1: Go to home page
        homePage.goToHomePage();
        homePage.clickPopupAd();

        // Step 2: Click on Cart icon in the top right of shopping page
        homePage.setClickCartICon();
        String getMessageAfterClick = shoppingCartPage.getEmptyCartMessage();
        // VP: Message is shown: YOUR SHOPPING CART IS EMPTY
        String showedMessage = "YOUR SHOPPING CART IS EMPTY";
        Assert.assertEquals(showedMessage, getMessageAfterClick);

        // Step 3: Click on "Return to Shop" button
        shoppingCartPage.clickReturnToShop();

        // Step 4: In Shop page, click on "cart" icon to add a product to cart
        // Airpods or any else item
        shoppingCartPage.addIConCartItem();
        String cartIconText = shoppingCartPage.getCartIconIndex();
        Assert.assertTrue(cartIconText.contains("1"));
        System.out.println("Đã pass verify cart is 1");
        // Step 5: Click on Cart icon in the top right of shopping page
        shoppingCartPage.clickCartIcon();
        // VP: check màu
        shoppingCartPage.checkBlackText();
        shoppingCartPage.checkGreyInCheckoutText();
        shoppingCartPage.checkGreyInOrderStatusText();
        // Step 6: Click on "Process to checkout" button
        checkoutPage.clickCheckoutNav();

        // VP: Shopping Cart is black bold

        // VP: Checkout and Order Status is grey

        // Step 7: Enter required fields  then click on "Place Order" button
        checkoutPage.fillBillingDetails();

        // VP: page
    }

    @After
    public void quitPage() {
        // No need to call WebDriverManager.quitDriver() here because it's already handled in BaseTest
    }
}
