package com.demoqa.uitests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
        loginPage.enterUsername("james");
        loginPage.enterPassword("Testing123!");
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("login")));
        loginButton.click();
        
		Thread.sleep(4000);
        Assert.assertTrue(profilePage.getProfileName().contains("james"));
    }

    @Test
    public void invalidLoginTest() throws InterruptedException {
        loginPage.enterUsername("invalidUser");
        loginPage.enterPassword("invalidPassword");
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("login")));
        loginButton.click();
        
		Thread.sleep(4000);
        Assert.assertTrue(loginPage.getErrorMessageField().isDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
