package org.seleniumhowto.test_architect_pom.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.junit.Before;
import org.seleniumhowto.test_architect_pom.base.BaseTest;
import org.seleniumhowto.test_architect_pom.pages.*;
import org.seleniumhowto.test_architect_pom.utils.ExtentReportManager;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LogoSliderFunctionallyOnHomePage extends BaseTest {

    private HomePage homePage;
    private ShoppingCartPage shoppingCartPage;
    private CheckoutPage checkoutPage;
    private OrderStatusPage orderStatusPage;
    private InforProductsPageAfterSearch inforProductsPageAfterSearch;

    private static ExtentReports extent;
    private ExtentTest test;

    @BeforeSuite
    public void setupReport() {
        extent = ExtentReportManager.getInstance();
    }

    @BeforeMethod
    public void setUpPages() {
        homePage = new HomePage(driver, wait);
        shoppingCartPage = new ShoppingCartPage(driver, wait);
        checkoutPage = new CheckoutPage(driver, wait);
        orderStatusPage = new OrderStatusPage(driver, wait);
        inforProductsPageAfterSearch = new InforProductsPageAfterSearch(driver, wait);
    }

    @Test(description = "slider")
    public void dragAndDropSlider() {
        test = extent.createTest("abc xyz");
        try {
            // Ensure WebDriver is initialized
            Assert.assertNotNull(driver, "WebDriver is null, initialization failed");

// Step 1: Go to home page and close popup
            homePage.goToHomePage();
            homePage.clickPopupAd();

            homePage.scrollToCarousel();
            homePage.testSwiperSlideDisappear();
            // co the them screenshot


        } catch (Exception e) {
            test.fail("Test failed: " + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    @AfterSuite
    public void tearDownReport() {
        extent.flush(); // Export HTML report
    }
}
