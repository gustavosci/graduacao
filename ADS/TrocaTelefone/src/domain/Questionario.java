package domain;

import domain.celular.Celular;
import domain.comportamento.Comportamento;
import domain.expectativa.Expectativa;

public class Questionario {

    private Celular celular;

    private Comportamento comportamento;

    private Expectativa expectativa;

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

    public Expectativa getExpectativa() {
        return expectativa;
    }

    public void setExpectativa(final Expectativa expectativa) {
        this.expectativa = expectativa;
    }
}
