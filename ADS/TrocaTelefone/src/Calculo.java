import domain.Questionario;

public class Calculo {

    /* Gastos em mAh da bateria por tipo de uso */
    final double MAH_GASTO_TELA_AUDIOFONE = 6;
    final double MAH_GASTO_TELA = 4.8;
    final double MAH_GASTO_AUDIOFONE = 1.2;

    private final Questionario questionario;

    private Boolean processamento;

    private Boolean armazenamento;

    private Boolean bateria;

    public Calculo(final Questionario questionario) {
        this.questionario = questionario;
    }

    public void calcular() {
        bateria = calcularBateria();
        armazenamento = calcularArmazenamento();
        processamento = calcularProcessamento();

        // verificar X/3 caracteristicas atingidas e exibir resposta ao usuário
    }

    private boolean calcularBateria() {

        double totalGastoBateria =
            (questionario.getComportamento().getComportamentoBateria().getMinutosVideo() * MAH_GASTO_TELA_AUDIOFONE) +
                (questionario.getComportamento().getComportamentoBateria().getMinutosMusica() * MAH_GASTO_AUDIOFONE) +
                (questionario.getComportamento().getComportamentoBateria().getMinutosRedesSociais() * MAH_GASTO_TELA) +
                (questionario.getComportamento().getComportamentoBateria().getMinutosOutrasOperacoes()
                    * MAH_GASTO_TELA);

        double mahTotalEsperado =
            (totalGastoBateria * 60) * questionario.getExpectativa().getExpectativaBateria().getHorasDuracaoEsperada();

        return mahTotalEsperado > questionario.getCelular().getBateria();
    }

    private boolean calcularArmazenamento() {
        return false;
    }

    private boolean calcularProcessamento() {
        return false;
    }

}
