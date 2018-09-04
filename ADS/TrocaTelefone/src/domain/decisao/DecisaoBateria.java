package domain.decisao;

public class DecisaoBateria {

    private Integer horasDuracaoEsperada;

    public DecisaoBateria(final Integer horasDuracaoEsperada) {
        this.horasDuracaoEsperada = horasDuracaoEsperada;
    }

    public Integer getHorasDuracaoEsperada() {
        return horasDuracaoEsperada;
    }

    public void setHorasDuracaoEsperada(final Integer horasDuracaoEsperada) {
        this.horasDuracaoEsperada = horasDuracaoEsperada;
    }
}
