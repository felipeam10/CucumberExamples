package br.mg.paodequeijo.steps;

import br.mg.paodequeijo.entidades.Filme;
import br.mg.paodequeijo.entidades.NotaAluguel;
import br.mg.paodequeijo.servicos.AluguelService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Calendar;
import java.util.Date;

public class AlugarFilmeSteps {

    private Filme filme;
    private AluguelService aluguel = new AluguelService();
    private NotaAluguel nota;
    private String erro;

    @Given("um filme com estoque de {int} unidades")
    public void umFilmeComEstoqueDeUnidades(int int1) throws Throwable {
        filme = new Filme();
        filme.setEstoque(int1);
    }

    @Given("que o preco do aluguel seja R$ {int}")
    public void queOPrecoDoAluguelSejaR$(int int1) throws Throwable {
        filme.setAluguel(int1);
    }

    @When("alugar")
    public void alugar() throws Throwable {
        try {
            nota = aluguel.alugar(filme);
        } catch (RuntimeException e) {
            erro = e.getMessage();
        }
    }

    @Then("o preco do aluguel sera R$ {int}")
    public void oPrecoDoAluguelSeraR$(int int1) throws Throwable {
        Assert.assertEquals(int1, nota.getPreco());

    }

    @Then("a data entrega sera no dia seguinte")
    public void aDataEntregaSeraNoDiaSeguinte() throws Throwable {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);

        Date dataRetorno = nota.getDataEntyega();
        Calendar calRetorno = Calendar.getInstance();
        calRetorno.setTime(dataRetorno);

        Assert.assertEquals(calendar.get(Calendar.DAY_OF_MONTH), calRetorno.get(Calendar.DAY_OF_MONTH));
        Assert.assertEquals(calendar.get(Calendar.MONTH), calRetorno.get(Calendar.MONTH));
        Assert.assertEquals(calendar.get(Calendar.YEAR), calRetorno.get(Calendar.YEAR));
    }

    @Then("o estoque do filme sera {int} unidade")
    public void oEstoqueDoFilmeSeraUnidade(int int1) throws Throwable {
        Assert.assertEquals(int1, filme.getEstoque());
    }

    @Then("nao sera possivel por falta de estoque")
    public void naoSeraPossivelPorFaltaDeEstoque() throws Throwable {
        Assert.assertEquals("Filme sem estoque", erro);
    }
}
