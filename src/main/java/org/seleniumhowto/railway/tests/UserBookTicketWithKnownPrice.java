package org.seleniumhowto.railway.tests;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.seleniumhowto.railway.pages.*;
import org.seleniumhowto.railway.utils.WebDriverManager;

import java.util.Map;

public class UserBookTicketWithKnownPrice {
    private static WebDriver driver;
    private static LoginPage loginPage;
    private static TrainPriceListPage trainPriceListPage;
    private static TicketPricePage ticketPricePage;
    private static BookTicketPage bookTicketPage;
    private static TicketConfirmationPage ticketConfirmationPage;

    @BeforeClass
    public static void setUp() {
        driver = WebDriverManager.getDriver();
        driver.get("http://saferailway.somee.com/Account/Login.cshtml");
        loginPage = new LoginPage(driver);
        trainPriceListPage = new TrainPriceListPage(driver);
        ticketPricePage = new TicketPricePage(driver);
        bookTicketPage = new BookTicketPage(driver);
        ticketConfirmationPage = new TicketConfirmationPage(driver);

        // Login
        // qjiupxvy@sharklasers.com
        // bigtncmu@sharklasers.com
        loginPage.login("qjiupxvy@sharklasers.com", "TestTestTest@123");
    }

    @Test
    public void testBookTicketWithKnownPrice() {

        // inner loop
        for (int i = 1; i <= 3; i++) {
            System.out.println("Running test iteration: " + i);

        // bottom
            // Navigate back to the home page to reset for the next iteration
            driver.get("http://saferailway.somee.com");
        }

            // Navigate to Train Price List page
            trainPriceListPage.navigateTo();
            trainPriceListPage.scrollToBottom();
            trainPriceListPage.clickCheckPrice("5", "6");

            // Get seat price from Ticket Price page
            Map<String, String> seatPriceMap = ticketPricePage.getSeatPriceMap();
            String hsPrice = seatPriceMap.get("HS");
            int hsPriceInt = Integer.parseInt(hsPrice);
            System.out.println("Giá ghế Hard Seat: " + hsPriceInt);

            // Book ticket
            ticketPricePage.clickBookTicket("5", "6", "1");
            bookTicketPage.bookTickets(2);

            // Verify ticket information
            Map<String, String> ticketInfo = ticketConfirmationPage.getTicketInformation();
            String totalPrice = ticketInfo.get("Total Price");
            int totalPriceInt = Integer.parseInt(totalPrice);
            System.out.println("Tổng vé trong bảng inforTable: " + totalPriceInt);

            int expectedPriceTicket = hsPriceInt * 2;
            System.out.println("Tổng vé (expectedPriceTicket): " + expectedPriceTicket);

            // Assertion
            Assert.assertEquals("Tổng giá trị vé không khớp!", totalPriceInt, expectedPriceTicket);



    }

    @AfterClass
    public static void tearDown() {
        WebDriverManager.quitDriver();
    }
}
