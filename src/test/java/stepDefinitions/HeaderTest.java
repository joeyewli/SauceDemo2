package stepDefinitions;

import BaseTest.BasePage;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.CartPage;
import pageObjects.HeaderPage;

import static org.junit.Assert.assertEquals;

public class HeaderTest extends BasePage {
    private HeaderPage headerPage;
    private CartPage cartPage;

    @Then("^cart will have (\\d+) items in it$")
    public void cart_will_have_items_in_it(int i) {
        assertEquals(i, headerPage.getCartItems());
    }

    @When("I click on the Cart")
    public void i_click_on_the_Cart() throws Throwable {
        cartPage = headerPage.clickOnCartIcon();
    }

    @Before("@cart")
    public void setUpInventoryPage() {
//        System.out.println("Set up inventory page");
        initialization();
        headerPage = new HeaderPage();
    }
}
