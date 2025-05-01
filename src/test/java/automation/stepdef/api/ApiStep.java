package automation.stepdef.api;

import automation.pages.api.ApiPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ApiStep {

    ApiPage apiPage;

    public ApiStep(){
        this.apiPage = new ApiPage();
    }

    @Given("User has prepare url for {string}")
    public void userHasPrepareUrlFor(String url) {
        apiPage.urlPrep(url);
    }

    @When("user send GET request to endpoint")
    public void userSendGETRequestToEndpoint() {
        apiPage.userSendGETRequestTo();
    }

    @Then("validation status code is equals to {int}")
    public void validationStatusCodeIsEqualsTo(int status_code) {
        apiPage.userValidateStatusCode(status_code);
    }

    @And("response will contain list of user information")
    public void responseWillContainListOfUserInformation() {
        apiPage.responseWillContainListOfUserInformation();
    }

    @And("user has create request body")
    public void userHasCreateRequestBody() {
        apiPage.userHasCreateRequestBody();

    }

    @When("user send POST request to endpoint")
    public void userSendPOSTRequestToEndpoint() {
        apiPage.userSendPOSTRequestToEndpoint();
    }

    @And("validate response body the same as requested")
    public void validateResponseBodyTheSameAsRequested() {
        apiPage.validateResponseCreateUser();
    }

    @And("user send POST request to create new user")
    public void userSendPOSTRequestToCreateNewUser() {
        apiPage.userSendPOSTRequestToEndpoint();
    }

    @Given("User has posted a new data to endpoint {string}")
    public void userHasPostedANewDataToEndpoint(String url) {
        apiPage.urlPrep(url);
        apiPage.userHasCreateRequestBody();
        apiPage.userSendPOSTRequestToEndpoint();
        apiPage.validateResponseCreateUser();
    }

    @And("user has prepare url {string}")
    public void userHasPrepareUrl(String url) {
        apiPage.urlPrep(url);
    }

    @When("user send DELETE request")
    public void userSendDELETERequest() {
        apiPage.deleteUser();
    }


    @And("validate request GET to endpoint {string}, returns response {int}")
    public void validateRequestGETToEndpointReturnsResponse(String url, int status_code) {
        apiPage.urlPrep(url);
        apiPage.deleteUserValidation(status_code);
    }

    @When("User send Request PUT to update data")
    public void userSendRequestPUTToUpdateData() {
        apiPage.updateUserData();
        apiPage.sendPutRequest();
    }

    @And("validate response body follow updated data")
    public void validateResponseBodyFollowUpdatedData() {
        apiPage.validateUpdateUser();
    }

    @And("response will not send empty data")
    public void responseWillNotSendEmptyData() {

        apiPage.validateTagResponse();
    }
}
