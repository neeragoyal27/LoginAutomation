package com.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {
    private WebDriver driver;

    // Locators
    private By profileName = By.id("userName-value");
    private By logoutButton = By.id("logout");

    // Constructor
    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public String getProfileName() {
        return driver.findElement(profileName).getText();
    }

    public void clickLogoutButton() {
        driver.findElement(logoutButton).click();
    }
}
