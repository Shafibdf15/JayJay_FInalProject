package automation.utility;

import org.openqa.selenium.WebDriver;
import automation.pages.web.*;

// Helper purchasing preconditions class
public class PurchasePreconditions {

    // Create object instance
    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;
    ProductPage productPage;
    CartPage cartPage;

    public PurchasePreconditions(WebDriver driver){
        this.driver = driver;
        this.homePage = new HomePage(driver);
        this.loginPage = new LoginPage(driver);
        this.productPage = new ProductPage(driver);
        this.cartPage = new CartPage(driver);

    }

    // Enter Demoblaze flow
    public void navigateToHomePage() {
        homePage.gotoPage();
        homePage.getLogin();
        homePage.getLoginModal();
    }

    // do Login flow
    public void performLogin(String username, String password) {
        loginPage.dologin(username, password);
        loginPage.setLoginButton();
        homePage.validateUserLogin();
    }

    // Add to cart flow
    public void addProductToCart() {
        homePage.getProduct();
        productPage.getProductPage();
        productPage.addtoCart();
    }

    // Redirect to cart page
    public void gotoCartPage() {
        cartPage.cartData();
    }


}
