package stepDefinitions;

import BaseTest.BasePage;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.FooterPage;
import pageObjects.HeaderPage;
import pageObjects.InventoryPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class InventoryTest extends BasePage {
    private InventoryPage inventoryPage;
    private FooterPage footerPage;
    private HeaderPage headerPage;

    @When("I click on all the links")
    public void i_click_on_all_the_links() {
        inventoryPage.showlinks();
    }

    @Then("all links works")
    public void all_links_works() {
        inventoryPage.checkLinks();
    }

    @Then("testing")
    public void testing() {
        System.out.println("Test");
    }


    @Then("all images are displayed")
    public void areAllImagesDisplayed() {
        boolean flag = inventoryPage.areImagesDisplayed();
        assertTrue(flag);
    }

    @When("^I add (\\d+) items$")
    public void I_add_items(int i) {
        inventoryPage.addToCart(i);
//        System.out.println("add items = " +i);
    }

    @When("^I remove (\\d+) items$")
    public void i_remove_items(int i) {
        inventoryPage.removeFromCart(i);
    }



    @Given("^I have (\\d+) items in the cart")
    public void i_have_items_in_the_cart(int i) {
        inventoryPage.addToCart(i);
    }

    @When("I sort (.*)")
    public void i_sort(String sortOption) throws Throwable {
        inventoryPage.selectSortingFilter(sortOption);
    }

    @Then("the Item prices are sorted from low to high")
    public void the_Item_prices_are_sorted_from_low_to_high()  throws Throwable {
       assertTrue(inventoryPage.checkPriceSortedFromLowToHigh());
    }


    @Then("the Item prices are sorted from high to low")
    public void the_Item_prices_are_sorted_from_high_to_low()  throws Throwable{
        assertTrue(inventoryPage.checkPriceSortedFromHighToLow());
    }

    @Then("the Items are sorted in ascending order")
    public void the_Items_are_sorted_in_ascending_order()throws Throwable {
        assertTrue(inventoryPage.checkItemsAscendingOrder());
    }

    @Then("the Items are sorted in descending order")
    public void the_Items_are_sorted_in_descending_order() throws Throwable{
        assertTrue(inventoryPage.checkItemsDescendingOrder());
    }

    @Then("I will be in the Products page")
    public void i_will_be_in_the_Products_page() {
        assertEquals("Products", inventoryPage.getPageTitle());
    }


    @Before("@cart, @inventory")
    public void setUpInventoryPage(){
//        System.out.println("Set up inventory page");
        initialization();
        inventoryPage = new InventoryPage();
        footerPage = new FooterPage();
        headerPage = new HeaderPage();
    }

    @After(value = "@addToCart", order = 100)
    public void emptycart() {
        if (inventoryPage != null && inventoryPage.isInitialised()) {
//            System.out.println("Empty cart method");
//            while (headerPage.getCartItems() > 0) {
//                inventoryPage.removeFromCart(1);
//            }
            inventoryPage.removeFromCart(headerPage.getCartItems());
        }
    }




//    @After(value = "@cart, @inventory", order = 0)
//    public void tearDown(){
//        System.out.println("tear down inventory page");
//        driver.quit();
//        driver = null;
//    }


}
