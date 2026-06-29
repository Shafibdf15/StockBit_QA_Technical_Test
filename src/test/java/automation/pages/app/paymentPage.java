package automation.pages.app;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class paymentPage {

    private AndroidDriver driver;
    private WebDriverWait wait;

    //Locators
    By onPaymentpage = AppiumBy.id("com.saucelabs.mydemoapp.android:id/enterPaymentMethodTV");
    By fullName = AppiumBy.id("com.saucelabs.mydemoapp.android:id/nameET");
    By cardNumber = AppiumBy.id("com.saucelabs.mydemoapp.android:id/cardNumberET");
    By expirateDate = AppiumBy.id("com.saucelabs.mydemoapp.android:id/expirationDateET");
    By securityCode = AppiumBy.id("com.saucelabs.mydemoapp.android:id/securityCodeET");
    By paymentBtn = AppiumBy.id("com.saucelabs.mydemoapp.android:id/paymentBtn");


    public paymentPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait   = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Validating user is on payment page
    public void userOnPaymentPage(){
        wait.until(ExpectedConditions.presenceOfElementLocated(onPaymentpage)).isDisplayed();
    }

    // User fill the required payment data
    public void userFillPaymentData(){
        wait.until(ExpectedConditions.elementToBeClickable(fullName)).sendKeys("Rebecca Winter");
        wait.until(ExpectedConditions.elementToBeClickable(cardNumber)).sendKeys("3258125675687891");
        wait.until(ExpectedConditions.elementToBeClickable(expirateDate)).sendKeys("0325");
        wait.until(ExpectedConditions.elementToBeClickable(securityCode)).sendKeys("123");
    }

    //User navigating to final review page
    public void userNavigatetoReviewPage(){
        wait.until(ExpectedConditions.elementToBeClickable(paymentBtn)).click();
    }
}
