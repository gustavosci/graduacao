package domain.celular;

public class Celular {

    private Integer armazenamento;

    private Integer bateria;

    public Celular(final Integer armazenamento, final Integer bateria) {
        this.armazenamento = armazenamento;
        this.bateria = bateria;
    }

    public Integer getArmazenamento() {
        return armazenamento;
    }

    public void setArmazenamento(final Integer armazenamento) {
        this.armazenamento = armazenamento;
    }

    public Integer getBateria() {
        return bateria;
    }

    public void setBateria(final Integer bateria) {
        this.bateria = bateria;
    }
}
