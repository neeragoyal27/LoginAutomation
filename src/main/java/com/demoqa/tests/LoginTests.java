package com.demoqa.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demoqa.pages.LoginPage;
import com.demoqa.pages.ProfilePage;

public class LoginTests {
    private WebDriver driver;
    private LoginPage loginPage;
    private ProfilePage profilePage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/login");
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
    }

    @Test
    public void validLoginTest() throws InterruptedException {
        loginPage.enterUsername("Neera");
        loginPage.enterPassword("Mydreams123$");
        
		Thread.sleep(2000);
        loginPage.clickLoginButton();
        
		Thread.sleep(2000);
        Assert.assertTrue(profilePage.getProfileName().contains("Neera"));
    }

    @Test
    public void invalidLoginTest() throws InterruptedException {
        loginPage.enterUsername("invalidUser");
        loginPage.enterPassword("invalidPassword");
        
		Thread.sleep(2000);
        loginPage.clickLoginButton();
        
		Thread.sleep(2000);
        Assert.assertTrue(loginPage.getErrorMessageField().isDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
