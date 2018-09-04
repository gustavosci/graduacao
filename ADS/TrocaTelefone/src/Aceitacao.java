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

    public Questionario aceitaQuestionario(){

        Questionario questionario = new Questionario();

        questionario.setCelular(aceitaCelular());
        questionario.setComportamento(aceitaComportamento());
        questionario.setExpectativa(aceitaExpectativa());

        return questionario;
    }

    private Celular aceitaCelular(){

        Celular celular = new Celular();

        return celular;
    }

    private Comportamento aceitaComportamento(){

        Comportamento comportamento = new Comportamento();

        comportamento.setComportamentoArmazenamento(aceitaComportamentoArmazenamento());
        comportamento.setComportamentoBateria(aceitaComportamentoBateria());
        comportamento.setComportamentoProcessamento(aceitaComportamentoProcessamento());

        return comportamento;
    }

    private ComportamentoArmazenamento aceitaComportamentoArmazenamento(){
        return null;
    }

    private ComportamentoBateria aceitaComportamentoBateria(){
        return null;
    }

    private ComportamentoProcessamento aceitaComportamentoProcessamento(){
        return null;
    }

    private Expectativa aceitaExpectativa(){

        Expectativa expectativa = new Expectativa();

        expectativa.setExpectativaArmazenamento(aceitaExpectativaArmazenamento());
        expectativa.setExpectativaBateria(aceitaExpectativaBateria());
        expectativa.setExpectativaProcessamento(aceitaExpectativaProcessamento());

        return expectativa;
    }

    private ExpectativaArmazenamento aceitaExpectativaArmazenamento(){
        return null;
    }

    private ExpectativaBateria aceitaExpectativaBateria(){
        return null;
    }

    private ExpectativaProcessamento aceitaExpectativaProcessamento(){
        return null;
    }

}
