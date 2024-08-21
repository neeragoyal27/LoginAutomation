package com.demoqa.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoqa.pages.BookStorePage;

public class BookStoreTests {
    private WebDriver driver;
    private BookStorePage bookStorePage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/books");
        bookStorePage = new BookStorePage(driver);
    }

    @Test
    public void searchBookTest() throws InterruptedException {
        bookStorePage.searchForBook("Programming JavaScript Applications");
        
        Thread.sleep(2000);
        Assert.assertTrue(bookStorePage.getFirstBookTitle("Programming JavaScript Applications").isDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
