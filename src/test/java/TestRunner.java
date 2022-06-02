import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        features = {"src/test/resources/features"},
        glue = {"StepDefinition", "DriverWrapper"},
        tags = "@test",
        monochrome = true,
        plugin = {"pretty", "html:target/Reports/Default/"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class TestRunner {
}