package BaseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObjects.LoginPage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BasePage {
    public static WebDriver driver;
    public static Properties prop;

    /**
     * Getting config file
     * This will be call by child definition classes
     */
    public BasePage(){
        try{
            prop = new Properties();
            FileInputStream fis = new FileInputStream("D:\\Desktop\\SauceDemo2\\src\\main\\java\\BaseTest\\config.properties");
            prop.load(fis);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This initializes the browser depending on the config file.
     * Will be call by all childs (Login Page and Step definitions)
     */
    public static void initialization(){
        String browserName = prop.getProperty("browser");
//        System.out.println("--------------------------------Initializing Browswer-------------------------");
        if (driver == null) {
            if (browserName.equals("FireFox")) {
//                System.out.println("-------------------------------FireFox initialized------------------------" + browserName);
                System.setProperty("webdriver.gecko.driver", "C:\\Users\\joeye\\Documents\\Automation Test\\geckodriver.exe");
                System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
                System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
                driver = new FirefoxDriver();
            } else if (browserName.equals("Chrome")) {
                ///
            }
        }

    }

    public LoginPage navigateToHomePage(){
        driver.navigate().to(prop.getProperty("homepage"));
        return new LoginPage();
    }

    public String getURL() {
        System.out.println(driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }
    public String getHomepage(){
        return prop.getProperty("homepage");
    }
}
