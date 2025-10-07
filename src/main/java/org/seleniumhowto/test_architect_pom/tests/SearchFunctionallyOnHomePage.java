package org.seleniumhowto.test_architect_pom.tests;

import org.junit.Before;
import org.junit.Test;
import org.seleniumhowto.test_architect_pom.base.BaseTest;
import org.seleniumhowto.test_architect_pom.pages.*;

public class SearchFunctionallyOnHomePage extends BaseTest {
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
    public void searchFunctionallyOnHomePage() {
        // Step 1: Go to home page and close popup
        homePage.goToHomePage();
        homePage.clickPopupAd();

        // Step 2: In Search textbox, enter search keyword 'laser'
        String keyWord = "laser";
        inforProductsPageAfterSearch.inputDataSearchBar(keyWord);
        // VP: - n Products Found
        String quantityProductsFound = inforProductsPageAfterSearch.getTextQuantityProductsFound();
        System.out.println(quantityProductsFound);
        // page only displays exactly "n product with name matched the given keyword"
        inforProductsPageAfterSearch.verifySearchResultsContain(keyWord);
    }
}
