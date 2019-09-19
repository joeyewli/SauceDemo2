package stepDefinitions;

import BaseTest.BasePage;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.InventoryPage;
import pageObjects.LoginPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class InventoryTest extends BasePage {
    LoginPage loginPage;
    InventoryPage inventoryPage;

//    @Before
//    public void setup(){
//        System.out.println("INVENTORY TEST SETUP");
////        initialization();
////        loginPage = new LoginPage();
//    }
//
//    @After
//    public void teardown() {
//        System.out.println("INVENTORY TEST Tear Down");
////        driver.quit();
//    }

    @Given("I am login on the inventory page")
    public void i_am_login_on_the_inventory_page() {
        initialization();
        loginPage = new LoginPage();
        inventoryPage = loginPage.loginAsStandardUser();

    }

    @When("I click on all the links")
    public void i_click_on_all_the_links() {
        inventoryPage.showlinks();

    }

    @Then("all links works")
    public void all_links_works() {
        // Write code here that turns the phrase above into concrete actions
        inventoryPage.checkLinks();
    }

    @Then("testing")
    public void testing() {
        System.out.println(inventoryPage.test());
    }

    @Then("(.*) is in the footer")
    public void doesFooterContains(String footer) {
        boolean flag = inventoryPage.doesFooterContains(footer);
        assertTrue(flag);
    }

    @Then("all images are displayed")
    public void areAllImagesDisplayed() {
        boolean flag = inventoryPage.areImagesDisplayed();
        assertTrue(flag);
    }

    @When("^I add (\\d+) items$")
    public void I_add_items(int i) {
        // Write code here that turns the phrase above into concrete actions
        inventoryPage.addToCart(i);
//        System.out.println("add items = " +i);
    }

    @When("^I remove (\\d+) items$")
    public void i_remove_items(int i) {
        inventoryPage.removeFromCart(i);
    }

    @Then("^cart will have (\\d+) items in it$")
    public void cart_will_have_items_in_it(int i) {
        int cartItems = inventoryPage.getCartItems();
        assertEquals(i, cartItems);
    }

    @Given("^I have (\\d+) items in the cart")
    public void i_have_items_in_the_cart(int i) {
        inventoryPage.addToCart(i);
    }

    @After
    public void emptycart() {
//        if (getURL().equals(prop.getProperty("inventorypage"))) {
        if (inventoryPage!=null && inventoryPage.isInitialised()){
            System.out.println("Empty cart method");
            while (inventoryPage.getCartItems() > 0) {

                inventoryPage.removeFromCart(1);
            }
        }

    }


}
