import domain.Questionario;

public class Init {

    public static void main(String[] args) {

        Aceitacao aceitacao = new Aceitacao();
        Questionario questionario = aceitacao.aceitaQuestionario();

        Calculo calculo = new Calculo(questionario);
        calculo.calcular();
    }
}
