package br.mg.paodequeijo.servicos;

import br.mg.paodequeijo.entidades.Filme;
import br.mg.paodequeijo.entidades.NotaAluguel;
import br.mg.paodequeijo.entidades.TipoAluguel;
import br.mg.paodequeijo.utils.DateUtils;

import java.util.Calendar;

public class AluguelService {

    public NotaAluguel alugar(Filme filme, TipoAluguel tipoAluguel) {

        if(filme.getEstoque() == 0)
            throw new RuntimeException("Filme sem estoque");

        NotaAluguel nota = new NotaAluguel();
        switch (tipoAluguel) {
            case COMUM:
                nota.setPreco(filme.getAluguel());
                nota.setDataEntrega(DateUtils.obterDataComDiferencaDeDias(1));
                nota.setPontuacao(1);
            break;

            case EXTENDIDO:
                nota.setPreco(filme.getAluguel() * 2);
                nota.setDataEntrega(DateUtils.obterDataComDiferencaDeDias(3));
                nota.setPontuacao(2);
            break;

            case SEMANAL:
                nota.setPreco(filme.getAluguel() * 3);
                nota.setDataEntrega(DateUtils.obterDataComDiferencaDeDias(7));
                nota.setPontuacao(3);
            break;
        }
        filme.setEstoque(filme.getEstoque() - 1);
        return nota;
    }
}
