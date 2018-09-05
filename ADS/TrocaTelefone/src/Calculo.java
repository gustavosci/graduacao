import domain.AvaliacaoTravamento;
import domain.Questionario;

public class Calculo {

    /* Gastos em mAh da bateria por tipo de uso */
    private final double MAH_GASTO_TELA_AUDIOFONE = 6;
    private final double MAH_GASTO_TELA = 4.8;
    private final double MAH_GASTO_AUDIOFONE = 1.2;

    /* Gastos em MBs da memória e armazenamento por tipo de uso */
    private final double MB_GASTO_FOTO = 3.86;
    private final double MB_GASTO_VIDEO = 1.98;
    private final double MB_GASTO_ARQUIVOS_GERAIS = 5;

    /* Fatores/peso para cálculo da satisfação do processamento */
    private final double PESO_TEMPO_BOOT = 3;
    private final double PESO_REGISTRO_FOTO = 5;
    private final double PESO_AVALIACAO_TRAVAMENTO = 4;

    private final Integer QTD_MIN_X_DIA = 1440;
    private final Integer QTD_MIN_X_HORA = 60;

    private final String POSITIVO = "POSITIVO";
    private final String NEGATIVO = "NEGATIVO";

    private final Integer TOTAL_PARAMETROS = 3;
    private final Integer MINIMO_PASSAR_APROVACAO = 2;

    private final Questionario questionario;

    private Boolean processamento;

    private Boolean armazenamento;

    private Boolean bateria;

    public Calculo(final Questionario questionario) {
        this.questionario = questionario;
    }

    public void calcular() {

        System.out.println("Apresentação de valores");

        bateria = calcularBateria();
        armazenamento = calcularArmazenamento();
        processamento = calcularProcessamento();

        final Integer totalPositivo = calculaTotalPositivos();

        System.out.println("\n\nResultado final: Seu celular atual passou " + totalPositivo + "/" + TOTAL_PARAMETROS);

        if (totalPositivo > MINIMO_PASSAR_APROVACAO) {
            System.out.println("\nPor este motivo, ainda não RECOMENDAMOS a troca do aparelho.");
        } else {
            System.out.println("\nPor este motivo, RECOMENDAMOS a troca do aparelho.");
        }
    }

    private Integer calculaTotalPositivos() {

        Integer totalPositivo = 0;

        if (bateria) {
            totalPositivo = totalPositivo + 1;
        }

        if (armazenamento) {
            totalPositivo = totalPositivo + 1;
        }

        if (processamento) {
            totalPositivo = totalPositivo + 1;
        }

        return totalPositivo;
    }

    private Boolean calcularBateria() {

        System.out.println("\nBateria\n");

        double totalGastoBateria =
            (questionario.getComportamento().getComportamentoBateria().getMinutosVideo() * MAH_GASTO_TELA_AUDIOFONE) +
                (questionario.getComportamento().getComportamentoBateria().getMinutosMusica() * MAH_GASTO_AUDIOFONE) +
                (questionario.getComportamento().getComportamentoBateria().getMinutosRedesSociais() * MAH_GASTO_TELA) +
                (questionario.getComportamento().getComportamentoBateria().getMinutosOutrasOperacoes()
                    * MAH_GASTO_TELA);

        final double mahTotalEsperado =
            (totalGastoBateria / QTD_MIN_X_DIA) * questionario.getExpectativa().getExpectativaBateria()
                .getMinutosDuracaoEsperada();

        final Boolean resultado = questionario.getCelular().getBateria() > mahTotalEsperado;

        System.out.println("Total de mAh gasto durante em 1 dia: " + totalGastoBateria);
        System.out.println("Total de mAh gasto durante em "
            + questionario.getExpectativa().getExpectativaBateria().getMinutosDuracaoEsperada() / QTD_MIN_X_HORA
            + " horas: " + mahTotalEsperado);
        System.out.println("Total de mAh em uma carga completa: " + questionario.getCelular().getBateria());
        System.out.println("Resultado: " + printResultado(resultado));

        return resultado;
    }

