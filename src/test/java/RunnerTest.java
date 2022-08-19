import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/",
        glue = "br.mg.paodequeijo.steps",
        tags = "@unitarios",
        plugin = {"pretty", "html:target/cucumber.html"},
        monochrome = false,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        dryRun = false
    )
public class RunnerTest {

    @BeforeClass
    public static void reset(){

    }
}
