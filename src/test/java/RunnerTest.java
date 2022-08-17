import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/inserirConta.feature",
        glue = "br.mg.paodequeijo.steps",
        tags = "not @ignore",
        plugin = {"pretty", "html:target/cucumber.html"},
        monochrome = false,
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        dryRun = false
    )
public class RunnerTest {

    @BeforeClass
    public static void reset(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\workspace-projects\\NavegDrivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://seubarriga.wcaquino.me/");
        driver.findElement(By.id("email")).sendKeys("felipeam10@hotmail.com");
        driver.findElement(By.id("senha")).sendKeys("123456");
        driver.findElement(By.tagName("button")).click();
        driver.findElement(By.linkText("reset")).click();
        driver.quit();
    }
}
