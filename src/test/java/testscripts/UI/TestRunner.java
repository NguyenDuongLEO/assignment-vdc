package testscripts.UI;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/testscripts/UI/features/TestFeatures.feature"
        ,glue= {"testscripts"}
)

public class TestRunner { }