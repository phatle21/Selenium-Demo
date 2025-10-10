package org.seleniumhowto.test_architect_pom.tests;

import org.junit.Before;
import org.junit.Test;
import org.seleniumhowto.test_architect_pom.base.BaseTest;
import org.seleniumhowto.test_architect_pom.pages.*;

public class LogoSliderFunctionallyOnHomePage extends BaseTest {
    private HomePage homePage;
    private ShoppingCartPage shoppingCartPage;
    private CheckoutPage checkoutPage;
    private OrderStatusPage orderStatusPage;
    private InforProductsPageAfterSearch inforProductsPageAfterSearch;

    @Before
    public void setUpPages() {
        homePage = new HomePage(driver, wait);
        shoppingCartPage = new ShoppingCartPage(driver, wait);
        checkoutPage = new CheckoutPage(driver, wait);
        orderStatusPage = new OrderStatusPage(driver, wait);
        inforProductsPageAfterSearch = new InforProductsPageAfterSearch(driver, wait);
    }

    @Test
    public void dragAndDropSlider() {
// Step 1: Go to home page and close popup
        homePage.goToHomePage();
        homePage.clickPopupAd();

        homePage.scrollToCarousel();
        homePage.testSwiperSlideDisappear();
    }
}
