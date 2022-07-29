package br.mg.paodequeijo.servicos;

import br.mg.paodequeijo.entidades.Filme;
import br.mg.paodequeijo.entidades.NotaAluguel;
import br.mg.paodequeijo.utils.DateUtils;

import java.util.Calendar;

public class AluguelService {

    public NotaAluguel alugar(Filme filme, String tipoAluguel) {

        if(filme.getEstoque() == 0)
            throw new RuntimeException("Filme sem estoque");

        NotaAluguel nota = new NotaAluguel();
        if("extendido".equals(tipoAluguel)){
            nota.setPreco(filme.getAluguel() * 2);
            nota.setDataEntrega(DateUtils.obterDataComDiferencaDeDias(3));
            nota.setPontuacao(2);
        } else {
            nota.setPreco(filme.getAluguel());
            nota.setDataEntrega(DateUtils.obterDataComDiferencaDeDias(1));
            nota.setPontuacao(1);
        }
        filme.setEstoque(filme.getEstoque() - 1);
        return nota;
    }
}
