package stepDefinitions;

import BaseTest.BasePage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class Hook extends BasePage {

    @After(order = 1000)
    public void screenshotAfterScenario(Scenario scenario) {
        System.out.println("SCREEN SHOT");
        if (scenario.isFailed()) {
            //Take a s screenshot....
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        } else {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }

    }
}
