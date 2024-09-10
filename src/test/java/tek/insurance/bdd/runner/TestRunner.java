package tek.insurance.bdd.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "",
        features = "classpath:features",
        glue = "tek.insurance.bdd.steps",
        dryRun = false,

        monochrome = true,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = {
                "pretty",
                "summary",
                "html:target/cucumber_report/index.html",
                "json:target/cucumber-report",
               "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }
)


public class TestRunner {


}
