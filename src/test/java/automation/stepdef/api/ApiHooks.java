package automation.stepdef.api;

import io.cucumber.java.After;
import io.cucumber.java.Before;

// Handling configuration before and after Test for API
public class ApiHooks {
    @Before("@api")
    public void beforeTest() {
        System.out.println("🔵 Setting up API Test Environment");
        // maybe setup common header, token, etc if needed

    }

    @After("@api")
    public void afterTest() {
        System.out.println("🔵 Cleaning up after API Test");
    }
}
