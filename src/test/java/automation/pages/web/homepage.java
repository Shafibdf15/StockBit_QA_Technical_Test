package automation.pages.web;

import automation.utility.WebDriverUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class homepage extends WebDriverUtility {

    //Locators
    By profileFeature = By.xpath("//*[@id=\"bit-tabbar\"]/div/div[5]/div");
    By profilePage = By.xpath("//*[@id=\"bit-tabbar\"]/div/div[5]/div");
    By exploreFeature = By.xpath("//*[@id=\"bit-tabbar\"]/div/div[3]");



    public void verifyLoggedIn() {
        // Verifying in login state
        wait.until(ExpectedConditions.urlContains("app.bibit.id"));
        wait.until(ExpectedConditions.not(
                ExpectedConditions.urlContains("login")
        ));
        System.out.println("✅ Session verified — user is logged in");
    }

    // Go To Explore Page
    public void goToExplore(){
        wait.until(ExpectedConditions.elementToBeClickable(exploreFeature)).click();
        pause(2000);
    }

    // Validating Explore Page
    public void validateExplorePage(){
        wait.until(ExpectedConditions.urlContains("https://app.bibit.id/explore"));
        pause(2000);
    }

}
