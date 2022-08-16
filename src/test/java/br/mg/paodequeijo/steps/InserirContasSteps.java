package br.mg.paodequeijo.steps;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class InserirContasSteps {

    private WebDriver driver;

    @Given("que estou acessando a aplicacao")
    public void queEstouAcessandoAAplicação() throws Throwable {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\workspace-projects\\NavegDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://seubarriga.wcaquino.me/");
    }

    @When("informo o usuario {string}")
    public void informoOUsuário(String string) throws Throwable {
        driver.findElement(By.id("email")).sendKeys(string);
    }

    @When("a senha {string}")
    public void aSenha(String string) throws Throwable {
        driver.findElement(By.id("senha")).sendKeys(string);
    }

    @When("seleciono entrar")
    public void selecionoEntrar() throws Throwable {
        driver.findElement(By.tagName("button")).click();
    }

    @Then("visualizo a pagina inicial")
    public void visualizoAPáginaInicial() throws Throwable {
        driver.findElement(By.xpath("//div[@class='alert alert-success'][contains(.,'Bem vindo, Felipe Amaral Araujo!')]"));
    }

    @When("seleciono Contas")
    public void selecionoContas() throws Throwable {
        driver.findElement(By.linkText("Contas")).click();
    }

    @When("seleciono Adicionar")
    public void selecionoAdicionar() throws Throwable {
        driver.findElement(By.xpath("//a[@href='/addConta'][contains(.,'Adicionar')]")).click();
    }

    @When("informo a conta {string}")
    public void informoAConta(String string) throws Throwable {
        driver.findElement(By.xpath("//input[@id='nome']")).sendKeys(string);
    }

    @When("seleciono Salvar")
    public void selecionoSalvar() throws Throwable {
        driver.findElement(By.xpath("//button[@type='submit'][contains(.,'Salvar')]")).click();
    }

    @When("a conta eh inserida com sucesso")
    public void aContaÉInseridaComSucesso() throws Throwable {
        driver.findElement(By.xpath("//div[@class='alert alert-success'][contains(.,'Conta adicionada com sucesso!')]"));
    }

    @Then("sou notificado que o nome da conta eh obrigatorio")
    public void souNotificadoQueONomeDaContaEhObrigatorio() {
        driver.findElement(By.xpath("//div[@class='alert alert-danger'][contains(.,'Informe o nome da conta')]"));
    }

    @Then("sou notificado que ja existe uma conta com esse nome")
    public void souNotificadoQueJaExisteUmaContaComEsseNome() {
        driver.findElement(By.xpath("//div[@class='alert alert-danger'][contains(.,'Já existe uma conta com esse nome!')]"));
    }

    @After
    public void fecharBrowser() {
        driver.quit();
    }

}
