package com.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BookStorePage {
    private WebDriver driver;

    // Locators
    private By searchBox = By.id("searchBox");

    // Constructor
    public BookStorePage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void searchForBook(String bookName) {
        driver.findElement(searchBox).sendKeys(bookName);
    }

    public WebElement getFirstBookTitle(String bookName) {
        return driver.findElement(By.id("see-book-" + bookName));
    }
}
