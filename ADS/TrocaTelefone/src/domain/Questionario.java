package domain;

import domain.celular.Celular;
import domain.comportamento.Comportamento;
import domain.decisao.Decisao;

public class Questionario {

    private Celular celular;

    private Comportamento comportamento;

    private Decisao decisao;

    public Questionario(final Celular celular, final Comportamento comportamento, final Decisao decisao) {
        this.celular = celular;
        this.comportamento = comportamento;
        this.decisao = decisao;
    }

    public Celular getCelular() {
        return celular;
    }

    public void setCelular(final Celular celular) {
        this.celular = celular;
    }

    public Comportamento getComportamento() {
        return comportamento;
    }

    public void setComportamento(final Comportamento comportamento) {
        this.comportamento = comportamento;
    }

    public Decisao getDecisao() {
        return decisao;
    }

    public void setDecisao(final Decisao decisao) {
        this.decisao = decisao;
    }
}
