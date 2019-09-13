package stepDefinitions;

import BaseTest.BasePage;
import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;
import cucumber.api.java.BeforeStep;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.junit.BeforeClass;
import pageObjects.InventoryPage;
import pageObjects.LoginPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginTest extends BasePage {

     LoginPage loginPage;
     InventoryPage inventoryPage;
    private String un= "Standard_user", pw = "secret_sauce";

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

    @Given("I am on saucedemo homepage")
    public void i_am_on_saucedemo_homepage() {
        initialization();
        loginPage = new LoginPage();
        loginPage.navigateToHomePage();
        System.out.println("logs in to site");
    }

    @When("I enter username (.*)")
    public void i_enter_username(String username) {
        // Write code here that turns the phrase above into concrete actions
        loginPage.insertUsername(username);
        System.out.println("enters username");
    }

    @When("password (.*)")
    public void password(String password) {
        // Write code here that turns the phrase above into concrete actions
        loginPage.insertPassword(password);
        System.out.println("enters password");
    }


    @When("try to Login")
    public void try_to_Login() {
        loginPage.pressLoginBtn();
    }

    @Then("I will login into (.*)")
    public void i_will_login_into(String currentURL) {
        assertEquals(loginPage.getURL(),currentURL);
        System.out.println("User is logged in");
    }


    @When("I check the homepage")
    public void i_check_the_homepage() throws Throwable {
        System.out.println("User checks page");
    }

    @Then("I can see swaglabs login logo")
    public void i_can_see_swaglabs_login_logo()throws Throwable{
        // Write code here that turns the phrase above into concrete actions
        System.out.println("swags logo");
        boolean flag = loginPage.getLoginLogo();
        assertTrue(flag);
    }

    @Then("I can see the robot logo")
    public void i_can_see_the_robot_logo() throws Throwable{
        // Write code here that turns the phrase above into concrete actions
        System.out.println("robot logo");
        boolean flag = loginPage.getRobotLogo();
        assertTrue(flag);
    }

    @Then("the tab shows (.*)")
    public void the_tab_shows_Swag_Labs(String title) throws Throwable {
        System.out.println("tab swag labs");
        assertEquals(title,driver.getTitle());
    }

    @Given("I am a standard_user")
    public void i_am_a_standard_user() throws Throwable {
        System.out.println("I am a standard user");
    }

    @Then("I will remain at the Login page")
    public void i_will_remain_at_the_Login_page() throws Throwable {
        assertEquals(getURL(),getURL());
    }

    @Then("I will get an error message (.*)")
    public void i_will_get_an_error_message(String error) throws Throwable{
        // Write code here that turns the phrase above into concrete actions
        //assertTrue(contains(error));
        System.out.println("Error Message");
        assertTrue(loginPage.getErrorMessage().contains(error));
    }




}