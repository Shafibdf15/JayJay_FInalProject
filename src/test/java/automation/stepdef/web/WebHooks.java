package automation.stepdef.web;

import automation.utility.WebDriverUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public class WebHooks extends WebDriverUtil {
    @Before("@web")
    public void beforeTest() {
        getDriver();
        driver.manage().deleteAllCookies();

    }

    @After("@web")
    public void afterTest() {

        driver.close();
    }
}
