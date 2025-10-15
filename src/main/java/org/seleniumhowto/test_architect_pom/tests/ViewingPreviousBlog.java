package org.seleniumhowto.test_architect_pom.tests;

import org.junit.Before;
import org.junit.Test;
import org.seleniumhowto.test_architect_pom.base.BaseTest;
import org.seleniumhowto.test_architect_pom.pages.*;

public class ViewingPreviousBlog extends BaseTest {

    private HomePage homePage;
    private ShoppingCartPage shoppingCartPage;
    private CheckoutPage checkoutPage;
    private OrderStatusPage orderStatusPage;
    private BlogPage blogPage;

    @Before
    public void setUpPages() {
        homePage = new HomePage(driver, wait);
        shoppingCartPage = new ShoppingCartPage(driver, wait);
        checkoutPage = new CheckoutPage(driver, wait);
        orderStatusPage = new OrderStatusPage(driver, wait);
    }

    // testcase outdate

    @Test
    public void ViewingPreviousBlog() {
        // Step 1: Go to home page and close popup
        homePage.goToHomePage();
        homePage.clickPopupAd();

        //
        blogPage.clickBlogNav();
    }
}
