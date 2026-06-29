package automation.stepdef.web;

import automation.utility.WebDriverUtility;
import automation.pages.web.homepage;
import automation.pages.web.explorepage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class searchproduct extends WebDriverUtility{

    homepage Homepage = new homepage();
    explorepage ExplorePage = new explorepage();

    @Given("user has login with valid account")
    public void userHasLoginWithValidAccount() {
        Homepage.verifyLoggedIn();
    }

    @And("user click on explore button")
    public void userClickOnExploreButton() {
        Homepage.goToExplore();
    }

    @And("explore pages is shown to user")
    public void explorePagesIsShownToUser() {
        Homepage.validateExplorePage();
    }

    @When("user search for product investment")
    public void userSearchForProductInvestment() {
        ExplorePage.searchInvestmentProduct();
    }

    @And("user click on the product")
    public void userClickOnTheProduct() {
        ExplorePage.clickOnSearchedProduct();
    }

    @Then("the product page is shown to user")
    public void theProductPageIsShownToUser() {
        ExplorePage.verifyOnProductPage();
    }



}
