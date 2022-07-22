package br.mg.paodequeijo.entidades;

import java.util.Date;

public class NotaAluguel {

    private int preco;
    private Date dataEntrega;

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    public Date getDataEntyega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date time) {
        dataEntrega = time;
    }
}
