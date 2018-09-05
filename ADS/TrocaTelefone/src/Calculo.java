import domain.Questionario;

public class Calculo {

    /* Gastos em mAh da bateria por tipo de uso */
    final double MAH_GASTO_TELA_AUDIOFONE = 6;
    final double MAH_GASTO_TELA = 4.8;
    final double MAH_GASTO_AUDIOFONE = 1.2;

    /* Gastos em MBs da memória e armazenamento por tipo de uso */
    final double MB_GASTO_FOTO = 3.86;
    final double MB_GASTO_VIDEO = 1.98;
    final double MB_GASTO_ARQUIVOS_GERAIS = 5;
    
    private final Integer QTD_MIN_X_DIA = 1440;
    private final Integer QTD_MIN_X_HORA = 60;
    private final String POSITIVO = "POSITIVO";
    private final String NEGATIVO = "NEGATIVO";

    private final Questionario questionario;

    private Boolean processamento;

    private Boolean armazenamento;

    private Boolean bateria;

    public Calculo(final Questionario questionario) {
        this.questionario = questionario;
    }
    
    private final String printResultado(boolean resultado) {
    	return resultado ? POSITIVO : NEGATIVO;
    }

    public void calcular() {
    	System.out.println("Apresentação de valores");
        bateria = calcularBateria();
        armazenamento = calcularArmazenamento();
        processamento = calcularProcessamento();

        // verificar X/3 caracteristicas atingidas e exibir resposta ao usuÃ¡rio
    }
    
    private boolean calcularBateria() {

    	System.out.println("Bateria");
    	
    	double totalGastoBateria =
        		(questionario.getComportamento().getComportamentoBateria().getMinutosVideo() * MAH_GASTO_TELA_AUDIOFONE) +
                (questionario.getComportamento().getComportamentoBateria().getMinutosMusica() * MAH_GASTO_AUDIOFONE) +
                (questionario.getComportamento().getComportamentoBateria().getMinutosRedesSociais() * MAH_GASTO_TELA) +
                (questionario.getComportamento().getComportamentoBateria().getMinutosOutrasOperacoes() * MAH_GASTO_TELA);

        double mahTotalEsperado =
            (totalGastoBateria / QTD_MIN_X_DIA)  * questionario.getExpectativa().getExpectativaBateria().getMinutosDuracaoEsperada();
        
        boolean resultado = questionario.getCelular().getBateria() > mahTotalEsperado;

        System.out.println("Total de mAh gasto durante em 1 dia: " + totalGastoBateria);
        System.out.println("Total de mAh gasto durante em "+ questionario.getExpectativa().getExpectativaBateria().getMinutosDuracaoEsperada() / QTD_MIN_X_HORA +" horas: "+ mahTotalEsperado);
        System.out.println("Total de mAh em uma carga completa: " + questionario.getCelular().getBateria());
        System.out.println("Resultado: " + printResultado(resultado));
        
        return resultado;
    }

    private boolean calcularArmazenamento() {

    	System.out.println("Armazenamento");

        double totalGastoComportamento =
        		(questionario.getComportamento().getComportamentoArmazenamento().getFotosMes() * MB_GASTO_FOTO) +
                (questionario.getComportamento().getComportamentoArmazenamento().getMinutosVideosMes() * MB_GASTO_VIDEO) +
                (questionario.getComportamento().getComportamentoArmazenamento().getQuantidadeMediasDownload());

        double mbsTotalEsperadoComportamento =
                (totalGastoComportamento * questionario.getExpectativa().getExpectativaArmazenamento().getQtdMesesEsperado());
        
        double mbsTotalEsperadoAceitacao =
        		(questionario.getExpectativa().getExpectativaArmazenamento().getFotosSalvasEsperado() * MB_GASTO_FOTO) +
                (questionario.getExpectativa().getExpectativaArmazenamento().getVideosGravadosEsperado() * MB_GASTO_VIDEO) +
                (questionario.getExpectativa().getExpectativaArmazenamento().getMediasBaixadasEsperado() * MB_GASTO_ARQUIVOS_GERAIS);
        
        boolean resultado = questionario.getCelular().getArmazenamento() > mbsTotalEsperadoComportamento && 
        					questionario.getCelular().getArmazenamento() > mbsTotalEsperadoAceitacao;

        System.out.println("Total de MBs consumidos durante 1 mes: " + totalGastoComportamento);
        System.out.println("Total de MBs consumidos durante "+ questionario.getExpectativa().getExpectativaArmazenamento().getQtdMesesEsperado() +" meses: "+ mbsTotalEsperadoComportamento);
        System.out.println("Total de MBs segundo parametros de aceitação: " + mbsTotalEsperadoAceitacao);
        System.out.println("Total de MBs no celular atual: " + questionario.getCelular().getArmazenamento());
        System.out.println("Resultado: " + printResultado(resultado));
        
        return resultado;
    }

    private boolean calcularProcessamento() {
        return false;
    }

}
