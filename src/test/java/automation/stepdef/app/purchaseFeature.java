package automation.stepdef.app;

import automation.pages.app.loginPage;
import automation.pages.app.homePage;
import automation.pages.app.productPage;
import automation.pages.app.cartPage;
import automation.pages.app.checkoutPage;
import automation.pages.app.paymentPage;
import automation.utility.appsUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class purchaseFeature {

    loginPage loginAppPage = new loginPage(appsUtility.getDriver());
    homePage HomePage = new homePage(appsUtility.getDriver());
    productPage ProductPage = new productPage(appsUtility.getDriver());
    cartPage Cart = new cartPage(appsUtility.getDriver());
    checkoutPage CheckoutPage = new checkoutPage(appsUtility.getDriver());
    paymentPage Paymentpage = new paymentPage(appsUtility.getDriver()) ;

    @Given("user has login with saucelab account")
    public void userHasLoginWithSaucelabAccount() {

        HomePage.onHomepage();
        HomePage.clickOnBurgerIcon();
        HomePage.navigateToLogin();
        loginAppPage.fillUserdata();
        loginAppPage.finalizeLogin();
    }

    @When("user click on Sauce Labs Backpack product")
    public void userClickOnSauceLabsBackpackProduct() {
        HomePage.openProduct();
    }

    @And("user selected blue color variant")
    public void userSelectedBlueColorVariant() {
        ProductPage.changeProductColor();
    }

    @And("user set the item quantity to two")
    public void userSetTheItemQuantityToTwo() {
        ProductPage.changeProductQuantity();
    }

    @And("user click on Add to Cart")
    public void userClickOnAddToCart() {
        ProductPage.addToCart();
    }

    @And("user navigate to cart page")
    public void userNavigateToCartPage() {
        ProductPage.navigatetoCart();
    }

    @And("user checkout")
    public void userCheckout() {
        Cart.validatingInCartPage();
        Cart.proceedtoCheckout();
    }

    @And("user fill the required information and click to payment")
    public void userFillTheRequiredInformationAndClickToPayment() {
        CheckoutPage.userOnCheckoutAddressPage();
        CheckoutPage.usefillRequiredAddressField();
        CheckoutPage.userNavigateToPaymentPage();
    }

    @And("finalize the payment")
    public void finalizeThePayment() {
        Paymentpage.userOnPaymentPage();
        Paymentpage.userFillPaymentData();
        Paymentpage.userNavigatetoReviewPage();
        CheckoutPage.reviewOrderfinalization();
    }

    @Then("user successfully buy the product")
    public void userSuccessfullyBuyTheProduct() {
        CheckoutPage.orderComplete();
    }



}
