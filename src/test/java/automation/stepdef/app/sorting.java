package automation.stepdef.app;

import automation.pages.app.homePage;
import automation.pages.app.loginPage;
import automation.utility.appsUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class sorting {

    homePage HomePage = new homePage(appsUtility.getDriver());

    @Given("user is in homepage")
    public void userIsInHomepage() {
        HomePage.onHomepage();
    }

    @And("user click on sorting feature")
    public void userClickOnSortingFeature() {
        HomePage.selectSortMenu();
    }

    @When("user sort product by Name - Descending")
    public void userSortProductByNameDescending() {
        HomePage.selectNameDescending();
    }

    @Then("product is sorted by name descending")
    public void productIsSortedByNameDescending() {
        HomePage.verifyNameDescending();
    }

    @When("user sort product by Price - Ascending")
    public void userSortProductByPriceAscending() {
        HomePage.selectSortMenu();
        HomePage.selectPriceAscending();
    }

    @Then("product is sorted by price ascending")
    public void productIsSortedByPriceAscending() {
        HomePage.verifyPriceAscending();
    }

}
