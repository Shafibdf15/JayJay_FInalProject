package automation.stepdef.web;

import automation.utility.PurchasePreconditions;
import automation.pages.web.CartPage;
import automation.utility.WebAlert;
import automation.utility.WebDriverUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

//E2E cases Step Def
public class PurchaseStep extends WebDriverUtil {

    //Create object instance
    PurchasePreconditions purchasePreconditions;
    CartPage cartPage;


    @Given("user has login with valid account")
    public void userHasLoginWithValidAccount()  {

        // Call preconditons helper
       purchasePreconditions = new PurchasePreconditions(driver);
       purchasePreconditions.navigateToHomePage();
       purchasePreconditions.performLogin("RandomAcc","Dummy123");
    }

    @When("user click product and add to cart")
    public void userClickProductAndAddToCart() {
        purchasePreconditions.addProductToCart();
    }

    @Then("Message indicating product has been added is shown")
    public void messageIndicatingProductHasBeenAddedIsShown() {

        WebAlert AlertMessage = new WebAlert(driver);
        AlertMessage.addtoCart();
    }

    @And("User can validate item in cart page")
    public void userCanValidateItemInCartPage() {
      purchasePreconditions.gotoCartPage();
    }

    @Given("User has product in Cart")
    public void userHasProductInCart() {

        purchasePreconditions = new PurchasePreconditions(driver);
        purchasePreconditions.navigateToHomePage();
        purchasePreconditions.performLogin("RandomAcc","Dummy123");
        purchasePreconditions.addProductToCart();
        purchasePreconditions.gotoCartPage();
    }

    @When("User click place order button")
    public void userClickPlaceOrderButton() {

        cartPage = new CartPage(driver);
        cartPage.placeOrder();
    }

    @And("User has fill the required data")
    public void userHasFillTheRequiredData() {

        cartPage.orderData();

    }

    @And("User click purchase button")
    public void userClickPurchaseButton() {

        cartPage.clickPurchase();

    }

    @Then("PopUp messeage indicating purchase successfull is shown")
    public void popupMesseageIndicatingPurchaseSuccessfullIsShown() {

        cartPage.purchasevalidation();
        cartPage.setCloseSuccessAlert();
    }

    @And("user click purchase button")
    public void clicPurchaseButton() {

        cartPage.clickPurchase();
    }

    @Then("Alert message is shown directing user to fill the required field")
    public void alertMessageIsShownDirectingUserToFillTheRequiredField() {

        WebAlert alert = new WebAlert(driver);
        alert.invalidOrder();
        cartPage.setCloseOrderModal();
    }

        @When("User click on delete button")
    public void userClickOnDeleteButton() {

            cartPage = new CartPage(driver);
            cartPage.clearCart();
    }

    @Then("Product will be removed from Cart")
    public void productWillBeRemovedFromCart() {

        cartPage.isCartEmpty();
    }




}
