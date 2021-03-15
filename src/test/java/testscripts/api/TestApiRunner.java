package testscripts.api;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/testscripts/api/featuresApi/TestApiFeatures.feature"
        ,glue= {"testscripts/api"},
        plugin = { "pretty", "html:target/cucumber-reports.html" },
        monochrome = true
)

public class TestApiRunner {
}