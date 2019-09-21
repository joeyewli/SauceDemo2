package stepDefinitions;

import BaseTest.BasePage;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import pageObjects.CartPage;
import pageObjects.FooterPage;
import pageObjects.InventoryPage;
import pageObjects.LoginPage;

import static org.junit.Assert.assertTrue;

public class FooterTest extends BasePage {
    private LoginPage loginPage;
    private InventoryPage inventoryPage;
    private CartPage cartPage;
    private FooterPage footerPage;

    @Before("@footer")
    public void setUpFooterPage(){
//        initialization();
        footerPage = new FooterPage();
    }

    @Then("(.*) is in the footer")
    public void doesFooterContains(String footer) {
        boolean flag = footerPage.doesFooterContains(footer);
        assertTrue(flag);
    }



}
