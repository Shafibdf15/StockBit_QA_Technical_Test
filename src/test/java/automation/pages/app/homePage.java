package automation.pages.app;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.assertj.core.api.Assertions.assertThat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class homePage {

    private AndroidDriver driver;
    private WebDriverWait wait;

    //Locators
    By homePage = AppiumBy.id("com.saucelabs.mydemoapp.android:id/container");
    By burgerIcon = AppiumBy.accessibilityId("View menu");
    By loginMenu = AppiumBy.accessibilityId("Login Menu Item");
    By logoutMenu = AppiumBy.accessibilityId("Logout Menu Item");
    By sortingMenu = AppiumBy.accessibilityId("Shows current sorting order and displays available sorting options");
    By nameDescending = AppiumBy.accessibilityId("Descending order by name");
    By priceAscending = AppiumBy.accessibilityId("Ascending order by price");
    By productTitle = By.id("com.saucelabs.mydemoapp.android:id/titleTV");
    By productPrice = By.id("com.saucelabs.mydemoapp.android:id/priceTV");
    By productBackpack = By.xpath("//androidx.recyclerview.widget.RecyclerView[@content-desc=\"Displays all products of catalog\"]/android.view.ViewGroup[1]/android.widget.ImageView[@content-desc=\"Product Image\"]");

    public homePage(AndroidDriver driver) {
        this.driver = driver;
        this.wait   = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    //Validating on Homepage
    public void onHomepage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(homePage));
    }

    // Navigating to side bar
    public void clickOnBurgerIcon(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(burgerIcon)).click();
    }

    // Navigating to login page
    public void navigateToLogin(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginMenu)).click();
    }

    // Validate user login
    public void validateLoginState(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutMenu)).isDisplayed();
    }

    // Navigating to sorting feature
    public void selectSortMenu() {
        wait.until(ExpectedConditions.elementToBeClickable(sortingMenu)).click();
    }

    // Choose filter based on Name Descending
    public void selectNameDescending() {
        wait.until(ExpectedConditions.elementToBeClickable(nameDescending)).click();
        System.out.println("📋 Selected: Name Descending");
    }

    // Choose sorting based on Price Ascending
    public void selectPriceAscending() {
        wait.until(ExpectedConditions.elementToBeClickable(priceAscending)).click();
        System.out.println("📋 Selected: Price Ascending");
    }

    //validate sorting process
    public void verifyNameDescending() {
        // Wait for list to reload after sort
        wait.until(ExpectedConditions.visibilityOfElementLocated(productTitle));

        List<WebElement> elements = driver.findElements(productTitle);

        List<String> actualNames = new ArrayList<>();
        for (WebElement e : elements) {
            actualNames.add(e.getText());
        }

        List<String> expectedNames = new ArrayList<>(actualNames);
        Collections.sort(expectedNames, Collections.reverseOrder()); // Z→A

        assertThat(actualNames)
                .as("Products are not sorted by name descending")
                .isEqualTo(expectedNames);

        System.out.println("✅ Name descending verified: " + actualNames);
    }

    // Verify page has been sort by price ascending
    public void verifyPriceAscending() {
        // Wait for list to reload after sort
        wait.until(ExpectedConditions.visibilityOfElementLocated(productPrice));

        List<WebElement> elements = driver.findElements(productPrice);

        List<Double> actualPrices = new ArrayList<>();
        for (WebElement e : elements) {
            String text = e.getText().replace("$", "").trim();
            actualPrices.add(Double.parseDouble(text));
        }

        List<Double> expectedPrices = new ArrayList<>(actualPrices);
        Collections.sort(expectedPrices); // low→high

        assertThat(actualPrices)
                .as("Products are not sorted by price ascending")
                .isEqualTo(expectedPrices);

        System.out.println("✅ Price ascending verified: " + actualPrices);
    }

    // Navigating to product page
    public void openProduct(){
       wait.until(ExpectedConditions.elementToBeClickable(productBackpack)).click();
    }

}
