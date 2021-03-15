package testscripts.ui;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/testscripts/ui/features/TestFeatures.feature"
        ,glue= {"testscripts/ui"},
        plugin = { "pretty", "html:target/cucumber-reports.html" },
        monochrome = true
)

public class TestRunner { }