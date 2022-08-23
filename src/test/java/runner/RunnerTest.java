package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import steps.Hooks;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/reports/cucumberTestes.json", "html:target/reports/"},
        features = "src/test/resources/features",
        tags = {"@test"},
        glue = {"steps"}
)
public class RunnerTest {
    @AfterClass
    public static void fecharApp(){
        Hooks.quitDriver();
    }
}
