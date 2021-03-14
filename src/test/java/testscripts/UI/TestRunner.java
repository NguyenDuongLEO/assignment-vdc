package testscripts.UI;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/testscripts/UI/TestFeatures.feature"
        ,glue= {"testscripts.UI.packagetest"}
)

public class TestRunner {

}
