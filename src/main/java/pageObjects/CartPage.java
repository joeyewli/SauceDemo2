package pageObjects;

import BaseTest.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends BasePage {

    @FindBy(className = "cart_quantity")
    private List<WebElement> quantity;
    @FindBy(className = "inventory_item_price")
    private List<WebElement> itemPrice;
    @FindBy(className = "cart_button")
    private List<WebElement> removeBtn;
    @FindBy(xpath = "//[contains(text(),'Continue Shopping')]")
    private WebElement continueShoppingBtn;
    @FindBy(className = "checkout_button")
    private WebElement checkoutBtn;
    @FindBy(className = "subheader")
    private WebElement pageTitle;

    public CartPage(){
        PageFactory.initElements(driver,this);
    }

    public String getPageTitle() {
    return pageTitle.getText();
    }


}
