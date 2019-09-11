package BaseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.LoginPage;

public class BasePage {
    public static WebDriver driver;
    private String homePageURL = "https://www.saucedemo.com";

    public BasePage(){
        PageFactory.initElements(driver, this   );
    }

    public static void initialization(){
        if (driver==null){
            System.out.println("--------------------------------SET UP -------------------------");
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\joeye\\Documents\\Automation Test\\geckodriver.exe");
            System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
            driver = new FirefoxDriver();
        }
    }

    public LoginPage navigateToHomePage(){
        driver.navigate().to(homePageURL);
        return new LoginPage();
    }

    public String getURL() {
        System.out.println(driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }
    public String getHomepage(){
        return homePageURL;
    }
}
