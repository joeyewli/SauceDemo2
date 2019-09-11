package pageObjects;

import BaseTest.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage extends BasePage {
    @FindBy(id="user-name")
    private WebElement username;
    @FindBy (id="password")
    private WebElement password;
    @FindBy(xpath = "//*[@value = 'LOGIN']")
    private WebElement loginBtn;
    @FindBy (className= "login_logo")
    private WebElement loginLogo;
    @FindBy (className = "bot_column")
    private WebElement botImage;
    @FindBy (xpath = "//*[@data-test = 'error']")
    private WebElement errorMessage;

    private String loginURL = "https://www.saucedemo.com/index.html";

    /*
    @FindBy(xpath = "//*[@placeholder = 'Username']")
    private WebElement username;

    @FindBy(xpath = "//*[@placeholder = 'Password']")
    private WebElement password;

    @FindBy(xpath = "//*[@value = 'LOGIN']")
    private WebElement login;

    @FindBy(xpath = "//*[@data-test = 'error']")
    private WebElement errorMessage;


     */

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void insertUsername(String un) {
        username.sendKeys(un);
    }

    public void insertPassword(String pw) {
        password.sendKeys(pw);
    }


    public InventoryPage pressLoginBtn() {
        loginBtn.click();
        return new InventoryPage();
    }
    public InventoryPage loginAsStandardUser(){
        navigateToHomePage();
//        username.sendKeys("standard_user");
        username.sendKeys("problem_user");
        password.sendKeys("secret_sauce");
        loginBtn.click();
        return new InventoryPage();
    }
    public String getLoginURL(){
        return loginURL;
    }

    public boolean getLoginLogo() {
        return loginLogo.isDisplayed();
    }

    public boolean getRobotLogo() {
        return botImage.isDisplayed();
    }

    public String getErrorMessage(){
        return errorMessage.getText();
    }
}
