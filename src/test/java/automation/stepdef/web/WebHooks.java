package automation.stepdef.web;

import automation.utility.WebDriverUtility;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class WebHooks extends WebDriverUtility {

    @Before("@web")
    public void beforeTest() {
        getDriver();
    }

    @After("@web")
    public void afterTest() {
        // Keep the session alive
        System.out.println("✅ Test complete - Chrome session kept alive");
    }
}