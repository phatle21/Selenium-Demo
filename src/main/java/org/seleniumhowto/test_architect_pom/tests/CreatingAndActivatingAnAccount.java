package org.seleniumhowto.test_architect_pom.tests;

import org.junit.Before;
import org.junit.Test;
import org.seleniumhowto.test_architect_pom.base.BaseTest;
import org.seleniumhowto.test_architect_pom.pages.CheckoutPage;
import org.seleniumhowto.test_architect_pom.pages.HomePage;
import org.seleniumhowto.test_architect_pom.pages.OrderStatusPage;
import org.seleniumhowto.test_architect_pom.pages.ShoppingCartPage;

public class CreatingAndActivatingAnAccount extends BaseTest {

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
    public void creatingAndActivatingAnAccount() {

    }
}
