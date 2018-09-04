package domain.expectativa;

public class Expectativa {

    private ExpectativaBateria expectativaBateria;

    private ExpectativaArmazenamento expectativaArmazenamento;

    private ExpectativaProcessamento expectativaProcessamento;

    public ExpectativaBateria getExpectativaBateria() {
        return expectativaBateria;
    }

    public void setExpectativaBateria(final ExpectativaBateria expectativaBateria) {
        this.expectativaBateria = expectativaBateria;
    }

    public ExpectativaArmazenamento getExpectativaArmazenamento() {
        return expectativaArmazenamento;
    }

    public void setExpectativaArmazenamento(final ExpectativaArmazenamento expectativaArmazenamento) {
        this.expectativaArmazenamento = expectativaArmazenamento;
    }

    public ExpectativaProcessamento getExpectativaProcessamento() {
        return expectativaProcessamento;
    }

    public void setExpectativaProcessamento(final ExpectativaProcessamento expectativaProcessamento) {
        this.expectativaProcessamento = expectativaProcessamento;
    }
}
