package domain.decisao;

public class DecisaoProcessamento {

    private Integer segundosCargaApp;

    private Integer estresseTravamentosApp;

    public DecisaoProcessamento(final Integer segundosCargaApp, final Integer estresseTravamentosApp) {
        this.segundosCargaApp = segundosCargaApp;
        this.estresseTravamentosApp = estresseTravamentosApp;
    }

    public Integer getSegundosCargaApp() {
        return segundosCargaApp;
    }

    public void setSegundosCargaApp(final Integer segundosCargaApp) {
        this.segundosCargaApp = segundosCargaApp;
    }

    public Integer getEstresseTravamentosApp() {
        return estresseTravamentosApp;
    }

    public void setEstresseTravamentosApp(final Integer estresseTravamentosApp) {
        this.estresseTravamentosApp = estresseTravamentosApp;
    }
}
