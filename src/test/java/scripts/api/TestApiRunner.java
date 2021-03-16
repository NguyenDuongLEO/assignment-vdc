package scripts.api;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/scripts/api/featuresApi/TestApiFeatures.feature"
        ,glue= {"scripts/api"},
        plugin = { "pretty", "html:target/cucumber-api-reports.html" },
        monochrome = true
)

public class TestApiRunner {
}