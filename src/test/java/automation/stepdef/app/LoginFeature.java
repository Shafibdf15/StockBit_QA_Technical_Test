package automation.stepdef.app;

import automation.pages.app.homePage;
import automation.pages.app.loginPage;
import automation.utility.appsUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginFeature {

    loginPage loginAppPage = new loginPage(appsUtility.getDriver());
    homePage HomePage = new homePage(appsUtility.getDriver());

    @Given("user is on homepage")
    public void userIsOnHomepage() {
        HomePage.onHomepage();
    }

    @And("user click on burger icon")
    public void userClickOnBurgerIcon() {
        HomePage.clickOnBurgerIcon();
    }

    @And("user click log in")
    public void userClickLogIn() {
        HomePage.navigateToLogin();
    }

    @When("User enters username & password")
    public void userEntersUsernamePassword() {
        loginAppPage.fillUserdata();
    }

    @And("user click login")
    public void userClickLogin() {
        loginAppPage.finalizeLogin();
    }

    @Then("User successfully login in the app")
    public void userSuccessfullyLoginInTheApp() {
        HomePage.clickOnBurgerIcon();
        HomePage.validateLoginState();
    }

}
