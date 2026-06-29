package automation.pages.app;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class cartPage {

    private AndroidDriver driver;
    private WebDriverWait wait;

    //Locators
    By inCartpage = AppiumBy.accessibilityId("Displays list of selected products");
    By totalPrice = AppiumBy.id("com.saucelabs.mydemoapp.android:id/totalPriceTV");
    By proceedtoCObtn = AppiumBy.accessibilityId("Confirms products for checkout");

    public cartPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait   = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Validating user is on Cart page
    public void validatingInCartPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(inCartpage)).isDisplayed();
        wait.until(ExpectedConditions.visibilityOfElementLocated(totalPrice)).isDisplayed();
    }

    // Navigating to Checkout page
    public void proceedtoCheckout(){
        wait.until(ExpectedConditions.elementToBeClickable(proceedtoCObtn)).click();
    }

}
