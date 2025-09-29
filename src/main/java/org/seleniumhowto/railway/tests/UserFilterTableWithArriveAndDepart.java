package org.seleniumhowto.railway.tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.seleniumhowto.railway.pages.*;
import org.seleniumhowto.railway.utils.WebDriverManager;

import java.util.Map;

public class UserFilterTableWithArriveAndDepart {
    private static WebDriver driver;
    private static LoginPage loginPage;
    private static TrainPriceListPage trainPriceListPage;
    private static TicketPricePage ticketPricePage;
    private static BookTicketPage bookTicketPage;
    private static TicketConfirmationPage ticketConfirmationPage;
    private static MyTicketPage myTicketPage;


    @BeforeClass
    public static void setUp() {
        driver = WebDriverManager.getDriver();
        driver.get("http://saferailway.somee.com/Account/Login.cshtml");
        loginPage = new LoginPage(driver);
        trainPriceListPage = new TrainPriceListPage(driver);
        ticketPricePage = new TicketPricePage(driver);
        bookTicketPage = new BookTicketPage(driver);
        ticketConfirmationPage = new TicketConfirmationPage(driver);
        myTicketPage = new MyTicketPage(driver);

        // Login
        // qjiupxvy@sharklasers.com
        // bigtncmu@sharklasers.com
        loginPage.login("qjiupxvy@sharklasers.com", "TestTestTest@123");
    }

    @Test
    public void testFilterTableWithArriveAndDepart() {
        myTicketPage.navigateTo();
        myTicketPage.applyFilter("Huế", "Sài Gòn", "10/9/2025", "New");
        // scroll
        myTicketPage.scrollToTableAfterFilter();
        myTicketPage.getInforTableAfterFilMap();


    }

    @AfterClass
    public static void tearDown() {
        WebDriverManager.quitDriver();
    }
}