    private Boolean calcularArmazenamento() {

        System.out.println("\nArmazenamento\n");

        final double totalGastoComportamento =
            (questionario.getComportamento().getComportamentoArmazenamento().getFotosMes() * MB_GASTO_FOTO) +
                (questionario.getComportamento().getComportamentoArmazenamento().getMinutosVideosMes() * MB_GASTO_VIDEO)
                +
                (questionario.getComportamento().getComportamentoArmazenamento().getQuantidadeMediasDownload());

        final double mbsTotalEsperadoComportamento =
            (totalGastoComportamento * questionario.getExpectativa().getExpectativaArmazenamento()
                .getQtdMesesEsperado());

        final double mbsTotalEsperadoAceitacao =
            (questionario.getExpectativa().getExpectativaArmazenamento().getFotosSalvasEsperado() * MB_GASTO_FOTO) +
                (questionario.getExpectativa().getExpectativaArmazenamento().getVideosGravadosEsperado()
                    * MB_GASTO_VIDEO) +
                (questionario.getExpectativa().getExpectativaArmazenamento().getMediasBaixadasEsperado()
                    * MB_GASTO_ARQUIVOS_GERAIS);

        final Boolean resultado = questionario.getCelular().getArmazenamento() > mbsTotalEsperadoComportamento &&
            questionario.getCelular().getArmazenamento() > mbsTotalEsperadoAceitacao;

        System.out.println("Total de MBs consumidos durante 1 mês: " + totalGastoComportamento);
        System.out.println(
            "Total de MBs consumidos durante " + questionario.getExpectativa().getExpectativaArmazenamento()
                .getQtdMesesEsperado() + " meses: " + mbsTotalEsperadoComportamento);
        System.out.println("Total de MBs segundo parametros de aceitação: " + mbsTotalEsperadoAceitacao);
        System.out.println("Total de MBs no celular atual: " + questionario.getCelular().getArmazenamento());
        System.out.println("Resultado: " + printResultado(resultado));

        return resultado;
    }

    private Boolean calcularProcessamento() {

        System.out.println("\nProcessamento\n");

        final Integer expectativaCargaApp = questionario.getExpectativa().getExpectativaProcessamento()
            .getSegundosCargaApp();

        final AvaliacaoTravamento avaliacaoTravamento = AvaliacaoTravamento
            .toEnum(questionario.getExpectativa().getExpectativaProcessamento().getEstresseTravamentosApp());

        final Boolean satisfacaoBoot =
            (questionario.getComportamento().getComportamentoProcessamento().getSegundosBootSO() / PESO_TEMPO_BOOT)
                <= expectativaCargaApp;

        final Boolean satisfacaoRegistroFoto =
            (questionario.getComportamento().getComportamentoProcessamento().getSegundosRegistroFoto()
                * PESO_REGISTRO_FOTO) <= expectativaCargaApp;

        final Boolean satisfacaoCargaRedeSocial =
            questionario.getComportamento().getComportamentoProcessamento().getSegundosCargaRedeSocial()
                <= expectativaCargaApp;

        final Boolean satisfacaoTravamentos =
            questionario.getComportamento().getComportamentoProcessamento().getTravamentosMes() <= (
                avaliacaoTravamento.getAvaliacao() * PESO_AVALIACAO_TRAVAMENTO);

        final Boolean resultado =
            satisfacaoBoot && satisfacaoRegistroFoto && satisfacaoCargaRedeSocial && satisfacaoTravamentos;

        System.out.println("Satisfação BOOT SO: " + satisfacaoBoot);
        System.out.println("Satisfação Registro Foto: " + satisfacaoRegistroFoto);
        System.out.println("Satisfação Carga rede social: " + satisfacaoCargaRedeSocial);
        System.out.println("Satisfação Travamentos: " + satisfacaoTravamentos);
        System.out.println("Resultado: " + printResultado(resultado));

        return resultado;
    }

    private String printResultado(final Boolean resultado) {
        return resultado ? POSITIVO : NEGATIVO;
    }
}

