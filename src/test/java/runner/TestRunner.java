package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        features = "src/test/resources/Features",
        glue = {"step_definitions"},
        //plugin = {"pretty", "summary", "html:target/cucumberReports/reports.html"},
        plugin = {"pretty", "summary", "json:target/Cucumber-reports/cucumber-html-reports/reports.json",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber-reports"}
        //publish = true,
        //tags = "@Login_test"
        //snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class TestRunner {
}
