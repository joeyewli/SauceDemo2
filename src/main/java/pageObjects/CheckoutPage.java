package pageObjects;

import BaseTest.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CheckoutPage extends BasePage {

    @FindBy(className = "subheader")
    private WebElement pageTitle;
    @FindBy(id = "first-name")
    private WebElement firstName;
    @FindBy(id = "last-name")
    private WebElement lastName;
    @FindBy(id = "postal-code")
    private WebElement postcode;
    @FindBy(className = "cart_cancel_link")
    private WebElement cancelBtn;
    @FindBy(xpath = "//*[@type='submit']")
    private WebElement continueBtn;
    @FindBy(xpath = "//*[@data-test = 'error']")
    private WebElement error;

    public CheckoutPage() {
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle() {
        return pageTitle.getText();
    }


    public void enterDetails(String firstName, String lastName, String postcode) {
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.postcode.sendKeys(postcode);
    }

    public CheckoutOverviewPage clickOnContinue() {
        continueBtn.click();
        return new CheckoutOverviewPage();
    }


    public String getErrorMessage() {
        return error.getText();
    }

    public void clickOnCancel() {
        cancelBtn.click();
    }
}
