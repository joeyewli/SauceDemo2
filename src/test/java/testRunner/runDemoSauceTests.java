package testRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features= "src/test/resources"
        ,plugin = {"pretty", "html:HTML-output", "json:JSON-output/cucumber.json", "junit:XML-output/cucumber.xml"}
        ,glue = "stepDefinitions"
        ,monochrome = true
        ,tags = "@now")
//        ,tags = {"~@donttest"})

public class runDemoSauceTests {
}
