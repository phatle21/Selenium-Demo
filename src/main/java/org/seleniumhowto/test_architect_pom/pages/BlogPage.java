package org.seleniumhowto.test_architect_pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BlogPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public BlogPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    // Logo LG nắm để kéo
    @FindBy(xpath = "//ul[@id='menu-main-menu-1']//li[@id='menu-item-5575']/a")
    private WebElement blogNav;

    public void clickBlogNav() {
        blogNav.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(org.openqa.selenium.By.xpath("//div[@class='etheme-pagination articles-pagination align-right']")));
    }


}
