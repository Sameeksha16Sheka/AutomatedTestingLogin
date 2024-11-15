package automatetest;

//import static org.junit.jupiter.api.Assertions.*;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
// 
// 
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
 
public class LoginTest {
    public static void main(String[] args) {
        // Set up WebDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
 
        try {
            // Navigate to the login page
            driver.get("https://practicetestautomation.com/practice-test-login/");
            driver.manage().window().maximize();
 
            // Locate username and password fields
            WebElement usernameField = driver.findElement(By.id("username"));
            WebElement passwordField = driver.findElement(By.id("password"));
            WebElement loginButton = driver.findElement(By.id("submit"));
 
            // Test valid login
            usernameField.sendKeys("student");
            passwordField.sendKeys("Password123");
            loginButton.click();
 
            // Verify success
            String expectedUrl = "https://practicetestautomation.com/logged-in-successfully/";
            if (driver.getCurrentUrl().equals(expectedUrl)) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Login failed.");
            }
           
            Thread.sleep(5000);
            // Verify expected text on the new page
           /* WebElement messageElement = driver.findElement(By.tagName("h1")); // Adjust locator if needed
            String pageText = messageElement.getText();
            if (pageText.contains("Congratulations") || pageText.contains("Logged In Successfully")) {
                System.out.println("Text verification passed!");
            } else {
                System.out.println("Text verification failed. Found text: " + pageText);
            }
            
            Thread.sleep(5000);
            
 
            //  Verify Log out button is displayed
            WebElement logoutButton = driver.findElement(By.xpath("//a[text()='Log out']"));
            if (logoutButton.isDisplayed()) {
                System.out.println("Log out button is displayed. Verification passed!");
            } else {
                System.out.println("Log out button is not displayed. Verification failed!");
            }*/
            
         // Verify error message
            WebElement errorMessageElement = driver.findElement(By.id("error"));
            String errorMessage = errorMessageElement.getText();
            if (errorMessage.contains("Your username is invalid!")) {
                System.out.println("Test passed: Error message is correct.");
            } else {
                System.out.println("Test failed: Unexpected error message. Found: " + errorMessage);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Quit the driver
            driver.quit();
        }
    }
}





//
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import java.time.Duration;
//
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//public class LoginTest {
//
//    public static void main(String[] args) {
//
//        // Automatically download and set up ChromeDriver
//        WebDriverManager.chromedriver().setup();
//
//        // Initialize the WebDriver with Chrome options
//        ChromeOptions options = new ChromeOptions();
//        WebDriver driver = new ChromeDriver(options);
//
//        try {
//            // Step 1: Open the login page
//            driver.get("https://practicetestautomation.com/practice-test-login/");
//
//            // Step 2: Locate the login elements (username, password, login button)
//            WebElement usernameField = driver.findElement(By.id("username"));
//            WebElement passwordField = driver.findElement(By.id("password"));
//            WebElement loginButton = driver.findElement(By.id("submit"));
//
//            // Step 3: Enter valid credentials
//            usernameField.sendKeys("test"); // Replace with valid username
//            passwordField.sendKeys("test"); // Replace with valid password
//
//            // Step 4: Click the login button
//            loginButton.click();
//
//            // Step 5: Wait for the login to complete (check for the 'logged in' element)
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            WebElement logoutButton = wait.until(
//                ExpectedConditions.visibilityOfElementLocated(By.linkText("Log out")));
//
//            // Step 6: Validate successful login by checking the presence of the "Log out" button
//            assertTrue(logoutButton.isDisplayed(), "Login failed, 'Log out' button not found!");
//
//            System.out.println("Login test passed!");
//
//        } catch (Exception e) {
//            System.out.println("Login test failed: " + e.getMessage());
//        } finally {
//            // Step 7: Close the browser
//            driver.quit();
//        }
//    }
//}
