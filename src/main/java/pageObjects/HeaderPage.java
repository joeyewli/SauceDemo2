package pageObjects;

import BaseTest.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderPage extends BasePage {
    @FindBy(className = "shopping_cart_badge")
    private WebElement cart;
    //    @FindBy(xpath = "//*[@class='inventory_list']/child::div//*[contains(@class,'add-to-cart-button')]")
    @FindBy(className = "shopping_cart_container")
    private WebElement cartIcon;

    public HeaderPage() {
        PageFactory.initElements(driver, this);
    }

    public int getCartItems() {

        try {
            return Integer.parseInt(cart.getText());
        } catch (NoSuchElementException e) {
//            System.out.println("Return 0 - No element");
            return 0;
        }

    }

    public CartPage clickOnCartIcon() {
        cartIcon.click();
        return new CartPage();
    }
}