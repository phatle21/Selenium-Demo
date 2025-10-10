package org.seleniumhowto.test_architect_pom.tests;

import com.aventstack.extentreports.*;
import org.testng.annotations.*;
import org.testng.Assert;
import org.seleniumhowto.test_architect_pom.base.BaseTest;
import org.seleniumhowto.test_architect_pom.pages.*;
import org.seleniumhowto.test_architect_pom.utils.ExtentReportManager;

public class SearchFunctionallyOnHomePage extends BaseTest {
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

    @Test(description = "Verify search functionality on Home Page using keyword 'laser'")
    public void searchFunctionallyOnHomePage() {
        test = extent.createTest("Search Functionality Test");

        try {
            // Step 1: Go to home page and close popup
            homePage.goToHomePage();
            homePage.clickPopupAd();
            test.log(Status.INFO, "Opened homepage and closed popup ad");

            // Step 2: In Search textbox, enter search keyword 'laser'
            String keyWord = "laser";
            inforProductsPageAfterSearch.inputDataSearchBar(keyWord);
            test.log(Status.INFO, "Entered search keyword: " + keyWord);

            // Verify search results
            String quantityProductsFound = inforProductsPageAfterSearch.getTextQuantityProductsFound();
            test.log(Status.INFO, "Found products: " + quantityProductsFound);

            inforProductsPageAfterSearch.verifySearchResultsContain(keyWord);
            test.pass("All search results contain keyword: " + keyWord);

        } catch (Exception e) {
            test.fail("Test failed: " + e.getMessage());
            Assert.fail(e.getMessage());
        }
    }

    @AfterSuite
    public void tearDownReport() {
        extent.flush(); // ✅ Xuất file HTML report
    }
}
