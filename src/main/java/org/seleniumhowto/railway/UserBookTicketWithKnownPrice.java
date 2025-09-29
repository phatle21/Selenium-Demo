package org.seleniumhowto.railway;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class UserBookTicketWithKnownPrice {
    static ChromeDriver driver = new ChromeDriver();
    static WebDriverWait wait;
    static WebElement element;
    static Select selectByValue;

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\phat.le\\Downloads\\chromedriver-win64\\chromedriver.exe");
     //   driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        // build 1 pom login - dung pojo
        driver.get("http://saferailway.somee.com/Account/Login.cshtml");
        String email = "bigtncmu@sharklasers.com";
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(email);
        String password = "TestTestTest@123";
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[.='Welcome to Safe Railway']")));
    }

    @Test
    public void action_1() throws InterruptedException {
        driver.findElement(By.xpath("//a[@href='/Page/TrainPriceListPage.cshtml']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[.='Train ticket price list']")));

        // scroll xuống bottom
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        // Click Check Price: Huế to Quảng Ngãi
        String id1 = "5";
        String id2 = "6";
        String clickCheckPrice =  String.format("//a[contains(@href, 'TicketPricePage.cshtml?id1=%s&id2=%s')]", id1, id2);
        System.out.println("XPath clickCheckPrice: " + clickCheckPrice);
        driver.findElement(By.xpath(clickCheckPrice)).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//h1[.='Ticket Price']"), "Ticket Price"));

        System.out.println("--------Xong page ticket price--------");

        // Xuất hiện page Ticket Price
        // row: Seat type
        List<WebElement> seatTypes = driver.findElements(By.xpath("//table[@class='MyTable MedTable']//tr[2]/td"));
        // row: Price (VND)
        List<WebElement> pricesRow = driver.findElements(By.xpath("//table[@class='MyTable MedTable']//tr[3]/td"));
        // store value key-value
        Map<String, String> seatPriceMap = new HashMap<>();
        for(int i = 0; i < seatTypes.size(); i++) {
            seatPriceMap.put(seatTypes.get(i).getText(), pricesRow.get(i).getText());
        }
        System.out.println("Giá trị seatPriceMap: " + seatPriceMap);
        String hsPrice = seatPriceMap.get("HS");
        int hsPriceInt = Integer.parseInt(hsPrice);
        System.out.println("Giá ghế Hard Seat: " + hsPriceInt);
       // String tr = "1";
       // String clickBookTicket =  String.format("//a[contains(@href, 'BookTicketPage.cshtml?id1=5&id2=6&id3=%s')]", tr);
      //  System.out.println("check clickBookTicket: " + clickBookTicket);
        String td = "3";
      //  String  = String.format("//table[@class='NoBorder']//tr/td[%s]", td);
        String id3 = "1";



        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        element = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//table[@class='NoBorder']//tr/td/a[contains(@href,'BookTicketPage.cshtml?id1=5&id2=6&id3=1')]")
        ));
        // scroll tới element
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();

     //   String clickBookTicket =  String.format("//table[@class='NoBorder']//tr/td/a[contains(@href, 'BookTicketPage.cshtml?id1=5&id2=6&id3=%s')]", id3);
     //   System.out.println("XPath của clickBookTicket: " + clickBookTicket);
     //   driver.findElement(By.xpath(clickBookTicket)).click();

        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//h1[.='Book ticket']"), "Book ticket"));
        selectByValue = new Select(driver.findElement(By.xpath("//select[@name='TicketAmount']")));
        int amountTicket = 2;
        selectByValue.selectByValue(String.valueOf(amountTicket));
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//div[@id='content']/h1[.='Ticket booked successfully!']"), "Ticket booked successfully!"));


        // xuat hien page Ticket booked successfully!
        // check assertion -
        // scroll tiếp

        element = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//table[@class='MyTable WideTable']")
        ));
        // scroll tới element
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

        // row:
        List<WebElement> rowName = driver.findElements(By.xpath("//tr[@class='TableSmallHeader']/th"));
        // row: Price (VND)
        List<WebElement> rowValue = driver.findElements(By.xpath("//tr[@class='OddRow']/td"));
        // store value key-value
        Map<String, String> inforTable = new HashMap<>();
        for(int i = 0; i < rowName.size(); i++) {
            inforTable.put(rowName.get(i).getText(), rowValue.get(i).getText());
        }
        System.out.println("Giá trị inforTable: " + inforTable);

        String totalPrice = inforTable.get("Total Price");
        int totalPriceInt = Integer.parseInt(totalPrice);
        System.out.println("Tổng vé trong bảng inforTable: " + totalPriceInt);

        int expectedPriceTicket = hsPriceInt * amountTicket;
        System.out.println("Tổng vé (expectedPriceTicket): " + expectedPriceTicket);

        // Assertion
        Assert.assertEquals("Tổng giá trị vé không khớp!", totalPriceInt, expectedPriceTicket);

        // Verify Point: Ticket Information displays total price correctly

    }
    @AfterClass
    public static void tearDown(){
        if (driver != null) {
            driver.quit();
        }
    }
}
