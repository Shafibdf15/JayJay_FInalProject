package automation.pages.api;

import automation.utility.ApiEndpoint;
import automation.utility.ApiAuth;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Random;
import static org.assertj.core.api.Assertions.assertThat;

public class ApiPage {

    //Creating Local Variables
    String setUrl, uid;
    Response response;
    JSONObject newUser, updatedData;

    // Handling url input for testing scenario
    public void urlPrep(String url){
        switch (url){
            case "Base_url":
                setUrl = ApiEndpoint.Base_url;
                break;
            case "Get_user":
                setUrl = ApiEndpoint.Get_user;
                break;
            case "create":
                setUrl = ApiEndpoint.create;
                break;
            case "get_deleted_user":
                setUrl = ApiEndpoint.Get_user + uid;
                break;
            case "Get_tag":
                setUrl = ApiEndpoint.GET_TAG;
                break;
            default:
                System.out.println("Endpoint Not found");
        }
        System.out.println(" Url to be hit: " + setUrl);
    }

    //Calling get request to designated endpoint
    public void userSendGETRequestTo(){
        response = RestAssured.given()
                .spec(ApiAuth.requestSpec())
                .when()
                .get(setUrl);
        System.out.println(" List Of Data : " +response.getBody().asPrettyString());

    }

    //Status Code Validation
    public void userValidateStatusCode(int status_code){
        try {
            assertThat(response.statusCode()).isEqualTo(status_code);
            System.out.println("✅ Status code is as expected: " + response.statusCode());
        } catch (AssertionError e) {
            System.out.println("❌ Status code mismatch! Expected: " + status_code + ", Actual: " + response.statusCode());
            throw e; // rethrow to let the test fail
        }
    }

    //Verifying response data
    public void responseWillContainListOfUserInformation(){
        try {
            //Stored data field from response
            List<Object> id = response.jsonPath().getList("data.id");
            List<Object> title = response.jsonPath().getList("data.title");
            List<Object> firstName = response.jsonPath().getList("data.firstName");
            List<Object> lastName = response.jsonPath().getList("data.lastName");
            List<Object> picture = response.jsonPath().getList("data.picture");

            //Assert response as expected
            assertThat(id.get(0)).isNotNull();
            assertThat(title.get(0)).isNotNull();
            assertThat(firstName.get(0)).isNotNull();
            assertThat(lastName.get(0)).isNotNull();
            assertThat(picture.get(0)).isNotNull();

            System.out.println("✅ Response contains all required user information.");
        } catch (Exception e) {
            System.out.println("❌ Response body validation FAILED.");
            throw e; // rethrow to let the test fail
        }

    }

    //Create request body
    public void userHasCreateRequestBody(){

        int randomNumber = new Random().nextInt(100);

        newUser = new JSONObject();
        newUser.put("title", "mr");
        newUser.put("firstName", "Test");
        newUser.put("lastName", "Demo");
        newUser.put("email", "TestDemo" +randomNumber+ "@dummy.com");
    }

    //Sending POST data
    public void userSendPOSTRequestToEndpoint(){
        response = RestAssured.given()
                .spec(ApiAuth.requestSpec())
                .body(newUser.toString())
                .when()
                .post(setUrl );

        System.out.println(" Response body: " + response.getBody().asPrettyString());

    }

    // Validate response as request
    public void validateResponseCreateUser(){
        JsonPath JsonEvaluator = response.jsonPath();
        String id = JsonEvaluator.get("id");
        String title = JsonEvaluator.get("title");
        String firstName = JsonEvaluator.getString("firstName");
        String lastname = JsonEvaluator.getString("lastName");
        String email =  JsonEvaluator.getString("email");

        assertThat(id).isNotNull();
        assertThat(title).isEqualTo(newUser.get("title"));
        assertThat(firstName).isEqualTo(newUser.get("firstName"));
        assertThat(lastname).isEqualTo(newUser.get("lastName"));
        assertThat(email).isNotNull();

        uid = (id);
        System.out.println("✅ Create User Response validated successfully with uid ; " +uid);
    }

    //Deleting existing user
    public void deleteUser(){
        response = RestAssured.given()
                .spec(ApiAuth.requestSpec())
                .when()
                .delete(setUrl + uid);

        System.out.println("✅ Status code after DELETE is: " + response.statusCode());

    }

    //Delete validation
    public void deleteUserValidation(int status_code){
        response = RestAssured.given()
                .spec(ApiAuth.requestSpec())
                .when()
                .get(setUrl);

        assertThat(response.statusCode()).isEqualTo(status_code);
        System.out.println("✅ Status code is as expected: " + response.statusCode());
    }

    //Store user data to update
    public void updateUserData(){

        List<Object> firstName = response.jsonPath().getList("data.firstName");
        List<Object> lastName = response.jsonPath().getList("data.lastName");

        HashMap<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("firstName", "DemoApi");
        bodyMap.put("lastName", "Test");
        updatedData = new JSONObject(bodyMap);

    }

    public void sendPutRequest(){
        response = RestAssured.given()
                .spec(ApiAuth.requestSpec())
                .body(updatedData.toString())
                .when()
                .put(setUrl + uid);
    }

    //Validate update as requested
    public void validateUpdateUser(){
        JsonPath jsonEvaluator = response.jsonPath();

        String id = jsonEvaluator.getString("id");
        String firstName = jsonEvaluator.getString("firstName");
        String lastName = jsonEvaluator.getString("lastName");

        assertThat(id).isEqualTo(uid);
        assertThat(firstName).isEqualTo(updatedData.get("firstName"));
        assertThat(lastName).isEqualTo(updatedData.get("lastName"));

        System.out.println(" - Updated Data : " +response.getBody().asPrettyString());

    }

    //Validate tag response
    public void validateTagResponse() {
        List<String> tags = response.jsonPath().getList("data");

        int invalidCount = 0;

        for (int i = 0; i < tags.size(); i++) {
            String tag = tags.get(i);
            if (tag == null || tag.trim().isEmpty()) {
                System.out.println("⚠️ Skipping invalid tag at index " + i + ": '" + tag + "'");
                invalidCount++;
            }
        }

        System.out.println("✅ Finished with " + invalidCount + " invalid tags skipped.");
    }
}
