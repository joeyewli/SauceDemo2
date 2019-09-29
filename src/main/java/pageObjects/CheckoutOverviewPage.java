package pageObjects;

import BaseTest.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckoutOverviewPage extends BasePage {

    @FindBy(className = "subheader")
    private WebElement pageTitle;
    //    @FindBy(className = "summary_value_label")
    @FindBy(xpath = "//*[contains(text(),'Payment Information')]following-sibling::class")
    private WebElement paymentInfo;
    @FindBy(className = "summary_value_label")
    private WebElement shippingInfo;
    @FindBy(className = "cart_item")
    private List<WebElement> cartItems;
    @FindBy(className = "inventory_item_name")
    private List<WebElement> inventoryName;
    @FindBy(className = "inventory_item_price")
    private List<WebElement> inventoryPrice;
    @FindBy(className = "inventory_item_desc")
    private List<WebElement> inventoryDesc;
    @FindBy(className = "summary_subtotal_label")
    private WebElement itemTotal;
    @FindBy(className = "summary_tax_label")
    private WebElement tax;
    @FindBy(className = "summary_total_label")
    private WebElement total;
    @FindBy(className = "cart_cancel_link")
    private WebElement cancelBtn;
    @FindBy(className = "cart_button")
    private WebElement finishBtn;


    public CheckoutOverviewPage() {
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle() {
        return pageTitle.getText();
    }

    public double getSumofCart() {
        double sum = 0;
        int position = inventoryPrice.get(0).getText().indexOf("$") + 1;
        for (WebElement item : inventoryPrice) {
            sum += Double.parseDouble(item.getText().substring(position));
        }
        System.out.println("SUM = " + sum);
        return sum;
    }

    public double getItemTotal() {
        int position = itemTotal.getText().indexOf("$") + 1;
//        System.out.println("Subtotal = " + itemTotal.getText().substring(position));
        return Double.parseDouble(itemTotal.getText().substring(position));
    }

    public double getTax() {
        int position = tax.getText().indexOf("$") + 1;
//        System.out.println("tax = " + tax.getText().substring(position));
        return Double.parseDouble(tax.getText().substring(position));
    }

    public double getTotal() {
        int position = total.getText().indexOf("$") + 1;
//        System.out.println("total = " + total.getText().substring(position));
        return Double.parseDouble(total.getText().substring(position));
    }

    public InventoryPage pressCancel() {
        cancelBtn.click();
        return new InventoryPage();
    }

    public void pressFinish() {
        finishBtn.click();
    }
}
