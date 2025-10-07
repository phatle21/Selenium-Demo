package org.seleniumhowto.test_architect_pom.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class InforProductsPageAfterSearch {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(xpath = "//div[@class='input-row flex align-items-center ']//input[@class='form-control']")
    private WebElement inputTextSearchBar;

    @FindBy(xpath = "//div[@class='input-row flex align-items-center ']//button[contains(@class, 'search-button')]")
    private WebElement clickSearch;

    @FindBy(xpath = "//h2[@class='products-title']")
    private WebElement getTextQuantityProductsFound;

    @FindBy(xpath = "//h2[@class='product-title']")
    private WebElement getProductsTitle;

    public void verifySearchResultsContain(String keyword) {
        List<WebElement> productTitles = driver.findElements(By.xpath("//h2[@class='product-title']"));
        // Print number of products
        System.out.println("Total products found: " + productTitles.size());
        // Assert at least 1 product is found
        Assert.assertTrue("❌ No products found!", productTitles.size() > 0);
        for(WebElement title : productTitles) {
            String productName = title.getText().toLowerCase();
            System.out.println("print" + productName);
            System.out.println("Checking product: " + productName);
            Assert.assertTrue("❌ Product name does not contain '" + keyword + "': " + productName,
                    productName.contains(keyword));
        }
        System.out.println("✅ Search result verification passed!");
    }

    public String getTextQuantityProductsFound(){
        return getTextQuantityProductsFound.getText();
    }

    public void inputDataSearchBar(String inputText){
        inputTextSearchBar.sendKeys(inputText);
        inputTextSearchBar.submit();
      //  clickSearch.click();
        wait.until(ExpectedConditions.urlContains("product"));
    }

    public InforProductsPageAfterSearch(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }



}
