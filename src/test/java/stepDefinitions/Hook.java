package stepDefinitions;

import BaseTest.BasePage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import java.io.File;

public class Hook extends BasePage {

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            //Take a s screenshot....
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }

    }

}
