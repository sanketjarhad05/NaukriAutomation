
package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/com/feature",   // path to .feature files
        glue = {"stepDefinations","appHooks"},                   // package of step defs
        plugin = {"pretty", "html:target/cucumber-report.html"}
      //  dryRun = true

      
)
public class TestRunner {
}
