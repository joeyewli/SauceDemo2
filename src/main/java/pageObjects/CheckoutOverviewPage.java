package pageObjects;

import BaseTest.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutOverviewPage extends BasePage {

    @FindBy(className = "subheader")
    private WebElement pageTitle;
    //    @FindBy(className = "summary_value_label")
    @FindBy(xpath = "//*[contains(text(),'Payment Information')]following-sibling::class")
    private WebElement paymentInfo;
    @FindBy(className = "summary_value_label")
    private WebElement shippingInfo;

    public CheckoutOverviewPage() {
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle() {
        return pageTitle.getText();
    }

}
