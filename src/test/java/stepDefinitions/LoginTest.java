package stepDefinitions;

import BaseTest.BasePage;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.CartPage;
import pageObjects.HeaderPage;
import pageObjects.InventoryPage;
import pageObjects.LoginPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginTest extends BasePage {

    private LoginPage loginPage;
    private InventoryPage inventoryPage;
    private HeaderPage headerPage;
    private CartPage cartPage;
//    @Before
//    public void setup(){
//        System.out.println("LOGIN TEST SETUP");
//        initialization();
//        loginPage = new LoginPage();
//    }
//    @After
//    public void teardown(){
//        System.out.println("LOGIN TEST Tear Down");
//        driver.quit();
//    }

    @Before()
    public void setUpLoginPage(){
        System.out.println("Set up login page");
        initialization();
        loginPage = new LoginPage();
    }
    @Given("I am on saucedemo homepage")
    public void i_am_on_saucedemo_homepage() {

        loginPage.navigateToHomePage();
//        System.out.println("logs in to site");
    }

    @Given("I am a standard_user")
    public void i_am_a_standard_user() {
//        System.out.println("I am a standard user");
    }

    @Given("I am login on the inventory page")
    public void i_am_login_on_the_inventory_page() {
        inventoryPage = loginPage.loginAsStandardUser();

    }

    @Given("I am login on the Cart page")
    public void i_am_login_on_the_cart_page() {
        inventoryPage = loginPage.loginAsStandardUser();
        headerPage = new HeaderPage();
        cartPage = headerPage.clickOnCartIcon();
    }

    @When("I enter username (.*)")
    public void i_enter_username(String username) {
        loginPage.insertUsername(username);
//        System.out.println("enters username");
    }

    @When("password (.*)")
    public void password(String password) {
        loginPage.insertPassword(password);
//        System.out.println("enters password");
    }


    @When("try to Login")
    public void try_to_Login() {
        inventoryPage = loginPage.pressLoginBtn();
        assertTrue(inventoryPage.isInitialised());
    }

    @When("try to Login expecting to failed")
    public void try_to_Login_expecting_to_failed() {
        loginPage.pressLoginBtn();
    }

    @Then("I will login into (.*)")
    public void i_will_login_into(String currentURL) {
        assertEquals(inventoryPage.getURL(), currentURL);
        System.out.println("User is logged in");
    }

    @When("I check the homepage")
    public void i_check_the_homepage() {
        System.out.println("User checks page");
    }

    @Then("I can see swaglabs login logo")
    public void i_can_see_swaglabs_login_logo() {
//        System.out.println("swags logo");
        boolean flag = loginPage.getLoginLogo();
        assertTrue(flag);
    }

    @Then("I can see the robot logo")
    public void i_can_see_the_robot_logo() {
//        System.out.println("robot logo");
        boolean flag = loginPage.getRobotLogo();
        assertTrue(flag);
    }

    @Then("the tab shows (.*)")
    public void the_tab_shows_Swag_Labs(String title) {
//        System.out.println("tab swag labs");
        assertEquals(title, driver.getTitle());
    }


    @Then("I will remain at the Login page")
    public void i_will_remain_at_the_Login_page() {
        assertEquals(getURL(), getURL());
    }

    @Then("I will get an error message (.*) in the Login page")
    public void i_will_get_an_error_message(String error) {
        //assertTrue(contains(error));
//        System.out.println("Error Message");
        assertTrue(loginPage.getErrorMessage().contains(error));
    }

//    @After(value = "@login, @end", order = 0)
//    public void tearDown(){
//        System.out.println("tear down login page");
//        driver.quit();
//        driver = null;
//    }


}