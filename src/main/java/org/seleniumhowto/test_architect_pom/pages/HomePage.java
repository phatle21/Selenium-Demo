package org.seleniumhowto.test_architect_pom.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(xpath = "//div[contains(@class, 'cart-type1')]/a")
    private WebElement cartIcon;

    @FindBy(xpath = "//div[@id='popmake-5700']//button")
    private WebElement closePopupButton;

    // bắt dynamic
    @FindBy(xpath = "//ul[@id='menu-main-menu-1']//li[@id='menu-item-5578']/a")
    private WebElement navBar;

    // scroll to slider
    @FindBy(xpath = "//div[contains(@class, 'elementor-image-carousel-wrapper')]")
    private WebElement sliderImages;

    // Logo LG nắm để kéo
    @FindBy(xpath = "//div[contains(@class, 'elementor-image-carousel-wrapper')]//div[@class='swiper-slide swiper-slide-next']//img[@class='swiper-slide-image']")
    private WebElement lgImage;

    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public void scrollToCarousel(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
       // js.executeScript("arguments[0].scrollIntoView(true);", sliderImages);
        js.executeScript("window.scrollTo(654, 4720);");

        try {
            Thread.sleep(5000); // dừng 1 giây (1000 milliseconds)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Hàm swipe slide từ trái sang phải
    private void swipeSlide(WebElement slide, int offsetX) {
        Actions actions = new Actions(driver);
        actions.clickAndHold(slide)
                .moveByOffset(offsetX, 0)
                .pause(Duration.ofMillis(500))
                .release()
                .perform();

        // Chờ animation kết thúc
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void testSwiperSlideDisappear(){
        // logo nắm để kéo
        swipeSlide(lgImage, 600);

    }

    public void clickShopNav() {
        navBar.click();
        // wait xuất hiện airpods
        wait.until(ExpectedConditions.visibilityOfElementLocated(org.openqa.selenium.By.xpath("//div[@class='content-product ']//h2/a[.='AirPods']")));

    }

    public void goToHomePage() {
        driver.get("https://demo.testarchitect.com/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(org.openqa.selenium.By.xpath("//div[@id='popmake-5700']")));
    }

    public void clickPopupAd() {
        closePopupButton.click();
    }

    public void setClickCartICon() {
        cartIcon.click();
    }
}
