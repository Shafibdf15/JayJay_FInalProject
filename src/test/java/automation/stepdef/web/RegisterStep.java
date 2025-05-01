package automation.stepdef.web;

import automation.pages.web.RegisterPage;
import automation.pages.web.HomePage;
import automation.utility.WebAlert;
import automation.utility.WebDriverUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterStep extends WebDriverUtil {

    // Declare object for HomePage and regis to interact with homepage and regis class elements
    HomePage homePage;
    RegisterPage registration;

    @Given("User is on demoblaze homepage")
    public void userIsOnDemoblazeHomepage() {

        homePage = new HomePage(driver);
        homePage.gotoPage();
    }

    @And("user has click on SignUp button")
    public void userHasClickOnSignUpButton() {
        homePage.getSignUP();
    }

    @And("Register modal is shown")
    public void registerModalIsShown() {
        homePage.regisModal();
    }

    @When("user fill username and password field")
    public void userFillUsernameAndPasswordField() {
        registration= new RegisterPage(driver);
        registration.fillRandomUsernameAndPassword();
    }

    @And("user submit registration form")
    public void userSubmitRegistrationForm() {
        registration.submitRegis();
    }

    @Then("user can see successfull registration message")
    public void userCanSeeSuccessfullRegistrationMessage() {

        WebAlert AlertMessage = new WebAlert(driver);
        AlertMessage.successRegistration();
    }

    @When("user fill username and password field with existing account")
    public void userFillUsernameAndPasswordFieldWithExistingAccount() {

        registration = new RegisterPage(driver);
        registration.enterExistingUsername();
    }

    @Then("user will see a popup message")
    public void userWillSeeAPopupMessage() {

        WebAlert AlertMessage = new WebAlert(driver);
        AlertMessage.existingAccountAlert();
    }


}
