package automation.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//Handles runner class for API test
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","html:reports/cucumber.html", "json:reports/cucumber.json"},
        glue = {"automation.stepdef.api"},
        features = {"src/test/resources/features/api"},
        tags = "@api"
)

public class ApiRunner {
}
