package automation.runner.app;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

//Handles runner class for API test
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty","html:reports/cucumber.html", "json:reports/cucumber.json"},
        glue = {"automation.stepdef.app"},
        features = {"src/test/resources/appfeatures"},
        tags = "@app"
)


public class apprunner {
}
