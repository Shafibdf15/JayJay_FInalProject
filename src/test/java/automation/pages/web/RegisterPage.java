package automation.pages.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Random;

public class RegisterPage {

    private String newUser;
    private String newUserPass;

    // Webdriver instance
    WebDriver driver;
    private WebDriverWait wait;
    //Locators
    By userInputUsername = By.id("sign-username");
    By userInputPassword = By.id("sign-password");
    By registerSubmitButton = By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]");

    //Constructor
    public RegisterPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofMillis(5000));
    }

    public void fillRandomUsernameAndPassword() {
        int randomNumber = new Random().nextInt(15); // random 0-15
        newUser = "TestAccount" + randomNumber;
        newUserPass = "DemoTest" + randomNumber;

        driver.findElement(userInputUsername).sendKeys(newUser);
        driver.findElement(userInputPassword).sendKeys(newUserPass);
    }

    // Clicking registration submission button
    public void submitRegis(){
        driver.findElement(registerSubmitButton).click();
        this.wait.until(ExpectedConditions.alertIsPresent());
    }

    // Entering pre existing account info to register
    public void enterExistingUsername(){
        driver.findElement(userInputUsername).sendKeys("DemoAccount15");
        driver.findElement((userInputPassword)).sendKeys("DemoAccount15");
    }
}
