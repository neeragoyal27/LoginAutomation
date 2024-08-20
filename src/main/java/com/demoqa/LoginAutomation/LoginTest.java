package com.demoqa.LoginAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

    public static void main(String[] args) {
        // Setup WebDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the login page
            driver.get("https://demoqa.com/login");

            // Find and fill in the username
            WebElement usernameField = driver.findElement(By.id("userName"));
            usernameField.sendKeys("Neera");

            // Find and fill in the password
            WebElement passwordField = driver.findElement(By.id("password"));
            passwordField.sendKeys("Mydreams123$");

            // Find and click the login button
            WebElement loginButton = driver.findElement(By.id("login"));
            loginButton.click();

            // Wait and check for successful login by checking for the logout button
            Thread.sleep(2000);
            WebElement logoutButton = driver.findElement(By.id("submit"));
            if (logoutButton.isDisplayed()) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Login failed!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
