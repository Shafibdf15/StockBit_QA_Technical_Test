package automation.utility;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class appsUtility {
    private static AndroidDriver driver;

    public static AndroidDriver getDriver() {
        if (driver == null) {
            try {
                UiAutomator2Options options = new UiAutomator2Options();
                options.setPlatformName("Android");
                options.setAutomationName("UiAutomator2");
                options.setAppPackage("com.saucelabs.mydemoapp.android");
                options.setAppActivity(".view.activities.SplashActivity");

                // APK path — Appium installs it automatically
                options.setApp(System.getProperty("user.dir")
                        + "\\src\\test\\resources\\app\\mda-2.2.0-25.apk");

                options.setNewCommandTimeout(Duration.ofSeconds(60));

                driver = new AndroidDriver(
                        new URL("http://127.0.0.1:4723"), options
                );

                System.out.println("✅ Appium driver started successfully");

            } catch (MalformedURLException e) {
                throw new RuntimeException("Appium server URL invalid: " + e.getMessage());
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
            System.out.println("✅ Appium driver closed");
        }
    }

}
