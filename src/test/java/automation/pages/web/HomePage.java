package automation.pages.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {

    //Calling webdriver instance
    WebDriver driver;
    private WebDriverWait wait;

    //Web elements Locators
    By signupbutton = By.id("signin2");
    By signupModal = By.id("signInModal");
    By loginButton = By.id("login2");
    By loginModal =  By.id("logInModal");
    By userValidLogin = By.id("nameofuser");
    By product1 = By.cssSelector("div.card.h-100 a\n");


    // Constructor initializes driver and wait
    public HomePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofMillis(5000));
    }

    public void gotoPage(){
        driver.get("https://www.demoblaze.com"); // Method to navigate to the demoblaze homepage
    }
    public void getSignUP(){
        driver.findElement(signupbutton).click(); // Click the "Sign up" button

    }

    public void regisModal(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(signupModal));// Wait for the registration modal to be visible
    }

    public void getLogin(){
        driver.findElement(loginButton).click(); // Click the "Login" button
    }

    public void getLoginModal(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginModal));// Wait for the login modal to be visible
    }

    // Wait for the user's name label to appear (as login success indicator)
    public boolean validateUserLogin(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(userValidLogin));
        WebElement LoginValidation = driver.findElement(userValidLogin);
        return LoginValidation.isDisplayed();
    }

    public void getProduct(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(product1));
        driver.findElement(product1).click();

    }
}
