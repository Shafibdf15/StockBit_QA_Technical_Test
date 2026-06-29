package automation.pages.app;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class productPage {

    private AndroidDriver driver;
    private WebDriverWait wait;

    //Locators
    By productPage = AppiumBy.accessibilityId("Displays selected product");
    By productColor = AppiumBy.accessibilityId("Blue color");
    By increaseQuantity = AppiumBy.accessibilityId("Increase item quantity");
    By itemQuantity = AppiumBy.accessibilityId("com.saucelabs.mydemoapp.android:id/noTV");
    By addcartBtn = AppiumBy.accessibilityId("Tap to add product to cart");
    By cartBtn = AppiumBy.id("com.saucelabs.mydemoapp.android:id/cartIV");

    public productPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait   = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    //Validating in product page
    public void enterProductPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(productPage));
    }

    //Changing product color option
    public void changeProductColor(){
        wait.until(ExpectedConditions.elementToBeClickable(productColor)).click();
    }

    //Changing product quantity
    public void changeProductQuantity(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(increaseQuantity)).click();
    }

    // Adding item to car
    public void addToCart(){
        driver.findElement(addcartBtn).click();
    }

    //Navigating to cart page by clicking cart buttom
    public void navigatetoCart(){
        driver.findElement(cartBtn).click();
    }

}
