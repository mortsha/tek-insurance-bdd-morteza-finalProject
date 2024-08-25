package tek.insurance.bdd.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "OpenBrowser",
        features = "classpath:features",
        glue = "tek.insurance.bdd.steps",
        dryRun = true,

        monochrome = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = {
                "pretty",
                "html:target/cucumber_report/index.html"
        }
)


public class TestRunner {


}
