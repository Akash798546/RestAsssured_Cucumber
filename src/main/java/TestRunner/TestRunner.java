package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	    features = "src\\main\\java\\FeatureFile\\RestAssuredFeature.feature",
	    glue = {"StepDefination"},
	    dryRun = false,
	    monochrome = true,
	    plugin = {"pretty", "html:target/cucumber-reports.html" ,"json:target/cucumber-report.json"}
	    
	)
public class TestRunner {

}
