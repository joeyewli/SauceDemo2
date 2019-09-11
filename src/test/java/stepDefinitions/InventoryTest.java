package stepDefinitions;

import BaseTest.BasePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.InventoryPage;
import pageObjects.LoginPage;

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
    public void i_am_login_on_the_inventory_page() throws Throwable {
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
    public void testing() throws Throwable{
    System.out.println(inventoryPage.test());
    }

    @Then("(.*) is in the footer")
    public void doesFooterContains(String footer) throws Throwable{
        boolean flag =inventoryPage.doesFooterContains(footer);
        assertTrue(flag);
    }
    @Then("all images are displayed")
    public void areAllImagesDisplayed(){
        boolean flag = inventoryPage.areImagesDisplayed();
        assertTrue(flag);
    }

}
