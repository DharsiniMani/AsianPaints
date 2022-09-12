package runner;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/featureFiles",
				 glue="stepDefinitions",
				 dryRun=false,
				 monochrome= true,
				 plugin={"pretty","html:test-output/CucumberReport.html"})
public class Run extends AbstractTestNGCucumberTests {

}
