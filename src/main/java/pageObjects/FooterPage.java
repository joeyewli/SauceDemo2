package pageObjects;

import BaseTest.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FooterPage extends BasePage {
    @FindBy(className = "footer")
    private WebElement footer;

    public FooterPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean isInitialised() {
        return footer.isDisplayed();
    }

    public String test() {
        return footer.getText();
    }

    public boolean doesFooterContains(String text) {
        return footer.getText().contains(text);
    }

}
