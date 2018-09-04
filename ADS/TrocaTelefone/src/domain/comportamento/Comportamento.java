package domain.comportamento;

public class Comportamento {

    private ComportamentoBateria comportamentoBateria;

    private ComportamentoArmazenamento comportamentoArmazenamento;

    private ComportamentoProcessamento comportamentoProcessamento;

    public ComportamentoBateria getComportamentoBateria() {
        return comportamentoBateria;
    }

    public void setComportamentoBateria(final ComportamentoBateria comportamentoBateria) {
        this.comportamentoBateria = comportamentoBateria;
    }

    public ComportamentoArmazenamento getComportamentoArmazenamento() {
        return comportamentoArmazenamento;
    }

    public void setComportamentoArmazenamento(final ComportamentoArmazenamento comportamentoArmazenamento) {
        this.comportamentoArmazenamento = comportamentoArmazenamento;
    }

    public ComportamentoProcessamento getComportamentoProcessamento() {
        return comportamentoProcessamento;
    }

    public void setComportamentoProcessamento(final ComportamentoProcessamento comportamentoProcessamento) {
        this.comportamentoProcessamento = comportamentoProcessamento;
    }
}
