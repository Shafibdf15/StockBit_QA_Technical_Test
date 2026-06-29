package automation.stepdef.app;

import automation.utility.appsUtility;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class appHooks {
    @Before("@app")
    public void setUp() {
        appsUtility.getDriver();  // starts driver + installs APK
        System.out.println("✅ Appium session started");
    }

    @After("@app")
    public void tearDown() {
        appsUtility.quitDriver(); // closes app + ends session
        System.out.println("✅ Appium session closed");
    }
}
