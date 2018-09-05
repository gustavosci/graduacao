import java.util.Scanner;

import domain.Questionario;
import domain.celular.Celular;
import domain.comportamento.Comportamento;
import domain.comportamento.ComportamentoArmazenamento;
import domain.comportamento.ComportamentoBateria;
import domain.comportamento.ComportamentoProcessamento;
import domain.expectativa.Expectativa;
import domain.expectativa.ExpectativaArmazenamento;
import domain.expectativa.ExpectativaBateria;
import domain.expectativa.ExpectativaProcessamento;

public class Aceitacao {

    private final Integer QTD_MBS_X_GB = 1024;
    private final Integer QTD_MIN_X_HORA = 60;

    private final Scanner scanner = new Scanner(System.in);

    public Questionario aceitaQuestionario(){

        Questionario questionario = new Questionario();

        questionario.setCelular(aceitaCelular());
        questionario.setComportamento(aceitaComportamento());
        questionario.setExpectativa(aceitaExpectativa());

        imprime("\nObrigado :) Agora vamos analisar seus dados...\n");

        return questionario;
    }

    private Celular aceitaCelular(){

        imprime("Olá, vamos conhecer um pouco seu celular");

        Celular celular = new Celular();

        imprime("Qual o armazenamento (GB) do aparelho?");
        celular.setArmazenamento(scanner.nextInt() * QTD_MBS_X_GB);

        imprime("Qual a capacidade da bateria (mAh) do aparelho?");
        celular.setBateria(scanner.nextInt());

        return celular;
    }

    private Comportamento aceitaComportamento(){

        imprime("\nAgora, vamos lhe perguntar sobre seu uso do celular\n");

        Comportamento comportamento = new Comportamento();

        comportamento.setComportamentoArmazenamento(aceitaComportamentoArmazenamento());
        comportamento.setComportamentoBateria(aceitaComportamentoBateria());
        comportamento.setComportamentoProcessamento(aceitaComportamentoProcessamento());

        return comportamento;
    }

    private ComportamentoArmazenamento aceitaComportamentoArmazenamento(){

        ComportamentoArmazenamento armazenamento = new ComportamentoArmazenamento();

        imprime("Quantas fotos por mês você tira com a camera do celular?");
        armazenamento.setFotosMes(scanner.nextInt());

        imprime("Quantos minutos por mês você filma com a camera do celular?");
        armazenamento.setMinutosVideosMes(scanner.nextInt());

        imprime("Qual a quantidade média em MB de arquivos (aúdio, PDFs, imagens, etc) que você baixa mensalmente?");
        armazenamento.setQuantidadeMediasDownload(scanner.nextInt());

        return armazenamento;

    }

    private ComportamentoBateria aceitaComportamentoBateria(){

        ComportamentoBateria bateria = new ComportamentoBateria();

        imprime("Quantos minutos por dia você passa olhando vídeos no celular? (tempo de tela ativa, com audio pelo fone)");
        bateria.setMinutosVideo(scanner.nextInt());

        imprime("Quantos minutos por dia você passa em redes sociais no celular? (tempo de tela ativa, sem audio pelo fone)");
        bateria.setMinutosRedesSociais(scanner.nextInt());

        imprime("Quantos minutos por dia você passa ouvindo músicas no celular? (tempo de tela inativa, com audio pelo fone)");
        bateria.setMinutosMusica(scanner.nextInt());

        imprime("Quantos minutos por dia você passa em outras operações usando o celular? ");
        bateria.setMinutosOutrasOperacoes(scanner.nextInt());

        return bateria;
    }

    private ComportamentoProcessamento aceitaComportamentoProcessamento(){

        ComportamentoProcessamento processamento = new ComportamentoProcessamento();

        imprime("Quanto tempo (segundos) seu celular demorar para ser inicializado?");
        processamento.setSegundosBootSO(scanner.nextInt());

        imprime("Qual o tempo (segundos) que leva para abrir e carregar os dados do app comum, como o Facebook? Considere uma conexão normal com a internet.");
        processamento.setSegundosCargaRedeSocial(scanner.nextInt());

        imprime("Ao tirar uma foto, qual o tempo (segundos) que o celular está pronto para uma nova foto?");
        processamento.setSegundosRegistroFoto(scanner.nextInt());

        imprime("Quantas vezes por mês, em média, um aplicativo trava e/ou para?");
        processamento.setTravamentosMes(scanner.nextInt());

        return processamento;
    }

    private Expectativa aceitaExpectativa(){

        imprime("\nÚltima parte... Vamos tentar entender suas expectativas :)\n");

        Expectativa expectativa = new Expectativa();

        expectativa.setExpectativaArmazenamento(aceitaExpectativaArmazenamento());
        expectativa.setExpectativaBateria(aceitaExpectativaBateria());
        expectativa.setExpectativaProcessamento(aceitaExpectativaProcessamento());

        return expectativa;
    }

    private ExpectativaArmazenamento aceitaExpectativaArmazenamento(){

        ExpectativaArmazenamento armazenamento = new ExpectativaArmazenamento();

        imprime("Quantos meses você aceita ficar com o celular sem precisar ficar apagando arquivos por falta de memória?");
        armazenamento.setQtdMesesEsperado(scanner.nextInt());
        
        imprime("Quantas fotos o celular deve aceitar sem ser necessário deletar arquivos para liberar espaço?");
        armazenamento.setFotosSalvasEsperado(scanner.nextInt());

        imprime("Quantos minutos de vídeos o celular deve aceitar sem ser necessário deletar arquivos para liberar espaço?");
        armazenamento.setVideosGravadosEsperado(scanner.nextInt());

        imprime("Imagine um arquivo que ocupe 5MB no dispositivo. Quantos desse arquivo o celular precisa comportar?");
        armazenamento.setMediasBaixadasEsperado(scanner.nextInt());

        return armazenamento;
    }

    private ExpectativaBateria aceitaExpectativaBateria(){

        ExpectativaBateria bateria = new ExpectativaBateria();

        imprime("Quantas horas a bateria do celular deve durar com uma carga completa?");
        bateria.setMinutosDuracaoEsperada(scanner.nextInt() * QTD_MIN_X_HORA);

        return bateria;
    }

    private ExpectativaProcessamento aceitaExpectativaProcessamento(){

        ExpectativaProcessamento processamento = new ExpectativaProcessamento();

        imprime("Quantos segundos são aceitáveis para um app carregar seus dados de primeira página?");
        processamento.setSegundosCargaApp(scanner.nextInt());

        imprime("De 1 a 5, quanto lhe estressa o fato de uma aplicação parar de responder?");
        processamento.setEstresseTravamentosApp(scanner.nextInt());

        return processamento;
    }

    private void imprime(final String text){
        System.out.println(text);
    }
}
