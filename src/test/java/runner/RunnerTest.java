package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import core.DriverFactory;

import java.io.IOException;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/reports/cucumberTestes.json", "html:target/reports/"},
        features = "src/test/resources/features",
        glue = {"steps"},
        snippets = SnippetType.CAMELCASE,
        tags = {"@regressivo"}
)
public class RunnerTest {
    @AfterClass
    public static void fecharApp() throws IOException {

        if (System.getProperty("os.name").equals("Windows 10")) {
            Runtime.getRuntime().exec("cmd.exe /c mvn cluecumber-report:reporting");
        } else {
            Runtime.getRuntime().exec("sh -c mvn cluecumber-report:reporting");
        }

        DriverFactory.quitDriver();
    }
}
