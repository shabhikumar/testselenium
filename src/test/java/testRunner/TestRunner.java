package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C:\\Users\\hp\\IdeaProjects\\SeleniumCucumber\\src\\test\\Features\\OrangeHRMLogin.feature",
        glue = "stepDefinitions",
//        plugin = {
//                "pretty",
//            "html:target/html-reports/report.html"
//        }

        plugin = { "pretty", "json:target/cucumber.json",
                "html:target/cucumber-html-report",
        "junit:target/cucumber.xml"}


)
public class TestRunner {

}
