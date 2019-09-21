package stepDefinitions;

import BaseTest.BasePage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Then;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class Hook extends BasePage {

    @After(order = 1000)
    public void screenshotAfterScenario(Scenario scenario) {
//        System.out.println("SCREEN SHOT");
        if (scenario.isFailed()) {
            //Take a s screenshot....
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        } else {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }

    }

    @After(value = ("@end"), order = 1)
    public void tearDown(Scenario scenario) {
//        System.out.println("QUIT DRIVER");
        driver.quit();
        driver = null;

    }

    @Then("QUIT DRIVER")
    public void quit_driver() {
//        System.out.println("QUIT DRIVER");
    }
}
