package automation.pages.web;

import automation.utility.WebDriverUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class explorepage extends WebDriverUtility{

    //Locators
    By searchFunction = By.cssSelector("div[class*='bit-explore-button-wrapper']");
    By writeSearchFunction = By.cssSelector("input.custom-input-search");
    By firstSearchResult = By.xpath("(//*[contains(@data-testid,'search-action')])[1]");

    //Clicking Search and writing on search feature
    public void searchInvestmentProduct(){
        wait.until(ExpectedConditions.elementToBeClickable(searchFunction)).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(writeSearchFunction)).sendKeys("Pasar uang");
        pause(2000);
    }

    // Get the first product result
    public void clickOnSearchedProduct(){
        wait.until(ExpectedConditions.elementToBeClickable(firstSearchResult)).click();
        pause(2000);
    }

    //Verify user on product page & redirect back to home
    public void verifyOnProductPage(){
        wait.until(ExpectedConditions.urlContains("reksadana"));
        System.out.println("✅ On product page: " + driver.getCurrentUrl());
        pause(2000);
        driver.get("https://app.bibit.id");
    }
}
