package pageObjects;

import BaseTest.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FinishPage extends BasePage {

    @FindBy(className = "subheader")
    private WebElement pageTitle;
    @FindBy(className = "complete-header")
    private WebElement header;
    @FindBy(className = "complete-text")
    private WebElement text;


    public FinishPage() {
        PageFactory.initElements(driver, this);
    }

    public String getTitle() {
        return pageTitle.getText();
    }

    public String getHeader() {
        return header.getText();
    }

    public String getText() {
        return text.getText();
    }

}
