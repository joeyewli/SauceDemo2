package testRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features= "src/test/resources"
        ,plugin = {"pretty", "html:HTML-output", "json:target/cucumber.json", "junit:XML-output/cucumber.xml"}
        ,glue = "stepDefinitions"
        ,monochrome = true
//        ,tags = "@now")
        ,tags = {"@inventory, @login, @cart"})
//        ,tags = {"~@donttest"})

public class runDemoSauceTests {
}
