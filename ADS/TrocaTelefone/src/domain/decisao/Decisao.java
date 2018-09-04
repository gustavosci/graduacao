package domain.decisao;

public class Decisao {

    private DecisaoBateria decisaoBateria;

    private DecisaoArmazenamento decisaoArmazenamento;

    private DecisaoProcessamento decisaoProcessamento;

    public Decisao(final DecisaoBateria decisaoBateria, final DecisaoArmazenamento decisaoArmazenamento,
        final DecisaoProcessamento decisaoProcessamento) {
        this.decisaoBateria = decisaoBateria;
        this.decisaoArmazenamento = decisaoArmazenamento;
        this.decisaoProcessamento = decisaoProcessamento;
    }

    public DecisaoBateria getDecisaoBateria() {
        return decisaoBateria;
    }

    public void setDecisaoBateria(final DecisaoBateria decisaoBateria) {
        this.decisaoBateria = decisaoBateria;
    }

    public DecisaoArmazenamento getDecisaoArmazenamento() {
        return decisaoArmazenamento;
    }

    public void setDecisaoArmazenamento(final DecisaoArmazenamento decisaoArmazenamento) {
        this.decisaoArmazenamento = decisaoArmazenamento;
    }

    public DecisaoProcessamento getDecisaoProcessamento() {
        return decisaoProcessamento;
    }

    public void setDecisaoProcessamento(final DecisaoProcessamento decisaoProcessamento) {
        this.decisaoProcessamento = decisaoProcessamento;
    }
}
