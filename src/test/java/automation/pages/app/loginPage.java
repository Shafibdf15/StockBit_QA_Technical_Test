package automation.pages.app;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class loginPage {

    private AndroidDriver driver;
    private WebDriverWait wait;

    //Locators
    By usernameField = AppiumBy.id("com.saucelabs.mydemoapp.android:id/nameET");
    By passwordField = AppiumBy.id("com.saucelabs.mydemoapp.android:id/passwordET");
    By loginBtn = AppiumBy.id("com.saucelabs.mydemoapp.android:id/loginBtn");


    public loginPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait   = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Filling user data
    public void fillUserdata(){
        wait.until(ExpectedConditions.elementToBeClickable(usernameField)).sendKeys("bod@example.com");
        wait.until(ExpectedConditions.elementToBeClickable(passwordField)).sendKeys("10203040");
    }

    // Finalize login process
    public void finalizeLogin(){
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
    }
}
