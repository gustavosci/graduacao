package domain.comportamento;

public class ComportamentoProcessamento {

    private Integer segundosBootSO;

    private Integer segundosCargaRedeSocial;

    private Integer segundosRegistroFoto;

    private Integer travamentosMes;

    public ComportamentoProcessamento(final Integer segundosBootSO, final Integer segundosCargaRedeSocial,
        final Integer segundosRegistroFoto, final Integer travamentosMes) {

        this.segundosBootSO = segundosBootSO;
        this.segundosCargaRedeSocial = segundosCargaRedeSocial;
        this.segundosRegistroFoto = segundosRegistroFoto;
        this.travamentosMes = travamentosMes;
    }

    public Integer getSegundosBootSO() {
        return segundosBootSO;
    }

    public void setSegundosBootSO(final Integer segundosBootSO) {
        this.segundosBootSO = segundosBootSO;
    }

    public Integer getSegundosCargaRedeSocial() {
        return segundosCargaRedeSocial;
    }

    public void setSegundosCargaRedeSocial(final Integer segundosCargaRedeSocial) {
        this.segundosCargaRedeSocial = segundosCargaRedeSocial;
    }

    public Integer getSegundosRegistroFoto() {
        return segundosRegistroFoto;
    }

    public void setSegundosRegistroFoto(final Integer segundosRegistroFoto) {
        this.segundosRegistroFoto = segundosRegistroFoto;
    }

    public Integer getTravamentosMes() {
        return travamentosMes;
    }

    public void setTravamentosMes(final Integer travamentosMes) {
        this.travamentosMes = travamentosMes;
    }
}
