package testscripts.ui;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/testscripts/ui/features/TestFeatures.feature"
        ,glue= {"testscripts"}
)

public class TestRunner { }