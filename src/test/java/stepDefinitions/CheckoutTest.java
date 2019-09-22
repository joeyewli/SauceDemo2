package stepDefinitions;

import BaseTest.BasePage;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.CheckoutOverviewPage;
import pageObjects.CheckoutPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CheckoutTest extends BasePage {
    private CheckoutPage checkoutPage;
    private CheckoutOverviewPage checkoutOverviewPage;

    @Before("@checkout")
    public void setUpLoginPage() {
//        System.out.println("Set up cart page");
        initialization();
        checkoutPage = new CheckoutPage();
    }

    @Then("I will be in the Checkout: Your Information page")
    public void i_will_be_in_the_Checkout_Your_Information_page() {
        assertEquals("Checkout: Your Information", checkoutPage.getPageTitle());
    }

    @When("I enter my details- first name = (.*), last name = (.*), postcode = (.*)")
    public void i_enter_my_details(String firstName, String lastName, String postcode) {
        checkoutPage.enterDetails(firstName, lastName, postcode);
    }

    @Then("I will get an error message (.*) in the Checkout page")
    public void i_will_get_an_error_message_in_checkout_page(String error) {
        //assertTrue(contains(error));
//        System.out.println("Error Message " + checkoutPage.getErrorMessage());
        assertTrue(checkoutPage.getErrorMessage().contains(error));
    }

    @When("I click cancel in the Checkout page")
    public void i_click_cancel_in_the_Checkout_page() {
        checkoutPage.clickOnCancel();
    }

    @Then("I will be in the Checkout: Overview page")
    public void i_will_be_in_the_Checkout_Overview_page() {
        assertEquals("Checkout: Overview", checkoutOverviewPage.getPageTitle());
    }

    @When("I click on continue")
    public void i_click_on_continue() {
        checkoutOverviewPage = checkoutPage.clickOnContinue();
    }
}
