package automation.stepdef.web;

import automation.pages.web.LoginPage;
import automation.pages.web.HomePage;
import automation.utility.WebAlert;
import automation.utility.WebDriverUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LoginStep extends WebDriverUtil {


    // Declare object for HomePage and login to interact with homepage and login class elements
    HomePage homePage;
    LoginPage login;

    @Given("user is on demoblaze homepage")
    public void userIsOnDemoblazeHomepage() {
        homePage = new HomePage(driver);
        homePage.gotoPage();
    }

    @And("user has click login button")
    public void userHasClickLoginButton() {
        homePage.getLogin();
    }

    @And("Login modal is shown to user")
    public void loginModalIsShownToUser() {
        homePage.getLoginModal();
    }

    @When("user enter username {string} and password {string}")
    public void userEnterUsernameAndPassword(String username, String password) {
        login = new LoginPage(driver);
        login.dologin(username,password);
    }

    @And("user click Login")
    public void userClickLogin() {
        login.setLoginButton();
    }

    @Then("user will successfully login and directed to homepage")
    public void userWillSuccessfullyLoginAndDirectedToHomepage() {
        homePage = new HomePage(driver);
        homePage.validateUserLogin();
    }

    @Then("user will see popup message indicating user enter invalid credentials")
    public void userWillSeePopupMessageIndicatingUserEnterInvalidCredentials() {
        WebAlert AlertMessage = new WebAlert(driver);
        AlertMessage.invalidLogin();
    }

    @Then("user will see a popup message indicating user does that exist")
    public void userWillSeeAPopupMessageIndicatingUserDoesThatExist() {
        WebAlert AlertMessage = new WebAlert(driver);
        AlertMessage.nonExistinglogin();
    }
}
