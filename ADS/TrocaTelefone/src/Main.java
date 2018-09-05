import domain.Questionario;

public class Main {

    public static void main(String[] args) {

        Aceitacao aceitacao = new Aceitacao();
        Questionario questionario = aceitacao.aceitaQuestionario();

        Calculo calculo = new Calculo(questionario);
        calculo.calcular();
    }
}
