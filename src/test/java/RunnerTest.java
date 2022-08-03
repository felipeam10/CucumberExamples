import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "br.mg.paodequeijo.steps",
        plugin = {"pretty", "html:target/cucumber.html"},
        monochrome = false,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        dryRun = true
    )
public class RunnerTest {

}
