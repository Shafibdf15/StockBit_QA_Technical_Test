package automation.pages.app;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class checkoutPage {

    private AndroidDriver driver;
    private WebDriverWait wait;

    //Locators
    By onCheckoutPage = AppiumBy.id("com.saucelabs.mydemoapp.android:id/checkoutTitleTV");
    By fullnameField = AppiumBy.id("com.saucelabs.mydemoapp.android:id/fullNameET");
    By Addressline1 = AppiumBy.id("com.saucelabs.mydemoapp.android:id/address1ET");
    By addressline2 = AppiumBy.id("com.saucelabs.mydemoapp.android:id/address2ET");
    By cityfield = AppiumBy.id("com.saucelabs.mydemoapp.android:id/cityET");
    By regionField = AppiumBy.id("com.saucelabs.mydemoapp.android:id/stateET");
    By zipCodeField = AppiumBy.id("com.saucelabs.mydemoapp.android:id/zipET");
    By countryField = AppiumBy.id("com.saucelabs.mydemoapp.android:id/countryET");
    By toPaymentBtn = AppiumBy.id("com.saucelabs.mydemoapp.android:id/paymentBtn");
    By reviewOrder = AppiumBy.id("com.saucelabs.mydemoapp.android:id/infoCL");
    By reviewAddress = AppiumBy.id("com.saucelabs.mydemoapp.android:id/addressLL");
    By placeOrderbtn = AppiumBy.accessibilityId("Completes the process of checkout");
    By successfullPurchase = AppiumBy.id("com.saucelabs.mydemoapp.android:id/completeTV");
    By continueShopping = AppiumBy.id("com.saucelabs.mydemoapp.android:id/shoopingBt");


    public checkoutPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait   = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Validating user is on Checkout page
    public void userOnCheckoutAddressPage(){
        wait.until(ExpectedConditions.presenceOfElementLocated(onCheckoutPage)).isDisplayed();
    }

    // User filling required Address information
    public void usefillRequiredAddressField(){
        wait.until(ExpectedConditions.elementToBeClickable(fullnameField)).sendKeys("Rebecca Winter");
        wait.until(ExpectedConditions.elementToBeClickable(Addressline1)).sendKeys("Mandorley 112");
        wait.until(ExpectedConditions.elementToBeClickable(addressline2)).sendKeys("Entrance 1");
        wait.until(ExpectedConditions.elementToBeClickable(cityfield)).sendKeys("Trurro");
        wait.until(ExpectedConditions.elementToBeClickable(regionField)).sendKeys("Jakarta");
        wait.until(ExpectedConditions.elementToBeClickable(zipCodeField)).sendKeys("89760");
        wait.until(ExpectedConditions.elementToBeClickable(countryField)).sendKeys("Indonesia");
    }

    //Navigating to payment page
    public void userNavigateToPaymentPage(){
        wait.until(ExpectedConditions.elementToBeClickable(toPaymentBtn)).click();
    }

    // Verifying user purchase and placing order
    public void reviewOrderfinalization(){
        wait.until(ExpectedConditions.presenceOfElementLocated(reviewOrder)).isDisplayed();
        wait.until(ExpectedConditions.presenceOfElementLocated(reviewAddress)).isDisplayed();
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderbtn)).click();
    }

    public void orderComplete(){
        wait.until(ExpectedConditions.presenceOfElementLocated(successfullPurchase)).isDisplayed();
        wait.until(ExpectedConditions.elementToBeClickable(continueShopping)).click();
    }
}
