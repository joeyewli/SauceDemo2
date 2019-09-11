package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseDefinitions {
    protected static WebDriver driver;
    public WebDriver getDriver(){
        if (driver==null){
            System.out.println("--------------------------------SET UP -------------------------");
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\joeye\\Documents\\Automation Test\\geckodriver.exe");
            System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
            driver = new FirefoxDriver();
        }
        return driver;
    }
}
