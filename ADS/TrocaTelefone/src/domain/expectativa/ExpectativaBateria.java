package domain.expectativa;

public class ExpectativaBateria {

    private Integer horasDuracaoEsperada;

    public ExpectativaBateria(final Integer horasDuracaoEsperada) {
        this.horasDuracaoEsperada = horasDuracaoEsperada;
    }

    public Integer getHorasDuracaoEsperada() {
        return horasDuracaoEsperada;
    }

    public void setHorasDuracaoEsperada(final Integer horasDuracaoEsperada) {
        this.horasDuracaoEsperada = horasDuracaoEsperada;
    }
}
