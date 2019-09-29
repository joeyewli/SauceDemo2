package stepDefinitions;

import BaseTest.BasePage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.bytebuddy.implementation.bytecode.Throw;
import pageObjects.CheckoutOverviewPage;
import pageObjects.CheckoutPage;
import pageObjects.InventoryPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CheckoutTest extends BasePage {
    private CheckoutPage checkoutPage;
    private CheckoutOverviewPage checkoutOverviewPage;
    private InventoryPage inventoryPage;
    @Before("@checkout")
    public void setUpLoginPage() throws Throwable {
//        System.out.println("Set up cart page");
        initialization();
        checkoutPage = new CheckoutPage();
    }

    @After(value = "@emptyCartCheckoutOverview", order = 101)
    public void emptyCartFromCheckoutOverview() {
        inventoryPage = checkoutOverviewPage.pressCancel();
    }

    @Then("I will be in the Checkout: Your Information page")
    public void i_will_be_in_the_Checkout_Your_Information_page() throws Throwable {
        assertEquals("Checkout: Your Information", checkoutPage.getPageTitle());
    }

    @When("I enter my details- first name = (.*), last name = (.*), postcode = (.*)")
    public void i_enter_my_details(String firstName, String lastName, String postcode) throws Throwable {
        checkoutPage.enterDetails(firstName, lastName, postcode);
    }

    @Then("I will get an error message (.*) in the Checkout page")
    public void i_will_get_an_error_message_in_checkout_page(String error) throws Throwable {
        //assertTrue(contains(error));
//        System.out.println("Error Message " + checkoutPage.getErrorMessage());
        assertTrue(checkoutPage.getErrorMessage().contains(error));
    }

    @When("I click cancel in the Checkout page")
    public void i_click_cancel_in_the_Checkout_page() throws Throwable {
        checkoutPage.clickOnCancel();
    }

    @Then("I will be in the Checkout: Overview page")
    public void i_will_be_in_the_Checkout_Overview_page() throws Throwable {
        assertEquals("Checkout: Overview", checkoutOverviewPage.getPageTitle());
    }

    @When("I click on continue")
    public void i_click_on_continue() throws Throwable {
        checkoutOverviewPage = checkoutPage.clickOnContinue();
    }

    @Then("Item total is the sum of all items in the cart")
    public void item_total_is_the_sum_of_all_items_in_the_cart() throws Throwable {
        assertEquals(checkoutOverviewPage.getSumofCart(), checkoutOverviewPage.getItemTotal(), 0.01);
    }

    @Then("^tax = (\\d+) percent of Item total$")
    public void tax_percent_of_Item_total(double a) throws Throwable {
        assertEquals(checkoutOverviewPage.getItemTotal() * a / 100, checkoutOverviewPage.getTax(), 0.01);

    }

    @Then("Total = Tax and Item Total")
    public void total_Tax_and_Item_Total() throws Throwable {
        assertEquals(checkoutOverviewPage.getItemTotal() + checkoutOverviewPage.getTax(), checkoutOverviewPage.getTotal(), 0.01);
    }
}
