package br.mg.paodequeijo.steps;

import br.mg.paodequeijo.entidades.Filme;
import br.mg.paodequeijo.entidades.NotaAluguel;
import br.mg.paodequeijo.entidades.TipoAluguel;
import br.mg.paodequeijo.servicos.AluguelService;
import br.mg.paodequeijo.utils.DateUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AlugarFilmeSteps {

    private Filme filme;
    private AluguelService aluguel = new AluguelService();
    private NotaAluguel nota;
    private String erro;
    private TipoAluguel tipoAluguel = TipoAluguel.COMUM;

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
            nota = aluguel.alugar(filme, tipoAluguel);
        } catch (RuntimeException e) {
            erro = e.getMessage();
        }
    }

    @Then("o preco do aluguel sera R$ {int}")
    public void oPrecoDoAluguelSeraR$(int int1) throws Throwable {
        Assert.assertEquals(int1, nota.getPreco());

    }

    @Then("o estoque do filme sera {int} unidade")
    public void oEstoqueDoFilmeSeraUnidade(int int1) throws Throwable {
        Assert.assertEquals(int1, filme.getEstoque());
    }

    @Then("nao sera possivel por falta de estoque")
    public void naoSeraPossivelPorFaltaDeEstoque() throws Throwable {
        Assert.assertEquals("Filme sem estoque", erro);
    }

    @Given("^o tipo de aluguel seja (.*)$")
    public void o_tipo_de_aluguel_seja_extendido(String tipo) throws Throwable {
        tipoAluguel = tipo.equals("semanal") ? TipoAluguel.SEMANAL : tipo.equals("extendido") ? TipoAluguel.EXTENDIDO : TipoAluguel.COMUM;
    }

    @Then("^a data de entrega sera em (\\d+) dias?$")
    public void a_data_de_entrega_sera_em_dias(int int1) throws Throwable {
        Date dataEsperada = DateUtils.obterDataComDiferencaDeDias(int1);
        Date dataReal = nota.getDataEntrega();

        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

        Assert.assertEquals(format.format(dataEsperada), format.format(dataReal));
    }

    @Then("a pontuacao recebida sera de {int} pontos")
    public void a_pontuacao_recebida_sera_de_pontos(int int1) throws Throwable {
        Assert.assertEquals(int1, nota.getPontuacao());
    }

    @And("o preco de aluguel seja R$ {int}")
    public void oPrecoDeAluguelSejaR$(int int1) {
        filme.setAluguel(int1);
    }
}
