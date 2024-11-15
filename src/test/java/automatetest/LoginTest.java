package automatetest;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

class LoginTest {

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        // Set up WebDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterEach
    void tearDown() {
        // Quit the driver after each test
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void testValidLogin() {
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

        // Verify if login was successful
        String expectedUrl = "https://practicetestautomation.com/logged-in-successfully/";
        if (driver.getCurrentUrl().equals(expectedUrl)) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed.");
        }
       // Thread.sleep(5000);
        
        // Verify expected text on the new page
        WebElement messageElement = driver.findElement(By.tagName("h1"));
        String pageText = messageElement.getText();
        if (pageText.contains("Congratulations") || pageText.contains("Logged In Successfully")) {
            System.out.println("Text verification passed!");
        } else {
            System.out.println("Text verification failed. Found text: " + pageText);
        }

        // Verify Log out button is displayed
        WebElement logoutButton = driver.findElement(By.xpath("//a[text()='Log out']"));
        if (logoutButton.isDisplayed()) {
            System.out.println("Log out button is displayed. Verification passed!");
        } else {
            System.out.println("Log out button is not displayed. Verification failed!");
        }
    }

    @Test
    void testInvalidLogin() {
        // Navigate to the login page
       driver.get("https://practicetestautomation.com/practice-test-login/");
        driver.manage().window().maximize();

        // Locate username and password fields
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("submit"));

        // Test invalid login
        usernameField.sendKeys("invalidUser");
        passwordField.sendKeys("InvalidPassword");
        loginButton.click();

        // Verify error message
        WebElement errorMessageElement = driver.findElement(By.id("error"));
        String errorMessage = errorMessageElement.getText();
        if (errorMessage.contains("Your username is invalid!")) {
            System.out.println("Test passed: Error message is correct.");
        } else {
            System.out.println("Test failed: Unexpected error message. Found: " + errorMessage);
        }
        
    }
}
