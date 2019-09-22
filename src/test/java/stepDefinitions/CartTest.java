package stepDefinitions;

import BaseTest.BasePage;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;

import static org.junit.Assert.assertEquals;

public class CartTest extends BasePage {
    private CartPage cartPage;
    private CheckoutPage checkoutPage;

    @Before("@cart, @checkout")
    public void setUpLoginPage() {
//        System.out.println("Set up cart page");
        initialization();
        cartPage = new CartPage();
    }

    @When("I click on Continue Shopping button")
    public void i_click_on_Continue_Shopping_button() {
        // Write code here that turns the phrase above into concrete actions
        cartPage.clickContinueShopping();
    }

    @Then("I will be in the Your Cart Page")
    public void i_will_be_in_the_Cart_Page() {
        assertEquals("Your Cart", cartPage.getPageTitle());
    }

    @When("I checkout")
    public void i_checkout() {
        checkoutPage = cartPage.clickCheckout();
    }

}
